package com.examples.customers;

import java.util.Scanner;

import com.examples.accounts.AccountMenu;
import com.examples.accounts.Accounts;
import com.examples.dao.AccountsDaoImpl;
import com.examples.dao.CustomersDaoImpl;
import com.examples.menu.MainMenu;

public class CustomersMenu {
	
	public static void Registration() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int option;
		int counter =0;

		Customers cust = new Customers();
		System.out.println("Press 1 to register for an account");
		option = input.nextInt();
		if (option == 1) {
			counter++;
			
				System.out.println("Please enter user first name: ");
				cust.setCustFname(input.next());
			
				System.out.println("Please enter your last name: ");
				cust.setCustLname(input.next());

			while (true) {
				System.out.println();
				System.out.println( cust.getCustFname() + " " + cust.getCustLname());
				System.out.println();
				System.out.println("Please create an username:");
				System.out.println();
				cust.setUserName(input.next());
				if (cust.getUserName().length() > 3 && cust.getUserName().length() <= 10) {
					System.out.println("Your user name was created");
					System.out.println();
					break;
				} else {

					System.out.println("Your user name must be 5 or 10 characters long");
					System.out.println();
				}
			}
		
			while (true) {

				System.out.println("Please create a password:");
				System.out.println();
				cust.setPassword(input.next());
				if (cust.getPassword().length() > 5 && cust.getPassword().length() <= 10) {
					System.out.println("Your password has been created");
					System.out.println();
					break;
				} else {

					System.out.println("Your password must be 5 or 10 characters long");
					System.out.println();
				
				}
			}
			
			 cust.setStatus("Pending");
			 System.out.println("Your ID is: " + cust.getCustID());
			 System.out.println();
			 System.out.println(cust.getCustFname() + ", Your account has been created");
			 System.out.println("The status of your account is: " + cust.getStatus());
			 System.out.println();
			 CustomersDaoImpl  custImpl = new CustomersDaoImpl();
			 custImpl.insertCustomers(cust);
			 Accounts newacc = new  Accounts();
			 @SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
				System.out.println("Your account ID will be: " + newacc.getAccID());
				int bal = 0;
				newacc.setCustID(cust.getCustID());
				newacc.setBalance(bal);
				newacc.setStatus(cust.getStatus());
				newacc.setBalance(cust.getBal());
				newacc.setAccCustFname(cust.getCustFname());
				newacc.setAccCustLname(cust.getCustLname());
				newacc.setCustID(cust.getCustID());
				System.out.println("Your initial balance is: " + newacc.getBalance() + " Your account status is pending. Your account needs to be approved by an employee or admin.");
				
				System.out.println("Press 0 to get a single account");
				System.out.println();
				System.out.println("Press 1 to get joint account");
				int opt = sc.nextInt();
				AccountsDaoImpl Accounts = new AccountsDaoImpl();
				if(opt == 0) {
					newacc.setIsJoint(0);
					newacc.setStatus("pending");
					Accounts custAccount = new Accounts(newacc.getAccID(), newacc.getIsJoint(), newacc.getStatus(), newacc.getBalance(), newacc.getAccCustFname(), newacc.getAccCustLname(),newacc.getCustID());
					Accounts.insertAccounts(custAccount);
				}else if(opt == 1) {
					newacc.setIsJoint(1);
					newacc.setStatus("pending");
					Accounts custAccount = new Accounts(newacc.getAccID(),newacc.getIsJoint(), newacc.getStatus(), newacc.getBalance(), newacc.getAccCustFname(), newacc.getAccCustLname(), newacc.getCustID());
					Accounts.insertAccounts(custAccount);
					
				}
	}// end if
		System.out.println("Your account will need to be approved.");
		MainMenu.menu();
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
	
	public static void customerSignIn() {
		String username;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("Please enter your username: ");
		username = sc.next();
		CustomersDaoImpl.custExist(username);
		customerSignpass();

	}
	
	private static void customerSignpass() {
   	 String password;
  		Scanner sc = new Scanner(System.in);
  		Accounts act = new Accounts();
  		System.out.println();
  		System.out.println("Please enter your password: ");
  		password = sc.next();
  		CustomersDaoImpl.custExist2
  		(password);

  		Scanner scanner = new Scanner(System.in);
  		Customers cust = new Customers();
		AccountsDaoImpl acct = new AccountsDaoImpl();
		System.out.println("Please enter your account ID");
		int accID = scanner.nextInt();
	    Accounts acc = new Accounts();
	    acc = acct.selectAccountsByAccountID(accID);
	    System.out.println("=====================================================================================================================================================================================");
	    System.out.println("                                                    Customer details");
	    System.out.println(acc);
	    System.out.println("=====================================================================================================================================================================================");

	    if(acc.getStatus().equals("approved")) {
	    	AccountMenu.bankingMenu(accID);
  		}else {
  			System.out.println("your account's status is still pending. Logging out . . .");
  			MainMenu.menu();
  		}
	}
}