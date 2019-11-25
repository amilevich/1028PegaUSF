package com.employee;

import java.util.ArrayList;
import java.util.Scanner;

import com.Methods.Methods;
import com.accounts.Accounts;

import bankinterfaces.CommonInterfaces;

public class Employee implements CommonInterfaces {
	
	
	private String name;
	private int pinCode;
	
	
	public Employee() {
		super();
		this.name = "Mr Employee";
		this.pinCode = 2345;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPinCode() {
		return pinCode;
	}


	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}



	public void deposit() {
		// TODO Auto-generated method stub
		int accountNo = Methods.adminSelectsAccount();
		if(accountNo!=0) {
			float depositAmt = Methods.getFloatvalue("Please provide deposit amount");
			
			Methods.accts.addDeposit(accountNo, depositAmt);
			// System.out.println("$"+depositAmt+ " has been deposited on the account "+
			// accountNo);
			Methods.bankloggy.info("$" + depositAmt + " has been deposited on the account " + accountNo);
			
		}
		
	}



	public void withdrawl() {
		// TODO Auto-generated method stub
		int accountNo = Methods.adminSelectsAccount();
		if(accountNo!=0) {
			float withdrawlAmt = Methods.getFloatvalue("Please specify the amount you want to withdraw on this account");
			Methods.accts.withdraw(accountNo, withdrawlAmt);
			Methods.bankloggy.info("$" + withdrawlAmt + " has been withdraw on the account " + accountNo);
			
		}
	}


	public void transfer() {
		System.out.println("Please select the accont where you want to withdraw money");
		System.out.println("Please select the accont where you want to withdraw money");
		int withdrawingAccount = Methods.adminSelectsAccount();
		if (withdrawingAccount != 0) {

			System.out.println("Please select the accont where you want to transfer money");
			int depositingAccount = Methods.adminSelectsAccount();
			if(depositingAccount!=0) {
				float amt = Methods.getFloatvalue("Specify the amount for transfer");

				Methods.accts.transfer(withdrawingAccount, depositingAccount, amt);
				Methods.bankloggy.info("$" + amt + " has been deposited on the account " + depositingAccount);
				Methods.bankloggy.info("$" + amt + " has been withdrawn from the account " + withdrawingAccount);
			}
			
		
	}
	}


	public void viewAccount() {
		Methods.accts.viewAll();
		
		
		
	}



}
