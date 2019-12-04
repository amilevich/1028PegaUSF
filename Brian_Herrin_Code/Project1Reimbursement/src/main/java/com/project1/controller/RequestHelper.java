package com.project1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	//the idea behind this class is to route requests 
	//based on the URI that comes along with the request
	
	public static String process(HttpServletRequest request, HttpServletResponse response) {
		
		switch(request.getRequestURI()) {
		
		case "/PetsFrontController/html/Login.do":
			return LoginController.Login(request);
			
		case "/PetsFrontController/html/Register.do":
			return RegisterController.Register(request);
			
		case "/PetsFrontController/html/Home.do":
			return HomeController.Home(request, response);
			
		default:
			return "/html/Login.html";
		}
	}

}
