package Reimbursement;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeController {
	public static void welcome(HttpServletRequest request, HttpServletResponse response) {
		String s = "<!DOCTYPE html>\n";
		
		s += String.format("%s\n%s\n", new head("", "", new title("", "REIMBURSEMENT LOGIN")).write(),
				new body("", "", new h1("", "LOGIN FOR REIMBURSEMENT!!"),
						new form("method = \"POST\" action=\"login.fhtagn\"", "",
								new input("type=\"text\" name=\"email\" placeholder=\"USERNAME!!\"", ""),
								new input("type=\"password\" name=\"password\" placeholder=\"PASSWORD!!\"", ""),
								new button("class=\"superbotton\" type=\"submit\", id=\"login\"", "<i>SUBMIT!</i>")),
						new form("method=\"POST\", action=\"registration.fhtagn\"", "",
								new button("action=\"submit\" id=\"register\"", "<i>SELL SOUL FOR EMPLOYMENT!!</i>"))).write());
		
		response.setContentType("text/html");
		try {
			response.getWriter().printf("%s", s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
