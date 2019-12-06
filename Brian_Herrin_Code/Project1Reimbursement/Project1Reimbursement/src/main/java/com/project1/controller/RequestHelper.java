package com.project1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	//the idea behind this class is to route requests 
	//based on the URI that comes along with the request
	
	public static String process(HttpServletRequest request, HttpServletResponse response) {
		
		switch(request.getRequestURI()) {
		case "/Project1Reimbursement/html/Login.do":
			return LoginController.Login(request);
		case "/Project1Reimbursement/html/EmployeeApply.do":
			return RegisterController.Register(request);
		case "/Project1Reimbursement/html/EmployeeUpdate.do":
			return ProfileController.Update(request);
		case "/Project1Reimbursement/html/EmpHistViewer.do":
			return EmployeeViewerController.Show(request);
		default:
			return "/html/Index.html";
		}
	}

}
