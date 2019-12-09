package expenseSysControllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import expenseSysControllers.EmpProfileController;
import expenseSysControllers.ManagerProfileController;
public class RequestHelper {
	
	public static String process(HttpServletRequest request, HttpServletResponse response) {
		
		switch(request.getRequestURI()) {
		
		case "/Project1ExpenseSystem/Login.do":
			return LoginController.Login(request);
			
		case "/Project1ExpenseSystem/Home.write":
			return HomeController.Home(request, response);
			
		case "/Project1ExpenseSystem/Register.do":
			return RegisterController.Register(request, response);
			
		case "/Project1ExpenseSystem/ViewAllReimbursements.write":
			ManagerProfileController.ViewAllReimbursements(request, response);
			
		case "/Project1ExpenseSystem/ApproveReimbursements.write":
			ManagerProfileController.ApproveReimbursements(request, response);
			
		case "/Project1ExpenseSystem/FilterByStatus.write":
			ManagerProfileController.FilterByStatus(request, response);
			
		case "/Project1ExpenseSystem/ViewPastTickets.write":
			EmpProfileController.ViewPastTickets(request, response);
			
		case "/Project1ExpenseSystem/AddReimbusementRequest.write":
			EmpProfileController.AddReimbusementRequest(request, response);
			
		default:
			return "/Login.html";
		}
	}
}