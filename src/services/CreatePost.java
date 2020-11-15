package services;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodels.dtos.PostDTO;
import util.DBUtil;

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


		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		
		// TODO this post needs to get tied to a user, since we don't have an actual LDAP, I don't think we can do that
		// so I think we should hardcode a TestUser for all posts.

		// Create PostDTO from endpoint request
		PostDTO post = new PostDTO(subject, body, date);

		DBUtil.createPost(post);

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
