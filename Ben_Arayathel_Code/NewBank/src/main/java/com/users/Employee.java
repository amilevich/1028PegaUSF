package com.users;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.backend.Account;
import com.backend.AccountManagement;
import com.frontend.MainDriver;

public class Employee {
	
	final static Logger loggy = Logger.getLogger(Employee.class);
	//Hard coded ID for 
	static String Employeeusername = "e";
	static String Employeepassword = "p";
	
	//This method verifies the login features of the account
	public static void employeeLogin(Scanner in) throws InputMismatchException{
		System.out.println("Hello Employee, please input your credentials");
		System.out.println("Username: ");
		String username = in.next();
		System.out.println("Password: ");
		String password = in.next();
		if (Employeeusername.contentEquals(username) && Employeepassword.contentEquals(password)) {
			loggedInMenu(in);
		}else{
			System.out.println("Incorrect login credentials");}
	}
	//THis method will showcase what the employee can do and gives access to the methods within the class.
	public static void loggedInMenu(Scanner in) throws InputMismatchException{
		do {
		System.out.println("Well done, you can follow basic protocol.");
		System.out.println("What would you like to do?");
		System.out.println("[0] Approve Pending Accounts.");
		System.out.println("[1] Disregard User privacy and access their intimate details.");
		
		int options = in.nextInt();		
		switch(options) {
		case 0:
			approveAccounts(in);
			break;
		case 2:
			getSecrets(in);
		default:
			System.out.println("That really isn't an option, learn to read to ");
		}
		}while(MainDriver.keepinteracting(in, "employee"));
	}
	//Approve pending accounts, within the array list into the "approved" pending map.
	public static void approveAccounts(Scanner in) throws InputMismatchException {
		if(AccountManagement.pendingAccounts.isEmpty()) {
			System.out.println("No accounts to approve");
		}else {
			for(Account i:AccountManagement.pendingAccounts) {
				System.out.println(i.toString());
				System.out.println("Would you like to approve or deny the account?(yes or no)");
				String input = in.next();
				//in.nextLine();
				if(input.equals("yes")) {
					AccountManagement.storageAccount.put(i.getiD(), i);
					if(i.getSecondName() != null) {
						AccountManagement.storageAccount.put(i.getSecondID(), i);
					}
					System.out.println("Account has been approved.");
				}
				else if(input.equals("no")) {
					System.out.println("Account has been denied.");
				}

			}
			AccountManagement.pendingAccounts.removeAll(AccountManagement.pendingAccounts);
			System.out.println("Account processing complete");
			loggy.info("Pending accounts have been approved");
		}
	}	
	//Allows employees to view account details via the toString method
	public static void getSecrets(Scanner in) throws InputMismatchException{

		if(AccountManagement.storageAccount.isEmpty()) {
			System.out.println("No accounts available to access");
		}else {

			System.out.println("Here are the keys to access everyones most intimate secrets.");
			System.out.println(AccountManagement.storageAccount.keySet().toString());
			boolean accessing = true;

			while(accessing) {
				try {
				System.out.println("Which account would you like to access?");
				in.nextLine();
				String eID = in.nextLine();
				Account account = AccountManagement.storageAccount.get(eID);
				System.out.println(account.toString());}catch(NullPointerException e) {
					//e.printStackTrace();
					System.out.println("That account does not exist");
				}
				
				System.out.println("Would you like to access any more accounts?");
				String input = in.next();
				if (input.equals("no")) {
					accessing = false;
				}else if(input.equals("yes")) {
					System.out.println("Cheery ho, lets get you some more trusted secret from our valued customers.");
				}else {
					System.out.println("That isn't a vaild input, remember we don't accept upper case.");
					break;
				}	
			}
		}

	}

}
	

