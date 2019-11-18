package com.projects.project0.userlayer;

import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.projects.project0.MainDriver;
import com.projects.project0.Terminal;
import com.projects.project0.businesslayer.Account;
import com.projects.project0.businesslayer.AdminEmployee;
import com.projects.project0.businesslayer.Customer;
import com.projects.project0.businesslayer.DataBaseAccounts;
import com.projects.project0.businesslayer.DataBaseApplications;
import com.projects.project0.businesslayer.DataBaseCustomers;

public class FrontEndTerminal extends Terminal {
	final static Logger logger = Logger.getLogger(FrontEndTerminal.class);
	public static void loginScreen(Scanner sc){
		
		System.out.println("Hello, welcome to Revature Project 0 Banking!");
		System.out.println("Do you already have an account with us? (y/n)");
		String temp = sc.nextLine();
		if(MainDriver.isEqualToString(temp, "y")) {
			System.out.println("Please type your username now");
			String temp1 = sc.nextLine();
			System.out.println("Please type your password now");
			String temp2 = sc.nextLine();
			if(DataBaseCustomers.dBCus.isLoginValid(temp1, temp2)) {
				Customer tempCus = DataBaseCustomers.dBCus.getMap(DataBaseCustomers.dBCus.getCustomerId(temp1));
				customerMainMenu(sc, tempCus);
			} else {
				System.out.println("It didn't work!");
			}
			
		} else if(MainDriver.isEqualToString(temp, "n")) {
			FrontEndTerminal.accountApplicationScreen();
		}
		sc.close();
	}
	
	private static void customerMainMenu(Scanner sc, Customer c) {
		System.out.println("Customer: " + c);
		System.out.println("0 Deposits");
		System.out.println("1 Withdraws");
		System.out.println("2 Transfers");
		System.out.println("Type 0, 1, or 2: ");
		while (!sc.hasNextInt()) sc.next();
		switch(sc.nextInt()) {
		case 0:
			customerDepositScreen(sc, c);
			break;
		case 1:
			customerWithdrawScreen(sc, c);
			break;
		case 2:
			customerTransferScreen(sc, c);
			break;
		case 3:
			System.out.println("Good-bye!");
			sc.close();
			System.exit(0);
			break;
		default:
			System.out.println("Good-bye!");
			sc.close();
			System.exit(0);
			break;
		}
		sc.close();
		System.exit(0);
	}

	private static void customerTransferScreen(Scanner sc, Customer c) {
		Integer fromAccount = 0, toAccount = 0; 
		double transBalance = 0;
		boolean isYourAccount = false;
		System.out.println("Accounts you are associated with: ");
		for(Integer i : c.getIdAccount()) {
			System.out.println(" " + i);
		}
		
		System.out.println("Transfer from account?:");
		fromAccount = sc.nextInt();
		System.out.println("Transfer to account?:");
		toAccount = sc.nextInt();
		System.out.println("Transfer amount?:");
		transBalance = sc.nextInt();
		
		for(Integer i : c.getIdAccount()) {
			if(i == fromAccount) {
				for(Integer j : c.getIdAccount()) {
					if(j == toAccount) {
						isYourAccount = true;
					}
				}
			}
		}
		if(isYourAccount) {
			if(DataBaseAccounts.dBAccs.isAccountId(fromAccount)) {
				if(DataBaseAccounts.dBAccs.isAccountId(toAccount)) {
					if(transBalance < DataBaseAccounts.dBAccs.getMap(fromAccount).seeBalance()) {
						AdminEmployee.adminEmp.transfer(transBalance, DataBaseAccounts.dBAccs.getMap(fromAccount), DataBaseAccounts.dBAccs.getMap(toAccount));
						System.out.println("Transfer Complete: $" + DataBaseAccounts.dBAccs.getMap(fromAccount).seeBalance() + " $" + DataBaseAccounts.dBAccs.getMap(toAccount).seeBalance());
						DataBaseAccounts.serializeDataBase();
					} else { System.out.println("Not enough money"); }
				} else { System.out.println("No account to transfer to"); }
			} else { System.out.println("Not an account to transfer from"); }
		}
		customerMainMenu(sc, c);
	}

	private static void customerWithdrawScreen(Scanner sc, Customer c) {
		Integer fromAccount = 0; 
		double withdrawBalance = 0;
		boolean isYourAccount = false;
		System.out.println("Accounts you are associated with: ");
		for(Integer i : c.getIdAccount()) {
			System.out.println(" " + i);
		}
		System.out.println("Withdraw from account? id: ");
		fromAccount = sc.nextInt();
		System.out.println("Withdraw amount?:");
		withdrawBalance = sc.nextInt();
		for(Integer i : c.getIdAccount()) {
			if(i == fromAccount) {
				isYourAccount = true;
			}
		}
		if(isYourAccount) {
			if(DataBaseAccounts.dBAccs.isAccountId(fromAccount)) {
				if(withdrawBalance < DataBaseAccounts.dBAccs.getMap(fromAccount).seeBalance()) {
					AdminEmployee.adminEmp.withdraw(withdrawBalance, DataBaseAccounts.dBAccs.getMap(fromAccount));
					System.out.println("Withdraw Complete: $" + DataBaseAccounts.dBAccs.getMap(fromAccount).seeBalance());
					DataBaseAccounts.serializeDataBase();
				} else { System.out.println("Not enough money"); }
			} else { System.out.println("Not an account to withdraw from"); }
		}
		customerMainMenu(sc, c);
	}

	private static void customerDepositScreen(Scanner sc, Customer c) {
		Integer toAccount = 0; 
		double depositBalance = 0;
		boolean isYourAccount = false;
		System.out.println("Accounts you are associated with: ");
		for(Integer i : c.getIdAccount()) {
			System.out.println(" " + i);
		}
		System.out.println("Deposit to account? id: ");
		toAccount = sc.nextInt();
		System.out.println("Deposit amount?:");
		depositBalance = sc.nextInt();
		for(Integer i : c.getIdAccount()) {
			if(i == toAccount) {
				isYourAccount = true;
			}
		}
		if(isYourAccount) {
			if(DataBaseAccounts.dBAccs.isAccountId(toAccount)) {
				AdminEmployee.adminEmp.deposit(depositBalance, DataBaseAccounts.dBAccs.getMap(toAccount));
				System.out.println("Deposit Complete: $" +DataBaseAccounts.dBAccs.getMap(toAccount).seeBalance());
				DataBaseAccounts.serializeDataBase();
			} else { System.out.println("Not an account to deposit to"); }
		}
		customerMainMenu(sc, c);
	}

	public static Customer quickCustomerCreationScreen() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please provide a username: ");
		String newUsernameC = sc.nextLine();
		System.out.println("Please provide a password: ");
		String newPasswordC = sc.nextLine();
		System.out.println("Please provide a first name: ");
		String newFirstNameC = sc.nextLine();
		System.out.println("Please provide a last name: ");
		String newLastNameC = sc.nextLine();
		sc.close();
		return new Customer(newUsernameC, newPasswordC, newFirstNameC, newLastNameC);
	}
	public static void accountApplicationScreen(){
		/*
		 * Basic flow of the application: 
		 * - User asks to open an account (either single or joint) 
		 * - Application is pending 
		 * - Employee or Admin logs in and approves the account 
		 * - User is able to log in and perform actions like withdraw, deposit and transfer
		 */
		
		Scanner sc = new Scanner(System.in);
		String tempString;
		
		String newUsernameC, newPasswordC, newFirstNameC, newLastNameC;
		Set<Customer> tempCustomers =  new HashSet<Customer>();
		double newAccountBalance = 0.0;
		
		System.out.println("Greetings, welcome to our automated account creation system!");
		System.out.println("Thank you for choosing Revature Project0 Banking.");
		System.out.println("Let's begin! We need to give you a way to get in your account.");
		System.out.println("Please provide a \"username\" for us to use for your new account: ");
	
		newUsernameC = sc.nextLine();
		
		System.out.println("Now for security. Write in a password!: ");
		newPasswordC = sc.nextLine(); 
		System.out.println("Got that memorized? Write that password again!: ");
		if(MainDriver.isEqualToString(sc.nextLine(), newPasswordC) ){
			System.out.println("Great Memory!");
		} else {
			System.out.println("Have a nice day, bye!");
			sc.close();
			System.exit(0);
		}
		
		System.out.println("What is your first name?: ");
		newFirstNameC = sc.nextLine(); 
		System.out.println("What is your last name?: ");
		newLastNameC = sc.nextLine(); 
		System.out.println("Alright, nice to meet you, " + newFirstNameC + "!");
		
		System.out.println("Now we can set up the account.");
		System.out.println("Would you like to make a single or joint account? (single joint)");
		tempString = sc.nextLine();
		if(MainDriver.isEqualToString(tempString, "joint")) {
			System.out.println("Joint Account confirmed."); 
			System.out.println("Is this with a current customer of ours? (y/n)");
			tempString = sc.nextLine();
			if(MainDriver.isEqualToString(tempString, "y")) {
				do {
					System.out.println("Type in their username and we'll link their profile to this account:");
					tempString = sc.nextLine();
					// tempCustomers.add(searchDataBaseCustomer(tempString));
					System.out.println("Any more customers of ours already? (y/n)");
					tempString = sc.nextLine();
				} while (MainDriver.isEqualToString(tempString, "y"));
			} else if(MainDriver.isEqualToString(tempString, "n")) {
				do {
					System.out.println("Then we need to make a new profile for them!");
					tempCustomers.add(quickCustomerCreationScreen());
					logger.info(tempCustomers.toString());
					System.out.println("Anyone else? (y/n)");
					tempString = sc.nextLine();
				} while (MainDriver.isEqualToString(tempString, "y"));
			}
		} else if(MainDriver.isEqualToString(tempString, "single")) {
			System.out.println("Single account, got it.");
		} else {
			System.out.println("Have a nice day, bye!");
			sc.close();
			System.exit(0);
		}
		
		System.out.println("Yeah, almost done! How much money for your initial deposit?: ");
		newAccountBalance = sc.nextDouble();
		if(MainDriver.isNegative(newAccountBalance)) {
			do {
				System.out.println("No negative values, please! Give it another go.");
				System.out.println("How much money for your initial deposit?: ");
				newAccountBalance = sc.nextDouble();
			} while(MainDriver.isNegative(newAccountBalance));
		}
		if(newAccountBalance == 0.0) {
			System.out.println("No shame in that! We do not have a minimum balance requirement.");
		}
		System.out.println("You are done! YES! YES! YES!");
		
		// Plan to instantiate accounts and fill them at the end here:
		Customer newC = new Customer(newUsernameC, newPasswordC, newFirstNameC, newLastNameC);
		//newC.setAssociates(tempCustomers);
		Account newA = null;
		newA = new Account(AdminEmployee.useNextAccountId(), newAccountBalance);
		newC.addIdAccount(newA.getAccountId());
		
		
		DataBaseApplications.dBApps.putMap(newA.getAccountId(), newA);
		DataBaseApplications.serializeDataBaseApplication();
		logger.info("New Application " + DataBaseApplications.dBApps.getMap(newA.getAccountId()).toString());
		DataBaseCustomers.dBCus.putMap(newC.getId(), newC);
		DataBaseCustomers.serializeDataBaseCustomer();
		logger.info("New Customer " + newC.toString());
		System.out.println("Welcome to Revature Project0 Banking, " + newC.getFullName() + "!");
		System.out.println("We will approve your account soon. Have a nice day, bye!");
		
		sc.close();
	}
	//
}
