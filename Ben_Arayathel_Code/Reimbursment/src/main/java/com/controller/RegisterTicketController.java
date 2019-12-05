package com.controller;

import javax.servlet.http.HttpServletRequest;

public class RegisterTicketController {

	public static String register(HttpServletRequest request) {
		String type = request.getParameter("ttype");
		System.out.println(request.getParameter("ttype"));
		
		String price = request.getParameter("number");
		System.out.println(request.getParameter("price").toString());
		
		String description = request.getParameter("Description");
		System.out.println(request.getParameter("Description"));
		
		return "employee.html";
	}

}
