package Reimbursement;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController {

	public static void login(HttpServletRequest request, HttpServletResponse response) {

		try {
			String name = request.getParameter("email");
			String password = request.getParameter("password");
			User u;
			DAO dao;
			HttpSession session;
			session = request.getSession();
			if (session.getAttribute("dao") == null)
				session.setAttribute("dao", new DAO(true));

			dao = (DAO) session.getAttribute("dao");
			u = dao.getUser(name);

			if (u == null) {
				System.out.printf("%s, YOU DONT EXIST\n", name);
				response.sendRedirect("./welcome.fhtagn");
				return;
			}

			if (!u.isPass(password)) {
				System.out.printf("WRONG PASSWORD\n");
				response.sendRedirect("./welcome.fhtagn");
				return;
			}

			session.setAttribute("user", u);

			response.setContentType("text/html");

			response.getWriter().printf("%s%s", "<!DOCTYPE html>\n",
					new head("", "").write() + new body("title=\"LOGGED IN\"",
							String.format("YOU ARE %s %s", u.getName()[0], u.getName()[1]),
							new h1("", (u.isAdvisor()) ? "advisor" : "employee"), new form("action = \"home.fhtagn\"", "",
									new button("type = \"submit\"", "<i>CONTINUE!<i>"))).write());
			
			response.sendRedirect("./home.fhtagn");

			//
			// if(name == e.name && password == e.password){
			// return "/Reimbursment/html/employee.html";}

			// else if(name == m.name && password == m.password{
			// return "/Reimbursment/html/manager.html";}
			//
			// else{
			// return "/Reimbursment/html/login.html";}
			//

		} catch (SQLException | IOException e) {
			e.printStackTrace();
			System.out.printf("%s\n", e.getMessage());
			return;
		}
	}

}
