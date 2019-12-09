package expenseSysControllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import expenseSysDao.ReimbursementDaoImp;
import expenseSysModels.Employee;
import expenseSysModels.Reimbursement;

public class EmpProfileController {
	
	
	public static String ViewPastTickets(HttpServletRequest request, HttpServletResponse response) {
		ReimbursementDaoImp reDao = new ReimbursementDaoImp();
		
		try {
			Employee emp = (Employee)request.getSession().getAttribute("Employee");
			ArrayList<Reimbursement> ar_re = reDao.selectAllEmpReimb(emp.getUserID());
		
			//sending the array_list of reimbursements back to the web server	
			response.getWriter().write(new ObjectMapper().writeValueAsString(ar_re));
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String AddReimbusementRequest(HttpServletRequest request, HttpServletResponse response) {
		ReimbursementDaoImp reDao = new ReimbursementDaoImp();
		
		try {
			Employee emp = (Employee)request.getSession().getAttribute("Employee");
			
			//variables for reimbursement object
			int reimID =0;//needs to be resolved
			java.sql.Date submitted = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			java.sql.Date resolved = null;
			String description= request.getParameter("description");
			int author = emp.getUserID();
			int resolver = 0;
			int status = 0;
			String str_type = request.getParameter("type");//should be int
			String str_amount = request.getParameter("amount"); //should be double
	
			int type = Integer.parseInt(str_type);	//converting to integer and double
			double amount = Double.parseDouble(str_amount);
			//needs input validation
			
			//adding reimbursement into the database
			Reimbursement re = new Reimbursement(reimID, amount, submitted, resolved, description, author, resolver, status, type); 
			reDao.insertReimb(re);
			
			//returning the reimbursement receipt to the user
			response.getWriter().write(new ObjectMapper().writeValueAsString(re));
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}	
	
	
	
	
}
