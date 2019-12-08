package Reimbursement;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public static void process(HttpServletRequest request, HttpServletResponse response) {
		switch(Rhylehian.interpret(request.getRequestURI())) {
		case Rhylehian.WELCOME:
			WelcomeController.welcome(request, response);
			break;
		case Rhylehian.LOGIN:
			LoginController.login(request, response);
			break;
		case Rhylehian.REGISTER_TICKET:
			try { RegisterTicketController.register(request, response); }
			catch (Exception e) { e.printStackTrace(); }
			break;
		case Rhylehian.REGISTRATION:
			try { RegistrationController.welcome(request, response); }
			catch (Exception e1) { e1.printStackTrace(); }
			break;
		case Rhylehian.REGISTER_USER:
			try { RegisterUserController.register(request, response); }
			catch (Exception e) { e.printStackTrace(); }
			break;
		case Rhylehian.SET_STATUS:
			SetStatusController.setStatus(request, response);
			break;
		case Rhylehian.HOME:
			try { HomeController.homepage(request, response); }
			catch (IOException e) { e.printStackTrace(); }
			break;
		default:
			try { response.sendRedirect(Rhylehian.incant(Rhylehian.WELCOME)); }
			catch (IOException e) { e.printStackTrace(); }
		}
	}

}
