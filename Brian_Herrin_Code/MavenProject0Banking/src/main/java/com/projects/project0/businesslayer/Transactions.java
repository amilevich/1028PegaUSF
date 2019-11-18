package com.projects.project0.businesslayer;

import com.projects.project0.businesslayer.Account;

public interface Transactions {
	//Advised to divide this into two interfaces: one for customers, one for employees and the admin implements both of these 
	
	//void checkLogInCredentials();
	//void createAccountApplication();
	//void approveAccountApplication();
	double seeBalance(Integer id);
	double printBalance(int id);
	void deposit(double input, Account output);
	void withdraw(double input, Account output);
	void transfer(double input, Account output, Account output1);
	//void logTransaction();
	
}
