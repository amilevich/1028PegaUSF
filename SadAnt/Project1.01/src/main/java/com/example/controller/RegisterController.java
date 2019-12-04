package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.dao.ERS_USERS_DAO_IMPL;
import com.pega.models.ERS_USERS;

public class RegisterController {

	public static String Register(HttpServletRequest request) {
		int id = 7;
		String userN = request.getParameter("username");
		String password = request.getParameter("password");
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String email = request.getParameter("email");
		int roleId = 1;

		ERS_USERS em = new ERS_USERS(id, userN, password, fName, lName, email, roleId);
		ERS_USERS_DAO_IMPL d = new ERS_USERS_DAO_IMPL();

		d.insertUser(em);
		System.out.println(em);
		return "/Login.html";
	}
}
