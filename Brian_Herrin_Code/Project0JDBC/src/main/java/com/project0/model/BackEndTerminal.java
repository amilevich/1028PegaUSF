package com.project0.model;

import java.io.IOException;
import java.util.Scanner;

import com.project0.dao.BankDaoImpl;
import com.project0.maindriver.MainDriver;

import org.apache.log4j.Logger;

public class BackEndTerminal extends Terminal {
	final static Logger logger = Logger.getLogger(BackEndTerminal.class);
	public static void printActiveAccounts() {
		System.out.println(BankDaoImpl.dBDao.selectAllAccounts());
	}
	
	public static void printApplications() {
		System.out.println(BankDaoImpl.dBDao.selectAllApplications());
		/*
		for(Integer i : DataBaseApplications.dBApps.getMapApplications().keySet() ) {
			DataBaseApplications.dBApps.getMap(i).printAccount();
		}
		*/
	}
	
	public static void printAccounts() {
		for(Integer i : DataBaseAccounts.dBAccs.getMapAccounts().keySet() ) {
			DataBaseAccounts.dBAccs.getMap(i).printAccount();
		}
	}
	
	private static void addApplicationToActive(Integer accountId, Account application) {
		//DataBaseAccounts.deserializeDataBase();
		//DataBaseApplications.deserializeDataBase();
		DataBaseAccounts.dBAccs.putMap(accountId, application);
		BankDaoImpl.dBDao.insertAccount(application);
		DataBaseApplications.dBApps.removeMap(accountId, application);
		BankDaoImpl.dBDao.deleteApplication(application);
		//DataBaseAccounts.serializeDataBase();
		//DataBaseApplications.serializeDataBase();
	}
	
	public static void loginScreen(Scanner sc){
		boolean isRunning = true;
		do {
		//Scanner sc = new Scanner(System.in);
		System.out.println("Employee Revature Project 0 Banking System");
		System.out.println("***Activating Login Sequence***");
		System.out.println("Please type your username now");
		String temp1 = sc.nextLine();
		System.out.println("Please type your password now");
		String temp2 = sc.nextLine();
		if(DataBaseEmployees.dBEmp.isLoginValid(temp1, temp2)) {
			System.out.println("Alright, lets get to work!");
			if(temp1.contentEquals("AdminEmployee") ) {
				adminMainMenuScreen(sc);
			} else {
				EmployeeMainMenuScreen(sc);
			}
		} else {
			System.out.println("Invalid username and/or password");
			isRunning = false;
		}
		sc.close();
		} while(isRunning);
		System.out.println("Have a nice day, bye!");
		System.exit(0);
	}
	
	public static void EmployeeApplicantSeeCustomerReviewScreen(Scanner sc, Integer accountId) {
		sc.reset();
		System.out.println("Excellent, account found!");
		Account application = DataBaseApplications.dBApps.getMap(accountId);
		System.out.println(application.toString());
		System.out.println("After reviewing this account, please type \"accept\" to accept the account into our active account database or type \"deny\" to destroy the application");
		if(sc.hasNext("accept")) {
			System.out.println("Wonderful Job!");
			addApplicationToActive(accountId, application);
		}  else if(sc.hasNext("deny")) {
			System.out.println("Remember to return the balance before destroying this!");
			System.out.println("Application Balance: $" + application.getBalance());
			removeApplication(accountId, application);
			EmployeeApplicantReviewScreen(sc);
		} else if (sc.hasNext("back")) {
			sc.reset();
			EmployeeApplicantReviewScreen(sc);
		} else {
			sc.reset();
			EmployeeApplicantReviewScreen(sc);
		}
		sc.reset();
		EmployeeApplicantReviewScreen(sc);
	}

	private static void removeApplication(Integer accountId, Account application) {
		//DataBaseApplications.deserializeDataBase();
		DataBaseApplications.dBApps.removeMap(accountId, application);
		BankDaoImpl.dBDao.deleteApplication(application);
		//DataBaseApplications.serializeDataBase();
	}

	public static void EmployeeApplicantReviewScreen(Scanner sc){
		sc.reset();
		printApplications();
		System.out.println("Here are all of the new accounts waiting for you to accept them.");
		System.out.println("If you would like to accept or deny an account, then type the specific account id. ");
		System.out.println("If you would like to go back to the main menu then type \"back\": ");
		Integer temp = 0;
		while (!sc.hasNextInt() || !sc.hasNext("back")) {
			if(sc.hasNext("back")) {
				System.out.println();
				sc.nextLine();
				EmployeeMainMenuScreen(sc);
			} else if(sc.hasNextInt()) {
				temp = sc.nextInt();
				if(DataBaseApplications.dBApps.isAccountId(temp)) {
					EmployeeApplicantSeeCustomerReviewScreen(sc, temp);
				} else {
					System.out.println("Invalid account number");
					sc.next();
				}
			} else {
				sc.next();
			}
		}
	}
	
	private static void EmployeeAccountReviewScreen(Scanner sc, Integer accountId) {
		sc.reset();
		Account account = DataBaseAccounts.dBAccs.getMap(accountId);
		System.out.println("Excellent, account found!");
		System.out.println(account.toString());
		System.out.println("After reviewing this account, you press enter go back to Accounts:");
		try {
			System.out.print(System.in.read());
			System.out.println("");
		} catch (IOException e) {
			e.printStackTrace();
		}
		EmployeeActiveAccountScreen(sc);
	}
	
	public static void EmployeeActiveAccountScreen(Scanner sc){
		sc.reset();
		printAccounts();
		System.out.println("Here are all of the active accounts.");
		System.out.println("If you would like to go back to the main menu then type \"back\" now: ");
		System.out.println("Else if you would like to examine a specific account, then type its account id. ");
		Integer temp = 0;
		while (!sc.hasNextInt() || !sc.hasNext("back")) {
			//System.out.println("A");
			if(sc.hasNext("back")) {
				//System.out.println("B");
				EmployeeMainMenuScreen(sc);
			} else if(sc.hasNextInt()) {
				temp = sc.nextInt();
				//System.out.println(temp);
				if(DataBaseAccounts.dBAccs.isAccountId(temp)) {
					//System.out.println("D");
					//sc.next();
					EmployeeAccountReviewScreen(sc, temp);
				} else {
					System.out.println("Invalid account number");
					sc.next();
				}
			} else {
				//System.out.println("F");
				sc.next();
			}
		}
	}

	public static void EmployeeMainMenuScreen(Scanner sc){
		sc.reset();
		System.out.println("Main Menu:");
		System.out.println(" 0 Review applications for new accounts");
		System.out.println(" 1 View active accounts");
		System.out.println(" 2 Log out");
		System.out.println("Input selection: ");
		while (!sc.hasNextInt()) sc.next();
		switch(sc.nextInt()) {
		case 0:
			EmployeeApplicantReviewScreen(sc);
			break;
		case 1:
			EmployeeActiveAccountScreen(sc);
			break;
		case 2:
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
	
	public static void adminMainMenuScreen(Scanner sc){
		System.out.println("Main Menu:");
		System.out.println(" 0 Review applications for new accounts");
		System.out.println(" 1 See accounts");
		System.out.println(" 2 Process deposits to accounts");
		System.out.println(" 3 Process withdraws from accounts");
		System.out.println(" 4 Process transfers between accounts");
		System.out.println(" 5 Process new Employees");
		System.out.println(" 6 List Employees");
		System.out.println(" 7 Log Out");
		while (!sc.hasNextInt()) {
			sc.next();
		}
		switch(sc.nextInt()) {
		case 0:
			adminApplicantReviewScreen(sc);
			break;
		case 1:
			adminActiveAccountScreen(sc);
			break;
		case 2:
			adminDepositsScreen(sc);
			break;
		case 3:
			adminWithdrawsScreen(sc);
			break;
		case 4:
			adminTransfersScreen(sc);
			break;
		case 5:
			registerEmployee(sc);
			break;
		case 6:
			listEmployees(sc);
			break;
		case 7:
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
		System.out.println("Have a nice day, bye!");
		sc.close();
		System.exit(0);
	}

	private static void adminTransfersScreen(Scanner sc) {
		Integer fromAccount = 0, toAccount = 0; 
		double transBalance = 0;
		System.out.println("Transfer from account?:");
		fromAccount = sc.nextInt();
		System.out.println("Transfer to account?:");
		toAccount = sc.nextInt();
		System.out.println("Transfer amount?:");
		transBalance = sc.nextInt();
		
		if(DataBaseAccounts.dBAccs.isAccountId(fromAccount)) {
			if(DataBaseAccounts.dBAccs.isAccountId(toAccount)) {
				if(transBalance < DataBaseAccounts.dBAccs.getMap(fromAccount).getBalance()) {
					AdminEmployee.adminEmp.transfer(transBalance, DataBaseAccounts.dBAccs.getMap(fromAccount), DataBaseAccounts.dBAccs.getMap(toAccount));
				} else { System.out.println("Not enough money"); }
			} else { System.out.println("No account to transfer to"); }
		} else { System.out.println("Not an account to transfer from"); }
		adminMainMenuScreen(sc);
	}

	private static void adminWithdrawsScreen(Scanner sc) {
		Integer fromAccount = 0; 
		double withdrawBalance = 0;
		
		System.out.println("Withdraw from account? id: ");
		fromAccount = sc.nextInt();
		System.out.println("Withdraw amount?:");
		withdrawBalance = sc.nextInt();
		
		if(DataBaseAccounts.dBAccs.isAccountId(fromAccount)) {
			if(withdrawBalance < DataBaseAccounts.dBAccs.getMap(fromAccount).getBalance()) {
				AdminEmployee.adminEmp.withdraw(withdrawBalance, DataBaseAccounts.dBAccs.getMap(fromAccount));
			} else { System.out.println("Not enough money"); }
		} else { System.out.println("Not an account to withdraw from"); }
		adminMainMenuScreen(sc);
	}

	private static void adminDepositsScreen(Scanner sc) {
		Integer toAccount = 0; 
		double depositBalance = 0;
		
		System.out.println("Deposit to account? id: ");
		toAccount = sc.nextInt();
		System.out.println("Deposit amount?:");
		depositBalance = sc.nextInt();
		
		if(DataBaseAccounts.dBAccs.isAccountId(toAccount)) {
			AdminEmployee.adminEmp.deposit(depositBalance, DataBaseAccounts.dBAccs.getMap(toAccount));
		} else { System.out.println("Not an account to deposit to"); }
		adminMainMenuScreen(sc);
		adminMainMenuScreen(sc);
	}

	private static void adminAccountReviewScreen(Scanner sc, Integer accountId) {
		sc.reset();
		System.out.println("Excellent, account found!");
		Account account = DataBaseAccounts.dBAccs.getMap(accountId);
		System.out.println(account.toString());
		System.out.println("After reviewing this account, you press enter go back to Accounts:");
		try {
			System.out.print(System.in.read());
			System.out.println("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		adminActiveAccountScreen(sc);
	}

	private static void adminActiveAccountScreen(Scanner sc) {
		sc.reset();
		printAccounts();
		System.out.println("Here are all of the active accounts.");
		System.out.println("If you would like to go back to the main menu then type \"back\" now: ");
		System.out.println("Else if you would like to examine a specific account, then type its account id. ");
		Integer temp = 0;
		while (!sc.hasNextInt() || !sc.hasNext("back")) {
			//System.out.println("A");
			if(sc.hasNext("back")) {
				//System.out.println("B");
				adminMainMenuScreen(sc);
			} else if(sc.hasNextInt()) {
				temp = sc.nextInt();
				//System.out.println(temp);
				if(DataBaseAccounts.dBAccs.isAccountId(temp)) {
					//System.out.println("D");
					//sc.next();
					adminAccountReviewScreen(sc, temp);
				} else {
					System.out.println("Invalid account number");
					sc.next();
				}
			} else {
				//System.out.println("F");
				sc.next();
			}
		}
	}

	private static void adminApplicantReviewScreen(Scanner sc) {
		sc.reset();
		printApplications();
		System.out.println("Here are all of the new accounts waiting for you to accept them.");
		System.out.println("If you would like to accept or deny an account, then type the specific account id. ");
		System.out.println("If you would like to go back to the main menu then type \"back\": ");
		Integer temp = 0;
		while (!sc.hasNextInt() || !sc.hasNext("back")) {
			if(sc.hasNext("back")) {
				System.out.println();
				sc.nextLine();
				adminMainMenuScreen(sc);
			} else if(sc.hasNextInt()) {
				temp = sc.nextInt();
				if(DataBaseApplications.dBApps.isAccountId(temp)) {
					adminApplicantSeeCustomerReviewScreen(sc, temp);
				} else {
					System.out.println("Invalid account number");
					sc.next();
				}
			} else {
				sc.next();
			}
		}
	}

	private static void adminApplicantSeeCustomerReviewScreen(Scanner sc, Integer temp) {
		sc.reset();
		System.out.println("Excellent, account found!");
		Account application = DataBaseApplications.dBApps.getMap(temp);
		System.out.println(application.toString());
		System.out.println("After reviewing this account, please type \"accept\" to accept the account into our active account database or type \"deny\" to destroy the application");
		if(sc.hasNext("accept")) {
			System.out.println("Wonderful Job!");
			addApplicationToActive(temp, application);
		}  else if(sc.hasNext("deny")) {
			System.out.println("Remember to return the balance before destroying this!");
			System.out.println("Application Balance: $" + application.getBalance());
			removeApplication(temp, application);
			adminApplicantReviewScreen(sc);
		} else if (sc.hasNext("back")) {
			sc.reset();
			adminApplicantReviewScreen(sc);
		} else {
			sc.reset();
			adminApplicantReviewScreen(sc);
		}
		sc.reset();
		adminApplicantReviewScreen(sc);
	}

	public static void registerEmployee(Scanner sc){
		/*
		*/
		
		System.out.println("Congratulations for being accepted as a Revature Project 0 Banking employee!");
		System.out.println("You need a username and password to access the back end system");
		System.out.println("Let's begin! We need to give you a way to get on our employee network.");
		System.out.println("Please provide a \"user name\" for us to use to identify you: ");
		System.out.println("");
		sc.nextLine();
		String temp = sc.nextLine();
		System.out.println("Alright, nice to meet you, " + temp + "!");
		System.out.println("Now for security. Write in a password!: ");
		String temp1 = sc.nextLine(); 
		System.out.println("Got that memorized? Write that password again!: ");
		if(MainDriver.isEqualToString(sc.nextLine(), temp1) ){
			System.out.println("Great Memory!");
		} else {
			System.out.println();
			adminMainMenuScreen(sc);
		}
		
		System.out.println("Now we can add you to the network: ");
		// Plan to instantiate accounts and fill them at the end here:
		Employee newE = new Employee(temp, temp1);
		//DataBaseEmployees.deserializeDataBase();
		DataBaseEmployees.dBEmp.getMapEmployees().put(AdminEmployee.useNextUserId(), newE);
		//DataBaseEmployees.serializeDataBase();
		adminMainMenuScreen(sc);
	}
	
	private static void listEmployees(Scanner sc) {
		System.out.println(DataBaseEmployees.dBEmp.getMapEmployees().entrySet());
		adminMainMenuScreen(sc);
	}
}
