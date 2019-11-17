package com.app.main;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;
	String userName;
	String userPin;
	String Name;
	ArrayList<Account> customerAccount;
	boolean isReg;
	public ArrayList<Account> getCustomerAccount() {
		return customerAccount;
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String userName, String userPin, String Name, boolean isReg) {
		
		this.userName = userName;
		this.userPin = userPin;
		this.Name = Name;
		this.isReg = false;
	}
	public void setCustomerAccount(ArrayList<Account> customerAccount) {
		this.customerAccount = customerAccount;
	}
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
	
}
