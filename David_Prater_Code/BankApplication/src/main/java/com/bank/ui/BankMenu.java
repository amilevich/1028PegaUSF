package com.bank.ui;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.bank.model.Employee;
import com.bank.model.NewCustomer;
import com.bank.model.Person;

public class BankMenu {
	
	public static ArrayList<Integer> accountBalances = new ArrayList<Integer>();
	public static ArrayList<Person> customerList = new ArrayList<Person>();
	
	static Scanner sc = new Scanner(System.in);
	static NewCustomer newCustomer = new NewCustomer();
	static Employee employee = new Employee();
	static int mainMenuChoice;

	public static void getMainMenu() throws FileNotFoundException{
		System.out.println( "Please make a selection from the table below\n" +
						    "1. Apply for an account\n" +
							"2. Account Login\n" + 
						    "3. Employee Login\n" + 
							"4. Administrator Login");
		int mainMenuChoice = sc.nextInt();
		openMainMenuChoice(mainMenuChoice);
	}
	
		public static void openMainMenuChoice(int mainMenuChoice) throws FileNotFoundException {
		switch (mainMenuChoice) {
		case 1:
			System.out.println("New User");
			System.out.println("1. Single Account");
			System.out.println("2. Joint Account");
			int newCustomerChoice = sc.nextInt();
			
			switch (newCustomerChoice) {
			case 1:
				newCustomer.registerNewCustomer();
				break;

			case 2:
				newCustomer.registerJointCustomer();
				break;
			}
			System.out.println("Please try to log in later to see if you were approved!");
			getMainMenu();
			break;
		case 2:
			System.out.println("What is your username");
			String username = sc.next(); 
			System.out.println("What is your password?");
			String password = sc.next();
			String usernamePasswordKey = username + password;
			System.out.println(usernamePasswordKey);
		case 3:
			System.out.println("Please approve pending accounts.");
			employee.approveNewCustomer();
		case 4:
			System.out.println("Please login with your company issued account username.");
			String adminName = sc.next();
			System.out.println("Please login with your company issued password");
			String adminPassword = sc.next();
			String adminPasswordKey = adminName + adminPassword;
			System.out.println(adminPasswordKey);
		}
	}
	
}

