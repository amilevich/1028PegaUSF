package com.bank.ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.model.Administrator;
import com.bank.model.Customer;
import com.bank.model.Employee;
import com.bank.model.NewCustomer;
import com.bank.model.Person;

public class BankMenu {

	// Create ArrayList to store a Person objects for people applying for an account
	public static ArrayList<Person> newCustomerList = new ArrayList<Person>();
	// Create HashMap to store a customers Person object and key. (This is what is WRITTEN and READ to the file)
	public static HashMap<String, Person> customerMap = new HashMap<>();

	// Create scanner to collect user input
	static Scanner sc = new Scanner(System.in);
	// Instantiate classes to access these classes methods
	static NewCustomer newCustomer = new NewCustomer();
	static Employee employee = new Employee();

	// This method is the main menu for the entire applications
	public static void getMainMenu() throws FileNotFoundException {

		System.out.println("Please make a selection from the table below\n" + "1. Apply for an account\n"
				+ "2. Account Login\n" + "3. Employee Login\n" + "4. Administrator Login\n" + "5. Exit Program");
		// Convert to string to perform input validation and open corresponding menu
		String mainMenuChoice = sc.next().toString();
		openMainMenuChoice(mainMenuChoice);
	}

	// This method takes in the user input
	public static void openMainMenuChoice(String mainMenuChoice) throws FileNotFoundException {
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
			writeCustomerList();
			System.exit(0);
		default:
			// If user input doesn't match an action call the this method recursively until they input a valid action
			getMainMenu();
		}
	}

	// This method writes the customerHashMap to the corresponding directory for the CustomerList.txt file
	public static void writeCustomerList() {
		// If the file location exists, serialize the data. If it doesn't exist catch exception
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				"C:\\Users\\prate\\Documents\\My_Git_Repos\\1028PegaUSF\\David_Prater_Code\\BankApplication\\CustomerList.txt"))) {
			oos.writeObject(customerMap);
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	// This method reads the customerHashMap from the corresponding directory for the CustomerList.txt file
	public static void readCustomerList() {
		// If the file location exists, deserialize the data. If it doesn't exist catch exception
		try {
			// Create FileInputStream and ObjectOutpuStream to deserialize the data
			FileInputStream fis = new FileInputStream("C:\\Users\\prate\\Documents\\My_Git_Repos\\1028PegaUSF\\David_Prater_Code\\BankApplication\\CustomerList.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			// Set customerMap equal to the specified data type and read deserialize the data
			customerMap = (HashMap<String, Person>) ois.readObject();
			
			// Close FileInputStream and ObjectOutpuStream
			ois.close();
			fis.close();
			// Catch the exceptions
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
			return;
		}

	}

}
