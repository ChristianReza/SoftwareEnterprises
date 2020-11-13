package datamodels.interfaces;

import java.util.Date;
import java.util.List;

public interface Post {
	
	String getSubject();
	String getBody();
	List<Comment> getComments();
	Date getDate();

}
