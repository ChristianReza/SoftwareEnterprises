package datamodels.dtos;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import datamodels.interfaces.Comment;
import datamodels.interfaces.Post;

public class PostDTO implements Post {
	
	private String subject;
	
	private String body;
	
	private List<Comment> comments;
	
	private Date date;

	public PostDTO(String subject, String body, Date date) {
		this.subject = subject;
		this.body = body;
		this.date = date;
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
		PostDTO postDTO = (PostDTO) o;
		return Objects.equals(subject, postDTO.subject) &&
				Objects.equals(body, postDTO.body) &&
				Objects.equals(comments, postDTO.comments) &&
				Objects.equals(date, postDTO.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(subject, body, comments, date);
	}
}
