package test.java.datamodels.dtos;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import main.datamodels.dtos.CommentDTO;
import main.datamodels.dtos.UserDTO;
import main.datamodels.interfaces.User;

class CommentDTOTest {
	
	private final User MOCK_USER = new UserDTO();
	private final String COMMENT = "That's awesome!";
	
	SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
	Date date = new Date(System.currentTimeMillis());
	
	private final Date DATE = date;

	@Test
	void testGetterSetter() {
		CommentDTO comment = new CommentDTO();
		comment.setUser(MOCK_USER);
		comment.setComment(COMMENT);
		comment.setDate(DATE);
		assertEquals(comment.getUser(), MOCK_USER);
		assertEquals(comment.getComment(), COMMENT);
		assertEquals(comment.getDate(), DATE);
	}
	
	@Test
	void testEquals() {
		CommentDTO comment = new CommentDTO();
		comment.setUser(MOCK_USER);
		comment.setComment(COMMENT);
		comment.setDate(DATE);
		
		CommentDTO comment2 = new CommentDTO();
		comment2.setUser(MOCK_USER);
		comment2.setComment(COMMENT);
		comment2.setDate(DATE);
		
		assertTrue(comment.equals(comment2));
	}

}
