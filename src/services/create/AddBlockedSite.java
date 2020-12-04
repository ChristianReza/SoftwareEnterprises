package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;

@WebServlet("/report")
public class AddBlockedSite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddBlockedSite() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String siteURL = request.getParameter("site").trim();

		DBUtil.blacklistSite(siteURL);

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
		out.println("<li> Site: " + siteURL);
		out.println("</ul>");
//		out.println("<a href=/" + projectName + "/" + searchWebName + ">Search Data</a> <br>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
