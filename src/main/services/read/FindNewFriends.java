package main.services.read;

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
import main.datamodels.interfaces.User;
import main.util.DBUtil;
import main.util.HTMLWriter;
import main.util.Info;

/**
 * Servlet implementation class findFriends
 */
@WebServlet("/findFriends")
public class FindNewFriends extends HttpServlet implements Info {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindNewFriends() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName").trim();
		String lastName = request.getParameter("lastName").trim();
		String location = request.getParameter("location");
		String hobbies = request.getParameter("hobbies");
		List<String> hobbiesList = Arrays.asList(hobbies.split(",")); // split hobbies by a space into a List<String>

		// Create UserDTO from endpoint request
		UserDTO user = new UserDTO(firstName, lastName, null, location, hobbiesList, null);

		List<User> possibleFriends = DBUtil.findUsers(user);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String status = "Possible Friends";
		String altText = "Find more";
		HTMLWriter htmlWriter = new HTMLWriter(status, findFriendsName, altText, possibleFriends, null);
		out.println(htmlWriter.createResponsePageWithBodyUSER());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
