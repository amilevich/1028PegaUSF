package com.bank.model;

import java.io.Serializable;

public class Account implements Serializable {

	private static final long serialVersionUID = 5635825819705054254L;

	// Variables for single and joint account
	private int accountID;
	private String accountNumber;
	private double accountBalance;
	private String firstName;
	private String lastName;
	private String address;
	private String username;
	private String password;

	private String firstName2 = null;
	private String lastName2 = null;
	private String address2 = null;
	private String username2 = null;
	private String password2 = null;

	public Account(String accountNumber, double accountBalance, String firstName, String lastName, String address,
			String username, String password) {
		super();
		this.accountNumber = accountNumber;
		// Initialize balance to zero
		this.accountBalance = accountBalance;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.username = username;
		this.password = password;
	}

	public Account(int accountID, String accountNumber, double accountBalance, String firstName, String lastName,
			String address, String username, String password) {
		super();
		this.accountID = accountID;
		this.accountNumber = accountNumber;
		// Initialize balance to zero
		this.accountBalance = accountBalance;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.username = username;
		this.password = password;
	}


	// Constructors for both single and joint accounts
	public String getFirstName2() {
		return firstName2;
	}

	public void setFirstName2(String firstName2) {
		this.firstName2 = firstName2;
	}

	public String getLastName2() {
		return lastName2;
	}

	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getUsername2() {
		return username2;
	}

	public void setUsername2(String username2) {
		this.username2 = username2;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
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
	
	

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	@Override
	public String toString() {
		// This if statement chooses which toString method to use depending on if its a
		// single or joint account
		// If usernam2 is null use single account toString else joint account toString
		return "Account ID: " + accountID + "\nAccount Number: " + accountNumber + "\nAccount Balance: "
				+ accountBalance + "\nName: " + firstName + " " + lastName + "\nAddress: " + address;

	}
}
