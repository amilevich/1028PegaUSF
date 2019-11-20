package bankapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import users.Account;

public class BankApp {
	
	public static List<Account> pendingAccounts = new ArrayList<Account>(); 
	public static Map<String, Account> approvedAccounts = new HashMap<String,Account>();

	// GETS DATA FROM HASHMAP, CREATES ID, RETURNS IT OR ELSE ~ RECIBE DATOS DE HASHMAP, CREA ID, DEVUELVE LA ID O OTRA MODA 
	public static Account getAccount(Scanner in) throws InputMismatchException{
		System.out.println("Please provide a username:");
		String username = in.nextLine();
		System.out.println("Please provide a password: ");
		String password = in.nextLine();
		String id = username + password;
		
		if(BankApp.approvedAccounts.keySet().contains(id)) {
			return approvedAccounts.get(id);
		}else {
			System.out.println("Account not found");
			return null;
		}

	}
	//
	public static Account getTransfer(Scanner in) throws InputMismatchException {
		System.out.println("Please provide the account username ");
		in.nextInt();
		String accountName = in.nextLine();
		Account account;
		for(String i:BankApp.approvedAccounts.keySet()) {
			if(i.contains(accountName)) {
				account = BankApp.approvedAccounts.get(i);
				return account;
			}
		}
		System.out.println("Account not found");
		return null;
	}
}