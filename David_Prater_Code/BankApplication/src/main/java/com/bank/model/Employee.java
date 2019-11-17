package com.bank.model;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.bank.ui.BankMenu;

public class Employee {

	static Scanner sc = new Scanner(System.in);
	
	
	public static void employeeMenu() throws FileNotFoundException {
		System.out.println("Please login with your company issued account username.");
		String employeeName = sc.next().toString();
		
		// If the user name is correct check the password. If either are incorrect send the user back to the main menu
		if (employeeName.equals("employee")) {
			System.out.println("Please login with your company issued password");
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

	public static void employeeActions() throws FileNotFoundException {
		
		Employee.approveNewCustomer();
		System.out.println("What would you like to do today?");
		System.out.println("1. View All Acounts\n2. Logout");
		String actionChoice =  sc.next().toString();

		switch (actionChoice) {
		case "1":
			viewAllAccounts();
			employeeMenu();
			break;
		case "2":
			System.out.println("Logout succesful.");
			BankMenu.getMainMenu();
		default:
			employeeMenu();
		}
	
		employeeActions();
	}
	

	
	// This method allows the current user to approve or deny pending accounts
	public static void approveNewCustomer() {

		// Loop through the arraylist of newCustomers and have the user choose whether
		// to approve or deny each account
		for (Person newCustomer : NewCustomer.newCustomerList) {
			System.out.println("Press 'y' to approve account and 'n' to deny the account.");
			String output = newCustomer.toString();
			System.out.println(output);
			
			// This do while loop runs until the current user approves or denies the pending account
			// Set choice to z to make sure it runs
			String choice = "z";
			do {
				choice = sc.next().toString();
				if (choice.equals("y")) {
					BankMenu.customerList.add(newCustomer);
					break;
				} else if (choice.equals("n")) {
					System.out.println("Denied");
				} else {
					System.out.println("Press 'y' to approve account and 'n' to deny the account.");
				}
			} while (!choice.equals("n") || !choice.equals("n"));

		}
		
		// This line makes the new arraylist empty
		NewCustomer.newCustomerList.removeAll(NewCustomer.newCustomerList);
		
	}
	
	public static void viewAllAccounts() {
		for(Person p : BankMenu.customerList) {
			String output = p.toString();
			System.out.println(output);
		}
	}
	
}


