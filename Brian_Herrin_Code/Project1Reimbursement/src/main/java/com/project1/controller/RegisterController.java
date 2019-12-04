package com.project1.controller;

import javax.servlet.http.HttpServletRequest;

import com.project1.dao.PetDaoImpl;
import com.project1.model.Pet;

public class RegisterController {

	
	public static String Register(HttpServletRequest request) {
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		
		Pet pet = new Pet();
		pet.setName(name);
		pet.setType(type);
		
		PetDaoImpl petDaoImpl = new PetDaoImpl();
		petDaoImpl.insertPet(pet);
		
		return "/html/Login.html";
	}
}
