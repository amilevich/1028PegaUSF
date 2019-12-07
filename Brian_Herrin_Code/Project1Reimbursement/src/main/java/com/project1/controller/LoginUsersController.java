package com.project1.controller;
import javax.servlet.http.HttpServletRequest;
import com.project1.dao.SystemDaoImpl;
import com.project1.model.Users;
public class LoginUsersController {

	public static String Login(HttpServletRequest request) {
		//System.out.println(request.getParameterMap().size() + " " + request.getParameterMap().values());
		String name = request.getParameter("txtUsernameQuery");
		String password = request.getParameter("txtPasswordQuery");
		//System.out.println("Login name: "+ name + ", password: " + password);
		SystemDaoImpl sysImpl = new SystemDaoImpl();
		Users users = new Users();
		users = sysImpl.selectUsers(name);
		//we are retrieving an existing record by username
		//that the user provided on the login page
		//and we are storing it into a users object
		
		//System.out.println(users.getName()+" "+users.getPassword());
		
		
		if(name == null || password == null || name.equals("") || password.equals("")) {
			//System.out.println("LoginController: null values for name or password");
		} else if(name.equals(users.getName()) && password.equals(users.getPassword())) {
			request.getSession().setAttribute("Users", users);
			if(users.getRole()==1)
				return "/html/EmployeeMainMenu.html";
			else
				return "/html/ManagerMainMenu.html";
			
		}
		
		return "/html/Index.html";
	}

	public static String Logout(HttpServletRequest request) {
		
		return "/html/Index.html";
	}
}


