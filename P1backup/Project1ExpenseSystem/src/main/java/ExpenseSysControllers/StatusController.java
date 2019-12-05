package ExpenseSysControllers;

import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import ExpenseSysDao.ReimbursementDaoImp;
import ExpenseSysModels.Reimbursement;

public class StatusController {

	public static String Status(HttpServletRequest request) {
		int id;
		try {
			id = Integer.parseInt(request.getParameter("reimb_id"));
		} catch(NumberFormatException e) {
			e.printStackTrace();
			return "/html/FinManHome.html";
		}

		java.sql.Date resolved = new Date(System.currentTimeMillis());	//gets the current system date to automatically set the resolved field without requiring user input
		int resolver = (int) request.getSession().getAttribute("ers_user_id"); //use session to get resolver ID 
		String status = request.getParameter("status");
	
		ReimbursementDaoImp reimbursementDaoImp = new ReimbursementDaoImp();
		Reimbursement reimbursement = reimbursementDaoImp.selectReimbById(id);
		
		
		reimbursement.setResolver(resolver);
		reimbursement.setResolved(resolved);
		
		//status switch statement
		switch (status) {
		case "1":
			reimbursement.setStatus(1);
		case "2":
			reimbursement.setStatus(2);
		case "3":
			reimbursement.setStatus(3);
		default: 
			
		}
	
		return "/html/FinManHome.html";		//take them to their home page or to a display page for the updated record
	
	}
}
