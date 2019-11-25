package com.projectzero.menu;

import java.util.Scanner;

import com.projectzero.dao.AccountDaoImpl;

import project0PartOne.Account;
import project0PartOne.Customer;

public class AccountMenu {
	AccountDaoImpl acDaoImpl = new AccountDaoImpl();
	
	BankMenu bkm = new BankMenu();
	
	public void PullCustomerAccountByCustomerID() {
		Scanner inp = new Scanner(System.in);
		Account act = new Account();
		System.out.print("Enter your cust id to view Status: ");
		int id = inp.nextInt();
		System.out.println(acDaoImpl.getAccountByCustomerId(id));
		act = acDaoImpl.getAccountByAccountById(id);
		if(act.getStatus().equals("approved")) {
			bkm.ActionMenu();
		}else{
			System.out.println("sorry your account is still pending");
			System.out.println("-------------------------------------------------------------------------");
			bkm.bankMenu();
		}
	}
public void accountRegistration(int id) {
		Account newAccount = new Account();
		Scanner inp = new Scanner(System.in);
		AccountDaoImpl accDaoImpl = new AccountDaoImpl();
		System.out.println("Your account id will be: " + newAccount.getAccountID());
		int bal = 0;
		newAccount.setBalance(bal);
		System.out.println("Your balance will be: " + newAccount.getBalance() + " until an employee or admin approves.");
		System.out.println("Please chosee your account type ('1') for checking, ('2') for savings: ");
		int option = inp.nextInt();
		if(option == 1) {
			newAccount.setType("checking");
			System.out.println("Your account type is: " + newAccount.getType());
		}else if(option == 2) {
			newAccount.setType("savings");
			System.out.println("Your account type is: " + newAccount.getType());
		}
		System.out.println("Please choose either (0) for single or (1) for joint: ");
		int opt = inp.nextInt();
		if(opt == 0) {
			newAccount.setJoint(0);
			newAccount.setStatus("pending");
			Account custAccount = new Account(newAccount.getAccountID(),newAccount.getBalance(),newAccount.getType(),newAccount.isJoint(),id,newAccount.getStatus());
			accDaoImpl.createAccount(custAccount);
		}else if(opt == 1) {
			newAccount.setJoint(1);
			newAccount.setStatus("pending");
			Account custAccount = new Account(newAccount.getAccountID(),newAccount.getBalance(),newAccount.getType(),newAccount.isJoint(),id,newAccount.getStatus());
			accDaoImpl.createAccount(custAccount);
		}
		System.out.println("thankYou for registering! your account is waiting for aproval!");
		
		BankMenu bkm = new BankMenu();
		bkm.bankMenu();
	}
}
