package com.project1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		case "/Project1Reimbursement/html/EmployeeUpdate.do":
			return ProfileController.empUpdate(request);
		case "/Project1Reimbursement/html/ManagerUpdate.do":
			return ProfileController.manUpdate(request);
		case "/Project1Reimbursement/html/EmployeeHistoryViewer.do":
			return EmployeeViewerController.postEmpHistPage(request, response);
		case "/Project1Reimbursement/html/EmpHistTable.do":
			return EmployeeViewerController.postEmpHistTable(request, response);
		case "/Project1Reimbursement/html/ManagerRecordsViewer.do":
			return ManagerViewerController.postManHistTable(request, response);
		default:
			return "/html/Index.html";
		}
	}

}
