package controller;
import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import expenseSysDao.UsersDaoImp;
import expenseSysModels.Employee;
import expenseSysModels.FinanceManager;
import expenseSysModels.User;

public class LoginController {
	
	final static Logger activityLog= Logger.getLogger(LoginController.class);
	
	public static void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("id");
		String password = request.getParameter("password");
		
		UsersDaoImp usersDaoImp = new UsersDaoImp();
		User user = usersDaoImp.selectUserByUserName(userName);
		
		 if (userName.equals(user.getUserName()) && password.equals(user.getPassword()) && user.getRole()==1){
			 	FinanceManager manager = new FinanceManager(user); 
		        request.getSession().setAttribute("role", "manager");
				request.getSession().setAttribute("object", manager);
				//String targetURL = "/ManagerHome.html";
				request.getRequestDispatcher("UserInfoServlet").forward(request, response);
				System.out.println("#Forward to ManagerHome success.#");
				
				activityLog.info("Finance Manager "+userName+" logged in.");
				
		 }else if (userName.equals(user.getUserName()) && password.equals(user.getPassword())){
			request.getSession().setAttribute("role", "employee");
			Employee emp = new Employee(user);
			request.getSession().setAttribute("object", emp);
			request.getRequestDispatcher("LoginServlet").forward(request, response);
			System.out.println("#Forward to EmployeeHome success.#");
			
			activityLog.info("Employee "+userName+" logged in.");

		 } else {
			activityLog.warn("There was a failed login attempt using "+userName+" as the user name.");
			 System.out.println("#Unable to process forward.#");
		 }
	}

}