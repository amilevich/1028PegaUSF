package com.bank.controller;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.dao.AccountDaoImpl;
import com.bank.model.Account;
import com.bank.view.BankMenu;

public class Customer {

	// Create the logger and scanner variables
	final static Logger logger = Logger.getLogger(Customer.class);
	static Scanner sc = new Scanner(System.in);
	
	// Create null Account object to be used for the current Account that is logged in
	static Account currentAccount = null;
	// Create Account objects to be used for the Account transferring money and the Account receiving money
	static Account transferAccount = null;
	static Account receiverAccount = null;

	// This method logs in the customer and sends them to the customer menu
	public static void customerMenu() {

		// Get input for the users username and password
		System.out.println("Please Enter Your Username.");
		String username = sc.next().toString();
		System.out.println("Please Enter Your Password.");
		String password = sc.next().toString();
		// Combine the username and password because this is their key in the customer HashMap
		//System.out.println(currentAccount.getPassword());
		
		currentAccount = AccountDaoImpl.selectAccountByID(username);
		
		if(currentAccount == null) {
			System.out.println("Invalid login credentials. You have been returned to the main menu");
			BankMenu.getMainMenu();
		}
		
		currentAccount = AccountDaoImpl.selectAccountByID(username);
		String passwordCheck = currentAccount.getPassword();
		//If the users submitted a correct key log them in to the customer menu
		
		if(password.equals(passwordCheck)) {
			// Set the current customer to access that Account details
			customerActions(currentAccount);
		} else {
			// If login fails print failure message and send them to the main menu
			System.out.println("Invalid Username or Password. Please Try Logging in Again");
			BankMenu.getMainMenu();
		}

	}

	// This method has the menu for actions the customer can perform. (View Account, Withdrawal, Deposit, and Transfer)
	public static void customerActions(Account Account) {
		// **Account.toString();
		System.out.println("What would you like to do today?");
		System.out.println("1. View Account Balance\n2. Withdraw Funds\n3. Deposit Funds\n4. Transfer Funds\n5. Logout");
		// Convert all input to a string to handle input validation
		String actionChoice = sc.next().toString();

		// Switch to the selected customer action if default call the customer actions method again
		switch (actionChoice) {
		case "1":
			// Print account number and balance for customer
			AccountDaoImpl.updateAccount(currentAccount);
			System.out.println("Account Number: " + currentAccount.getAccountNumber());
			System.out.println("Balance: $" + currentAccount.getAccountBalance());
			break;
		case "2":
			// Withdrawal funds from customer account
			withdrawalFunds(currentAccount);
			customerActions(currentAccount);
			break;
		case "3":
			// Deposit funds to customer account
			depositFunds(currentAccount);
			customerActions(currentAccount);
			break;
		case "4":
			// Transfer funds between to customers
			transferFunds();
			customerActions(currentAccount);
			break;
		case "5":
			// Log the customer out
			System.out.println("Logout succesful.");
			BankMenu.getMainMenu();
			break;
		default:
			// This handles input validation because it calls it self recursively if it it does't match a case.
			customerActions(currentAccount);
		}

		// Call method recursively to allow the user to perform more actions
		customerActions(currentAccount);
	}

	// Method to withdrawal funds from account
	public static void withdrawalFunds(Account Account) {
		
		// For administrator account if their inputs is invalid return to admin actions
		if(Account == null) {
			System.out.println("Invalid Account Number");
			Administrator.administratorActions();
		}
		
		System.out.println("How much money would you like to withdrawal today?");
		// This method makes sure the user entered a positive number
		double withdrawlAmount = getPositiveDouble();
		// Check to make sure they have enough money
		if(withdrawlAmount > Account.getAccountBalance()) {
			// If they don't have enough money print account balance and send them to customer menu
			System.out.println("Sorry, You dont have enough money.");
			System.out.println("You have $" + Account.getAccountBalance() + " in account #" + Account.getAccountNumber() + ".");
			customerActions(Account);
		} else {
			// If they have enough money withdrawal it from account
			Account.setAccountBalance(Account.getAccountBalance() - withdrawlAmount);
			AccountDaoImpl.updateAccount(Account);
			logger.info("Account #" + Account.getAccountNumber() + " withdrew $" + withdrawlAmount);
		}
	}

	// Method to deposit funds into account
	public static void depositFunds(Account Account) {
		// For administrator account if their inputs is invalid return to admin actions
		if(Account == null) {
			System.out.println("Invalid Account Number");
			Administrator.administratorActions();
		}
		
		System.out.println("How much money would you like to depost today?");
		// Check to make sure they entered a positive number
		double depositAmount = getPositiveDouble();
		Account.setAccountBalance(Account.getAccountBalance() + depositAmount);
		AccountDaoImpl.updateAccount(Account);
		logger.info("Account #" + Account.getAccountNumber() + " deposited $" + depositAmount);
	}

	// Method to transfer funds to an account
	public static void transferFunds() {
		// Get transferrers account from accountNumber
		System.out.println("What is the account number for the transferer?");
		String transfererAccountNumber = sc.next().toString();
		transferAccount = AccountDaoImpl.selectAccountByNumber(transfererAccountNumber);
		
		// Get receivers account from account number
		System.out.println("What is the account number to transfer to?");
		String receiverAccountNumber = sc.next().toString();
		receiverAccount = AccountDaoImpl.selectAccountByNumber(receiverAccountNumber);
		
		// If the accounts exist perform a transfer
		if(receiverAccount == null || transferAccount == null) {
			// If account(s) doesn't exist return to main menu
			System.out.println("Invalid account choices.");
			System.out.println("For safety purposes you have been returned to the main menu");
			BankMenu.getMainMenu();
		} else if(receiverAccountNumber.equals(receiverAccount.getAccountNumber()) && transfererAccountNumber.equals(transferAccount.getAccountNumber())) {
			System.out.println("How much money would you like to transfer?");
			double funds = getPositiveDouble();
			if (transferAccount.getAccountBalance() >= funds) {
				transferAccount.setAccountBalance(transferAccount.getAccountBalance() - funds);
				receiverAccount.setAccountBalance(receiverAccount.getAccountBalance() + funds);
				AccountDaoImpl.updateAccount(transferAccount);
				AccountDaoImpl.updateAccount(receiverAccount);
				System.out.println("You transferred $" + funds + " to Account #" + receiverAccountNumber + " account.");
				logger.info("$" + funds + " Transferred from Account #" + transferAccount.getAccountNumber() + " to account number #" + receiverAccount.getAccountNumber());
			} else {
				// If transferrer does't have enough money rinform them and return to main menu
				System.out.println("Sorry don't have enough funds for that transfer.\nYou have been returned to the main menu for safety purposes.");
				BankMenu.getMainMenu();
			}
			
		} else {
			// If account(s) doesn't exist return to main menu
			System.out.println("Invalid account choices.");
			System.out.println("For safety purposes you have been returned to the main menu");
			BankMenu.getMainMenu();
		}

	}

	
	// Makes sure the user inputs a positive double
	public static double getPositiveDouble() {
		double number;
		// Continue to loop through the users input until the submit a positive number
		do {
			// Make the scanner keep requesting user input until they submit a number
			while (!sc.hasNextDouble()) {
				// Print message to console informing user to enter a positive number
				System.out.println("Please Enter a Positive Number");
				// Call next to restart scanner input
				sc.next();
			}
			// Set input to number than check if it is a positive number
			number = sc.nextDouble();
		} while (number <= 0);

		return number;
	}

}
