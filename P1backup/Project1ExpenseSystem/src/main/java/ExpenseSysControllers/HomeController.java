package expenseSysControllers;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import expenseSysModels.Employee;
import expenseSysModels.FinanceManager; 

public class HomeController {
	
	public static String Home(HttpServletRequest request, HttpServletResponse response) {
		
		String role = (String)request.getSession().getAttribute("role");
		
		if (role.equals("employee")) {
			Employee emp = (Employee)request.getSession().getAttribute("object");
			try {
				response.getWriter().write(new ObjectMapper().writeValueAsString(emp));
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		} else {
			FinanceManager manager = (FinanceManager)request.getSession().getAttribute("object");
			try {
				response.getWriter().write(new ObjectMapper().writeValueAsString(manager));
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}	
	}

}