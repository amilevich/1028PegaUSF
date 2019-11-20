package users;

import java.util.InputMismatchException;
import java.util.Scanner;

import bankapp.BankApp;
import bankapp.MainDriver;

public class Admin extends Customer {
	// HARD CODED ADMIN
	static String adminUsername = "HWHY";
	static String adminPassword = "balance";

	public static void adminLogin(Scanner in) throws InputMismatchException {
		System.out.println("Welcome Yahweh, please provide your username and password: ");
		System.out.println("Username: ");
		String username = in.next();
		System.out.println("Password: ");
		String password = in.next();
		if (adminUsername.contentEquals(username) && adminPassword.contentEquals(password)) {
			boolean running = true;
			do {
				viewAllAccountInfo(in);
				adminLoginMenu(in);
				running = MainDriver.runProgram(in);
			} while (running);
		} else {
			System.out.println("Incorrect login");
		}
	}

	
	public static void adminLoginMenu(Scanner in) throws InputMismatchException {
		System.out.println("What would you like to do? ");
		System.out.println("Deposit - DEP");
		System.out.println("Withdraw - DEB");
		System.out.println("Transfer - TFR");
		System.out.println("View All Accounts - VIEW");
		System.out.println("Cancel Account - END");
		System.out.println("Log Out - EXIT");
		
		String adminSelection = in.next();
		switch (adminSelection) {
		case "DEP":
			System.out.println("Which account would you like to make a deposit to?");
			String key = in.next();
			Account account = BankApp.approvedAccounts.get(key);
			deposit(account, in);
			adminLoginMenu(in);
			break;
		case "DEB":
			System.out.println("Which account would you like to take a debit from?");
			String keyOne = in.next();
			Account accountOne = BankApp.approvedAccounts.get(keyOne);
			withdraw(accountOne, in);
			adminLoginMenu(in);
			break;
		case "TFR":
			System.out.println("Which account would you like to make a transfer from?");
			String keyTwo = in.next();
			Account accountTwo = BankApp.approvedAccounts.get(keyTwo);
			System.out.println("Which account would you like to transfer to?");
			Account accountThree = BankApp.getTransfer(in);
			transfer(accountTwo, accountThree, in);
			adminLoginMenu(in);
			break;
		case "VIEW":
			Employee.viewAccountInfo(in);
			adminLoginMenu(in);
			break;
		case "END":
			System.out.println("Which account would you like to cancel?");
			String keyThree = in.next();
			Account accountFour = BankApp.approvedAccounts.get(keyThree);
			removeAccounts(accountFour);
			adminLoginMenu(in);
			break;
		case "EXIT":
			System.out.println("Logged out...");
			System.out.println();
			System.out.println("Have a great day");
			break;
		}
	}

	public static void viewAllAccountInfo(Scanner in) throws InputMismatchException {
		System.out.println("All Accounts");
		System.out.println(BankApp.approvedAccounts.keySet().toString());
	}

	public static void removeAccounts(Account account) throws InputMismatchException {
		BankApp.approvedAccounts.remove(account.getAccountNumber());
		System.out.println("Account Deleted");
	}

}