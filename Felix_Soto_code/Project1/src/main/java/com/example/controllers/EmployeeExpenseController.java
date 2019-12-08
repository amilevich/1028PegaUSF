package com.example.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.example.dao.ExpenseDaoImpl;
import com.example.ers.Employee;
import com.example.ers.Expense;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeExpenseController {
	final static Logger loggy = Logger.getLogger(EmployeeExpenseController.class);

	public static String loadExpensesById(HttpServletRequest request, HttpServletResponse response) {
		ExpenseDaoImpl expImpl = new ExpenseDaoImpl();
		List<Expense> lExp = new ArrayList<Expense>();
		Employee emp = (Employee)request.getSession().getAttribute("employee");
		int emp_id = emp.getUsedId();
		lExp = expImpl.selectExpensesByEmployeeId(emp_id);
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(lExp));
		} catch (JsonProcessingException e) {
			loggy.error(e);
		} catch (IOException e) {
			loggy.error(e);
		}
		return "/html/EmployeeHome.html";
	}
}