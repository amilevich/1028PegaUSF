package com.users;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.backend.Account;
import com.backend.AccountManagement;
import com.frontend.MainDriver;

public class BankAdmin extends Customer {
	
	final static Logger loggy = Logger.getLogger(BankAdmin.class);
	
	//Hard coded ID for admin
	static String bankUser = "b";
	static String bankPass = "b";
	//This method verifies the login features of the account
	public static void employeeLogin(Scanner in) throws InputMismatchException{
		System.out.println("Hello Admin, please input your credentials");
		System.out.println("Username: ");
		String username = in.next();
		System.out.println("Password: ");
		String password = in.next();
		if (bankUser.contentEquals(username) && bankPass.contentEquals(password)) {
			loggy.info("User successfully logged in as an admin");
			access(in);
			loggedInMenu(in);
		}else{
			loggy.info("The user failed to hack the admin profile, what a loser");
			System.out.println("Incorrect login credentials");}
	}
	//THis method will showcase what the employee can do and gives access to the methods within the class.
	public static void loggedInMenu(Scanner in) throws InputMismatchException{
		System.out.println("Well done, you can follow basic protocol.");
		do {
		System.out.println("What would you like to do?");
		System.out.println("[0] Steal from an account");
		System.out.println("[1] Deposit, for some reason.");
		System.out.println("[2] Transfer money around");
		System.out.println("[3] Become omniscient and view all the secrets");
		System.out.println("[4] Become death, the destroyer of accounts.");
		System.out.println("[5] Approve pending accounts.");
		
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
			break;
		default:
			System.out.println("That is not a vaild input.");
		}}while(MainDriver.keepinteracting(in, "Bank Admin"));
	}
	//This method returns a set of keys for the Admin to access the accounts with
	public static void access(Scanner in) throws InputMismatchException{
		System.out.println("Here are the keys to access everyones accounts.");
		System.out.println(AccountManagement.storageAccount.keySet().toString());
	}
	//This method removes accounts.
	public static void removeAccounts(Account account) throws InputMismatchException{
		AccountManagement.storageAccount.remove(account.getiD());
		System.out.println("Account removed.");
		System.out.println("Don't let the power get to your head. You're only this powerful within MY app.");
		loggy.info(account.getName() + " has been removed from the bank");
	}

}
