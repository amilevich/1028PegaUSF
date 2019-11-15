package com.example.partone;

import java.io.Serializable;
//work on going in and making sure bankAccounts.get(joint) is getting the right joint
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

public class Account implements Client, Employee, SystemAdmin {
	
	/**
	 * @author Sadie Larson
	 */
	final static Logger loggy = Logger.getLogger(Account.class);
	private int hashKey;
	HashMap<String, String> userPass = new HashMap<String, String>();
	private String username;
	private String password;
	private String fName;
	private String lName;
	private int birthD;
	private int birthY;
	private int birthM;
	protected static String accountType; // 1: Single, 2: Joint
	private int userType; // client = 1, employee = 2, system admin = 3
	public static int accountKey; // accounts hashkey
	protected boolean accountExists = false;
	private int joint = 0; // will fill in with populated HashKey if joint

	// ******************************************************//
	// ******** used for user input checking *******************//
	// ******************************************************//
	public static boolean exceptionCaught = false;
	public static String choice = null;
	static Scanner sc = new Scanner(System.in);
	public String yn; // use as yes or no option in scanner
	public String names; // used to get first and last name
	public int date; // used to get birthdate

	// ******************************************************//
	// ******** public getter and setters *******************//
	// ******************************************************//
	public int getHashKey() {
		return hashKey;
	}

	public void setHashKey(int hashKey) {
		this.hashKey = hashKey;
	}

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
		userPass.put(username, password);
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
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

	@Override
	public String toString() {
		String info = null;
		if (userType == 1) {
			if (joint > 0) {
				info = "Account [Username=Password: " + userPass + ", accountAccessType: client" + ", Account: "
						+ accounts + ", Joint Key: " +joint + "]";
			} else { // not a joint account
				info = "Account [Username=Password: " + userPass  +", accountAccessType: client"
						+ ", Account: " + accounts + "]";
			}
		} else if (userType == 2) { // employee
			info = "Account [ Username=Password: " + userPass + ", accountAccessType: Employee" + "]";
		} else { // sys ad
			info = "Account [ Username=Password: " + userPass + ", accountAccessType: System Admin" + "]";
		}
		return info;
	}

	// ******************************************************//
	// ******* creating an actual account *******************//
	// ******************************************************//
	public Account() {
		// needed for adding from file
	}

	public Account(HashMap<Integer, Account> bankAccounts, int accountKey, int temp) {
		createJAccount(bankAccounts, accountKey, temp);
		// System.out.println("done constructing joint account");
	}

	public Account(HashMap<Integer, Account> bankAccounts, String choice) {

		createAccount(bankAccounts, choice);
		// System.out.println("done constructing");
	}

	public void createAccount(HashMap<Integer, Account> bankAccounts, String choice) {
		switch (choice) {
		case "1":
			userType = 1;
			break;
		case "2":
			userType = 2;
			break;
		case "3":
			userType = 3;
			break;
		}
		System.out.println("Please enter a username below");
		while (true) {
			username = sc.nextLine();
			username.toLowerCase();
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

		// ************ setting up a password *******************//
		System.out.println("Please enter a password below");
		while (true) {
			password = sc.nextLine();
			password.toLowerCase();
			if (password.length() < 1) { // change to verify password meets specs
				System.out.println("Invalid. errors occurred in creating a password");
			} else {
				break;
			}
		}

		setUsername(username);
		setPassword(password);
		// userPass.put(this.getUsername(), this.getPassword());

		// ******Setting up account information *******************//

		/*
		 * System.out.println("Please enter your first name below"); while (true) {
		 * names = sc.nextLine(); if (names.equals(" ")) {
		 * System.out.println("Please enter at least one character"); } else { break; }
		 * } setfName(names);
		 * 
		 * System.out.println("Please enter your last name below"); while (true) { names
		 * = sc.nextLine(); if (names.equals(" ")) {
		 * System.out.println("Please enter at least one character"); } else { break; }
		 * } setlName(names);
		 * 
		 * System.out.println("Please enter your birth month"); while (true) { date =
		 * sc.nextInt(); if ((date < 1) || date > 12) {
		 * System.out.println("Months fall between 1-12"); } else { break; } }
		 * setBirthM(date);
		 * 
		 * System.out.println("Please enter your birth day"); while (true) { date =
		 * sc.nextInt(); if ((date < 1) || date > 31) {
		 * System.out.println("Dates fall between 1-31"); } else { break; } }
		 * setBirthD(date);
		 * 
		 * System.out.println("Please enter your birth year"); while (true) { date =
		 * sc.nextInt(); if ((date < 1923) || date > 2001) {
		 * System.out.println("Years fall between 1923-2001"); } else { break; }
		 * 
		 * } setBirthY(date);
		 */
		// System.out.println("Awesome, your account is in pending. Log in after
		// employee approval has been confirmed");
	}

	private void createJAccount(HashMap<Integer, Account> bankAccounts, int accountKey, int temp) {
		userPass.put(bankAccounts.get(accountKey).getUsername(), bankAccounts.get(accountKey).getPassword());
		userPass.put(bankAccounts.get(temp).getUsername(), bankAccounts.get(temp).getPassword());
		accounts.put("shared checking", 0.0);
		userType = 1; // client
	}

	// ******************************************************//
	// ******* client account information *******************//
	// ******************************************************//

	protected boolean accountHolder; // check to see status of account
	protected double accountBalance = 0.0;
	private int applicationStatus; // 0: applied, 1: approved, 2: denied

	public int getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(int applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public String accountCur; // checking, savings, whatever they call it
	public double amount;

	Map<String, Double> accounts = new HashMap<String, Double>();

	@Override
	public void createAccounts(Map<String, Double> accounts2) { // note difference between account(user) and accounts
																// (types of accounts a user has
		if (userType == 2) {
			System.out.println("Error. You are an Employee you do not have access to creating accounts");
		} else {
			System.out.println(
					"Enter the name of the account you want to create. Ex: Checkin, Savings, Leo's Checking, etc.");
			while (true) {
				accountCur = sc.nextLine();
				accountExists = false;
				System.out.println("entered into create accounts going to wiat for user iput");
				for (Entry<String, Double> en : accounts2.entrySet()) { // iterate through all members
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
			accounts2.put(accountCur, 0.0);
		}
	}

	@Override
	public void accessAccounts(HashMap<Integer, Account> bankAccounts, int accountKeyAccess) {
		// ***************Sys ad **************//
		if (userType == 3) {
			if (bankAccounts.get(accountKeyAccess).getJoint() > 0) {
				System.out.println("Do you want to access their 1: Joint or 2: Single account");
				while (true) {
					yn = sc.nextLine();
					if ((yn.equals("1")) || (yn.equals("2"))) {
						break;
					} else {
						System.out.println("Invalid input. Please enter 1 or 2");
					}
				}
				// debugging line
				// below******************************************************************************
				System.out.println("Joint value is" + bankAccounts.get(accountKeyAccess).getJoint());
				if (yn.equals("1")) { // Joint account viewing
					bankAccounts.get(accountKeyAccess).accessJoint(bankAccounts);
				} else { // accessing single account
					System.out.println("sys ad chose 2");
					bankAccounts.get(accountKeyAccess).accessSingleAccount();
				}
			}
		}

		// ***************Client **************//
		else {
			if (joint > 0) {
				System.out.println("Do you want to access your 1: Joint or 2: Single account");
				while (true) {
					yn = sc.nextLine();
					if ((yn.equals("1")) || (yn.equals("2"))) {
						break;
					} else {
						System.out.println("Invalid input. Please enter 1 or 2");
					}
				}
				if (yn.equals("1")) { // Joint account viewing
					accessJoint(bankAccounts);
				} else {
					accessSingleAccount();
				}
			}

			else { // accessing single account
				accessSingleAccount();
			}
		}
	}

	private int checkAccount;

	@Override
	public void accessSingleAccount() {
		// ************************* Commented out to serialize Account object without
		// the hashmap
		if (accounts.isEmpty()) {
			System.out.println("Single Account Holder currently. You need to name the first account");
			createAccounts(accounts);
		}
		System.out.println("Which account do you want to look at");
		System.out.println(accounts);
		while (true) {
			accountExists = false;
			accountCur = sc.nextLine();
			accountCur.toLowerCase();
			for (Entry<String, Double> en : accounts.entrySet()) { //
				// check if accountKey is in map
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

		checkClientAction();
		checkAccount = Integer.valueOf(yn);
		if (checkAccount == 2) {
			checkAccount = 3;
		}
		if (choice.equals("1")) {
			accounts.put(accountCur, deposit());
		} else if (choice.equals("2")) {
			accounts.put(accountCur, withdraw());
		}
		if (choice.equals("3")) {
			transfer(accounts);

		}
	}

	@Override
	public void accessJoint(HashMap<Integer, Account> bankAccounts) {
		System.out.println("Which account do you want to look at");
		System.out.println("If you want to make a new account please enter 'Create'");
		System.out.println(bankAccounts.get(joint).accounts);
		while (true) {
			accountExists = false;
			accountCur = sc.nextLine();
			accountCur.toLowerCase();
			if (accountCur.equals("create")) {
				createAccounts(bankAccounts.get(joint).accounts);
				System.out.println(bankAccounts.get(joint).accounts);
			}
			for (Entry<String, Double> en : bankAccounts.get(joint).accounts.entrySet()) {
				// check if accountKey is in map
				if (accountCur.equals(en.getKey())) {
					System.out.println("account exists");
					accountExists = true;
					break;
				}
			}
			if (accountExists) {
				break;
			} else {
				System.out.println("Invalid. Class Account does not exist. Your accounts are: ");
				System.out.println(bankAccounts.get(joint).accounts);
			}
		}
		checkClientAction();
		if (choice.equals("1")) {
			(bankAccounts.get(joint).accounts).put(accountCur, bankAccounts.get(joint).deposit());
		} else if (choice.equals("2")) {
			(bankAccounts.get(joint).accounts).put(accountCur, bankAccounts.get(joint).withdraw());
		}
		if (choice.equals("3")) {
			bankAccounts.get(joint).transfer(accounts);
		}
	}

	@Override
	public int apply(HashMap<Integer, Account> bankAccounts, int accountKeyPassed) {
		System.out.println("What type of account would you like to create? 1: Single or  2: Joint");
		while (true) {
			accountType = sc.nextLine();
			System.out.println(accountType);
			if ((accountType.equals("1")) || (accountType.equals("2"))) {
				break;
			} else {
				System.out.println("Invalid input. Please enter either 1 or 2");
			}
		}

		if (accountType.equals("2")) {
			if (bankAccounts.size() < 2) {
				System.out.println("There are no other accounts to choose from"); // informs user they are the only
																					// account in database
			} else {
				System.out.println("You chose to make a joint account.");
				System.out.println("If you are joining an account please enter the account key below");
				String temp = null;
				while (true) {
					boolean keyFound = false;
					boolean notClient = false;
					temp = sc.nextLine();
					temp.toLowerCase();
					if (temp.equals("exit")) {
						break;
					}
					for (Entry<Integer, Account> en : bankAccounts.entrySet()) {
						if (temp.equals(String.valueOf(en.getKey()))) {
							if (en.getValue().getUserType() == 1) { // check if accountKey is in map and a client
								System.out.println("entered a joint acount key");
								keyFound = true;
								break;
							} else if (en.getValue().getUserType() != 1) {
								notClient = true;
							}
						}
					}
					if (keyFound) {
						break;
					} else if (notClient) {
						System.out.println("The account key is not of a client. Please re-enter");
					} else { // accountKey does not match
						System.out.println("accountKey does not match a current open account");
					}
				}
				if (!(temp.equals("exit"))) {
					joint = Integer.parseInt(temp);
					System.out.println("Accountkey being passed to joint " + joint);
					bankAccounts.get(joint).setJoint(accountKeyPassed);
				}
//				loggy.info(username + " made a joint account with " + bankAccounts.get(temp).getUsername());
				
			}
			System.out.println(
					"Fantastic, your account is pending employee approval. Log in after employee approval has been confirmed");
			return joint;
		}
		return joint;
	}

	@Override
	public void viewInformation() {
		System.out.println("Name: " + getfName() + " " + getlName());
		System.out.println("Account Staus: " + applicationStatus);
		System.out.println("Open accounts: " + accounts);
		System.out.println("Joint status: " + joint);
	}

	@Override
	public double deposit() {
		System.out.println("Please enter amount you wish to deposit");
		exceptionCaught = true;
		while (true && exceptionCaught) {
			exceptionCaught = false;
			String amountTemp = sc.nextLine();
			try {
				amount = Double.valueOf(amountTemp);
			} catch (Exception e) {
				System.out.println("Invalid. Input must be an number");
				exceptionCaught = true;
				continue;
			}
			if (amount < 0) { // checks if non-negative value used
				System.out.println("You can NOT enter a negative value");
				System.out.println("Please re-enter deposit amount");
				exceptionCaught = true;
			} else { // positive value was entered
				break;
			}

		}
		loggy.info(username + " made a deposit of" + amount);
		
		System.out.println("Your new account balance is: " + (accountBalance + amount));
		accountBalance += amount;
		return (accountBalance);

	}

	@Override
	public double withdraw() {

		if (accountBalance > 0) {
			System.out.println("Please enter amount you wish to withdraw:");
			exceptionCaught = true;

			while (true && exceptionCaught) {
				exceptionCaught = false;
				String amountTemp = sc.nextLine();
				try {
					amount = Double.valueOf(amountTemp);
				} catch (Exception e) {
					System.out.println("Invalid. Input must be an number");
					exceptionCaught = true;
					continue;
				}
				if (amount > accountBalance) { // checks if enough in account
					System.out.println("Invalid! Your acocunt only has: " + accountBalance);
					System.out.println("Please re-enter withdraw amount");
					exceptionCaught = true;
				} else if (amount < 0) { // checks if non-negative value used
					System.out.println("You can NOT enter a negative value");
					System.out.println("Please re-enter withdraw amount");
					exceptionCaught = true;
				} else {
					break;
				}
			}
			loggy.info(username + " made a withdraw of" + amount);
			
			System.out.println("Your new account balance is: " + (accountBalance - amount));
			accountBalance -= amount;
			return (accountBalance);
		} else {
			System.out.println("You only have $0 in your account");
		}
		return (accountBalance);

	}

	@Override
	public void transfer(Map<String, Double> accounts2) {
		if (accounts2.size() < 2) {
			createAccounts(accounts2);
		}
		System.out.println("Please enter account you want to transfer from");
		System.out.println(accounts2);
		String accountOn = "";
		while (true) {
			accountExists = false;
			accountCur = sc.nextLine();
			accountCur.toLowerCase();
			// check if account exists in the list
			for (Entry<String, Double> en : accounts2.entrySet()) { // iterate through all members
				// in
				// accounts map // check if accountKey is in map
				if (accountCur.equals(en.getKey())) {
					accountExists = true;
					accountOn = accountCur;
					System.out.println("account found to exist");
					break; // breaks out of for loop
				}
			}
			if (accountExists && accounts.get(accountCur) <= 0) {
				System.out.println("Your acocunt has 0 funds in it");
				accountExists = false;
			}
			if (accountExists) {
				break;
			} else {
				System.out.println("Invalid. Please choose an exisiting account to transfer from.");
				System.out.println(accounts);
			}
		}

		System.out.println("Please enter account you wish to transfer to");
		while (true) {
			accountCur = sc.nextLine();
			accountCur.toLowerCase();
			// check if account exists in the list
			for (Entry<String, Double> en : accounts2.entrySet()) { // iterate through all members
				if (accountCur.equals(en.getKey())) {
					accountExists = true;
					break;
				}
			}
			if (accountExists && (!accountOn.equals(accountCur))) { // makes sure not to transfer from same
				break;
			} else if (accountOn.equals(accountCur)) {
				System.out.println(
						"Invalid. Please choose a different account to transfer to. Has to be different than the one you are transferring from.");
			} else { // meaning account does not exist
				System.out.println("Invalid. Please choose an exisiting account to transfer to.");
			}
		}

		System.out.println("Please enter amount you wish to transfer");
		exceptionCaught = true;
		while (true && exceptionCaught) {
			exceptionCaught = false;
			String amountTemp = sc.nextLine();
			try {
				amount = Double.valueOf(amountTemp);	
			} catch (Exception e) {
				System.out.println("Invalid. Amount must be an integer value.");
				exceptionCaught = true;
				continue;
			}
			if (amount > accounts.get(accountOn)) { // checks if enough in account
				System.out.println("Invalid! Your acocunt only has: " + accounts.get(accountOn));
				System.out.println("Please re-enter withdraw amount");
				exceptionCaught = true;
			} else if (amount < 0) { // checks if non-negative value used
				System.out.println("You can NOT enter a negative value");
				System.out.println("Please re-enter withdraw amount");
				exceptionCaught = true;
			} else {
				break;
			}
		}
		loggy.info(username + " made a transfer of" + amount + "from their " + accountOn + " account to their " + accountCur + " account.");
		accounts.put(accountCur, (amount + accounts2.get(accountCur)));
		accounts.put(accountOn, (accounts2.get(accountOn)) - amount);
		System.out.println(accounts);

	}

	// ******************************************************//
	// ******************Employee Account *******************//
	// ******************************************************//
	@Override
	public void viewApp() {
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

	@Override
	public void setAccountStatus() {
		System.out.println("Current status is: " + applicationStatus); // currently only will be pending as empoyee
																		// can't go in to edit anythign else
		if (applicationStatus == 0) {
			System.out.println("Do you wnat to approve the account?");
			checkYN();
			if (yn.equals("1")) {
				applicationStatus = 1; // approved
				accountHolder = true;
				System.out.println("The account is now approved");

			} else if (yn.equals("2")) {
				applicationStatus = 2; // denied
				System.out.println("The account is now denied");

			}
		}
	}

	@Override
	public void viewAccount() {
		// show all attributes of account
		System.out.println("Username: " + getUsername());
		System.out.println("Password: " + getPassword());
		System.out.println("Name: " + getfName() + " " + getlName());
		System.out.println("Birth date: " + getBirthM() + "/" + getBirthD() + "/" + getBirthY());
		// System.out.println("List of accounts and their amount" + accounts);
		System.out.println("Open accounts: " + accounts);
	}

	// ******************************************************//
	// **************System Admin Account *******************//
	// ******************************************************//
	@Override
	public void setAccountStatusAd() {
		switch (applicationStatus) {
		case 0: // account is pending
			setAccountStatus();
			break;
		case 1: // account was approved
			System.out.println("Application is currently active");
			System.out.println("Do you want to cancel the account?");
			checkYN();
			if (yn.equals("1")) {
				this.applicationStatus = 2; // approved
				this.accountHolder = false;
				System.out.println("The account is now cancelled");
			} else if (yn.equals("2")) {
				applicationStatus = 1; // denied
				this.accountHolder = true;
				System.out.println("The account is still approved");
			}
			break;
		case 2: // account was denied
			System.out.println("Application was previously denied or cancelled");
			System.out.println("Do you want to re-approve the account?");
			checkYN();
			if (yn.equals("1")) {
				this.applicationStatus = 1; // approved
				this.accountHolder = true;
				System.out.println("The account is now approved");

			} else if (yn.equals("2")) {
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

	// **************************************************//
	// ***********Functions in Account class************//
	// **************************************************//
	private void checkYN() {
		System.out.println("Please enter 1: Yes or 2: No");
		while (true) {
			yn = sc.nextLine();
			if ((yn.equals("1")) || (yn.equals("2"))) {
				break;
			} else {
				System.out.println("Invalid input. Please enter 1 or 2");
			}
		}
	}

	private void checkClientAction() {
		System.out.println("Would you like to 1: Deposit 2: Withdraw 3: Transfer");
		while (true) {
			choice = sc.nextLine();
			if ((choice.equals("1")) || (choice.equals("2")) || (choice.equals("3"))) {
				break;
			} else {
				System.out.println("Invalid. Please enter 1, 2, or 3");
			}
		}
	}

}