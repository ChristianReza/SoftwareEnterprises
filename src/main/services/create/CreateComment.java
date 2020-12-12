package main.services.create;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.datamodels.dtos.CommentDTO;
import main.datamodels.dtos.UserDTO;
import main.util.DBUtil;

/**
 * Servlet implementation class CreateComment
 */
@WebServlet("/CreateComment")
public class CreateComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subject = request.getParameter("subject");
		String body = request.getParameter("body").trim();
		
		UserDTO commentUser = new UserDTO("Commenting", "User", "CommentingUser@test.com", null, null, Integer.toString(("testuser").hashCode()));


		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm z");
		Date date = new Date(System.currentTimeMillis());
		
		// TODO this post needs to get tied to a user, since we don't have an actual LDAP, I don't think we can do that
		// so I think we should hardcode a TestUser for all posts.

		// Create PostDTO from endpoint request
		CommentDTO comment = new CommentDTO(commentUser, body, date);

		DBUtil.createComment(comment);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Database Result";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
		out.println(docType + //
				"<html>\n" + //
				"<head>" + //
				"<style>table, th, td {\r\n" + "  border: 1px solid black;\r\n" + //
				"border-collapse: collapse;\r\n  } </style>" + // 
				"<title>" + title + "</title></head>\n" + //
				"<body bgcolor=\"#f0f0f0\">\n" + //
				"<h1 align=\"center\">" + title + "</h1>\n");
		out.println("<ul>");
		out.println("<li> Post: " + subject + "\t" + formatter.format(date) + "\n" + body);
		out.println("</ul>");
//		out.println("<a href=/" + projectName + "/" + searchWebName + ">Search Data</a> <br>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
