package com.bankapp.main;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Account {

	private int accID;
	private double balance;
	private String type;
	private String status;
	private double deposit;
	private double withdraw;
	private double transfer;
	public static final boolean validInput = false;
	public static int flag = 0;

	// Getters and Setters
	public int getAccID() {
		return accID;
	}

	public void setAccID(int accID) {
		this.accID = accID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public double getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}

	public double getTransfer() {
		return transfer;
	}

	public void setTransfer(double transfer) {
		this.transfer = transfer;
	}

	public void withdrawPro(HashMap<String, Customer> hMap) {
		Scanner cws = new Scanner(System.in);
		double amount;
		String username;
		flag = 0;
		while (!validInput && flag == 0) {
			for (Entry<String, Customer> en : hMap.entrySet()) {
				System.out.print("Which account would you like to withdraw from: ");
				cws.nextLine();
				username = cws.nextLine();
				if (username.equals(en.getValue().getUserUsername())) {
					System.out.print("What would you like to withdraw: ");
					amount = cws.nextDouble();
					// if the value is less than or equal to 0, return input valid
					// amount
					if (amount <= 0 && amount > en.getValue().getBalance()) {
						System.out.print("Please enter a valid amount: ");
					} else {
						// add to balance
						en.getValue().setBalance(en.getValue().getBalance() - amount);
						System.out.println(
								"Withdraw successful!  Customer's balance is " + en.getValue().getBalance() + ".");
						flag = 1;
					}
				}
			}
		}
	}

	public void depositPro(HashMap<String, Customer> hMap) {
		Scanner cds = new Scanner(System.in);
		double temp3;
		String username;
		int filler;
		while (!validInput && flag == 0) {
			for (Entry<String, Customer> en : hMap.entrySet()) {
				System.out.print("Which account would you like to deposit to: ");
				cds.nextLine();
				username = cds.nextLine();
				if (username.equals(en.getValue().getUserUsername())) {
					System.out.print("What would you like to deposit: ");
					temp3 = cds.nextDouble();
					// if the value is less than or equal to 0, return input valid amount
					if (temp3 <= 0) {
						System.out.print("Please enter a valid amount: ");
					} else {
						// add to balance
						en.getValue().setBalance(en.getValue().getBalance() + temp3);
						System.out.println(
								"Deposit successful!  Customer's balance is " + en.getValue().getBalance() + ".");
						flag = 1;
						break;
					}
				}
			}
		}
		flag = 0;
	}

	public void transferPro(HashMap<String, Customer> hMap) {
		Scanner cts = new Scanner(System.in);
		String accountTo;
		double amount;
		int choice;
		String accountFrom;
		while (!validInput && flag == 0) {
			System.out.print("Which account would you like to transfer from: ");
			cts.nextLine();
			accountFrom = cts.nextLine();
			for (Entry<String, Customer> en : hMap.entrySet()) {
				if (accountFrom.equals(en.getValue().getUserUsername())) {
					System.out.print("Which account would you like to transfer to: ");
					accountTo = cts.nextLine();
					for (Entry<String, Customer> i : hMap.entrySet()) {
						if (accountTo.equals(i.getValue().getUserUsername())) {
							System.out.print("What amount would you like to transfer: ");
							amount = cts.nextDouble();
							if (amount <= 0) {
								System.out.print("Please enter a valid amount: ");
								break;
							} // if value is greater than the amount in the account,
								// return input valid amount
							else if (amount > en.getValue().getBalance()) {
								System.out.println("Cannot transfer an amount greater than your account balance.");
								System.out.print("Please enter a valid amount: ");
								break;
							} // if the value will cause a balance of 0, return amount
								// would be 0 and confirm
								// they want to withdraw that amount.
							else if ((en.getValue().getBalance() - amount) == 0) {
								System.out.print(
										"This will cause your account to be left at 0.  Do you want to do this (please select 1 for yes and 0 for no): ");
								choice = cts.nextInt();
								switch (choice) {
								case 1:
									i.getValue().setBalance(i.getValue().getBalance() + amount);
									en.getValue().setBalance(en.getValue().getBalance() - amount);
									System.out.println(
											"Transfer successful!  You balance is " + en.getValue().getBalance() + ".");
									System.out.println(i.getValue().getUserFirstName() + "'s account balance is now: "
											+ i.getValue().getBalance() + ".");
									flag = 1;
									break;
								case 2:
									flag = 1;
									break;
								default:
									System.out.print("Invalid input.  Please use 1 for yes and 2 for no: ");
								}
							} else {
								// if value is less than the amount in the account, make
								// transfer successful
								i.getValue().setBalance(i.getValue().getBalance() + amount);
								en.getValue().setBalance(en.getValue().getBalance() - amount);
								System.out.println(
										"Transfer successful! " + en.getValue().getUserFirstName() + "'s balance is " + en.getValue().getBalance() + ".");
								System.out.println(i.getValue().getUserFirstName() + "'s account balance is now: "
										+ i.getValue().getBalance() + ".");
								flag = 1;
							}
						}
					}
				}
			}
			flag = 0;
		}
	}

	public void viewAccountPro(HashMap<String, Customer> viewAcc) {
		Scanner vap = new Scanner(System.in);
		String temp;
		while (!validInput && flag == 0) {
			System.out.print("Please enter the user you are trying to look up: ");
			temp = vap.nextLine();
			for (Entry<String, Customer> en : viewAcc.entrySet()) {
				if (temp.equals(en.getValue().getUserUsername())) {
					System.out.println("Account Username: " + en.getValue().getUserUsername() + " Account First Name: "
							+ en.getValue().getUserFirstName() + " Account Last Name: "
							+ en.getValue().getUserLastName() + " Type of Account: "
							+ en.getValue().getUserAccountApply() + " Account Balance: " + en.getValue().getBalance());
					flag = 1;
				}
			}
		}
		flag = 0;
	}

	public void accountApprovePro(HashMap<String, Customer> approveAcc) {
		Scanner aap = new Scanner(System.in);
		String temp;
		while (!validInput && flag == 0) {
			System.out.println("Lists of accounts that need approval: ");
			System.out.println();
			for (Entry<String, Customer> en : approveAcc.entrySet()) {
				if (en.getValue().getStatus().equals("pending")) {
					System.out.println("Account Username: " + en.getValue().getUserUsername() + " Account First Name: "
							+ en.getValue().getUserFirstName() + " Account Last Name: "
							+ en.getValue().getUserLastName() + " Type of Account: "
							+ en.getValue().getUserAccountApply());
				}
			}
			// print out accounts that need approved
			// make it so that the employee/admin can choose if the account is approved or
			// denied
			System.out.print("Please enter the username of the user you would like to approve: ");
			temp = aap.nextLine();
			for (Entry<String, Customer> en : approveAcc.entrySet()) {
				if (temp.equals(en.getValue().getUserUsername())) {
					en.getValue().setStatus("approved");
					System.out.println(" ");
					System.out.println("Account approved!");
					flag = 1;
					break;
				} else {
					System.out.print("Not a valid username.  Please enter a valid username: ");
				}
			}
		}
		flag = 0;
	}

	public void accountCancelPro(HashMap<String, Customer> cancelAcc) {
		Scanner acp = new Scanner(System.in);
		String temp;
		while (!validInput && flag == 0) {
			System.out.println("Lists of active accounts: ");
			System.out.println();
			for (Entry<String, Customer> en : cancelAcc.entrySet()) {
				if (en.getValue().getStatus().equals("approved")) {
					System.out.println("Account Username: " + en.getValue().getUserUsername() + " Account First Name: "
							+ en.getValue().getUserFirstName() + " Account Last Name: "
							+ en.getValue().getUserLastName() + " Type of Account: "
							+ en.getValue().getUserAccountApply());
				}
				System.out.print("Please enter the username of the user you would like to cancel: ");
				temp = acp.nextLine();
				if (temp.equals(en.getValue().getUserUsername())) {
					en.getValue().setStatus("cancelled");
					System.out.println(" ");
					System.out.println("Account cancelled!");
					flag = 1;
					break;
				} else {
					System.out.print("Not a valid username.  Please enter a valid username: ");
				}
			}
		}
		flag = 0;
	}
}