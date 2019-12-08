package com.project1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project1.dao.SystemDaoImpl;

public class ApproveDenyReimbursementsController {
	public static String approve(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("value"));
		SystemDaoImpl expImpl = new SystemDaoImpl();
		expImpl.approveReimbursement(id);

		return "/html/ManagerTicketViewer.html";
	}

	public static String deny(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("value"));
		SystemDaoImpl expImpl = new SystemDaoImpl();
		expImpl.denyReimbursement(id);

		return "/html/ManagerTicketViewer.html";
	}
}


