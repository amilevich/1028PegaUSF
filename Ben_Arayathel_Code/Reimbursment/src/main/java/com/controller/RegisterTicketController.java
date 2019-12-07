package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.BasicTicket;
import com.model.Ticket;
import com.model.User;

public class RegisterTicketController {

	public static String register(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, InstantiationException, IOException {
		HttpSession session = request.getSession();
		DAO dao = (DAO)session.getAttribute("dao");
		User u = (User)session.getAttribute("user");

		BasicTicket bt;
		Ticket t;
		
		PrintWriter out = response.getWriter();
		
		String str = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		System.out.println(str.toString());
		
		bt = new ObjectMapper().readValue(str, BasicTicket.class);
	
		
		System.out.println(bt.toString() + " ticket");
		
		
		if(dao == null || u == null) {
			System.out.printf("LOGIN FIRST");
			return "./login.html";
		}
		t = new Ticket(u.getEmail(), Double.valueOf(bt.getPrice()), bt.getDesc(), Byte.valueOf(bt.getTtype()), new Timestamp(System.currentTimeMillis()));
		if(!dao.storeTicket(t))  System.out.printf("STORE TICKET FAIL\n");
		
		System.out.println(t.toString());
		try {
			System.out.println(new ObjectMapper().writeValueAsString(t));
			
			response.getWriter().write(new ObjectMapper().writeValueAsString(t));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("console log error");
			e.printStackTrace();
		} 
		
		//return null;
		return new ObjectMapper().writeValueAsString(t);

}
}
