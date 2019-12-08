package com.project1.controller;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.project1.dao.SystemDaoImpl;
//import com.project1.model.Employee;
import com.project1.model.Reimbursement;
//import com.project1.model.Users;

public class EmployeeViewerController {
	public static String postEmpHistPage(HttpServletRequest request, HttpServletResponse response) {
		
		return "/html/EmployeeHistoryViewer.html";
	}
	public static String getEmpHistTable(HttpServletRequest request, HttpServletResponse response) {
		List<Reimbursement> reimbursements = (List<Reimbursement>)request.getSession().getAttribute("Reimbursements");
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(reimbursements));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
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
	/*
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
  res.setContentType("text/html");
  OutputStream o=res.getOutputStream();
  o.write(("<html>\n").getBytes());
  o.write(("\t<head>\n").getBytes());
  o.write(("\t<title>Applets</title>\n").getBytes());
  o.write(("\t</head>\n").getBytes());
  o.write(("\t<body>\n").getBytes());
  o.write(("\tOverview:<br>\n").getBytes());
  for (  CompileUnit applet : server.appletCompiler.getApplets()) {
    String filename=applet.getJarName().substring(applet.getJarName().lastIndexOf("/") + 1);
    o.write(("\t\t<APPLET codebase='data/' code='" + applet.mainClass.replace(".","/") + ".class' archive='"+ filename+ "'></APPLET><br/>\n").getBytes());
  }
  o.write(("\t</body>\n").getBytes());
  o.write(("</html>\n").getBytes());
  o.flush();
  o.close();
}
	*/
}
