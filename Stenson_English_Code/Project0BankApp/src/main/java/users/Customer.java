package users;

import java.util.InputMismatchException;
import java.util.Scanner;

import bankapp.BankApp;
import bankapp.MainDriver;

public class Customer {

	
	public static void customerLogin(Scanner in) throws InputMismatchException {
		System.out.println("Would you like to log in  or apply for a new account?");
		System.out.println("Login - LOGIN");
		System.out.println("Apply - APPLY");
		String input = in.next();
		switch (input) {
		case "LOGIN":
			Account account = BankApp.getAccount(in);
			int accountNumber = account.hashCode();

			do {
				System.out.println("Account #" + accountNumber);
				System.out.println("How can we be of service?");
				System.out.println();
				System.out.println("View Balance - BAL");
				System.out.println("Make a Deposit - DEP");
				System.out.println("Make a Withdrawal - DEB");
				System.out.println("Transfer Funds - TFR");
				System.out.println("Log out - EXIT");
				String customerSelection = in.next();
				switch (customerSelection) {
				case "BAL":
					System.out.println("Your account balance is: $" + account.getBalance());
					break;
				case "DEP":
					deposit(account, in);
					break;
				case "DEB":
					withdraw(account, in);
					break;
				case "TFR":
					System.out.println("Which account would you like to make a transfer to?");
					Account account2 = BankApp.getTransfer(in);
					transfer(account, account2, in);
					break;
				case "EXIT":
					System.out.println("Logged Out");
					System.out.println("Thank you for banking with Bank of CZR");
					break;
				default:
					System.out.println("Invalid selection");
				}

			} while (MainDriver.runProgram(in));
			break;
		case "APPLY":
			System.out.println("Are you applying for a single account or a joint account?");
			System.out.println("Single Account - S");
			System.out.println("Joint Account - J");
			String newAccountSelection = in.next();
			switch (newAccountSelection) {
			case "S":
				create(in);
				break;
			case "J":
				createJoint(in);
				break;
			}
			break;
		default:
			System.out.println("Invalid selection");
		}
	}

	// ACCOUNT CREATION ~ CREACION DE CUENTO
	public static void create(Scanner in) throws InputMismatchException {
		System.out.println("Please provide a username:");
		String username = in.next();
		System.out.println("Please provide a password: ");
		String password = in.next();
		System.out.println("Deposit Amount: ");
		double balance = in.nextDouble();
		Account account = new Account(username, password, username + password, balance, 0);
		int accountNumber = account.hashCode();

		BankApp.pendingAccounts.add(account);
		System.out.println("Your application for account #" + accountNumber
				+ " has been submitted. Please allow up to 24 to 48 hours approval time for each submission.");
	}

	public static void createJoint(Scanner in) throws InputMismatchException {
		System.out.println("Please provide the username for the primary account holder: ");
		String userOne = in.next();
		System.out.println("Please provide a password for the primary account holder: ");
		String passwordOne = in.next();

		System.out.println("Please provide the username for the secondary account holder:");
		String userTwo = in.next();
		System.out.println("Please provide a password for the secondary account holder: ");
		String passwordTwo = in.next();

		System.out.println("How much would you like to deposit into your account?");
		double balance = in.nextDouble();

		Account account = new Account(userOne, passwordOne, userOne + passwordOne, userTwo, passwordTwo,
				userTwo + passwordTwo, balance, 0);
		int accountNumber = account.hashCode();
		BankApp.pendingAccounts.add(account);
		System.out.println("Your application for account #" + accountNumber
				+ " has been submitted. Please allow up to 24 to 48 hours approval time for each submission.");

	}

	public static void viewAccountBalance(Account account) {
		System.out.println(account.getBalance());

	}

	public static void deposit(Account account, Scanner in) throws InputMismatchException {
		System.out.println("How much would you like to deposit?");
		double dep = in.nextDouble();
		account.setBalance(account.getBalance() + dep);
		System.out.println("Your account balance is: $" + account.getBalance());
	}

	public static void withdraw(Account account, Scanner in) throws InputMismatchException {
		System.out.println("How much would you like to withdraw?");
		double debit = in.nextDouble();
		if (account.getBalance() >= debit) {
			account.setBalance(account.getBalance() - debit);
			System.out.println("Your account balance is: $" + account.getBalance());

		} else if (account.getBalance() < debit) {
			System.out.println("Insufficient Funds");
			System.out.println("Your account balance is: $" + account.getBalance());
			withdraw(account, in);
		}
	}

	public static void transfer(Account account1, Account account2, Scanner in) throws InputMismatchException {
		try {
			System.out.println("How much would you like to transfer to from: " + account1.getName() + " to: "
					+ account2.getName() + "?");
			double transferTotal = in.nextDouble();
			if ((account1.getBalance() - transferTotal) >= 0) {
				account1.setBalance(account1.getBalance() - transferTotal);
				account2.setBalance(account2.getBalance() + transferTotal);
				System.out.println("Transfer completed");
			} else {
				System.out.println("Transfer not complete. Please try again");
				transfer(account1, account2, in);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	//ADDING TO THE NEXT VERSION ~ ANADE A PROXIMO VERSION
	public static void getPriorTransaction(Account account) {

	}
}