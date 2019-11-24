package com.folder.bank;

import java.io.Serializable;
import java.util.Random;

public class Customers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 973199081453125034L;
	//Random # Generator
	Random randomCustomerId = new Random();
	private int customerId = randomCustomerId.nextInt(10000);
	private int totalBalance;
	private String accountType;
	private String username;
	private String password;
	private int pendingApproved = 0;
	
//	static Scanner input = new Scanner(System.in);
//	static Employees employee = new Employees();
	
	

	//Customers Constructors
	public Customers(){
		super();
		
	}
	
	public Customers(int customerId, int totalBalance, String accountType, String username, String password, int pendingApproved) {
		super();
		this.customerId = customerId;
		this.totalBalance = totalBalance;
		this.accountType = accountType;
		this.username = username;
		this.password = password;
		this.pendingApproved = pendingApproved;
	}
	

	//Getters & Setters

	@Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", totalBalance="
				+ totalBalance + ", accountType= " + accountType + ", username=" + username + ", password=" + password
				+ ", pendingApproved=" + pendingApproved + "]";
	}

	// Get ID
	public int getCustomerId() {
		return customerId;
	}
	// Set ID
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	// Get Total Balance
	public int getTotalBalance() {
		return totalBalance;
	}
	// Set Total Balance
	public void setTotalBalance(int totalBalance) {
		this.totalBalance = totalBalance;
	}
	// Get Account Type
	public String getAccountType() {
		return accountType;
	}
	// Set Account Type
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	// Get User name
	public String getUsername() {
		return username;
	}
	// Set User name
	public void setUsername(String username) {
		this.username = username;
	}
	// Get Password
	public String getPassword() {
		return password;
	}
	// Set Password
	public void setPassword(String password) {
		this.password = password;
	}
	// Get pendingApproved
	public int getPendingApproved() {
		return pendingApproved;
	}
	// Set Password
	public void setPendingApproved(int pendingApproved) {
		this.pendingApproved = pendingApproved;
	}
}