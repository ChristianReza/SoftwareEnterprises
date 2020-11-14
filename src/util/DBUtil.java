package util;

import datamodels.dtos.PostDTO;
import datamodels.dtos.UserDTO;
import datamodels.entities.BlacklistEntity;
import datamodels.entities.PostEntity;
import datamodels.entities.UserEntity;
import datamodels.interfaces.Post;
import datamodels.interfaces.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	 * @param keyword - user ID to find friends of (may change this, but same concept)
	 * @return - list of all users
	 */
	public static List<User> listUsersFriends(String keyword) {
		List<User> resultList = new ArrayList<>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> friends =  session.createQuery("FROM UserEntity").list();
			for (Object friend : friends) {
				UserEntity user = (UserEntity) friend;
				if (user.getId().toString().equals(keyword)) {
					resultList.addAll(user.getFriends());
				}
			}
			tx.commit();
		} catch (HibernateException e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return resultList;
	}

	/**
	 * Search user entities by hobbies
	 *
	 * @param keyword - hobby to search by
	 * @return users with that hobby
	 */
	public static List<UserEntity> findByHobby(String keyword) {
		List<UserEntity> resultList = new ArrayList<>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> users = session.createQuery("FROM UserEntity").list();
			for (Iterator<?> iterator = users.iterator(); iterator.hasNext();) {
				UserEntity user = (UserEntity) iterator.next();
				if (user.getHobbies().contains(keyword)) {
					resultList.add(user);
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
	 * Find a user's posts.
	 * Once we have posts, we don't need to find comments in a separate method.
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
			List<?> friends =  session.createQuery("FROM UserEntity").list();
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
			List<?> sites =  session.createQuery("FROM BlacklistEntity").list();
			for (Object site : sites) {
				BlacklistEntity web = (BlacklistEntity) site;
				if (web.getReportedSite().contains(keyword)) {
					alreadyReported = true;
					web.bumpReports();
				}
			}
			if(!alreadyReported) { // if the site is not in the blacklist, add it with 1 report
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
			session.save(
					new UserEntity(user));
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
	public static void createPost(PostDTO post) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(
					new PostEntity(post));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}


}
