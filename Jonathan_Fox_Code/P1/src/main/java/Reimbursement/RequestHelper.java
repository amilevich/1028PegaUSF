package Reimbursement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public static String process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
		case "/Reimbursement/html/Login.do":
			return LoginController.login(request);
		case "/Reimbursment/html/RegisterTicket.do":
			try {
				return RegisterTicketController.register(request);
			} catch (Exception e) {
				e.printStackTrace();
				return "./login.html";
			}
		case "/Reimbursment/html/SetStatus.do":
			return SetStatusController.setStatus(request);
		default:
			return "./login.html";
		}
	}

}
