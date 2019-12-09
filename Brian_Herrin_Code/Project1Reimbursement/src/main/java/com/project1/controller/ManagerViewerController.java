package com.project1.controller;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.dao.SystemDaoImpl;
import com.project1.model.Reimbursement;
import com.project1.model.SessionData;
//import com.project1.model.Users;

public class ManagerViewerController {
	public static String postManHistPage(HttpServletRequest request, HttpServletResponse response) {
		SystemDaoImpl sysImpl = new SystemDaoImpl();
		SessionData data = (SessionData)request.getSession().getAttribute("SessionData");
		data.setReimbursements(sysImpl.selectAllReimbursements()); 
		//System.out.println("postManHistPage SessionData: "+data.getUser().toString());
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(data));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "/html/ManagerHistoryViewer.html";
	}
	
	public static String postManTicketPage(HttpServletRequest request, HttpServletResponse response) {
		SystemDaoImpl sysImpl = new SystemDaoImpl();
		SessionData data = (SessionData)request.getSession().getAttribute("SessionData");
		data.setReimbursements( sysImpl.selectReimbursementPending() );
		//System.out.println("postManHistPage SessionData: "+data.getUser().toString());
		//System.out.println("postManHistPage SessionData: "+data.getReimbursements().toString());
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(data));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "/html/ManagerTicketViewer.html";
	}

	public static String getManHistTable(HttpServletRequest request, HttpServletResponse response) {
		SessionData data = (SessionData)request.getSession().getAttribute("SessionData");
		List<Reimbursement> reimbursements = data.getReimbursements();
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(reimbursements));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static String getManTicketTable(HttpServletRequest request, HttpServletResponse response) {
		SystemDaoImpl sysDaoImpl = new SystemDaoImpl();
		List<Reimbursement> pendingReimbursements = sysDaoImpl.selectReimbursementPending();
		//Users user = (Users)request.getAttribute("Users");
		SessionData data = (SessionData)request.getSession().getAttribute("SessionData");
		//System.out.println("Sess Username "+sessionData.getUser().getName());
		//System.out.println("Size of sess data reim list "+sessionData.getReimbursements().size());
		data.setReimbursements(pendingReimbursements);
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(data));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
