package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.dao.UserDaoImpl;
import com.example.entitys.User;



public class LoginController {
	
	
	public static String Login(HttpServletRequest request) {
		
		
		String name = request.getParameter("inputName");
		String type = request.getParameter("inputPassword");

//		String name = request.getParameter("name");
//		String type = request.getParameter("type");

		
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User user = new User();
		user = userDaoImpl.find(name);
		
		System.out.println("pppppppppppppp " + user + " "+ name + " " + type);
		
		if((name.equals(user.getUsername()) || name.equals(user.getEmail())) && type.equals(user.getPassword())) {
			
			request.getSession().setAttribute("User", user);
			
			return user.getRole().getRole().equals("ADMIN")?"/html/home_manager.html":"/html/home_user.html";
		}
		
		return "/html/login.html";	

    }
	
}	
