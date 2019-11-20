package users;

import java.util.InputMismatchException;
import java.util.Scanner;

import bankapp.BankApp;

public class Employee {
	// HARDCODED EMPLOYEE
	static String EmployeeUsername = "Adam";
	static String EmployeePassword = "eden";

	public static void employeeLogin(Scanner in) throws InputMismatchException {
		System.out.println("Welcome to the Bank of CZR Employee Portal");
		System.out.println("Please provide your username and password");
		System.out.println("username: ");
		String username = in.next();
		System.out.println("password: ");
		String password = in.next();
		if (EmployeeUsername.contentEquals(username) && EmployeePassword.contentEquals(password)) {
			loggedInMenu(in);
		} else {
			System.out.println("Match not found...");
		}
	}

	
	public static void loggedInMenu(Scanner in) throws InputMismatchException {

		System.out.println("Which task would you like to complete? Approve pending accounts or view customer accounts");
		System.out.println("Approve pending accounts - APPROVE");
		System.out.println("View customer accounts - VIEW");
		String employeeSelection = in.next();
		switch (employeeSelection) {
		case "APPROVE":
			approveAccounts(in);
			break;
		case "VIEW":
			viewAccountInfo(in);
			break;
		}
	}

	
	public static void approveAccounts(Scanner in) throws InputMismatchException {
		if (BankApp.pendingAccounts.isEmpty()) {
			System.out.println("There are no pending applications!");
		} else {
			for (Account i : BankApp.pendingAccounts) {
				System.out.println(i.toString());
				System.out.println("Would you like to approve or deny the application?");
				String input = in.next();
				// in.nextLine();
				if (input.equals("APPROVE")) {
					BankApp.approvedAccounts.put(i.getId(), i);
					if (i.getNameTwo() != null) {
						BankApp.approvedAccounts.put(i.getIdTwo(), i);
					}
					System.out.println("Account has been approved.");
				} else if (input.equals("DENY")) {
					System.out.println("Account has been denied.");
				}

			}
			BankApp.pendingAccounts.removeAll(BankApp.pendingAccounts);
			System.out.println("Account processing complete");
		}
	}

	public static void viewAccountInfo(Scanner in) throws InputMismatchException {

		if (BankApp.approvedAccounts.isEmpty()) {
			System.out.println("Account applications are still pending");
		} else {
			System.out.println(BankApp.approvedAccounts.keySet().toString());
			boolean viewingAccount = true;

			while (viewingAccount) {
				try {
					System.out.println("Which account would you like to view?");
					in.next();
					String accountId = in.next();
					Account account = BankApp.approvedAccounts.get(accountId);
					System.out.println(account.toString());
				} catch (NullPointerException e) {
					 e.printStackTrace();
					System.out.println("Account does not exist");
				}

				System.out.println("Would you like to view other accounts?");
				String employeeMenuSelection = in.next();
				if (employeeMenuSelection.equals("NO")) {
					viewingAccount = false;
					System.out.println("Logging out...");
				} else if (employeeMenuSelection.equals("YES")) {
					viewAccountInfo(in);
				} else {
					System.out.println("Invalid selection");
					break;
				}
			}
		}

	}

}