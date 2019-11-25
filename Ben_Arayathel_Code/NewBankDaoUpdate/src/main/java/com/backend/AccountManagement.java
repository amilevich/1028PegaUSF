package com.backend;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.dao.AccountDao;
import com.dao.AccountDaompl;

public class AccountManagement {
	
	public static List<Account> pendingAccounts = new ArrayList<Account>(); // Stores pending accounts
	//public static Map<String, Account> storageAccount = new HashMap<String,Account>();// Stores approved accounts in a HashMap.

	//Method to pull an object from the stored Accounts
	public static Account getAccount(Scanner in) throws InputMismatchException{
		System.out.println("Please give us a username:");
		String username = in.next();
		System.out.println("and the password to the account: ");
		String password = in.next();
		String id = username + password;
		AccountDao news = new AccountDaompl();
		if(news.selectAccountByName(id) == null) {
			System.out.println("An account with those login credentials don't exist.");
			return null;
		}else {
			return news.selectAccountByName(id);
		}
//		if(AccountManagement.storageAccount.keySet().contains(id)) {
//			return storageAccount.get(id);
//		}else {
//			System.out.println("Account does not exist.");
//			return null;
//		}

	}
	//Unique method for transferring between Accounts
	public static Account getAccountTransfer(Scanner in) throws InputMismatchException {
		System.out.println("please give us the username of the account.");
		in.nextLine();
		String accountName = in.nextLine();
		Account account;
		
		AccountDao news = new AccountDaompl();
		List<Account> tester = news.selectAllAccounts();
		List<String> keyset = new ArrayList<>();
		for(Account i: tester) {
			keyset.add(i.getiD());
		}
		
		
		for(String i:keyset) {
			if(i.contains(accountName)) {
				account = news.selectAccountByName(i);
				System.out.println(i.toString());
				
				return account;
			}
		}
		System.out.println("Account not found");
		return null;
	}
}
