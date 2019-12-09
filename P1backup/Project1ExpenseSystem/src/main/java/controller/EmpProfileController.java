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
import expenseSysModels.Employee;
import expenseSysModels.Reimbursement;

public class EmpProfileController {
	
	final static Logger activityLog= Logger.getLogger(EmpProfileController.class);
	
	
	public static void ViewPastTickets(HttpServletRequest request, HttpServletResponse response) {
		ReimbursementDaoImp reDao = new ReimbursementDaoImp();
		
		try {
			Employee emp = (Employee)request.getSession().getAttribute("object");
			ArrayList<Reimbursement> ar_re = reDao.selectAllEmpReimb(emp.getUserID());
		
			//sending the array_list of reimbursements back to the web server	
			response.getWriter().write(new ObjectMapper().writeValueAsString(ar_re));
			
			activityLog.info("Reimbursement request history viewed by " + emp.getFirstName() + " " + emp.getLastName());
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void AddReimbusementRequest(HttpServletRequest request, HttpServletResponse response) {
		ReimbursementDaoImp reDao = new ReimbursementDaoImp();
		
		try {
			Employee emp = (Employee)request.getSession().getAttribute("object");
			
			int reimID =0;
			java.sql.Date submitted = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			java.sql.Date resolved = null;
			String description= request.getParameter("description");
			int author = emp.getUserID();
			int resolver = 0;
			int status = 1;	
			int type = Integer.parseInt(request.getParameter("type"));	
			double amount = Double.parseDouble(request.getParameter("amount"));
			//needs input validation
			
			//adding reimbursement into the database
			Reimbursement re = new Reimbursement(reimID, amount, submitted, resolved, description, author, resolver, status, type); 
			reDao.insertReimb(re);
			activityLog.info("Reimbursement request submitted by " + emp.getFirstName() + " " + emp.getLastName());
			
			//returning the reimbursement receipt to the user
			response.getWriter().write(new ObjectMapper().writeValueAsString(re));
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}	
	
}