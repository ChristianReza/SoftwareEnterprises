package main.services.create;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import main.util.DBUtil;
import main.util.HTMLWriter;
import main.util.Info;

@WebServlet("/report")
public class AddBlockedSite extends HttpServlet implements Info {
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
		String status = "Site reported";
		String altText = "Report a Site";
		HTMLWriter htmlWriter = new HTMLWriter(status, reportSiteName, altText);
		out.println(htmlWriter.createResponsePage());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
