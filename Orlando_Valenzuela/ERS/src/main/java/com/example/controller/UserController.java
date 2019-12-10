package com.example.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.example.dao.ReimburstmentDaoImpl;
import com.example.dao.StatusDaoImpl;
import com.example.dao.TypeDaoImpl;
import com.example.entitys.Reimburstment;
import com.example.entitys.Status;
import com.example.entitys.Type;
import com.example.entitys.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserController {
	
	final static Logger loggy = Logger.getLogger(UserController.class);
	
	public static String Tickets(HttpServletRequest request, HttpServletResponse response) {
		
		loggy.info("inside Tickets UserController");
		
	    ArrayList<Reimburstment> list;
		
	    User user = (User)request.getSession().getAttribute("User");
		ReimburstmentDaoImpl reimburstmentDaoImpl = new ReimburstmentDaoImpl();
		
		list = reimburstmentDaoImpl.findAll(user);
		
		
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(list));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "/html/home_user.html";	
    }
	
	public static String NewTickets(HttpServletRequest request, HttpServletResponse response) {
		
		loggy.info("inside NewTickets UserController");
		
	    User user = (User)request.getSession().getAttribute("User");
		float inputAmount = Float.parseFloat(request.getParameter("inputAmount"));
		String inputType = request.getParameter("inputType");
		String description = request.getParameter("textDescription");
		//Blob file =  (Blob)request.getParameter("receiptFile");
				
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		StatusDaoImpl statusDaoImpl = new StatusDaoImpl();
		TypeDaoImpl typeDaoImpl = new TypeDaoImpl(); 
		Status status = statusDaoImpl.find("PENDING");
		Type type = typeDaoImpl.find(inputType);
		
		ReimburstmentDaoImpl reimburstmentDaoImpl = new ReimburstmentDaoImpl();	
		reimburstmentDaoImpl.insert(new Reimburstment(0, inputAmount, ts, null, description, null, null, status, type, user));
		
		return "/html/home_user.html";	
    }		

}
