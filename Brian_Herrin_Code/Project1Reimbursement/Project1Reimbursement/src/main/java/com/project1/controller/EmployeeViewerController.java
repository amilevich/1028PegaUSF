package com.project1.controller;

import javax.servlet.http.HttpServletRequest;

import com.project1.dao.SystemDaoImpl;
import com.project1.model.Employee;

public class EmployeeViewerController {
	public static String Show(HttpServletRequest request) {
		Employee employee = (Employee)request.getSession().getAttribute("Employee");
		//getting the attribute from the session that was set upon
		//login in LoginController
		
		String type = request.getParameter("txtPasswordQuery");
		employee.setFirstName(type);
		
		SystemDaoImpl sysDaoImpl = new SystemDaoImpl();
		sysDaoImpl.updateEmployee(employee);
		
		return "/html/EmployeeHistoryViewer.html";
	}
}
