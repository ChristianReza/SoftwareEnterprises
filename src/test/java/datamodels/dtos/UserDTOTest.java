package test.java.datamodels.dtos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.datamodels.dtos.UserDTO;
import main.datamodels.interfaces.Post;
import main.datamodels.interfaces.User;

class UserDTOTest {
	
	private final String FIRST_NAME = "first";
	private final String LAST_NAME = "last";
	private final String EMAIL = "something@hotmail.com";
	private final String LOCATION = "EARTH";
	private final List<String> HOBBIES = new ArrayList<String>();
	private final List<User> FRIENDS = new ArrayList<User>();
	private final List<Post> POSTS = new ArrayList<Post>();
	private final String PASSWORD = "password";

	
	@Test
	void testConstructor() {
		UserDTO user = new UserDTO(FIRST_NAME, LAST_NAME, EMAIL, LOCATION, HOBBIES, PASSWORD);
		
		assertEquals(user.getFirstName(), FIRST_NAME);
		assertEquals(user.getLastName(), LAST_NAME);
		assertEquals(user.getEmail(), EMAIL);
		assertEquals(user.getLocation(), LOCATION);
		assertEquals(user.getHobbies(), HOBBIES);
		assertEquals(user.getPassword(), PASSWORD);
	}
	
	@Test
	void testGetterSetter() {
		UserDTO user = new UserDTO();
		
		user.setFirstName(FIRST_NAME);
		user.setLastName(LAST_NAME);
		user.setEmail(EMAIL);
		user.setLocation(LOCATION);
		user.setHobbies(HOBBIES);
		user.setFriends(FRIENDS);
		user.setPosts(POSTS);
		user.setPassword(PASSWORD);
		
		assertEquals(user.getFirstName(), FIRST_NAME);
		assertEquals(user.getLastName(), LAST_NAME);
		assertEquals(user.getEmail(), EMAIL);
		assertEquals(user.getLocation(), LOCATION);
		assertEquals(user.getHobbies(), HOBBIES);
		assertEquals(user.getFriends(), FRIENDS);
		assertEquals(user.getPosts(), POSTS);
		assertEquals(user.getPassword(), PASSWORD);
	}
	
	@Test
	void testEquals() {
		UserDTO user = new UserDTO();
		
		user.setFirstName(FIRST_NAME);
		user.setLastName(LAST_NAME);
		user.setEmail(EMAIL);
		user.setLocation(LOCATION);
		user.setHobbies(HOBBIES);
		user.setFriends(FRIENDS);
		user.setPosts(POSTS);
		user.setPassword(PASSWORD);
		
		UserDTO user2 = new UserDTO();
		
		user2.setFirstName(FIRST_NAME);
		user2.setLastName(LAST_NAME);
		user2.setEmail(EMAIL);
		user2.setLocation(LOCATION);
		user2.setHobbies(HOBBIES);
		user2.setFriends(FRIENDS);
		user2.setPosts(POSTS);
		user2.setPassword(PASSWORD);
		
		assertTrue(user.equals(user2));
	}


}
