package ExpenseSysControllers;

import javax.servlet.http.HttpServletRequest;
import ExpenseSysDao.UsersDaoImp;
import ExpenseSysModels.User;

public class LoginController {
	
	public static String Login(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		String pass = request.getParameter("pass");
		
		UsersDaoImp usersDaoImp = new UsersDaoImp();
		User user = usersDaoImp.selectUserByUserName(userName);
		//retrieving an existing record by name that the user provided on the login page and stored it into a pet object
		
		if(userName.contentEquals(user.getUserName()) && pass.equals(user.getPassword()) && user.getRole()==1) {
			request.getSession().setAttribute("User",  user);	//setting the session to the current logged in user
			return "/html/FinManHome.html";
		} else if (userName.contentEquals(user.getUserName()) && pass.equals(user.getPassword())) {
			request.getSession().setAttribute("User",  user);	//setting the session to the current logged in user
			return "/html/EmpHome.html";
		}
		else return "/Login.html";
	}

}
