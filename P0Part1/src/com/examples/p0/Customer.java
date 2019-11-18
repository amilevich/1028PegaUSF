package com.examples.p0;
import java.io.IOException;
import java.util.ArrayList;

public class Customer extends User {
	
	private ArrayList<Account> accounts = new ArrayList<Account>();

	public Customer(String name, String userName, String password) {
		super(name, userName, password);
	}
	public Account getAccount() throws IOException {
		Integer accountNumber;
		Account temp = null;
		Integer input = 1;
		do {
			System.out.println("Enter your account number");
			accountNumber = Excptns.integerInput();
			for (Account account : accounts) {
				if (account.getAccountNumber() == accountNumber) {
					temp = account;
				}
			}
			if (temp == null) {
				System.out.println("No account with that account Number");
				System.out.println("Press 1 to try again");
				System.out.println("Press 0 to go back to previous menu");
				input = Excptns.integerInput();
			} else {
				break;
			}
		} while (input != 0);
		return temp;
	}

	public void openNewAccount() throws IOException {
		Double amount;
		// Input Amount
		System.out
				.println("How much money would you like to deposit now? Minimum amount to open an account is $500");
		amount = Excptns.doubleInput();
		if (amount < 500)
			System.out.println("Sorry we cant open an account with amount " + amount.toString());
		else {
			System.out.println("Okay! You have " + amount.toString() + " as opening balance");
			Account temp = new Account(amount);
			if (accounts.add(temp)) {
				Bank.setTotalMoneyDeposited(Bank.getTotalMoneyDeposited() + amount);
				System.out.println("Account created.");
				temp.showAccountDetails();
			}
		}
	}

	public void showCustomerDetails() {

	}

	public Integer getNoOfAccount() {
		return accounts.size();
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}
}