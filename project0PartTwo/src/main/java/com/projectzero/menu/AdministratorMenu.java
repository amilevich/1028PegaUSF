package com.projectzero.menu;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.projectzero.dao.AccountDaoImpl;
import com.projectzero.dao.CustomerDaoImpl;

import project0PartOne.Account;
import project0PartOne.Customer;

public class AdministratorMenu {
	//////////////////////////////////////THIS IS THE CLASS THAT HAS THE ADMINISTRATOR FEATURES FOR THEIR MENU
	//--Down below is the method that will show in console the options that an administrator can choose
	//--Basic operations such as : view customers, approve an account, deny an account,edit,cancel,deposit
	//--withdrawal,transfer, go back to options, quit to log out
	//--we do not need to write all these methods because we can inherit or use the methods
	static Customer custtAc = new Customer();
	final static Logger log = Logger.getLogger(AdministratorMenu.class);
	public static void adminMenu() {
		AccountDaoImpl acDaoImpl = new AccountDaoImpl();
		Scanner input = new Scanner(System.in);
		BankMenu bKm = new BankMenu();
		System.out.println(" Choose an option: ");
		System.out.println(" 'a' : View Customers ");
		System.out.println(" 'b' : Approve an account ");
		System.out.println(" 'c' : Deny an account");
		System.out.println(" 'd' : Edit an account");
		System.out.println(" 'e' : Cancel an account");
		System.out.println(" 'f' : Deposit");
		System.out.println(" 'g' : Withdrawal");
		System.out.println(" 'h' : Transfer");
		System.out.println(" 'i' : Go Back");
		System.out.println(" 'q' : Quit");
		System.out.print(" Enter option here: ");
		char option;
		String input2;
		do {
			input2 = input.next();
			option = input2.charAt(0);
			switch (option) {
			case 'a':
				// view Customers
				System.out.println(acDaoImpl.getAllAccounts());
				System.out.print("d to go back or q to quit: ");
				break;
			case 'b':
				// approve method
				EmployeeMenu.approve();
				break;
			case 'c':
				// deny method
				EmployeeMenu.Deny();
				break;
			case 'd':
				// Edit method
				edit();
				break;
			case 'e':
				// Cancel method
				
				break;
			case 'f':
				// Deposit method
				BankMenu.Deposit();
				break;
			case 'g':
				// withdrawal method
				BankMenu.Withdrawal();
				break;
			case 'h':
				// Transfer method
				BankMenu.transfer();
				break;
			case 'i':
				// Main Menu
				EmployeeMenu.employeeMenu();
				break;
			case 'q':
				// quits the program
				bKm.bankMenu();
				break;
			default:
				System.out.println("You entered the wrong option");
			}
		} while (option != 'q');
		
	}
	public static void edit() {
		log.warn("The edit operation by admin is activated");
		Scanner input = new Scanner(System.in);
		AccountDaoImpl acDaoImpl = new AccountDaoImpl();
		CustomerDaoImpl cusDaoImpl = new CustomerDaoImpl();
		
		//----in order for the administrator to edit an account they need to enter the customer's id
		//----then we get the account from the database by id and store in object
		//----then we set the changes to what administrator inputs and then we update the account
		System.out.print("Enter Customer Account ID you which to edit: ");
		int customerID = input.nextInt();
		System.out.println(cusDaoImpl.getCustomerByID(customerID));
		System.out.println("_______________________________________________________________________");
		
		custtAc = cusDaoImpl.getCustomerByID(customerID);
		System.out.println("What do yo want to edit?:");
		System.out.println("1. Customer first name:");
		System.out.println("2. Customer last name:");
		System.out.println("3. Customer username:");
		System.out.println("4. Customer password:");
		System.out.print("choose option: ");
		String op = input.next();
		if(op.equals("1")) {
			System.out.print("Enter the customer's name: ");
			String name = input.next();
			custtAc.setCustomerFirstName(name);
			System.out.println("Customer#: " + customerID + " name has beed changed to " + name);
			log.info("Customer# " + customerID + " name was edited to " + name);
		}else if(op.equals("2")){
			System.out.print("Enter the customer's last name: ");
			String lname = input.next();
			custtAc.setCustomerLastName(lname);
			System.out.println("Customer#: " + customerID + " last name has beed changed to " + lname);
			log.info("Customer# " + customerID + " lat name was edited to " + lname);
		}else if(op.equals("3")){
			System.out.print("Enter the customer's username: ");
			String username = input.next();
			custtAc.setCustomerUsername(username);
			System.out.println("Customer#: " + customerID + " user name has beed changed to " + username);
			log.info("Customer# " + customerID + " user name was edited to " + username);
		}	
		else if(op.equals("4")){
			System.out.print("Enter the customer's password: ");
			String password = input.next();
			custtAc.setCustomerUsername(password);
			System.out.println("Customer#: " + customerID + " password has beed changed to " + password);
			log.info("Customer# " + customerID + " password was edited to " + password);
		}	
	}
	public static void cancel() {
		log.warn("The cancel operation by admin is activated");
		Scanner input = new Scanner(System.in);
		AccountDaoImpl acDaoImpl = new AccountDaoImpl();
		CustomerDaoImpl cusDaoImpl = new CustomerDaoImpl();
		Account delAc = new Account();
		Customer delC = new Customer();
		
		//----in order for the administrator to delete an account they need to enter the customer's id and account id
		System.out.print("Enter Customer ID you which to cancel: ");
		int customerID = input.nextInt();
		System.out.print("Enter account ID you which to cancel: ");
		int acID = input.nextInt();
		System.out.println(cusDaoImpl.getCustomerByID(customerID));
		System.out.println(acDaoImpl.getAccountById(acID));
		delC = cusDaoImpl.getCustomerByID(customerID);
		delAc = acDaoImpl.getAccountById(acID);
		System.out.println("_______________________________________________________________________");
		System.out.print("Are you sure you want to cancel?, (y) for yes, (n) for no: ");
		String optt = input.next();
		if(optt.equals("y")) {
			cusDaoImpl.deleteCustomer(delC);
			acDaoImpl.deleteAccount(delAc);
		}
	}
}
