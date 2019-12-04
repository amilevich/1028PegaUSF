package com.example.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.main.Pet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HomeController {

	public static String Home(HttpServletRequest req, HttpServletResponse res) {
		//retrieve the pet object from our session
		
		Pet pet = (Pet)req.getSession().getAttribute("Pet");
		
		//Marshalling Tool
		//converting an object into a data format
		//in our case we are converting pet to JSON(Jackson)
		
		try {
			res.getWriter().write(new ObjectMapper().writeValueAsString(pet));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
