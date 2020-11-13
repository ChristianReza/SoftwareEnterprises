package datamodels.interfaces;

import java.util.Date;

import datamodels.interfaces.User;

public interface Comment {
	
	User getUser();
	String getComment();
	Date getDate();

}
