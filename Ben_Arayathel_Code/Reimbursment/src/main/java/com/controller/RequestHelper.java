package com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public static String process(HttpServletRequest request, HttpServletResponse response) throws IOException, NumberFormatException, InstantiationException {
		switch(request.getRequestURI()) {
		
		case "/Reimbursment/html/Login.do":
			return LoginController.login(request);
			
		case "/Reimbursment/html/RegisterTicket.do":
			return RegisterTicketController.register(request, response);
			
//		case "/Reimbursment/html/SetStatus.do":
//			return SetStatusController.setStatus(request, response);
			
		default:
			return "./employee.html";
		}
	}

}
