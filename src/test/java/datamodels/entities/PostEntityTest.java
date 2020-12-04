package test.java.datamodels.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.datamodels.dtos.PostDTO;
import main.datamodels.entities.PostEntity;
import main.datamodels.interfaces.Comment;

class PostEntityTest {

	private final String SUBJECT = "subject";
	private final String BODY = "body";
	
	private final List<Comment> COMMENTS = new ArrayList<Comment>();
	
	SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
	Date date = new Date(System.currentTimeMillis());
	
	private final Date DATE = date;
	
	@Test
	void testConstructor() {
		PostDTO postDTO = new PostDTO(SUBJECT, BODY, DATE);
		PostEntity post = new PostEntity(postDTO);
		
		assertEquals(post.getSubject(), SUBJECT);
		assertEquals(post.getBody(), BODY);
		assertEquals(post.getDate(), DATE);
	}
	
	@Test
	void testGetterSetter() {
		PostEntity post = new PostEntity();
		post.setSubject(SUBJECT);
		post.setBody(BODY);
		post.setDate(DATE);
		post.setComments(COMMENTS);
		
		assertEquals(post.getSubject(), SUBJECT);
		assertEquals(post.getBody(), BODY);
		assertEquals(post.getDate(), DATE);
		assertEquals(post.getComments(), COMMENTS);
	}
	
	@Test
	void testEquals() {
		PostEntity post = new PostEntity();
		post.setSubject(SUBJECT);
		post.setBody(BODY);
		post.setDate(DATE);
		post.setComments(COMMENTS);
		
		PostEntity post2 = new PostEntity();
		post2.setSubject(SUBJECT);
		post2.setBody(BODY);
		post2.setDate(DATE);
		post2.setComments(COMMENTS);
		
		assertTrue(post.equals(post2));
	}

}
