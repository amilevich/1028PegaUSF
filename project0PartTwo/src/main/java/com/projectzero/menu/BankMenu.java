package com.projectzero.menu;

import com.projectzero.dao.AccountDaoImpl;
import com.projectzero.menu.CustomerMenu;

import project0PartOne.Account;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class BankMenu {
	////////////////////////////////////THIS IS THE CLASS THAT HAS ALL THE BANK FEATURES/////////////////////////////////////////////
	//----------------down below declaring the objects to be used
	final static Logger log = Logger.getLogger(BankMenu.class);
	static AccountDaoImpl acDaoImpl = new AccountDaoImpl();
	
	//-----------Down below is the main menu once the program is running
	//----------Within this menu we have options such as:
	//-----------Sign in as customer, sign in as employee, sign in as admin, register or quit application
	public void bankMenu() {
		log.warn("The bank's main menu is active");
		Scanner input = new Scanner(System.in);
		CustomerMenu cm = new CustomerMenu();
		EmployeeMenu empl = new EmployeeMenu();
		char option;
		String input2;
		System.out.println("|                           W E L C O M E                               |");
		System.out.println("|_______________________________________________________________________|");
		System.out.println("| 'a' : Sign In as customer                                             |");
		System.out.println("| 'b' : Sign In as employee                                             |");
		System.out.println("| 'c' : Sign In as Admin                                                |");
		System.out.println("| 'd' : Register                                                        |");
		System.out.println("| 'q' : Quit                                                            |");
		System.out.println("|_______________________________________________________________________|");
		System.out.print(" Enter option here: ");
		do {
			input2 = input.next();
			option = input2.charAt(0);
			switch (option) {
			case 'a':
				cm.customerSignIn1();
				break;
			case 'b':
				// sign in as employee method
				empl.employeeSignIn();
				break;
			case 'c':
				// sign in as admin
				
				break;
			case 'd':
				// Customer register method
				cm.customerRegistration();
				break;
			case 'q':
				System.out.println("Goodbye and thank you");
				break;
			default:
				System.out.println("You entered the wrong option");
			}
		} while (option != 'q');
	}
	
	//-----Down below is the menu that will be presented to customer once there account has been approved
	//-----This menu contains the options of Depositing,Withdrawal,transferring,go back to main menu, quit
	public void ActionMenu() {
		log.warn("The Customer's action menu is active");
		Scanner input = new Scanner(System.in);
		char option;
		String input2;
		System.out.println("_________________________________________________| ");
		System.out.println("_________________________________________________| ");
		System.out.println(" 'a' : Deposit ");
		System.out.println(" 'b' : Withdrawal ");
		System.out.println(" 'c' : Transfer");
		System.out.println(" 'd' : Go Back");
		System.out.println(" 'q' : Quit");
		System.out.print("Enter option here: ");
		do {
			input2 = input.next();
			option = input2.charAt(0);
			switch (option) {
			case 'a':
				// Deposit method
				Deposit();
				break;
			case 'b':
				// Withdrawal method
				Withdrawal();
				break;
			case 'c':
				// Transfer method
				transfer();
				break;
			case 'd':
				// Main Menu
				bankMenu();
				break;
			case 'q':
				// quits the program
				System.out.println("Thank you and goodbye");
				break;
			default:
				System.out.println("You entered the wrong option");
			}
		} while (option != 'q');
	}
	
	//------This method is the deposit, it allows the customer to deposit money into their account
	//-----To do this we need the account id to verify , the amount to deposit, then update there account
	public static void Deposit() {
		log.info("The deposti operation is active");
		Account acct = new Account();
		Scanner input = new Scanner(System.in);
		CustomerMenu cm = new CustomerMenu();
		EmployeeMenu empl = new EmployeeMenu();
		int amount = 0;
		System.out.print("Enter the account id: ");
		int acid = input.nextInt();
		acct = acDaoImpl.getAccountById(acid);
		
			System.out.print("Enter the amount you want to deposit: ");
			amount = input.nextInt();
			acct.setBalance(amount + acct.getBalance());
			acDaoImpl.updateAccount(acct);
			System.out.println("Ammount: " + amount + "has been deposited to account" );
		
	}
	
	//---------This method is the withdrawal, it allows the customer to take out money from their account
	//---------To do this we need the account id to verify, the amount they want to withdrawal, then update custome's balance
	public static void Withdrawal() {
		log.info("The withdrawal operation is active");
		Account acct = new Account();
		Scanner input = new Scanner(System.in);
		CustomerMenu cm = new CustomerMenu();
		EmployeeMenu empl = new EmployeeMenu();
		int amount = 0;
		System.out.print("Enter the account id: ");
		int acid = input.nextInt();
		acct = acDaoImpl.getAccountById(acid);
		
			System.out.print("Enter the amount you want to withdrawal: ");
			amount = input.nextInt();
			acct.setBalance(acct.getBalance()-amount);
			acDaoImpl.updateAccount(acct);
			System.out.println("Ammount: " + amount + "has been withdrawan from " + acid );
	}
	//---This method is transfer, it allows the customer to transfer from their accounts to others
	//---To do this we need the account id of current customer to verify
	//---Then we need the second account id to verify it exists as well
	//---Then enter the amount for transferring depending on how much they have
	//---we subtract the amount from current customer's balance and add amount entered to the second account
	public static void transfer() {
		log.warn("The transfer operation is active");
		Account acct = new Account();
		Account acct2 = new Account();
		Scanner input = new Scanner(System.in);
		CustomerMenu cm = new CustomerMenu();
		EmployeeMenu empl = new EmployeeMenu();
		int amount = 0;
		System.out.print("Enter current customer account id: ");
		int acid = input.nextInt();
		acct = acDaoImpl.getAccountById(acid);
		System.out.print("Enter the account id you wich to transfer to: ");
		int acid2 = input.nextInt();
		acct2 = acDaoImpl.getAccountById(acid2);
			System.out.print("Enter the amount you want to transfer to: ");
			amount = input.nextInt();
			acct2.setBalance(amount);
			acct.setBalance(acct.getBalance()-amount);
			acDaoImpl.updateAccount(acct);
			acDaoImpl.updateAccount(acct2);
			System.out.println("Ammount: " + amount + "has been transfered to " + acid2);
	}
	
}
