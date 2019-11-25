package com.projectzero.menu;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.projectzero.dao.AccountDaoImpl;

import project0PartOne.Account;
import project0PartOne.Employee;

public class EmployeeMenu {
	///////////////////////////////////////////////THIS IS THE CLASS WHERE EPLOYEE FEATURES PERSIST//////////////////////////////////
	//-----------Down below are the objects that will be used
	final static Logger log = Logger.getLogger(EmployeeMenu.class);
	static Scanner input = new Scanner(System.in);
	static AccountDaoImpl acDaoImpl = new AccountDaoImpl();
	static Employee em = new Employee();
	static BankMenu bankm = new BankMenu();
	//-----------------Down below is the menu for employee
	public static void employeeMenu() {
		log.warn("Employee menu has been activated");
		System.out.println(" Choose an option: ");
		System.out.println(" 'a' : View Customers ");
		System.out.println(" 'b' : Approve an account ");
		System.out.println(" 'c' : Deny an account");
		System.out.println(" 'd' : Go Back");
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
				approve();
				break;
			case 'c':
				// deny method
				
				break;
			case 'd':
				// Main Menu
				employeeMenu();
				break;
			case 'q':
				// quits the program
				
				break;
			default:
				System.out.println("You entered the wrong option");
			}
		} while (option != 'q');
	}
	//----------------------Down below is the sign in for the employee
	public static void employeeSignIn() {
		log.warn("Employee is singning in");
		//----asking for credentials of the employee
		System.out.print("Enter your username: ");
		String username = input.next();
		System.out.print("Enter your password: ");
		String password = input.next();
		//----if the employee credentials are correct redirect them to the menu if not try again using recursion
		if(em.getEmployeeUsername().equals(username) && em.getEmployeePassword().equals(password)) {
			log.info("Employee was able to login successfully");
			employeeMenu();
		}else {
			System.out.println("sorry wrong password try again");
			log.info("Employee could not log in due to wrong password or username");
			employeeSignIn();
		}
	}
	//-------------------------Down below is the approve method where employee will  be able to approve an account
	public static void approve() {
		log.warn("The approving operation is activated");
		//----in order for the employee to approve an account they need to enter the account id
		//----then we get the account from the database by id and store in object
		//----prompt employee a message of re ensuring the approval request
		//----then we set the status to approved and then we update the account
		System.out.print("Enter Account ID you which to approve: ");
		int accountID = input.nextInt();
		System.out.println(acDaoImpl.getAccountById(accountID));
		System.out.println("_______________________________________________________________________");
		Account currAc = new Account();
		currAc = acDaoImpl.getAccountById(accountID);

		System.out.print("Approve y for yes or n for no: ");
		String op = input.next();
		if(op.equals("y")) {
			String ap = "approved";
			currAc.setStatus(ap);
			log.info("Account# " + accountID + " was approved");
			acDaoImpl.updateAccount(currAc);
			System.out.println("account: " + accountID + " has been approved");
		}else {
			log.info("Account# " + accountID + " is still pending");
			System.out.println("status still pending");
		}	
	}
	//---------------------Down below is the method that will allow the employee to deny an account
	public static void Deny() {
		log.warn("The denying operation is activated");
		//----in order for the employee to deny an account they need to enter the account id
		//----then we get the account from the database by id and store in object
		//----prompt employee a message of re ensuring the deny request
		//----then we set the status to denied and then we update the account to persist in database
		System.out.print("Enter Account ID you which to deny: ");
		int accountID = input.nextInt();
		System.out.println(acDaoImpl.getAccountById(accountID));
		System.out.println("_______________________________________________________________________");
		Account currAc = new Account();
		currAc = acDaoImpl.getAccountById(accountID);
		
		System.out.print("Deny y for yes or n for no: ");
		String op = input.next();
		if(op.equals("y")) {
			String den = "denied";
			currAc.setStatus(den);
			log.info("Account#" + accountID + " has been denied");
			acDaoImpl.updateAccount(currAc);
			System.out.println("account: " + accountID + " has been denied");
		}else {
			log.info("Account#" + accountID + " is pending");
			System.out.println("status still pending");
		}	
	}
}

