package com.example.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class RequestHelper {
	final static Logger loggy = Logger.getLogger(RequestHelper.class);
	public static String process(HttpServletRequest request, HttpServletResponse response) {
		switch (request.getRequestURI()) {
		case "/Project1/html/Register.do":
			System.out.println("in request helper");
			loggy.info("in request helper");
			return RegisterController.Register(request);
		case "/Project1/html/Login.do":
			return LoginController.Login(request);
		case "/Project1/html/NewExpense.do":
			return ExpenseController.submitExpense(request);
		case "/Project1/html/LoadExpenses.do":
			return AdminExpenseController.loadExpenses(request, response);
		case "/Project1/html/ApproveExpense.do":
			return AdminExpenseController.approveExpense(request, response);
		case "/Project1/html/DenyExpense.do":
			return AdminExpenseController.denyExpense(request, response);
		case "/Project1/html/LoadExpensesById.do":
			return EmployeeExpenseController.loadExpensesById(request, response);
		default:
			loggy.info("Not a valid .do string");
			return null;
		}
	}
}