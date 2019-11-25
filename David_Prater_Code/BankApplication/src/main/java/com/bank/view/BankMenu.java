package com.bank.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.bank.controller.Administrator;
import com.bank.controller.Customer;
import com.bank.controller.Employee;
import com.bank.controller.NewCustomer;
import com.bank.model.Account;

public class BankMenu {

	// Create ArrayList to store a Account objects for people applying for an account
	public static ArrayList<Account> newCustomerList = new ArrayList<Account>();
	// Create HashMap to store a customers Account object and key. (This is what is WRITTEN and READ to the file)
	public static HashMap<String, Account> customerMap = new HashMap<>();

	// Create scanner to collect user input
	static Scanner sc = new Scanner(System.in);
	// Instantiate classes to access these classes methods
	static NewCustomer newCustomer = new NewCustomer();
	static Employee employee = new Employee();

	// This method is the main menu for the entire applications
	public static void getMainMenu() {

		System.out.println("Please make a selection from the table below\n" + "1. Apply for an account\n"
				+ "2. Account Login\n" + "3. Employee Login\n" + "4. Administrator Login\n" + "5. Exit Program");
		// Convert to string to perform input validation and open corresponding menu
		String mainMenuChoice = sc.next().toString();
		openMainMenuChoice(mainMenuChoice);
	}

	// This method takes in the user input
	public static void openMainMenuChoice(String mainMenuChoice) {
		switch (mainMenuChoice) {
		case "1":
			// Menu for the user to choose single or joint account
			System.out.println("New User");
			System.out.println("1. Single Account");
			System.out.println("2. Joint Account");
			String newCustomerChoice = sc.next().toString();

			// Switch menu to correct screen from user input
			switch (newCustomerChoice) {
			case "1":
				// Register single account
				newCustomer.registerNewCustomer();
				break;

			case "2":
				// Register joint account
				newCustomer.registerJointCustomer();
				break;
			default:
				// If they input an invalid option call the add account menu
				openMainMenuChoice("1");
			}
			break;
		case "2":
			// Display customer menu
			Customer.customerMenu();
			break;
		case "3":
			// Display employee menu
			Employee.employeeMenu();
			break;
		case "4":
			// Display administrator menu
			Administrator.adminstratorMenu();
			break;
		case "5":
			// Write current accounts to file then terminate the program
			System.exit(0);
		default:
			// If user input doesn't match an action call the this method recursively until they input a valid action
			getMainMenu();
		}
	}



}
