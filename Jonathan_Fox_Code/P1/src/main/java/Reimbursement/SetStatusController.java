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
				response.sendRedirect(Rhylehian.incant(Rhylehian.WELCOME));
				return;
			}

			if (id == null || status == null) {
				System.out.printf("PARAMETERS NOT PASSED IN PROPERLY\nid: %s status: %s\n", id, status);
				response.sendRedirect(Rhylehian.incant(Rhylehian.HOME));
				return;
			}

			if (!dao.modTicket(Integer.valueOf(id), (Integer.valueOf(status)==1)?true:false)) {
				System.out.printf("TICKET MODIFICATION FAILURE\n");
				response.sendRedirect(Rhylehian.incant(Rhylehian.HOME));
				return;
			}
			
			response.sendRedirect(Rhylehian.incant(Rhylehian.HOME));
			return;
			
		}catch(Exception e) {
			System.out.printf("%s\n", e.getMessage());
			try { response.sendRedirect(Rhylehian.incant(Rhylehian.HOME)); }
			catch (IOException e1) { e1.printStackTrace(); }
			return;
		}
	
	}
}