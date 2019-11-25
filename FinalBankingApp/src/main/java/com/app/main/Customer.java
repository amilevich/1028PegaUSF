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
	int serial_ID;
	String userName;
	String userPin;
	String Name;
	String Status;
	ArrayList<String> accounts = new ArrayList<String>(); //Acct Number - Joint
	
	public Customer() {
		
	}
	
	public Customer(int serial_ID, String userName, String userPin, String Name) {
		this.serial_ID = serial_ID;
		this.userName = userName;
		this.userPin = userPin;
		this.Name = Name;
		this.accounts= new ArrayList<String>();
		this.Status = "pending";
	}

	/**
	 * 
	 */
	
	@Override
	public String toString() {
		return "Personal Info- Name: " + Name + " Username: "+ userName + " Userpin: " + userPin;
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
		this.accounts.add(accNum);
	}
	
	public void removeAccount(String accNum) {
		this.accounts.remove(accNum);
	}
	
	public int getSerial_ID() {
		return serial_ID;
	}

	public void setSerial_ID(int serial_ID) {
		this.serial_ID = serial_ID;
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


