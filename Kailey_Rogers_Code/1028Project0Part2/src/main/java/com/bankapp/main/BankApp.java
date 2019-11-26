package com.bankapp.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.Logger;

import java.util.Map.Entry;

public class BankApp {

	public static int flag = 0;
	public static int flag1 = 0;
	final static Logger bankLog = Logger.getLogger(BankApp.class);

	public static void main(String[] args) {
		HashMap<String, Customer> hMap = new HashMap<String, Customer>();
		CustomerDaoImpl cusDao = new CustomerDaoImpl();
		AccountDaoImpl Dao = new AccountDaoImpl();
		hMap = cusDao.selectAllCustomers();
		
		while (true) {

			Employee account2 = new Employee();
			Admin account3 = new Admin();
			final boolean validInput = false;
			// Bank Menu
			int temp;
			Scanner msc = new Scanner(System.in);
			while (!validInput) {
				System.out.println("\n");
				System.out.println("Welcome to the bank.  Here are your options:");
				System.out.println("1 register");
				System.out.println("2 login");
				System.out.print("What would you like to do: ");
				while (!validInput) {
					try {
						String input = msc.nextLine();
						temp = Integer.valueOf(input);
						break;
					} catch (Exception e) {
						System.out.println("Please enter a valid number.");
					}
				}
				switch (temp) {
				case 1:
					Customer account = new Customer();
					account.accountSignUp(hMap);
					hMap.put(account.getUserUsername(), account);
					cusDao.insertCustomer(account);
					Dao.insertAccount(account);
					if (!account.getUserAccountApply().equals("single")) {
						String user2 = account.getUserAccountApply();
						Customer account1 = new Customer(account.getUserUsername(), account.getUserPassword(),
								account.getUserFirstName(), account.getUserLastName(),
								hMap.get(user2).getUserUsername(), hMap.get(user2).getJointUserPassword(),
								hMap.get(user2).getJointUserFirstName(), hMap.get(user2).getJointUserLastName());
						cusDao.insertCustomer(account1);
						Dao.insertAccount(account1);
					}
					break;
				case 2:
					System.out.println("\n");
					System.out.println("Here are our following logins:");
					System.out.println("1 customer");
					System.out.println("2 employee");
					System.out.println("3 admin");
					System.out.print("Please choose the appropriate login: ");
					while (!validInput) {
						try {
							String input = msc.nextLine();
							temp = Integer.valueOf(input);
							break;
						} catch (Exception e) {
							System.out.println("Please enter a valid number.");
						}
					}
					switch (temp) {
					case 1:
						// get username
						String temp2;
						while (!validInput && flag == 0) {
							System.out.println("\n");
							System.out.print("Please enter your username: ");
							boolean userExists = true;
							temp2 = msc.nextLine();
							// if user exists
							for (Entry<String, Customer> en : hMap.entrySet()) {
								if (temp2.equals(en.getValue().getUserUsername())
										&& (en.getValue().getStatus()).equals("approved")) {
									System.out.print("Please enter your password: ");
									temp2 = msc.nextLine();

									// if password matches
									if (temp2.equals(en.getValue().getUserPassword())) {
										Account customerAccount = new Account();
										double temp3;
										int temp4;
										while (!validInput && flag1 == 0) {
											System.out.println("\n");
											System.out
													.println("Welcome to the customer portal.  Here are your options:");
											System.out.println("1 deposit");
											System.out.println("2 withdraw");
											System.out.println("3 transfer");
											System.out.println("4 view account info");
											System.out.println("5 exit to main menu");
											System.out.print("What would you like to do: ");
											while (!validInput) {
												try {
													String input = msc.nextLine();
													temp4 = Integer.valueOf(input);
													break;
												} catch (Exception e) {
													System.out.println("Please enter a valid number.");
												}
											}

											switch (temp4) {
											case 1:
												double temp5;
												while (!validInput && flag == 0) {
													System.out.print("What would you like to deposit: ");
													temp3 = msc.nextDouble();
													// if the value is less than or equal to 0, return input valid
													// amount
													if (temp3 <= 0) {
														System.out.print("Please enter a valid amount: ");
													} else {
														// add to balance
														en.getValue().setBalance(en.getValue().getBalance() + temp3);
														System.out.println("Deposit successful!  Your balance is "
																+ en.getValue().getBalance() + ".");
														bankLog.info("User " + en.getValue().getUserUsername()
																+ " deposited " + temp3
																+ " dollars making a balance of "
																+ en.getValue().getBalance() + " dollars.");
														flag = 1;
													}
												}
												flag = 0;
												break;
											case 2:
												double amount;
												while (!validInput && flag == 0) {
													System.out.print("What would you like to withdraw: ");
													amount = msc.nextDouble();
													// if the value is less than or equal to 0, return input valid
													// amount
													if (amount <= 0 && amount > en.getValue().getBalance()) {
														System.out.print("Please enter a valid amount: ");
													} else {
														// subtract the difference and return the balance
														en.getValue().setBalance(en.getValue().getBalance() - amount);
														System.out.println("Withdraw successful!  Your balance is "
																+ en.getValue().getBalance() + ".");
														bankLog.info(
																"User " + en.getValue().getUserUsername() + " withdrew "
																		+ amount + " dollars leaving a balance of "
																		+ en.getValue().getBalance() + " dollars.");
														flag = 1;
													}
												}
												flag = 0;
												break;
											case 3:
												String accountTo;

												int choice;
												while (!validInput && flag == 0) {
													System.out.print("Which account would you like to transfer to: ");
													accountTo = msc.nextLine();
													for (Entry<String, Customer> i : hMap.entrySet()) {
														if (accountTo.equals(i.getValue().getUserUsername())) {
															System.out
																	.print("What amount would you like to transfer: ");
															amount = msc.nextDouble();
															if (amount <= 0) {
																System.out.print("Please enter a valid amount: ");
																break;
															} // if value is greater than the amount in the account,
																// return input valid amount
															else if (amount > en.getValue().getBalance()) {
																System.out.println(
																		"Cannot transfer an amount greater than your account balance.");
																System.out.print("Please enter a valid amount: ");
																break;
															} // if the value will cause a balance of 0, return amount
																// would be 0 and confirm
																// they want to withdraw that amount.
															else if ((en.getValue().getBalance() - amount) == 0) {
																System.out.print(
																		"This will cause your account to be left at 0.  Do you want to do this (please select 1 for yes and 0 for no): ");
																choice = msc.nextInt();
																switch (choice) {
																case 1:
																	i.getValue().setBalance(
																			i.getValue().getBalance() + amount);
																	en.getValue().setBalance(
																			en.getValue().getBalance() - amount);
																	System.out.println(
																			"Transfer successful!  You balance is "
																					+ en.getValue().getBalance() + ".");
																	System.out.println(i.getValue().getUserFirstName()
																			+ "'s account balance is now: "
																			+ i.getValue().getBalance() + ".");
																	bankLog.info("User "
																			+ en.getValue().getUserUsername()
																			+ " transferred " + amount + " dollars to "
																			+ i.getValue().getUserUsername()
																			+ " leaving a balance of "
																			+ en.getValue().getBalance() + " dollars.");
																	flag = 1;
																	break;
																case 2:
																	flag = 1;
																	break;
																default:
																	System.out.print(
																			"Invalid input.  Please use 1 for yes and 2 for no: ");
																}
															} else {
																// if value is less than the amount in the account, make
																// transfer successful
																i.getValue()
																		.setBalance(i.getValue().getBalance() + amount);
																en.getValue().setBalance(
																		en.getValue().getBalance() - amount);
																System.out
																		.println("Transfer successful!  You balance is "
																				+ en.getValue().getBalance() + ".");
																System.out.println(i.getValue().getUserFirstName()
																		+ "'s account balance is now: "
																		+ i.getValue().getBalance() + ".");
																bankLog.info("User " + en.getValue().getUserUsername()
																		+ " transferred " + amount + " dollars to "
																		+ i.getValue().getUserUsername()
																		+ " leaving a balance of "
																		+ en.getValue().getBalance() + " dollars.");
																flag = 1;
															}
														}
													}
												}
												flag = 0;
												break;
											case 4:
												customerAccount.viewAccountPro(hMap);
												break;
											case 5:
												flag = 1;
												flag1 = 1;
												break;
											default:
												System.out.print("Not a valid input.  Please enter a valid input: ");
												break;
											}
										}
										flag1 = 0;
									}
								} else if (temp2.equals(en.getValue().getUserUsername())
										&& (en.getValue().getStatus()).equals("pending")) {
									System.out.println("Your account is still awaiting approval.  Please be patient.");
									flag = 1;
								} else if (temp2.equals(en.getValue().getUserUsername())
										&& (en.getValue().getStatus()).equals("cancelled")) {
									System.out.println(
											"Your account has been cancelled.  Please contact an admin if this was an error.");
									flag = 1;
								}
							}
						}
						flag = 0;
						break;
					case 2:
						account2.employeeLogIn(hMap);
						break;
					case 3:
						account3.adminLogIn(hMap);
						break;
					default:
						System.out.print("Not a valid input.  Please enter a valid input: ");
						break;
					}
					break;
				default:
					System.out.print("Not a valid input.  Please enter a valid input: ");
					break;
				}
			}
		}
	}
}
