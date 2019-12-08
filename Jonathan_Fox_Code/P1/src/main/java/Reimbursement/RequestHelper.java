package Reimbursement;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public static void process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
		case "/P1/html/welcome.fhtagn":
			//WelcomeController.welcome(request, response);
			break;
		case "/P1/html/login.fhtagn":
			LoginController.login(request, response);
			break;
		case "/P1/html/RegisterTicket.fhtagn":
			try {
				RegisterTicketController.register(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/P!/html/SetStatus.fhtagn":
			SetStatusController.setStatus(request, response);
			break;
		case "/P1/html/home.fhtagn":
			try {
				HomeController.homepage(request, response);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		default:
			
		}
	}

}
