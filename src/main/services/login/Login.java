package main.services.login;

import java.io.IOException;
import java.io.PrintWriter; 
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.datamodels.dtos.UserDTO;
import main.util.DBUtil;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String email = request.getParameter("j_username");
		String password = Integer.toString(request.getParameter("j_password").hashCode());
		
		
		// Create UserDTO from endpoint request
		
		UserDTO user = new UserDTO(null, null, email, null,null, password); 
		boolean loginSuccess = DBUtil.loginUser(user);
		PrintWriter out = response.getWriter(); 
		response.setContentType("text/html");
		String title = "logged in";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n";
		if(loginSuccess)
		{
			out.println(docType +
					"<html>\n" + //
					"<head>" + //
					"<style>table, th, td {\r\n" + "  border: 1px solid black;\r\n" + //
					"border-collapse: collapse;\r\n  } </style>" + // 
					"<title>" + title + "</title></head>\n" + //
					"<body bgcolor=\"#f0f0f0\">\n" + //
					"<h1 align=\"center\">" + title + "</h1>\n");
			out.println("<p> Log in Successful, welcome " + email); 
		}
		else
		{
			response.sendRedirect("loginFail.html");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
