package com.example.partone; //change this outside of the same package as the others is that main driver cannot edit protected variables

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Map.Entry;

public class MainDriver {
	static boolean start = true;
	static boolean validInput = false;
	static Scanner sc = new Scanner(System.in);
	static String userN = null;
	static boolean userExists = false;
	static int currKey = 0;
	static int accountKey = 0;
	static Random r = new Random();
	static HashMap<Integer, SystemAdmin> bankAccounts = new HashMap<Integer, SystemAdmin>();

	public static void main(String[] args) {
		//String yn;
		int choice = 0;
		String userP = null;
		
		while (start) {
			System.out.println("Hello, welcome to Revature Banking.");
			System.out.println("Do you want to 1: Log in or 2: Create an acocunt");
			System.out.println("Enter 1 or 2:");
			while (!validInput) {
				choice = sc.nextInt();
				if ((choice == 1) || (choice == 2)) {
					break;
				} else {
					System.out.println("Invalid input. Please enter 1 or 2");
				}
			}
			//////////////////////////////////////////////////////////////////////////////////////////
			////// logging in to
			////////////////////////////////////////////////////////////////////////////////////////// anaccount////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////
			if (choice == 1) {
				System.out.println("Please Log in");
				System.out.println("Username:");
				checkUser();
				while (!validInput) { //check password correspodns with username
					System.out.println("Password:");
					userP = sc.nextLine();
					if(userP != bankAccounts.get(currKey).getPassword()) {
						System.out.println("Incorrect password. Please re-enter password");
					}
					else {
						break;
					}
				}
				/////////////////////////////////////////////////////////////////////////
				///// Checking userType/////////////////////////////////////////////////
				if (bankAccounts.get(currKey).getUserType() == 0) { //client
					System.out.println("What would you like to do?");
					String options = "1: Check Balance 2: Deposit 3: Withdraw 4: Trasnfer";
					System.out.println(options);
					System.out.println("Enter 1, 2, 3, or 4");
					// implement options
					while (!validInput) {
						choice = sc.nextInt();
						if ((choice == 1) || (choice == 2) || (choice == 3) || (choice == 4)) {
							break;
						} else {
							System.out.println("Invalid input. Please enter 1, 2, 3, or 4");
						}
					}
					if (choice == 1) {
						// check balance of account
						// .viewBalance();
					} else if (choice == 2) {
						// .deposit();
					} else if (choice == 3) {
						// .withdraw();
					} else if (choice == 2) {
						// .transfer();
					} else {
						System.out.println("Error in choice between looking at account options");
					}
				}
				/////////////////////////////////////////////////////////////////////////
				else if (bankAccounts.get(currKey).getUserType() == 1) { //employee
					System.out.println("Welcome employee: " + bankAccounts.get(currKey).getfName());
					System.out.println("What would you like to do?");
					String options = "1: Check Account Application Status 2: Check Account Information";
					System.out.println(options);
					System.out.println("Enter 1, or 2");
					// implement options
					while (!validInput) {
						choice = sc.nextInt();
						if ((choice == 1) || (choice == 2)) {
							break;
						} else {
							System.out.println("Invalid input. Please enter 1 or 2");
						}
					}
					if (choice == 1) {
						// check account application status
						System.out.println("Enter the username of the acocunt you wish to review");
						checkUser();
						bankAccounts.get(currKey).setAccountStatus();
					} else if (choice == 2) {
						// view information
						System.out.println("Please enter username of of the user you want to look at");
						checkUser();
						bankAccounts.get(currKey).viewAccount();
					} else {
						System.out.println("Error in choice between looking at account options");
					}
					/////////////////////////////////////////////////////////////////////////
				} else if (bankAccounts.get(currKey).getUserType() == 2) { //system admin
					System.out.println("Welcome system administrator: " + bankAccounts.get(currKey).getfName());
					System.out.println("What would you like to do?");
					String options = "1: Check Application Status/Cancel Account 2: Check Account Information 3: Change a user's password 4: Change Password";
					System.out.println(options);
					System.out.println("Enter 1, 2, 3, or 4");
					// implement options
					while (!validInput) {
						choice = sc.nextInt();
						if ((choice == 1) || (choice == 2)) {
							break;
						} else {
							System.out.println("Invalid input. Please enter 1 or 2");
						}
					}
					if (choice == 1) {
						// check account application status
						System.out.println("Enter the username of the acocunt you wish to review");
						checkUser();
						bankAccounts.get(currKey).setAccountStatus();
					} else if (choice == 2) { // view information
						System.out.println("Please enter username of of the user you want to look at");
						checkUser();
						bankAccounts.get(currKey).viewAccount();
					} else if (choice == 3) { // change user's password
						System.out.println("Please enter username of of the user");
						checkUser();
						System.out.println("Enter new Password: ");
						userP = sc.nextLine();
						bankAccounts.get(currKey).setPassword(userP);
					} else if (choice == 4) {
						System.out.println("Enter new Password: ");
						userP = sc.nextLine();
						bankAccounts.get(currKey).setPassword(userP);
					} else {
						System.out.println("Error in choice between looking at account options");
					}
				} else {
					System.out
							.println("Error has occurred with userType not being a client, employee, or system admin");
				}
				//////////////////////////////////////////////////////////////////////////////////////////
				////// creating an
				////////////////////////////////////////////////////////////////////////////////////////// account///////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////
			} else if (choice == 2) {
				// implement creating an account
				/*
				 * use a map of type objects with either client, employee, or system admin
				 * access
				 * 
				 * include if an account with username is already taken
				 * 
				 */
				System.out.println(
						"Please enter what account type you are opening 1: Client 2: Employee or 3: Ssytem Admin");
				System.out.println("Please enter 1, 2, or 3");
				while (!validInput) {
					choice = sc.nextInt();
					if ((choice == 1) || (choice == 2) || (choice == 3)) {
						break;
					} else {
						System.out.println("Invalid choice. Please enter 1, 2 or 3");
					}
				}
				if (choice == 1) {
					Client cl = new Client();
					cl.createAccount();
					createKey();
					bankAccounts.put(accountKey, (SystemAdmin) cl);
				} else if (choice == 2) {
					Employee em = new Employee();
					em.createAccount();
					createKey();
					bankAccounts.put(accountKey, (SystemAdmin) em);//not sure what to do with this because if change to account (parent class) then can't get each items specifics when accessing from hash table
				} else if (choice == 3) {
					SystemAdmin sa = new SystemAdmin();
					sa.createAccount();
				createKey();
					bankAccounts.put(accountKey, sa);
				} else {
					System.out.println("Error in choice betweenw hat type of account creating 0 =client, 1 =employee, 2 = sys ad");
				}
			}
			//////////////////////////////////////////////////////////////////////////////////////////
			else {
				System.out.println("error has occurred with choosing whether to open an account or log in");
			}
		}
	}

	static void checkUser() {
		while (!validInput) {
			userN = sc.nextLine();
			for (Entry<Integer, SystemAdmin> en : bankAccounts.entrySet()) { // iterate through all members
																				// in
				// accounts map
				if (userN == en.getValue().getUsername()) { // check if accountKey is in map
					userExists = true;
					currKey = en.getKey();
				}
			}
			if (!userExists) {
				System.out.println("The username does not exist!");
				System.out.println("Please re-enter username"); // can add the ability to search by accountkey instead
			}
		}
	}

	static void createKey() {
		while (!validInput) {
			accountKey = r.nextInt(9999);
			for (Entry<Integer, SystemAdmin> en : bankAccounts.entrySet()) { // iterate through all members in
																				// accounts map
				if (accountKey == en.getKey()) { // check if accountKey is in map
					continue;
				} else { // accountKey is unique
					break;
				}
			}
		}
	}
}
