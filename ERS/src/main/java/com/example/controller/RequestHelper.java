package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	public static String process(HttpServletRequest request, HttpServletResponse response) {
		
		switch(request.getRequestURI()) {
		
		case "/ERS/html/login.do":
			
			System.out.println("/ERS/html/login.do");
			return LoginController.Login(request);
	/*		
		case "/ERS/html/register.do":
			return RegisterController.Register(request);
			
		case "/ERS/html/home_user.do":
			return HomeController.Home(request, response);
					
		case "/ERS/html/home_manager.do":
			return HomeController.Home(request, response);			
		*/	
		default:
			return "/html/login.html";
		}
	}	

}
