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

import com.bank.model.Administrator;
import com.bank.model.Customer;
import com.bank.model.Employee;
import com.bank.model.NewCustomer;
import com.bank.model.Person;

public class BankMenu {

	public static ArrayList<Person> customerList = new ArrayList<Person>();
	public static HashMap<String, Person> customerMap = new HashMap<>();

	static Scanner sc = new Scanner(System.in);
	static NewCustomer newCustomer = new NewCustomer();
	static Employee employee = new Employee();

	public static void getMainMenu() throws FileNotFoundException {

		System.out.println("Please make a selection from the table below\n" + "1. Apply for an account\n"
				+ "2. Account Login\n" + "3. Employee Login\n" + "4. Administrator Login\n" + "5. Exit Program");
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
			Customer.customerMenu();
			break;
		case "3":
			Employee.employeeMenu();
			break;
		case "4":
			Administrator.adminstratorMenu();
			break;
		case "5":
			// Write current accounts to file then terminate the program
			writeCustomerList();
			System.exit(0);
		default:
			getMainMenu();
		}
	}

	public static void writeCustomerList() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				"C:\\Users\\prate\\Documents\\My_Git_Repos\\1028PegaUSF\\David_Prater_Code\\BankApplication\\CustomerList.txt"))) {
			oos.writeObject(customerMap);
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public static void readCustomerList() {
		try {
			
			FileInputStream fis = new FileInputStream("C:\\Users\\prate\\Documents\\My_Git_Repos\\1028PegaUSF\\David_Prater_Code\\BankApplication\\CustomerList.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			customerMap = (HashMap<String, Person>) ois.readObject();
			
			ois.close();
			fis.close();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
			return;
		}

	}

}
