package com.app.main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;



public class Menu {
	public final static Logger bankLog = Logger.getLogger(Logger.class);
	
	static String userId;
	
	static long accountNumber = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
	
	static float deposit = 0f;
	static float withdraw = 0f;
	static float transfer = 0f;
	
	public static Scanner scan = new Scanner(System.in);
	
	public static Customer ID = new Customer(); // Customer Obj
	public static Admin admin = new Admin(); // Admin Obj
	public static Employee employee = new Employee();// Employee Obj
	
	static Account acct = new Account(0, accountNumber);
	
	public static ArrayList<Customer> pendingCust = new ArrayList<Customer>();// Pending Accts Arraylist
	public static Map <String, Customer> validAccts = new HashMap<String, Customer>();// Approved Accts K=String, V=Customer obj
	public static HashMap<String, Customer> allCustHash = Customer.readCustomers(); //Cust to Cust, auto fetches
	public static HashMap<String, Account> allAccHash = Account.readAccounts();
	static String filename = "temp.ser";
	
	public static void main(String[] args) {

	}
	
	public static void runWelcomeMenu() { //Main Menu
		
		System.out.println("Welcome to your local bank." + '\n'+ "1. Register" + '\n' + "2. Login" + '\n' + "3. Exit");
		String option = scan.nextLine(); //Scanner String
		allAccHash.put(acct.accNum, acct);// Generate acct and assign
		
		switch (option) {
		case "1": //Registration
			System.out.println("Welcome to account regristration. Please enter your full name.");
			String uName = scan.nextLine();
			ID.setName(uName);

			System.out.println("Please enter a username.");
			String uUsername = scan.nextLine();
			ID.userName= (uUsername);
			allAccHash.get(acct.accNum).customers.add(uUsername); 

			System.out.println("Please enter a four digit pin number.");
			String uPin = scan.nextLine();
			int pinLimit = String.valueOf(uPin).length();
			if(pinLimit > 4 || pinLimit <= 3) {//If not a sting of 4 digits, print this
				runRegMenu();
			}else{
				ID.userPin = uPin;
			}
			
			System.out.println("What's your initial deposit amount?");
			float uBalance = scan.nextFloat();
			scan.nextLine();
			allAccHash.get(acct.accNum).balance = uBalance;

			Customer newCustomer = new Customer(uUsername, uPin, uName);
			pendingCust.add(newCustomer);
			
			System.out.println("Is this a single or joint account?" + '\n' + "1. Joint" + '\n'+ "2. Single");
			String uJoint = scan.nextLine();

			if(uJoint.equals("1")) {// Joint

				System.out.println("Joint account setup. Please enter full name.");
				String uName1 = scan.nextLine();
				ID.setName(uName1);

				System.out.println("Please enter a username.");
				String uUsername1 = scan.nextLine();
				ID.userName= (uUsername1);
				allAccHash.get(acct.accNum).customers.add(uUsername1); 

				System.out.println("Please enter a four digit pin number.");
				String uPin1 = scan.nextLine();
				int pinLimit1 = String.valueOf(uPin1).length();
				if(pinLimit1 > 4 || pinLimit1 <= 3) {//If not a sting of 4 digits, print this
					runRegMenu();
				}else{
					ID.userPin = uPin1; // or upin?
					Customer cust2 =  new Customer(uName1, uUsername1, uPin1);
					allCustHash.put(uUsername1, cust2);
				}
			}
			if(uJoint.equals("2")) {// Single
				System.out.println("Confirmed single account.");
			}
			newCustomer.accounts.add(acct.accNum);
			allCustHash.put(newCustomer.userName, newCustomer);// stored into hashmap
			
			System.out.println("Okay " + ID.Name + " Please await account approval and review your account details:" +'\n' + allAccHash.get(acct.accNum).customers.get(0) 
					+ " "+ allCustHash.get(ID.userName) + " " + allAccHash.get(acct.accNum).balance + '\n' + "Acct#: " + allAccHash.get(acct.accNum));
			runWelcomeMenu();
			break;
			
		case "2": runLoginMenu(); //Login
		break;
		
		case "3" :
			Account.writeAccounts(allAccHash);
			Customer.writeCustomers(allCustHash);
			System.exit(0);
		break;
		
		default: 
			System.out.println("Invalid option");
			runWelcomeMenu();
		}
	}
	
	public static void runRegMenu() {//Reg. menu recursive
		
		String option1 = scan.nextLine(); //Scanner String
		switch (option1) {
		case "1": //Registration
			System.out.println("Welcome to account regristration. Please enter your full name.");
			String uName = scan.nextLine();
			ID.setName(uName);

			System.out.println("Please enter a username.");
			String uUsername = scan.nextLine();
			ID.userName= (uUsername);
			allAccHash.get(acct.accNum).customers.add(uUsername); 

			System.out.println("Please enter a four digit pin number.");
			String uPin = scan.nextLine();
			int pinLimit = String.valueOf(uPin).length();
			if(pinLimit > 4 || pinLimit <= 3) {//If not a sting of 4 digits, print this
				runRegMenu();
			}else{
				ID.userPin = uPin;
			}

			System.out.println("What's your initial deposit amount?");
			float uBalance = scan.nextFloat();
			scan.nextLine();
			allAccHash.get(acct.accNum).balance = uBalance;

			Customer newCustomer = new Customer(uUsername, uPin, uName);
			pendingCust.add(newCustomer);
			
			System.out.println("Is this a single or joint account?" + '\n' + "1. Joint" + '\n'+ "2. Single");
			String uJoint = scan.nextLine();
			
			if(uJoint.equals("1")) {// Joint
				
				System.out.println("Joint account setup. Enter full name.");
				String uName1 = scan.nextLine();
				ID.setName(uName1);

				System.out.println("Please enter a username.");
				String uUsername1 = scan.nextLine();
				ID.userName= (uUsername1);
				allAccHash.get(acct.accNum).customers.add(uUsername1); 
				
				System.out.println("Please enter a four digit pin number.");
				String uPin1 = scan.nextLine();
				int pinLimit1 = String.valueOf(uPin1).length();
				if(pinLimit1 > 4 || pinLimit1 <= 3) {//If not a sting of 4 digits, print this
					System.out.println("Invalid input.");
					runRegMenu();
				}else{
					ID.userPin = uPin1;
					Customer cust2 =  new Customer(uName1, uUsername1, uPin1);
					allCustHash.put(uUsername1, cust2);
					System.out.println("Account for " +cust2.Name+ " has been created!");
				}
			}
			if(uJoint.equals("2")) {// Single
				System.out.println("Confirmed single account.");
			}
			
			newCustomer.accounts.add(acct.accNum);
			allCustHash.put(newCustomer.userName, newCustomer);// stored into hashmap
			
			System.out.println("Okay " + ID.Name + " Please await account approval and review your account details:" +'\n' + allAccHash.get(acct.accNum).customers.get(0) 
					+ " "+ allCustHash.get(ID.userName) + " " + allAccHash.get(acct.accNum).balance + '\n' + "Acct#: " + allAccHash.get(acct.accNum));
			
			runWelcomeMenu();
			break;
			
		case "2": runLoginMenu(); //Login
		break;
		
		default: 
			System.out.println("Invalid option");
			runWelcomeMenu();
		}	
	}
	
	public static void runLoginMenu() {// Login for all accounts
		System.out.println("Welcome to login, please enter your username.");
		String uName0 = scan.nextLine();
		
		System.out.println("Enter pin number.");
		String uPin0 = scan.nextLine();
		
		if(uName0.equals(admin.userName) && uPin0.equals(admin.userPin)){
			runAmenu();
		}else if(uName0.equals(employee.userName) && uPin0.equals(employee.userPin)){
			runEmenu();
		}
		if(allCustHash.containsKey(uName0) && allCustHash.get(uName0).userPin.equals(uPin0)) {
			System.out.println("Log in successful.");
			
			if((allCustHash.get(uName0).Status.equals("pending"))) {
				System.out.println("This account is pending. Please login later.");
				//userId= cust.userName+cust.userPin;
				runWelcomeMenu();
			} 
//			if (allCustHash.get(uName0).accounts.size() > 1) {
//				System.out.println("Which account would you like to access?");
//				String choice1 = allCustHash.get(uName0).accounts.get(0);
//				String choice2 = allCustHash.get(uName0).accounts.get(1);
//				System.out.println("choice 1:" + choice1 + " or " + "choice 2:" + choice1 );
//				String login = scan.nextLine();
//				
//				if(login.equals("1")) {
//					System.out.println("Ok you'll be using: " + allCustHash.get(uName0).accounts.get(0));
//					String jointAccNum = allCustHash.get(uName0).accounts.get(0);
//					runCmenu(jointAccNum);
//
//				}else {
//					System.out.println("Ok you'll be using: " + allCustHash.get(uName0).accounts.get(1));
//					String singleAccNum = allCustHash.get(uName0).accounts.get(1);
//					runCmenu(singleAccNum);
//				}
//			}
		}else{ 
			System.out.println("Invalid Login.");
			runWelcomeMenu();
		}
		if(allCustHash.get(uName0).accounts.size() > 1) {
			System.out.println("Which account would you like to access?");
			String choice1 = allCustHash.get(uName0).accounts.get(0);
			String choice2 = allCustHash.get(uName0).accounts.get(1);
			System.out.println("choice 1:" + choice1 + " or " + "choice 2:" + choice1 );
			String login = scan.nextLine();
			
			if(login.equals("1")) {
				System.out.println("Ok you'll be using: " + allCustHash.get(uName0).accounts.get(0));
				String jointAccNum = allCustHash.get(uName0).accounts.get(0);
				runCmenu(jointAccNum);

			}else {
				System.out.println("Ok you'll be using: " + allCustHash.get(uName0).accounts.get(1));
				String singleAccNum = allCustHash.get(uName0).accounts.get(1);
				runCmenu(singleAccNum);
			}
		}

		if(!uName0.equals(employee.userName) && uPin0.equals(employee.userPin)) {
			System.out.println("Invalid Login.");
			runWelcomeMenu();
		}
		if(!uName0.equals(admin.userName) && uPin0.equals(admin.userPin)) {
			System.out.println("Invalid Login.");
			runWelcomeMenu();
		}
	}
	
	public static void runCmenu(String accNum) {//Menu for customer banking
		
		System.out.println("Welcome, how may I help you today?" + '\n' + "1. Deposit" + '\n' + "2. Withdraw" + '\n' + "3. Transfer" + '\n'+ "4. Exit");
		
		String option2 = scan.nextLine(); //Scanner String
		switch (option2) {
		
		case "1": //Deposit
			System.out.println("How much would you like to deposit?");
			float dep = scan.nextFloat();
			
			scan.nextLine();
			allAccHash.get(accNum).balance += dep;
			
			System.out.println("New balance: " + allAccHash.get(accNum).balance);
			Menu.bankLog.info("New balance: " + allAccHash.get(accNum).balance);
			runCmenu(accNum);
			break;
			
		case "2": //Withdrawl
			System.out.println("How much would you like to withdraw?");
			float wit = scan.nextFloat();
			scan.next();
			
			if(allAccHash.get(accNum).balance < wit) {
				System.out.println("Overdraft. Not enough in account.");
				runCmenu(accNum);
			}else {
				scan.nextLine();
				allAccHash.get(accNum).balance -= wit;

				System.out.println("New balance: " + allAccHash.get(accNum).balance);
				Menu.bankLog.info("New balance: " + allAccHash.get(accNum).balance);
				runCmenu(accNum);
			}
			break;
			
		case "3": //Transfer
			System.out.println("Enter Acct# for transfer.");
			String target1 = scan.nextLine();

			if(allAccHash.containsKey(target1)) {
				
				System.out.println("Enter amount of transfer.");
				float trans = scan.nextFloat();
				scan.nextLine();
				
				if(allAccHash.get(accNum).balance < trans) {
					System.out.println("Overdraft. Not enough in account.");
					adminEdits();
				}
				allAccHash.get(target1).balance+= trans;
				allAccHash.get(accNum).balance -= trans;
				System.out.println(allAccHash.get(ID.getName()) +" has new balance of: " + allAccHash.get(accNum).balance);
				Menu.bankLog.info(allAccHash.get(ID.getName()) +" has new balance of: " + allAccHash.get(accNum).balance);
			}
			if(!allCustHash.containsKey(target1)) {
				System.out.println("Not a match, sorry.");
				adminEdits();
			}
			runCmenu(accNum);
			break;

		case "4": // Exit
			System.out.println("Transaction complete.");
			runWelcomeMenu();
			break;
			
		default :
			System.out.println("Invalid input.");
			runCmenu(accNum);
			}
		}

	public static void runEmenu() {// Run Employee menu //login after admin null exception
		System.out.println("Welcome Employee_0:" + '\n' + "1. View Open Accounts" + '\n' + "2. Exit"); // See personal info and balances
		String choice = scan.nextLine();
		if(choice.equals("1")) {
			Set set = allAccHash.entrySet(); // set of entries
			Iterator i = set.iterator(); //iterator
			while(i.hasNext()) {
				Map.Entry allAccHash = (Map.Entry)i.next();
				System.out.print(allAccHash.getKey() + ": ");
				System.out.println(allAccHash.getValue());
			}
			System.out.println();
			System.out.println("Acct# Info: "+allAccHash);
			
			while(i.hasNext()) {
				Map.Entry allCustHash = (Map.Entry)i.next();
				System.out.print(allCustHash.getKey() + ": ");
				System.out.println(allCustHash.getValue());
			}
			System.out.println();
			System.out.println("Personal Info: "+allCustHash);
		}
		if(choice.equals("2")) {
			runWelcomeMenu();
		}
		else {
			System.out.println("Invalid option.");
			runEmenu();
		}
	}
	public static void runAmenu() {// Run admin menu
		System.out.println("Welcome "  + admin.Name + '\n' +"1. View Pending Accounts" + '\n' + "2. Edit Accounts" + '\n' + "3. Sign-Out");// Deposit, Withdraw, Transfer with all accounts

			String option3 = scan.nextLine(); //Scanner String
			switch (option3) {
			
			case "1": //Pending Accts
				adminApproval();
				break;
				
			case "2": //Edit
				adminEdits();
				break;
				
			case "3": // Exit
				System.out.println("Signing out.");
				runLoginMenu();
				break;
				
			default :
				System.out.println("Invalid input.");
				runAmenu();
				}

	}
	public static void adminView() {
		System.out.println("Show all customers");
	}
	public static void adminApproval() {
		String options="";
		for(int x = 0; x < pendingCust.size(); x++) {
			System.out.println(pendingCust.size());
			System.out.println("ACCOUNT IN PENDING: " + pendingCust.get(x));
			System.out.println("1. Approve");
			System.out.println("2. Deny");

			options =scan.next();

			switch(options) {
			case "1" : //null exception
//				System.out.println("Starting Pending list: " + pendingCust);
//				System.out.println("Starting Active List: " +validAccts);
//				Account newAccount = new Account(0, accountNumber);
//				//pendingCust.get(x).addAccount(newAccount);
//				pendingCust.get(x).accounts.add(newAccount.accNum);
//				validAccts.put( (pendingCust.get(x).getUserName() +pendingCust.get(x).getUserPin()), pendingCust.get(x));
//				//pendingCust.remove(x);
//				System.out.println("Ending Pending list: " + pendingCust);
//				System.out.println("Ending Active List: " +validAccts);
//				//writeCustomer(filename, pendingCust);
				System.out.println("Type Customer ID to confirm approval: ");
				scan.nextLine();
				String uChoice = scan.nextLine();
				if(allCustHash.containsKey(uChoice)) {
					allCustHash.get(uChoice).Status = "Approved";
					System.out.println("Account approved.");
				}else {
					System.out.println("Unable to locate user.");
				}
				break;

			case "2" : // Deny
				System.out.println("Type Customer ID to confirm denial: ");
				scan.nextLine();
				String uChoice0 = scan.nextLine();	
				if(allCustHash.containsKey(uChoice0)) {
					allCustHash.get(uChoice0).Status = "Denied";
					System.out.println("Account denied.");
				}else {
					System.out.println("Unable to locate user.");
				}
				break;
				
			default :
				runAmenu();
			}
		}
		pendingCust.removeAll(pendingCust);
		System.out.println("No more accounts. Returning to previous menu.");
		runAmenu();
	}
		
	public static void adminEdits() {
		System.out.println("1. Deposit into Account" + '\n' + "2. Withdraw from Account" + '\n'+ "3. Transfer from Account" + '\n' +"4. Close Account" + '\n' + "5. Exit");
		String options =scan.nextLine();

		switch(options) {
		case "1" :
			System.out.println("Enter Username ID for deposit.");
			String target = scan.nextLine();
			
			if(allCustHash.containsKey(target)) {
				System.out.println("Enter amount of deposit.");
				float dep = scan.nextFloat();
				scan.nextLine();

				allAccHash.get(acct.accNum).balance += dep;
			}
			if(!allCustHash.containsKey(target)) {
				System.out.println("Not a match, sorry.");
				adminEdits();
			}
			
			System.out.println("New balance of: "+ allAccHash.get(acct.accNum).balance);
			Menu.bankLog.info("New balance of: "+ allAccHash.get(acct.accNum).balance);
			adminEdits();
			break;
			
		case "2" :
			System.out.println("Enter Username ID for withdrawl.");
			String target2 = scan.nextLine();
			
			if(allCustHash.containsKey(target2)) {
				System.out.println("Enter amount of withdrawl.");
				float wit = scan.nextFloat();
				scan.nextLine();

				allAccHash.get(acct.accNum).balance -= wit;
			}
			if(!allCustHash.containsKey(target2)) {
				System.out.println("Not a match, sorry.");
				adminEdits();
			}
			
			System.out.println("New balance of: "+ allAccHash.get(acct.accNum).balance);
			Menu.bankLog.info("New balance of: "+ allAccHash.get(acct.accNum).balance);
			adminEdits();
			break;
			
		case "3" : 
			System.out.println("Enter Acct# for transfer.");
			String target1 = scan.nextLine();

			if(allAccHash.containsKey(target1)) {
				
				System.out.println("Enter amount of transfer.");
				float trans = scan.nextFloat();
				scan.nextLine();
				
				if(allAccHash.get(acct.accNum).balance < trans) {
					System.out.println("Overdraft. Not enough in account.");
					adminEdits();
				}
				allAccHash.get(target1).balance+= trans;
				allAccHash.get(acct.accNum).balance -= trans;
				System.out.println(allAccHash.get(ID.getName()) +" has new balance of: " + allAccHash.get(acct.accNum).balance);
				Menu.bankLog.info(allAccHash.get(ID.getName()) +" has new balance of: " + allAccHash.get(acct.accNum).balance);
			}
			if(!allCustHash.containsKey(target1)) {
				System.out.println("Not a match, sorry.");
				adminEdits();
			}
			break;
			
		case "4" :
			System.out.println("Enter Acct# to be closed.");
			String target3 = scan.nextLine();
			
			System.out.println("Enter corresponding User ID.");
			String target4 = scan.nextLine();

			if(allAccHash.containsKey(target3) && allCustHash.containsKey(target4)) {
				allAccHash.remove(acct.accNum);
				allCustHash.containsKey(target4);
				System.out.println("Account closed.");
				adminEdits();
			}
			else{
				System.out.println("Not a match, sorry.");
				adminEdits();
			}
			break;
		case "5" :
			runAmenu();
			break;
			
		default :
			System.out.println("Invalid option");
			adminEdits();
			}
	}
	
////////////////////////////SERIALIZATION/////////////////////////////////////////////////////////////////////////////////////////////
	public static void writePendingCustomer(String filename, ArrayList<Customer> pendingCust) {// Write Customer cust obj into txt.file
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			oos.writeObject(pendingCust);
		}catch (IOException a){
			a.printStackTrace();
			}
		}
}
