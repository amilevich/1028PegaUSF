package com.example.partone;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Client extends Account {

	public Client(HashMap<Integer, Account> bankAccounts) {
		super(bankAccounts, 1);
		// TODO Auto-generated constructor stub
	}

	/*protected boolean accountHolder; // check to see status of account
	protected int accountBalance = 0;
	protected int applicationStatus; // 0: applied, 1: approved, 2: denied

	String accountCur; // checking, savings, whatever they call it
	int amount;

	Map<String, Integer> accounts = new HashMap<String, Integer>();

	public Client(HashMap<Integer, SystemAdmin> bankAccounts) {
		createAccount(bankAccounts);
		apply(bankAccounts);
		System.out.println("done constructing");
	}

	public void createAccounts() { // note difference between account(user) and accounts (types of accounts a user
									// has)
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

	public void apply(HashMap<Integer, SystemAdmin> bankAccounts) { // need to implement creating a joint account
		System.out.println("What type of account would you like to create? 1: Single or  2: Joint");
		while (!validInput) {
			accountType = sc.nextInt();
			System.out.println(accountType);
			if ((accountType == 1) || (accountType == 2)) { //keeps getting frozen here for some reason
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
				for (Entry<Integer, SystemAdmin> en : bankAccounts.entrySet()) { // iterate through all members in
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
			System.out.println("Fantastic, your account is pending employee approval. Log in after employee approval has been confirmed");
	}

	public void viewInformation() {
		System.out.println("Name: " + getfName() + " " + getlName());
		System.out.println(accounts);
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
*/
}
