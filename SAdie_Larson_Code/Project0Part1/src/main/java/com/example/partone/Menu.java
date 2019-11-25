package com.example.partone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.example.dao.BankAccountsDaoImpl;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Menu {
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
	public static BankAccountsDaoImpl b = new BankAccountsDaoImpl();

	public void menuShow() {
		// String filename = "./bankUsers6.txt";
		// readObject(filename); // Reads in past bank accounts created and adds to
		// hashmap to parse through data
		// function created around line 505
		// **************************Variables Used******************************//
		String userP = null;
		while (repeatMain) { // will repeat continuously unless user wants to end completely
			bankAccounts = b.selectBankAccounts();
			System.out.println(
					"---------------------------------------------------------------------------------------------------");
			System.out.println(
					"|$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$|");
			System.out.println(
					"---------------------------------------------------------------------------------------------------");
			System.out.println("\t\t\tThese are the bank Accounts stored:");
			for (Entry<Integer, Account> en : bankAccounts.entrySet()) {
				System.out.println(en.toString());
			}
			System.out.println(
					"---------------------------------------------------------------------------------------------------");
			System.out.println(
					"|$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$🏦$|");
			System.out.println(
					"---------------------------------------------------------------------------------------------------");
			repeatMain = false;
			repeatOptions = true;
			System.out.println("\t\t\tHello, welcome to Revature Banking.");
			System.out.println("\t\t\tDo you want to 1: Log in or 2: Create an account");
			System.out.println("\t\t\tEnter 1 or 2:");
			while (true) {
				choice = sc.nextLine();
				if ((choice.equals("1")) || (choice.equals("2"))) {
					break;
				} else {
					System.out.println("\t\t\tInvalid input. Please enter 1 or 2");
				}
			}
			// ******************************************************//
			// *************Logging in to Account *******************//
			// ******************************************************//
			if (choice.equals("1")) {
				System.out.println("\t\t\tPlease Log in");
				System.out.println("\t\t\tUsername:");
				checkUser(); // function made to check if user exists with username
				// created around line 452
				if (repeatMain) {
					break;
				}
				while (true) { // check password corresponds with Username
					System.out.println("\t\t\tPassword Case Sensitive:");
					userP = sc.nextLine();
					for (Entry<Integer, Account> en : bankAccounts.entrySet()) { // iterate through all members
						// check if accountKey is in map
						// System.out.println(en.getValue().getUsername());
						for (Entry<String, String> en2 : en.getValue().userPass.entrySet()) {
							if (userP.equals(en2.getValue())) {
								userExists = true;
								break;
							}
						}
						if (userExists) {
							break;
						}
					}
					if (!userExists) {
						System.out.println("\t\t\tPlease re-enter password");
					} else {
						userExists = false;
						break;
					}
				}

				// ******************************************************//
				// ******************Client Account ********************//
				// ******************************************************//
				if (bankAccounts.get(currKey).getUserType() == 1) {
					int temp = currKey;
					String tempU = "";
					for (Entry<String, String> i : bankAccounts.get(currKey).userPass.entrySet()) {
						tempU += (" " + i.getKey());
					}
					// System.out.println(bankAccounts.get(temp).getApplicationStatus());
					if (bankAccounts.get(temp).getApplicationStatus() == 1) { // approved account
						loggy.info(tempU + " Logged in");
						while (repeatOptions) {
							System.out.println("\t\t\tWelcome " + tempU + "! What would you like to do?");
							String options = "\t\t\t1: Check Information 2: Access Accounts 3: Change Passsword 4: Return to main";
							System.out.println(options);
							System.out.println("\t\t\tEnter 1, 2, or 3");
							// implement options
							while (true) {
								choice = sc.nextLine();
								if ((choice.equals("1")) || (choice.equals("2")) || choice.equals("3")
										|| choice.equals("4")) {
									break;
								} else {
									System.out.println("\t\t\tInvalid input. Please enter 1, 2, 3, or 4");
								}
							}

							if (repeatMain) { // should break out of repeat loop and restart
								break;
							}
							switch (choice) {
							case "1":
								// check balance of account and other information
								System.out.println("\t\t\tAccountKey: " + currKey);
								bankAccounts.get(currKey).viewInformation(bankAccounts);
								menuOption();
								break;
							case "2":
								// sends to client to go through accounts names
								bankAccounts.get(currKey).accessAccounts(bankAccounts, currKey);
								b.updateBankAccounts(bankAccounts.get(currKey));
								menuOption();
								break;

							case "3":
								// change password
								System.out.println("\t\t\tEnter new Password Case Sensitive:  ");
								userP = sc.nextLine();
								for (Entry<String, String> i : bankAccounts.get(currKey).userPass.entrySet()) {
									i.setValue(userP);
								}
								System.out.println(
										tempU + "'s password successfully updated ");
								loggy.info(tempU + " Changed their password");
								b.updateBankAccounts(bankAccounts.get(currKey));
								menuOption();
								break;
							case "4":
								// return to main menu
								repeatMain = true;
								break;
							default:
								System.out.println("\t\t\tError in choice between looking at account options");
							}
							if (repeatMain) {
								repeatOptions = false;
							}
						}
					} else {
						System.out.println("\t\t\tError. Your account is not active. Please speak witih employee\n");
						loggy.info(
								tempU + " Tried to log in but account is not active");
						repeatMain = true;
					}
				} else if (repeatMain) { // should break out of repeat loop and restart
					break;
				}

				// ******************************************************//
				// ******************Employee Account *******************//
				// ******************************************************//
				else if (bankAccounts.get(currKey).getUserType() == 2) {
					int tempEKey = currKey;
					String tempU = "";
					for (Entry<String, String> i : bankAccounts.get(currKey).userPass.entrySet()) {
						tempU += (" " + i.getKey());
					}
					loggy.info(tempU + " Logged in");
					while (repeatOptions) {
						System.out.println("\t\t\t\t\t\tWelcome employee: " + tempU);
						System.out.println("\t\t\tWhat would you like to do?");
						String options = "1: Check Account Application Status, 2: Check Account Information, 3: Change Password 4: Return to main";
						System.out.println(options);
						System.out.println("\t\t\tEnter 1, 2, 3, or 4");
						// implement options
						while (true) {
							choice = sc.nextLine();
							if (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4")) {
								break;
							} else {
								System.out.println("\t\t\tInvalid input. Please enter 1, 2, 3, or 4");
							}
						}
						switch (choice) {
						case "1":
							// check account application status
							verifyClient(); // calls the checkUser function and verifies that account employee is
											// trying
											// to access is a client only
							// function created around line 496
							if (repeatMain) {
								break;
							}
							String tempU2 = "";
							for (Entry<String, String> i : bankAccounts.get(currKey).userPass.entrySet()) {
								tempU2 += (" " + i.getKey());
							}
							//Set account status
							bankAccounts.get(currKey).setAccountStatus();
							if (bankAccounts.get(currKey).getApplicationStatus() == 1) {
								loggy.info(tempU + " Approved " + tempU2 + "'s account");
							} else if (bankAccounts.get(currKey).getApplicationStatus() == 2) {
								loggy.info(tempU + " Denied " + tempU2 + "'s account");
							}
							System.out.println(bankAccounts.get(currKey).getHashKey());
							
							System.out.println("hi");
							b.updateBankAccounts(bankAccounts.get(currKey));
							menuOption();
							break;
						case "2": // view information
							System.out.println("\t\t\tPlease enter username of the user you want to look at");
							verifyClient();
							if (repeatMain) {
								break;
							}
							bankAccounts.get(currKey).viewInformation(bankAccounts);
							menuOption();
							break;
						case "3":
							// change password
							System.out.println("\t\t\tEnter new Password Case Sensitive: ");
							userP = sc.nextLine();
							for (Entry<String, String> i : bankAccounts.get(currKey).userPass.entrySet()) {
								i.setValue(userP);
							}
							System.out.println(tempU + "'s password successfully updated ");
							loggy.info(tempU + " Changed their password");
							b.updateBankAccounts(bankAccounts.get(currKey));
							menuOption();
							break;
						case "4":
							repeatMain = true;
							break;
						default:
							System.out.println("\t\t\tError in choice between looking at account options");
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
					String tempU = "";
					for (Entry<String, String> i : bankAccounts.get(currKey).userPass.entrySet()) {
						tempU += (" " + i.getKey());
					}
					loggy.info(tempU + " Logged in");
					int temp = currKey;
					while (repeatOptions) {
						System.out.println("\t\t\tWelcome system administrator: " + tempU);
						System.out.println("\t\t\tWhat would you like to do?");
						String options = "1: Check Application Status/Cancel Account 2: Check Account Information 3: Change a user's password 4: Access Client Account 5: Change Password 6: Return to Main Menu";
						System.out.println(options);
						System.out.println("\t\t\tEnter 1, 2, 3, 4, 5, or 6");
						// implement options
						while (true) {
							choice = sc.nextLine();
							if (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4")
									|| choice.equals("5") || choice.equals("6")) {
								break;
							} else {
								System.out.println("\t\t\tInvalid input. Please enter 1, 2, 3, 4, 5, or 6");
							}
						}
						switch (choice) {
						case "1":
							// check account application status
							verifyClient();
							if (repeatMain) {
								break;
							} else {
								String tempU2 = "";
								for (Entry<String, String> i : bankAccounts.get(currKey).userPass.entrySet()) {
									tempU2 += (" " + i.getKey());
								}
								bankAccounts.get(currKey).setAccountStatusAd();
								if (bankAccounts.get(currKey).getApplicationStatus() == 1) {
									loggy.info(tempU + " Approved " + tempU2 + "'s account");
								} else if (bankAccounts.get(currKey).getApplicationStatus() == 2) {
									loggy.info(tempU + " Denied/Cancelled " + tempU2 + "'s account");
								}
								System.out.println(bankAccounts.get(currKey));
								b.updateBankAccounts(bankAccounts.get(currKey));
								menuOption();
							}
							break;
						case "2": // view information
							verifyClient();
							if (repeatMain) {
								break;
							}
							bankAccounts.get(currKey).viewInformation(bankAccounts);
							menuOption();
							break;
						case "3": // change user's password
							verifyClient();
							if (repeatMain) {
								break;
							}
							String tempU2 = "";
							for (Entry<String, String> i : bankAccounts.get(currKey).userPass.entrySet()) {
								tempU2 += (" " + i.getKey());
							}
							System.out.println("\t\t\tEnter new Password Case Sensitive: ");
							userP = sc.nextLine();
							bankAccounts.get(currKey).setPassword(userP);
							System.out.println(tempU + "'s password successfully updated ");
							loggy.info(tempU + " changed " + tempU2 + "'s password");
							b.updateBankAccounts(bankAccounts.get(currKey));
							menuOption();
							break;
						case "4":
							accountKey = currKey;
							verifyClient();
							if (repeatMain) {
								break;
							}
							bankAccounts.get(accountKey).accessAccounts(bankAccounts, currKey);
							b.updateBankAccounts(bankAccounts.get(currKey));
							menuOption();
							break;
						case "5":
							System.out.println("\t\t\tEnter new Password Case Sensitive: ");
							userP = sc.nextLine();
							for (Entry<String, String> i : bankAccounts.get(currKey).userPass.entrySet()) {
								i.setValue(userP);
							}
							System.out.println(tempU + "'s password successfully updated ");
							loggy.info(tempU + " Changed their password");
							b.updateBankAccounts(bankAccounts.get(temp));
							menuOption();
							break;
						case "6":
							repeatMain = true;
							break;
						default:
							System.out.println("\t\t\tError in choice between looking at account options");
							menuOption();
							break;
						}
						if (repeatMain) {
							repeatOptions = false;
						}
					}
				} else {
					System.out.println(
							"\t\t\tError has occurred with userType not being a client, employee, or system admin");
				}
			}

			// ******************************************************//
			// ******************Creating Account *******************//
			// ******************************************************//
			else if (choice.equals("2")) {
				System.out.println(
						"Please enter what account type you are opening 1: Client 2: Employee or 3: System Admin");
				System.out.println("\t\t\tPlease enter 1, 2, or 3");
				while (true) {
					choice = sc.nextLine();
					if (choice.equals("1") || choice.equals("2") || choice.equals("3")) {
						break;
					} else {
						System.out.println("\t\t\tInvalid choice. Please enter 1, 2 or 3");
					}

				}
				switch (choice) {
				case "1":
					Account cl = new Account(bankAccounts, choice);
					createKey();
					cl.setHashKey(accountKey);
					bankAccounts.put(accountKey, cl);
					b.insertBankAccounts(cl);
					System.out.println();
					String tempU = "";
					for (Entry<String, String> i : cl.userPass.entrySet()) {
						tempU += (" " + i.getKey());
					}
					loggy.info(tempU + " Creted an Account");
					int temp = 0;
					temp = cl.apply(bankAccounts, accountKey);
					int temp2 = accountKey;
					if (temp > 0) {
						Account jo = new Account(bankAccounts, accountKey, temp);
						createKey();
						String tempU2 = "";
						for (Entry<String, String> i : jo.userPass.entrySet()) {
							tempU2 += (" " + i.getKey());
						}
						bankAccounts.put(accountKey, jo);
						loggy.info(tempU + " Creted an Joint Account with " + tempU2);
						bankAccounts.get(temp2).setJoint(accountKey);
						bankAccounts.get(temp).setJoint(accountKey);
						jo.setHashKey(accountKey)
						;
						b.insertBankAccounts(jo);
					}
					repeatMain = true;
					break;
				case "2":
					Account em = new Account(bankAccounts, choice);
					createKey();
					em.setHashKey(accountKey);
					bankAccounts.put(accountKey, em);
					String tempUE = "";
					for (Entry<String, String> i : em.userPass.entrySet()) {
						tempUE += (" " + i.getKey());
					}
					loggy.info(tempUE + " Creted an Account");
					b.insertBankAccounts(em);
					repeatMain = true;
					break;
				case "3":
					Account sa = new Account(bankAccounts, choice);
					createKey();
					sa.setHashKey(accountKey);
					bankAccounts.put(accountKey, sa);
					String tempUS = "";
					for (Entry<String, String> i : sa.userPass.entrySet()) {
						tempUS += (" " + i.getKey());
					}
					loggy.info(tempUS + " Creted an Account");
					b.insertBankAccounts(sa);
					repeatMain = true;
					break;
				default:
					System.out.println(
							"Error in choice betweenw hat type of account creating 0 =client, 1 =employee, 2 = sys ad");
					break;
				}
				// System.out.println("\t\t\tExiting to main menu now");
				// repeatMain = true;
			} else {
				System.out.println("\t\t\terror has occurred with choosing whether to open an account or log in");
			}

		} // end of repeat main method

		// ********Adding Account information to SerializedFile***********//

		// ArrayList<Object> arrObj = new ArrayList<Object>();
		// // HashMap<Integer, ArrayList> accountsObj = new HashMap<Integer,
		// ArrayList>();
		// for (Entry<Integer, Account> en : bankAccounts.entrySet()) {
		// arrObj.add(en.getValue().getHashKey()); // int
		// arrObj.add(en.getValue().userPass);
		// arrObj.add(en.getValue().getApplicationStatus()); // int
		// arrObj.add(en.getValue().getUserType()); // int
		// arrObj.add(en.getValue().getJoint()); // int
		// arrObj.add(en.getValue().accounts); // hashmap
		// }
		//
		// HashMap<Integer, ArrayList> accountsObj = new HashMap<Integer, ArrayList>();
		//
		// int i = 0;
		// for (Entry<Integer, Account> en : bankAccounts.entrySet()) {
		// ArrayList arr = new ArrayList();
		// for (int j = 0; j < 6; j++) {
		// arr.add(arrObj.get(i + j));
		// accountsObj.put(en.getValue().getHashKey(), arr);
		// }
		// i += 6;
		// }

		// try (ObjectOutputStream oos = new ObjectOutputStream(new
		// FileOutputStream(filename))) {
		// oos.writeObject(accountsObj);
		// } catch (IOException io) {
		// io.printStackTrace();
		// }

		// for (Entry<Integer, Account> en : bankAccounts.entrySet()) {
		// b.insertBankAccounts(en.getValue());
		// }
		// b.selectById(9550);
		// bankAccounts = b.selectBankAccounts();
		// b.deleteBankAccounts(2290);

		// *********Send out to table**************//
		for (Entry<Integer, Account> en : bankAccounts.entrySet()) {
			b.updateBankAccounts(en.getValue());
		}

	} // end of main method

	// ******************************************************//
	// ****************** Functions to use ******************//
	// ******************************************************//
	private static void menuOption() { // returns user to main menu
		System.out.println("\t\t\tDo you want to return to 1: Main Menu or 2: Options Screen 3: Exit Program");
		System.out.println();
		while (true) {
			choice = sc.nextLine();
			if (choice.equals("1")) {
				repeatMain = true;
				break;
			} else if (choice.equals("2")) {
				repeatOptions = true;
				break;
			} else if (choice.equals("3")) {
				repeatMain = false;
				repeatOptions = false;
				break;
			} else {
				System.out.println("\t\t\tInvalid. can only choose 1, 2, or 3");
			}
		}
	}

	private static void checkUser() { // checks if the user exists
		while (true) {
			userN = sc.nextLine();
			userN = userN.toLowerCase();
			if (userN.equals("exit")) {
				repeatMain = true;
				break;
			}
			// System.out.println(bankAccounts.toString()); //used if I want to make it
			// easier for displaying
			for (Entry<Integer, Account> en : bankAccounts.entrySet()) { // iterate through all members
				// check if accountKey is in map
				// System.out.println(en.getValue().getUsername());
				for (Entry<String, String> en2 : en.getValue().userPass.entrySet()) {
					if (userN.equals(en2.getKey())) {
						currKey = en.getKey();
						userExists = true;
						break;
					}
				}
				if (userExists) {
					break;
				}
			}
			if (!userExists) {
				System.out.println("\t\t\tThe username does not exist!");
				System.out.println("\t\t\tPlease re-enter username");
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
			System.out.println("\t\t\tEnter the username of the account you wish to review");
			checkUser();
			if (bankAccounts.get(currKey).getUserType() == 1) {
				break;
			} else {
				System.out.println("\t\t\tNot valid. Only Clients can be accessed.");
			}
		}
	}

	// private static void readObject(String filename) { // this method will read
	// all of the objects from file (database)
	// try (ObjectInputStream ois = new ObjectInputStream(new
	// FileInputStream(filename))) {
	// while (true) {
	// try {
	// while (true) {
	// HashMap<Integer, ArrayList> obj = (HashMap) ois.readObject();
	// // System.out.println(obj);
	// for (Entry<Integer, ArrayList> en : obj.entrySet()) {
	// Account obac = new Account();
	// obac.setHashKey((int) en.getValue().get(0));
	// obac.userPass = (HashMap) en.getValue().get(1);
	// obac.setUsername(obac.userPass.keySet().iterator().next());
	// obac.setPassword(obac.userPass.get(obac.getUsername()));
	// obac.setApplicationStatus((int) en.getValue().get(2));
	// obac.setUserType((int) en.getValue().get(3));
	// obac.setJoint((int) en.getValue().get(4));
	// obac.accounts = (HashMap) en.getValue().get(5);
	// bankAccounts.put(obac.getHashKey(), obac);
	// }
	// }
	// } catch (Exception e) {
	// // e.printStackTrace();
	// break;
	// }
	// }
	// } catch (IOException e) {
	// // e.printStackTrace();
	// System.out.println("\t\t\tDone passing in bankAccounts data");
	// }
	// }
}
