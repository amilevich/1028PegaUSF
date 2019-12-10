package Reimbursement;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationController {
	public static void welcome(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String s = "<!DOCTYPE html>";
		
		s += new html("", "",
				new head("", "",
					new meta("charset=\"utf-8\"", ""),
					new meta("http-equiv=\"X-UA-Compatible\" content=\"ie*edge\"", ""),
					new style("","* {\r\n" + 
							"    font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;\r\n" + 
							"}\r\n" + 
							"body{\r\n" + 
							"	background-image:url('https://i.redd.it/orfoia6fvsw21.png'); \r\n" + 
							"	background-size:cover;\r\n" + 
							"}\r\n" + 
							"button{\r\n" + 
							"	animation: blink 1s infinite;\r\n" + 
							"	background-color:red;\r\n" + 
							"	opacity:0.7;\r\n" + 
							"}\r\n" + 
							"@keyframes blink{\r\n" + 
							"	from{\r\n" + 
							"		opacity:0.2;\r\n" + 
							"		color:lime;\r\n" + 
							"	}\r\n" + 
							"	to{\r\n" + 
							"		opacity:0.7;\r\n" + 
							"		color:white;\r\n" + 
							"	}\r\n" + 
							"	0%{\r\n" + 
							"		opacity:0.2;\r\n" + 
							"	}\r\n" + 
							"	50%{\r\n" + 
							"		opacity:0.6;\r\n" + 
							"	}\r\n" + 
							"	100%{\r\n" + 
							"		opacity:0.8;\r\n" + 
							"	}\r\n" + 
							"}\r\n" + 
							"\r\n" + 
							"h2 {\r\n" + 
							"	color:white;\r\n" + 
							"    font-size: 80px;\r\n" + 
							"    text-align: center;\r\n" + 
							"    font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;\r\n" + 
							"    margin-bottom: 0%;\r\n" + 
							"    margin-top: 0%;\r\n" + 
							"}\r\n" + 
							"label{\r\n" + 
							"	color:white;\r\n" + 
							"}\r\n" + 
							"\r\n" + 
							"#submit {\r\n" + 
							"    font-size: 200px;\r\n" + 
							"    padding-top: 32%;\r\n" + 
							"    padding-bottom: 32%;\r\n" + 
							"    margin-right: 0px;\r\n" + 
							"    text-align: center;\r\n" + 
							"}\r\n" + 
							".form-group{\r\n" + 
							"	padding:0%;\r\n" + 
							"	font-size:65px;\r\n" + 
							"	margin:0px;\r\n" + 
							"}\r\n" + 
							"input {\r\n" + 
							"	margin:0px;\r\n" + 
							"	padding:0%;\r\n" + 
							"	font-size:60px;\r\n" + 
							"    width: 90%;\r\n" + 
							"	opacity:0.7;\r\n" + 
							"}"),
					new title("", "SLAVE REGISTRATION")),
				new body("", "",
						new div("class=\"container\"", "", 
							new h2("", "REGISTRATION FORM"),
							new form(String.format("style='display:flex; justify-content: center; align-items: center;' class=\"form-group\" action=\"%s\"",Rhylehian.incant(Rhylehian.REGISTER_USER)), "",
									new div("style='display:inline-block;flex-grow: 1'","",
											new div("class='form-group'","",
													new label("class=\"control-label col-sm-2\" for=\"email\"","Email"),
													new input("type=\"text\" class=\"form-control\" id=\"email\" placeholder=\"Enter email\" name=\"email\"","")),
											new div("class='form-group'","",
													new label("class=\"control-label col-sm-2\" for=\"password\"","Password"),
													new input("type=\"password\" class=\"form-control\" id=\"password\" placeholder=\"Enter password\" name=\"password\"","")),
											new div("class='form-group'","",
													new label("class=\"control-label col-sm-2\" for=\"first_name\"","First Name"),
													new input("type=\"text\" class=\"form-control\" id=\"first_name\" placeholder=\"Enter first name\" name=\"first_name\"","")),
											new div("class='form-group'","",
													new label("class=\"control-label col-sm-2\" for=\"last_name\"","Last Name"),
													new input("type=\"text\" class=\"form-control\" id=\"last-name\" placeholder=\"Enter last name\" name=\"last_name\"",""))),
									new div("style='display:inline-block; flex-grow: 4' class=\"form-group\"","",
											new div("class=\"col-sm-offset-2 col-sm-10\"","",
													new button("type=\"submit\" class=\"btn btn-default\" id = \"submit\" font-size=\"1000px\"","<i>SUBMIT!</i>"))))))).write();
		
		response.setContentType("text/html");
		response.getWriter().printf("%s", s);
		return;
		
	}
}
