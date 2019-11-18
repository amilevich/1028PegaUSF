
package com.project.pt1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

enum Status {

	PENDING, APPROVED, DENIED;
}

enum jStatus {
	NOT_JOINT,PENDING, APPROVED, DENIED, LOST_IN_BEUROCRACY;
}

public class Customer implements Serializable {


	final static Logger Loggy = Logger.getLogger(Customer.class);
	
	private String username;
	private String password;
	public Status appStatus;
	public jStatus jointStatus;
	BankAccount account = new BankAccount();
	public double funds = 0;
	String[] JointAppDetails = new String[2];
	
	


	Customer() {
		appStatus = Status.PENDING;
	}

	public Customer(String x, String y) {

		this.username = x;
		this.password = y;
		appStatus = Status.PENDING;
		jointStatus = jStatus.NOT_JOINT;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String name) {
		this.username = name;
	}

	public String getPassword() {
		return password;
	}
	
	public double getFunds() {
		return funds;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setFunds(double x) {
		this.funds = x;
	}


	public void reDisplay() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Would you like to make another transaction?");
		System.out.println("1 \t Yes");
		System.out.println("2 \t No");

		int input = sc.nextInt();
		switch (input) {
		case 1:
			customerPrompt();
			break;
		case 2:
			System.out.println("Thank you for using Atlas Bank, Goodbye.");
			System.exit(0);
		}

	}

	public void setStatus(Status stat) {
		this.appStatus = stat;
	}

	public Status getStatus() {
		return appStatus;
	}
	
	@SuppressWarnings("unchecked")
	public void updateFile() { 
		Loggy.info(this.getUsername() +" File Updated.");
		String fileName = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/applications/customers.ser";
		ArrayList<Customer> cust = null;


			cust = MainDriver.readCustomers();
		

			try { 
				
				cust = addRemove(cust,this);

				FileOutputStream fop = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fop);

				oos.writeObject(cust);
				
				fop.close();
				oos.close();
				
				System.out.println("Account Updated for '" + this.getUsername()+ "'");

			} catch (IOException ex) {
				System.out.println("IOException is caught - Customer Update Error");
			}
	}

		

	public void customerPrompt() {
		account.readFile();
		Scanner sc = new Scanner(System.in);
		System.out.println("What would you like to do?");
		System.out.println("1 \t Deposit Funds");
		System.out.println("2 \t Withdraw Funds");
		System.out.println("3 \t Transfer Funds");
		System.out.println("4 \t View Balance");
		System.out.println("5 \t Apply for a Joint Account"); 
		System.out.println("6 \t Logout.");
		System.out.println("Please make a selection(1-6)");

		int selection = sc.nextInt();
		switch (selection) {

		case 1:
			System.out.print("How much would you like to deposit?");
			int depo = sc.nextInt();
			account.depositFunds(depo);
			Loggy.info("Customer deposit successful.");
			reDisplay();
			break;
		case 2:
			System.out.println("Available funds .... $" + this.getFunds());
			System.out.println("Please enter withdrawl amount.");

			double wd = sc.nextDouble();
			account.withdrawFunds(wd);
			Loggy.info("Customer withdrawl successful.");
			reDisplay();

			break;
		case 3:
			break;
		case 4:
			System.out.println("Account Balance .... " + account.getFunds());
			reDisplay();
			break;
		case 5:
			System.out.println("Please enter the username for the secondary account");
			String tempName = sc.next();

			System.out.println("Please enter the password for the secondary account");
			String tempPw = sc.next();
			jointApplication(tempName, tempPw);
			Loggy.info("Joint application sent. Between " + this.getUsername() +" and" + tempName);
			break;
		case 6:
			System.out.println("Thank you for banking with Atlas");
			this.account.updateFile();
			System.exit(0);
			MainDriver.prompt();

			break;
		}
	}

	@SuppressWarnings("unchecked")
	public void jointApplication(String x, String y) { //UPDATED NOT TESTED

		{

	
			String fileName = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/applications/customers.ser"; 

			Customer object1 = null;
			ArrayList<Customer> cust = null;
			try {
				// Reading the object from a file
				FileInputStream file = new FileInputStream(fileName);
				ObjectInputStream in = new ObjectInputStream(file);

				// Method for deserialization of object
				cust = (ArrayList<Customer>) in.readObject();

				in.close();
				file.close();

				for(Customer temp:cust) {
					if(temp.getUsername().contentEquals(x) && temp.getPassword().contentEquals(y)) {
						
			
						this.JointAppDetails[0] = x; //These details will be fetched when employee class calls it.
						this.JointAppDetails[1] = y;
						
					
						this.jointStatus = jStatus.PENDING;
						
						temp.updateFile();
						
						System.out.println("Joint Account Application Successfully Sent.");
						System.out.println("1 \t Continue");
						System.out.println("2 \t Logout");
						Scanner sc = new Scanner(System.in);
						int cont = sc.nextInt();
						switch (cont) {
						case 1:
							this.customerPrompt();
							break;
						case 2:
							System.out.println("Thank you for using Atlas Bank. Goodbye.");
							MainDriver.prompt();
			
						}
					}
					 else {

					System.out.println("Secondary Account Password Incorrect. \nWould you like to try again? ");
																												
					System.out.println("1\tYes");
					System.out.println("2\tNo");
					System.out.println("Please make a selection(1-2)");
					@SuppressWarnings("resource")
					Scanner sc = new Scanner(System.in);
					int selection = sc.nextInt();

					switch (selection) {
					case 1:
						System.out.println("Please enter secondary account password.");
						String pw = sc.next();

						jointApplication(x, pw); // uses same username that was passed to it, but new password
						break;
					case 2: // Send back to customer screen.
						customerPrompt();
						break;
					default:
						customerPrompt();
					}
				}

				}}

			catch (IOException ex) {
				System.out.println("No user found by the name: '" + x + "' in joint application.");
			}

			catch (ClassNotFoundException ex) {
				System.out.println("ClassNotFoundException is caught");
			}

		}
	}

	public static ArrayList<Customer> addRemove(ArrayList<Customer> x, Customer y) {
		for(int i =0;i<x.size();i++) {
			
			if(x.get(i).getUsername().contentEquals(y.getUsername())) {
				
				
				x.remove(i);
				x.add(i, y);
				
				
			}
			
		}
		return x;
	}
	
	public String toString() {
		return "Name: [" + this.username +"] " +
	
				"AccountID: [" + this.account.accountID+ "] Application Status: [" + this.appStatus+"]";
	}
	public String toDetailedString() {
		return "Name: [" + this.username +"] " 
				+ " AccountID: [" + this.account.accountID+ "] Funds: "+this.getFunds()+  "Application Status: [" + this.appStatus+"] Joint Status: ["+this.jointStatus + "]";
	}
	
	public void transferFunds() {
	
		ArrayList<Customer> temp = MainDriver.readCustomers();
		ArrayList<Customer> jAccounts = new ArrayList<Customer>();
		int count = 1;
		for(Customer x:temp) {
			
			if(!(x.username.contentEquals(this.username)) && x.account.accountID == this.account.getID()) {
				jAccounts.add(x);
				System.out.println("["+count+"]" + "-" + x.username + "...." + x.funds);
				count++;
				
			}
		}
			if(jAccounts.isEmpty()) {
				System.out.println("You currently have no open joint accounts.");
				customerPrompt();
			}
			else {
				Scanner sc = new Scanner(System.in);
				System.out.println("Which account would you like to transfer funds?");
				int input = sc.nextInt();
				Customer z = jAccounts.get(input-1);
				moveMoney(z);
				
			}
			}

	public void moveMoney(Customer x) {
		System.out.println("Current Account balance...." + this.getFunds());
		System.out.println(" Account balance...." + x.getFunds());
		
		System.out.println("[1] Transfer to Joint Account");
		System.out.println("[2] Transfer from Joint Account");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		switch(input) {
		case 1: System.out.println("Please enter outgoing transfer amount: ");
		double trans = sc.nextDouble();
		if(this.getFunds() <trans) {
			System.out.println("Insufficient funds.");
			moveMoney(x);
		}
		else {
			this.funds -=trans;
			x.funds+=trans;
			updateFile();
			x.updateFile();
			System.out.println("Transfer successfuly made.");
			System.out.println("New Account Balance...."+ this.funds);
			System.out.println("Joint Account Balance...."+ x.getFunds());
			
			MainDriver.promptContinue();
			customerPrompt();
			
		}
			break;
		case 2:
			System.out.println("Please enter incoming transfer amount: ");
			double intrans = sc.nextDouble();
			if(x.getFunds() < intrans) {
				System.out.println("Insufficient funds.");
				moveMoney(x);
			}
			else {
				Loggy.info("Employee Username directory not found.");
				this.funds +=intrans;
				x.funds-=intrans;
				updateFile();
				x.updateFile();
				System.out.println("Transfer successfuly made.");
				System.out.println("New Account Balance...."+ this.funds);
				System.out.println("Joint Account Balance...."+ x.getFunds());
				MainDriver.promptContinue();
				customerPrompt();
				
			}
			break;
		}
		
		
	}
}
