package com.examples.accounts;

import java.util.List;
import java.util.Scanner;

import com.examples.customers.Customers;
import com.examples.dao.AccountsDaoImpl;
import com.examples.dao.CustomersDaoImpl;
import com.examples.menu.MainMenu;
public class AccountMenu {
	
	static AccountsDaoImpl accDao = new AccountsDaoImpl();
	static CustomersDaoImpl cusDao = new CustomersDaoImpl();
	static List<Customers> custList = cusDao.selectAllCustomers();
	static Accounts a = new Accounts();
	static Customers c = new Customers();
	static int customerID;
	public static void bankingMenu(int parr) {
			
		int option;		
		@SuppressWarnings("resource")
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("\n");
		System.out.println("What would you like to do?");
		
		System.out.println("Press 1 to make a deposit");
		System.out.println("Press 2 to make a Withdraw");
		System.out.println("Press 3 to make a transfer with another account");
		System.out.println("Press 4 to logout");
		
		do {
			option = scanner1.nextInt();
			System.out.println("\n");
			
			switch(option) {
				
			case 1:
				Deposit();

				break;
				
			case 2:
				Withdraw();
				break;
			
			case 3:
				transfer();
				
			case 4:
				System.out.println("Logging out. . .");
            	MainMenu.menu();
				break;
				
				default:
				System.out.println("Invalid option! Please enter a valid option");
				
			}
			
		}while(option != 4);
		
		System.out.println("Thank You. Have a nice day!");
		
	}// end banking menu
	
	static public void Withdraw() {
		Accounts account = new Accounts();
		AccountsDaoImpl  accDao = new AccountsDaoImpl();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int amount = 0;
		System.out.println("Please enter your account ID:");
		int acid = sc.nextInt();
		account = accDao.selectAccountsByAccountID(acid);
		System.out.println();
		System.out.println("Please enter the amount you want to withdraw: ");
		amount = sc.nextInt();
		account.setBalance(account.getBalance()- amount);
		
		if (account.getBalance() < amount) {
			System.out.println("You don't have enough funds to withdraw.");
			System.out.println();
			
			System.out.println("Logging back into account . . .");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			AccountsDaoImpl acct = new AccountsDaoImpl();
			System.out.println("Please enter your account ID");
			int accID = scanner.nextInt();
		    Accounts acc = new Accounts();
		    acc = acct.selectAccountsByAccountID(accID);
		    System.out.println("=====================================================================================================================================================================================");
		    System.out.println("                                                    Customer details");
		    System.out.println(acc);
		    System.out.println("=====================================================================================================================================================================================");

			bankingMenu(0);
		}else {
			
		accDao.updateAccounts(account);
		System.out.println("$" + amount + " has been withdrawn from your account");
		
		System.out.println("Logging back into account . . .");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		AccountsDaoImpl acct = new AccountsDaoImpl();
		System.out.println("Please enter your account ID");
		int accID = scanner.nextInt();
	    Accounts acc = new Accounts();
	    acc = acct.selectAccountsByAccountID(accID);
	    System.out.println("=====================================================================================================================================================================================");
	    System.out.println("                                                    Customer details");
	    System.out.println(acc);
	    System.out.println("=====================================================================================================================================================================================");

		bankingMenu(0);
	}
}
	// Deposit method
		static public void Deposit() {
			Accounts account = new Accounts();
			AccountsDaoImpl  accDao = new AccountsDaoImpl();
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			int amount = 0;
			System.out.println("Please enter your account ID: ");
			int acid = sc.nextInt();
			account = accDao.selectAccountsByAccountID(acid);
			System.out.println();
			System.out.println("Please enter the amount you want to deposit: ");
			amount = sc.nextInt();
			account.setBalance(amount + account.getBalance());
			accDao.updateAccounts(account);
			System.out.println("$" + amount + " have been deposited into your account");
			
			
			System.out.println("Logging back into account . . .");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			AccountsDaoImpl acct = new AccountsDaoImpl();
			System.out.println("Please enter your account ID");
			int accID = scanner.nextInt();
		    Accounts acc = new Accounts();
		    acc = acct.selectAccountsByAccountID(accID);
		    System.out.println("=====================================================================================================================================================================================");
		    System.out.println("                                                    Customer details");
		    System.out.println(acc);
		    System.out.println("=====================================================================================================================================================================================");

			bankingMenu(0);
		}
	
	public static void transfer() {
		AccountsDaoImpl accDao = new AccountsDaoImpl();
		Accounts acctransf = new Accounts();
		Accounts acctransf1 = new Accounts();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int amount = 0;
		System.out.println("Please enter your account ID: ");
		int accID = sc.nextInt();
		acctransf  = accDao.selectAccountsByAccountID(accID);
		System.out.println();
		System.out.println("Please now enter the account ID you want to transfer to: ");
		int accID2 = sc.nextInt();
		acctransf1 = accDao.selectAccountsByAccountID(accID2);
		System.out.println();
		System.out.println("OK, now please enter the amount to be transfered");
		amount = sc.nextInt();
		acctransf1.setBalance(amount);
		acctransf.setBalance(acctransf.getBalance() - amount);
		if (acctransf.getBalance() < amount) {
			System.out.println("You don't have enough funds to transfer");
			System.out.println();

			System.out.println("Logging back into account . . .");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			AccountsDaoImpl acct = new AccountsDaoImpl();
			System.out.println("Please enter your account ID");
			int accID1 = scanner.nextInt();
		    Accounts acc = new Accounts();
		    acc = acct.selectAccountsByAccountID(accID1);
		    System.out.println("=====================================================================================================================================================================================");
		    System.out.println("                                                    Customer details");
		    System.out.println(acc);
		    System.out.println("=====================================================================================================================================================================================");
		  
		    bankingMenu(0);
			
		}else {
		accDao.updateAccounts(acctransf);
		accDao.updateAccounts(acctransf1);
		System.out.println("The amount of $" + amount + " has been transfered to " + accID2);
		
		System.out.println("Logging back into account . . .");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		AccountsDaoImpl acct = new AccountsDaoImpl();
		System.out.println("Please enter your account ID");
		int accID1 = scanner.nextInt();
	    Accounts acc = new Accounts();
	    acc = acct.selectAccountsByAccountID(accID1);
	    System.out.println("=====================================================================================================================================================================================");
	    System.out.println("                                                    Customer details");
	    System.out.println(acc);
	    System.out.println("=====================================================================================================================================================================================");

	    bankingMenu(0);		
		}
	}
}