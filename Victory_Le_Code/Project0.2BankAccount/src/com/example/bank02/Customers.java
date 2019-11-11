package com.example.bank02;

public class Customers {

	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	
	Accounts customerAcct = new Accounts();
	
	
	//Constructor
	
	public Customers() {
		
	}
	
	public Customers(String username, String password, String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public void register() {
		System.out.println("In the Register menu");
		customerAcct.deposit(9090, 200, 800);
	}
	
	
	
	//Getter and Setter
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
	
	
	
	
	
}
