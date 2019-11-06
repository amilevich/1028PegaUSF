package com.example.bankaccount;

import java.util.Scanner;

public class Customers {

		//Attributes/Traits
		private int id;
		private String firstName;
		private String lastName;
		private String username;
		private String password;
		private double checkingBalance;
		private double savingBalance;
		private double totalBalance;
		private double transfer;
		
		//Display menu
		public void displayMenu() {
						
			System.out.println("Welcome to Victory Bank" );
			
			System.out.println("***********************");
			
			System.out.println("Menu");
			
			System.out.println("1. Customer" +"\n"+"2. Employee"+"\n"+"3. Admin"+"\n"+"4. Back");
			
		}
		
		//Menu 
		public void Menu(int options) {
			Scanner sc = new Scanner(System.in);
			displayMenu();
			switch(sc.nextInt()) {
			case 1:
				System.out.println("Customer");
				CreateAccount(username, password, firstName, lastName){
//					Use Scanner method for input data
					
					//First Name
					System.out.println("First Name: ");
					String firstName = sc.nextLine();
					setUsername(firstName);
					
					//Last Name
					System.out.println("Last name: ");
					String lastName = sc.nextLine();
					setUsername(lastName);
					
					//Set Usernßame
					System.out.println("Create Username: ");
					String userName = sc.nextLine();
					setUsername(userName);
					System.out.println("Welcome " + getUsername());
					
					//Set Password
					System.out.println("Create Password: ");
					String passWord = sc.nextLine();
					setPassword(passWord);
					
					//Check your user input
					System.out.println("Welcome " + getFirstName() +" "+getLastName()+"\n");
					System.out.println("Your username is: " + getUsername());
					System.out.println("Your password is: " + getPassword());
				}
				break;
			
			case 2:
				System.out.println("Employee");
//				Employees em = new Employees();
//				em.accountApprovalDeny(accept, deny, customer);
//				em.employeeViewAccount(username, password, customer);
//				break;
			
			case 3:
				System.out.println("Admin");
				break;
			
			case 4:
				System.out.println("back");
				break;
			default:
				System.out.println("Select from option");
			}

		}
		
		
		
		//Create a new Account
		public void CreateAccount(String username, String password, String firstName, String lastName) {
			Customers newAccount = new Customers();
			System.out.println(newAccount.getCheckingBalance());
			System.out.println(newAccount.getSavingBalance());
			System.out.println(newAccount.getTotalBalance());
			
		}
		
		//Created a new customer w/ attributes
		public Customers() {
			
			this.checkingBalance = 0;
			this.savingBalance = 0;
			this.totalBalance = this.checkingBalance + this.savingBalance;
		}
		
		
		//Deposit into account balance
		public void Deposit(String type, double depositAmt) {
			
			if(type == "checking deposit") {
				System.out.println("\n" + "Depositing: " + depositAmt + " to Checking balance: " + getCheckingBalance() + "\n");
				this.setCheckingBalance(getCheckingBalance() + depositAmt);
				System.out.println("Total checking balance: " + getCheckingBalance());
			}
			
			if(type == "saving deposit") {
				System.out.println("\n" + "Depositing: " + depositAmt + " to Saving balance " + getSavingBalance() + "\n");
				this.setSavingBalance(getSavingBalance() + depositAmt) ;
				System.out.println("Total saving balance: " + getSavingBalance());
			}
		}
		
		
		//Withdraw from account balance
		public void Withdraw(String type, double withdrawAmt) {
			
			if(type == "checking withdraw") {
				System.out.println("\n" + "Withdraw: " + withdrawAmt + " from Checking balance " + getCheckingBalance());
				this.setCheckingBalance(getCheckingBalance() - withdrawAmt);
				System.out.println("\n" + "Total checking balance: " + getCheckingBalance() + "\n");
			}
			
			if(type == "saving withdraw") {
				System.out.println("\n" + "Withdraw: " + withdrawAmt + " from Saving balance " + getSavingBalance() + "\n");
				this.setSavingBalance(getSavingBalance() - withdrawAmt);
				System.out.println("\n" + "Total saving balance: " + getSavingBalance() + "\n");
			}
		}
		
		
		//View Customer Account
		public void customerList(String account, String password, Customers customer) {
		System.out.println("This account belongs to  " + customer.getUsername());
		System.out.println("Checking balance for " + customer.getUsername() + " is: " + customer.getCheckingBalance());
		System.out.println("Saving balance for " + customer.getUsername() + " is: " + customer.getSavingBalance());
		System.out.println("Total balance for " + customer.getUsername() + " is: " + customer.getTotalBalance() +"\n");
		}

		
		
		
		//Getter and Setter
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}



		public String getLastName() {
			return lastName;
		}



		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public double getCheckingBalance() {
			return checkingBalance;
		}
		public void setCheckingBalance(double checkingBalance) {
			this.checkingBalance = checkingBalance;
		}
		public double getSavingBalance() {
			return savingBalance;
		}
		public void setSavingBalance(double savingBalance) {
			this.savingBalance = savingBalance;
		}
		public double getTotalBalance() {
			return totalBalance;
		}
		public void setTotalBalance(double totalBalance) {
			this.totalBalance = totalBalance;
		}
		public double getTransfer() {
			return transfer;
		}
		public void setTransfer(double transfer) {
			this.transfer = transfer;
		}
		
}
		

		
		
		
		
		

		
		
		