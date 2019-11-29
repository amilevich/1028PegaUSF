package com.bank.controller;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.bank.dao.AccountDaoImpl;
import com.bank.model.Account;
import com.bank.view.BankMenu;

public class Employee {

	static Scanner sc = new Scanner(System.in);
	AccountDaoImpl accountDaoImpl = new AccountDaoImpl();

	public static void employeeMenu() {
		System.out.println("Please login with your company issued account username.");
		String employeeName = sc.next().toString();

		// If the user name is correct check the password. If both are correct log in
		// the employee.
		// If either are incorrect send the user back to the main menu
		// employee: username = employee and password = password
		if (employeeName.equals("employee")) {
			System.out.println("Please login with your company issued password");
			// Convert all input to string to perfom input validation
			String adminPassword = sc.next().toString();
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

	// This method displays the actions the employee can perform
	public static void employeeActions() {
		// Run this method when an employee or administrator logs in to force them to
		// approve all accounts
		// before performing any other actions
		Employee.approveNewCustomer();
		System.out.println("What would you like to do today?");
		System.out.println("1. View All Acounts\n2. Logout");
		// Convert to string to perfrom input validation
		String actionChoice = sc.next().toString();

		// Switch between available choices for and return them to the menu after each
		// action
		switch (actionChoice) {
		case "1":
			viewAllAccounts();
			employeeActions();
			break;
		case "2":
			System.out.println("Logout succesful.");
			BankMenu.getMainMenu();
		default:
			// Call recursively to get input until user submits correct action
			employeeMenu();
		}

		// Call method recursively until the employee logs out
		employeeActions();
	}

	// This method allows the current user to approve or deny pending accounts
	public static void approveNewCustomer() {


		// Loop through the arraylist of newCustomers and have the user choose whether
		// to approve or deny each account
		for (Account newCustomer : NewCustomer.newCustomerList) {
			System.out.println("Press 'y' to approve account and 'n' to deny the account.");
			String output = newCustomer.toString();
			System.out.println(output);

			// This do while loop runs until the current user approves or denies the pending account
			// Set choice to z to make sure it runs
			String choice = "z";
			do {
				// Validate the user input by converting to string
				choice = sc.next().toString();
				// If user enters 'y' approve the account
				if (choice.equals("y")) {
					
					AccountDaoImpl.insertAccount(newCustomer);
					// Create a key (username + password) to access that account in the customer
					// HashMap
					BankMenu.customerMap.put((newCustomer.getUsername() + newCustomer.getPassword()), newCustomer);
					// This checks if the current account is a joint account
					// If their is a password for the second user it means its a joint account
					if (newCustomer.getPassword2() != null) {
						// Create a second key that references the same Account object that way both
						// objects are updated by either use
						BankMenu.customerMap.put((newCustomer.getUsername2() + newCustomer.getPassword2()),
								newCustomer);
					}

					// Add the Account(s) to the customer HashMap
					BankMenu.newCustomerList.add(newCustomer);
					break;
					// Deny account
				} else if (choice.equals("n")) {
					System.out.println("Denied");
				} else {
					System.out.println("Press 'y' to approve account and 'n' to deny the account.");
				}
				// Call this loop until they approve or deny the account
			} while (!choice.equals("y") || !choice.equals("n"));

		}

		// This line makes a new ArrayList deleting the approved and denied accounts
		NewCustomer.newCustomerList.removeAll(NewCustomer.newCustomerList);

	}

	// Method to view all accounts
	public static void viewAllAccounts() {
		// For each keyset in the customer HashMap print their information
		List<Account> accounts = AccountDaoImpl.selectAllAccounts();
		for(Account a : accounts) {
			System.out.println("Account Number: " + a.getAccountNumber());
			System.out.println("Account Balance: " + a.getAccountBalance());
			System.out.println("Name: " + a.getFirstName() + " " + a.getLastName());
			System.out.println("Address: " + a.getAddress());
			System.out.println("");
		}

	}

	// This generate a random number between 100000 and 1 and returns it as a string
	public static String generateAccountNumber() {
		Random r = new Random();
		int randomAccountNumber = r.nextInt((100000 - 1) + 1) + 1;
		// Convert the integer to a string
		return Integer.toString(randomAccountNumber);
	}

}
