package com.app.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;

public class Menu {
	
	static long accountNumber = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
	static float deposit = 0f;
	static float withdraw = 0f;
	static float transfer = 0f;
	
	public static boolean isReg = false; //Is user registered
	public static Scanner scan = new Scanner(System.in);
	
	public static Customer cust = new Customer(); // Customer Obj
	public static Admin admin = new Admin(); // Admin Obj
	public static Employee employee = new Employee();// Employee Obj
	
	static Account acct = new Account(0, accountNumber);
	
	public static ArrayList<Customer> pendingCust = new ArrayList<Customer>();// Pending Accts Arraylist
	public static Map <String, Customer> validAccts = new HashMap<String, Customer>();// Approved Accts K=String, V=Customer obj
	
	static String filename = "temp.ser";
	
	public static void main(String[] args) {
		writeCustomer(filename, cust); //Reading user object input FileInputStream = write.obj
		readCustomer(filename);	//Writing user object input //serialize, middle - admin edit while pending, seriliaze approve
	}
	
	public static void runWelcomeMenu() { //Main Menu
		
		System.out.println("Welcome to your local bank." + '\n'+ "1. Register" + '\n' + "2. Login");
		String option = scan.nextLine(); //Scanner String
		
		switch (option) {
		case "1": //Registration
			System.out.println("Welcome to account regristration. Please enter your full name.");
			String uName = scan.nextLine();
			cust.setName(uName);

			System.out.println("Please enter a username.");
			String uUsername = scan.nextLine();
			cust.setUserName(uUsername);

			System.out.println("Please enter a four digit pin number.");
			String uPin = scan.nextLine();

			int pinLimit = String.valueOf(uPin).length();
			if(pinLimit > 4 || pinLimit <= 3) {//If not a sting of 4 digits, print this
				runRegMenu();
			}else{
				cust.setUserPin(uPin);
			}

			System.out.println("What's your initial deposit amount?");
			acct.balance = scan.nextFloat();
			scan.nextLine();
			acct.setBalance(acct.balance);

			//pendingCust.add(cust);// add cust(obj) -> accounts arraylist
			writeCustomer(filename, cust); //Write serialization of info assigned by user -> cust(obj) -> txt file
			Customer newCustomer = new Customer(uUsername, uPin, uName, isReg);
			pendingCust.add(newCustomer);
			

			System.out.println("Okay " + cust.Name + " Please await account approval and review your account details:" +'\n' + cust.userName + " "+ cust.userPin + " " + acct.balance);
			runWelcomeMenu();
			break;
			
		case "2": runLoginMenu(); //Login
		break;
		
		default: 
			System.out.println("Invalid option");
			runWelcomeMenu();
		}
	}
	
	public static void runRegMenu() {
		
		String option1 = scan.next(); //Scanner String
		switch (option1) {
		case "1": //Registration
			System.out.println("Welcome to account regristration. Please enter your full name.");
			String uName = scan.nextLine();
			cust.setName(uName);
		
			System.out.println("Please enter a username.");
			String uUsername = scan.nextLine();
			cust.setUserName(uUsername);
		
			System.out.println("Please enter a four digit pin number.");
			String uPin = scan.nextLine();
			
			int pinLimit = String.valueOf(uPin).length();
			if(pinLimit > 4 || pinLimit <= 3) {//If not a sting of 4 digits, print this
				System.out.println("Invalid pin. Please re-enter");
				runRegMenu();
				}else{
					cust.setUserPin(uPin);
					}

			System.out.println("What's your initial deposit amount?");
			float uBalance = scan.nextFloat();
			scan.nextLine();
			acct.setBalance(uBalance);
			System.out.println(acct.balance);
			
			writeCustomer(filename, cust); //Write serialization of info assigned by user -> cust(obj) -> txt file
			Customer newCustomer = new Customer(uUsername, uPin, uName, isReg);
			pendingCust.add(newCustomer);
			
			System.out.println("Okay " + cust.Name + "Please await account approval and review your account details:" +'\n' + cust.userName + cust.userPin + acct.balance);
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
		
			//System.out.println(pendingAccts.size());
			for(int i = 0; i < pendingCust.size(); i++) {// For all customer accounts check for Valid Username & Password match within acct arraylist
				
				if((uName0.equals(cust.userName) && uPin0.equals(cust.userPin))){//works
					System.out.println("Logged in.");
					runCmenu();
					
//					System.out.println(pendingAccts.get(i));
//					System.out.println(pendingAccts);
//					System.out.println(filename);
				}

			}

		if(uName0.equals(admin.userName) && uPin0.equals(admin.userPin)){
			runAmenu();// works
		}
		if(uName0.equals(employee.userName) && uPin0.equals(employee.userPin)){
			runEmenu();
		}
		else {
			System.out.println("Invalid Login.");
			runLoginMenu();
		}
	}
	
	public static void runCmenu() {//Menu for customer banking
		
		System.out.println("Welcome, how may I help you today?" + '\n' + "1. Deposit" + '\n' + "2. Withdraw" + '\n' + "3. Transfer" + '\n'+ "4. Exit");
		
		String option2 = scan.next(); //Scanner String
		switch (option2) {
		
		case "1": //Deposit
			
			System.out.println("How much would you like to deposit?");
			float dep = scan.nextFloat();
			scan.nextLine();
			acct.setBalance(acct.balance + dep);
			System.out.println(acct.balance);
			runCmenu();
			break;
			
		case "2": //Withdrawl
			
			System.out.println("How much would you like to withdraw?");
			float wit = scan.nextFloat();
			scan.nextLine();
			acct.setBalance(acct.balance - wit);
			runCmenu();
			break;
			
		case "3": //Transfer
			System.out.println("Whom am I transfering to?");
			float trans = scan.nextFloat();
			scan.nextLine();
			
			System.out.println("How much am I transfering?");
			runCmenu();
			break;
			
		case "4": // Exit
			System.out.println("Transaction complete.");
			runWelcomeMenu();
			runCmenu();
			break;
			
		default :
			System.out.println("Invalid input.");
			runCmenu();
			}
		}

	public static void runEmenu() {// Run Employee menu
		System.out.println("Welcome Employee_0:" + '\n' + "1. View Open Accounts"); // See personal info and balances
		}
	public static void runAmenu() {// Run admin menu
		System.out.println("Welcome Mr. Ngo:" + '\n' + "1. View Transaction History" + '\n' + "2. View Pending Accounts" + '\n' + "3. Edit Accounts");// Deposit, Withdraw, Transfer with all accounts
		
		String option3 = scan.next(); //Scanner String
		switch (option3) {
		
		case "1": // Cust History
			adminView();
			
			break;
			
		case "2": //Pending Accts
			adminApproval();
			break;
			
		case "3": //Edit
			adminEdits();
			break;
			
		default :
			System.out.println("Invalid input.");
			runCmenu();
			}
	}
	public static void adminView() {
		System.out.println("Show all customers");
	}
	public static void adminApproval() {
		System.out.println("Displaying all pending accounts");
		for(int i=0; i < pendingCust.size(); i++) {
			System.out.println(pendingCust.get(i));
		}
		String options = scan.nextLine(); //Scanner String
		
		ListIterator<Customer> itr = pendingCust.listIterator();
		for(int i = 0; i < pendingCust.size(); i++ ) {
			System.out.println(pendingCust.get(i));
			System.out.println("Approve or deny this account?" + '\n' + "1. Approve" + '\n' + "2. Deny" + '\n' + "3. Exit");
			
			switch (options) {
			
			case "1": //Approve
				validAccts.put(cust.userName + cust.userPin, cust);
				break;
			
			case "2": //Deny
				itr.remove();
				break;
				
			case "3": //Exit
				System.out.println("Closing menu.");
				runAmenu();
				break;
				
			default :
				System.out.println("Invalid option.");
				runAmenu();
			}
		}
	}
	public static void adminEdits() {
		System.out.println("Edit accounts");
	}
	
////////////////////////////SERIALIZATION/////////////////////////////////////////////////////////////////////////////////////////////
	public static void writeCustomer(String filename, Object cust) {// Write Customer cust obj into txt.file
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			oos.writeObject(cust);
		}catch (IOException a){
			a.printStackTrace();
			}
		}
	public static void readCustomer(String filename) {// Read Customer cust obj into txt.file
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			Object object = ois.readObject();
			System.out.println(object);
		}catch(IOException b) {
			b.printStackTrace();
		}catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
	}
	
}
