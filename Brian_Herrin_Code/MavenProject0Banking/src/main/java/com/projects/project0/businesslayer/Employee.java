package com.projects.project0.businesslayer;

import com.projects.project0.User;

public class Employee extends User {
	// Employees of the bank should be able to view all of their customers:
		// Account information
		// Account balances
		// Personal information
	// Employees should be able to approve/deny open applications for accounts
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Employee() {
		
	}
	public Employee(String userName, String password) {
		super(userName, password);
	}
	public void printEmployee() {
		System.out.println(" " + getUserName());
	}
}
