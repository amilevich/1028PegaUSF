package com.example.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.example.dao.ReimburstmentDaoImpl;
import com.example.dao.StatusDaoImpl;
import com.example.entitys.Reimburstment;
import com.example.entitys.Status;
import com.example.entitys.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ManagerController {
	
	final static Logger loggy = Logger.getLogger(ManagerController.class);
	
	public static String Tickets(HttpServletRequest request, HttpServletResponse response) {
		
		loggy.info("inside Tickets ManagerController");
		
	    ArrayList<Reimburstment> list;
		
		
		ReimburstmentDaoImpl reimburstmentDaoImpl = new ReimburstmentDaoImpl();
		
		list = reimburstmentDaoImpl.findAll();
		
		
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(list));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "/html/home_manager.html";	

    }
	
	public static String Action(HttpServletRequest request, HttpServletResponse response) {
		
		loggy.info("inside Action ManagerController");
	
		int id = Integer.parseInt(request.getParameter("id"));
		String action = request.getParameter("value");
		User user = (User)request.getSession().getAttribute("User");
		request.getSession().setAttribute("User", user);

		StatusDaoImpl  statusDaoImpl = new StatusDaoImpl();		
		ArrayList<Status> status = statusDaoImpl.findAll();
		
		Status stup = null;
		for(Status x :status)	
		   if(x.getStatus().equals(action))
			   stup = x;
		
		if (stup != null) {
			
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			
			Reimburstment reimb = new Reimburstment(id, 0, null, ts, null, null, user, stup, null, null);
			
			ReimburstmentDaoImpl reimburstmentDaoImpl = new ReimburstmentDaoImpl();
			reimburstmentDaoImpl.update(reimb);
			
			try {
				response.getWriter().write(new ObjectMapper().writeValueAsString(new Boolean(true)));
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
				
		return "/html/home_manager.html";	

    }

}
