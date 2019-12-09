package com.project1.controller;

import java.io.IOException;
//import java.sql.Blob;
//import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.project1.dao.SystemDaoImpl;
import com.project1.model.Reimbursement;
import com.project1.model.SessionData;

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

	public static String makeReimbursement(HttpServletRequest request, HttpServletResponse response) {
		SessionData data = (SessionData)request.getSession().getAttribute("SessionData");
		SystemDaoImpl expImpl = new SystemDaoImpl();
		String stringType = request.getParameter("radioTypes");
		int intType=4;
		if(stringType.contentEquals("1")) {
			intType=1;
		} else if(stringType.contentEquals("2")) {
			intType=2;
		} else if(stringType.contentEquals("3")) {
			intType=3;
		} else {
			intType=4;
		} 
		Double dAmount = Double.parseDouble(request.getParameter("txtAmountQuery"));
		String description = request.getParameter("ReimDescriptionText");
		//String stringReceipt = request.getParameter("upLoadBanner");
		//Blob receipt = (Blob)stringReceipt;
		Reimbursement r = new Reimbursement(0, dAmount, null, description, /*Blob*/null, data.getUser().getUsersId(), 1, intType);
		expImpl.insertReimbursement(r);
		
		return "/html/EmployeeReimbursementForm.html";
	}
}

