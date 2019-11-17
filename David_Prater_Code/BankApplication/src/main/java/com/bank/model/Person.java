package com.bank.model;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 5635825819705054254L;

	private String accountNumber;
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String email;
	private String username;
	private String password;

	// Create a constructor to hold information about a new person
	public Person(String firstName, String lastName, String address, String phoneNumber, String email, String username,
			String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public Person(String accountNumber, String firstName, String lastName, String address, String phoneNumber,
			String email, String username, String password) {
		super();
		this.accountNumber = accountNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.username = username;
		this.password = password;

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

	@Override
	public String toString() {
		return "Account Number: " + accountNumber + "\nName: " + firstName + " " + lastName
				+ "\nAddress: " + address + "\nPhone Number: " + phoneNumber + "\nEmail: " + email + "\nUsername: "
				+ username + "\nPassword: " + password + "\n";
	}

}
