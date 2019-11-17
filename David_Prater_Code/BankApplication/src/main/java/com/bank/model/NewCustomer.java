package com.bank.model;

import java.util.ArrayList;
import java.util.Scanner;

import com.bank.model.Person;
import com.bank.ui.BankMenu;

import java.io.*;

public class NewCustomer implements Serializable {

	private static final long serialVersionUID = -3579390326967818657L;
	Scanner sc = new Scanner(System.in);
	public static ArrayList<Person> newCustomerList = new ArrayList<>();


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
		Person newUser = new Person(firstName, lastName, address, phoneNumber, email, username, password);
		newCustomerList.add(newUser);


		System.out.println("Please try to log in later to see if you were approved!");
		BankMenu.getMainMenu();


	}
	
	public void registerJointCustomer() throws FileNotFoundException {
		registerNewCustomer();
		registerNewCustomer();

	}
}
