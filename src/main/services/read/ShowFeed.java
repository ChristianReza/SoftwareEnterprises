package main.services.read;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.datamodels.dtos.UserDTO;
import main.datamodels.interfaces.Post;
import main.util.DBUtil;
import main.util.HTMLWriter;
import main.util.Info;

/**
 * Servlet implementation class ShowFeed
 */
@WebServlet("/Feed")
public class ShowFeed extends HttpServlet implements Info {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowFeed() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDTO userFeed = new UserDTO("Demo", "User", "DemoUser@test.com", null, null, Integer.toString(("demo").hashCode()));
		
		List<Post> usersPosts = DBUtil.findPosts(userFeed);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String status = "Your Feed";
		HTMLWriter htmlWriter = new HTMLWriter(status, null, "", null, usersPosts);
		out.println(htmlWriter.createResponsePageWithBodyPOST());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
