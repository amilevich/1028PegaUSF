package com.bank.model;

import java.util.ArrayList;
import java.util.Scanner;

import com.bank.model.Person;

import java.io.*;

public class NewCustomer implements Serializable {

	private static final long serialVersionUID = -3579390326967818657L;
	Scanner sc = new Scanner(System.in);
	public static ArrayList<Person> newCustomerList = new ArrayList<>();

	/**
	 * Collect all information for the new user
	 */

	public ArrayList<Person> registerNewCustomer() {
				
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

		//Create a new customer object
		Person newUser = new Person(firstName, lastName, address, phoneNumber, email, username, password);
		newCustomerList.add(newUser);
		System.out.println(newCustomerList.toString());
		
		
		
//		try {
//			FileOutputStream fileOut = new FileOutputStream(
//					"C:/Users/prate/Documents/My_Git_Repos/1028PegaUSF/David_Prater_Code/BankApplication/NewCustomerList.txt");
//			ObjectOutputStream out = new ObjectOutputStream(fileOut);
//			out.writeObject(newUser);
//			out.close();
//			fileOut.close();
//			System.out.printf("Serialized data is saved. \n");
//		} catch (IOException i) {
//			i.printStackTrace();
//		}

		return newCustomerList;

	}
	
	public void registerJointCustomer() {
		registerNewCustomer();
		registerNewCustomer();

	}
}
