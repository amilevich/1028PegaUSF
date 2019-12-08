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
				response.sendRedirect(Rhylehian.incant(Rhylehian.WELCOME));
				return;
			}

			if (!u.isPass(password)) {
				System.out.printf("WRONG PASSWORD\n");
				response.sendRedirect(Rhylehian.incant(Rhylehian.WELCOME));
				return;
			}

			session.setAttribute("user", u);
			
			response.sendRedirect(Rhylehian.incant(Rhylehian.HOME));
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			System.out.printf("%s\n", e.getMessage());
			return;
		}
	}

}
