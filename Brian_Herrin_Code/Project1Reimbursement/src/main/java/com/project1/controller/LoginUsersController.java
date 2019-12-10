package com.project1.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.project1.dao.SystemDaoImpl;
import com.project1.model.Reimbursement;
import com.project1.model.SessionData;
import com.project1.model.Users;
public class LoginUsersController {

	public static String Login(HttpServletRequest request) {
		//System.out.println(request.getParameterValues().size() + " " + request.getParameterValues());
		String name = request.getParameter("txtUsernameQuery");
		String password = request.getParameter("txtPasswordQuery");
		//System.out.println("Login name: "+ name + ", password: " + password);
		SystemDaoImpl sysImpl = new SystemDaoImpl();
		// Getting user personal details from the DB
		Users users = new Users();
		users = sysImpl.selectUsers(name);
		//System.out.println(users.getName()+" "+users.getPassword());
		
		if(name == null || password == null || name.equals("") || password.equals("")) {
			//System.out.println("LoginController: null values for name or password");
		} else if(name.equals(users.getName()) && password.equals(users.getPassword())) {
			request.getSession().setAttribute("Users", users);
			if(users.getRole()==2) {
				//
				List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
				reimbursements = sysImpl.selectReimbursementsByUsersId(users.getUsersId());
				SessionData sessionData = new SessionData(users, reimbursements);
				request.getSession().setAttribute("SessionData", sessionData);
				
				return "/html/EmployeeMainMenu.html";
			} else {
				//
				List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
				reimbursements = sysImpl.selectAllReimbursements();
				SessionData sessionData = new SessionData(users, reimbursements);
				request.getSession().setAttribute("SessionData", sessionData);
				
				return "/html/ManagerMainMenu.html";
			}
			
		}
		
		return "/html/Index.html";
	}

	public static String Logout(HttpServletRequest request) {
		//
		SessionData data = new SessionData();
		request.getSession().setAttribute("SessionData", data);
		//
		return "/html/Index.html";
	}
}


