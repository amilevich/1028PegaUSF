package Reimbursement;

import javax.servlet.http.HttpServletRequest;

public class LoginController {

	public static String login(HttpServletRequest request) {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
//		
//		if(name == e.name && password == e.password){
//			return "/Reimbursment/html/employee.html";}
		
//		else if(name == m.name && password == m.password{
//			return "/Reimbursment/html/manager.html";}
//		
//		else{
//			return "/Reimbursment/html/login.html";}
//		
		
		return "P1/html/login.html";
	}

}
