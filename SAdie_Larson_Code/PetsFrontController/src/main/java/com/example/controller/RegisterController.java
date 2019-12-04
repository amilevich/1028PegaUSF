package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.dao.DaoImpl;
import com.example.main.Pet;

public class RegisterController {
	public static String Register(HttpServletRequest req) {

		String name = req.getParameter("name");
		String type = req.getParameter("type");
		Pet pet = new Pet();
		pet.setName(name);
		pet.setType(type);

		DaoImpl p = new DaoImpl();
		p.insertPet(pet);
		
		return "html/Login.html";		
	}

}
