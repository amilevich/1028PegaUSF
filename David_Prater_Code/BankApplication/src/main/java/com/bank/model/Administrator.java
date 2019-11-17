package com.bank.model;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.bank.ui.BankMenu;

public class Administrator {

	static Scanner sc = new Scanner(System.in);
	

	// This is the login method for the administrator
	// Administrator username = "admin"
	// Administrator password = "password"
	public static void adminstratorMenu() throws FileNotFoundException {
		
		System.out.println("Please login with your company issued account username.");
		String adminName = sc.next().toString();
		
		// If the user name is correct check the password. If either are incorrect send the user back to the main menu
		if (adminName.equals("admin")) {
			System.out.println("Please login with your company issued password");
			String adminPassword = sc.next().toString();
			if (adminPassword.equals("password")) {
				administratorActions();
			} else {
				System.out.println("Please Try Loggin in again.");
				BankMenu.getMainMenu();
			}
		} else {
			System.out.println("Please Try Loggin in again.");
			BankMenu.getMainMenu();
		}
		
	}

	
	// This method displays and collects the administrators actions
	public static void administratorActions() throws FileNotFoundException {
		Employee.approveNewCustomer();
		System.out.println("What would you like to do today?");
		System.out.println("1. View All Acounts\n2. Withdraw Funds\n3. Deposit Funds\n4. TransferFunds\n5. Cancel Account\n6. Logout");
		String actionChoice =  sc.next().toString();

		switch (actionChoice) {
		case "1":
			Employee.viewAllAccounts();
			break;
		case "2":
			// Withdarawal
			administratorActions();
			break;
		case "3":
			// Deposit
			administratorActions();
			break;
		case "4":
			// Transfer Funds
			administratorActions();
			break;
		case "5":
			cancelAccount();
			break;
		case "6":
			System.out.println("Logout succesful.");
			BankMenu.getMainMenu();
			break;
		default:
			administratorActions();
		}
	
		administratorActions();
	}
	
	
	public static void cancelAccount() throws FileNotFoundException {		
		System.out.println("1. Select Which Account to Delete\n2. View All Accounts Funds\n3. Return to Administrator Menu");
		
		String actionChoice = sc.next().toString();
		
		switch(actionChoice) {
		case "1":
			System.out.println("Please type the account number you wish to canecl.");
			// Loop through customer list and check account number the
			// customerList.remove()
			break;
		case "2":
			Employee.viewAllAccounts();
			break;
		case "3":
			administratorActions();
			break;
		default:
			cancelAccount();
			;
		}
	
		cancelAccount();
		
	}
	
}
