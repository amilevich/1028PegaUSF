package com.example.controller;



import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



public class RequestHelper {

	

	//the idea behind this class is to route requests 

	//based on the URI that comes along with the request

	

	public static String process(HttpServletRequest request, HttpServletResponse response) {

		

		switch(request.getRequestURI()) {

		

		case "/Project1/html/Login.do":

			return LoginController.Login(request);

			

		case "/Project1/html/Register.do":
System.out.println("in request helper");
			return RegisterController.Register(request);

			

		case "/Project1/html/Home.do":

			return HomeController.Home(request, response);

			

		default:

			return "/html/Login.html";

		}

	}
}