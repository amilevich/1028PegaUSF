package com.controller;

import javax.servlet.http.HttpServletRequest;

import com.dao.DaoUserTmpl;
import com.users.Employees;

public class LoginController {
	
	
	
	public static String Login(HttpServletRequest request) {
		String name = request.getParameter("userName");
		String password = request.getParameter("password");
		System.out.println("this is the name from html" + name);
		DaoUserTmpl daoUser = new DaoUserTmpl();
		Employees employee= new Employees();
		System.out.println("in login controller after employee made");
		 employee = daoUser.selectUserByName(name);
		 System.out.println("the employee selected is" + employee);
		
		 if(name.equals(employee.getUserName()) && password.equals(employee.getPassword())) {
				//we are setting the session to the current logged in pet
				request.getSession().setAttribute("Employees", employee);
				return "/EmployeePortal.html";
			}
			
			return "/main.html";
	}

}
