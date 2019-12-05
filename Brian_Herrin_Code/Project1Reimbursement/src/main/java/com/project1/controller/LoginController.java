package com.project1.controller;

import javax.servlet.http.HttpServletRequest;

import com.project1.dao.SystemDaoImpl;
import com.project1.model.Employee;

public class LoginController {
	
	
	public static String Login(HttpServletRequest request) {
		String name = request.getParameter("txtUsernameQuery");
		String pass = request.getParameter("txtPasswordQuery");
		
		SystemDaoImpl sysDaoImpl = new SystemDaoImpl();
		Employee employee = new Employee();
		employee = sysDaoImpl.selectEmployeeByName(name);
		//we are retrieving an existing record by the employee's name
		//that the user provided on the login page
		//and we are storing it in a pet object
		
		if(name.equals(employee.getUserName()) && pass.equals(employee.getPassword())) {
			//we are setting the session to the current logged in pet
			request.getSession().setAttribute("Employee", employee);
			return "/html/EmployeeMainMenu.html";
		}
		
		return "/html/Index.html";
	}

}
