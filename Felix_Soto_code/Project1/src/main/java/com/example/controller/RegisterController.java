package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.dao.UserDaoImpl;
import com.example.model.Users;

public class RegisterController {

	public static String Register(HttpServletRequest request) {
		String Username = request.getParameter("Username");
		String password = request.getParameter("password");
		
		Users user = new Users();
		user.setUsername(Username);
		user.setPassword(password);

		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.insertUser(user);
		System.out.println(user);
		return "/html/Login.html";
	}
}