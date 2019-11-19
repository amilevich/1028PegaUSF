package com.users;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.frontend.MainDriver;

public class Customer {

	//access will let the user decide between opening a new account vs logging into a previous account.
	public static void access(Scanner in) throws InputMismatchException{
		System.out.println("Hi there, extemely valued meatbag");
		System.out.println("Would you like to access your account [0] or create an account[1]?");
		int input = in.nextInt();
		switch(input) {
		case 0:
			Account account = AccountManagement.getAccount(in);
			if(account == null) {
				break;
			}
			do {
			System.out.println();
			System.out.println("What would you like to do with your account? Withdraw[0],"
					+ "Deposit[1] or Transfer[2]?");
			int input2 = in.nextInt();
			switch(input2) {
			case 0:
				withdraw(account, in);
				break;
			case 1:
				deposit(account, in);
				break;
			case 2:
				System.out.println("Which account would you like to transfer to?");
				Account account2 = AccountManagement.getAccountTransfer(in);
				transfer(account, account2, in);
				break;
			default:
				System.out.println("While that is not an invalid option, that doesn't get you anything.");
			}
			
			}while(MainDriver.keepinteracting(in,"customer"));
			break;
		case 1:
			System.out.println("A single account[0] or a joint account[1]?");
			int input3 = in.nextInt();
			switch(input3) {
			case 0:
				create(in);
				break;
			case 1:
				createJoint(in);
				break;
			}
			break;
		default:
			System.out.println("That is not a vaild input, you'll be returned back to the main menu.");
		}
	}
	
	//creates an account
	public static void create(Scanner in) throws InputMismatchException{
		System.out.println("Please give us a username:");
		String username = in.next();
		//if(AccountManagement.storageAccount)
		System.out.println("and password: ");
		String password = in.next();
		System.out.println("and how much would you like to deposit into your account?");
		Double balance = in.nextDouble();
		Account account = new Account(username, password, username + password, balance);
		
		AccountManagement.pendingAccounts.add(account);
		System.out.println("Congratulations, your account is waiting to be approved by a staff member.");
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
		
		System.out.println("How much would you like to deposit into your account?");
		Double balance = in.nextDouble();
		
		Account account = new Account(username1, password1, username1+password1, username2, password2, username2+password2, balance);
		AccountManagement.pendingAccounts.add(account);
		System.out.println("Congratulations, your joint account is waiting to be approved by a staff member.");
		
	}
	
	//withdraws from account
	public static void withdraw(Account account,Scanner in) throws InputMismatchException{
		System.out.println("How much would you like to withdraw?");
		double drawl = in.nextDouble();
		if(account.getBalance()>=drawl) {
			account.setBalance(account.getBalance() - drawl);
			System.out.println("Your new account balance is �" + account.getBalance());

		}else if(account.getBalance()<drawl){
			System.out.println("Your account balance is only �" + account.getBalance());
			System.out.println("Please request a lower amount or input 0 if you'd like to cancel your transaction.");
			withdraw(account, in);
		}
	}
	
	//depositing accounts
	public static void deposit(Account account,Scanner in) throws InputMismatchException{
		System.out.println("How much would you like to deposit?");
		double dep = in.nextDouble();
		account.setBalance(account.getBalance() + dep);
		System.out.println("You've deposited into your account, you account is now �" + account.getBalance());
	}
	
	//Transferring money between accounts
	public static void transfer(Account account1,Account account2,Scanner in) throws InputMismatchException{
		try {
		System.out.println("How much would you like to transfer to from " + account1.getName() + " to " + account2.getName() + "?");
		double transferAmount = in.nextDouble();
		if((account1.getBalance()-transferAmount) >= 0) {
			account1.setBalance(account1.getBalance()-transferAmount);
			account2.setBalance(account2.getBalance()+transferAmount);
			System.out.println("Transfer is succesful");}
		else {
			System.out.println("Transfer not succesful, try again or input 0 when prompted for transfer amount to cancel transaction");
			transfer(account1, account2, in);
		}}catch(Exception e) {
			e.getStackTrace();
		}
		
	}
	
}