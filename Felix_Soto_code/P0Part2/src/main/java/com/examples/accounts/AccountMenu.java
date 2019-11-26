package com.examples.accounts;

import java.util.List;
import java.util.Scanner;

import com.examples.customers.Customers;
import com.examples.customers.CustomersMenu;
import com.examples.dao.AccountsDaoImpl;
import com.examples.dao.CustomersDaoImpl;
import com.examples.employeemenu.EmpMenu;
import com.examples.menu.MainMenu;
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
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n");
		System.out.println("What would you like to do?");
		
		System.out.println("Press 1 to check your balance");
		System.out.println("Press 2 to make a deposit");
		System.out.println("Press 3 to make a Withdraw");
		System.out.println("Press 4 to exit");
		
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
				System.out.println("Enter an amount to deposit: ");
				Deposit(custList, customerID);

				break;
				
			case 3:
				System.out.println("Enter an amount to withdraw: ");
				Withdraw(custList,customerID);
				
				System.out.println("Your balance now is: $"  + c.getBal());
				System.out.println("\n");
				break;
				
			case 4:
				System.out.println("Logging out. . .");
            	MainMenu.menu();
				break;
				
				default:
				System.out.println("Invalid option! Please enter a valid option");
				
			}
			
		}while(option != 5);
		
		System.out.println("Thank You. Have a nice day!");
		
	}// end banking menu
	
	//  withdraw
	static public void Withdraw(List<Customers> custList, int customerID) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int amount1 = sc.nextInt();
		
		if(amount1 > 0) {
				for(Customers i : custList) {
					System.out.println(i);
				System.out.println(c.getCustID());
				if(c.getCustID() == customerID) {
				
					c.setBal(c.getBal() - amount1);
					System.out.println("The amount of $" + amount1 + " was succesfully withdraw");
					cusDao.updateCustomers(i);
					//cust.writeCustObject(filename, CustomersList);
					System.out.println("Your balance  is $: " + c.getBal());
				}
		}
		
	}
//	
	
	}//end withdraw
	
	// Deposit method
	static public void Deposit() {
		Accounts acct = new Accounts();
		Scanner cs = new Scanner(System.in);
		CustomersMenu cm = new CustomersMenu();
		EmpMenu empl = new EmpMenu();
		int amount = 0;
		
		System.out.println("Enter your account id: ");
		int acid = input.nextInt();
		acct = AccountsDaoImpl.getAccountById(acid);
		System.out.println("Enter the amount you want to deposit: ");
		
			}
		}
		
	}
//	
	
	}

}// end class
