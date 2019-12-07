package com.example.controllers;

import javax.servlet.http.HttpServletRequest;

import com.example.dao.EmployeeDaoImpl;
import com.example.ers.Employee;

public class LoginController {

	public static String Login(HttpServletRequest request) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		EmployeeDaoImpl empImpl = new EmployeeDaoImpl();
		Employee emp = new Employee();
		emp = empImpl.selectEmployeeByUsername(username);
		request.getSession().setAttribute("employee", emp);
		System.out.println(emp);
		String type = emp.getType();

		if (type.equals("Employee")) {
			if (username.equals(emp.getUsername()) & password.equals(emp.getPassword())) {
				return "/html/EmployeeHome.html";
			}
		} else if (type.equals("Manager")) {
			if (username.equals(emp.getUsername()) & password.equals(emp.getPassword())) {
				return "/html/AdminHome.html";
			}
		}
		return "/html/Login.html";
	}
}