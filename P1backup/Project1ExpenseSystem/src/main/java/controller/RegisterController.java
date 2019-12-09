package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import expenseSysDao.ReimbursementDaoImp;
import expenseSysDao.UsersDaoImp;
import expenseSysModels.Employee;
import expenseSysModels.User;

public class RegisterController {
	
	final static Logger activityLog= Logger.getLogger(RegisterController.class);
	
	public static void Register(HttpServletRequest request, HttpServletResponse response) {
		UsersDaoImp userDao = new UsersDaoImp();
		
		String password = request.getParameter("password");
		String userName = request.getParameter("userName");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");;
		String email = request.getParameter("email");
		String str_role = request.getParameter("role");
		int role = Integer.parseInt(str_role);
			
		
		if (role == 1) {
			User user = new User(userName, password, firstName, lastName, email, role); 
			//Employee emp = new Employee(userName, password, firstName, lastName, email);
			userDao.insertUser(user);
			activityLog.info("New Employee user created with a user name of "+ userName+ " for "+ firstName + " " + lastName);
		} else {
			User user = new User(userName, password, firstName, lastName, email, role); 
			userDao.insertUser(user);
			activityLog.info("New Finance Manager user created with a user name of "+ userName+ " for "+ firstName + " " + lastName);
		}		
	}
}
