package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


import com.example.controller.RequestHelper;

public class MasterServlet  extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final static Logger loggy = Logger.getLogger(MasterServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		RequestHelper.process(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		
		String targetURL = RequestHelper.process(req, res);
		req.getRequestDispatcher(targetURL).forward(req, res);
		//chose to respond with a forward for every POST request
	}
}
