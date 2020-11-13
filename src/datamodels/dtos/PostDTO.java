package datamodels.dtos;

import java.util.Date;
import java.util.List;

import datamodels.interfaces.Comment;
import datamodels.interfaces.Post;

public class PostDTO implements Post {
	
	private String subject;
	
	private String body;
	
	private List<Comment> comments;
	
	private Date date;

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostDTO other = (PostDTO) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}
	
	

}
