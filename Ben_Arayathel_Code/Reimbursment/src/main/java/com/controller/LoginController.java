package com.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dao.DAO;
import com.model.User;

public class LoginController {

	public static String login(HttpServletRequest request) {
		
		try {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			User u;
			DAO dao;
			HttpSession session;
			session = request.getSession();
			if(session.getAttribute("dao") == null) session.setAttribute("dao", new DAO(true));
			dao = (DAO)session.getAttribute("dao");
			u = dao.getUser(name);
			if(u == null) {
				System.out.printf("YOU DONT EXIST\n");
				return "./login.html";
			}
			if(!u.isPass(password)) {
				System.out.printf("WRONG PASSWORD\n");
				return "./login.html";
			}
			session.setAttribute("user", u);
			if(u.isAdvisor())return "./employee.html";
			else return "./employee.html";
		
			}catch(SQLException e) {
				e.printStackTrace();
				System.out.printf("%s\n", e.getMessage());
				return "./login.html";
			}
	}

}


//String name = request.getParameter("name");
//String password = request.getParameter("password");
//System.out.println(name);
//System.out.println(password);
////
////if(name == e.name && password == e.password){
////	return "/Reimbursment/html/employee.html";}
//
////else if(name == m.name && password == m.password{
////	return "/Reimbursment/html/manager.html";}
////
////else{
////	return "/Reimbursment/html/login.html";}
////
//if(name.equals("a") && password.equals("b")) {
//	
//	//request.getSession().setAttribute(arg0, arg1);
//	
//	return "./employee.html";
//} else {
//	
//	return "./login.html";
//}
//}