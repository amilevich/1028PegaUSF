package Reimbursement;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

public class RegisterUserController {
	public static void register(HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException {
		try {
			HttpSession session = request.getSession();
			DAO dao;
			User u;
			String first_name, last_name, email, password;
			MessageDigest md5 = MessageDigest.getInstance("MD5");

			if (session.getAttribute("dao") == null) session.setAttribute("dao", new DAO(true));
			dao = (DAO) session.getAttribute("dao");

			email = request.getParameter("email");
			first_name = request.getParameter("first_name");
			last_name = request.getParameter("last_name");
			password = request.getParameter("password");

			if(email == null || first_name == null || last_name == null || password == null) {
				System.out.printf("PARAMETERS PASSED IN IMPROPERLY\n email:%s password:%s first_name:%s last_name:%s\n", email, password, first_name, last_name);
				response.sendRedirect(Rhylehian.incant(Rhylehian.REGISTRATION));
				return;
			}
			
			password = DatatypeConverter.printHexBinary(md5.digest(password.getBytes()));
			
			u = new User(email, password, first_name, last_name, false);
			
			if(dao.storeUser(u)) response.sendRedirect(Rhylehian.incant(Rhylehian.WELCOME));
			else response.sendRedirect(Rhylehian.incant(Rhylehian.REGISTRATION));
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.printf("%s\n", e.getMessage());
			response.sendRedirect(Rhylehian.incant(Rhylehian.REGISTRATION));
			return;
		} catch (InstantiationException e) {
			e.printStackTrace();
			System.out.printf("%s\n", e.getMessage());
			response.sendRedirect(Rhylehian.incant(Rhylehian.REGISTRATION));
			return;
		}

		return;
	}
}
