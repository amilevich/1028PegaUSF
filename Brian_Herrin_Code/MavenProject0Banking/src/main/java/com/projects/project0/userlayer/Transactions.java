package com.projects.project0.userlayer;

import com.projects.project0.businesslayer.Account;

public interface Transactions {
	//Advised to divide this into two interfaces: one for customers, one for employees and the admin implements both of these 
	
	//public void checkLogInCredentials();
	//public void createAccountApplication();
	//public void approveAccountApplication();
	public double seeBalance();
	public void deposit(double input);
	public void withdraw(double input);
	public void transfer(double input, Account output);
	//public void logTransaction();
}
