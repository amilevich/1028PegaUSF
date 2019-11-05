package com.example.partone;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class Account {

	private String username;
	private String password;
	private String fName;
	private String lName;
	private int birthD;
	private int birthY;
	private int birthM;
	protected static int accountType; // 1: Single, 2: Joint
	private int userType; // client = 0, employee = 1, system admin = 2
	public String names;
	public int date;
	public static int accountKey;
	protected boolean accountExists = false;

	public boolean validInput;
	Scanner sc = new Scanner(System.in);
	public int yn; // use as yes or no option in scanner

	////////////////////////////////////////////////////////
	//// getters and setters ////// /////////////////////////
	///////////////////////////////////////////////////////
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		Account.accountType = accountType;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public int getBirthY() {
		return birthY;
	}

	public void setBirthY(int birthY) {
		this.birthY = birthY;
	}

	public int getBirthM() {
		return birthM;
	}

	public void setBirthM(int birthM) {
		this.birthM = birthM;
	}

	public int getBirthD() {
		return birthD;
	}

	public void setBirthD(int birthD) {
		this.birthD = birthD;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	////////////////////////////////////////////////////////
	//// creating an actual account /////////////////////////
	///////////////////////////////////////////////////////
	public Account(HashMap<Integer, Account> bankAccounts, int choice) {
		createAccount(bankAccounts, choice);
		if (choice == 1) { // client
			apply(bankAccounts);
		}
		System.out.println("done constructing");
	}

	public void createAccount(HashMap<Integer, Account> bankAccounts, int choice) { // using this as constructor but
																					// might want
		// to change into main driver?
		switch (choice) {
		case 1:
			userType = 1;
			break;
		case 2:
			userType = 2;
			break;
		case 3:
			userType = 3;
			break;
		}
		System.out.println("Please enter a username below");
		while (!validInput) {
			username = sc.nextLine();
			for (Entry<Integer, Account> en : bankAccounts.entrySet()) { // iterate through all members in
				accountExists = username.equals(en.getValue().getUsername());
				if (accountExists) {
					break;
				}
			}
			if (accountExists) {
				System.out.println("Invalid. Username already exists.");
				System.out.println("Please enter a username below");
			} else if (username.length() < 1) { // change to check that username is NOT taken
				System.out.println("Invalid. Username needs to have at least one character");
			} else {
				break;
			}
		}
		//////////////////////////////////////////////////////////////////////////////////////////////
		///// setting up password
		////////////////////////////////////////////////////////////////////////////////////////////// //////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("Please enter a password below");
		while (!validInput) {
			password = sc.nextLine();
			if (password.length() < 1) { // change to verify password meets specs
				System.out.println("Invalid. errors occurred in creating a password");
			} else {
				break;
			}
		}

		setUsername(username);
		setPassword(password);
		//////////////////////////////////////////////////////////////////////////////////////////////
		///// setting up account
		////////////////////////////////////////////////////////////////////////////////////////////// information//////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////
		/*
		 * System.out.println("Please enter your first name below"); while (!validInput)
		 * { names = sc.nextLine(); if (names.equals(" ")) {
		 * System.out.println("Please enter at least one character"); } else { break; }
		 * } setfName(names);
		 * 
		 * System.out.println("Please enter your last name below"); while (!validInput)
		 * { names = sc.nextLine(); if (names.equals(" ")) {
		 * System.out.println("Please enter at least one character"); } else { break; }
		 * } setlName(names);
		 * 
		 * System.out.println("Please enter your birth month"); while (!validInput) {
		 * date = sc.nextInt(); if ((date < 1) || date > 12) {
		 * System.out.println("Months fall between 1-12"); } else { break; } }
		 * setBirthM(date);
		 * 
		 * System.out.println("Please enter your birth day"); while (!validInput) { date
		 * = sc.nextInt(); if ((date < 1) || date > 31) {
		 * System.out.println("Dates fall between 1-31"); } else { break; } }
		 * setBirthD(date);
		 * 
		 * System.out.println("Please enter your birth year"); while (!validInput) {
		 * date = sc.nextInt(); if ((date < 1923) || date > 2001) {
		 * System.out.println("Years fall between 1923-2001"); } else { break; }
		 * 
		 * } setBirthY(date);
		 */
		// System.out.println("Awesome, your account is in pending. Log in after
		// employee approval has been confirmed");
	}

	// client account

	protected boolean accountHolder; // check to see status of account
	protected int accountBalance = 0;
	private int applicationStatus; // 0: applied, 1: approved, 2: denied

	public int getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(int applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	String accountCur; // checking, savings, whatever they call it
	int amount;

	Map<String, Integer> accounts = new HashMap<String, Integer>();

	public void createAccounts() { // note difference between account(user) and accounts (types of accounts a user
									// has)
		if (userType == 2) {
			System.out.println("Error. You are an Employee you do not have access to creating accounts");
		} else {
			System.out.println(
					"Enter the name of the account you want to create. Ex: Checkin, Savings, Leo's Checking, etc.");
			while (!validInput) {
				accountCur = sc.nextLine();
				for (Entry<String, Integer> en : accounts.entrySet()) { // iterate through all members
					// in
					// accounts map // check if accountKey is in map
					if (accountCur == en.getKey()) {
						System.out.println("Invalid. Accounts name already exists");
						accountExists = true;
					}
				}
				if (!accountExists) {
					break;
				}
			}
			accounts.put(accountCur, 0);
		}
	}

	public void accessAccounts(int choice) {
		System.out.println("Which account do you want to look at");
		while (!validInput) {
			accountCur = sc.nextLine();
			for (Entry<String, Integer> en : accounts.entrySet()) { // iterate through all members
				// in
				// accounts map // check if accountKey is in map
				if (accountCur == en.getKey()) {
					System.out.println("Invalid. Accounts name already exists");
					accountExists = true;
				}
			}
			if (accountExists) {
				break;
			}
		}
		if (choice == 2) {
			accounts.put(accountCur, deposit());
		} else if (choice == 3) {
			accounts.put(accountCur, withdraw());
		} else if (choice == 4) {
			transfer();
		} else {
			System.out.println("Erorr in client choice for accessAccounts should be a 2, 3, or 4");
		}

	}

	public void apply(HashMap<Integer, Account> bankAccounts) { // need to implement creating a joint account
		System.out.println("What type of account would you like to create? 1: Single or  2: Joint");
		while (!validInput) {
			accountType = sc.nextInt();
			System.out.println(accountType);
			if ((accountType == 1) || (accountType == 2)) { // keeps getting frozen here for some reason
				break;
			} else {
				System.out.println("Invalid input. Please enter either 1 or 2");

			}
		}

		if (accountType == 2) {
			System.out.println("You chose to make a joint account.");
			System.out.println("If you are joining an account please enter the account key below");
			while (!validInput) {
				accountKey = sc.nextInt();
				for (Entry<Integer, Account> en : bankAccounts.entrySet()) { // iterate through all members in
																				// accounts map
					if (accountKey == en.getKey()) { // check if accountKey is in map
						System.out.println("entered a joint acount key");
						break;
					} else { // accountKey does not match
						System.out.println("accountKey does nto match a current open account");
					}
				}
				break;
			}
		}
		System.out.println(
				"Fantastic, your account is pending employee approval. Log in after employee approval has been confirmed");
	}

	public void viewInformation() {
		System.out.println("Name: " + getfName() + " " + getlName());
		System.out.println("Account Staus: " + applicationStatus);
		System.out.println("Open accounts: " + accounts);

	}

	public int withdraw() {
		if (!this.accountHolder) {
			System.out.println("You do not have an account at this time");
			return 0;
		} else {
			System.out.println("Please enter amount you wish to withdraw:");
			while (!validInput) {
				amount = sc.nextInt();
				if (amount > accountBalance) { // checks if enough in account
					System.out.println("Invalid! Your acocunt only has: " + accountBalance);
					System.out.println("Please re-enter withdraw amount");
				} else if (amount < 0) { // checks if non-negative vlaue used
					System.out.println("You can NOT enter a negative value");
					System.out.println("Please re-enter withdraw amount");
				} else {
					validInput = true;
				}
			}
			validInput = false;
			return (accountBalance - amount);
		}
	}

	public int deposit() {
		if (!this.accountHolder) {
			System.out.println("You do not have an account at this time");
			return 0;
		} else {
			System.out.println("Please enter amount you wish to deposit");
			while (!validInput) {
				amount = sc.nextInt();
				if (amount < 0) { // checks if non-negative value used
					System.out.println("You can NOT enter a negative value");
					System.out.println("Please re-enter deposit amount");
				}
			}
			validInput = false;
			return (accountBalance + amount);
		}
	}

	public void transfer() {
		if (!this.accountHolder) {
			System.out.println("You do not have an account at this time");
		} else {
			System.out.println("Please enter account you want to transfer from");
			System.out.println(accounts);
			String accountOn = null;
			while (!validInput) {
				boolean accountExists = false;
				accountCur = sc.nextLine();

				// check if account exists in the list
				for (Entry<String, Integer> en : accounts.entrySet()) { // iterate through all members
					// in
					// accounts map // check if accountKey is in map
					if (accountCur == en.getKey()) {
						accountExists = true;
						accountOn = accountCur;
						break; // breaks out of for loop
					}
				}
				if (accountExists) {
					break;
				}
			}

			System.out.println("Please enter account you wish to transfer to");
			while (!validInput) {
				accountCur = sc.nextLine();

				// check if account exists in the list
				for (Entry<String, Integer> en : accounts.entrySet()) { // iterate through all members
					if (accountCur == en.getKey()) {
						accountExists = true;
						break;
					}
				}
				if (accountExists && (accountOn != accountCur)) { // makes sure not to transfer from same
					break;
				} else if (accountOn == accountCur) {
					System.out.println(
							"Invalid. Please choose a different account to transfer to. Has to be different than the one you are transferring from.");
				} else { // meaning account does not exist
					System.out.println("Invalid. Please choose an exisiting account to transfer to.");
				}

				System.out.println("Please enter amount you wish to transfer");
				while (!validInput) {
					amount = sc.nextInt();
					if ((amount > 0) && (amount < accounts.get(accountOn))) { // valid entry
						break;
					} else if (amount < accounts.get(accountOn)) {
						System.out.println("Invalid. Not sufficient funds in account");
					} else {
						System.out.println("Invalid. Value must be a positive integer greater than 0");
					}
				}
				accounts.put(accountCur, (amount + accounts.get(accountCur)));
				accounts.put(accountOn, (accounts.get(accountOn)) - amount);

			}
		}
	}
	/////////////////////////////////////////////////////////////////
	// employee

	void viewApp() {
		if (!this.accountHolder) {
			System.out.println("Current status is:");
			if (this.applicationStatus == 0) {
				System.out.println("Pending approval");
				setAccountStatus();
			}
			if (this.applicationStatus == 1) {
				System.out.println("This account is currently active");
			} else {
				System.out.println("This account was denied");
			}
		}
	}

	void setAccountStatus() {
		System.out.println("Current status is: " + applicationStatus); // currently only will be pending as empoyee
																		// can't go in to edit anythign else
		System.out.println("Do you wnat to approve the account?");
		System.out.println("Please enter 1: Yes or 2: No");
		while (!validInput) {
			yn = sc.nextInt();
			if ((yn == 1) || (yn == 2)) {
				break;
			} else {
				System.out.println("Invalid input. Please enter 1 or 2");
			}
		}
		if (yn == 1) {
			this.applicationStatus = 1; // approved
			this.accountHolder = true;
			System.out.println("The account is now approved");

		} else if (yn == 2) {
			applicationStatus = 2; // denied
			System.out.println("The account is now denied");

		}
	}

	void viewAccount(HashMap<Integer, Account> bankAccounts) {
		System.out.println("Please enter account username to view");
		while (!validInput) {
			accountCur = sc.nextLine();
			for (Entry<Integer, Account> en : bankAccounts.entrySet()) { // iterate through all members in
				if (accountCur.equals(en.getValue().getUsername()))
					accountExists = true;
				break;
			}
			// if account not an option
			if (!accountExists) {
				System.out.println("Please enter a valid account");
			} else {
				break;
			}
		}
		validInput = false;
		// show all attributes of account
		System.out.println("Username: " + this.getUsername());
		System.out.println("Password: " + this.getPassword());
		System.out.println("Name: " + this.getfName() + " " + this.getlName());
		System.out.println("Birth date: " + this.getBirthM() + "/" + this.getBirthD() + "/" + this.getBirthY());
		System.out.println("List of accounts and their amount" + accounts);

	}

	// system admin
	void setAccountStatusAd() {
		if (userType == 3) {// if a systemadmin
			if (!accountHolder) { // account status still pending or was denied/cancelled
				if (applicationStatus == 2) {
					System.out.println("Application was previously denied or cancelled");
					System.out.println("Do you want to re-approve the account?");
				} else {
					System.out.println("Do you want to approve the account?");
				}

				System.out.println("Please enter 1: Yes or 2: No");
				while (!validInput) {
					yn = sc.nextInt();
					if ((yn == 1) || (yn == 2)) {
						break;
					} else {
						System.out.println("Invalid input. Please enter 1 or 2");
					}
				}
				if (yn == 1) {
					applicationStatus = 1;
				} else if (yn == 2) {
					applicationStatus = 2; // denied
				}
			} else if (accountHolder) { // disable approved account
				System.out.println("The current status is: " + applicationStatus);
				System.out.println("Do you want the account to cancel the account?");
				System.out.println("Please enter 1: Yes or 2: No");
				while (!validInput) {
					yn = sc.nextInt();
					if ((yn == 1) || (yn == 2)) {
						break;
					} else {
						System.out.println("Invalid input. Please enter 1 or 2");
					}
				}
				if (yn == 1) {
					applicationStatus = 2; // cancelled account
					accountHolder = false;
				} else if (yn == 2) {
					applicationStatus = 1; // decided to keep account active
					accountHolder = true;
				}
			} else { // not an account holder and application status was denied/cancelled
				System.out.println("Error occurred. AccountHolder cna only be true or false");
			}
		} else {
			System.out.println("Error. You do not have access to diable accounts");
		}
	}

	@Override
	public String toString() {
		return "Account [username=" + username + ", password=" + password + ", accountAccessType=" + userType + "]";
	}

}
