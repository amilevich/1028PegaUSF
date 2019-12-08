package com.project1.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.dao.SystemDaoImpl;
//import com.project1.model.Employee;
import com.project1.model.Reimbursement;
import com.project1.model.Users;

public class EmployeeViewerController {
	public static String postEmpHistPage(HttpServletRequest request, HttpServletResponse response) {
		
		return "/html/EmployeeHistoryViewer.html";
	}
	public static String postEmpHistTable(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getParameterMap().size() + " " + request.getParameterValues("EmpHistoryViewerTable"));
		SystemDaoImpl sysDaoImpl = new SystemDaoImpl();
		Users usersLoggedIn = (Users)request.getSession().getAttribute("Users");
		List<Reimbursement> reimbursements = sysDaoImpl.selectReimbursementsByUsersId(sysDaoImpl.selectUsers(usersLoggedIn.getName()).getUsersId());
		
		// For Reimbursement Table
		PrintWriter pWriter;
		/*
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(reimbursements));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
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
		return "/html/EmployeeHistoryViewer.html";
	}
	/*
	public static String Show(HttpServletRequest request, HttpServletResponse response) {
		SystemDaoImpl sysDaoImpl = new SystemDaoImpl();
		Employee employeeLoggedIn = (Employee)request.getSession().getAttribute("Employee");
		List<Reimbursement> reimbursements = sysDaoImpl.selectEmployeeReimbursementsById(sysDaoImpl.selectEmployeeByName(employeeLoggedIn.getUserName()).getUserId());
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
		
		return "/html/EmployeeHistoryViewer.html";
	}
	*/
}