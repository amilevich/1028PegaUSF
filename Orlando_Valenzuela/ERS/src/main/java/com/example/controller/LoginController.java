package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.example.dao.UserDaoImpl;
import com.example.entitys.User;

public class LoginController {
	
	final static Logger loggy = Logger.getLogger(LoginController.class);
	
	public static String Login(HttpServletRequest request) {
		
		loggy.info("inside Login LoginController");
		
		String name = request.getParameter("inputName");
		String type = request.getParameter("inputPassword");
		
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User user = new User();
		user = userDaoImpl.find(name);
		
		
		if(user != null && (name.equals(user.getUsername()) || name.equals(user.getEmail())) && type.equals(user.getPassword())) {
			
			request.getSession().setAttribute("User", user);
			
			return user.getRole().getRole().equals("ADMIN")?"/html/home_manager.html":"/html/home_user.html";
		}
		
		return "/html/login.html";	

    }
	
}	
