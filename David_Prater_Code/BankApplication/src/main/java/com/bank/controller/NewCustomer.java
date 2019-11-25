package com.bank.controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.model.Account;
import com.bank.view.BankMenu;


public class NewCustomer {

	final static Logger logger = Logger.getLogger(NewCustomer.class);
	Scanner sc = new Scanner(System.in);
	public static ArrayList<Account> newCustomerList = new ArrayList<>();
	public static String accountNumber = null;



	// This method collects all the information about the customer and adds them to the new customer list
	public void registerNewCustomer() {
		
		System.out.println("What is your first name?");
		String firstName = sc.nextLine();
		System.out.println("What is your last name?");
		String lastName = sc.nextLine();
		System.out.println("What is your address");
		String address = sc.nextLine();
		System.out.println("Please create a username.");
		String username = sc.nextLine();
		System.out.println("Please choose a password.");
		String password = sc.nextLine();
		accountNumber = generateAccountNumber();
		//Create a new customer object and add them the ArrayList of new customers pending approval or denial
		Account newUser = new Account(accountNumber, 0, firstName, lastName, address, username, password);
		newCustomerList.add(newUser);
		logger.info("New account created succesfully. " + newUser);

		System.out.println("Please try to log in later to see if you were approved!");
		BankMenu.getMainMenu();


	}
	
	public void registerJointCustomer() {
		
		String accountNumber = generateAccountNumber();
		System.out.println("Please Enter Informtaion for User One");
		System.out.println("What is your first name?");
		String firstName = sc.nextLine();
		System.out.println("What is your last name?");
		String lastName = sc.nextLine();
		System.out.println("What is your address");
		String address = sc.nextLine();
		System.out.println("Please create a username.");
		String username = sc.nextLine();
		System.out.println("Please choose a password.");
		String password = sc.nextLine();
		
		System.out.println("Please Enter Informtaion for User Two");
		System.out.println("What is your first name?");
		String firstName2 = sc.nextLine();
		System.out.println("What is your last name?");
		String lastName2 = sc.nextLine();
		System.out.println("What is your address");
		String address2 = sc.nextLine();
		System.out.println("Please create a username.");
		String username2 = sc.nextLine();
		System.out.println("Please choose a password.");
		String password2 = sc.nextLine();

		//Create a new customer object and add them the ArrayList of new customers pending approval or denial
		Account newUser = new Account(accountNumber, 0, firstName, lastName, address, username, password);
		newCustomerList.add(newUser);
		newUser = new Account(accountNumber, 0, firstName2, lastName2, address2, username2, password2);
		newCustomerList.add(newUser);
		logger.info("New joint account created succesfully.\n" + newUser);


		System.out.println("Please try to log in later to see if you were approved!");
		BankMenu.getMainMenu();

	}
	
	// This generate a random number between 100000 and 1 and returns it as a string
	public static String generateAccountNumber() {
		Random r = new Random();
		int randomAccountNumber = r.nextInt((100000 - 1) + 1) + 1;
		// Convert the integer to a string
		return Integer.toString(randomAccountNumber);
	}
	
}
