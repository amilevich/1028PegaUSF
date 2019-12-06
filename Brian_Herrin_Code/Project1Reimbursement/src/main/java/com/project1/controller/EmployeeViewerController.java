package com.project1.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import com.project1.dao.SystemDaoImpl;
import com.project1.model.Employee;
import com.project1.model.Reimbursement;

public class EmployeeViewerController {
	public static String Show(Reimbursement[] resultSet, HttpServletResponse response) throws ServletException, IOException {
			// Show Employee Name
			// For Reimbursement Table
			PrintWriter pWriter = response.getWriter();
			for(int i = 0; i < resultSet.length; i++){
				pWriter.write("<tr><td>"+resultSet[i].getAmount() + "</td>");
				pWriter.write("<td>"+ resultSet[i].getStatus() + "</td>");
				pWriter.write("<td>" + resultSet[i].getExpense() + "</td>");
				pWriter.write("<td>" + resultSet[i].getDescription() + "</td>");
				pWriter.write("<td>" + resultSet[i].getImageData() + "</td>");
				pWriter.write("<td>" + resultSet[i].getDateSubmitted() + "</td>");
				pWriter.write("<td>" + resultSet[i].getDateResolved() + "</td></tr>");
			}
		return "/html/EmployeeHistoryViewer.html";
	}
}
