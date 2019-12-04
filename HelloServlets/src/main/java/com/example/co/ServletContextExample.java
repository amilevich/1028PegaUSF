package com.example.co;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class ServletContextExample extends HttpServlet {
	
	@Override
	public void init() throws ServletException{
		System.out.println("Servlet Context Example");
		String db = getServletContext().getInitParameter("databaseUrl");
		System.out.println("Database URL is " + db);
	}

}
