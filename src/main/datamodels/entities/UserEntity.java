package main.datamodels.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import main.datamodels.dtos.UserDTO;
import main.datamodels.interfaces.Post;
import main.datamodels.interfaces.User;

@Entity
@Table(name = "USER")
public class UserEntity implements User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "PW")
	private String password;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "LOC")
	private String location;

	@Column(name = "HOBBIES")
	@ElementCollection
	private List<String> hobbies;

	@Column(name = "FRIENDS")
	@OneToMany(targetEntity = UserEntity.class)
	private List<User> friends;

	@Column(name = "POSTS")
	@OneToMany(targetEntity = PostEntity.class)
	private List<Post> posts;

	public UserEntity(UserDTO user) {
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.location = user.getLocation();
		this.hobbies = user.getHobbies();
		this.friends = user.getFriends();
		this.posts = user.getPosts();
		this.password = user.getPassword();
	}

	public Integer getId() {
		return id;
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
	
	@Override
	public String getPassword() {
		return this.password;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UserEntity that = (UserEntity) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(firstName, that.firstName) &&
				Objects.equals(lastName, that.lastName) &&
				Objects.equals(email, that.email) &&
				Objects.equals(location, that.location) &&
				Objects.equals(hobbies, that.hobbies) &&
				Objects.equals(friends, that.friends) &&
				Objects.equals(posts, that.posts) &&
				Objects.equals(password, that.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, email, location, hobbies, friends, posts, password);
	}

}
