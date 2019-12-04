package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.dao.DaoImpl;
import com.example.main.Employee;


public class LoginController {

	public static String Login(HttpServletRequest req) {

		String name = req.getParameter("name");
		String type = req.getParameter("type");
		DaoImpl p = new DaoImpl();
		Employee em = new Employee();
		em = p.selectByUsername(name);
		
//		we are retrieving an existing record by the pets name that the 
//		user provided on the login page 
//		and we are storing it into a pet object
		
		if(name.equals(pet.getName()) && type.equals(pet.getType())) {
			return "/html/Home.html";
		}
		return "html/Login.html";
	}
}
