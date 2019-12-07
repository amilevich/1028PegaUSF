package com.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dao.DAO;
import com.model.User;

public class RegisterUserController {
	
	public static String register(HttpServletRequest request) {
	
	try {
		HttpSession session = request.getSession();
		DAO dao;
		User u;
		String first_name, last_name, email, password;
		if (session.getAttribute("dao") == null) session.setAttribute("dao", new DAO(true));
		dao = (DAO) session.getAttribute("dao");
		email = request.getParameter("email");
		first_name = request.getParameter("first_name");
		last_name = request.getParameter("last_name");
		password = request.getParameter("password");
		u = new User(email, password, first_name, last_name, false);
		dao.storeUser(u);
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.printf("%s\n", e.getMessage());
		return "./login.html";
	} catch (InstantiationException e) {
		e.printStackTrace();
		System.out.printf("%s\n", e.getMessage());
		return "./login.html";
	}
	return "./login.html";
	}

}
