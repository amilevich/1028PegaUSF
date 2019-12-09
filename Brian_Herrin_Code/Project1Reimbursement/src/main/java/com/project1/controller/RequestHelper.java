package com.project1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project1.model.SessionData;

public class RequestHelper {
	
	//the idea behind this class is to route requests 
	//based on the URI that comes along with the request
	
	public static String process(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("RequestHelper request: " + request.getRequestURI());
		switch(request.getRequestURI()) {
		case "/Project1Reimbursement/html/Login.do":
			return LoginUsersController.Login(request);
		case "/Project1Reimbursement/html/Logout.do":
			return LoginUsersController.Logout(request);
		case "/Project1Reimbursement/html/EmployeeApply.do":
			return RegisterController.empRegister(request);
		case "/Project1Reimbursement/html/ManagerApply.do":
			return RegisterController.manRegister(request);
		case "/Project1Reimbursement/html/EmployeeProfile.do":
			return ProfileController.postEmpProfile(request, response);
		case "/Project1Reimbursement/html/ManagerProfile.do":
			return ProfileController.postManProfile(request, response);
		case "/Project1Reimbursement/html/EmployeeUpdate.do":
			return ProfileController.empUpdate(request);
		case "/Project1Reimbursement/html/ManagerUpdate.do":
			return ProfileController.manUpdate(request);
		case "/Project1Reimbursement/html/EmployeeHistoryViewer.do":
			return EmployeeViewerController.postEmpHistPage(request, response);
		case "/Project1Reimbursement/html/ManagerHistoryViewer.do":
			return ManagerViewerController.postManHistPage(request, response);
		case "/Project1Reimbursement/html/EmpHistTable.do":
			return EmployeeViewerController.getEmpHistTable(request, response);
		case "/Project1Reimbursement/html/postEmpHistTable.do":
			return EmployeeViewerController.postEmpHistPage(request, response);
		case "/Project1Reimbursement/html/ManHistTable.do":
			return ManagerViewerController.getManHistTable(request, response);
		case "/Project1Reimbursement/html/ManagerTicketViewer.do":
			return ManagerViewerController.postManTicketPage(request, response);
		case "/Project1Reimbursement/html/ManTicketTable.do":
			return ManagerViewerController.getManTicketTable(request, response);
		case "/Project1Reimbursement/html/ManTicketApprove.do":
			return ApproveDenyReimbursementsController.approve(request, response);
		case "/Project1Reimbursement/html/ManTicketDeny.do":
			return ApproveDenyReimbursementsController.deny(request, response);
		default:
			return "/html/Index.html";
		}
	}

}
