package com.example.partone;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import org.omg.CORBA.DynAnyPackage.Invalid;

public class Account {

	HashMap<String, String> userPass = new HashMap<String, String>();
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
	private int joint = 0; // will fill in with populated key
	public boolean validInput = false;
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

	public int getJoint() {
		return joint;
	}

	public void setJoint(int joint) {
		this.joint = joint;
	}

	////////////////////////////////////////////////////////
	//// creating an actual account /////////////////////////
	///////////////////////////////////////////////////////
	public Account(HashMap<Integer, Account> bankAccounts, int accountKey, int temp) {
		createJAccount(bankAccounts, accountKey, temp);
		System.out.println("done constructing joint account");
	}

	public Account(HashMap<Integer, Account> bankAccounts, int choice) {
		createAccount(bankAccounts, choice);
		System.out.println("done constructing");
	}

	public void createAccount(HashMap<Integer, Account> bankAccounts, int choice) {
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
		userPass.put(this.getUsername(), this.getPassword());
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

	public void createJAccount(HashMap<Integer, Account> bankAccounts, int accountKey, int temp) {
		userPass.put(bankAccounts.get(accountKey).getUsername(), bankAccounts.get(accountKey).getPassword());
		userPass.put(bankAccounts.get(temp).getUsername(), bankAccounts.get(temp).getPassword());
		accounts.put("Shared checking", (float) 0);
	}

	// client account

	protected boolean accountHolder; // check to see status of account
	protected float accountBalance = 0;
	private int applicationStatus; // 0: applied, 1: approved, 2: denied

	public int getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(int applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public String accountCur; // checking, savings, whatever they call it
	public float amount;

	Map<String, Float> accounts = new HashMap<String, Float>();

	public void createAccounts() { // note difference between account(user) and accounts (types of accounts a user
									// has)
		if (userType == 2) {
			System.out.println("Error. You are an Employee you do not have access to creating accounts");
		} else {
			System.out.println(
					"Enter the name of the account you want to create. Ex: Checkin, Savings, Leo's Checking, etc.");
			while (!validInput) {
				accountCur = sc.nextLine();
				accountExists = false;
				System.out.println("entered into create accounts going to wiat for user iput");
				for (Entry<String, Float> en : accounts.entrySet()) { // iterate through all members
					// in
					// accounts map // check if accountKey is in map
					if (accountCur.equals(en.getKey())) {
						System.out.println("Invalid. Accounts name already exists");
						accountExists = true;
						break;
					}
				}
				if (!accountExists) {
					break;
				}
			}
			accounts.put(accountCur, (float) 0);
		}
	}

	public void accessAccounts(HashMap<Integer, Account> bankAccounts) {
		/*
		 * if (!this.accountHolder) {
		 * System.out.println("You do not have an account at this time"); } else {
		 */
		sc.nextLine(); // putting because would read past the account cur
		int choice = 0;
		System.out.println("Would you like to 1: Deposit 2: Withdraw 3: Transfer");
		while (!validInput) {
			choice = sc.nextInt();
			if ((choice == 1) || (choice == 2) || (choice == 3)) {
				break;
			} else {
				System.out.println("Invalid. Please enter 1, 2, or 3");
			}
		}
		sc.nextLine();
		if (joint > 0) {
			System.out.println("Do you want to access your 1: Joint or 2: Single account");
			while (!validInput) {
				yn = sc.nextInt();
				if ((yn == 1) || (yn == 2)) {
					break;
				} else {
					System.out.println("Invalid input. Please enter 1 or 2");
				}
			}
		}
		if (yn == 1) {
			System.out.println("Which account do you want to look at");
			System.out.println(bankAccounts.get(joint).accounts);
			if (choice == 3) {
				System.out.println("Do you want to create a new account");
				checkYN();
				if (yn == 1) {
					sc.nextLine();
					createAccounts();
					transfer();
				}
			} else {
				while (!validInput) {
					accountExists = false;
					accountCur = sc.nextLine();
					for (Entry<String, Float> en : accounts.entrySet()) { // iterate through all members
						// in
						// accounts map // check if accountKey is in map
						if (accountCur.equals(en.getKey())) {
							System.out.println("account exists");
							accountExists = true;
							break;
						}
					}
					if (accountExists) {
						break;
					} else {
						System.out.println("Invalid. Class Account does not exist. YOur accounts are: ");
						System.out.println(accounts);
					}
				}
				if (choice == 1) {
					accounts.put(accountCur, deposit());
				} else if (choice == 2) {
					accounts.put(accountCur, withdraw());
				}
			}

		} else {
			if (accounts.isEmpty()) {
				System.out.println("You need to name your first account");
				createAccounts();
			}

			System.out.println("Which account do you want to look at");
			System.out.println(accounts);
			if (choice == 3) {
				System.out.println("Do you want to create a new account");
				checkYN();
				if (yn == 1) {
					sc.nextLine();
					createAccounts();
					transfer();
				}
			} else {

				while (!validInput) {
					accountExists = false;
					accountCur = sc.nextLine();
					for (Entry<String, Float> en : accounts.entrySet()) { // iterate through all members
						// in
						// accounts map // check if accountKey is in map
						if (accountCur.equals(en.getKey())) {
							System.out.println("account exists");
							accountExists = true;
							break;
						}
					}
					if (accountExists) {
						break;
					} else {
						System.out.println("Invalid. Class Account does not exist. YOur accounts are: ");
						System.out.println(accounts);
					}
				}
				if (choice == 1) {
					accounts.put(accountCur, deposit());
				} else if (choice == 2) {
					accounts.put(accountCur, withdraw());
				}
			}
		}
		// }

	}

	public int apply(HashMap<Integer, Account> bankAccounts, int accountKeyPassed) {
		System.out.println("What type of account would you like to create? 1: Single or  2: Joint");
		while (!validInput) {
			accountType = sc.nextInt();
			System.out.println(accountType);
			if ((accountType == 1) || (accountType == 2)) {
				break;
			} else {
				System.out.println("Invalid input. Please enter either 1 or 2");

			}
		}

		if (accountType == 2) {
			System.out.println("You chose to make a joint account.");
			System.out.println("If you are joining an account please enter the account key below");
			while (!validInput) {
				boolean keyFound = false;
				joint = sc.nextInt();
				for (Entry<Integer, Account> en : bankAccounts.entrySet()) { // iterate through all members in
																				// accounts map
					if (joint == en.getKey()) { // check if accountKey is in map
						System.out.println("entered a joint acount key");
						keyFound = true;
						break;
					} else { // accountKey does not match
						System.out.println("accountKey does nto match a current open account");
					}
				}
				if (keyFound) {
					break;
				}
			}
			System.out.println("Accountkey being passed to joint " + joint);
			bankAccounts.get(joint).setJoint(accountKeyPassed);
		}
		System.out.println(
				"Fantastic, your account is pending employee approval. Log in after employee approval has been confirmed");
		return joint;
	}

	public void viewInformation() {
		System.out.println("Name: " + getfName() + " " + getlName());
		System.out.println("Account Staus: " + applicationStatus);
		System.out.println("Open accounts: " + accounts);
		System.out.println("Joint status: " + joint);

	}

	public float withdraw() {
		System.out.println("Please enter amount you wish to withdraw:");
		while (!validInput) {
			amount = sc.nextInt();
			if (amount > accountBalance) { // checks if enough in account
				System.out.println("Invalid! Your acocunt only has: " + accountBalance);
				System.out.println("Please re-enter withdraw amount");
			} else if (amount < 0) { // checks if non-negative value used
				System.out.println("You can NOT enter a negative value");
				System.out.println("Please re-enter withdraw amount");
			} else {
				break;
			}
		}
		System.out.println("Your new account balance is: " + (accountBalance - amount));
		accountBalance -= amount;
		return (accountBalance);

	}

	public float deposit() {
		System.out.println("Please enter amount you wish to deposit");
		while (!validInput) {
			amount = sc.nextInt();
			if (amount < 0) { // checks if non-negative value used
				System.out.println("You can NOT enter a negative value");
				System.out.println("Please re-enter deposit amount");
			} else { // positive value was entered
				break;
			}
		}

		System.out.println("Your new account balance is: " + (accountBalance + amount));
		accountBalance += amount;
		return (accountBalance);
	}

	public void transfer() {
		System.out.println("Please enter account you want to transfer from");
		System.out.println(accounts);
		String accountOn = null;
		while (!validInput) {
			accountExists = false;
			accountCur = sc.nextLine();

			// check if account exists in the list
			for (Entry<String, Float> en : accounts.entrySet()) { // iterate through all members
				// in
				// accounts map // check if accountKey is in map
				if (accountCur.equals(en.getKey())) {
					accountExists = true;
					accountOn = accountCur;
					System.out.println("account found to exist");
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
			for (Entry<String, Float> en : accounts.entrySet()) { // iterate through all members
				if (accountCur.equals(en.getKey())) {
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
		}

		System.out.println("Please enter amount you wish to transfer");
		while (!validInput) {
			amount = sc.nextInt();
			if ((amount > 0) && (amount < accounts.get(accountOn))) { // valid entry
				break;
			} else {
				System.out.println("Invalid. Amount must be between 0 and " + accounts.get(accountOn));
			}
		}
		accounts.put(accountCur, (amount + accounts.get(accountCur)));
		accounts.put(accountOn, (accounts.get(accountOn)) - amount);
		System.out.println(accounts);
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
		checkYN();
		if (yn == 1) {
			applicationStatus = 1; // approved
			accountHolder = true;
			System.out.println("The account is now approved");

		} else if (yn == 2) {
			applicationStatus = 2; // denied
			System.out.println("The account is now denied");

		}
	}

	void viewAccount() {
		// show all attributes of account
		System.out.println("Username: " + getUsername());
		System.out.println("Password: " + getPassword());
		System.out.println("Name: " + getfName() + " " + getlName());
		System.out.println("Birth date: " + getBirthM() + "/" + getBirthD() + "/" + getBirthY());
		System.out.println("List of accounts and their amount" + accounts);
	}

	// system admin
	void setAccountStatusAd() {
		switch (applicationStatus) {
		case 0: // account is pending
			setAccountStatus();
			break;
		case 1: // account was approved
			System.out.println("Application is currently active");
			System.out.println("Do you want to cancel the account?");
			checkYN();
			if (yn == 1) {
				this.applicationStatus = 2; // approved
				this.accountHolder = false;
				System.out.println("The account is now cancelled");
			} else if (yn == 2) {
				applicationStatus = 1; // denied
				this.accountHolder = true;
				System.out.println("The account is still approved");
			}
			break;
		case 3: // account was denied
			System.out.println("Application was previously denied or cancelled");
			System.out.println("Do you want to re-approve the account?");
			checkYN();
			if (yn == 1) {
				this.applicationStatus = 1; // approved
				this.accountHolder = true;
				System.out.println("The account is now approved");

			} else if (yn == 2) {
				applicationStatus = 2; // denied
				this.accountHolder = false;
				System.out.println("The account is now denied");
			}
			break;
		default:
			System.out.println("Error occurred - applicationStaus should be 0, 1, or 2 only");
			break;
		}
	}

	@Override
	public String toString() {
		String info = null;
		if (joint > 0) {

			info = "Account [username=" + username + ", password=" + password + ", accountAccessType=" + userType
					+ ", Joint Account= " + joint + "]";
		} else {
			info = "Account [username=" + username + ", password=" + password + ", accountAccessType=" + userType
					+ ", Single Account]";
		}
		return info;
	}

	private void checkYN() {
		System.out.println("Please enter 1: Yes or 2: No");
		while (!validInput) {
			yn = sc.nextInt();
			if ((yn == 1) || (yn == 2)) {
				break;
			} else {
				System.out.println("Invalid input. Please enter 1 or 2");
			}
		}

	}

}
