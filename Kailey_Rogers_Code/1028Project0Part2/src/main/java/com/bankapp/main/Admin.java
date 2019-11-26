package com.bankapp.main;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class Admin extends Account {

	public Admin(int accID, double balance, String type, String status) {
		super(accID, balance, type, status);
		// TODO Auto-generated constructor stub
	}
	
	public Admin() {
	}

	private String adminUsername = "admin";
	private String adminPassword = "password";
	public static final boolean validInput = false;
	public static int flag = 0;
	public static int flag1 = 0;

	// Getters and Setters
	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	// Admin Login
	public void adminLogIn(HashMap<String, Customer> hMap) {
		Scanner cls = new Scanner(System.in);
		Account cLog = new Account();

		// get username
		String temp;
		while (!validInput && flag == 0) {
			System.out.println("\n");
			System.out.print("Please enter your username: ");
			temp = cls.nextLine();
			// If username matches
			if (temp.equals(adminUsername)) {
				System.out.print("Please enter your password: ");
				temp = cls.nextLine();

				// if password matches
				if (temp.equals(adminPassword)) {
					Account adminAccount = new Account();
					double temp3;
					int temp2;
					while (!validInput && flag1 == 0) {
						System.out.println("\n");
						System.out.println("Welcome to the admin portal.  Here are your options:");
						System.out.println("1 deposit");
						System.out.println("2 withdraw");
						System.out.println("3 transfer");
						System.out.println("4 view account info");
						System.out.println("5 edit account info");
						System.out.println("6 accounts needing approval");
						System.out.println("7 cancel an account");
						System.out.println("8 return to main menu");
						System.out.print("What would you like to do: ");
						while (!validInput) {
							try {String input = cls.nextLine();
							temp2 = Integer.valueOf(input);
							break;
							}catch(Exception e){
								System.out.println("Please enter a valid number.");
							}
						}

						switch (temp2) {
						case 1:
							adminAccount.depositPro(hMap);
							break;
						case 2:
							adminAccount.withdrawPro(hMap);
							break;
						case 3:
							adminAccount.transferPro(hMap);
							break;
						case 4:
							adminAccount.viewAccountPro(hMap);
							break;
						case 5:
							adminAccount.editAccountPro(hMap);
							break;
						case 6:
							adminAccount.accountApprovePro(hMap);
							break;
						case 7:
							adminAccount.accountCancelPro(hMap);
							break;
						case 8:
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
			}
		}
		flag = 0;
	}
}