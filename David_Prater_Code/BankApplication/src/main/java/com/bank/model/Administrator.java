package com.bank.model;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.ui.BankMenu;
import com.bank.ui.MainActivity;

public class Administrator {

	final static Logger logger = Logger.getLogger(Administrator.class);
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
			// If login failed return to main menu
			System.out.println("Please Try Loggin in again.");
			BankMenu.getMainMenu();
		}

	}

	// This method displays and collects the administrators actions
	public static void administratorActions() throws FileNotFoundException {
		// This method forces the administrator to approve or deny accounts before they can perfrom any other actions
		Employee.approveNewCustomer();
		System.out.println("What would you like to do today?");
		System.out.println(
				"1. View All Acounts\n2. Withdraw Funds\n3. Deposit Funds\n4. TransferFunds\n5. Cancel Account\n6. Logout");
		// Convert to string to perform input validation
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
			// Log the administrator out
			System.out.println("Logout succesful.");
			BankMenu.getMainMenu();
			break;
		default:
			// Call method recursively until a valid input is entered
			administratorActions();
		}
		// Return to administrator menu until they logout
		administratorActions();
	}

	// This method is used to delete existing accounts
	public static void cancelAccount() throws FileNotFoundException {
		System.out.println(
				"1. Select Which Account to Delete\n2. View All Accounts\n3. Return to Administrator Menu");

		// Convert to string to perform input validation
		String actionChoice = sc.next().toString();

		// Switch to cancel account menu
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
		// Call recursively until the administrator inputs a valid option
		cancelAccount();

	}
	
	// This method allows the administrator to choose which account the want to perform actions on
	public static void getPassKey() throws FileNotFoundException {
		System.out.println("Whats is the key for the account? (key = username + password)");
		String passKey = sc.next().toString();
		// If they enter a valid key set current customer to that person objects in customer HashMap
		if(BankMenu.customerMap.containsKey(passKey)) {
			 currentPerson = BankMenu.customerMap.get(passKey);
		} else {
			// Else return to administrator menu
			System.out.println("Invalid key. Please Try Again.");
			administratorActions();
		}
	}
	
	// This method allows the administrator to delete accounts
	public static void removeAccount() throws FileNotFoundException {
		System.out.println("Whats is the key for the account you wish to delete? (key = username + password)");
		String passKey = sc.next().toString();
		
		// If this key is in the customer HashMap delete its corresponding Person object
		if(BankMenu.customerMap.containsKey(passKey)) {
			 currentPerson = BankMenu.customerMap.get(passKey);
			 BankMenu.customerMap.remove(passKey);
			 // Notify the administrator of a successful account canceling
			 System.out.println("Account Removed Succesfully.");
			 logger.info("Account number " + currentPerson.getAccountNumber() + "successfully deleted.");
			 
		} else {
			// If the admin submits an invalid key return them to the actions menu
			System.out.println("Invalid key. Please Try Again");
			administratorActions();
		}
		
	}

}
