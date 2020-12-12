package main.services.create;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.datamodels.dtos.PostDTO;
import main.datamodels.dtos.UserDTO;
import main.util.DBUtil;

@WebServlet("/createPost")
public class CreatePost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreatePost() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String subject = request.getParameter("subject");
		String body = request.getParameter("body").trim();


		Date date = new Date(System.currentTimeMillis());
		
		UserDTO postUser = new UserDTO("Demo", "User", "DemoUser@test.com", "", null, Integer.toString(("demo").hashCode()));

		// Create PostDTO from endpoint request
		PostDTO post = new PostDTO(subject, body, date);

		DBUtil.createPost(post, postUser);

		response.sendRedirect("index.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
