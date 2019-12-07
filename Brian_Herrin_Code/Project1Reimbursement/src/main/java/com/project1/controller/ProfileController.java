package com.project1.controller;

import javax.servlet.http.HttpServletRequest;

import com.project1.dao.SystemDaoImpl;
//import com.project1.model.Employee;
import com.project1.model.Manager;
import com.project1.model.Users;

public class ProfileController {
	
	public static String empUpdate(HttpServletRequest request) {
		Users employee = (Users)request.getSession().getAttribute("Users");
		//getting the attribute from the session that was set upon
		//login in LoginController
		
		String type = request.getParameter("txtPasswordQuery");
		employee.setFirstName(type);
		
		SystemDaoImpl sysDaoImpl = new SystemDaoImpl();
		sysDaoImpl.updateUsers(employee);
		if(employee.getRole()==1)
			return "/html/EmployeeMainMenu.html";
		else
			return "/html/ManagerMainMenu.html";
	}
	
	public static String manUpdate(HttpServletRequest request) {
		Manager employee = (Manager)request.getSession().getAttribute("Manager");
		//getting the attribute from the session that was set upon
		//login in LoginController
		
		String type = request.getParameter("txtPasswordQuery");
		employee.setFirstName(type);
		
		SystemDaoImpl sysDaoImpl = new SystemDaoImpl();
		sysDaoImpl.updateManager(employee);
		
		return "/html/ManagerMainMenu.html";
	}

}
