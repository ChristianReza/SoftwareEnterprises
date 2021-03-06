package main.datamodels.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import main.datamodels.dtos.CommentDTO;
import main.datamodels.interfaces.Comment;
import main.datamodels.interfaces.User;

@Entity
@Table(name = "COMMENTS")
public class CommentEntity implements Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@OneToOne
	private UserEntity user;
	
	@Column(name = "COMMENT")
	private String comment;
	
	@Column(name = "DATE")
	private Date date;
	
	public CommentEntity(CommentDTO comment) {
		super();
		this.user = (UserEntity) comment.getUser();
		this.comment = comment.getComment();
		this.date = comment.getDate();
	}

	public CommentEntity(Integer id, UserEntity user, String comment, Date date) {
		super();
		this.id = id;
		this.user = user;
		this.comment = comment;
		this.date = date;
	}

	public CommentEntity() {
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

	public void setUser(UserEntity user) {
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
		CommentEntity that = (CommentEntity) o;
		return Objects.equals(user, that.user) &&
				Objects.equals(comment, that.comment) &&
				Objects.equals(date, that.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(user, comment, date);
	}
}
