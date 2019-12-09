package expenseSysControllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import expenseSysDao.ReimbursementDaoImp;
import expenseSysModels.FinanceManager;
import expenseSysModels.Reimbursement;

public class ManagerProfileController {
	
	public static String ViewAllReimbursements(HttpServletRequest request, HttpServletResponse response) {
		//FinanceManager manager = (FinanceManager)request.getSession().getAttribute("object");
		ReimbursementDaoImp reDao = new ReimbursementDaoImp();
		ArrayList<Reimbursement> ar_re = reDao.selectAllReimb();
		
		try {
			//sending the array_list of reimbursements back to the web server
			response.getWriter().write(new ObjectMapper().writeValueAsString(ar_re));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String ApproveReimbursements(HttpServletRequest request, HttpServletResponse response) {
		FinanceManager manager = (FinanceManager)request.getSession().getAttribute("object");
		ReimbursementDaoImp reDao = new ReimbursementDaoImp();
		
		try {
			//selecting the reimbursement
			String str_reimID = request.getParameter("reimID");
			int reimID = Integer.parseInt(str_reimID);
			Reimbursement re = reDao.selectReimbById(reimID);
			
			//updating status attribute
			String str_status = request.getParameter("status");
			int status = Integer.parseInt(str_status);
			re.setStatus(status);
			
			//updating resolver attribute
			re.setResolver(manager.getUserID());
			
			//updating resolved date attribute
			java.sql.Date resolved = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			re.setResolved(resolved);
			
			reDao.updateReimb(re);
			
			//sending the approved/denied reimbursement back
			response.getWriter().write(new ObjectMapper().writeValueAsString(re));
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; 
	}	
	
	public static String FilterByStatus(HttpServletRequest request, HttpServletResponse response) {
		ReimbursementDaoImp reDao = new ReimbursementDaoImp();
		
		String str_status = request.getParameter("status");
		int status = Integer.parseInt(str_status);
		ArrayList<Reimbursement> reimbs = reDao.filterReimbByStatus(status);
		
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(reimbs));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; 		
	}
	
}
