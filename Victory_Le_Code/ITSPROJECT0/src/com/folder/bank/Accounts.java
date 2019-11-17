package com.folder.bank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
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
	static String filename = "./bankPending.txt";
	static String filename2 = "./bankApproved.txt";

	static // Unrelated Variable
	int option;
	static int counter = 0;
	static int flag = 0;

	// *******************************************************************************************************************
	// Main Menu

	public static void menu() {
		System.out.println("");
		readObject(filename);
		System.out.println();
		readObject(filename2);
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
		System.out.println("\t 5. Done");


		// * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
		// Switch 1. Login
		// Switch 2. Registration
		try {
			String option = input.next();
	
			flag = 0;
			switch (option) {
			case "1": // Customer Login
				customerLogin();
				break;
			case "2": // Employee Login
				employeeLogin();
				break;
			case "3": // Admin login
				adminLogin();
				break;
			case "4":
				registration();
				break;
			case "5":
				writeObject(filename, accountsPending);
				writeObject(filename2, accountsApproved);
			default:
				menu();
		}

	} catch(Exception e){
		System.out.println("Invalid user input. Da fook");
	}
}

	// *******************************************************************************************************************
	// Customer Login
	public static void customerLogin() {
		flag = 1;
		System.out.println("");
		System.out.println("");
		System.out.println("*****Customer Login Page*****");
		System.out.println("");

		// Customer Login Username
		System.out.println("Provide ID:");
		int userIDCredential;
		while (true) {
			String tempy = input.next();
			try {
				userIDCredential = Integer.valueOf(tempy);
				break;
			} catch (Exception e) {
				System.out.println("Invlaid please enter a number");
			}
		}

		// Customer Login Password
		System.out.println("Provide Password: ");
		String passCredential = input.next();
		if (accountsApproved.isEmpty()) {
			Customers i = accountsApproved.iterator().next();
			if (userIDCredential == i.getCustomerId() && passCredential.equals(i.getPassword())) {
				System.out.println("Login credential valid");
				System.out.println("");
				System.out.println("");
				System.out.println("1. Display");
				System.out.println("2. Deposit");
				System.out.println("3. Withdraw");
				System.out.println("4. Done");
				String option = input.next();

				switch (option) {
				case "1":
					System.out.println("1. Display info");
					customerList(accountsApproved, userIDCredential);
					customerLogin();
					break;
				case "2":
					System.out.println("Deposit Here");
					deposit(accountsPending, userIDCredential);
					customerLogin();
					break;
				case "3":
					System.out.println("3. Withdraw");
					withdraw(accountsPending, userIDCredential);
					customerLogin();
					break;
				case "4":
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
		flag = 2;
		System.out.println("\n");
		System.out.println("\t *****Employee Login Page*****");
		System.out.println("");

		// Employee Login Username
		Employees employee = new Employees();
		System.out.println("\t Provide Employee Username:");
		String emCredential = input.next();

		// Employee Login Password
		System.out.println("\t Em Password: ");
		String passCredential = input.next();

		if (emCredential.equals(employee.getEmUsername()) && passCredential.equals(employee.getEmPassword())) {
			System.out.println("\n");
			System.out.println("\t 1. View All Accounts");
			System.out.println("\t 2. Approve/Decline Accounts");
			System.out.println("\t 3. Done");
			String option = input.next();

			switch (option) {
			case "1":
				System.out.println("\t View All Accounts");
				if (accountsPending.isEmpty()) {
					System.out.println("");
					System.out.println("");
					System.out.println("\t No Accounts...Register to continue");
					employeeLogin();
				} else {
					printListPretty(accountsPending);
					employeeLogin();
				}

				break;
			case "2":
				System.out.println("\t Approve/Decline Accounts");
				accDec();
				employeeLogin();
				break;
			case "3":
				System.out.println("\t 3. Done");
				menu();
				break;
			default:
				System.out.println("Done");
				System.out.println("Nice going you broke it...");
				employeeLogin();
				break;
			}
		} else {
			System.out.println("\t Wrong Employee Login");
			employeeLogin();
		}
	}

	// *******************************************************************************************************************
	// Admin Login
	private static void adminLogin() {
		flag = 3;
		System.out.println("\n");
		System.out.println("\t *****Admin Login Page*****");
		System.out.println("");

		// Admin Login Username
		Admin admin = new Admin();
		System.out.println("\t Provide Admin String:");
		String adCredential = input.next();

		// Admin Login Password
		System.out.println("\t Admin Password: ");
		String passCredential = input.next();

		if (adCredential.equals(admin.getAdUsername()) && passCredential.equals(admin.getAdPassword())) {
			System.out.println("\n");
			System.out.println("\t 1. View All Accounts");
			System.out.println("\t 2. Approve/Decline/Cancel Accounts");
			System.out.println("\t 3. Access client accounts");
			System.out.println("\t 4. Done");
			String option = input.next();

			switch (option) {
			case "1":
				System.out.println("\t View All Accounts");
				if (accountsPending.isEmpty()) {
					System.out.println("");
					System.out.println("");
					System.out.println("\t No Accounts...Register to continue");
				} else {
					printListPretty(accountsPending);
					adminLogin();
				}

				break;
			case "2":
				System.out.println("\t Approve/Decline Accounts");
				accDec();
				adminLogin();
				break;
			case "3":
				System.out.println("\t Access client accounts");
				// Print Accounts Pending
				printListPretty(accountsPending);
				// Print Accounts Approved
				printListPretty(accountsApproved);
				adminLogin();
				break;
			case "4":
				System.out.println("\t Done");
				menu();
				break;
			default:
				System.out.println("Done");
				System.out.println("Nice going you broke it...");
				adminLogin();
				break;
			}
		}
	}

	// ********************************************************************************************************
	// Methods below
	// ***********************************************************************************************************

	// Registration
	public static void registration() {
		System.out.println("\n");
		System.out.println("\t*****Registration Menu******");
		System.out.println("");
		System.out.println("\t _____Account type?_____");
		System.out.println("");
		System.out.println("\t 1. Single \n");
		System.out.println("\t 2. Joint ");
		String option = input.next();
		// *****************************

		// Need a method for validation if it isnt int.

		switch (option) {
		// Single Account
		case "1":
			Customers singleCustomer = new Customers();
			System.out.println("\n");
			System.out.println("\t Option 1: Single Account");
			System.out.println("\n");

			// Single Username and Password
			System.out.println("\t Enter Username: \n");
			String usernameSin = input.next();
			singleCustomer.setUsername(usernameSin);
			System.out.println("\t Enter Password: \n");
			String passwordSin = input.next();
			singleCustomer.setPassword(passwordSin);

			// Single Account ID
			singleCustomer.setAccountType("\t Single");
			System.out.println("\n");
			// Single Accounts Balance
			singleCustomer.setTotalBalance(0);

			// *********************************************************************
			// Receipt
			System.out.println("\t *****Here is your the receipt*****");
			System.out.println("\t New Username ID............" + singleCustomer.getCustomerId());
			System.out.println("\t New Account Type..........." + singleCustomer.getAccountType());
			System.out.println("\t New Username............... " + singleCustomer.getUsername());
			System.out.println("\t New Password............... " + singleCustomer.getPassword());
			System.out.println("\t Total Balance............... " + singleCustomer.getTotalBalance());

			// Add into account pending Array List
			accountsPending.add(singleCustomer);
			// writeObject(filename, accountsPending);

			break;
		// Joint Account
		case "2":

			// First User
			Customers jointCustomer = new Customers();
			System.out.println("\t Joint account");
			System.out.println("");
			System.out.println("\t Enter 1st Username: \n");
			String usernameJoint = input.next();
			jointCustomer.setUsername(usernameJoint);
			System.out.println("\t Enter 1st Password: \n");
			String passwordJoint = input.next();
			jointCustomer.setPassword(passwordJoint);
			System.out.println("\n");
			// Set Account Type
			jointCustomer.setAccountType("\t Joint");

			// Second User
			Customers joint2Customer = new Customers();

			System.out.println("\t Enter 2nd Username: \n");
			String usernameJoint2 = input.next();
			joint2Customer.setUsername(usernameJoint2);
			joint2Customer.setPassword(jointCustomer.getPassword());
			joint2Customer.setCustomerId(jointCustomer.getCustomerId());

			// Set Account Type
			joint2Customer.setAccountType("\t Joint");
			System.out.println("\n");

			// Single Accounts Balance
			jointCustomer.setTotalBalance(0);
			joint2Customer.setTotalBalance(jointCustomer.getTotalBalance());

			// *********************************************************************
			// Receipt
			System.out.println("\t *****Here is 1nd User's receipt*****");
			System.out.println("\t New Username ID............ " + jointCustomer.getCustomerId());
			System.out.println("\t New Account Type........... " + jointCustomer.getAccountType());
			System.out.println("\t New Username............... " + jointCustomer.getUsername());
			System.out.println("\t New Password............... " + jointCustomer.getPassword());
			System.out.println("");
			System.out.println("\t *****Here is 2nd User's receipt*****");
			System.out.println("\t New Username ID............ " + joint2Customer.getCustomerId());
			System.out.println("\t New Account Type........... " + joint2Customer.getAccountType());
			System.out.println("\t New Username............... " + joint2Customer.getUsername());
			System.out.println("\t New Password............... " + joint2Customer.getPassword());
			System.out.println("");
			System.out.println("\tTotal Joint Balance.............. " + jointCustomer.getTotalBalance());
			System.out.println("\n");
			// Add into account pending Array List
			accountsPending.add(jointCustomer);
			accountsPending.add(joint2Customer);
			// writeObject(filename, accountsPending);
			break;

		default:
			System.out.println("Default");
		}

		menu();
	}
	// ***********************************************************************************************************
	// Approval / Decline method for Customers

	public static void accDec() {
		System.out.println("1. Accept");
		System.out.println("2. Decline");
		int judgement = input.nextInt();

		switch (judgement) {
		case 1:
			System.out.println("Accepted");
			accountsApproved.add(accountsPending.get(0));
			System.out.println("Show accountPending:\t" + accountsPending);
			accountsPending.remove(0);
			System.out.println("Show accountsApproved:\t" + accountsApproved);
			System.out.println("Show current accountPending:\t" + accountsPending);
			break;
		case 2:
			System.out.println("Decline");
			printListPretty(accountsPending);
			accountsPending.remove(0);
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
		if (amount > 0) {
			for (Customers i : accountsPending) {
				if (i.getCustomerId() == userIDCredential) {
					newBalance = amount + i.getTotalBalance();
					i.setTotalBalance(newBalance);
					System.out.println("The amount of " + newBalance + " was deposited");
					System.out.println(i.getTotalBalance());
					// writeObject(filename, accountsPending);
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
					// writeObject(filename, accountsPending);
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

		} catch (FileNotFoundException e) {
			System.out.println("No accounts loaded");
			// e.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void readObject2(String filename2) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename2))) {
			ArrayList<Customers> temp = (ArrayList<Customers>) ois.readObject();
			for (Customers i : temp) {
				Customers c = new Customers();
				c = i;
				accountsApproved.add(c);
			}
			System.out.println(accountsApproved);

		} catch (FileNotFoundException e) {
			System.out.println("No accounts loaded");
			// e.printStackTrace();
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
				System.out.println(i.toString());
			}
		}

	}
	// ********************************************************************************************************

	static void printListPretty(ArrayList<Customers> accountsPending) {
		System.out.println("All Customers: ");
		for (Customers i : accountsPending) {
			System.out.println(i);
		}
		System.out.println(flag);
		if (flag == 1) {
			customerLogin();
		} else if (flag == 2) {
			employeeLogin();
		} else if (flag == 3) {
			adminLogin();
		} else {
			menu();
		}
	}

	// ********************************************************************************************************
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
