package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.dao.ERS_USERS_DAO_IMPL;
import com.pega.models.ERS_USERS;


public class LoginController {

	public static String Login(HttpServletRequest req) {

		String name = req.getParameter("name");
		String type = req.getParameter("type");
		ERS_USERS_DAO_IMPL p = new ERS_USERS_DAO_IMPL();
		ERS_USERS em = new ERS_USERS();
		//em = p.selectByUsername(name);
		
//		we are retrieving an existing record by the pets name that the 
//		user provided on the login page 
//		and we are storing it into a pet object
		
//		if(name.equals(pet.getName()) && type.equals(pet.getType())) {
//			return "/html/Home.html";
//		}
		return "html/Login.html";
	}
}
