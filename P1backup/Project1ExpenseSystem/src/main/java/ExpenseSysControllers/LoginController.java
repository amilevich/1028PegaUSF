package expenseSysControllers;

import javax.servlet.http.HttpServletRequest;
import expenseSysDao.UsersDaoImp;
import expenseSysModels.Employee;
import expenseSysModels.FinanceManager;
import expenseSysModels.User;

public class LoginController {
	
	public static String Login(HttpServletRequest request) {
		String userName = request.getParameter("id");
		String password = request.getParameter("password");
		
		UsersDaoImp usersDaoImp = new UsersDaoImp();
		User user = usersDaoImp.selectUserByUserName(userName);
		
		 if (userName.equals(user.getUserName()) && password.equals(user.getPassword()) && user.getRole()==1){
			 	FinanceManager manager = new FinanceManager(user); 
				request.getSession().setAttribute("role", "manager");
				request.getSession().setAttribute("object", manager);
				return "/ManagerHome.html";
		 }else{
			request.getSession().setAttribute("role", "employee");
			Employee emp = new Employee(user);
			request.getSession().setAttribute("object", emp);
			return "/EmployeeHome.html";
		 }
	}
}
