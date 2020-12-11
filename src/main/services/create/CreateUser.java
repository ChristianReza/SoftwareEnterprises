package main.services.create;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.datamodels.dtos.UserDTO;
import main.util.DBUtil;

@WebServlet("/createUser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateUser() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName").trim();
		String lastName = request.getParameter("lastName").trim();
		String password = Integer.toString(request.getParameter("password").hashCode()); // hash pw
		String email = request.getParameter("email");
		String location = request.getParameter("location");
		String hobbies = request.getParameter("hobbies");
		List<String> hobbiesList = Arrays.asList(hobbies.split(",")); // split hobbies by a space into a List<String>
		List<String> hobbiesTrimmed = hobbiesList.stream().map(String::trim).collect(Collectors.toList());

		// Create UserDTO from endpoint request
		UserDTO user = new UserDTO(firstName, lastName, email, location, hobbiesTrimmed, password);

		DBUtil.createUser(user);

		response.sendRedirect("login.html");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
