package main.datamodels.entities;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import main.datamodels.dtos.PostDTO;
import main.datamodels.interfaces.Comment;
import main.datamodels.interfaces.Post;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "POSTS")
public class PostEntity implements Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "SUBJ")
	private String subject;

	@Column(name = "BODY")
	private String body;

	@Column(name = "COMMENTS")
	@OneToMany(targetEntity = CommentEntity.class)
	private List<Comment> comments;

	@Column(name = "DATE")
	private Date date;

    public PostEntity(PostDTO post) {
    	this.subject = post.getSubject();
    	this.body = post.getBody();
    	this.comments = post.getComments();
    	this.date = post.getDate();
    }

	public Integer getId() {
		return id;
	}

	@Override
	public String getSubject() {
		return this.subject;
	}

	@Override
	public String getBody() {
		return this.body;
	}

	@Override
	public List<Comment> getComments() {
		return this.comments;
	}

	@Override
	public Date getDate() {
		return this.date;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PostEntity that = (PostEntity) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(subject, that.subject) &&
				Objects.equals(body, that.body) &&
				Objects.equals(comments, that.comments) &&
				Objects.equals(date, that.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, subject, body, comments, date);
	}
}
