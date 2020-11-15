package datamodels.dtos;

import java.util.List;
import java.util.Objects;

import datamodels.interfaces.Post;
import datamodels.interfaces.User;


public class UserDTO implements User {
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String location;
	
	private List<String> hobbies;
	
	private List<User> friends;
	
	private List<Post> posts;
	
	public UserDTO(String firstName, String lastName, String email, String location, List<String> hobbies) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.location = location;
		this.hobbies = hobbies;
	}

	@Override
	public String getFirstName() {
		return this.firstName;
	}

	@Override
	public String getLastName() {
		return this.lastName;
	}

	@Override
	public String getEmail() {
		return this.email;
	}

	@Override
	public String getLocation() {
		return this.location;
	}

	@Override
	public List<String> getHobbies() {
		return this.hobbies;
	}

	@Override
	public List<User> getFriends() {
		return this.friends;
	}

	@Override
	public List<Post> getPosts() {
		return this.posts;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UserDTO userDTO = (UserDTO) o;
		return Objects.equals(firstName, userDTO.firstName) &&
				Objects.equals(lastName, userDTO.lastName) &&
				Objects.equals(email, userDTO.email) &&
				Objects.equals(location, userDTO.location) &&
				Objects.equals(hobbies, userDTO.hobbies) &&
				Objects.equals(friends, userDTO.friends) &&
				Objects.equals(posts, userDTO.posts);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, email, location, hobbies, friends, posts);
	}
}
