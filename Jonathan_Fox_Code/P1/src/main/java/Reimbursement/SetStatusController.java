package Reimbursement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SetStatusController {

	public static String setStatus(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			DAO dao = (DAO) session.getAttribute("dao");
			User u = (User) session.getAttribute("user");

			String id = request.getParameter("id"); // ?????????????
			String status = request.getParameter("status");

			if (dao == null || u == null) {
				System.out.printf("LOGIN FIRST\n");
				return "./login.html";
			}

			if (id == null || status == null) {
				System.out.printf("PARAMETERS NOT PASSED IN PROPERLY\nid: %s status: %s", id, status);
				return "./employee.html";
			}

			if (!dao.modTicket(Integer.valueOf(id), (Integer.valueOf(status)==1)?true:false)) {
				System.out.printf("TICKET MODIFICATION FAILURE\n");
				return "./employee.html";
			}
			
		}catch(Exception e) { System.out.printf("%s\n", e.getMessage()); }
		
		return "./employee.html";
		
	}
}