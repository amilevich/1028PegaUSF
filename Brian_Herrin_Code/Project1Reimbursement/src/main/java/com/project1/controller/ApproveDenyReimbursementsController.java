package com.project1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project1.dao.SystemDaoImpl;
import com.project1.model.SessionData;
import com.project1.model.Users;

public class ApproveDenyReimbursementsController {
	public static String approve(HttpServletRequest request, HttpServletResponse response) {
		SessionData data = (SessionData)request.getSession().getAttribute("SessionData");
		int id = Integer.parseInt(request.getParameter("txtApproveReimbursement"));
		//System.out.println("approve id: " + id);
		System.out.println("approve usersId: " + data.getUser().toString());
		SystemDaoImpl expImpl = new SystemDaoImpl();
		//expImpl.approveReimbursement(id);
		expImpl.updateReimbursement(data.getUser().getUsersId(), 2, id);
		
		return "/html/ManagerTicketViewer.html";
	}

	public static String deny(HttpServletRequest request, HttpServletResponse response) {
		Users users = (Users)request.getAttribute("Users");
		int id = Integer.parseInt(request.getParameter("txtDenyReimbursement"));
		//System.out.println("deny id " + id);
		SystemDaoImpl expImpl = new SystemDaoImpl();
		//expImpl.denyReimbursement(id);
		expImpl.updateReimbursement(users.getUsersId(), 3, id);
		return "/html/ManagerTicketViewer.html";
	}
}


