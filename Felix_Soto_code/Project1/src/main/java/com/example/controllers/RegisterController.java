package com.example.controllers;

import javax.servlet.http.HttpServletRequest;

import com.example.dao.EmployeeDaoImpl;
import com.example.ers.Employee;

public class RegisterController {

	public static String Register(HttpServletRequest request) {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String type = request.getParameter("type");
		
		Employee emplo = new Employee();
		emplo.setUsedId(0);
		emplo.setFirstName(firstname);
		emplo.setLastName(lastname);
		emplo.setUsername(username);
		emplo.setPassword(password);
		emplo.setEmail(email);
		emplo.setType(type);

		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		employeeDaoImpl.insertEmployee(emplo);
		System.out.println(emplo);
		return "/html/Login.html";
	}
}