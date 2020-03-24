package com.example.partone;

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
	public HashMap<String, String> userPass = new HashMap<String, String>();
	private String username;
	private String password;
	private int trigger;
	// private String fName;
	// private String lName;
	// private int birthD;
	// private int birthY;
	// private int birthM;
	protected static String accountType; // 1: Single, 2: Joint
	private int userType = 1; // client = 1, employee = 2, system admin = 3
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

	// public String getlName() {
	// return lName;
	// }
	//
	// public void setlName(String lName) {
	// this.lName = lName;
	// }
	//
	// public String getfName() {
	// return fName;
	// }
	//
	// public void setfName(String fName) {
	// this.fName = fName;
	// }
	//
	// public int getBirthY() {
	// return birthY;
	// }
	//
	// public void setBirthY(int birthY) {
	// this.birthY = birthY;
	// }
	//
	// public int getBirthM() {
	// return birthM;
	// }
	//
	// public void setBirthM(int birthM) {
	// this.birthM = birthM;
	// }
	//
	// public int getBirthD() {
	// return birthD;
	// }
	//
	// public void setBirthD(int birthD) {
	// this.birthD = birthD;
	// }

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
						+ accounts + ", Joint Key: " + joint + ", Account Status: " + applicationStatus + "]";
			} else { // not a joint account
				info = "Account [Username=Password: " + userPass + ", accountAccessType: client" + ", Account: "
						+ accounts + ", Account Status: " + applicationStatus + "]";
			}
		} else if (userType == 2) { // employee
			info = "Account [Username=Password: " + userPass + ", accountAccessType: Employee" + "]";
		} else { // sys ad
			info = "Account [Username=Password: " + userPass + ", accountAccessType: System Admin" + "]";
		}
		return info;
	}

	// ******************************************************//
	// ******* creating an actual account *******************//
	// ******************************************************//

	public Account(HashMap<Integer, Account> bankAccounts, int accountKey, int temp) {
		createJAccount(bankAccounts, accountKey, temp);
		// System.out.println("\t\t\tdone constructing joint account");
	}

	public Account(HashMap<Integer, Account> bankAccounts, String choice) {

		createAccount(bankAccounts, choice);
		// System.out.println("\t\t\tdone constructing");
	}

	// ****************** SQL ********************//
	public Account(int trigger, int hashKey, int appStat, String usern, String userp, String usern2, String userp2,
			int userType, int joint, float checking, float savings) {
		this.setTrigger(trigger);
		this.accountKey = hashKey;
		this.hashKey = hashKey;
		this.applicationStatus = appStat;
		this.userPass.put(usern, userp);
		if (!usern2.equals("NULL")) {
			this.userPass.put(usern2, userp2);
			this.accounts.put("shared checking", checking);
			this.accounts.put("shared savings", savings);
		} else {
			this.accounts.put("checking", checking);
			this.accounts.put("savings", savings);
		}
		this.userType = userType;
		this.joint = joint;
	}

	// emplyee/sysad
	public Account(int trigger, int hashKey, int appStat, String usern, String userp, String usern2, String userp2,
			int userType, int joint) {
		this.setTrigger(trigger);
		this.accountKey = hashKey;
		this.applicationStatus = appStat;
		this.userPass.put(usern, userp);
		if (!usern2.equals("NULL")) {
			this.userPass.put(usern2, userp2);
		}
		this.userType = userType;
		this.joint = joint;
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
		System.out.println("\t\t\tPlease enter a username below");
		while (true) {
			username = sc.nextLine();
			username = username.toLowerCase();
			for (Entry<Integer, Account> en : bankAccounts.entrySet()) { // iterate through all members in
				for (Entry<String, String> i : en.getValue().userPass.entrySet()) {
					accountExists = username.equals(i.getKey());
				}
				if (accountExists) {
					break;
				}
			}
			if (accountExists) {
				System.out.println("\t\t\tInvalid. Username already exists.");
				System.out.println("\t\t\tPlease enter a username below");
			} else if (username.length() < 1) { // change to check that username is NOT taken
				System.out.println("\t\t\tInvalid. Username needs to have at least one character");
			} else {
				break;
			}
		}

		// ************ setting up a password *******************//
		System.out.println("\t\t\tPlease enter a password below. Case Sensitive");
		while (true) {
			password = sc.nextLine();
			if (password.length() < 1) { // change to verify password meets specs
				System.out.println("\t\t\tInvalid. errors occurred in creating a password");
			} else {
				break;
			}
		}

		setUsername(username);
		setPassword(password);
		accounts.put("checking", 0.00f);
		accounts.put("savings", 0.00f);
		// userPass.put(this.getUsername(), this.getPassword());

		// ******Setting up account information *******************//

		// System.out.println("\t\t\tPlease enter your first name below");
		// while (true) {
		// names = sc.nextLine();
		// if (names.equals(" ")) {
		// System.out.println("\t\t\tPlease enter at least one character");
		// } else {
		// break;
		// }
		// }
		// setfName(names);
		//
		// System.out.println("\t\t\tPlease enter your last name below");
		// while (true) {
		// names = sc.nextLine();
		// if (names.equals(" ")) {
		// System.out.println("\t\t\tPlease enter at least one character");
		// } else {
		// break;
		// }
		// }
		// setlName(names);
		//
		// System.out.println("\t\t\tPlease enter your birth month");
		// while (true) {
		// date = sc.nextInt();
		// if ((date < 1) || date > 12) {
		// System.out.println("\t\t\tMonths fall between 1-12");
		// } else {
		// break;
		// }
		// }
		// setBirthM(date);
		//
		// System.out.println("\t\t\tPlease enter your birth day");
		// while (true) {
		// date = sc.nextInt();
		// if ((date < 1) || date > 31) {
		// System.out.println("\t\t\tDates fall between 1-31");
		// } else {
		// break;
		// }
		// }
		// setBirthD(date);
		//
		// System.out.println("\t\t\tPlease enter your birth year");
		// while (true) {
		// date = sc.nextInt();
		// if ((date < 1923) || date > 2001) {
		// System.out.println("\t\t\tYears fall between 1923-2001");
		// } else {
		// break;
		// }
		//
		// }
		// setBirthY(date);

		// System.out.println("\t\t\tAwesome, your account is in pending. Log in after
		// employee approval has been confirmed");
	}

	private void createJAccount(HashMap<Integer, Account> bankAccounts, int accountKey, int temp) {
		String u1 = "";
		String p1 = "";
		String u2 = "";
		String p2 = "";

		for (Entry<String, String> en2 : bankAccounts.get(accountKey).userPass.entrySet()) {
			u1 += "" + en2.getKey();
			p1 += "" + en2.getValue();

		}
		for (Entry<String, String> en2 : bankAccounts.get(temp).userPass.entrySet()) {
			u2 += "" + en2.getKey();
			p2 += "" + en2.getValue();

		}
		this.userPass.put(u1, p1);
		this.userPass.put(u2, p2);
		this.accounts.put("shared checking", 0.00f);
		this.accounts.put("shared savings", 0.00f);
		this.userType = 1; // client

	}

	// ******************************************************//
	// ******* client account information *******************//
	// ******************************************************//

	protected boolean accountHolder; // check to see status of account
	// protected float accountBalance = 0.00;
	private int applicationStatus = 0; // 0: applied, 1: approved, 2: denied

	public int getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(int applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public String accountCur; // checking, savings, whatever they call it
	public float amount;

	public Map<String, Float> accounts = new HashMap<String, Float>();

	@Override
	public void createAccounts(Map<String, Float> accounts2) { // note difference between account(user) and accounts
																// (types of accounts a user has
		if (userType == 2) {
			System.out.println("\t\t\tError. You are an Employee you do not have access to creating accounts");
		} else {
			System.out.println(
					"Enter the name of the account you want to create. Ex: Checkin, Savings, Leo's Checking, etc.");
			while (true) {
				accountCur = sc.nextLine();
				accountExists = false;
				for (Entry<String, Float> en : accounts2.entrySet()) { // iterate through all members
					// in
					// accounts map // check if accountKey is in map
					if (accountCur.equals(en.getKey())) {
						System.out.println("\t\t\tInvalid. Accounts name already exists");
						accountExists = true;
						break;
					}
				}
				if (!accountExists) {
					break;
				}
			}
			accounts2.put(accountCur, 0.0f);
		}
	}

	@Override
	public void accessAccounts(HashMap<Integer, Account> bankAccounts, int accountKeyAccess) {
		// ***************Sys ad **************//
		if (userType == 3) {
			if (bankAccounts.get(accountKeyAccess).getJoint() > 0) {
				System.out.println("\t\t\tDo you want to access their 1: Joint or 2: Single account");
				while (true) {
					if ((yn.equals("1")) || (yn.equals("2"))) {
						break;
					} else {
						System.out.println("\t\t\tInvalid input. Please enter 1 or 2");
					}
				}
				System.out.println("\t\t\tJoint value is" + bankAccounts.get(accountKeyAccess).getJoint());
				if (yn.equals("1")) { // Joint account viewing
					bankAccounts.get(accountKeyAccess).accessJoint(bankAccounts, accountKeyAccess);
				} else { // accessing single account
					System.out.println("\t\t\tsys ad chose 2");
					bankAccounts.get(accountKeyAccess).accessSingleAccount(bankAccounts, accountKeyAccess);
				}
			}
		}

		// ***************Client **************//
		else {
			if (joint > 0) {
				System.out.println("\t\t\tDo you want to access your 1: Joint or 2: Single account");
				while (true) {
					yn = sc.nextLine();
					if ((yn.equals("1")) || (yn.equals("2"))) {
						break;
					} else {
						System.out.println("\t\t\tInvalid input. Please enter 1 or 2");
					}
				}
				if (yn.equals("1")) { // Joint account viewing
					accessJoint(bankAccounts, accountKeyAccess);
				} else {
					accessSingleAccount(bankAccounts, accountKeyAccess);
				}
			}

			else { // accessing single account
				accessSingleAccount(bankAccounts, accountKeyAccess);
			}
		}
	}

	private int checkAccount;

	@Override
	public void accessSingleAccount(HashMap<Integer, Account> bankAccounts, int hashKey) {
		// the hashmap
		if (accounts.isEmpty()) {
			System.out.println("\t\t\tSingle Account Holder currently. You need to name the first account");
			createAccounts(accounts);
		}
		System.out.println("\t\t\tWhich account do you want to look at");
		System.out.println(accounts);
		while (true) {
			accountExists = false;
			accountCur = sc.nextLine();
			accountCur = accountCur.toLowerCase();
			for (Entry<String, Float> en : accounts.entrySet()) { //
				// check if accountKey is in map
				if (accountCur.equals(en.getKey())) {
					System.out.println("\t\t\taccount exists");
					accountExists = true;
					break;
				}
			}
			if (accountExists) {
				break;
			} else {
				System.out.println("\t\t\tInvalid. Class Account does not exist. Your accounts are: ");
				System.out.println(accounts);
			}
		}

		checkClientAction();
		checkAccount = Integer.valueOf(choice);
		if (checkAccount == 2) {
			checkAccount = 3;
		}
		if (choice.equals("1")) {
			accounts.put(accountCur, deposit(accountCur));

		} else if (choice.equals("2")) {
			accounts.put(accountCur, withdraw(accountCur));
		}
		if (choice.equals("3")) {
			// System.out.println(hashKey);
			// System.out.println(joint);
			transfer(hashKey, joint, bankAccounts);
		}
	}

	@Override
	public void accessJoint(HashMap<Integer, Account> bankAccounts, int HashKey) {
		System.out.println("\t\t\tWhich account do you want to look at");
		System.out.println("\t\t\tIf you want to make a new account please enter 'Create'");
		System.out.println(bankAccounts.get(joint).accounts);
		while (true) {
			accountExists = false;
			accountCur = sc.nextLine();
			accountCur = accountCur.toLowerCase();
			if (accountCur.equals("create")) {
				createAccounts(bankAccounts.get(joint).accounts);
				System.out.println(bankAccounts.get(joint).accounts);
			}
			for (Entry<String, Float> en : bankAccounts.get(joint).accounts.entrySet()) {
				// check if accountKey is in map
				if (accountCur.equals(en.getKey())) {
					System.out.println("\t\t\taccount exists");
					accountExists = true;
					break;
				}
			}
			if (accountExists) {
				break;
			} else {
				System.out.println("\t\t\tInvalid. Class Account does not exist. Your accounts are: ");
				System.out.println(bankAccounts.get(joint).accounts);
			}
		}
		checkClientAction();
		if (choice.equals("1")) {
			(bankAccounts.get(joint).accounts).put(accountCur, bankAccounts.get(joint).deposit(accountCur));
			Menu.b.updateBankAccounts(bankAccounts.get(joint));
		} else if (choice.equals("2")) {
			(bankAccounts.get(joint).accounts).put(accountCur, bankAccounts.get(joint).withdraw(accountCur));
			Menu.b.updateBankAccounts(bankAccounts.get(joint));
		}
		if (choice.equals("3")) {
			bankAccounts.get(joint).transfer(joint, hashKey, bankAccounts);
			Menu.b.updateBankAccounts(bankAccounts.get(joint));
		}
	}

	@Override
	public int apply(HashMap<Integer, Account> bankAccounts, int accountKeyPassed) {
		System.out.println("\t\t\tWhat type of account would you like to create? 1: Single or  2: Joint");
		while (true) {
			accountType = sc.nextLine();
			System.out.println(accountType);
			if ((accountType.equals("1")) || (accountType.equals("2"))) {
				break;
			} else {
				System.out.println("\t\t\tInvalid input. Please enter either 1 or 2");
			}
		}

		if (accountType.equals("2")) {
			if (bankAccounts.size() < 2) {
				System.out.println("\t\t\tThere are no other accounts to choose from"); // informs user they are the
																						// only
				// account in database
			} else {
				System.out.println("\t\t\tYou chose to make a joint account.");
				System.out.println("\t\t\tIf you are joining an account please enter the account key below");
				String temp = null;
				while (true) {
					boolean keyFound = false;
					boolean notClient = false;
					temp = sc.nextLine();
					temp = temp.toLowerCase();
					if (temp.equals("exit")) {
						break;
					}
					for (Entry<Integer, Account> en : bankAccounts.entrySet()) {
						if (temp.equals(String.valueOf(en.getKey()))) {
							if (en.getValue().getUserType() == 1) { // check if accountKey is in map and a client
								System.out.println("\t\t\tentered a joint acount key");
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
						System.out.println("\t\t\tThe account key is not of a client. Please re-enter");
					} else { // accountKey does not match
						System.out.println("\t\t\taccountKey does not match a current open account");
					}
				}
				if (!(temp.equals("exit"))) {
					joint = Integer.parseInt(temp);
					System.out.println("\t\t\tAccountkey being passed to joint " + joint);
					bankAccounts.get(joint).setJoint(accountKeyPassed);
					// Menu.b.updateBankAccounts(bankAccounts.get(joint));
				}
				// for(Entry<String, String> i : userPass.entrySet()) {
				// loggy.info(i.getKey() + " made a joint account with "
				// +bankAccounts.get(temp));
				// }
			}
			System.out.println(
					"Fantastic, your account is pending employee approval. Log in after employee approval has been confirmed");
			return joint;
		}
		return joint;
	}

	@Override
	public void viewInformation(HashMap<Integer, Account> bankAccounts) {
		for (Entry<String, String> i : userPass.entrySet()) {
			System.out.println("\t\t\tUsername: " + i.getKey());
			System.out.println("\t\t\tPassword: " + i.getValue());
		}
		System.out.println("\t\t\tAccount Staus: " + applicationStatus);
		System.out.println("\t\t\tOpen accounts: " + accounts);
		if (joint > 0) {
			System.out.println("\t\t\tJoint Accounts: " + bankAccounts.get(joint).accounts);
		}
		System.out.println("\t\t\tJoint status: " + joint);
	}

	@Override
	public float deposit(String acc) {
		System.out.println("\t\t\tPlease enter amount you wish to deposit");
		exceptionCaught = true;
		while (true && exceptionCaught) {
			exceptionCaught = false;
			String amountTemp = sc.nextLine();
			try {
				amount = Float.valueOf(amountTemp);
			} catch (NumberFormatException e) {
				System.out.println("\t\t\tInvalid. Input must be an number");
				exceptionCaught = true;
				continue;
			}
			if (amount < 0) { // checks if non-negative value used
				System.out.println("\t\t\tYou can NOT enter a negative value");
				System.out.println("\t\t\tPlease re-enter deposit amount");
				exceptionCaught = true;
			} else { // positive value was entered
				break;
			}
		}
		for (Entry<String, String> i : userPass.entrySet()) {
			loggy.info(i.getKey() + " made a deposit of" + amount);
		}
		System.out.println("\t\t\tYour new account balance is: " + (accounts.get(acc) + amount));
		float tempy = accounts.get(acc) + amount;
		accounts.put(acc, tempy);
		return (accounts.get(acc));
	}

	@Override
	public float withdraw(String acc) {
		if (accounts.get(acc) > 0) {
			System.out.println("\t\t\tPlease enter amount you wish to withdraw:");
			exceptionCaught = true;

			while (true && exceptionCaught) {
				exceptionCaught = false;
				String amountTemp = sc.nextLine();
				try {
					amount = Float.valueOf(amountTemp);
				} catch (NumberFormatException e) {
					System.out.println("\t\t\tInvalid. Input must be an number");
					exceptionCaught = true;
					continue;
				}
				if (amount > accounts.get(acc)) { // checks if enough in account
					System.out.println("\t\t\tInvalid! Your acocunt only has: " + accounts.get(acc));
					System.out.println("\t\t\tPlease re-enter withdraw amount");
					exceptionCaught = true;
				} else if (amount < 0) { // checks if non-negative value used
					System.out.println("\t\t\tYou can NOT enter a negative value");
					System.out.println("\t\t\tPlease re-enter withdraw amount");
					exceptionCaught = true;
				} else {
					break;
				}
			}
			for (Entry<String, String> i : userPass.entrySet()) {
				loggy.info(i.getKey() + " made a withdraw of" + amount);
			}
			System.out.println("\t\t\tYour new account balance is: " + (accounts.get(acc) - amount));
			float tempy = accounts.get(acc) - amount;
			accounts.put(acc, tempy);
			return (accounts.get(acc));
		} else {
			System.out.println("\t\t\tYou only have $0 in your account");
		}
		Menu.b.updateBankAccounts(this);
		return (accounts.get(acc));
	}

	@Override
	public void transfer(int key, int otherKey, HashMap<Integer, Account> bankAccounts) {

		if (joint > 0) {
			System.out.println(
					"Would you like to 1: Transfer between your personal and joint account or 2: Your personal accounts");
			while (true) {
				yn = sc.nextLine();
				if ((yn.equals("1")) || (yn.equals("2"))) {
					break;
				} else {
					System.out.println("\t\t\tInvalid input. Please enter 1 or 2");
				}
			}
		} else {
			yn = "2";
		}
		if (yn.equals("1")) {
			System.out.println("\t\t\tPlease enter account you want to transfer from");
			System.out.println(bankAccounts.get(key).accounts);
			System.out.println(bankAccounts.get(otherKey).accounts);
			transferBetween(key, otherKey, bankAccounts);
		} else {
			System.out.println(key);
			System.out.println(bankAccounts.get(key).accounts.size());
			// if (bankAccounts.get(key).accounts.size() < 2) {
			// createAccounts(bankAccounts.get(key).accounts);
			// }
			System.out.println("\t\t\tPlease enter account you want to transfer from");
			System.out.println(bankAccounts.get(key).accounts);
			String accountOn = "";
			while (true) {
				accountExists = false;
				accountCur = sc.nextLine();
				accountCur = accountCur.toLowerCase();
				// check if account exists in the list
				for (Entry<String, Float> en : bankAccounts.get(key).accounts.entrySet()) { // iterate through all
																							// members
					// in
					// accounts map // check if accountKey is in map
					if (accountCur.equals(en.getKey())) {
						accountExists = true;
						accountOn = accountCur;
						System.out.println("\t\t\taccount found to exist");
						break; // breaks out of for loop
					}
				}
				if (accountExists && accounts.get(accountCur) <= 0) {
					System.out.println("\t\t\tYour acocunt has 0 funds in it");
					accountExists = false;
				}
				if (accountExists) {
					break;
				} else {
					System.out.println("\t\t\tInvalid. Please choose an exisiting account to transfer from.");
					System.out.println(bankAccounts.get(key).accounts);
				}
			}

			System.out.println("\t\t\tPlease enter account you wish to transfer to");
			while (true) {
				accountCur = sc.nextLine();
				accountCur = accountCur.toLowerCase();
				// check if account exists in the list
				for (Entry<String, Float> en : bankAccounts.get(key).accounts.entrySet()) { // iterate through all
																							// members
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
					System.out.println("\t\t\tInvalid. Please choose an exisiting account to transfer to.");
				}
			}

			System.out.println("\t\t\tPlease enter amount you wish to transfer");
			exceptionCaught = true;
			while (true && exceptionCaught) {
				exceptionCaught = false;
				String amountTemp = sc.nextLine();
				try {
					amount = Float.valueOf(amountTemp);
				} catch (NumberFormatException e) {
					System.out.println("\t\t\tInvalid. Amount must be an integer value.");
					exceptionCaught = true;
					continue;
				}
				if (amount > accounts.get(accountOn)) { // checks if enough in account
					System.out.println("\t\t\tInvalid! Your acocunt only has: " + accounts.get(accountOn));
					System.out.println("\t\t\tPlease re-enter withdraw amount");
					exceptionCaught = true;
				} else if (amount < 0) { // checks if non-negative value used
					System.out.println("\t\t\tYou can NOT enter a negative value");
					System.out.println("\t\t\tPlease re-enter withdraw amount");
					exceptionCaught = true;
				} else {
					break;
				}
			}
			for (Entry<String, String> i : userPass.entrySet()) {

				loggy.info(i.getKey() + " made a transfer of" + amount + "from their " + accountOn
						+ " account to their " + accountCur + " account.");
			}
			// System.out.println(key);
			bankAccounts.get(key).accounts.put(accountCur, (amount + bankAccounts.get(key).accounts.get(accountCur)));
			bankAccounts.get(key).accounts.put(accountOn, (bankAccounts.get(key).accounts.get(accountOn)) - amount);
			System.out.println(bankAccounts.get(key).accounts);
		}
		Menu.b.updateBankAccounts(this);

	}

	@Override // need to do
	public void transferBetween(int key, int otherKey, HashMap<Integer, Account> bankAccounts) {
		String accountOn = "";
		int jOrR = 0; // will be 1 if accountsCur is in key, 2 if accountsCur is in otherKey
		while (true) {
			accountExists = false;
			accountCur = sc.nextLine();
			accountCur = accountCur.toLowerCase();
			// check if account exists in the list
			for (Entry<String, Float> en : bankAccounts.get(key).accounts.entrySet()) { // iterate through all members
				// in
				// accounts map // check if accountKey is in map
				if (accountCur.equals(en.getKey())) {
					accountExists = true;
					accountOn = accountCur;
					jOrR = 1;
					System.out.println("\t\t\taccount found to exist");
					break; // breaks out of for loop
				}
			}
			for (Entry<String, Float> en : bankAccounts.get(otherKey).accounts.entrySet()) { // iterate through all
																								// members
				// in
				// accounts map // check if accountKey is in map
				if (accountCur.equals(en.getKey())) {
					accountExists = true;
					accountOn = accountCur;
					jOrR = 2;
					System.out.println("\t\t\taccount found to exist");
					break; // breaks out of for loop
				}
			}
			if (jOrR == 1) {
				if (accountExists && bankAccounts.get(key).accounts.get(accountCur) <= 0) {
					System.out.println("\t\t\tYour acocunt has 0 funds in it");
					accountExists = false;
					continue;
				}
			} else {
				if (accountExists && bankAccounts.get(otherKey).accounts.get(accountCur) <= 0) {
					System.out.println("\t\t\tYour acocunt has 0 funds in it");
					accountExists = false;
					continue;
				}
			}

			if (accountExists) {
				break;
			} else {
				System.out.println("\t\t\tInvalid. Please choose an exisiting account to transfer from.");
				System.out.println(bankAccounts.get(key).accounts);
				System.out.println(bankAccounts.get(otherKey).accounts);
			}
		}

		System.out.println("\t\t\tPlease enter account you wish to transfer to");
		while (true) {
			accountOn = sc.nextLine();
			accountOn = accountOn.toLowerCase();
			// check if account exists in the list
			for (Entry<String, Float> en : bankAccounts.get(key).accounts.entrySet()) { // iterate through all members
				if (accountOn.equals(en.getKey())) {
					accountExists = true;
					break;
				}
			}
			for (Entry<String, Float> en : bankAccounts.get(otherKey).accounts.entrySet()) { // iterate through all
																								// members
				if (accountOn.equals(en.getKey())) {
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
				System.out.println("\t\t\tInvalid. Please choose an exisiting account to transfer to.");
				System.out.println(bankAccounts.get(key).accounts);
				System.out.println(bankAccounts.get(otherKey).accounts);
			}
		}

		System.out.println("\t\t\tPlease enter amount you wish to transfer");
		exceptionCaught = true;
		while (true && exceptionCaught) {
			exceptionCaught = false;
			String amountTemp = sc.nextLine();
			try {
				amount = Float.valueOf(amountTemp);
			} catch (NumberFormatException e) {
				System.out.println("\t\t\tInvalid. Amount must be an integer value.");
				exceptionCaught = true;
				continue;
			}
			if (jOrR == 1) {
				if (amount > bankAccounts.get(key).accounts.get(accountCur)) { // checks if enough in account
					System.out.println(
							"Invalid! Your acocunt only has: " + bankAccounts.get(key).accounts.get(accountCur));
					System.out.println("\t\t\tPlease re-enter withdraw amount");
					exceptionCaught = true;
					continue;
				}

			} else {
				if (amount > bankAccounts.get(otherKey).accounts.get(accountCur)) { // checks if enough in account
					System.out.println(
							"Invalid! Your acocunt only has: " + bankAccounts.get(otherKey).accounts.get(accountCur));
					System.out.println("\t\t\tPlease re-enter withdraw amount");
					exceptionCaught = true;
					continue;
				}
			}
			if (amount < 0) { // checks if non-negative value used

				System.out.println("\t\t\tYou can NOT enter a negative value");
				System.out.println("\t\t\tPlease re-enter withdraw amount");
				exceptionCaught = true;
			} else {
				break;
			}
		}
		for (Entry<String, String> i : userPass.entrySet()) {
			loggy.info(i.getKey() + " made a transfer of" + amount + "from their " + accountOn + " account to their "
					+ accountCur + " account.");
		}
		if (jOrR == 1) {
			bankAccounts.get(otherKey).accounts.put(accountOn,
					(amount + bankAccounts.get(otherKey).accounts.get(accountOn)));
			bankAccounts.get(key).accounts.put(accountCur, (bankAccounts.get(key).accounts.get(accountCur)) - amount);
		} else {
			bankAccounts.get(key).accounts.put(accountOn, (amount + bankAccounts.get(key).accounts.get(accountOn)));
			bankAccounts.get(otherKey).accounts.put(accountCur,
					(bankAccounts.get(otherKey).accounts.get(accountCur)) - amount);
		}
		System.out.println(bankAccounts.get(key).accounts);
		System.out.println(bankAccounts.get(otherKey).accounts);
		Menu.b.updateBankAccounts(this);
	}

	// ******************************************************//
	// ******************Employee Account *******************//
	// ******************************************************//
	@Override
	public void viewApp() {
		if (!this.accountHolder) {
			System.out.println("\t\t\tCurrent status is:");
			if (this.applicationStatus == 0) {
				System.out.println("\t\t\tPending approval");
				setAccountStatus();
			}
			if (this.applicationStatus == 1) {
				System.out.println("\t\t\tThis account is currently active");
			} else {
				System.out.println("\t\t\tThis account was denied");
			}
		}
	}

	@Override
	public void setAccountStatus() {
		System.out.println("\t\t\tCurrent status is: " + applicationStatus); // currently only will be pending as
																				// empoyee
		// can't go in to edit anything else
		if (applicationStatus == 0) {
			System.out.println("\t\t\tDo you want to approve the account?");
			checkYN();
			if (yn.equals("1")) {
				applicationStatus = 1; // approved
				accountHolder = true;
				System.out.println("\t\t\tThe account is now approved");
			} else if (yn.equals("2")) {
				applicationStatus = 2; // denied
				System.out.println("\t\t\tThe account is now denied");

			}
		}
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
			System.out.println("\t\t\tApplication is currently active");
			System.out.println("\t\t\tDo you want to cancel the account?");
			checkYN();
			if (yn.equals("1")) {
				Menu.b.deleteBankAccounts(hashKey);
				System.out.println("\t\t\tThe account is now cancelled");
			} else if (yn.equals("2")) {
				applicationStatus = 1; // denied
				this.accountHolder = true;
				System.out.println("\t\t\tThe account is still approved");
			}
			break;
		case 2: // account was denied
			System.out.println("\t\t\tApplication was previously denied or cancelled");
			System.out.println("\t\t\tDo you want to re-approve the account?");
			checkYN();
			if (yn.equals("1")) {
				this.applicationStatus = 1; // approved
				this.accountHolder = true;
				System.out.println("\t\t\tThe account is now approved");

			} else if (yn.equals("2")) {
				applicationStatus = 2; // denied
				this.accountHolder = false;
				System.out.println("\t\t\tThe account is now denied");
			}
			break;
		default:
			System.out.println("\t\t\tError occurred - applicationStaus should be 0, 1, or 2 only");
			break;
		}
	}

	// **************************************************//
	// ***********Functions in Account class************//
	// **************************************************//
	private void checkYN() {
		System.out.println("\t\t\tPlease enter 1: Yes or 2: No");
		while (true) {
			yn = sc.nextLine();
			if ((yn.equals("1")) || (yn.equals("2"))) {
				break;
			} else {
				System.out.println("\t\t\tInvalid input. Please enter 1 or 2");
			}
		}
	}

	private void checkClientAction() {
		System.out.println("\t\t\tWould you like to 1: Deposit 2: Withdraw 3: Transfer");
		while (true) {
			choice = sc.nextLine();
			if ((choice.equals("1")) || (choice.equals("2")) || (choice.equals("3"))) {
				break;
			} else {
				System.out.println("\t\t\tInvalid. Please enter 1, 2, or 3");
			}
		}
	}

	public int getTrigger() {
		return trigger;
	}

	public void setTrigger(int trigger) {
		this.trigger = trigger;
	}
}