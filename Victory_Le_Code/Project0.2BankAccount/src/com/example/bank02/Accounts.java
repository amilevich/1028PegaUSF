package com.example.bank02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Accounts implements Serializable {
	private int accNum;
	private int balance;
	private String accountType;
	private int withdraw;
	private int deposit;
	
	
	
	public Accounts() {
		super();
	}
	
	
	
	public Accounts(int accNum, int balance, String accountType, int withdraw, int deposit) {
		super();
		this.accNum = accNum;
		this.balance = balance;
		this.accountType = accountType;
		this.withdraw = withdraw;
		this.deposit = deposit;
	}
	
//	****************************************************************************************************************************************************
	
	//					MAIN MENU 
	

	Customers cu = new Customers();
	//Create file
	String filename = "Banking.ser";
	//Write the file
	FileOutputStream fos = null;
	ObjectOutputStream oos = null;
//	ArrayList<Object> objectArray = readObject();
	
	try {
		fos = new FileOutputStream(filename);
		oos = new ObjectOutputStream(fos);
		oos.writeObject(ac);
		fos.close();
		oos.close();
	} catch (IOException ex) {
		ex.printStackTrace();
	}
	
	
	

// Menu
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Bank of Victory" + "\n");
		System.out.println("1. Customer");
		System.out.println("2. Employee");
		System.out.println("3. Admin");
		System.out.println("4. Register");

		String menuOption = sc.nextLine();
		
		switch(menuOption) {
		
		case "1":
			System.out.println("Customer Portal");
			
			System.out.println("1. Withdraw");
			System.out.println("2. Deposit");
			System.out.println("3. View");
			
			String input = sc.nextLine();
			switch(input) {
			
			case "1":
				//Withdraw call
				System.out.println("Enter withdraw amount");		
				String withdraw = sc.nextLine();
				ac.withdraw(0, 0, 100);
				System.out.println("Total balance " + ac.getBalance());
				break;
				
			case "2":
				//Deposit call
				System.out.println("How much would you like to deposit?");	
				int deposit= sc.nextInt();
//				ac.deposit(0, 0, 0) ;
				ac.deposit( deposit);
				sc.nextLine();
				System.out.println(ac.getDeposit());
				System.out.println("Total balance " + ac.getBalance());
				break;
				
			case "3":
				//Print call
				System.out.println("View my total balance");
				sc.nextLine();
				break;
				
			default:
				System.out.println("Error in the Customer option");
			
			}
			
			
			
			break;
			
			
		case "2":
			System.out.println("Employee Portal");
			
			System.out.println("1. View");
			System.out.println("2. Accept/Deny");
			break;
			
		case "3":
			System.out.println("Admin Portal");
			System.out.println("1. View");
			System.out.println("2. Accept/Deny");
			System.out.println("3. Withdraw");
			System.out.println("4. Deposit");
			break;
			
		case "4":
			ArrayList<String> registrationArray = new ArrayList<String>();
			System.out.println("Registration");
			
			//Username
			System.out.println("Enter Username");
//			String setUsername = cu.setUsername(sc.nextLine());
			
			String getUsername = cu.getUsername();
			System.out.println(getUsername);
			registrationArray.add(getUsername);
			System.out.println( registrationArray.get(0) );
			
			//Password
			System.out.println("Enter Password");
			cu.setPassword(sc.next());
			System.out.println(cu.getPassword());
			System.out.println(registrationArray);
		
			break;
			
		default:
			System.out.println("Invalid input");
			
		}
	public void deposit(int accNum, int balance,  int deposit) {
		this.setDeposit(getDeposit() + balance);
		System.out.println("Deposit " + getDeposit());
		System.out.println("Total " + getBalance());
	}
	
	public void withdraw(int accNum, int balance, int withdraw) {
		this.setWithdraw(getWithdraw() - balance);
		System.out.println("Withdraw " + getWithdraw());
		System.out.println("Total " + getBalance());

	}
	public void deposit(  int deposit) {
		int balance = 0;
		this.setDeposit(getDeposit() + deposit);
		System.out.println("Deposit " + getDeposit());
		this.setBalance(getDeposit() + balance);
	}
	
	
	




	//Getters and Setters
	public int getAccNum() {
		return accNum;
	}



	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}



	public int getBalance() {
		return balance;
	}



	public void setBalance(int balance) {
		this.balance = balance;
	}



	public String getAccountType() {
		return accountType;
	}



	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}



	public int getWithdraw() {
		return withdraw;
	}



	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}



	public int getDeposit() {
		return deposit;
	}



	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}




	
	
	
	
}
