package com.bank.model;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.model.Person;
import com.bank.ui.BankMenu;

import java.io.*;

public class NewCustomer implements Serializable {

	private static final long serialVersionUID = -3579390326967818657L;
	final static Logger logger = Logger.getLogger(NewCustomer.class);
	Scanner sc = new Scanner(System.in);
	public static ArrayList<Person> newCustomerList = new ArrayList<>();
	public static String accountNumber = null;



	// This method collects all the information about the customer and adds them to the new customer list
	public void registerNewCustomer() throws FileNotFoundException {
		
		System.out.println("What is your first name?");
		String firstName = sc.nextLine();
		System.out.println("What is your last name?");
		String lastName = sc.nextLine();
		System.out.println("What is your address");
		String address = sc.nextLine();
		System.out.println("What is your phone number?");
		String phoneNumber = sc.nextLine();
		System.out.println("What is your email?");
		String email = sc.nextLine();
		System.out.println("Please create a username.");
		String username = sc.nextLine();
		System.out.println("Please choose a password.");
		String password = sc.nextLine();

		//Create a new customer object and add them the ArrayList of new customers pending approval or denial
		Person newUser = new Person(accountNumber, firstName, lastName, address, phoneNumber, email, username, password);
		newCustomerList.add(newUser);
		logger.info("New account created succesfully. " + newUser);

		System.out.println("Please try to log in later to see if you were approved!");
		BankMenu.getMainMenu();


	}
	
	public void registerJointCustomer() throws FileNotFoundException {
		
		System.out.println("Please Enter Informtaion for User One");
		System.out.println("What is your first name?");
		String firstName = sc.nextLine();
		System.out.println("What is your last name?");
		String lastName = sc.nextLine();
		System.out.println("What is your address");
		String address = sc.nextLine();
		System.out.println("What is your phone number?");
		String phoneNumber = sc.nextLine();
		System.out.println("What is your email?");
		String email = sc.nextLine();
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
		System.out.println("What is your phone number?");
		String phoneNumber2 = sc.nextLine();
		System.out.println("What is your email?");
		String email2 = sc.nextLine();
		System.out.println("Please create a username.");
		String username2 = sc.nextLine();
		System.out.println("Please choose a password.");
		String password2 = sc.nextLine();

		//Create a new customer object and add them the ArrayList of new customers pending approval or denial
		Person newUser = new Person(accountNumber, firstName, lastName, address, phoneNumber, email, username, password, firstName2, lastName2, address2, phoneNumber2, 
				email2, username2, password2);
		newCustomerList.add(newUser);
		logger.info("New joint account created succesfully.\n" + newUser);


		System.out.println("Please try to log in later to see if you were approved!");
		BankMenu.getMainMenu();

	}
}
