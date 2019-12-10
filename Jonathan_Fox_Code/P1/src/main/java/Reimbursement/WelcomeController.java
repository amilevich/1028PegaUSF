package Reimbursement;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeController {
	public static void welcome(HttpServletRequest request, HttpServletResponse response) {
		String s = "<!DOCTYPE html>\n";
		
		s += String.format("%s\n%s\n", new head("", "", new style("","* {\r\n" + 
				"            font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"body{\r\n" + 
				"	background-image:url('https://i.ytimg.com/vi/rKQMBYYIrSU/maxresdefault.jpg');\r\n" + 
				"	background-size:cover;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"button{\r\n" + 
				"	background-color:red;\r\n" + 
				"	opacity:0.7;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"#submission {padding: 2%;}\r\n" + 
				"h1 {\r\n" + 
				"	font-size: 65px;\r\n" + 
				"	font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;\r\n" + 
				"	margin-bottom: 0%;\r\n" + 
				"	margin-top: 0%;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"@keyframes blink{\r\n" + 
				"	from{\r\n" + 
				"		opacity:0;\r\n" + 
				"		color:lime;\r\n" + 
				"	}\r\n" + 
				"	to{\r\n" + 
				"		opacity:1;\r\n" + 
				"		color:white;\r\n" + 
				"	}\r\n" + 
				"	0%{ opacity:0.2; }\r\n" + 
				"	50%{ opacity:0.6; }\r\n" + 
				"	100%{ opacity:0.8; }\r\n" + 
				"}\r\n" + 
				"label {\r\n" + 
				"	font-size: 70px;\r\n" + 
				"}\r\n" + 
				"input {\r\n" + 
				"	height: 70px;\r\n" + 
				"	width: 95%;\r\n" + 
				"	font-size: 70px;\r\n" + 
				"	opacity: 0.8;\r\n" + 
				"}\r\n" + 
				"#login {\r\n" + 
				"	animation: blink 1s infinite;\r\n" + 
				"	text-align: center;\r\n" + 
				"	font-size: 120px;\r\n" + 
				"	width: max-content;\r\n" + 
				"	padding-top: 12%;\r\n" + 
				"	padding-bottom: 12%;\r\n" + 
				"	padding-left:200px;\r\n" + 
				"	padding-right:200px;\r\n" + 
				"}\r\n" + 
				"#register {\r\n" + 
				"	animation: blink 0.99s infinite;\r\n" + 
				"	font-size: 100px;\r\n" + 
				"	padding-top: 5%;\r\n" + 
				"	padding-bottom: 5%;\r\n" + 
				"	width: max-content;\r\n" + 
				"	padding-left: 10%;\r\n" + 
				"	padding-right: 10%;\r\n" + 
				"	text-align: center;\r\n" + 
				"}"),
				new title("", "REIMBURSEMENT LOGIN")).write(),
				new body("", "", new h1("text-align='left'", "LOGIN FOR REIMBURSEMENT!!"),
						new div("id = 'submission'","",
						new form(String.format("style='display:flex; justify-content: center; align-items: center;' method = \"POST\" action=\"%s\"", Rhylehian.incant(Rhylehian.LOGIN)), "", new div("style='display:inline-block;flex-grow: 1'","",
								new label("","EMAIL:"),
								new input("type=\"text\" name=\"email\" placeholder=\"USERNAME!!\"", ""),
								new label("","PASSWORD:"),
								new input("type=\"password\" name=\"password\" placeholder=\"PASSWORD!!\"", "")), new div("style='display:inline-block; flex-grow: 3'","",
								new button("class=\"superbotton\" type=\"submit\", id=\"login\"", "<i>SUBMIT!</i>")))),
						new br("",""),
						new form(String.format("method=\"POST\", action=\"%s\"", Rhylehian.incant(Rhylehian.REGISTRATION)), "",
								new button("action=\"submit\" id=\"register\"", "<i>SELL SOUL FOR EMPLOYMENT!!</i>"))).write());
		
		response.setContentType("text/html");
		try { response.getWriter().printf("%s", s); }
		catch (IOException e) { e.printStackTrace(); }
	}
}
