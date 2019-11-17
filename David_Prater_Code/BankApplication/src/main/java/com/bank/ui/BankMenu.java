package com.bank.ui;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.bank.model.Administrator;
import com.bank.model.Employee;
import com.bank.model.NewCustomer;
import com.bank.model.Person;

public class BankMenu {
	
	public static ArrayList<Integer> accountBalances = new ArrayList<Integer>();
	public static ArrayList<Person> customerList = new ArrayList<Person>();
	
	static Scanner sc = new Scanner(System.in);
	static NewCustomer newCustomer = new NewCustomer();
	static Employee employee = new Employee();


	public static void getMainMenu() throws FileNotFoundException{
		System.out.println( "Please make a selection from the table below\n" +
						    "1. Apply for an account\n" +
							"2. Account Login\n" + 
						    "3. Employee Login\n" + 
							"4. Administrator Login\n" +
						    "5. Exit Program");
		String mainMenuChoice = sc.next().toString();
		openMainMenuChoice(mainMenuChoice);
	}
	
		public static void openMainMenuChoice(String mainMenuChoice) throws FileNotFoundException {
		switch (mainMenuChoice) {
		case "1":
			System.out.println("New User");
			System.out.println("1. Single Account");
			System.out.println("2. Joint Account");
			String newCustomerChoice = sc.next().toString();
			
			switch (newCustomerChoice) {
			case "1":
				newCustomer.registerNewCustomer();
				break;

			case "2":
				newCustomer.registerJointCustomer();
				break;
			default: 
				openMainMenuChoice("1");
			}
			break;
		case "2":
			System.out.println("What is your username");
			String username = sc.next(); 
			System.out.println("What is your password?");
			String password = sc.next();
			String usernamePasswordKey = username + password;
			System.out.println(usernamePasswordKey);
			break;
		case "3":
			Employee.employeeMenu();
			break;
		case "4":
			Administrator.adminstratorMenu();
			break;
		case "5":
			// Write current accounts to file then terminate the program
		default:
			getMainMenu();
		}
	}
	
}

