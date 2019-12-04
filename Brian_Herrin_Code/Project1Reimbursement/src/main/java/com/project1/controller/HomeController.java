package com.project1.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.model.Pet;

public class HomeController {

	public static String Home(HttpServletRequest request, HttpServletResponse response) {
		//retrieving the pet object from our session
		Pet pet = (Pet)request.getSession().getAttribute("Pet");
		
		//Marshalling Tool
		//converting an object into a data format
		//in our case we are converting pet to JSON (Jackson)
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(pet));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
