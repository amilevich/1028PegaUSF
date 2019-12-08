package com.project1.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.project1.dao.SystemDaoImpl;
import com.project1.model.Reimbursement;

public class LoadReimbursementController {
	public static String loadReimbById(HttpServletRequest request, HttpServletResponse response) {
		SystemDaoImpl expImpl = new SystemDaoImpl();
		List<Reimbursement> obj = new ArrayList<Reimbursement>();
		obj = expImpl.selectAllReimbursements();
		
		//Marshalling Tool
				//converting an object into a data format
				//in our case we are converting pet to JSON (Jackson)
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(obj));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "/html/ManagerHistoryViewer.html";
	}
}

