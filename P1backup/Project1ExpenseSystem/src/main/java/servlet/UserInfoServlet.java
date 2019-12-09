package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import expenseSysModels.FinanceManager;

public class UserInfoServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	    //FinanceManager manager = (FinanceManager)request.getSession().getAttribute("object");
	    request.getRequestDispatcher("header.html").include(request, response);
	 
        HttpSession session=request.getSession(false);  
        if(session!=null){  
        	FinanceManager manager =(FinanceManager)session.getAttribute("object");
            out.print("<h4>Hello, "+ manager.getUserName() +", Welcome to Profile.</h4>");
            request.getRequestDispatcher("ManagerHome.html").include(request, response);
        	
        }else {
        	out.print("Session empty.");  
        }
        
        
        
        
		out.close();

	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}

}
