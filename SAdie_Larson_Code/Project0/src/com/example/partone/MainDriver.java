package com.example.partone; //change this outside of the same package as the others is that main driver cannot edit protected variables

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Map.Entry;

public class MainDriver {
	static boolean validInput = false;
	static boolean repeatMain = true;
	static boolean repeatOptions = true;
	static Scanner sc = new Scanner(System.in);
	static String userN = null;
	static boolean userExists = false;
	static int currKey = 0;
	static int accountKey = 0;
	static int choice = 0;
	static Random r = new Random();
	static HashMap<Integer, Account> bankAccounts = new HashMap<Integer, Account>();
	

	public static void main(String[] args) {
		String userP = null;
		boolean start = true;

		while (start) { // will constantly run program
			System.out.println("started program");
			while (repeatMain) {
				System.out.println(bankAccounts.toString());
				repeatMain = false;
				repeatOptions = true;

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
				////////////////////////////////////////////////////////////////////////////////////////// account//////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////
				if (choice == 1) {
					System.out.println("Please Log in");
					System.out.println("Username:");
					checkUser();
					if(repeatMain) {
						System.out.println("entered exit mode");
						break;
					}
					while (!validInput) { // check password correspodns with username
						System.out.println("Password:");
						userP = sc.nextLine();
						boolean validP = userP.equals(bankAccounts.get(currKey).getPassword());
						if (!validP) {
							System.out.println("Incorrect password. Please re-enter password");
						} else {
							break;
						}
					}
					/////////////////////////////////////////////////////////////////////////
					///// Checking userType/////////////////////////////////////////////////
					if (bankAccounts.get(currKey).getUserType() == 1) { // client
						while (repeatOptions) {
							System.out.println(
									"Welcome " + bankAccounts.get(currKey).getfName() + "! What would you like to do?");
							String options = "1: Check Information 2: Deposit 3: Withdraw 4: Trasnfer 5: Return to main";
							System.out.println(options);
							System.out.println("Enter 1, 2, 3, 4, or 5");
							// implement options
							while (!validInput) {
								choice = sc.nextInt();
								if ((choice == 1) || (choice == 2) || (choice == 3) || (choice == 4)) {
									break;
								} else if (choice == 5) {
									repeatMain = true;
									break;
								} else {
									System.out.println("Invalid input. Please enter 1, 2, 3, or 4");
								}
							}

							if (repeatMain) { // should break out of repeat loop and restart
								break;
							}

							if (choice == 1) {
								// check balance of account and other information
								System.out.println("AccountKey: " + currKey);
								bankAccounts.get(currKey).viewInformation();
								menuOption();
							} else if ((choice == 2) || (choice == 3) || (choice == 4)) {
								// sends to client to go through accounts names
								if (bankAccounts.get(currKey).getApplicationStatus() == 1) { // application approved
									bankAccounts.get(currKey).accessAccounts(choice);
								} else if (bankAccounts.get(currKey).getApplicationStatus() == 0) { // application
																									// status pending
									System.out.println("Access Denied. Your account is still pending.");
								} else {
									System.out.println("Access Denied. Your account has been denied.");
								}
								// access accounts allows to access specific account to manipulate
							} else {
								System.out.println("Error in choice between looking at account options");
							}
							if (repeatMain) {
								repeatOptions = false;
							}

						}
					} else if (repeatMain) { // should break out of repeat loop and restart
						break;
					}
					/////////////////////////////////////////////////////////////////////////
					else if (bankAccounts.get(currKey).getUserType() == 2) { // employee
						while (repeatOptions) {
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
							switch (choice) {
							case 1:
								// check account application status
								System.out.println("Enter the username of the acocunt you wish to review");
								checkUser();
								bankAccounts.get(currKey).setAccountStatus();
								menuOption();
								break;
							case 2: // view information
								System.out.println("Please enter username of of the user you want to look at");
								checkUser();
								bankAccounts.get(currKey).viewAccount(bankAccounts);
								menuOption();
								break;
							default:
								System.out.println("Error in choice between looking at account options");
								menuOption();
								break;
							}
							if (repeatMain) {
								repeatOptions = false;
							}
						}
						/////////////////////////////////////////////////////////////////////////
					} else if (repeatMain) { // should break out of repeat loop and restart
						break;
					} else if (bankAccounts.get(currKey).getUserType() == 3) { // system admin
						while (repeatOptions) {
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
							switch (choice) {
							case 1:
								// check account application status
								System.out.println("Enter the username of the acocunt you wish to review");
								checkUser();
								System.out.println(repeatMain);
								if(repeatMain) {
									break;
								}
								else {
								bankAccounts.get(currKey).setAccountStatusAd();
								menuOption();
								}
								break;
							case 2: // view information
								System.out.println("Please enter username of of the user you want to look at");
								checkUser();
								if(repeatMain) {
									break;
								}
								bankAccounts.get(currKey).viewAccount(bankAccounts);
								menuOption();
								break;
							case 3: // change user's password
								System.out.println("Please enter username of of the user");
								checkUser();
								if(repeatMain) {
									break;
								}
								System.out.println("Enter new Password: ");
								userP = sc.nextLine();
								bankAccounts.get(currKey).setPassword(userP);
								System.out.println(
										bankAccounts.get(currKey).getUsername() + "'s password successfully updated ");
								menuOption();
								break;
							case 4:
								System.out.println("Enter new Password: ");
								userP = sc.nextLine();
								bankAccounts.get(currKey).setPassword(userP);
								System.out.println(
										bankAccounts.get(currKey).getUsername() + "'s password successfully updated ");
								menuOption();
								break;
							default:
								System.out.println("Error in choice between looking at account options");
								menuOption();
								break;
							}
							if (repeatMain) {
								repeatOptions = false;
							}

						}
					} else {
						System.out.println(
								"Error has occurred with userType not being a client, employee, or system admin");
					}
				}

				//////////////////////////////////////////////////////////////////////////////////////////
				////// creating an
				////////////////////////////////////////////////////////////////////////////////////////// account///////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////
				else if (choice == 2) {
					// implement creating an account
					/*
					 * use a map of type objects with either client, employee, or system admin
					 * access
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
					switch (choice) {
					case 1:
						Account cl = new Account(bankAccounts, choice);
						createKey();
						bankAccounts.put(accountKey, cl);
						break;
					case 2:
						Account em = new Account(bankAccounts, choice);
						createKey();
						bankAccounts.put(accountKey, em);
						break;
					case 3:
						Account sa = new Account(bankAccounts, choice);
						createKey();
						bankAccounts.put(accountKey, sa);
						break;
					default:
						System.out.println(
								"Error in choice betweenw hat type of account creating 0 =client, 1 =employee, 2 = sys ad");
						break;
					}

					System.out.println("Exiting to main menu now");
					repeatMain = true;
				}
				//////////////////////////////////////////////////////////////////////////////////////////
				else {
					System.out.println("error has occurred with choosing whether to open an account or log in");
				}
			} // end of repeat main method
		} // end of repeat start
	} // end of main method

	static void menuOption() {
		System.out.println("Do you want to reurn to 1: main menu or 2: options screen");
		System.out.println();
		while (!validInput) {
			choice = sc.nextInt();
			if (choice == 1) {
				repeatMain = true;
				break;
			} else if (choice == 2) {
				repeatOptions = true;
				break;
			} else {
				System.out.println("Invalid. can only choose 1 or 2");
			}
		}
	}

	static void checkUser() {
		userN = sc.nextLine();
		while (!validInput) {
			userN = sc.nextLine();
			if (userN.equals("exit")) {
				System.out.println("entered exit mode");
				repeatMain = true;
				break;
			}
			System.out.println(bankAccounts.toString());
			for (Entry<Integer, Account> en : bankAccounts.entrySet()) { // iterate through all members
																			// in
				// accounts map
				// String temp = en.getValue().getUsername();
				// System.out.println(temp);
				// check if accountKey is in map
				if (userN.equals(en.getValue().getUsername())) {
					currKey = en.getKey();
					userExists = true;
					break;
				}
			}
			if (!userExists) {
				System.out.println("The username does not exist!");
				System.out.println("Please re-enter username"); // can add the ability to search by accountkey instead
			} else {
				break;
			}
		}
	}

	static void createKey() {
		while (!validInput) {
			accountKey = r.nextInt(9999);
			// System.out.println(accountKey);
			for (Entry<Integer, Account> en : bankAccounts.entrySet()) { // iterate through all members in
				// accounts map
				if (accountKey == en.getKey()) { // check if accountKey is in map
					continue;
				} else { // accountKey is unique
					break;
				}
			}
			break;
		}
	}
}
