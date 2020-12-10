package main.util;

public class HTMLWriter implements Info {

	private String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n";

	private String style = "<style>\r\n" + "header {\r\n" + "    background-color:black;\r\n" + "    color:white;\r\n"
			+ "    text-align:center;\r\n" + "    padding:5px;	 \r\n" + "}\r\n" + "nav {\r\n"
			+ "    line-height:30px;\r\n" + "    background-color:#eeeeee;\r\n" + "    height:300px;\r\n"
			+ "    width:100px;\r\n" + "    float:left;\r\n" + "    padding:5px;	      \r\n" + "}\r\n"
			+ "section {\r\n" + "    width:350px;\r\n" + "    float:left;\r\n" + "    padding:10px;	 	 \r\n" + "}\r\n"
			+ "footer {\r\n" + "    background-color:black;\r\n" + "    color:white;\r\n" + "    clear:both;\r\n"
			+ "    text-align:center;\r\n" + "    padding:5px;	 	 \r\n" + "}\r\n" + "</style>";

	private String title;
	private String webName;
	private String webNameAlt;

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

	public String createResponsePage() {
		String body = (docType + //
				"<html>\n" + //
				"<head>" + //
				style + //
				"<title>" + this.title + "</title></head>\n" + //
				"<body bgcolor=\"#f0f0f0\">\n" + //
				"<h1 align=\"center\">" + this.title + "</h1>\n" + "<ul>" +
//				"<li> Site: " + siteURL +
				"</ul>" + "<a href=/" + projectName + "/" + this.webName + ">" + this.webNameAlt + "</a> <br>"
				+ "</body></html>");
		return body;
	}

}
