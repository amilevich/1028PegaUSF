package com.example.partone;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import java.io.IOException;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainDriver {
	static boolean validInput = false;
	static boolean repeatMain = true;
	static boolean repeatOptions = true;
	static Scanner sc = new Scanner(System.in);
	static String userN = null;
	static boolean userExists = false;
	static int currKey = 0;
	static int accountKey = 0;
	static String choice = null;
	static Random r = new Random();
	static HashMap<Integer, Account> bankAccounts = new HashMap<Integer, Account>();

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fo = new FileOutputStream("BankUsers.txt");
		ObjectOutputStream ob = new ObjectOutputStream(fo);
		ObjectInputStream obi = new ObjectInputStream(new FileInputStream("BankUsers.txt"));
	
	/*	try {
			while ((bankAccounts =  obi.readObject()) != null) {
				bankAccounts = temp; //
				System.out.println(bankAccounts);
			}
		} catch (EOFException e) {
			// output expected
		}
		*/
		obi.close();

		// working on reading in accounts
		// *********************************************************//
		String userP = null;
		boolean start = true;
		// while (start) { // will constantly run program
		while (repeatMain) {
			System.out.println(bankAccounts.toString());
			repeatMain = false;
			repeatOptions = true;

			System.out.println("Hello, welcome to Revature Banking.");
			System.out.println("Do you want to 1: Log in or 2: Create an acocunt");
			System.out.println("Enter 1 or 2:");
			while (!validInput) {
				choice = sc.nextLine();
				if ((choice.equals("1")) || (choice.equals("2"))) {
					break;
				} else {
					System.out.println("Invalid input. Please enter 1 or 2");
				}
			}
			// ******************************************************//
			// *************Logging in to Account *******************//
			// ******************************************************//

			if (choice.equals("1")) {
				System.out.println("Please Log in");
				System.out.println("Username:");
				checkUser();
				if (repeatMain) {
					System.out.println("entered exit mode");
					break;
				}
				while (!validInput) { // check password corresponds with Username
					System.out.println("Password:");
					userP = sc.nextLine();
					userP.toLowerCase();
					boolean validP = userP.equals(bankAccounts.get(currKey).getPassword());
					if (!validP) {
						System.out.println("Incorrect password. Please re-enter password");
					} else {
						break;
					}
				}
				// ******************************************************//
				// ******************Client Account ********************//
				// ******************************************************//
				if (bankAccounts.get(currKey).getUserType() == 1) {
					System.out.println(bankAccounts.get(currKey).getApplicationStatus());
					if (bankAccounts.get(currKey).getApplicationStatus() == 1) { // approved account
						while (repeatOptions) {
							System.out.println(
									"Welcome " + bankAccounts.get(currKey).getfName() + "! What would you like to do?");
							String options = "1: Check Information 2: Access Accounts 3: Return to main";
							System.out.println(options);
							System.out.println("Enter 1, 2, or 3");
							// implement options
							while (!validInput) {
								choice = sc.nextLine();
								if ((choice.equals("1")) || (choice.equals("2"))) {
									break;
								} else if (choice.equals("3")) {
									repeatMain = true;
									break;
								} else {
									System.out.println("Invalid input. Please enter 1, 2, or 3");
								}
							}

							if (repeatMain) { // should break out of repeat loop and restart
								break;
							}

							if (choice.equals("1")) {
								// check balance of account and other information
								System.out.println("AccountKey: " + currKey);
								bankAccounts.get(currKey).viewInformation();
								menuOption();
							} else if (choice.equals("2")) {
								// sends to client to go through accounts names
								// if (bankAccounts.get(currKey).getApplicationStatus() == 1) { // application
								// approved
								bankAccounts.get(currKey).accessAccounts(bankAccounts, currKey);
								// } else if (bankAccounts.get(currKey).getApplicationStatus() == 0) { //
								// application
								// status pending
								// System.out.println("Access Denied. Your account is still pending.");
								// } else {
								// System.out.println("Access Denied. Your account has been denied.");
								// }
								// access accounts allows to access specific account to manipulate
							} else {
								System.out.println("Error in choice between looking at account options");
							}
							if (repeatMain) {
								repeatOptions = false;
							}
						}
					} else {
						System.out.println("Error. Your account is not active. Please speak witih employee");
						repeatMain = true;
					}
				} else if (repeatMain) { // should break out of repeat loop and restart
					break;
				}

				// ******************************************************//
				// ******************Employee Account *******************//
				// ******************************************************//
				else if (bankAccounts.get(currKey).getUserType() == 2) {
					while (repeatOptions) {
						System.out.println("Welcome employee: " + bankAccounts.get(currKey).getfName());
						System.out.println("What would you like to do?");
						String options = "1: Check Account Application Status, 2: Check Account Information, 3: Return to main";
						System.out.println(options);
						System.out.println("Enter 1, 2, or 3");
						// implement options
						while (!validInput) {
							choice = sc.nextLine();
							if (choice.equals("1") || choice.equals("2") || choice.equals("3")) {
								break;
							} else {
								System.out.println("Invalid input. Please enter 1, 2, or 3");
							}
						}
						switch (choice) {
						case "1":
							// check account application status
							verifyClient();
							if (repeatMain) {
								break;
							}
							bankAccounts.get(currKey).setAccountStatus();
							menuOption();

							break;
						case "2": // view information
							System.out.println("Please enter username of of the user you want to look at");
							verifyClient();
							if (repeatMain) {
								break;
							}
							bankAccounts.get(currKey).viewAccount();
							menuOption();
							break;
						case "3":
							repeatMain = true;
							break;
						default:
							System.out.println("Error in choice between looking at account options");
							menuOption();
							break;
						}
						if (repeatMain) {
							repeatOptions = false;
							break;
						}
					}
					// ******************************************************//
					// *************Chance to loop back to start ************//
					// ******************************************************//

				} else if (repeatMain) {
					break;
				}

				// ******************************************************//
				// *****************Sys Admin Account *******************//
				// ******************************************************//
				else if (bankAccounts.get(currKey).getUserType() == 3) {
					int temp = currKey;
					while (repeatOptions) {
						System.out.println("Welcome system administrator: " + bankAccounts.get(currKey).getfName());
						System.out.println("What would you like to do?");
						String options = "1: Check Application Status/Cancel Account 2: Check Account Information 3: Change a user's password 4: Access Client Account 5: Change Password 6: Return to Main Menu";
						System.out.println(options);
						System.out.println("Enter 1, 2, 3, 4, 5, or 6");
						// implement options
						while (!validInput) {
							choice = sc.nextLine();
							if (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4")
									|| choice.equals("5") || choice.equals("6")) {
								break;
							} else {
								System.out.println("Invalid input. Please enter 1, 2, 3, 4, 5, or 6");
							}
						}
						switch (choice) {
						case "1":
							// check account application status
							verifyClient();
							// System.out.println(repeatMain);
							if (repeatMain) {
								break;
							} else {
								bankAccounts.get(currKey).setAccountStatusAd();
								menuOption();
							}
							break;
						case "2": // view information
							verifyClient();
							if (repeatMain) {
								break;
							}
							bankAccounts.get(currKey).viewAccount();
							menuOption();
							break;
						case "3": // change user's password
							verifyClient();
							if (repeatMain) {
								break;
							}
							System.out.println("Enter new Password: ");
							userP = sc.nextLine();
							userP.toLowerCase();
							bankAccounts.get(currKey).setPassword(userP);
							System.out.println(
									bankAccounts.get(currKey).getUsername() + "'s password successfully updated ");
							menuOption();
							break;
						case "4":
							accountKey = currKey;
							verifyClient();
							if (repeatMain) {
								break;
							}
							bankAccounts.get(accountKey).accessAccounts(bankAccounts, currKey);
							menuOption();
							break;
						case "5":
							System.out.println("Enter new Password: ");
							userP = sc.nextLine();
							userP.toLowerCase();
							bankAccounts.get(temp).setPassword(userP);
							System.out.println(
									bankAccounts.get(temp).getUsername() + "'s password successfully updated ");
							menuOption();
							break;
						case "6":
							repeatMain = true;
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
					System.out
							.println("Error has occurred with userType not being a client, employee, or system admin");
				}
			}

			// ******************************************************//
			// ******************Creating Account *******************//
			// ******************************************************//
			else if (choice.equals("2")) {
				System.out.println(
						"Please enter what account type you are opening 1: Client 2: Employee or 3: System Admin");
				System.out.println("Please enter 1, 2, or 3");
				while (!validInput) {
					choice = sc.nextLine();
					if (choice.equals("1") || choice.equals("2") || choice.equals("3")) {
						break;
					} else {
						System.out.println("Invalid choice. Please enter 1, 2 or 3");
					}

				}
				switch (choice) {
				case "1":
					Account cl = new Account(bankAccounts, choice);
					createKey();
					bankAccounts.put(accountKey, cl);
					int temp = 0;
					temp = cl.apply(bankAccounts, accountKey);
					System.out.println(temp);
					int temp2 = accountKey;
					if (temp > 0) {
						Account jo = new Account(bankAccounts, accountKey, temp);
						createKey();
						bankAccounts.put(accountKey, jo);
						bankAccounts.get(temp2).setJoint(accountKey);
						bankAccounts.get(temp).setJoint(accountKey);
					}
					ob.writeObject(cl);
					repeatMain = false;
					break;
				case "2":
					Account em = new Account(bankAccounts, choice);
					createKey();
					bankAccounts.put(accountKey, em);
					ob.writeObject(em);
					repeatMain = false;
					break;
				case "3":
					Account sa = new Account(bankAccounts, choice);
					createKey();
					bankAccounts.put(accountKey, sa);
					ob.writeObject(sa);
					repeatMain = false;
					break;
				default:
					System.out.println(
							"Error in choice betweenw hat type of account creating 0 =client, 1 =employee, 2 = sys ad");
					break;
				}
				ob.close();
				// System.out.println("Exiting to main menu now");
				// repeatMain = true;
			} else {
				System.out.println("error has occurred with choosing whether to open an account or log in");
			}
		} // end of repeat main method
			// } // end of repeat start
	} // end of main method

	// ******************************************************//
	// ****************** Functions to use ******************//
	// ******************************************************//
	static void menuOption() {
		System.out.println("Do you want to reurn to 1: main menu or 2: options screen");
		System.out.println();
		while (!validInput) {
			choice = sc.nextLine();
			if (choice.equals("1")) {
				repeatMain = true;
				break;
			} else if (choice.equals("2")) {
				repeatOptions = true;
				break;
			} else {
				System.out.println("Invalid. can only choose 1 or 2");
			}
		}
	}

	static void checkUser() {
		while (!validInput) {
			userN = sc.nextLine();
			userN.toLowerCase();
			if (userN.equals("exit")) {
				System.out.println("entered exit mode");
				repeatMain = true;
				break;
			}
			System.out.println(bankAccounts.toString());
			for (Entry<Integer, Account> en : bankAccounts.entrySet()) { // iterate through all members
				// check if accountKey is in map
				System.out.println(en.getValue().getUsername());
				if (userN.equals(en.getValue().getUsername())) {
					currKey = en.getKey();
					userExists = true;
					break;
				}
			}
			if (!userExists) {
				System.out.println("The username does not exist!");
				System.out.println("Please re-enter username"); // TODO: can add the ability to search by accountkey
																// instead? yes or no?
			} else {
				userExists = false;
				break;
			}
		}
	}

	static void createKey() {
		while (!validInput) {
			accountKey = r.nextInt(9999);
			for (Entry<Integer, Account> en : bankAccounts.entrySet()) { // iterate through all members
				if (accountKey == en.getKey()) { // check if accountKey is in map
					continue;
				} else { // accountKey is unique
					break;
				}
			}
			break;
		}
	}

	static void verifyClient() {
		while (!validInput) {
			System.out.println("Enter the username of the acocunt you wish to review");
			checkUser();
			if (bankAccounts.get(currKey).getUserType() == 1) {
				break;
			} else {
				System.out.println("Not valid. Only Clients can be accessed.");
			}
		}
	}
}
