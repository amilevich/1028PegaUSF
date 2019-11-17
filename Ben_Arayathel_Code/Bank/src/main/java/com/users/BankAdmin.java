package com.users;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.frontend.MainDriver;

public class BankAdmin extends Customer {
	//Hard coded ID for admin
	static String bankUser = "b";
	static String bankPass = "b";
	//This method verifies the login features of the account
	public static void employeeLogin(Scanner in) throws InputMismatchException{
		System.out.println("Hello Employee, please input your credentials");
		System.out.println("Username: ");
		String username = in.next();
		System.out.println("Password: ");
		String password = in.next();
		if (bankUser.contentEquals(username) && bankPass.contentEquals(password)) {
			boolean interacting = true;
			do {
			access(in);
			loggedInMenu(in);
			interacting = MainDriver.keepinteracting(in, "Admin");
			}while(interacting);
		}else{
			System.out.println("Incorrect login credentials");}
	}
	//THis method will showcase what the employee can do and gives access to the methods within the class.
	public static void loggedInMenu(Scanner in) throws InputMismatchException{
		System.out.println("Well done, you can follow basic protocol.");
		System.out.println("What would you like to do? "
				+ "Steal from an account [0]?"
				+ "Deposit...why is this even option?[1]"
				+ "Transfer money around?[2]"
				+ "Become omniscient?[3]"
				+ "Become death, the destroyer of accounts?[4]");
		int options = in.nextInt();
		switch(options) {
		case 0:
			System.out.println("Which account would you like play around with?");
			String key = in.next();
			Account account = AccountManagement.storageAccount.get(key);
			withdraw(account, in);
			break;
		case 1:
			System.out.println("Which account would you like play around with?");
			String key1 = in.next();
			Account account1 = AccountManagement.storageAccount.get(key1);
			deposit(account1, in);
			break;
		case 2:
			System.out.println("Which account would you like play around with?");
			String key2 = in.next();
			Account account2 = AccountManagement.storageAccount.get(key2);
			System.out.println("Which account would you like to transfer to?");
			Account account3 = AccountManagement.getAccountTransfer(in);
			transfer(account2,account3, in);
			break;
		case 3:
			Employee.getSecrets(in);
			break;
		case 4:
			System.out.println("Which account would you like play around with?");
			String key3 = in.next();
			Account account4 = AccountManagement.storageAccount.get(key3);
			removeAccounts(account4);
			break;
		case 5:
			Employee.approveAccounts(in);
		case 6:
			System.out.println("Thank you for using this amazingly developed menu.");
			break;
		}
	}

	public static void access(Scanner in) throws InputMismatchException{
		System.out.println("Here are the keys to access everyones most intimate secrets.");
		System.out.println(AccountManagement.storageAccount.keySet().toString());
	}
	public static void removeAccounts(Account account) throws InputMismatchException{
		AccountManagement.storageAccount.remove(account.getiD());
		System.out.println("Account removed.");
		System.out.println("Don't let the power get to your head.");
	}

}
