package com.controller;


import javax.servlet.http.HttpServletRequest;

import com.dao.DaoUserTmpl;
import com.users.Employees;

public class RegisterController {
	
	
	public static String Register(HttpServletRequest request){
			
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("secondName");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String status = request.getParameter("role");
		System.out.println(status);
		int userStatus=0;
		if(status.equals("FinanceManager")) {
			userStatus=1;
		}else {
			userStatus=2;
		}
		
		DaoUserTmpl daoUser = new DaoUserTmpl();
		Employees employee = new Employees(); 
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmail(email);
		employee.setUserName(userName);
		employee.setPassword(password);
		employee.setUserRole(userStatus);		

		//creates new user
		daoUser.addUsers(employee);

		return "/main.html";
		
		
		
	}

}
