package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public static String process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
		case "/Reimbursment/html/Login.do":
			return LoginController.login(request);
		case "/Reimbursment/html/RegisterTicket.do":
			return RegisterTicketController.register(request);
		case "/Reimbursment/html/SetStatus.do":
			return SetStatusController.setStatus(request);
		default:
			return "/Reimbursment/html/login.html";
		}
	}

}
