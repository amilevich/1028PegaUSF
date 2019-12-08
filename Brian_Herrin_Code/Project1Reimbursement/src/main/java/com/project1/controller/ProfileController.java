package com.project1.controller;
import javax.servlet.http.HttpServletRequest;
import com.project1.dao.SystemDaoImpl;
import com.project1.model.Users;
public class ProfileController {
	public static String empUpdate(HttpServletRequest request) {
		Users user = new Users();
		request.getSession().setAttribute("Users", user);
		//System.out.println("empUpdate Session User: " + user.toString());
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String email = request.getParameter("email");
		//System.out.println("empRegister: " + password + " " + firstname + " " + lastname + " " + email);
		Users emplo = new Users();
		emplo.setPassword(password);
		emplo.setFirstName(firstname);
		emplo.setLastName(lastname);
		emplo.setEmail(email);
		//System.out.println("empRegister: " + emplo.toString());
		SystemDaoImpl systemDaoImpl = new SystemDaoImpl();
		systemDaoImpl.updateUsers(user);
		return "/html/EmployeeMainMenu.html";
	}
	
	public static String manUpdate(HttpServletRequest request) {
		Users user = new Users();
		request.getSession().setAttribute("Users", user);
		//System.out.println("empUpdate Session User: " + user.toString());
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String email = request.getParameter("email");
		//System.out.println("empRegister: " + password + " " + firstname + " " + lastname + " " + email);
		Users emplo = new Users();
		emplo.setPassword(password);
		emplo.setFirstName(firstname);
		emplo.setLastName(lastname);
		emplo.setEmail(email);
		//System.out.println("empRegister: " + emplo.toString());
		SystemDaoImpl systemDaoImpl = new SystemDaoImpl();
		systemDaoImpl.updateUsers(user);
		return "/html/ManagerMainMenu.html";
	}
}