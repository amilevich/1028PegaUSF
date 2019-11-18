package com.examples.p0;

import java.io.IOException;

public class Account {
	private Double balance = 0.0;
	private Integer accountNumber;
	static String status;
	private static int nextAccountNumber = 29300;

	Account(Double balance) {
		this.balance = balance;
		accountNumber = nextAccountNumber++;
		if (balance != 0)
		status = "Pending";
	}

	public void showAccountDetails() {
		System.out.print("Account Number: ");
		System.out.println(this.getAccountNumber());
		System.out.print("Current Balance: $");
		System.out.println(this.getBalance());
		System.out.print("Account Status: ");
		System.out.println(this.getStatus());
	}
	
	public void deposit() throws IOException {
		Double amount;
		Integer input = 1;
		do {
			if(status != "Active") {
				System.out.println("You are not allowed to do that, your status is either pending or frozen. Please contact an employee or admin.");
				break;
			}
			System.out.println("How much money you want to deposit?");
			amount = Excptns.doubleInput();
			if (amount > 0) {
				double temp = balance;
				balance += amount;
				Bank.setTotalMoneyDeposited(Bank.getTotalMoneyDeposited() + amount);
				if (temp < 500) {
					System.out.println(
							"$40 is deducted as your account balance was below \"Minimum Balance\" witch is $500, before this transaction.");
					balance -= 40;
				}
				System.out.println("Your updated balance is: " + balance.toString());
				if (balance < 0)
					status = "Frozen";
				input = 0;
			} else {
				System.out.println("Amount can not be 0 or negative. Please enter a positive amount.");
				do {
					System.out.println("Press 1 to try again");
					System.out.println("Press 0 to go back to the previous menu");
					input = Excptns.integerInput();
					if (input == 1 || input == 0)
						break;
					else
						continue;
				} while (true);
			}
		} while (input != 0);
	}

	public void withdraw() throws IOException {
		Double amount;
		int input = 0;
		do {
			if(status != "Active") {
				System.out.println("You are not allowed to do that, your status is either pending or frozen. Please contact an employee or admin.");
				break;
			}
			
			System.out.println("How much money you want to withdraw?");
			amount = Excptns.doubleInput();
			if (amount > 0) {
				if (amount <= balance + 500) {
					balance -= amount;
					Bank.setTotalMoneyDeposited(Bank.getTotalMoneyDeposited() - amount);
					System.out.println("Your updated balance is: " + balance.toString());
					if (balance < 0)
						status = "frozen";
				} else {
					System.out.println("You don't have enough balance to withdraw");
				}
			} else {
				System.out.println("Amount can not be 0 or negative. Please enter a positive amount.");
				do {
					System.out.println("Press 1 to try again");
					System.out.println("Press 0 to go back to the previous menu");
					input = Excptns.integerInput();
					if (input == 1 || input == 0)
						break;
					else
						continue;
				} while (true);
			}
		} while (input != 0);
	}

	public String getStatus() {
		return status;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(double d) {
		balance = d;
	}
}