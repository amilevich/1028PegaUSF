package com.bank.model;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.bank.ui.BankMenu;

public class Administrator {

	static Scanner sc = new Scanner(System.in);
	public static Person currentPerson = null;
	public static Person transferPerson = null;
	public static Person receiverPerson = null;

	// This is the login method for the administrator
	// Administrator username = "admin"
	// Administrator password = "password"
	public static void adminstratorMenu() throws FileNotFoundException {

		System.out.println("Please login with your company issued account username.");
		String adminName = sc.next().toString();

		// If the user name is correct check the password. If either are incorrect send
		// the user back to the main menu
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
		System.out.println(
				"1. View All Acounts\n2. Withdraw Funds\n3. Deposit Funds\n4. TransferFunds\n5. Cancel Account\n6. Logout");
		String actionChoice = sc.next().toString();

		// Switch to correct menu option
		switch (actionChoice) {
		case "1":
			Employee.viewAllAccounts();
			break;
		case "2":
			// Withdrawal
			getPassKey();
			Customer.withdrawalFunds(currentPerson);
			administratorActions();
			break;
		case "3":
			// Deposit
			getPassKey();
			Customer.depositFunds(currentPerson);
			administratorActions();
			break;
		case "4":
			// Transfer Funds
			Customer.transferFunds();
			administratorActions();
			break;
		case "5":
			// Delete Account
			cancelAccount();
			administratorActions();
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
		System.out.println(
				"1. Select Which Account to Delete\n2. View All Accounts\n3. Return to Administrator Menu");

		String actionChoice = sc.next().toString();

		switch (actionChoice) {
		case "1":
			removeAccount();
			administratorActions();
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
	
	public static void getPassKey() throws FileNotFoundException {
		System.out.println("Whats is the key for the account? (key = username + password)");
		String passKey = sc.next().toString();
		
		if(BankMenu.customerMap.containsKey(passKey)) {
			 currentPerson = BankMenu.customerMap.get(passKey);
		} else {
			System.out.println("Invalid key. Please Try Again.");
			administratorActions();
		}
	}
	
	public static void removeAccount() throws FileNotFoundException {
		System.out.println("Whats is the key for the account you wish to delete? (key = username + password)");
		String passKey = sc.next().toString();
		
		if(BankMenu.customerMap.containsKey(passKey)) {
			 currentPerson = BankMenu.customerMap.get(passKey);
			 BankMenu.customerMap.remove(passKey);
			 System.out.println("Account Removed Succesfully.");
		} else {
			System.out.println("Invalid Username. Please Try Again");
			cancelAccount();
		}
		
	}

}
