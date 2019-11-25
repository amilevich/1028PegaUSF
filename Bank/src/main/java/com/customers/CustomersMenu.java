package com.customers;

import java.util.Scanner;

import com.accounts.AccountMenu;
import com.accounts.Accounts;
import com.customers.dao.AccountsDaoImpl;
import com.customers.dao.CustomersDaoImpl;
import com.mainmenu.MainMenu;

public class CustomersMenu {
	
	public static void Registration() {
		Scanner input = new Scanner(System.in);
		int option;
		int counter =0;

		Customers cust = new Customers();
		System.out.println("________________________________________________________________________________");
		System.out.println("|                       Welcome to our Bank!! (-.-)                             |");
		System.out.println("|_______________________________________________________________________________|");
		System.out.println("Type 1. to register for a single account");
		System.out.println("Type 2. to register for a joint account");
		option = input.nextInt();
		if (option == 1) {
			counter++;
			
				System.out.println("Please enter user first name: " + counter);
				cust.setCustFname(input.next());
//				String temp = input.next();
//				cust.setCustFname(temp);
//				try {
//					Integer.valueOf(temp);
//					System.out.println("SORRY!! That is an invalid input!!(only contain letters)");
//					continue;
//				} catch (Exception e) {
//					break;
//				}
			
			// get lastname and print out
			
				System.out.println("Please enter your last name: " + counter);
				cust.setCustLname(input.next());
//				String temp = input.next();
//				cust.setCustLname(temp);
//				try {
//					Integer.valueOf(temp);
//					System.out.println("SORRY!! That is an invalid input!! (only contain letters)");
//					continue;
//				} catch (Exception e) {
					
				
				
			// end while loop
			// asking Customer to create a username
			while (true) {
				System.out.println();
				System.out.println("Awesome " + cust.getCustFname() + " " + cust.getCustLname());
				System.out.println();
				System.out.println("Please create a user name:");
				System.out.println("Your user name should be between 5 & 10 characters!");
				System.out.println();
				cust.setUserName(input.next());
				if (cust.getUserName().length() > 5 && cust.getUserName().length() <= 10) {
					System.out.println("Nice!! Your user name was created!!");
					System.out.println();
					break;
				} else {

					System.out.println("SORRY!! Your user name must be 5 or 10 characters long");
					System.out.println();
				}
				// Asking customer to create password
				
			}// end user name while loop
			
			
			while (true) {

				System.out.println("Please create a password:");
				System.out.println("Your password should not contain no more than 10 characters!");
				System.out.println();
				cust.setPassword(input.next());
				if (cust.getPassword().length() > 5 && cust.getPassword().length() <= 10) {
					System.out.println("Nice!! Your password was created!!");
					System.out.println();
					break;
				} else {

					System.out.println("SORRY!! Your password must be 5 or 10 characters long");
					System.out.println();
				
				}
			}// end pass while loop
			
			 System.out.println("Your ID is: " + cust.getCustID());
			 System.out.println();
			 System.out.println("Congratulations!! " + cust.getCustFname() + ", Your account has been created!!");
			 System.out.println("The status of your account is: " + cust.getStatus());
			 System.out.println();
//			 cust.serializedCustomer(CustomersList);
			 CustomersDaoImpl  custImpl = new CustomersDaoImpl();
			 custImpl.insertCustomers(cust);
			 Accounts newacc = new  Accounts();
			 Scanner sc = new Scanner(System.in);
				System.out.println("Your account id will be: " + newacc.getAccID());
				int bal = 0;
				newacc.setCustID(cust.getCustID());
				newacc.setBalance(bal);
				newacc.setStatus(cust.getStatus());
				newacc.setBalance(cust.getBal());
				newacc.setAccCustFname(cust.getCustFname());
				newacc.setAccCustLname(cust.getCustLname());
				newacc.setPreviousTransaction(cust.getCustID());
				newacc.setCustID(cust.getCustID());
				System.out.println("Your actual balance is: " + newacc.getBalance() + " until it gets approved!");
				
				System.out.println("Please choose the type of account you have");
				System.out.println();
				System.out.println("1. Single account");
				System.out.println();
				System.out.println("2.Joint account");;
				int opt = sc.nextInt();
				AccountsDaoImpl Accounts = new AccountsDaoImpl();
				if(opt == 0) {
					newacc.setIsJoint(0);
					newacc.setStatus("pending");
					Accounts custAccount = new Accounts(newacc.getAccID(), newacc.getIsJoint(), newacc.getStatus(), newacc.getBalance(), newacc.getAccCustFname(), newacc.getAccCustLname(), newacc.getPreviousTransaction(),newacc.getCustID());
					Accounts.insertAccounts(custAccount);
				}else if(opt == 1) {
					newacc.setIsJoint(1);
					newacc.setStatus("pending");
					Accounts custAccount = new Accounts(newacc.getAccID(),newacc.getIsJoint(), newacc.getStatus(), newacc.getBalance(), newacc.getAccCustFname(), newacc.getAccCustLname(), newacc.getPreviousTransaction(),newacc.getCustID());
					Accounts.insertAccounts(custAccount);
					
				}
	}// end if
		System.out.println("Your account is waiting for aproval!");
		MainMenu.mainMenu();
	}// end registration
	
	/*
	public void custExist() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Type your ID:");
		String password = sc.next();
		CustomersDaoImpl cust = new CustomersDaoImpl();
		cust.custExist1(password);
	}
	*/
	
	@SuppressWarnings("unlikely-arg-type")
	public static void customerSign() {
		String username;
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("Please enter your username: ");
		username = sc.next();
		CustomersDaoImpl.custExist(username);
		customerSignpass();

	}// end customer sign in
	
       private static void customerSignpass() {
    	 String password;
   		Scanner sc = new Scanner(System.in);
   		System.out.println();
   		System.out.println("Please enter your password: ");
   		password = sc.next();
   		CustomersDaoImpl.custExist1(password);
   		AccountMenu.bankingMenu();
	}// end customer pass

}// end class
