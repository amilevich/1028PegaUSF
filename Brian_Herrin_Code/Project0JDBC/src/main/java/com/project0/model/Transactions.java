package com.project0.model;

import com.project0.model.Account;

public interface Transactions {
	//Advised to divide this into two interfaces: one for customers, one for employees and the admin implements both of these 
	
	//void checkLogInCredentials();
	//void createAccountApplication();
	//void approveAccountApplication();
	double seeBalance(Integer id);
	double printBalance(int id);
	void deposit(double input, Account output);
	void deposit(double input);
	void withdraw(double input, Account output);
	void withdraw(double input);
	void transfer(double input, Account output, Account output1);
	//void logTransaction();
	
	
	
}
