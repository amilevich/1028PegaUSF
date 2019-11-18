package com.projectzerobankapppartone;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class Administrator extends Employee{

	private String username = "admin";
	private String password = "admin";
	static Scanner input = new Scanner(System.in);
	static Administrator adminis = new Administrator();
	final static Logger log = Logger.getLogger(Administrator.class);
	public Administrator() {
		super();
	}
	
	//this method retrieves the Admins username
		public String getUsername() {
			return username;
		}
		//this method retrieves the Admins password
		public String getPassword() {
			return password;
		}
		//this method sets the Admins user name
		public void setUsername(String username) {
			this.username = username;
		}
		//this method sets the Admins password
		public void setPassword(String password) {
			this.password = password;
		}
	public static void AdminSign() {
		System.out.println("Enter Admin username:  ");
		String tempUser = input.next();
		// emp.setUser(input.next(tempUser));
		adminis.getUsername();

		System.out.println("Enter Admin password:  ");
		String temPass = input.next();
		adminis.setPassword(temPass);
		adminis.getPassword();
		if (tempUser.equals("admin") && temPass.equals("admin")) {
			AdminMenu();
		} else {
			System.out.println("Admin user and password are incorect");
		}
		// Employee menu asking Employee to choose
	}
	public static void approveOrDeny() {
		for (Customer g : Account.pendingCustomers) {
			System.out.println(g);
		}
		Scanner accCId = new Scanner(System.in);
		System.out.print("Enter Account ID you which to approve: ");
		String apAcID = accCId.next();
		System.out.println("_______________________________________________________________________");

		for (int j = 0; j < Account.pendingCustomers.size(); j++) {
			if (Account.pendingCustomers.get(j).getActtID().contains(apAcID)) {

				System.out.println(Account.pendingCustomers.get(j).toString().replaceAll("^.|.$", "").replace(", ", "\n"));
				System.out.println("approve ('yes') or ('no') for no");
				String opt = accCId.next();
				if (opt.equals("yes")) {
					Account.pendingCustomers.get(j).setStat("aproved");
					Customer.writeObject(Account.filename, Account.pendingCustomers);
					log.info("admin has approved an account");
				}else {
					Account.pendingCustomers.get(j).setStat("denied");
					Customer.writeObject(Account.filename, Account.pendingCustomers);
					log.info("admin has denied an account");
				}

			}
		}

	}
	public static void AdminMenu() {
		System.out.println(" Choose an option: ");
		System.out.println(" 'a' : View Customers ");
		System.out.println(" 'b' : Approve an account ");
		System.out.println(" 'c' : Deny an account");
		System.out.println(" 'd' : Deposit");
		System.out.println(" 'e' : Withdrawal");
		System.out.println(" 'f' : Transfer");
		System.out.println(" 'g' : Go Back");
		System.out.println(" 'q' : Quit");
		System.out.print(" Enter option here: ");
		char option;
		String input2;
		do {
			input2 = input.next();
			option = input2.charAt(0);
			switch (option) {
			case 'a':
				// view Customers
				for (Customer ct : Account.pendingCustomers) {
					System.out.println(ct);
				}
				break;
			case 'b':
				// approve method
				Administrator.approveOrDeny();
				break;
			case 'c':
				// deny method
				Administrator.approveOrDeny();
				break;
			case 'd':
				System.out.print(" please enter deposit amount: ");
				double amount = input.nextDouble();
				Account.Deposit(amount);
				Scanner accCId = new Scanner(System.in);
				System.out.print("Enter Account ID to save: ");
				String apAcID = accCId.next();
				System.out.println("_______________________________________________________________________");
				Administrator.AdminMenu();
			case 'e':
				System.out.print("please enter withdrawal amount: ");
				double amount2 = input.nextDouble();
				Account.Withdrawal(amount2);
				Administrator.AdminMenu();
				break;
			case 'f':
				Account.Transfer();
				break;
			case 'g':
				// Main Menu
				Customer.writeObject(Account.filename, Account.pendingCustomers);
				AdminMenu();
				break;
			case 'q':
				// quits the program
				Account.bankMenu();
				break;
			default:
				System.out.println("You entered the wrong option");
			}
		} while (option != 'q');
	}
}
