package com.examples.customers;

import java.util.Random;

public class Customers {
	Random generator = new Random();// generate random number for customer ID
	private String custFname;
	private String custLname;
	private String userName;
	private String password;
	private int custID= generator.nextInt(1000);
	private String status;
	private double bal = 0.00;
	
	// constructor
	public Customers() {
		
	}

	// getters and setters 
	
	public String getCustFname() {
		return custFname;
	}

	public void setCustFname(String custFname) {
		this.custFname = custFname;
	}

	public String getCustLname() {
		return custLname;
	}

	public void setCustLname(String custLname) {
		this.custLname = custLname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getBal() {
		return bal;
	}

	public void setBal(double bal) {
		this.bal = bal;
	}

	// toString
	@Override
	public String toString() {
		return "Customers custFname=" + custFname + ", custLname=" + custLname
				+ ", userName=" + userName + ", password=" + password + ", custID=" + custID
				+ ", status=" + status + ", bal=" + bal;
	}

	// Parametrized constructor 
	public Customers(String custFname, String custLname, String userName, String password, int custID,
			 String status, double bal) {
		super();
		this.custFname = custFname;
		this.custLname = custLname;
		this.userName = userName;
		this.password = password;
		this.custID = custID;
		this.status = status;
		this.bal = bal;
	}

	public void withdraw(float withdrawal) {
		// TODO Auto-generated method stub
		
	}
}