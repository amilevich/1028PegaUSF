package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import expenseSysDao.ReimbursementDaoImp;
import expenseSysModels.FinanceManager;
import expenseSysModels.Reimbursement;

public class ManagerProfileController {
	
	final static Logger activityLog= Logger.getLogger(ManagerProfileController.class);
		
	
	public static void ViewAllReimbursements(HttpServletRequest request, HttpServletResponse response) {
		FinanceManager man = (FinanceManager)request.getSession().getAttribute("object");
		ReimbursementDaoImp reDao = new ReimbursementDaoImp();
		ArrayList<Reimbursement> ar_re = reDao.selectAllReimb();
		System.out.println(ar_re);
		try {
			//sending the array_list of reimbursements back to the web server
			response.getWriter().write(new ObjectMapper().writeValueAsString(ar_re));
			
			activityLog.info("Reimbursement request history viewed by " + man.getFirstName() + " " + man.getLastName());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ApproveReimbursements(HttpServletRequest request, HttpServletResponse response) {
		FinanceManager manager = (FinanceManager)request.getSession().getAttribute("object");
		ReimbursementDaoImp reDao = new ReimbursementDaoImp();
		
		try {
			//selecting the reimbursement
			int reimID = Integer.parseInt(request.getParameter("reimID"));
			Reimbursement re = reDao.selectReimbById(reimID);
		
			int status = Integer.parseInt(request.getParameter("status"));
			re.setStatus(status);
			
			//status switch case for adding the word to the logger
			String stat=" ";
			switch(status) {
			case 2: stat = "APPROVED";
				break;
			case 3: stat = "DENIED";
				break;
			}
			
			//updating resolver attribute
			re.setResolver(manager.getUserID());
			
			//updating resolved date attribute
			java.sql.Date resolved = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			re.setResolved(resolved);
			
			reDao.updateReimb(re);
			
			//sending the approved/denied reimbursement back
			response.getWriter().write(new ObjectMapper().writeValueAsString(re));
			
			//logging the status alteration
			activityLog.info("Reimbursement request "+ reimID +" resolved by " + manager.getFirstName() + " " + manager.getLastName()+ " with status: "+ stat);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public static void FilterByStatus(HttpServletRequest request, HttpServletResponse response) {
		FinanceManager manager = (FinanceManager)request.getSession().getAttribute("object");
		ReimbursementDaoImp reDao = new ReimbursementDaoImp();
		
		int status = Integer.parseInt(request.getParameter("status"));
		ArrayList<Reimbursement> reimbs = reDao.filterReimbByStatus(status);
		
		//status switch case for adding the word to the logger
		String stat=" ";
		switch(status) {
		case 1: stat = "PENDING";
			break;
		case 2: stat = "APPROVED";
			break;
		case 3: stat = "DENIED";
			break;
		}
		
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(reimbs));
			activityLog.info("Reimbursement requests with "+ stat +" status viewed by " + manager.getFirstName()+ " " + manager.getLastName());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
}
