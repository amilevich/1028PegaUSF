package com.project1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project1.model.Reimbursement;

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
			try {
				List Reimbursement reimbursement;
				
				return EmployeeViewerController.Show(reimbursement, response);
			} catch (ServletException e) {
				e.printStackTrace();
				return "/html/Index.html";
			} catch (IOException e) {
				e.printStackTrace();
				return "/html/Index.html";
			}
		default:
			return "/html/Index.html";
		}
	}

}
