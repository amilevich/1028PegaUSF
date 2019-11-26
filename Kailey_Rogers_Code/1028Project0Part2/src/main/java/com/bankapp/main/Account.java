package com.bankapp.main;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import org.apache.log4j.Logger;

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
	AccountDaoImpl Dao = new AccountDaoImpl();
	CustomerDaoImpl cusDao = new CustomerDaoImpl();
	final static Logger bankLog = Logger.getLogger(Account.class);

	public Account() {

	}

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

	public Account(int accID, double balance, String type, String status) {
		super();
		this.accID = accID;
		this.balance = balance;
		this.type = type;
		this.status = status;
	}

	public void withdrawPro(HashMap<String, Customer> hMap) {
		Scanner cws = new Scanner(System.in);
		double amount;
		String username;
		flag = 0;
		while (!validInput && flag == 0) {
			System.out.print("Which account would you like to withdraw from: ");
			// cws.nextLine();
			username = cws.nextLine();
			for (Entry<String, Customer> en : hMap.entrySet()) {
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
						bankLog.info("User " + username + " withdrew " + amount + " dollars leaving a balance of "
								+ en.getValue().getBalance() + " dollars.");
						Dao.subtractBalance(en.getValue());
						flag = 1;
					}
				}
			}
		}
		flag = 0;
	}

	public void depositPro(HashMap<String, Customer> hMap) {
		Scanner cds = new Scanner(System.in);
		double temp3;
		String username;
		flag = 0;
		while (!validInput && flag == 0) {
			System.out.print("Which account would you like to deposit to: ");
			// cds.nextLine();
			username = cds.nextLine();
			for (Entry<String, Customer> en : hMap.entrySet()) {
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
						bankLog.info("User " + username + " deposited " + temp3 + " dollars making a balance of "
								+ en.getValue().getBalance() + " dollars.");
						Dao.addBalance(en.getValue());
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
		flag = 0;
		while (!validInput && flag == 0) {
			System.out.print("Which account would you like to transfer from: ");
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
											"Transfer successful!  Your balance is " + en.getValue().getBalance() + ".");
									System.out.println(i.getValue().getUserFirstName() + "'s account balance is now: "
											+ i.getValue().getBalance() + ".");
									bankLog.info("User " + en.getValue().getUserUsername() + " transfered " + amount
											+ " dollars to " + i.getValue().getUserUsername() + " leaving a balance of "
											+ en.getValue().getBalance() + " dollars.");
									Dao.subtractBalance(en.getValue());
									Dao.addBalance(i.getValue());
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
								System.out.println("Transfer successful! " + en.getValue().getUserFirstName()
										+ "'s balance is " + en.getValue().getBalance() + ".");
								System.out.println(i.getValue().getUserFirstName() + "'s account balance is now: "
										+ i.getValue().getBalance() + ".");
								bankLog.info("User " + en.getValue().getUserUsername() + " transfered " + amount
										+ " dollars to " + i.getValue().getUserUsername() + " leaving a balance of "
										+ en.getValue().getBalance() + " dollars.");
								Dao.subtractBalance(en.getValue());
								Dao.addBalance(i.getValue());
								flag = 1;
								break;
							}
						}
					}
				}
			}
		}
		flag = 0;
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
					String username = en.getValue().getUserUsername();
//					cusDao.selectCustomerByUsername(viewAcc.get(username));

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
							+ en.getValue().getType());
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
					bankLog.info("User " + en.getValue().getUserUsername() + " has been approved.");
					Dao.approveAccount(en.getValue());
					flag = 1;
					break;
				}
			}
			if (flag != 1) {
				System.out.print("Not a valid username.  Please enter a valid username.");
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
			}
			System.out.print("Please enter the username of the user you would like to cancel: ");
			temp = acp.nextLine();
			for (Entry<String, Customer> en : cancelAcc.entrySet()) {
				if (temp.equals(en.getValue().getUserUsername())) {
					en.getValue().setStatus("cancelled");
					System.out.println(" ");
					System.out.println("Account cancelled!");
					bankLog.info("User " + en.getValue().getUserUsername() + " has been cancelled.");
					String accountCancel = en.getValue().getStatus();
					Dao.cancelAccount(cancelAcc.get(accountCancel));
					flag = 1;
					break;
				}
			}
			if (flag != 1) {

				System.out.print("Not a valid username.  Please enter a valid username: ");
			}
		}
		flag = 0;
	}

	public void editAccountPro(HashMap<String, Customer> editAcc) {
		Scanner eap = new Scanner(System.in);
		String temp;
		String password;
		String firstName;
		String lastName;
		int temp2;
		while (!validInput && flag == 0) {
			System.out.print("Please enter the user you would like to edit: ");
			temp = eap.nextLine();
			for (Entry<String, Customer> en : editAcc.entrySet()) {
				if (temp.equals(en.getValue().getUserUsername())) {
					System.out.println("Account Username: " + en.getValue().getUserUsername() + " Account First Name: "
							+ en.getValue().getUserFirstName() + " Account Last Name: "
							+ en.getValue().getUserLastName() + " Type of Account: "
							+ en.getValue().getUserAccountApply() + " Account Balance: " + en.getValue().getBalance());
					System.out.println("");
					System.out.println("Editing Options");
					System.out.println("1 Password");
					System.out.println("2 First Name");
					System.out.println("3 Last Name");
					System.out.print("What would you like to edit: ");
					while (!validInput) {
						try {
							String input = eap.nextLine();
							temp2 = Integer.valueOf(input);
							break;
						} catch (Exception e) {
							System.out.println("Please enter a valid number.");
						}
					}

					switch (temp2) {
					case 1:
						System.out.print("What would you like to change the password to: ");
						password = eap.nextLine();
						System.out.println("Password set!");
						en.getValue().setUserPassword(password);
						bankLog.info("User " + en.getValue().getUserUsername() + "'s password was updated.");
						cusDao.updateCustomerPassword(editAcc.get(password));
						flag = 1;
						break;
					case 2:
						System.out.print("What would you like to change the first name to: ");
						firstName = eap.nextLine();
						System.out.println("First name set!");
						en.getValue().setUserFirstName(firstName);
						bankLog.info("User " + en.getValue().getUserUsername() + "'s first name was updated.");
						cusDao.updateCustomerFirstName(editAcc.get(firstName));
						flag = 1;
						break;
					case 3:
						System.out.print("What would you like to change the last name to: ");
						lastName = eap.nextLine();
						System.out.println("Last name set!");
						en.getValue().setUserLastName(lastName);
						bankLog.info("User " + en.getValue().getUserUsername() + "'s last name was updated.");
						cusDao.updateCustomerLastName(editAcc.get(lastName));
						flag = 1;
						break;
					default:
						System.out.println("Please enter a valid number.");
						break;
					}

				}
			}
		}
		flag = 0;
	}
}