package com.accounts;

import java.util.List;
import java.util.Scanner;

import com.customers.Customers;
import com.daos.AccountsDaoImpl;
import com.daos.CustomersDaoImpl;
import com.employee.Employee;
import com.mainmenu.MainMenu;
public class AccountMenu {
	
	static AccountsDaoImpl accDao = new AccountsDaoImpl();
	static CustomersDaoImpl cusDao = new CustomersDaoImpl();
	static List<Customers> custList = cusDao.selectAllCustomers();
	static Accounts a = new Accounts();
	static Customers c = new Customers();
	static int customerID;
	public static void bankingMenu(int acco) {
		int option;
		//double balance = cust.getBal();
		Scanner scanner = new Scanner(System.in);
		do {
		System.out.println("\n");
		System.out.println("What would you like to do? ");
		
		System.out.println("1. Transfer money ");
		System.out.println("2. Make a deposit ");
		System.out.println("3. Withdraw");
		System.out.println("4. View your balance");
		System.out.println("5. Exit");
		
		 
			System.out.println("=============================================================");
			System.out.println("What would you like to do next ? Please select an opction ");
			System.out.println("=============================================================");
			option = scanner.nextInt();
			System.out.println("\n");
			
			switch(option) {
			
			case 1:
				
				transfer();
				break;
	
				
			case 2:
				Deposit();

				break;
				
			case 3:
				Withdraw();

				break;
				
			case 4:
				vewBalance(acco);
				break;
				
			case 5:
				System.out.println("Login Out");
            	MainMenu.mainMenu();
				System.out.println("=============================================");
				break;
				
				default:
				System.out.println("Invalid option!! Please enter a valid option ");
				
			}
			
		}while(option != 5);
		
		System.out.println("Thank You for using our sevices!! ");
		
	}// end banking menu
	
	//  withdraw
	
	// Deposit method
	static public void Deposit() {
		Accounts account = new Accounts();
		AccountsDaoImpl  accDao = new AccountsDaoImpl(); 
		Scanner sc = new Scanner(System.in);
		int amount = 0;
		System.out.println("Please enter your account ID to deposit:");
		int acid = sc.nextInt();
		account = accDao.selectAccountsByAccountID(acid);
		System.out.println();
		System.out.println("Please enter the amount you want to deposit: ");
		amount = sc.nextInt();
		account.setBalance(amount + account.getBalance());
		accDao.updateAccounts(account);
		System.out.println("The amount of $ " + amount + " has been deposited!!");
			
	
	}// end deposit
	
	
	static public void Withdraw() {
		Accounts account = new Accounts();
		AccountsDaoImpl  accDao = new AccountsDaoImpl(); 
		Scanner sc = new Scanner(System.in);
		int amount = 0;
		System.out.println("Please enter your account ID to withdraw :");
		int acid = sc.nextInt();
		account = accDao.selectAccountsByAccountID(acid);
		System.out.println();
		System.out.println("Please enter the amount you want to withdraw: ");
		amount = sc.nextInt();
		account.setBalance(account.getBalance()- amount);
		accDao.updateAccounts(account);
		System.out.println("The amount of $ " + amount + " has been withdrawn!!");
			
	
	}// end withdraw
	
	
	public static void transfer() {
		AccountsDaoImpl accDao = new AccountsDaoImpl();
		Accounts acctransf = new Accounts();
		Accounts acctransf1 = new Accounts();
		Scanner sc = new Scanner(System.in);
		Customers  cust = new Customers();
		Employee empl = new Employee();
		int amount = 0;
		System.out.println("Please enter your account ID: ");
		int accID = sc.nextInt();
		acctransf  = accDao.selectAccountsByAccountID(accID);
		System.out.println();
		System.out.println("Please now enter the account ID you want to transfer to: ");
		int accID2 = sc.nextInt();
		acctransf1 = accDao.selectAccountsByAccountID(accID2);
		System.out.println();
		System.out.println("OK, now please enter the amount you want to transfer: ");
		amount = sc.nextInt();
		acctransf1.setBalance(amount);
		acctransf.setBalance(acctransf.getBalance() - amount);
		accDao.updateAccounts(acctransf);
		accDao.updateAccounts(acctransf1);
		System.out.println("The amount of $" + amount + " has been transfered to " + accID2);
	}// end transfer
	
public static void vewBalance(int accountID) {
	AccountsDaoImpl viewBal = new AccountsDaoImpl();
	Accounts accbal = new Accounts();
	accbal = viewBal.selectAccountsByAccountID(accountID);
	accbal.getBalance();
	System.out.println("Your current balance is: $" + accbal.getBalance());
}

}// end class
