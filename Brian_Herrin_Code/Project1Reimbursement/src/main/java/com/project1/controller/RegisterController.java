package com.project1.controller;

import javax.servlet.http.HttpServletRequest;

import com.project1.dao.SystemDaoImpl;
import com.project1.model.Employee;

public class RegisterController {
	public static String empRegister(HttpServletRequest request) {
		String name = request.getParameter("txtUsernameApply");
		String type = request.getParameter("txtPasswordApply");
		
		Employee employee = new Employee();
		employee.setFirstName(name);
		employee.setLastName(type);
		
		SystemDaoImpl employeeDaoImpl = new SystemDaoImpl();
		employeeDaoImpl.insertEmployee(employee);
		
		return "/html/Login.html";
	}

	public static String manRegister(HttpServletRequest request) {
		String name = request.getParameter("txtUsernameApply");
		String type = request.getParameter("txtPasswordApply");
		
		Employee employee = new Employee();
		employee.setFirstName(name);
		employee.setLastName(type);
		
		SystemDaoImpl employeeDaoImpl = new SystemDaoImpl();
		employeeDaoImpl.insertEmployee(employee);
		
		return "/html/Login.html";
	}
}
