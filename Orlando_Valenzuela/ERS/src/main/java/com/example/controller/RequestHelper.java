package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	public static String process(HttpServletRequest request, HttpServletResponse response) {
		
		switch(request.getRequestURI()) {
		
		case "/ERS/html/login.do":	
			
			return LoginController.Login(request);
			
		case "/ERS/html/manager.do":
			
			return ManagerController.Tickets(request, response);
				
		case "/ERS/html/manager_action.do":
			return ManagerController.Action(request, response);
					
		case "/ERS/html/user.do":
			return UserController.Tickets(request, response);
			
		case "/ERS/html/user_ticket.do":
			return UserController.NewTickets(request, response);			
		
		default:
			return "/html/login.html";
		}
	}	

}
