package com.bank.model;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 5635825819705054254L;

	// Variables for single and joint account
	private String accountNumber;
	private double accountBalance;
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String email;
	private String username;
	private String password;

	private String firstName2 = null;
	private String lastName2 = null;
	private String address2 = null;
	private String phoneNumber2 = null;
	private String email2 = null;
	private String username2 = null;
	private String password2 = null;

	public Person(String accountNumber, String firstName, String lastName, String address, String phoneNumber,
			String email, String username, String password) {
		super();
		this.accountNumber = accountNumber;
		// Initialize balance to zero
		this.accountBalance = 0.0;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	

	public Person(String accountNumber, String firstName, String lastName, String address,
			String phoneNumber, String email, String username, String password, String firstName2, String lastName2,
			String address2, String phoneNumber2, String email2, String username2, String password2) {
		super();
		this.accountNumber = accountNumber;
		// Initialize balance to zero
		this.accountBalance = 0.0;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName2 = firstName2;
		this.lastName2 = lastName2;
		this.address2 = address2;
		this.phoneNumber2 = phoneNumber2;
		this.email2 = email2;
		this.username2 = username2;
		this.password2 = password2;
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

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	@Override
	public String toString() {
		// This if statement chooses which toString method to use depending on if its a single or joint account
		// If usernam2 is null use single account toString else joint account toString
		if (username2 == null) {

			return "Account Number: " + accountNumber + "\nAccount Balance: " + accountBalance + "\nName: " + firstName
					+ " " + lastName + "\nAddress: " + address + "\nPhone Number: " + phoneNumber + "\nEmail: " + email + "\n";

		} else {
			return "Account Number: " + accountNumber + "\nAccount Balance: " + accountBalance + "\nName: " + firstName
					+ " " + lastName + "\nAddress: " + address + "\nPhone Number: " + phoneNumber + "\nEmail: " + email
					+ "\nUser Two Name: " + firstName + " " + lastName + "\nUser Two Address: " + address
					+ "\nUser Two Phone Number: " + phoneNumber + "\nUser Two Email: " + email + "\n";

		}
	}

}
