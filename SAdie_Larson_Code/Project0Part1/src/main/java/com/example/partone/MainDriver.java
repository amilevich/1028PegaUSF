package com.example.partone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainDriver {
	// Static variables used in main method, functions, and the account class
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
	final static Logger loggy = Logger.getLogger(MainDriver.class);

	public static void main(String[] args) {
		String filename = "./bankUsers.txt";
		readObject(filename); // Reads in past bank accounts created and adds to hashmap to parse through data
		// function created around line 505
		// **************************Variables Used******************************//
		String userP = null;
		while (repeatMain) { // will repeat continuously unless user wants to end completely
			System.out.println("These are the bank Accounts made");
			System.out.println(bankAccounts.toString());
			repeatMain = false;
			repeatOptions = true;

			System.out.println("Hello, welcome to Revature Banking.");
			System.out.println("Do you want to 1: Log in or 2: Create an acocunt");
			System.out.println("Enter 1 or 2:");
			while (true) {
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
				checkUser(); // function made to check if user exists with username
				// created around line 452
				if (repeatMain) {
					System.out.println("entered exit mode");
					break;
				}
				while (true) { // check password corresponds with Username
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
						loggy.info(bankAccounts.get(currKey).getUsername() + " Logged in");
						while (repeatOptions) {
							System.out.println(
									"Welcome " + bankAccounts.get(currKey).getUsername() + "! What would you like to do?");
							String options = "1: Check Information 2: Access Accounts 3: Change Passswrod 4: Return to main";
							System.out.println(options);
							System.out.println("Enter 1, 2, or 3");
							// implement options
							while (true) {
								choice = sc.nextLine();
								if ((choice.equals("1")) || (choice.equals("2")) || choice.equals("3")|| choice.equals("4")) {
									break;
								} else {
									System.out.println("Invalid input. Please enter 1, 2, 3, or 4");
								}
							}

							if (repeatMain) { // should break out of repeat loop and restart
								break;
							}
							switch (choice) {
							case "1":
								// check balance of account and other information
								System.out.println("AccountKey: " + currKey);
								bankAccounts.get(currKey).viewInformation();
								menuOption();
								break;
							case "2":
								// sends to client to go through accounts names
								// if (bankAccounts.get(currKey).getApplicationStatus() == 1) { // application
								// approved
								bankAccounts.get(currKey).accessAccounts(bankAccounts, currKey);
								menuOption();
								break;

							case "3":
								// change password
								System.out.println("Enter new Password: ");
								userP = sc.nextLine();
								userP.toLowerCase();
								bankAccounts.get(currKey).setPassword(userP);
								System.out.println(
										bankAccounts.get(currKey).getUsername() + "'s password successfully updated ");
								loggy.info(bankAccounts.get(currKey).getUsername() + " Changed their password");
								menuOption();
								break;
							case "4":
								// return to main menu
								repeatMain = true;
								break;
							default:
								System.out.println("Error in choice between looking at account options");
							}
							if (repeatMain) {
								repeatOptions = false;
							}
						}
					} else {
						System.out.println("Error. Your account is not active. Please speak witih employee");
						loggy.info(
								bankAccounts.get(currKey).getUsername() + " Tried to log in but account is not active");
						repeatMain = true;
					}
				} else if (repeatMain) { // should break out of repeat loop and restart
					break;
				}

				// ******************************************************//
				// ******************Employee Account *******************//
				// ******************************************************//
				else if (bankAccounts.get(currKey).getUserType() == 2) {
					loggy.info(bankAccounts.get(currKey).getUsername() + " Logged in");
					while (repeatOptions) {
						System.out.println("Welcome employee: " + bankAccounts.get(currKey).getUsername());
						System.out.println("What would you like to do?");
						String options = "1: Check Account Application Status, 2: Check Account Information, 3: Return to main";
						System.out.println(options);
						System.out.println("Enter 1, 2, or 3");
						// implement options
						while (true) {
							choice = sc.nextLine();
							if (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4")) {
								break;
							} else {
								System.out.println("Invalid input. Please enter 1, 2, 3, or 4");
							}
						}
						switch (choice) {
						case "1":
							// check account application status
							String temp = bankAccounts.get(currKey).getUsername();
							verifyClient(); // calls the checkUser function and verifies that account employee is trying
											// to access is a client only
							// function created around line 496
							if (repeatMain) {
								break;
							}
							bankAccounts.get(currKey).setAccountStatus();
							if (bankAccounts.get(currKey).getApplicationStatus() == 1) {
								loggy.info(
										temp + " Approved " + bankAccounts.get(currKey).getUsername() + "'s account");
							} else if (bankAccounts.get(currKey).getApplicationStatus() == 2) {
								loggy.info(temp + " Denied " + bankAccounts.get(currKey).getUsername() + "'s account");
							}
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
							// change password
							System.out.println("Enter new Password: ");
							userP = sc.nextLine();
							userP.toLowerCase();
							bankAccounts.get(currKey).setPassword(userP);
							System.out.println(
									bankAccounts.get(currKey).getUsername() + "'s password successfully updated ");
							loggy.info(bankAccounts.get(currKey).getUsername() + " Changed their password");
							menuOption();
							break;
						case "4":
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
					String tempU = bankAccounts.get(currKey).getUsername();
					loggy.info(tempU + " Logged in");
					int temp = currKey;
					while (repeatOptions) {
						System.out.println("Welcome system administrator: " + bankAccounts.get(currKey).getUsername());
						System.out.println("What would you like to do?");
						String options = "1: Check Application Status/Cancel Account 2: Check Account Information 3: Change a user's password 4: Access Client Account 5: Change Password 6: Return to Main Menu";
						System.out.println(options);
						System.out.println("Enter 1, 2, 3, 4, 5, or 6");
						// implement options
						while (true) {
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
								if (bankAccounts.get(currKey).getApplicationStatus() == 1) {
									loggy.info(tempU + " Approved " + bankAccounts.get(currKey).getUsername()
											+ "'s account");
								} else if (bankAccounts.get(currKey).getApplicationStatus() == 2) {
									loggy.info(tempU + " Denied/Cancelled " + bankAccounts.get(currKey).getUsername()
											+ "'s account");
								}
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
							loggy.info(bankAccounts.get(temp).getUsername() + " changed "
									+ bankAccounts.get(currKey).getUsername() + "'s password");
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
							loggy.info(bankAccounts.get(temp).getUsername() + " Changed their password");
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
				while (true) {
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
					cl.setHashKey(accountKey);
					bankAccounts.put(accountKey, cl);
					System.out.println();
					loggy.info(cl.getUsername() + " Creted an Account");
					int temp = 0;
					temp = cl.apply(bankAccounts, accountKey);
					System.out.println(temp);
					int temp2 = accountKey;
					if (temp > 0) {
						Account jo = new Account(bankAccounts, accountKey, temp);
						createKey();
						bankAccounts.put(accountKey, jo);
						loggy.info(cl.getUsername() + " Creted an Joint Account with "
								+ bankAccounts.get(temp2).getUsername());
						bankAccounts.get(temp2).setJoint(accountKey);
						bankAccounts.get(temp).setJoint(accountKey);
						jo.setHashKey(accountKey);
					}
					repeatMain = false;
					break;
				case "2":
					Account em = new Account(bankAccounts, choice);
					createKey();
					em.setHashKey(accountKey);
					bankAccounts.put(accountKey, em);
					loggy.info(em.getUsername() + " Creted an Account");
					repeatMain = false;
					break;
				case "3":
					Account sa = new Account(bankAccounts, choice);
					createKey();
					sa.setHashKey(accountKey);
					bankAccounts.put(accountKey, sa);
					loggy.info(sa.getUsername() + " Creted an Account");
					repeatMain = false;
					break;
				default:
					System.out.println(
							"Error in choice betweenw hat type of account creating 0 =client, 1 =employee, 2 = sys ad");
					break;
				}
				// System.out.println("Exiting to main menu now");
				// repeatMain = true;
			} else {
				System.out.println("error has occurred with choosing whether to open an account or log in");
			}
			System.out.println("Would you like to exit now? 1: Yes,  2: No");
			while (true) {
				choice = sc.nextLine();
				if (choice.equals("1")) {
					repeatMain = false;
					break;
				} else if (choice.equals("2")) {
					repeatMain = true;
					break;
				} else {
					System.out.println("Invalid. can only choose 1 or 2");
				}
			}
		} // end of repeat main method

		// ********Adding Account information to SerializedFile***********//

		ArrayList arrObj = new ArrayList();
		// HashMap<Integer, ArrayList> accountsObj = new HashMap<Integer, ArrayList>();
		for (Entry<Integer, Account> en : bankAccounts.entrySet()) {
			arrObj.add(en.getValue().getHashKey()); // int
			arrObj.add(en.getValue().userPass);
			arrObj.add(en.getValue().getApplicationStatus()); // int
			arrObj.add(en.getValue().getUserType()); // int
			arrObj.add(en.getValue().getJoint()); // int
			arrObj.add(en.getValue().accounts); // hashmap
		}

		HashMap<Integer, ArrayList> accountsObj = new HashMap<Integer, ArrayList>();

		int i = 0;
		for (Entry<Integer, Account> en : bankAccounts.entrySet()) {
			ArrayList arr = new ArrayList();
			for (int j = 0; j < 6; j++) {
				arr.add(arrObj.get(i + j));
				accountsObj.put(en.getValue().getHashKey(), arr);
			}
			i += 6;
		}

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(accountsObj);
		} catch (IOException io) {
			io.printStackTrace();
		}

		// readObject(filename); // testing to make sure it was r=wrritten correctly and
		// can be accessed
		System.out.println("Done");

	} // end of main method

	// ******************************************************//
	// ****************** Functions to use ******************//
	// ******************************************************//
	private static void menuOption() { // returns user to main menu
		System.out.println("Do you want to reurn to 1: main menu or 2: options screen");
		System.out.println();
		while (true) {
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

	private static void checkUser() { // checks if the user exists
		while (true) {
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
				// System.out.println(en.getValue().getUsername());
				if (userN.equals(en.getValue().getUsername())) {
					currKey = en.getKey();
					userExists = true;
					break;
				}
			}
			if (!userExists) {
				System.out.println("The username does not exist!");
				System.out.println("Please re-enter username");
			} else {
				userExists = false;
				break;
			}
		}
	}

	private static void createKey() { // creates a special key from 0-9999
		while (true) {
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

	private static void verifyClient() { // checks if client exists
		while (true) {
			System.out.println("Enter the username of the acocunt you wish to review");
			checkUser();
			if (bankAccounts.get(currKey).getUserType() == 1) {
				break;
			} else {
				System.out.println("Not valid. Only Clients can be accessed.");
			}
		}
	}

	private static void readObject(String filename) { // this method will read all of the objects from file (database)
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			while (true) {
				try {
					while (true) {
						HashMap<Integer, ArrayList> obj = (HashMap) ois.readObject();
						System.out.println(obj);
						for (Entry<Integer, ArrayList> en : obj.entrySet()) {
							Account obac = new Account();
							obac.setHashKey((int) en.getValue().get(0));
							obac.userPass = (HashMap) en.getValue().get(1);
							obac.setUsername(obac.userPass.keySet().iterator().next());
							obac.setPassword(obac.userPass.get(obac.getUsername()));
							obac.setApplicationStatus((int) en.getValue().get(2));
							obac.setUserType((int) en.getValue().get(3));
							obac.setJoint((int) en.getValue().get(4));
							obac.accounts = (HashMap) en.getValue().get(5);
							bankAccounts.put(obac.getHashKey(), obac);
						}
					}
				} catch (Exception e) {
					// e.printStackTrace();
					break;
				}
			}
		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("Done passing in bankAccounts data");
		}
	}
}
