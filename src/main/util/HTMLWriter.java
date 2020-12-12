package main.util;

import java.util.List;

import main.datamodels.interfaces.Post;
import main.datamodels.interfaces.User;

public class HTMLWriter implements Info {

	private String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n";

	private String style = "<style>\r\n" + "header {\r\n" + "    background: linear-gradient(to bottom left, #33ccff 8%, #66ff99 74%);\r\n" + "    color:white;\r\n"
			+ "    text-align:center;\r\n" + "    padding:5px;	 \r\n" + "}\r\n" + "nav {\r\n"
			+ "    line-height:30px;\r\n" + "    background-color:#eeeeee;\r\n" + "    height:100%;\r\n"
			+ "    width:115px;\r\n" + "    float:left;\r\n" + "    padding:5px;	      \r\n" + "}\r\n"
			+ "section {\r\n" + "    width:350px;\r\n" + "    float:left;\r\n" + "    padding:10px;	 	 \r\n" + "}\r\n"
			+ "footer {\r\n" + "     background: linear-gradient(to bottom left, #33ccff 8%, #66ff99 74%);\r\n" + "    color:white;\r\n" + "    clear:both;\r\n"
			+ "    text-align:center;\r\n" + "    padding:5px;	 	 \r\n" + "}\r\n" + "</style>";

	private String title;
	private String webName;
	private String webNameAlt;
	private List<User> userList;
	private List<Post> usersPosts;

	/**
	 * 
	 * @param title      - Title to be at the top of the HTML page.
	 * @param webName    - Name of HTML file to link back to in HTML response from
	 *                   back-end.
	 * @param webNameAlt - Alternate name for webName.
	 */
	public HTMLWriter(String title, String webName, String webNameAlt) {
		this.title = title;
		this.webName = webName;
		this.webNameAlt = webNameAlt;
	}

	public HTMLWriter(String title, String webName, String webNameAlt, List<User> bodyList, List<Post> usersPosts) {
		this.title = title;
		this.webName = webName;
		this.webNameAlt = webNameAlt;
		this.userList = bodyList;
		this.usersPosts = usersPosts;
	}

	public String createResponsePage() {
		String body = (docType + //
				"<html>\n" + //
				"<head>" + //
				style + //
				"<title>" + this.title + "</title></head>\n" + //
				"<body bgcolor=\"#f0f0f0\">\n" + //
				"<h1 align=\"center\">" + this.title + "</h1>\n" + "\"<nav> <a href=\"/SoftwareEnterprises/index.html\">Home</a> <br>  <a href=/" + projectName + "/"
				+ this.webName + ">" + this.webNameAlt + "</a> </nav> <br>" + "<footer>\r\n" + "Copyright\r\n"
				+ "</footer></body></html>");
		return body;
	}

	public String createResponsePageWithBodyUSER() {
		StringBuilder tableBuilder = new StringBuilder();
		tableBuilder.append(
				"<table> <tr> <th>First Name</th> <th>Last Name</th> <th>Location</th> " + "<th>Hobbies</th></tr>");
		for (User user : userList) {

			tableBuilder.append(String.format("<tr> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> </tr>",
					user.getFirstName(), user.getLastName(), user.getLocation(), user.getHobbies()));

		}
		tableBuilder.append("</table>");

		String body = (docType + //
				"<html>\n" + //
				"<head>" + //
				style + //
				"<title>" + this.title + "</title></head>\n" + //
				"<body bgcolor=\"#f0f0f0\">"
				+ "<header>\r\n" + 
				"		<h1>" + this.title + "</h1>\r\n" + 
				"	</header>\n" + //
				"\n" +
				"<nav> <a href=\"/SoftwareEnterprises/index.html\">Home</a> <br> <a href=/"
				+ projectName + "/" + this.webName + ">" + this.webNameAlt + "</a> </nav> <br>"
				+ "<section> <ul>" + tableBuilder + "</ul> </section>" + 
				"<footer>\r\n"
				+ "\r\n" + "</footer></body></html>");
		return body;
	}
	
	public String createResponsePageWithBodyPOST() {
		StringBuilder tableBuilder = new StringBuilder();
		tableBuilder.append(
				"<table> <tr> <th>Subject</th> <th>Body</th> <th>Date</th></tr>");
		for (Post post : usersPosts) {

			tableBuilder.append(String.format("<tr> <td>%s</td> <td>%s</td> <td>%s</td> </tr>",
					post.getSubject(), post.getBody(), post.getDate()));

		}
		tableBuilder.append("</table>");

		String body = (docType + //
				"<html>\n" + //
				"<head>" + //
				style + //
				"<title>" + this.title + "</title></head>\n" + //
				"<body bgcolor=\"#f0f0f0\">"
				+ "<header>\r\n" + 
				"		<h1>" + this.title + "</h1>\r\n" + 
				"	</header>\n" + //
				"\n <nav> <a href=\"/SoftwareEnterprises/index.html\">Home</a> <br>  <a href=/"
				+ projectName + "/" + this.webName + ">" + this.webNameAlt + "</a> </nav> <br> <section> <ul>" + tableBuilder + "</ul> </section>" + "<footer>\r\n"
				+ "Copyright\r\n" + "</footer></body></html>");
		return body;
	}

}
