package com.folder.bank;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Accounts implements Serializable {
	/**
	 * Java Docs
	 */
	private static final long serialVersionUID = 2766760989820227774L;
	Random randomGen = new Random();
	private int accountID = randomGen.nextInt(100);
	private boolean isJoint;
	private String status;
	private int balance;

	// Scanners
	static Scanner input = new Scanner(System.in);

	// Instantiate of ArrayList
	static ArrayList<Customers> accountsPending = new ArrayList<Customers>();
	static ArrayList<Customers> accountsApproved = new ArrayList<Customers>();

	// Iterator
	static Iterator<Customers> iterPending = accountsPending.iterator();
	// static Iterator<Customers> iterApproved = accountsApproved.iterator();

	static // Instantiate of Classes
	Customers newCustomer = new Customers();
	Employees employee = new Employees();
	Admin admin = new Admin();

	// Text File
	static String filename = "./bank.txt";

	static // Unrelated Variable
	int option;
	static int counter = 0;

	// *******************************************************************************************************************
	// Main Menu

	public static void menu() {
		readObject(filename);
		System.out.println("\n");
		System.out.println("\t~" + "Account Pending");
		System.out.println(" \n");
		System.out.println("\t  [̲̅$̲̅(̲̅ ᵕ꒳ᵕ)̲̅$̲̅]");
		System.out.println("        *****Bank*****");
		System.out.println("      *****Main Menu*****");
		System.out.println(" \n");
		System.out.println("\t 1. Customer");
		System.out.println("\t 2. Employee");
		System.out.println("\t 3. Admin");
		System.out.println("\t 4. Registration");

		int option = input.nextInt();

		// * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
		// Switch 1. Login
		// Switch 2. Registration
		switch (option) {
		case 1: // Customer Login
			customerLogin();
			break;
		case 2: // Employee Login
			employeeLogin();
			break;
		case 3: // Admin login
			adminLogin();

			break;
		case 4:
			registration();
			break;
		default:
			System.out.println("Done");
		}

	}

	// *******************************************************************************************************************
	// Customer Login
	public static void customerLogin() {
		System.out.println("");
		System.out.println("");
		System.out.println("*****Customer Login Page*****");
		System.out.println("");

		// Customer Login Username
		System.out.println("Provide ID:");
		int userIDCredential = input.nextInt();

		// Customer Login Password
		System.out.println("Provide Password: ");
		String passCredential = input.next();

		while (accountsPending.iterator().hasNext()) {
			Customers i = accountsPending.iterator().next();
			if (userIDCredential == i.getCustomerId() && passCredential.equals(i.getPassword())) {
				System.out.println("Login credential valid");
				System.out.println("");
				System.out.println("");
				System.out.println("1. Display");
				System.out.println("2. Deposit");
				System.out.println("3. Withdraw");
				System.out.println("4. Done");
				int option = input.nextInt();

				switch (option) {
				case 1:
					System.out.println("1. Display info");
					customerList(accountsPending, userIDCredential);
					break;
				case 2:
					System.out.println("Deposit Here");
					deposit(accountsPending, userIDCredential);
					break;
				case 3:
					System.out.println("3. Withdraw");
					withdraw(accountsPending, userIDCredential);
					break;
				case 4:
					System.out.println("4. Done");
					menu();
					break;
				default:
					System.out.println("Done");
					System.out.println("Nice going you broke it...");
					break;
				}
			} else {
				System.out.println("false");
				customerLogin();
			}
		}
	}

	// *******************************************************************************************************************
	// Employee Login
	public static void employeeLogin() {
		System.out.println("");
		System.out.println("");
		System.out.println("*****Employee Login Page*****");
		System.out.println("");

		// Employee Login Username
		Employees employee = new Employees();
		System.out.println("Provide Employee String:");
		String emCredential = input.next();

		// Employee Login Password
		System.out.println("Em Password: ");
		String passCredential = input.next();

		if (emCredential.equals(employee.getEmUsername()) && passCredential.equals(employee.getEmPassword())) {
			System.out.println("\n");
			System.out.println("1. View All Accounts");
			System.out.println("2. Approve/Decline Accounts");
			System.out.println("3. Done");
			int option = input.nextInt();

			switch (option) {
			case 1:
				System.out.println("\t View All Accounts");
				if (accountsPending.isEmpty()) {
					System.out.println("");
					System.out.println("");
					System.out.println("No Accounts...Register to continue");
					menu();
				} else {
					printListPretty(accountsPending);
				}

				break;
			case 2:
				System.out.println("Approve/Decline Accounts");
				accDec(accountsPending, accountsApproved);
				break;
			case 3:
				System.out.println("3. Done");
				menu();
				break;
			default:
				System.out.println("Done");
				System.out.println("Nice going you broke it...");
				break;
			}
		}
	}

	// *******************************************************************************************************************
	// Admin Login
	private static void adminLogin() {
		System.out.println("Admin Login");

	}

	// ********************************************************************************************************
	// Methods below
	// ***********************************************************************************************************

	// Registration
	public static void registration() {
		System.out.println("");
		System.out.println("");

		System.out.println("*****Registration Menu******");
		System.out.println("");
		System.out.println("_____Account type?_____");
		System.out.println("");
		System.out.println("1. Single \n");
		System.out.println("2. Joint ");
		int option = input.nextInt();
		// *****************************

		// Need a method for validation if it isnt int.

		switch (option) {
		// Single Account
		case 1:
			Customers singleCustomer = new Customers();
			System.out.println("");
			System.out.println("");
			System.out.println("Option 1: Single Account");
			System.out.println("");

			// Single Username and Password
			System.out.println("Enter Username: \n");
			String usernameSin = input.next();
			singleCustomer.setUsername(usernameSin);
			System.out.println("Enter Password: \n");
			String passwordSin = input.next();
			singleCustomer.setPassword(passwordSin);

			// Single Account ID
			singleCustomer.setAccountType("Single");

			// Single Accounts Balance
			singleCustomer.setTotalBalance(0);

			// *********************************************************************
			// Receipt
			System.out.println("*****Here is your the receipt*****");
			System.out.println("New Username ID............" + singleCustomer.getCustomerId());
			System.out.println("New Account Type..........." + singleCustomer.getAccountType());
			System.out.println("New Username............... " + singleCustomer.getUsername());
			System.out.println("New Password............... " + singleCustomer.getPassword());
			System.out.println("Total Balance............... " + singleCustomer.getTotalBalance());

			// Add into account pending Array List
			accountsPending.add(singleCustomer);
			writeObject(filename, accountsPending);
			readObject(filename);

			break;
		// Joint Account
		case 2:

			// First User
			Customers jointCustomer = new Customers();
			System.out.println("Joint account");
			System.out.println("");
			System.out.println("Enter 1st Username: \n");
			String usernameJoint = input.next();
			jointCustomer.setUsername(usernameJoint);
			System.out.println("Enter 1st Password: \n");
			String passwordJoint = input.next();
			jointCustomer.setPassword(passwordJoint);

			// Set Account Type
			jointCustomer.setAccountType("Joint");

			// Second User
			Customers joint2Customer = new Customers();

			System.out.println("Enter 2nd Username: \n");
			String usernameJoint2 = input.next();
			joint2Customer.setUsername(usernameJoint2);
			System.out.println("Enter 2nd Password: \n");
			String passwordJoint2 = input.next();
			joint2Customer.setPassword(passwordJoint2);
			joint2Customer.setCustomerId(jointCustomer.getCustomerId());

			// Set Account Type
			joint2Customer.setAccountType("Joint");

			// Single Accounts Balance
			jointCustomer.setTotalBalance(0);
			joint2Customer.setTotalBalance(jointCustomer.getTotalBalance());

			// *********************************************************************
			// Receipt
			System.out.println("*****Here is 1nd User's receipt*****");
			System.out.println("New Username ID............ " + jointCustomer.getCustomerId());
			System.out.println("New Account Type........... " + jointCustomer.getAccountType());
			System.out.println("New Username............... " + jointCustomer.getUsername());
			System.out.println("New Password............... " + jointCustomer.getPassword());
			System.out.println("");
			System.out.println("*****Here is 2nd User's receipt*****");
			System.out.println("New Username ID............ " + joint2Customer.getCustomerId());
			System.out.println("New Account Type........... " + joint2Customer.getAccountType());
			System.out.println("New Username............... " + joint2Customer.getUsername());
			System.out.println("New Password............... " + joint2Customer.getPassword());
			System.out.println("");
			System.out.println("Total Joint Balance.............. " + jointCustomer.getTotalBalance());

			// Add into account pending Array List
			accountsPending.add(jointCustomer);
			accountsPending.add(joint2Customer);
			writeObject(filename, accountsPending);
			readObject(filename);
			break;

		default:
			System.out.println("Default");
		}

		menu();
	}
	// ***********************************************************************************************************
	// Approval / Decline method for Customers

	public static void accDec(ArrayList<Customers> accountsPending, ArrayList<Customers> accountsApproved) {

		readObject(filename);
		System.out.println("1. Accept");
		System.out.println("2. Decline");
		int judgement = input.nextInt();

		switch (judgement) {
		case 1:
			ArrayList<Customers> temp = accountsPending;
			accountsPending.remove(accountsPending.contains(temp));
			System.out.println("Show accountPending:\t" + accountsPending);
			accountsApproved.addAll(temp);
			System.out.println("Show accountsApproved:\t" + accountsApproved);
			System.out.println("Show accountPending:\t" + accountsPending);
			break;
		case 2:
			System.out.println("Decline");
			accountsPending.remove(accountsPending.get(0));
			System.out.println(accountsPending);
			break;
		default:
			System.out.println("Default at accDec");
			break;
		}
	}
	// *******************************************************************************
	// Money Transaction

	// Deposit
	public static void deposit(ArrayList<Customers> accountsPending, int userIDCredential) {
		int newBalance = 0;
		int amount = input.nextInt();
		if (amount != 0 && amount > 0) {
			for (Customers i : accountsPending) {
				if (i.getCustomerId() == userIDCredential) {
					newBalance = amount + i.getTotalBalance();
					i.setTotalBalance(newBalance);
					System.out.println("The amount of " + newBalance + " was deposited");
					System.out.println(i.getTotalBalance());
					writeObject(filename, accountsPending);
				}
				customerLogin();
			}
		} else {
			System.out.println("Invalid Deposit");
		}

	}

	// ********************************************************************************************************

	// Withdraw
	public static void withdraw(ArrayList<Customers> accountsPending, int userIDCredential) {
		System.out.println("Withdraw amount: ");
		readObject(filename.toString());
		int newBalance = 0;
		int amount = input.nextInt();
		if (amount != 0 && amount > 0) {
			for (Customers i : accountsPending) {
				if (i.getCustomerId() == userIDCredential) {
					newBalance = i.getTotalBalance() - amount;
					i.setTotalBalance(newBalance);
					System.out.println("The amount of " + newBalance + " was withdrawed");
					System.out.println(i.getTotalBalance());
					writeObject(filename, accountsPending);
				}
				customerLogin();
			}
		} else {
			System.out.println("Invalid Deposit");
		}
	}

	// *******************************************************************************************************************
	// ObjectInputStream & ObjectOutputStream

	// Write object to filename
	public static void writeObject(String filename, Object obj) {

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
			out.writeObject(obj);
		} catch (IOException io) {
			io.printStackTrace();
		}

	}

	// Read object from filename
	public static void readObject(String filename) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			ArrayList<Customers> temp = (ArrayList<Customers>) ois.readObject();
			for (Customers i : temp) {
				Customers c = new Customers();
				c = i;
				accountsPending.add(c);
			}
			System.out.println(accountsPending);

		} catch (IOException exception) {
			exception.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	// ********************************************************************************************************
	// Display Info
	// *******************************************************************************************************************
	// Print Account balance information

	public static void customerList(ArrayList<Customers> accountsPending, int userIDCredential) {

		for (Customers i : accountsPending) {
			if (i.getCustomerId() == userIDCredential) {
				System.out.println("This account belongs to  " + i.getUsername());
				System.out.println(
						"Total balance for account #: " + i.getCustomerId() + "\n " + i.getTotalBalance() + "\n");
				System.out.println("");
			}
		}
	}
	// ********************************************************************************************************

	static void printListPretty(ArrayList<Customers> accountsPending) {
		System.out.println("All Customers: ");
		for (Customers i : accountsPending) {
			System.out.println(i);
		}
		employeeLogin();
	}

	// ********************************************************************************************************

	// Account Constructors
	public Accounts() {
		super();

	}

	// Setter & Getters

	// Get ID Account
	public int getAccountID() {
		return accountID;
	}

	// Set ID Account
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	// Get Joint Account
	public boolean isJoint() {
		return isJoint;
	}

	// Set Joint Account
	public void setJoint(boolean isJoint) {
		this.isJoint = isJoint;
	}

	// Get Status Account
	public String getStatus() {
		return status;
	}

	// Set Status Account
	public void setStatus(String status) {
		this.status = status;
	}

	// Get Balance Account
	public int getBalance() {
		return balance;
	}

	// Set Balance Account
	public void setBalance(int balance) {
		this.balance = balance;
	}

}
