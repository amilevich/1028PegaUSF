package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		//Direct Response
		//PrintWriter
		PrintWriter pWriter = response.getWriter();
		String fColor = "PurpleRedBlackBlue";
		pWriter.write("<h1> HELLO </h1>");
		pWriter.write("<h2>My favorite color is: " + fColor + "</h2>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		//forward
		//request.getRequestDispatcher("Home.html").forward(request, response);
		
		//redirect
		response.sendRedirect("https://hackernoon.com/hn-images/1*qZoBA3wFh-82y2N3qQCdpw.jpeg");
	}
	
	
}
