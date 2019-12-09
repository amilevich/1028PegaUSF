package com.project1.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.dao.SystemDaoImpl;
import com.project1.model.Reimbursement;
import com.project1.model.SessionData;
import com.project1.model.Users;

public class EmployeeViewerController {
	public static String postEmpHistPage(HttpServletRequest request, HttpServletResponse response) {
		SystemDaoImpl sysImpl = new SystemDaoImpl();
		SessionData data = (SessionData)request.getSession().getAttribute("SessionData");
		//System.out.println(data.getUser().toString());
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		reimbursements = sysImpl.selectReimbursementsByUsersId(data.getUser().getUsersId());
		
		request.getSession().setAttribute("SessionData", data);
		
		return "/html/EmployeeHistoryViewer.html";
	}
	public static String getEmpHistTable(HttpServletRequest request, HttpServletResponse response) {
		SessionData data = (SessionData)request.getSession().getAttribute("SessionData");
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
