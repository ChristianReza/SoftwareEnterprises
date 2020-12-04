package main.datamodels.interfaces;

import java.util.List;

public interface User {
	
	String getFirstName();
	String getLastName();
	String getEmail();
	String getLocation();
	List<String> getHobbies();
	List<User> getFriends();
	List<Post> getPosts();
	String getPassword();

}
