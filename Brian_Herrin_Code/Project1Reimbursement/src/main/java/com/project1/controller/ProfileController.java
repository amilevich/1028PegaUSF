package com.project1.controller;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.dao.SystemDaoImpl;
import com.project1.model.SessionData;
import com.project1.model.Users;
public class ProfileController {
	public static String empUpdate(HttpServletRequest request) {
		SessionData data =  (SessionData)request.getSession().getAttribute("SessionData");
		//Users user =  (Users)request.getSession().getAttribute("Users");
		//Users user = new Users();
		//request.getSession().setAttribute("Users", user);
		//System.out.println("empUpdate Session User: " + data.getUser().toString());
		String password = request.getParameter("txtPasswordEdit");
		String firstname = request.getParameter("txtFirstNameEdit");
		String lastname = request.getParameter("txtLastNameEdit");
		String email = request.getParameter("txtEMailEdit");
		//System.out.println("empRegister textboxes: " + password + " " + firstname + " " + lastname + " " + email);
		Users emplo = new Users();
		emplo.setName(data.getUser().getName());
		if(password.contentEquals("")) {
			password = data.getUser().getPassword();
		} 
		if(password != null) {
				emplo.setPassword(password);
		} else {
			password = data.getUser().getPassword();
		}
		emplo.setUsersId(data.getUser().getUsersId());
		if(firstname.contentEquals("")) {
			firstname = data.getUser().getFirstName();
		} 
		if(firstname != null) {
				emplo.setFirstName(firstname);
		} else {
			firstname = data.getUser().getFirstName();
		}
		if(lastname.contentEquals("")) {
			lastname = data.getUser().getLastName();
		} 
		if(lastname != null) {
				emplo.setLastName(lastname);
		} else {
			lastname = data.getUser().getLastName();
		}
		if(email.contentEquals("")) {
			email = data.getUser().getEmail();
		} 
		if(email != null) {
				emplo.setEmail(email);
		} else {
			email = data.getUser().getEmail();
		}
		emplo.setRole(2);
		//System.out.println("empRegister: " + emplo.toString());
		data.setUser(emplo);
		//System.out.println("empRegister Finish: " + data.getUser().toString());
		SystemDaoImpl systemDaoImpl = new SystemDaoImpl();
		systemDaoImpl.updateUsers(data.getUser());
		
		return "/html/EmployeeMainMenu.html";
	}
	
	public static String manUpdate(HttpServletRequest request) {
		SessionData data =  (SessionData)request.getSession().getAttribute("SessionData");
		//Users user =  (Users)request.getSession().getAttribute("Users");
		//Users user = new Users();
		//request.getSession().setAttribute("Users", user);
		//System.out.println("empUpdate Session User: " + data.getUser().toString());
		String password = request.getParameter("txtPasswordEdit");
		String firstname = request.getParameter("txtFirstNameEdit");
		String lastname = request.getParameter("txtLastNameEdit");
		String email = request.getParameter("txtEMailEdit");
		//System.out.println("empRegister textboxes: " + password + " " + firstname + " " + lastname + " " + email);
		Users emplo = new Users();
		emplo.setName(data.getUser().getName());
		if(password.contentEquals("")) {
			password = data.getUser().getPassword();
		} 
		if(password != null) {
				emplo.setPassword(password);
		} else {
			password = data.getUser().getPassword();
		}
		emplo.setUsersId(data.getUser().getUsersId());
		if(firstname.contentEquals("")) {
			firstname = data.getUser().getFirstName();
		} 
		if(firstname != null) {
				emplo.setFirstName(firstname);
		} else {
			firstname = data.getUser().getFirstName();
		}
		if(lastname.contentEquals("")) {
			lastname = data.getUser().getLastName();
		} 
		if(lastname != null) {
				emplo.setLastName(lastname);
		} else {
			lastname = data.getUser().getLastName();
		}
		if(email.contentEquals("")) {
			email = data.getUser().getEmail();
		} 
		if(email != null) {
				emplo.setEmail(email);
		} else {
			email = data.getUser().getEmail();
		}
		emplo.setRole(1);
		//System.out.println("empRegister: " + emplo.toString());
		data.setUser(emplo);
		//System.out.println("empRegister Finish: " + data.getUser().toString());
		SystemDaoImpl systemDaoImpl = new SystemDaoImpl();
		systemDaoImpl.updateUsers(data.getUser());
		
		return "/html/ManagerMainMenu.html";
	}

	public static String postEmpProfile(HttpServletRequest request, HttpServletResponse response) {
		SessionData data = (SessionData)request.getSession().getAttribute("SessionData");
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(data));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "/html/EmployeeProfile.html";
	}

	public static String postManProfile(HttpServletRequest request, HttpServletResponse response) {
		SessionData data = (SessionData)request.getSession().getAttribute("SessionData");
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(data));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "/html/ManagerProfile.html";
	}
}