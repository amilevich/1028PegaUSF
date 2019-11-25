package com.project0;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Customer implements Serializable {
	/**
	 * 
	 *///variables declaration and initialized
	private static final long serialVersionUID = -6815639076385746891L;
	// Declare private variables
	Random randomGenerator = new Random();
	
	private int custId = randomGenerator.nextInt(25);

	
	private int acctId=randomGenerator.nextInt(25);
	ArrayList<String>theList=new ArrayList<String>();
	private String userName;
	
	
	
	private String password;
	private String fName;
	private String lName;
	//private int acctId;

	//public String cusId =randomGenerator.nextInt(70000);
	Account actt = new Account();
	
	private String status ="penging";
	private double balance;
	private int cusId;
	
	
	// Create constructor with no fields
	public Customer() {
		super();

	}

	// create constructor with fields
	public Customer(int acctId,String userName, String password, String fName, String lName, int cusId, String stat, double balance) {
		super();
		
		this.userName = userName;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
		this.cusId = cusId;
		this.status=status;
		this.balance=balance;
		this.acctId = acctId;
		
		
		
		
	}
	
	//getters and setters
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance=balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String stat) {
		this.status = stat;
	}

	public String getUserName() {
		return userName;
	}

	// Creating the getters

	// retrieve customer password
	public String getPassword() {
		return password;
	}

	// method that retrieve customer fisrt name
	public String getfName() {
		return fName;

	}

	// retrieving customer last name
	public String getlName() {
		return lName;
	}

	// retrieve id
	public int getCusId() {
		return cusId;
	}

	// retrieve customer username
	public void setUserName(String userName) {
		this.userName = userName;
	}

	// create setters
	// set the customer last name
	public void setPassword(String password) {
		this.password = password;
	}

	// set the customer first name
	public void setfName(String fName) {
		this.fName = fName;
	}

	// set the customer last name
	public void setlName(String lName) {
		this.lName = lName;
	}

	// set the customer id
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	
	
	

	

	public int getActtId() {
		return acctId;
		
		
	}

	

	

	// creating method that write customer object
	public void writeCustomer(String Filename, Object object) {
		try (ObjectOutputStream cust = new ObjectOutputStream(new FileOutputStream(Filename))) {
			cust.writeObject(object);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

	//ToString method
	@Override
	public String toString() {
		return "Customer First Name= " + fName + ", Last Name= " + lName + ",userName= " + userName + ", password= " + password + " , cusId= " + cusId + ", acttId= " + acctId + ", status= " + status + ", balance= "
				+ balance + "";
	}

	


}
