package com.project0.bankapp;

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
	 * javadocs
	 * @author Cristian Adon
	 * @param into my methods
	 */
	private static final long serialVersionUID = 9194717891151263975L;
	
	Random generator = new Random();// generate random number for customer ID
	
	//private variables
	private String custFname;
	private String custLname;
	private String userName;
	private String password;
	private int custID= generator.nextInt(300);
	String stringCustID = Integer.toString(custID);
	private int acctID = generator.nextInt(300);
	private String accID = Integer.toString(acctID);
	private String status = "Pending";
	private double bal = 0.00;
	ArrayList<String> CList = new ArrayList<String>();
	
	
	//no- args constructor
	public Customer(){
		super();
		
	}
	
	//constructor
	public Customer(String custFname, String custLname, String userName, String password, String custID,String accID,String status, double bal) {
		super();
		this.custFname = custFname;
		this.custLname = custLname;
		this.userName = userName;
		this.password = password;
		this.stringCustID = custID;
		this.accID = accID;
		this.bal= bal;
		this.status = status;
		

	}

	// variables getters
	public String getCustFname() {
		return custFname;
	}
	//getting customer last name
	public String getCustLname() {
		return custLname;
	}
	//getting username
	public String getUserName() {
		return userName;
	}
	// getting user password
	public String getPassword() {
		return password;
	}
	//getting customer ID
	public String getCustID() {
		return stringCustID;
	}
	//getting account ID
	public String getAccID() {
		return accID;
	}
	
	public double getBal() {
		return bal;
	}

	public String getStatus() {
		return status;
	}

	// variables setters
	public void setBal(double bal) {
		this.bal = bal;
	}

	public void setAccID(String accID) {
		this.accID = accID;
	}

	
	public void setCustFname(String custFname) {
		this.custFname = custFname;
	}
	//setting customer last name
	public void setCustLname(String custLname) {
		this.custLname = custLname;
	}
	//setting customer user name
	public void setUserName(String userName) {
		this.userName = userName;
	}
	//setting customer password
	public void setPassword(String password) {
		this.password = password;
	}
	//setting customer ID
	public void setCustID(String custID) {
		this.stringCustID = custID;
	}
       // setting account status 
	public void setStatus(String status) {
		this.status = status;
	}

	// write method for customer
	public void writeCustObject(String filename, Object obj) {
		
		try(ObjectOutputStream custoos = new ObjectOutputStream(new FileOutputStream(filename,true))){
			custoos.writeObject(obj);
			
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
	}// end write method
	
	@Override
	public String toString() {
		return "Customer first name: " + custFname + ", Last name: " + custLname + ", UserName: " + userName
				+ ", Password: " + password + ", Customer ID: " + stringCustID + ", AccountID: " + accID + " ,Status: " + status + " , Balance: " + bal;
	}

	
	public static void writeObject(String filename, Object obj) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			oos.writeObject(obj);
			
		}catch(IOException io) {
			io.printStackTrace();
		}
		
	}
	
	
	public static void readObject(String filename) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			Account.CustomersList = (ArrayList<Customer>)ois.readObject();
			
		}catch(IOException exception) {
			exception.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
}//end class 
