package com.frontend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AccountManagement {
	
	public static List<Account> pendingAccounts = new ArrayList<Account>(); // Stores pending accounts
	public static Map<String, Account> storageAccount = new HashMap<String,Account>();// Stores approved accounts in a HashMap.

	//Method to pull an object from the stored Accounts
	public static Account getAccount(Scanner in) throws InputMismatchException{
		System.out.println("Please give us a username:");
		String username = in.next();
		System.out.println("and the password to the account: ");
		String password = in.next();
		String id = username + password;
		if(AccountManagement.storageAccount.keySet().contains(id)) {
			return storageAccount.get(id);
		}else {
			System.out.println("Account does not exist.");
			return null;
		}

	}
	//Unique method for transferring between Accounts
	public static Account getAccountTransfer(Scanner in) throws InputMismatchException {
		System.out.println("please give us the username of the account.");
		in.nextLine();
		String accountName = in.nextLine();
		Account account;
		for(String i:AccountManagement.storageAccount.keySet()) {
			if(i.contains(accountName)) {
				account = AccountManagement.storageAccount.get(i);
				return account;
			}
		}
		System.out.println("Account not found");
		return null;
	}
}

