package controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import controller.ManagerProfileController;
import javax.servlet.http.HttpServletResponse;
import controller.EmpProfileController;
public class RequestHelper {
	
	public static void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		switch(request.getRequestURI()) {
		
		case "/Project1ExpenseSystem/Login.do":
			LoginController.Login(request, response);
			
		case "/Project1ExpenseSystem/Register.do":
			RegisterController.Register(request, response);
			
		case "/Project1ExpenseSystem/Home.do":
			HomeController.Home(request, response);

		case "/Project1ExpenseSystem/ViewAllReimbursements.do":
			ManagerProfileController.ViewAllReimbursements(request, response);

		case "/Project1ExpenseSystem/ApproveReimbursements.do":
			ManagerProfileController.ApproveReimbursements(request, response);

		case "/Project1ExpenseSystem/FilterByStatus.do":
			ManagerProfileController.FilterByStatus(request, response);

		case "/Project1ExpenseSystem/ViewPastTickets.do":
			EmpProfileController.ViewPastTickets(request, response);

		case "/Project1ExpenseSystem/AddReimbusementRequest.do":
			EmpProfileController.AddReimbusementRequest(request, response);
			
		default:

		}
	}
}