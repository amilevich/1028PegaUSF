package com.project1.controller;

//import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import com.project1.dao.SystemDaoImpl;
import com.project1.model.Reimbursement;

public class StatusController {
	public static String update(HttpServletRequest request) {
		Reimbursement obj = (Reimbursement)request.getSession().getAttribute("Reimbursement");
		request.getSession().setAttribute("Reimbursement", obj);
		Timestamp dateResolved = Timestamp.valueOf(request.getParameter("dateResolved"));
		int status = Integer.parseInt(request.getParameter("status"));
		int id = Integer.parseInt(request.getParameter("id"));
		obj.setDateResolved(dateResolved);
		obj.setStatusId(status);
		obj.setId(id);
		SystemDaoImpl systemDaoImpl = new SystemDaoImpl();
		systemDaoImpl.updateReimbursement(obj);
		
		return "/html/SOMETHING.html";
	}
}