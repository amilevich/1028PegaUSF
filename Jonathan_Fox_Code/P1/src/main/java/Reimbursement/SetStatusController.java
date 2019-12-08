package Reimbursement;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SetStatusController {

	public static void setStatus(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			DAO dao = (DAO) session.getAttribute("dao");
			User u = (User) session.getAttribute("user");

			String id = request.getParameter("id");
			String status = request.getParameter("mod");

			if (dao == null || u == null) {
				System.out.printf("LOGIN FIRST\n");
				response.sendRedirect("./welcome.fhtagn");
				return;
			}

			if (id == null || status == null) {
				System.out.printf("PARAMETERS NOT PASSED IN PROPERLY\nid: %s status: %s\n", id, status);
				response.sendRedirect("./home.fhtagn");
				return;
			}

			if (!dao.modTicket(Integer.valueOf(id), (Integer.valueOf(status)==1)?true:false)) {
				System.out.printf("TICKET MODIFICATION FAILURE\n");
				response.sendRedirect("./home.fhtagn");
				return;
			}
			
			response.sendRedirect("./home.fhtagn");
			return;
			
		}catch(Exception e) {
			System.out.printf("%s\n", e.getMessage());
			try { response.sendRedirect("./home.fhtagn"); }
			catch (IOException e1) { e1.printStackTrace(); }
			return;
		}
	
	}
}