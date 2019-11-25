package com.project0.model;

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
	public Employee(Integer id, String userName, String password) {
		super(userName, password);
		setId(id);
	}
	public void printEmployee() {
		System.out.println(" " + getUserName());
	}
}
