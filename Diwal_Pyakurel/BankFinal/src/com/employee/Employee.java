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


	@Override
	public void deposit() {
		// TODO Auto-generated method stub
		
		int accountNo = Methods.adminSelectsAccount();
		Scanner sc = new Scanner(System.in);
		float depositAmt = Methods.getFloatvalue("Please specify the deposit amount");
		Methods.addDeposits(accountNo, depositAmt);
		
	}


	@Override
	public void withdrawl() {
		
		int accountNo = Methods.adminSelectsAccount();
		float withdrawlAmt = Methods.getFloatvalue("Please specify the withdrawl amount");
		Methods.getWithdrawl(accountNo, withdrawlAmt);		
	}

	@Override
	public void transfer() {
		System.out.println("Please select the accont where you want to withdraw money");
		int withdrawingAccount = Methods.adminSelectsAccount();
		System.out.println("Please select the accont where you want to transfer money");
		int depositingAccount = Methods.adminSelectsAccount();
		float amt = Methods.getFloatvalue("Please specify the transfer amount");
		Methods.transfer(withdrawingAccount, depositingAccount, amt);
		System.out.println("$"+amt+ " has been deposited on the account "+ depositingAccount);
		System.out.println("$" +amt+ " has been withdrawn from the account "+ withdrawingAccount);
		
	}


	@Override
	public void viewAccount() {
		ArrayList<Accounts> allAccounts = Methods.readAccounts();

		for(int i =0; i<allAccounts.size(); i++) {
			allAccounts.get(i).toString();
		}
		
		
	}



}
