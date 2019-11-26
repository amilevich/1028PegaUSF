package com.app.main;
package com.app.main;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.io.FileOutputStream;
import org.apache.log4j.Logger;

public class JunitTest {





		public final static Logger bankLog = Logger.getLogger(Logger.class);
		
		static float deposit = 0f;
		static float withdraw = 0f;
		static float transfer = 0f;
		
		public static Scanner scan = new Scanner(System.in);
		
		public static Customer ID = new Customer(); // Customer Obj
		public static Admin admin = new Admin(); // Admin Obj
		public static Employee employee = new Employee();// Employee Obj
		static Account acct = new Account();
		
		public static ArrayList<Customer> pendingCust = new ArrayList<Customer>();// Pending Accts Arraylist
		public static Map <String, Customer> validAccts = new HashMap<String, Customer>();
		//public static HashMap<String, Customer> allCustHash = Customer.readCustomers(); //Cust to Cust, auto fetches
		//public static HashMap<String, Account> allAccHash = Account.readAccounts();
		static String filename = "temp.ser";
		
		BankImpl bankDao = new BankImpl();
		HashMap<String, Customer> allCustHash;
		HashMap<String, Account> allAccHash; 
		
		Menu(){
			this.allCustHash = bankDao.getCHashMap(); 
			this.allAccHash = bankDao.getAHashMap(); 
		}

		public static void main(String[] args) {

		}
		
		public void runWelcomeMenu() { //Main Menu
			
			System.out.println("Welcome to your local bank." + '\n'+ "1. Register" + '\n' + "2. Login" + '\n' + "3. Exit");
			String option = scan.nextLine(); //Scanner String
			
			switch (option) {
			case "1": //Registration
				Account acct1 = new Account();
				allAccHash.put(acct1.accNum, acct1);// Generate acct and assign
				System.out.println("Welcome to account regristration. Please enter your full name.");
				String uName = scan.nextLine();
				ID.setName(uName);

				System.out.println("Please enter a username.");
				String uUsername = scan.nextLine();
				ID.userName= (uUsername);
				allAccHash.get(acct1.accNum).customers.add(uUsername); 

				System.out.println("Please enter a four digit pin number.");
				String uPin = scan.nextLine();
				int pinLimit = String.valueOf(uPin).length();
				if(pinLimit > 4 || pinLimit <= 3) {//If not a string of 4 digits, print this
					runRegMenu();
				}else{
					ID.userPin = uPin;
				}
				
				System.out.println("What's your initial deposit amount?");
				float uBalance = scan.nextFloat();
				scan.nextLine();
				allAccHash.get(acct1.accNum).balance = uBalance;
				Menu.bankLog.info(allAccHash.get(acct1.accNum).balance = uBalance);

				Customer newCustomer = new Customer(0, uUsername, uPin, uName);
				pendingCust.add(newCustomer);
				
				System.out.println("Is this a single or joint account?" + '\n' + "1. Joint" + '\n'+ "2. Single");
				String uJoint = scan.nextLine();

				if(uJoint.equals("1")) {// Joint

					System.out.println("Joint account setup. Please enter full name.");
					String jName = scan.nextLine();
					ID.setName(jName);

					System.out.println("Please enter a username.");
					String jUsername = scan.nextLine();
					ID.userName= (jUsername);
					allAccHash.get(acct1.accNum).customers.add(jUsername);

					System.out.println("Please enter a four digit pin number.");
					String jPin = scan.nextLine();
					int pinLimit1 = String.valueOf(jPin).length();
					if(pinLimit1 > 4 || pinLimit1 <= 3) {//If not a sting of 4 digits, print this
						runRegMenu();
					}else{
						ID.userPin = jPin;
						Customer newJointCustomer =  new Customer(1, jName, jUsername, jPin);
						pendingCust.add(newJointCustomer);
						allCustHash.put(newJointCustomer.userName, newJointCustomer);
						System.out.println("Joint Account submitted and awaiting approval." + '\n');
					}
				}
				if(uJoint.equals("2")) {// Single
					System.out.println("Confirmed single account." + '\n');
				}
				newCustomer.accounts.add(acct1.accNum);
				allCustHash.put(newCustomer.userName, newCustomer);// stored into hashmap
				System.out.println("Okay " + uName + ". Please await account approval and review your account details:" +'\n'
				+ '\n' + "Personal Info- Name: " + uName + " Username: " + uUsername + " Userpin: " + uPin + '\n' + allAccHash.get(acct1.accNum) +'\n');
				runWelcomeMenu();
				break;
				
			case "2": runLoginMenu(); //Login
			break;
			
			case "3" :
				Account.writeAccounts(allAccHash);
				Customer.writeCustomers(allCustHash);
				bankDao.insertAllAccts(allAccHash);
				bankDao.insertAllCusts(allCustHash);
				System.exit(0);
			break;
			
			default: 
				System.out.println("Invalid option");
				runWelcomeMenu();
			}
		}
		
		public void runRegMenu() {//Reg. menu recursive
			
			String option1 = scan.nextLine();
			switch (option1) {
			case "1": //Registration
				Account acct = new Account();
				allAccHash.put(acct.accNum, acct);// Generate acct and assign
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
				Menu.bankLog.info(allAccHash.get(acct.accNum).balance = uBalance);

				Customer newCustomer = new Customer(0, uUsername, uPin, uName);
				pendingCust.add(newCustomer);
				
				System.out.println("Is this a single or joint account?" + '\n' + "1. Joint" + '\n'+ "2. Single");
				String uJoint = scan.nextLine();
				
				if(uJoint.equals("1")) {// Joint
					
					System.out.println("Joint account setup. Please enter full name.");
					String jName = scan.nextLine();
					ID.setName(jName);

					System.out.println("Please enter a username.");
					String jUsername = scan.nextLine();
					ID.userName= (jUsername);
					allAccHash.get(acct.accNum).customers.add(jUsername); 

					System.out.println("Please enter a four digit pin number.");
					String jPin = scan.nextLine();
					int pinLimit1 = String.valueOf(jPin).length();
					if(pinLimit1 > 4 || pinLimit1 <= 3) {//If not a sting of 4 digits, print this
						runRegMenu();
					}else{
						ID.userPin = jPin;
//						Customer newJointCustomer =  new Customer(jName, jUsername, jPin);
//						pendingCust.add(newJointCustomer);
//						allCustHash.put(newJointCustomer.userName, newJointCustomer);
						System.out.println("Joint Account submitted and awaiting approval." + '\n');
					}
				}
				if(uJoint.equals("2")) {// Single
					System.out.println("Confirmed single account." + '\n');
				}
				
				newCustomer.accounts.add(acct.accNum);
				allCustHash.put(newCustomer.userName, newCustomer);// stored into hashmap
				System.out.println("Okay " + uName + ". Please await account approval and review your account details:" +'\n'
				+ '\n' + "Personal Info- Name: " + uName + " Username: " + uUsername + " Userpin: " + uPin + '\n' + allAccHash.get(acct.accNum) +'\n');
				
				runWelcomeMenu();
				break;
				
			case "2": runLoginMenu(); //Login
			break;
			
			default: 
				System.out.println("Invalid option");
				runWelcomeMenu();
			}	
		}
		
		public void runLoginMenu() {// Login for all accounts
			System.out.println("Welcome to login, please enter your username.");
			String uName0 = scan.nextLine();

			System.out.println("Enter pin number.");
			String uPin0 = scan.nextLine();

			if(uName0.equals(admin.userName) && uPin0.equals(admin.userPin)){
				runAmenu();
			}else if(uName0.equals(employee.userName) && uPin0.equals(employee.userPin)){
				runEmenu();
			}
			if(allCustHash.containsKey(uName0) && allCustHash.get(uName0).userPin.equals(uPin0) && allCustHash.get(uName0).Status.equals("Approved")) {
				System.out.println("Logging in...");
				runCmenu();

				if((allCustHash.get(uName0).Status.equals("pending"))) {
					System.out.println("This account is pending. Please wait for Admin approval.");
					runWelcomeMenu();
				} 
				if (allCustHash.get(uName0).accounts.size() > 1) {
					System.out.println("Which account would you like to access?");
					String option1 = allCustHash.get(uName0).accounts.get(0);
					String option2 = allCustHash.get(uName0).accounts.get(1);
					System.out.println("1. Joint Acct. User:" + option1 + " or " + "Joint Acct. User:" + option2 );
					String login = scan.nextLine();

					if(login.equals("1")) {
						System.out.println("Ok you'll be using: " + allCustHash.get(uName0).accounts.get(0));
						String jointAccNum = allCustHash.get(uName0).accounts.get(0);
						runCmenu();

					}else {
						System.out.println("Ok you'll be using: " + allCustHash.get(uName0).accounts.get(1));
						String singleAccNum = allCustHash.get(uName0).accounts.get(1);
						runCmenu();
					}
				}
			}else{ 
				System.out.println("Invalid Login.");
				runWelcomeMenu();
			}

		}
		
		public String runCmenu(String test) {//Menu for customer banking
			
			System.out.println("Welcome, how may I help you today?" + '\n' + "1. Deposit" + '\n' + "2. Withdraw" + '\n' + "3. Transfer" + '\n'+ "4. Exit");
			
			String option2 = test; 
			switch (option2) {
			
			case "1": //Deposit
				System.out.println("How much would you like to deposit?");
				//float dep = scan.nextFloat();
				
				//scan.nextLine();
				//allAccHash.get(acct.accNum).balance += dep;
				
				//System.out.println("New balance: $" + allAccHash.get(acct.accNum).balance);
				//Menu.bankLog.info("New balance: $" + allAccHash.get(acct.accNum).balance);
				
				//runCmenu();
				//break;
				return "pass";
				
			case "2": //Withdrawl
				System.out.println("How much would you like to withdraw?");
				float wit = scan.nextFloat();
				scan.next();
				
				if(allAccHash.get(acct.accNum).balance < wit) {
					System.out.println("Overdraft. Not enough in account.");
					//runCmenu();
				}else {
					scan.nextLine();
					allAccHash.get(acct.accNum).balance -= wit;

					System.out.println("New balance: $" + allAccHash.get(acct.accNum).balance);
					Menu.bankLog.info("New balance: $" + allAccHash.get(acct.accNum).balance);
					//runCmenu();
				}
				return "fail";
				
			case "3": //Transfer
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
					allAccHash.get(target1).balance += trans;
					allAccHash.get(acct.accNum).balance -= trans;
					System.out.println(allAccHash.get(ID.getName()) +" has new balance of: $" + allAccHash.get(acct.accNum).balance);
					Menu.bankLog.info(allAccHash.get(ID.getName()) +" has new balance of: $" + allAccHash.get(acct.accNum).balance);
				}
				if(!allCustHash.containsKey(target1)) {
					System.out.println("Not a match, sorry.");
					adminEdits();
				}
				//runCmenu();
				return "fail";

			case "4": // Exit
				System.out.println("Transaction complete.");
				runWelcomeMenu();
				return "fail";
				
			default :
				System.out.println("Invalid input.");
				return "fail";
				}
			return "fail";
			}

		public void runEmenu() {// Run Employee menu
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
		public String runAmenu(String s) {// Run admin menu
			System.out.println("Welcome "  + admin.Name + '\n' +"1. View Pending Accounts" + '\n' + "2. Edit Accounts" + '\n' + "3. Sign-Out");// Deposit, Withdraw, Transfer with all accounts

				String option3 = s;
				switch (option3) {
				
				case "1": //Pending Accts
					//adminApproval();
					return "pass";
					
				case "2": //Edit
					adminEdits();
					return "fail";
					
				case "3": // Exit
					System.out.println("Signing out.");
					runLoginMenu();
					return "fail";
					
				default :
					System.out.println("Invalid input.");
					return "fail";
					}

		}
		public static void adminView() {
			System.out.println("Show all customers");
		}
		public void adminApproval() {
			String options="";
			for(int x = 0; x < pendingCust.size(); x++) {
				System.out.println(pendingCust.size());
				System.out.println("ACCOUNT IN PENDING: " + pendingCust.get(x));
				System.out.println("1. Approve");
				System.out.println("2. Deny");

				options =scan.next();

				switch(options) {
				case "1" :
					System.out.println("Enter Customer username to confirm approval: ");
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
					System.out.println("Type Customer username to confirm denial: ");
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
			System.out.println("No more accounts. Returning to previous menu." +'\n');
			runAmenu();
		}
			
		public void adminEdits() {
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
				
				System.out.println("New balance of: $"+ allAccHash.get(acct.accNum).balance);
				Menu.bankLog.info("New balance of: $"+ allAccHash.get(acct.accNum).balance);
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
				
				System.out.println("New balance of: $"+ allAccHash.get(acct.accNum).balance);
				Menu.bankLog.info("New balance of: $"+ allAccHash.get(acct.accNum).balance);
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
					System.out.println(allAccHash.get(ID.getName()) +" has new balance of: $" + allAccHash.get(acct.accNum).balance);
					Menu.bankLog.info(allAccHash.get(ID.getName()) +" has new balance of: $" + allAccHash.get(acct.accNum).balance);
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



