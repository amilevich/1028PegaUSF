package com.bank.model;

import static org.hamcrest.CoreMatchers.containsString;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.bank.ui.BankMenu;

public interface Customer {

	static Scanner sc = new Scanner(System.in);

	public static void customerMenu() throws FileNotFoundException {

		System.out.println("Please Enter Your Username.");
		String username = sc.next().toString();
		
		// If the user name is correct check the password. If either are incorrect send the user back to the main menu
		if (username.equals("employee")) {
			System.out.println("Please enter you password.");
			String adminPassword = sc.next();
			if (adminPassword.equals("password")) {
				employeeActions();
			} else {
				System.out.println("Please Try Loggin in again.");
				BankMenu.getMainMenu();
			}
		} else {
			System.out.println("Please Try Loggin in again.");
			BankMenu.getMainMenu();
		}

	}

	public static void customerActions() throws FileNotFoundException {
		Employee.approveNewCustomer();
		System.out.println("What would you like to do today?");
		System.out.println("1. View Account Balance\n2. Withdraw Funds\n3. Deposit Funds\n4. TransferFunds\n5. Logout");
		String actionChoice =  sc.next().toString();

		switch (actionChoice) {
		case "1":
			Employee.viewAllAccounts();
			break;
		case "2":
			// Withdarawal
			withdrawalFunds(10);
			customerActions();
		case "3":
			withdrawalFunds(10);
			customerActions();
		case "4":
			withdrawalFunds(10);
			customerActions();
		case "5":
			System.out.println("Logout succesful.");
			BankMenu.getMainMenu();
			break;
		default:
			customerActions();
		}
	
		customerActions();
	}
	
	
	
	// Method to withdrawal funds from account
	public static double withdrawalFunds(double funds) {
		return funds;
	}
	
	// Method to deposit funds into account
	public static double depositFunds(double funds) {
		return funds;
	}
	
	// Method to transfer funds to an account
	public static double transferFunds(double funds) {
		System.out.println("Whats is the account number you wish to transfer funds to?");
		String otherAccount = sc.next().toString();
		
		System.out.println("You transferred $" + funds + " to account number " + otherAccount + ".");
		return funds;
	}
	
	
}
