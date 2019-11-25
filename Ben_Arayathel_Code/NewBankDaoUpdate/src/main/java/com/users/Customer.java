package com.users;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.backend.Account;
import com.backend.AccountManagement;
import com.dao.AccountDao;
import com.dao.AccountDaompl;
import com.frontend.MainDriver;

public class Customer {
	
	final static Logger loggy = Logger.getLogger(Customer.class);

	//access will let the user decide between opening a new account vs logging into a previous account.
	public static void access(Scanner in) throws InputMismatchException{
		System.out.println("Hi there, extemely super duper valued customer.");
		System.out.println("Would you like to access your account[0] or create an account[1]?");
		int input = in.nextInt();
		switch(input) {
		case 0:
			Account account = AccountManagement.getAccount(in);
			if(account == null) {
				break;
			}
			do {
			System.out.println("");
			System.out.println("What would you like to do with your account?");
			System.out.println("[0] Withdraw");
			System.out.println("[1] Deposit");
			System.out.println("[2] Transfer");
			System.out.println("[3] View Balance");
			int input2 = in.nextInt();
			switch(input2) {
			case 0:
				loggy.info("User chose to withdraw");
				withdraw(account, in);
				break;
			case 1:
				loggy.info("User chose to deposit, very nice");
				deposit(account, in);
				break;
			case 2:
				loggy.info("User is transferring money");
				System.out.println("Which account would you like to transfer to?");
				Account account2 = AccountManagement.getAccountTransfer(in);
				System.out.println(account);
				Customer.transfer(account, account2, in);
				System.out.println("what?");
				break;
			case 3:
				loggy.info("User chose to see how rich they are");
				viewBalance(account);
				break;
			default:
				loggy.info("User can't read or type, insufficient data to conclude which.");
				System.out.println("While that is not an invalid option, that doesn't get you anything mate.");
			}
			
			}while(MainDriver.keepinteracting(in,"customer"));
			break;
		case 1:
			System.out.println("Create a single account[0] or a joint account[1]?");
			int input3 = in.nextInt();
			switch(input3) {
			case 0:
				loggy.info("User chose to attempt to create a single account.");
				create(in);
				break;
			case 1:
				loggy.info("User chose to attempt to create a joint account");
				createJoint(in);
				break;
			}
			break;
		default:
			System.out.println("That is not a vaild input, you'll be returned back to the previous menu.");
		}
	}
	
	private static void viewBalance(Account account) {
		System.out.println("Your balance is " + account.getBalance());
	}

	//creates an account
	public static void create(Scanner in) throws InputMismatchException{
		boolean interacting = true;
		while(interacting) {
		System.out.println("Please give us a username:");
		String username = in.next();
		System.out.println("and password: ");
		String password = in.next();
		
		AccountDao news = new AccountDaompl();
		List<Account> tester = news.selectAllAccounts();
		List<String> keyset = new ArrayList<>();
		for(Account i: tester) {
			keyset.add(i.getiD());
		}
		
		if(keyset.contains(username+password)) {
			System.out.println("An account with your details have already been created.");
			System.out.println("You'll be removed from the creation menu");
			loggy.info("User failed in creating account, same username as a previos account");
			interacting = false;
		}else {
		System.out.println("and how much would you like to deposit into your account?");
		Double balance = in.nextDouble();
		Account account = new Account(username, password, username + password, balance);
		AccountManagement.pendingAccounts.add(account);
		loggy.info("Pending account succesfully created by user");
		System.out.println("Congratulations, your account is waiting to be approved by a staff member.");
		interacting = false;
		}
		}
	}
	
	//creates a joint account
	public static void createJoint(Scanner in) throws InputMismatchException{
		System.out.println("Please give us the first username:");
		String username1 = in.next();
		System.out.println("and a password: ");
		String password1 = in.next();
		
		System.out.println("Please give us the second username:");
		String username2 = in.next();
		System.out.println("and a password: ");
		String password2 = in.next();
		
		AccountDao news = new AccountDaompl();
		List<Account> tester = news.selectAllAccounts();
		List<String> keyset = new ArrayList<>();
		for(Account i: tester) {
			keyset.add(i.getiD());
		}
		
		if(keyset.contains(username1+password1)) {
			System.out.println("An account with your details have already been created.");
			System.out.println("You'll be removed from the creation menu");
			loggy.info("User failed in creating account, same username as a previos account");
			
		}else if(keyset.contains(username2 + password2) || (username1+password1 == username2+password2) ){
			System.out.println("An account with your details have already been created.");
			System.out.println("You'll be removed from the creation menu");
			loggy.info("User failed in creating account, same username as a previos account");
		}else {
		
		System.out.println("How much would you like to deposit into your account?");
		Double balance = in.nextDouble();
		//Calling on a different constructor to that of the single account.
		Account account = new Account(username1, password1, username1+password1, username2, password2, username2+password2, balance);
		AccountManagement.pendingAccounts.add(account);
		System.out.println("Congratulations, your joint account is waiting to be approved by a staff member.");}
		
	}
	
	//withdraws from account
	public static void withdraw(Account account,Scanner in) throws InputMismatchException{
		System.out.println("How much would you like to withdraw?");
		double drawl = in.nextDouble();
		if(account.getBalance()>=drawl) {
			account.setBalance(account.getBalance() - drawl);
			System.out.println("Your new account balance is £" + account.getBalance());
			AccountDao news = new AccountDaompl();
			news.updateAccount(account,account.getBalance() - drawl);
			loggy.info("User withdrew £" + drawl + " from " + account.getiD());
		}else if(account.getBalance()<drawl){
			loggy.info("Ha, the user is poor");
			System.out.println("Your account balance is only £" + account.getBalance());
			System.out.println("Please request a lower amount or input 0 if you'd like to cancel your transaction.");
			withdraw(account, in);
		}
	}
	
	//depositing accounts
	public static void deposit(Account account,Scanner in) throws InputMismatchException{
		System.out.println("How much would you like to deposit?");
		double dep = in.nextDouble();
		//account.setBalance(account.getBalance() + dep);
		AccountDao news = new AccountDaompl();
		news.updateAccount(account,account.getBalance() + dep);
		System.out.println("You've deposited into account,  account now has £" + account.getBalance());
		loggy.info("User has deposited in £" + dep + " to " + account.getiD());
	}
	
	//Transferring money between accounts
	public static void transfer(Account account1,Account account2,Scanner in) throws InputMismatchException{
		try {
		System.out.println("How much would you like to transfer to from " + account1.getName() + " to " + account2.getName() + "?");
		double transferAmount = in.nextDouble();
		if((account1.getBalance()-transferAmount) >= 0) {
			account1.setBalance(account1.getBalance()-transferAmount);
			account2.setBalance(account2.getBalance()+transferAmount);
			System.out.println("Transfer is succesful");
			AccountDao news = new AccountDaompl();
			news.updateAccount(account1, account1.getBalance());
			news.updateAccount(account2, account2.getBalance());
			loggy.info("User transferred £" + transferAmount + " from " + account1.getName() + " to " + account2.getName());
		}
		else {
			loggy.info("User unsucessfully attempted to transfer funds");
			System.out.println("Transfer not succesful, insufficient funds, try again or input 0 when prompted for transfer amount to cancel transaction");
			transfer(account1, account2, in);
		}
		
		}catch(Exception e) {
			e.getStackTrace();
		}
		
	}
	
}
