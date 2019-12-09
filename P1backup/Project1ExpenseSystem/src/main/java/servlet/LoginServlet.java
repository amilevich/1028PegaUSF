package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import expenseSysModels.Employee;
import expenseSysModels.FinanceManager;

public class LoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	    request.getRequestDispatcher("header.html").include(request, response);

        HttpSession session=request.getSession(false);  
        if(session!=null){  
        	Employee emp =(Employee)session.getAttribute("object");
            out.print("<h4>Hello, "+ emp.getUserName() +", Welcome to Profile.</h4>");
            request.getRequestDispatcher("EmployeeHome.html").include(request, response);
        	
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
