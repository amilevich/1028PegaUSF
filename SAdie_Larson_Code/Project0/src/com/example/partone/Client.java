package com.example.partone;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Client extends Account {

	protected boolean accountHolder; // check to see status of account
	protected int accountBalance;
	protected int applicationStatus; // 0: applied, 1: approved, 2: denied

	String accountCur; // checking, savings, whatever they call it
	int amount;

	Map<String, Integer> accounts = new HashMap<String, Integer>();

	public Client() {
		createAccount();
		apply();
	}

	public void apply() { // need to implement creating a joint account
		System.out.println("What type of account would you like to create? Single or Joint");
		while (!validInput) {
			accountType = sc.nextLine();
			if ((accountType == "Single") || (accountType == "Joint")) {
				break;
			} else {
				System.out.println("Invalid input. Please enter either Single or Joint");
			}
		}
		
		this.accountType = accountType;
		if(accountType == "Joint") {
			System.out.println("You chose to make a joint account.");
			System.out.println("If you are joining an account please enter the account key below");
			while(!validInput) {
				
			}
		}
	}

	public void viewBalance() {
		System.out.println(accounts);
	}

	public int withdraw(int accountBalance) {
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

	public int deposit(int accountBalance) {
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

	public int transfer(int accountBalance) {
		if (!this.accountHolder) {
			System.out.println("You do not have an account at this time");
			return 0;
		} else {
			boolean validAccount = false;
			System.out.println("Please enter account you want to transfer from");
			System.out.println(accounts);
			while (!validInput) {
				accountCur = sc.nextLine();

				// check if account exists in the list
				// if(accountCur != )
				// } else {
				// System.out.println();
				// }
				System.out.println("Please enter account you wish to transfer to");
				System.out.println("Please enter amount you wish to transfer");
			}
			validInput = false;
			return (accountBalance + amount);
		}
	}

}
