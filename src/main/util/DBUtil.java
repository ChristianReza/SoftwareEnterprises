package main.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import main.datamodels.dtos.CommentDTO;
import main.datamodels.dtos.PostDTO;
import main.datamodels.dtos.UserDTO;
import main.datamodels.entities.BlacklistEntity;
import main.datamodels.entities.CommentEntity;
import main.datamodels.entities.PostEntity;
import main.datamodels.entities.UserEntity;
import main.datamodels.interfaces.Post;
import main.datamodels.interfaces.User;

/**
 * @since JavaSE-1.8
 */
public class DBUtil {
	static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory != null) {
			return sessionFactory;
		}
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	/**
	 * find all friends of a user
	 *
	 * @param keyword - user ID to find friends of (may change this, but same
	 *                concept)
	 * @return - list of all users
	 */
	public static List<User> listUsersFriends(String keyword) {
		List<User> resultList = new ArrayList<>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> friends = session.createQuery("FROM UserEntity").list();
			for (Object friend : friends) {
				UserEntity user = (UserEntity) friend;
				if (user.getId().toString().equals(keyword)) {
					resultList.addAll(user.getFriends());
				}
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return resultList;
	}

	/**
	 * Search user entities search criteria (first name/last name/hobbies/location)
	 *
	 * @param user - UserDTO to search for similarities against users in DB
	 * @return users with that that match parts of the query
	 */
	public static List<User> findUsers(UserDTO queryUser) {
		List<User> resultList = new ArrayList<>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> users = session.createQuery("FROM UserEntity").list();
			for (Iterator<?> iterator = users.iterator(); iterator.hasNext();) {
				UserEntity user = (UserEntity) iterator.next();
				List<String> hobbies = 
						queryUser.getHobbies().stream().map(String::trim).collect(Collectors.toList());

				if ((!user.getFirstName().isEmpty() && !user.getLastName().isEmpty())
						&& user.getFirstName().equalsIgnoreCase(queryUser.getFirstName())
						|| user.getLastName().equalsIgnoreCase(queryUser.getLastName())) {
					if (!resultList.contains(user))
						resultList.add(user);
				}
				for (String hobby : hobbies) {
					if (user.getHobbies().contains(hobby.trim())) {
						if (!resultList.contains(user))
							resultList.add(user);
					}
				}
				if (!user.getLocation().isEmpty()
						&& user.getLocation().equalsIgnoreCase(queryUser.getLocation())) {
					if (!resultList.contains(user))
						resultList.add(user);
				}
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}

	public static boolean loginUser(UserDTO loginRequest) {
		boolean loggedIn = false;

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> users = session.createQuery("FROM UserEntity").list();
			for (Iterator<?> iterator = users.iterator(); iterator.hasNext();) {
				UserEntity user = (UserEntity) iterator.next();
				if (user.getEmail().equals(loginRequest.getEmail())
						&& user.getPassword().equals(loginRequest.getPassword())) {
					loggedIn = true;
					break;
				}
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return loggedIn;
	}

	/**
	 * Find a user's posts. Once we have posts, we don't need to find comments in a
	 * separate method.
	 *
	 * @param keyword user ID to find posts by
	 * @return - list of user's posts
	 */
	public static List<Post> findPosts(String keyword) {
		List<Post> resultList = new ArrayList<>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> friends = session.createQuery("FROM UserEntity").list();
			for (Object friend : friends) {
				UserEntity user = (UserEntity) friend;
				if (user.getId().toString().equals(keyword)) {
					resultList.addAll(user.getPosts());
				}
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}

	/**
	 * Reported site added to blacklist with a report
	 *
	 * @param keyword - Site that is being reported.
	 */
	public static void blacklistSite(String keyword) {
		boolean alreadyReported = false;
		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> sites = session.createQuery("FROM BlacklistEntity").list();
			for (Object site : sites) {
				BlacklistEntity web = (BlacklistEntity) site;
				if (web.getReportedSite().contains(keyword)) {
					alreadyReported = true;
					web.bumpReports();
				}
			}
			if (!alreadyReported) { // if the site is not in the blacklist, add it with 1 report
				session.save(new BlacklistEntity(keyword));
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/*
	 * CREATE METHODS
	 */

	/**
	 * save user to DB
	 *
	 * @param user - user to create
	 */
	public static void createUser(UserDTO user) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(new UserEntity(user));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/**
	 * save a post to the DB
	 *
	 * @param post - post to save
	 */
	public static void createPost(PostDTO post, UserDTO postUser) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		UserEntity postingUser = null;
		try {
			tx = session.beginTransaction();

			// Create a user that will post all comments, since we don't have
			// an LDAP or anything like that for user token/auth to tell
			// who is posting the comments
			List<?> users = session.createQuery("FROM UserEntity").list();
			boolean demoUser = false;
			for (Object friend : users) {
				UserEntity user = (UserEntity) friend;
				UserEntity convertedDTO = convertDTO(postUser);
				if (user.simpleEquals(convertedDTO)) {
					postingUser = user;
					demoUser = true;
					break;
				}
			}
			if (!demoUser) {
				createUser(postUser);
				for (Object friend : users) {
					UserEntity user = (UserEntity) friend;
					if (user.equals(convertDTO(postUser))) {
						postingUser = user;
					}
				}
			}
			session.save(new PostEntity(post));
			
			List<?> posts = session.createQuery("FROM PostEntity").list();
			PostEntity savedPost = null;
			for (Object temp : posts) {
				PostEntity pst = (PostEntity) temp;
				PostEntity convertedDTO = new PostEntity(post);
				if (pst.simpleEquals(convertedDTO)) {
					savedPost = pst;
					break;
				}
			}

			List<Post> usersPosts = (postingUser.getPosts() != null ? postingUser.getPosts() : new ArrayList<Post>());
			usersPosts.add(savedPost);
			session.merge(postingUser);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	/**
	 * save a comment to the DB
	 *
	 * @param comment - comment to save
	 */
	public static void createComment(CommentDTO comment) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			// Create a user that will post all comments, since we don't have 
			// an LDAP or anything like that for user token/auth to tell 
			// who is posting the comments
			List<?> users = session.createQuery("FROM UserEntity").list();
			boolean commentUserExist = false;
			for (Object friend : users) {
				UserEntity user = (UserEntity) friend;
				if (user.equals(comment.getUser()) && !commentUserExist) {
					createUser((UserDTO) comment.getUser());
					commentUserExist = true;
				}
			}
			
			
			session.save(new CommentEntity(comment));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	
	/*
	 * CONVERT METHODS
	 */
	
	public static UserEntity convertDTO(UserDTO userDTO) { 
		return new UserEntity(userDTO);
	}
	

}
