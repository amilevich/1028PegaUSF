package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.dao.UserDaoImpl;
import com.example.model.Users;

public class LoginController {
	
	public static String Login(HttpServletRequest request) {
		String Username = request.getParameter("Username");
		String password = request.getParameter("password");
		
		
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		Users user = new Users();
		user = userDaoImpl.selectUserByUsername(Username);
		//we are retrieving an existing record by the pet's name
		//that the user provided on the login page
		//and we are storing it into a pet object
		
		if(Username.equals(user.getUsername()) && password.equals(user.getPassword())) {
			request.getSession().setAttribute("User", user);
			return "/html/Home.html";
		}
		
		return "/html/Login.html";
	}
}