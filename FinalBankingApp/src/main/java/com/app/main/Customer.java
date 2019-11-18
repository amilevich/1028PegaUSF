package com.app.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;
	String userName;
	String userPin;
	String Name;
	String Status;
	ArrayList<String> accounts = new ArrayList<String>();	//Acct Number - joint
	
//	public ArrayList<Account> getCustomerAccount() {
//		return customerAccount;
//	}
	public Customer() {
		
	}
	
	public Customer(String userName, String userPin, String Name) {
		this.userName = userName;
		this.userPin = userPin;
		this.Name = Name;
		this.accounts= new ArrayList<String>();
		this.Status = "pending";
	}
//	public void setCustomerAccount(ArrayList<Account> customerAccount) {
//		this.customerAccount = customerAccount;
//	}
	/**
	 * 
	 */
	
	@Override
	public String toString() {
		return "Customer [userName=" + userName + ", userPin=" + userPin + ", Name=" + Name + "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPin() {
		return userPin;
	}
	public void setUserPin(String userPin) {
		this.userPin = userPin;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}	
	
	public void addAccount(String accNum) {
		//this.customerAccount.add(this.getCustomerAccount().size(), account);
		this.accounts.add(accNum);
	}
	
	public void removeAccount(String accNum) {
		this.accounts.remove(accNum);
	}
	
	public static HashMap<String, Customer> readCustomers(){
		HashMap<String, Customer> allCustomers = new HashMap<String, Customer>();
		String filename = "customers.ser";
		FileInputStream myFis = null;
		ObjectInputStream myOin = null;
		
		try {
			myFis = new FileInputStream(filename);
			myOin = new ObjectInputStream(myFis);
			
			if(myFis.available() != 0) {
				allCustomers = (HashMap<String, Customer>)myOin.readObject();
				myOin.close();
			}
		} catch(Exception e) {
			System.out.println("Re-initializing data base due to io error.");
			Customer ID = new Customer("Prev.Acct", "0000", "Temp" );
			Account acc = new Account("1", "Prev.Acct");
			ID.accounts.add(acc.accNum);
			HashMap<String, Account> hashAcc = new HashMap<>();
			HashMap<String, Customer> hashCust = new HashMap<>();
			hashAcc.put(acc.accNum, acc);
			hashCust.put(ID.userName, ID);
			Customer.writeCustomers(hashCust);
			Account.writeAccounts(hashAcc);
			Customer.writeCustomers(hashCust);
			System.out.println("Initialization complete. Please re-run the program.");
			//e.printStackTrace();
		}
		return allCustomers;
	}

	public static void writeCustomers(HashMap<String, Customer>cust) {// Write Customer obj. into txt.file
		boolean append = false; 
		String filename = "customers.ser";
		try
		{
			FileOutputStream file = new FileOutputStream(filename, append);
			ObjectOutputStream oos = new ObjectOutputStream(file); 
			oos.writeObject(cust);
			oos.close();
			file.close();
		}catch (IOException a){
			a.printStackTrace();
		}
	}
}


