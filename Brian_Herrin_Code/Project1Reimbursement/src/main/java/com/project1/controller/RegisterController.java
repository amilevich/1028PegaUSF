package com.project1.controller;
import javax.servlet.http.HttpServletRequest;
import com.project1.dao.SystemDaoImpl;
import com.project1.model.Users;public class RegisterController {	
	// Register for Employee (2)
		public static String empRegister(HttpServletRequest request) {
			String username = request.getParameter("txtUsernameApply");
			String password = request.getParameter("txtPasswordApply");
			String firstname = request.getParameter("txtFirstNameApply");
			String lastname = request.getParameter("txtLastNameApply");
			String email = request.getParameter("txtEMailApply");
			//System.out.println("empRegister: " + username + " " + password + " " + firstname + " " + lastname + " " + email);
			//int role = request.getParameter("role");			
			Users emplo = new Users();
			emplo.setUsersId(0);
			emplo.setName(username);
			emplo.setPassword(password);
			emplo.setFirstName(firstname);
			emplo.setLastName(lastname);
			emplo.setEmail(email);
			emplo.setRole(2);
			//System.out.println("empRegister: " + emplo.toString());
			SystemDaoImpl systemDaoImpl = new SystemDaoImpl();
			systemDaoImpl.insertUsers(emplo);
			return "/html/Index.html";
		}
		
		public static String manRegister(HttpServletRequest request) {
			String username = request.getParameter("txtUsernameApply");
			String password = request.getParameter("txtPasswordApply");
			String firstname = request.getParameter("txtFirstNameApply");
			String lastname = request.getParameter("txtLastNameApply");
			String email = request.getParameter("txtEMailApply");
			//System.out.println("manRegister: " + username + " " + password + " " + firstname + " " + lastname + " " + email);
			//int role = request.getParameter("role");			
			Users emplo = new Users();
			emplo.setUsersId(0);
			emplo.setName(username);
			emplo.setPassword(password);
			emplo.setFirstName(firstname);
			emplo.setLastName(lastname);
			emplo.setEmail(email);
			emplo.setRole(1);
			//System.out.println("manRegister: " + emplo.toString());
			SystemDaoImpl systemDaoImpl = new SystemDaoImpl();
			systemDaoImpl.insertUsers(emplo);
			return "/html/Index.html";
		}
	}