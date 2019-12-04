package com.example.co;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class ServletConfigExample extends HttpServlet{

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet Config Example");
		String food = getInitParameter("favoriteFood");
		System.out.println("Favorite food is " + food);
		
		String dessert = getInitParameter("bestDessert");
		System.out.println("Best dessert is " + dessert);
		
		String db = getServletContext().getInitParameter("databaseUrl");
		System.out.println("here is the url again: " + db);
	}
}
