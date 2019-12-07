package com.project1.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.project1.dao.SystemDaoImpl;
import com.project1.model.Reimbursement;
import com.project1.model.Users;

public class ManagerViewerController {
	public static String Show(HttpServletRequest request, HttpServletResponse response) {
		SystemDaoImpl sysDaoImpl = new SystemDaoImpl();
		Users userLoggedIn = (Users)request.getSession().getAttribute("Users");
		List<Reimbursement> reimbursements = sysDaoImpl.selectEmployeeReimbursementsById(sysDaoImpl.selectEmployeeByName(userLoggedIn.getName()).getUserId());
		// For Reimbursement Table
		PrintWriter pWriter;
		try {
			pWriter = response.getWriter();
			for(int i = 0; i < reimbursements.size(); i++){
				pWriter.write("<tr><td>" + reimbursements.get(i).getAmount() + "</td>");
				pWriter.write("<td>"+ reimbursements.get(i).getStatusId() + "</td>");
				pWriter.write("<td>" + reimbursements.get(i).getTypeId() + "</td>");
				pWriter.write("<td>" + reimbursements.get(i).getDescription() + "</td>");
				pWriter.write("<td>" + reimbursements.get(i).getReceipt() + "</td>");
				pWriter.write("<td>" + reimbursements.get(i).getDateSubmitted() + "</td>");
				pWriter.write("<td>" + reimbursements.get(i).getDateResolved() + "</td></tr>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "/html/ManagerHistoryViewer.html";
	}
}
