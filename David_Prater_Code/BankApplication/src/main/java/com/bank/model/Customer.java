package com.bank.model;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.ui.BankMenu;

public class Customer {

	// Create the logger and scanner variables
	final static Logger logger = Logger.getLogger(Customer.class);
	static Scanner sc = new Scanner(System.in);
	
	// Create null Person object to be used for the current person that is logged in
	static Person currentPerson = null;
	// Create Person objects to be used for the person transferring money and the person receiving money
	static Person transferPerson = null;
	static Person receiverPerson = null;

	// This method logs in the customer and sends them to the customer menu
	public static void customerMenu() throws FileNotFoundException {

		// Get input for the users username and password
		System.out.println("Please Enter Your Username.");
		String username = sc.next().toString();
		System.out.println("Please Enter Your Password.");
		String password = sc.next().toString();
		// Combine the username and password because this is their key in the customer HashMap
		String passwordKey = username + password;
		
		// If the users submitted a correct key log them in to the customer menu
		if(BankMenu.customerMap.containsKey(passwordKey)) {
			// Set the current customer to access that person details
			currentPerson = BankMenu.customerMap.get(passwordKey);
			customerActions(currentPerson);
		} else {
			// If login fails print failure message and send them to the main menu
			System.out.println("Invalid Username or Password. Please Try Logging in Again");
			BankMenu.getMainMenu();
		}

	}

	// This method has the menu for actions the customer can perform. (View Account, Withdrawal, Deposit, and Transfer)
	public static void customerActions(Person person) throws FileNotFoundException {
		// **person.toString();
		System.out.println("What would you like to do today?");
		System.out.println("1. View Account Balance\n2. Withdraw Funds\n3. Deposit Funds\n4. TransferFunds\n5. Logout");
		// Convert all input to a string to handle input validation
		String actionChoice = sc.next().toString();

		// Switch to the selected customer action if default call the customer actions method again
		switch (actionChoice) {
		case "1":
			// Print account number and balance for customer
			System.out.println("Account Number: " + currentPerson.getAccountNumber());
			System.out.println("Balance: $" + currentPerson.getAccountBalance());
			break;
		case "2":
			// Withdrawal funds from customer account
			withdrawalFunds(currentPerson);
			customerActions(currentPerson);
			break;
		case "3":
			// Deposit funds to customer account
			depositFunds(currentPerson);
			customerActions(currentPerson);
			break;
		case "4":
			// Transfer funds between to customers
			transferFunds();
			customerActions(currentPerson);
			break;
		case "5":
			// Log the customer out
			System.out.println("Logout succesful.");
			BankMenu.getMainMenu();
			break;
		default:
			// This handles input validation because it calls it self recursively if it it does't match a case.
			customerActions(currentPerson);
		}

		// Call method recursively to allow the user to perform more actions
		customerActions(currentPerson);
	}

	// Method to withdrawal funds from account
	public static void withdrawalFunds(Person person) throws FileNotFoundException {
		System.out.println("How much money would you like to withdrawal today?");
		// This method makes sure the user entered a positive number
		double withdrawlAmount = getPositiveDouble();
		// Check to make sure they have enough money
		if(withdrawlAmount > person.getAccountBalance()) {
			// If they dont have enough money print account balance and send them to customer menu
			System.out.println("Sorry, You dont have enough money.");
			System.out.println("You have $" + person.getAccountBalance() + " in account #" + person.getAccountNumber() + ".");
			customerActions(person);
		} else {
			// If they have enough money withdrawal it from account
			person.setAccountBalance(person.getAccountBalance() - withdrawlAmount);
			logger.info("Account #" + person.getAccountNumber() + " withdrew $" + withdrawlAmount);
		}
	}

	// Method to deposit funds into account
	public static void depositFunds(Person person) {
		System.out.println("How much money would you like to depost today?");
		// Check to make sure they entered a positive number
		double depositAmount = getPositiveDouble();
		person.setAccountBalance(person.getAccountBalance() + depositAmount);
		logger.info("Account #" + person.getAccountNumber() + " deposited $" + depositAmount);
	}

	// Method to transfer funds to an account
	public static void transferFunds() throws FileNotFoundException {
		// Get receivers username and password which equals key to access the account
		System.out.println("What is the username of the account you wish to transfer to?");
		String receiverName = sc.next().toString();
		System.out.println("What is the password of the account you wish to transfer to?");
		String receiverPassword= sc.next().toString();
		String receiverKey = receiverName + receiverPassword;
		
		// Get transferrers username and password which equals key to access the account
		System.out.println("What is the username of the account you wish to transfer to?");
		String transfererName = sc.next().toString();
		System.out.println("What is the password of the account you wish to transfer to?");
		String transfererPassword= sc.next().toString();
		String transfererKey = transfererName + transfererPassword;
		
		// Check if transfer account exists
		if(BankMenu.customerMap.containsKey(transfererKey)) {
			 transferPerson = BankMenu.customerMap.get(transfererKey);
		} else {
			System.out.println("For safety purposes you have been returned to the main menu?");
			BankMenu.getMainMenu();
		}
		
		// Check if receivers account exist
		if(BankMenu.customerMap.containsKey(receiverKey)) {
			receiverPerson = BankMenu.customerMap.get(receiverKey);
		} else {
			System.out.println("For safety purposes you have been returned to the main menu?");
			BankMenu.getMainMenu();
		}
		
		// Get funds amount and check if it positive
		System.out.println("How much money would you like to transfer?");
		double funds = getPositiveDouble();

		// Check to make sure transferrer has enough funds if so transfer from their account to receiver
		// If they don't have enough funds notify them and send them to the main menu
		if (transferPerson.getAccountBalance() >= funds) {
			transferPerson.setAccountBalance(transferPerson.getAccountBalance() - funds);
			receiverPerson.setAccountBalance(receiverPerson.getAccountBalance() + funds);
			System.out.println("You transferred $" + funds + " to " + receiverName + " account.");
			logger.info("$" + funds + " Transferred from Account #" + transferPerson.getAccountNumber() + " to account number #" + receiverPerson.getAccountNumber());
		} else {
			System.out.println("Sorry aren't have enough funds for that transfer.\nYou have been returned to the main menu for safety purposes.");
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
