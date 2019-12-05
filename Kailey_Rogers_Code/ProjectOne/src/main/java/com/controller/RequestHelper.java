package com.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	public static String process(HttpServletRequest request, HttpServletResponse response){
		
		switch(request.getRequestURI()) {
		
		case "/ProjectOne/Login.do":
			return LoginController.Login(request);
			
		case "/ProjectOne/Register.do":
			return RegisterController.Register(request);
			
		case "/ProjectOne/Home.do":
			return HomeController.Home(request, response);
			
		default:
			return "/main.html";
		}
	}


}
