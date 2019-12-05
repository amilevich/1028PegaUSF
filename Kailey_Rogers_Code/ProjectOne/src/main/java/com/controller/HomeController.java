package com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.users.Employees;

public class HomeController {

	public static String Home(HttpServletRequest request, HttpServletResponse response) {
		Employees employee = (Employees)request.getSession().getAttribute("Employees");
		
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(employee));
		}catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
