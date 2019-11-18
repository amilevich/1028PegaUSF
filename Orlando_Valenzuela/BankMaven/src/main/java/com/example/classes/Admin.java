package com.example.classes;


public class Admin extends Employee {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Admin(String userName, String password) {
		super(userName, password);
		
	}
	
	public boolean cancel(Account account) {
		
		return true;
	}

}
