package com.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DAO;
import com.model.Ticket;
import com.model.User;

public class RegisterTicketController {

	public static String register(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, InstantiationException {
		HttpSession session = request.getSession();
		DAO dao = (DAO)session.getAttribute("dao");
		User u = (User)session.getAttribute("user");
//		String type = request.getParameter("ttype");
		String type = "0";
		String price = request.getParameter("price");
		String description = request.getParameter("Description");
		Ticket t;
		
		System.out.println(dao);
		System.out.println(u);
		System.out.println(type);
		System.out.println(price);
		System.out.println(description);
		
		if(dao == null || u == null) {
			System.out.printf("LOGIN FIRST");
			return "./login.html";
		}
		t = new Ticket(u.getEmail(), Double.valueOf(price), description, Byte.valueOf(type), new Timestamp(System.currentTimeMillis()));
		if(!dao.storeTicket(t))  System.out.printf("STORE TICKET FAIL\n");
		
		return "./employee.html";

}
}
