package com.app.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Account implements Serializable{

	static final long serialVersionUID = -5419807147720782881L;
	/**
	 * 
	 */
	int serialNum;
	float balance;
	long accountNumber;
	ArrayList<String> customers = new ArrayList<String>(); //Cust IDs

	String accNum; 
	public Account() {
		
	}
	
	public Account(int serialNum, String accNum, String id) {
		super();
		this.serialNum = serialNum;
		this.balance = 0;
		this.accountNumber = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
		this.customers.add(id);	
		this.accNum = Long.toString(this.accountNumber);
	}
	
	public Account(int serialNum, String accNum, float balance) {
		super();
		this.serialNum = serialNum;
		this.balance = balance;
		this.accNum = accNum; 
	}
	
//	public Account() {
//		super();
//		this.balance = 0;
//		this.accountNumber = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
//		this.customers=  new ArrayList<String>();	
//		this.accNum = Long.toString(this.accountNumber);
//	}
//
//	public Account(String accNum, String id) {
//		super();
//		this.balance = 0;
//		this.accountNumber = 12;
//		this.customers.add(id);	
//		this.accNum = accNum;
//	
	
	@Override
	public String toString() {
		return "Account Info- Account #: " + accountNumber + " Balance: $" + balance;
	}

	public int getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public static HashMap<String, Account> readAccounts(){
		HashMap<String, Account> allAccounts= new HashMap<String, Account>();
		String filename1 = "accounts.ser";

		try {
			FileInputStream myFis = new FileInputStream(filename1);
			ObjectInputStream myOin = new ObjectInputStream(myFis);			
			allAccounts = (HashMap<String,Account>)myOin.readObject();
			myOin.close();

		}catch(Exception e) {
			System.out.println("Re-initializing data base due to io error.");
			Customer ID = new Customer(0000, "Prev.Acct", "0000", "Temp" );
			Account acc = new Account(0000, "1", "Prev.Acct");
			ID.accounts.add(acc.accNum);
			HashMap<String, Account> hashAcc = new HashMap<>();
			HashMap<String, Customer> hashCust = new HashMap<>();
			hashAcc.put(acc.accNum, acc);
			hashCust.put(ID.userName, ID);
			Customer.writeCustomers(hashCust);
			Account.writeAccounts(hashAcc);
			Customer.writeCustomers(hashCust);
			System.out.println("Initialization complete. Please re-run the program.");
		}
		return allAccounts;
	}

	public static void writeAccounts(HashMap<String, Account>accounts) {// Write Accts obj. into txt.file
		boolean append = false; 
		String filename = "accounts.ser";
		try {

			FileOutputStream file = new FileOutputStream(filename, append);
			ObjectOutputStream oos = new ObjectOutputStream(file); 
			oos.writeObject(accounts);
			oos.close();
			file.close();

		}catch (IOException a){
			a.printStackTrace();
		}
	}

}
