package main.datamodels.dtos;

import java.util.Date;
import java.util.Objects;

import main.datamodels.interfaces.Comment;
import main.datamodels.interfaces.User;

public class CommentDTO implements Comment {
	
	private User user;
	
	private String comment;
	
	private Date date;
	
	public CommentDTO(UserDTO user, String comment, Date date) {
		super();
		this.user = user;
		this.comment = comment;
		this.date = date;
	}

	public CommentDTO() {
		// Default Constructor
	}

	@Override
	public User getUser() {
		return this.user;
	}

	@Override
	public String getComment() {
		return this.comment;
	}

	@Override
	public Date getDate() {
		return this.date;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CommentDTO that = (CommentDTO) o;
		return Objects.equals(user, that.user) &&
				Objects.equals(comment, that.comment) &&
				Objects.equals(date, that.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(user, comment, date);
	}
}
