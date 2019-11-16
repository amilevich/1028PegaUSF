package com.users;

import java.util.Scanner;

public class BankAdmin extends Customer {
	
	//Hard coded ID for admin
	static String bankUser = "b";
	static String bankPass = "b";
	
	//This method verifies the login features of the account
		public static void employeeLogin(Scanner in) {
			System.out.println("Hello Employee, please input your credentials");
			System.out.println("Username: ");
			String username = in.next();
			System.out.println("Password: ");
			String password = in.next();
			if (bankUser.contentEquals(username) && bankPass.contentEquals(password)) {
				access(in);
				loggedInMenu(in);
			}else{
				System.out.println("Incorrect login credentials");}
		}
		
		//THis method will showcase what the employee can do and gives access to the methods within the class.
		public static void loggedInMenu(Scanner in) {
			
			System.out.println("Well done, you can follow basic protocol.");
			System.out.println("What would you like to do? "
					+ "Steal from an account [0]?"
					+ "Deposit...why is this even option?[1]"
					+ "Transfer money around?[2]"
					+ "Become omniscient?[3]"
					+ "Become death, the destroyer of accounts?[4]");
			int options = in.nextInt();
			in.nextLine();
			System.out.println("Which account would you like play around with?");
			String key = in.nextLine();
			in.nextLine();
			Account account = AccountManagement.storageAccount.get(key);
			switch(options) {
			case 0:
				withdraw(account, in);
				break;
			case 1:
				deposit(account, in);
				break;
			case 2:
				System.out.println("Which account would you like to transfer to?");
				Account account2 = AccountManagement.getAccountTransfer(in);
				transfer(account,account2, in);
				break;
			case 3:
				Employee.getSecrets(in);
				break;
			case 4:
				removeAccounts(account);
				break;
			case 5:
				Employee.approveAccounts();
			case 6:
				System.out.println("Thank you for using this amazingly developed menu.");
				break;
			}
		}
		
	
	
	
	public static void access(Scanner in) {
		System.out.println("Here are the keys to access everyones most intimate secrets.");
		System.out.println(AccountManagement.storageAccount.keySet().toString());
	}
	
	public static void removeAccounts(Account account) {
		AccountManagement.storageAccount.remove(account.getiD());
		System.out.println("Account removed.");
		System.out.println("Don't let the power get to your head.");
	}
	

}
