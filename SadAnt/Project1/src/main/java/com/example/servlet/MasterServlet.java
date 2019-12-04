package com.example.servlets;
/*
 * change the actual values being doPost and doGet
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlets extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			PrintWriter pWriter = response.getWriter();
			String fColor = "PurpleRedBlackBlue";
			pWriter.write("<h1>Hello</h1>");
			pWriter.write("<h2>My Favorite color is: " + fColor + "</h2>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//		//forward
//		request.getRequestDispatcher("Home.html").forward(request, response);
		
		//redirect
		response.sendRedirect("https://github.com/amilevich/1028PegaUSF/tree/SadAnt/SadAnt");
	}
	
}