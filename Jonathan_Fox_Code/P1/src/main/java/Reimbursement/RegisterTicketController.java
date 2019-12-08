package Reimbursement;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterTicketController {

	public static void register(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, InstantiationException, IOException {
		HttpSession session = request.getSession();
		DAO dao = (DAO)session.getAttribute("dao");
		User u = (User)session.getAttribute("user");
		String type = request.getParameter("ttype");
		String price = request.getParameter("price");
		String description = request.getParameter("Description");
		Ticket t;
		
		if(dao == null || u == null) {
			System.out.printf("LOGIN FIRST\n");
			response.sendRedirect("./welcome.fhtagn");
			return;
		}
		
		t = new Ticket(u.getEmail(), Double.valueOf(price), description, Byte.valueOf(type), new Timestamp(System.currentTimeMillis()));
		
		if(!dao.storeTicket(t))  System.out.printf("STORE TICKET FAIL\n");
		
		response.sendRedirect("./home.fhtagn");
		return;	
	}
}