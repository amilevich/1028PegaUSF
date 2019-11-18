package com.bank.model;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.bank.ui.BankMenu;

public class Customer {

	static Scanner sc = new Scanner(System.in);
	static Person currentPerson = null;
	static Person transferPerson = null;
	static Person recieverPerson = null;

	public static void customerMenu() throws FileNotFoundException {

		System.out.println("Please Enter Your Username.");
		String username = sc.next().toString();
		System.out.println("Please Enter Your Password.");
		String password = sc.next().toString();
		String passwordKey = username + password;
		
		if(BankMenu.customerMap.containsKey(passwordKey)) {
			currentPerson = BankMenu.customerMap.get(passwordKey);
			customerActions(currentPerson);
		} else {
			System.out.println("Invalid Username. Please Try Logging in Again");
			BankMenu.getMainMenu();
		}

		// If the user name is correct check the password. If either are incorrect send
		// the user back to the main menu

	}

	public static void customerActions(Person person) throws FileNotFoundException {
		person.toString();
		System.out.println("What would you like to do today?");
		System.out.println("1. View Account Balance\n2. Withdraw Funds\n3. Deposit Funds\n4. TransferFunds\n5. Logout");
		String actionChoice = sc.next().toString();

		switch (actionChoice) {
		case "1":
			System.out.println("Account Number: " + currentPerson.getAccountNumber());
			System.out.println("Balance: $" + currentPerson.getAccountBalance());
			break;
		case "2":
			// Withdrawal
			withdrawalFunds(currentPerson);
			customerActions(currentPerson);
			break;
		case "3":
			depositFunds(currentPerson);
			customerActions(currentPerson);
			break;
		case "4":
			transferFunds();
			customerActions(currentPerson);
			break;
		case "5":
			System.out.println("Logout succesful.");
			BankMenu.getMainMenu();
			break;
		default:
			customerActions(currentPerson);
		}

		customerActions(currentPerson);
	}

	// Method to withdrawal funds from account
	public static void withdrawalFunds(Person person) {
		System.out.println("How much money would you like to withdrawal today?");
		double withdrawlAmount = getPositiveDouble();
		if(withdrawlAmount > person.getAccountBalance()) {
			System.out.println("Sorry, You dont have enough money.");
			withdrawalFunds(person);
		} else {
			person.setAccountBalance(person.getAccountBalance() - withdrawlAmount);
		}
	}

	// Method to deposit funds into account
	public static void depositFunds(Person person) {
		System.out.println("How much money would you like to depost today?");
		double depositAmount = getPositiveDouble();
		person.setAccountBalance(person.getAccountBalance() + depositAmount);
	}

	// Method to transfer funds to an account
	public static void transferFunds() throws FileNotFoundException {
		System.out.println("What is the username of the account you wish to transfer to?");
		String receiverName = sc.next().toString();
		System.out.println("What is the password of the account you wish to transfer to?");
		String receiverPassword= sc.next().toString();
		String receiverKey = receiverName + receiverPassword;
		
		System.out.println("What is the username of the account you wish to transfer to?");
		String transfererName = sc.next().toString();
		System.out.println("What is the password of the account you wish to transfer to?");
		String transfererPassword= sc.next().toString();
		String transfererKey = transfererName + transfererPassword;
		
		if(BankMenu.customerMap.containsKey(transfererKey)) {
			 recieverPerson = BankMenu.customerMap.get(transfererKey);
		} else {
			System.out.println("For safety purposes you have been returned to the main menu?");
			BankMenu.getMainMenu();
		}
		
		if(BankMenu.customerMap.containsKey(receiverKey)) {
			transferPerson = BankMenu.customerMap.get(receiverKey);
		} else {
			System.out.println("For safety purposes you have been returned to the main menu?");
			BankMenu.getMainMenu();
		}
		
		System.out.println("How much money would youh like to transfer?");
		double funds = getPositiveDouble();

		if (transferPerson.getAccountBalance() >= funds) {
			transferPerson.setAccountBalance(transferPerson.getAccountBalance() - funds);
			recieverPerson.setAccountBalance(recieverPerson.getAccountBalance() + funds);
			System.out.println("You transferred $" + funds + " to " + receiverName + " account.");

		} else {
			System.out.println("Sorry you dont have enough funds.\nYou have been returned to the main menu");
			BankMenu.getMainMenu();
		}

	}

	
	// Makes sure the user inputs a positive double
	public static double getPositiveDouble() {
		double number;
		do {
			while (!sc.hasNextDouble()) {
				System.out.println("Please Enter a Positive Number");
				sc.next(); // this is important!
			}
			number = sc.nextDouble();
		} while (number <= 0);

		return number;
	}

}
