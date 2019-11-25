package com.projectzero.menu;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.projectzero.dao.AccountDaoImpl;
import com.projectzero.dao.CustomerDaoImpl;

import project0PartOne.Account;
import project0PartOne.Customer;

import com.projectzero.validation.Validation;

public class CustomerMenu {
	///////////////////////////////////////THIS IS THE CLASS WHERE ALL CUSTOMER FEATURES PERSIST///////////////////////////////////////
	//---Down below is the objects used in this class
	final static Logger log = Logger.getLogger(CustomerMenu.class);
	CustomerDaoImpl cusDaoImpl = new CustomerDaoImpl();
	AccountDaoImpl accDaoImpl = new AccountDaoImpl();
	AccountMenu aCm = new AccountMenu();
	
	public static String promptString(Scanner input, String prompt) {
		
		return input.next();
	}
	//-----Down below is the method that allows customer to enter username and check if it exists in database
	//----if it exists we call second method
	public void customerSignIn1() {
		Scanner input = new Scanner(System.in);
		System.out.print("Entery your username: ");
		String username = input.next();
		cusDaoImpl.customerExists(username);
		customerSignIn2();
		}
	//-----This is the second method where the customer enters password and check if password exists in database
	public void customerSignIn2() {
		Scanner input = new Scanner(System.in);
		System.out.print("Password: ");
		String password = input.next();
		cusDaoImpl.customerExists2(password);
	}
	//----Down below is the method that allows the customer to register
	//----for the customer to register the following credentials are needed:
	//----CustomerID,First name, last name, user name, password
	//---then we add customer to database with there account status pending to the database
	public void customerRegistration() {
		log.warn("Customer registration is activated");
		Customer newCust = new Customer(); //<-----------------customer object
		Scanner inp = new Scanner(System.in);//<---------------scanner input
		System.out.print("Create customer! ");
		System.out.print("ID: ");
		int id = inp.nextInt();
		newCust.setCustomerID(id);
		System.out.print("Enter First Name: ");
		String fname = inp.next();
		newCust.setCustomerFirstName(fname);
		System.out.print("Enter Last Name: ");
		String lname = inp.next();
		newCust.setCustomerLastName(lname);
		System.out.println("Create username: ");
		String username = inp.next();
		newCust.setCustomerUsername(username);
		if (!cusDaoImpl.isUsernameUnique(newCust)) {
			System.out.println("username already exists please use a different one!");
			log.warn("Customer registration was deactivated due to username already in the database");
			customerRegistration();
		}
		System.out.println("Create password: ");
		String password = inp.next();
		newCust.setCustomerPassword(password);
		if(!cusDaoImpl.ispasswordUnique(newCust)) {
			System.out.println("password already exists please use a different one!");
			log.warn("Customer registration was deactivated due to password already in the database");
			customerRegistration();
		}
		Customer customer = new Customer(newCust.getCustomerID(), newCust.getCustomerFirstName(),
				newCust.getCustomerLastName(), newCust.getCustomerUsername(), newCust.getCustomerPassword());

		cusDaoImpl.createCustomer(customer);
				aCm.accountRegistration(id);
			
		
	}

}
