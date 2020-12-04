package main.datamodels.interfaces;

import java.util.Date;

public interface Comment {
	
	User getUser();
	String getComment();
	Date getDate();

}
