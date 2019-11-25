package com.accounts;

import java.util.List;
import java.util.Scanner;

import com.customers.Customers;
import com.customers.dao.AccountsDaoImpl;
import com.customers.dao.CustomersDaoImpl;
import com.mainmenu.MainMenu;
public class AccountMenu {
	
	static AccountsDaoImpl accDao = new AccountsDaoImpl();
	static CustomersDaoImpl cusDao = new CustomersDaoImpl();
	static List<Customers> custList = cusDao.selectAllCustomers();
	static Accounts a = new Accounts();
	static Customers c = new Customers();
	static int customerID;
	public static void bankingMenu() {
		int option;
		//double balance = cust.getBal();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n");
		System.out.println("What would you like to do? ");
		
		System.out.println("1. Check your balance ");
		System.out.println("2. Make a deposit ");
		System.out.println("3. Withdraw");
		System.out.println("4. See your previous transaction");
		System.out.println("5. Exit");
		
		do {
			System.out.println("=============================================================");
			System.out.println("What would you like to do next ? Please select an opction ");
			System.out.println("=============================================================");
			option = scanner.nextInt();
			System.out.println("\n");
			
			switch(option) {
			
			case 1:
				System.out.println(accDao.selectAccountsByAccountID(2020));
				for(Customers i : custList) {
				if(	i.getUserName().equals(c.getUserName())) {
					System.out.println("---------------------------------");
					System.out.println("Your Balance is:  " + "$" +  i.getBal());
					System.out.println("----------------------------------");
					System.out.println("\n");
				}
				}
				break;
	
				
			case 2:
				System.out.println("-----------------------------------");
				System.out.println("Enter an amount to deposit: ");
				System.out.println("------------------------------------");
				Deposit(custList, customerID);

				break;
				
			case 3:
				System.out.println("--------------------------------------");
				System.out.println("Enter an amount to withdraw: ");
				System.out.println("---------------------------------------");
				Withdraw(custList,customerID);
				
				System.out.println("Your balance now is: $"  + c.getBal());
				System.out.println("\n");
				break;
				
			case 4:
//				System.out.println("----------------------------------------");
//				previousTransaction();
//				System.out.println("-----------------------------------------");
//				System.out.println("\n");
//				break;
				
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
	static public void Withdraw(List<Customers> custList, int customerID) {
		Scanner sc = new Scanner(System.in);
		int amount1 = sc.nextInt();
		
		if(amount1 > 0) {
				for(Customers i : custList) {
					System.out.println(i);
				System.out.println(c.getCustID());
				if(c.getCustID() == customerID) {
				
					c.setBal(c.getBal() - amount1);
					System.out.println("The amount of $" + amount1 + " was succesfully deposited!");
					cusDao.updateCustomers(i);
					//cust.writeCustObject(filename, CustomersList);
					System.out.println("Your balance  is $: " + c.getBal());
				}
		}
		
	}
//	
	
	}//end withdraw
	
	// Deposit method
	static public void Deposit(List<Customers> custList, int customerID) {
		Scanner sc = new Scanner(System.in);
		int amount1 = sc.nextInt();
		
		if(amount1 > 0) {
				for(Customers i : custList) {
					System.out.println(i);
				System.out.println(c.getCustID());
				if(c.getCustID() == customerID) {
				
					c.setBal(c.getBal() + amount1);
					System.out.println("The amount of $" + amount1 + " was succesfully deposited!");
					cusDao.updateCustomers(i);
					//cust.writeCustObject(filename, CustomersList);
					System.out.println("Your balance  is $: " + c.getBal());
				}
		}
		
	}
//	
	
	}

}// end class
