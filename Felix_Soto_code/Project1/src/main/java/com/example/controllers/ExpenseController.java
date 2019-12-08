package com.example.controllers;

import javax.servlet.http.HttpServletRequest;
import com.example.dao.ExpenseDaoImpl;
import com.example.ers.Employee;
import com.example.ers.Expense;

public class ExpenseController {

	public static String submitExpense(HttpServletRequest request) {
		Employee emp = (Employee)request.getSession().getAttribute("employee");
		int emp_id = emp.getUsedId();
		String firstname = emp.getFirstName();
		String lastname = emp.getLastName();
		int type = Integer.parseInt(request.getParameter("type"));
		double amount = Double.parseDouble(request.getParameter("Amount"));
		String desc = request.getParameter("Description");
		ExpenseDaoImpl expImpl = new ExpenseDaoImpl();
		Expense exp = new Expense(emp_id,firstname,lastname,type,amount,desc);
		expImpl.insertExpense(exp);
		return "/html/EmployeeHome.html";
	}
}