package test.java.datamodels.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import main.datamodels.entities.CommentEntity;
import main.datamodels.entities.UserEntity;

class CommentEntityTest {
	
	private final UserEntity MOCK_USER = new UserEntity();
	private final String COMMENT = "That's awesome!";
	
	SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
	Date date = new Date(System.currentTimeMillis());
	
	private final Date DATE = date;

	@Test
	void testGetterSetter() {
		CommentEntity comment = new CommentEntity();
		comment.setUser(MOCK_USER);
		comment.setComment(COMMENT);
		comment.setDate(DATE);
		assertEquals(comment.getUser(), MOCK_USER);
		assertEquals(comment.getComment(), COMMENT);
		assertEquals(comment.getDate(), DATE);
	}
	
	@Test
	void testEquals() {
		CommentEntity comment = new CommentEntity();
		comment.setUser(MOCK_USER);
		comment.setComment(COMMENT);
		comment.setDate(DATE);
		
		CommentEntity comment2 = new CommentEntity();
		comment2.setUser(MOCK_USER);
		comment2.setComment(COMMENT);
		comment2.setDate(DATE);
		
		assertTrue(comment.equals(comment2));
	}

}
