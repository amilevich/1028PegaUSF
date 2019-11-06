package com.example.bankaccount;

public class Employees extends Customers{

	
	//View Customer Account
	public void employeeViewAccount(String username, String password, Customers customer) {
		customerList(customer.getUsername(), customer.getPassword(), customer);
		//username, password, customer himself

	}
	
	
	//Approve and Deny open application
	public void accountApprovalDeny(String accept, String deny, Customers customer) {
		
	}
}
