package com.examples.accounts;

import java.util.Random;

public class Accounts {

	Random generator = new Random();// generate random number for account ID
	// declaring account variables
	private int accID = generator.nextInt(100000);
	private int isJoint;
	private String status;
	private double balance;
	private String accCustFname;
	private String accCustLname;
	private int CustID;
	
	//constructor
	public Accounts() {
		super();
	}

	// getters and setters
	public int getAccID() {
		return accID;
	}

	public void setAccID(int accID) {
		this.accID = accID;
	}

	public int getIsJoint() {
		return isJoint;
	}

	public void setIsJoint(int isJoint) {
		this.isJoint = isJoint;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccCustFname() {
		return accCustFname;
	}

	public void setAccCustFname(String accCustFname) {
		this.accCustFname = accCustFname;
	}

	public String getAccCustLname() {
		return accCustLname;
	}

	public void setAccCustLname(String accCustLname) {
		this.accCustLname = accCustLname;
	}


	public int getCustID() {
		return CustID;
	}

	public void setCustID(int custID) {
		CustID = custID;
	}

	@Override
	public String toString() {
		return " Account ID: " + accID  + ", Is it a joint account? (0 means no, 1 means yes) : " + isJoint + ", Account status: " + status +", Account balance: " + balance
				 + ", First name: " + accCustFname  + ", Last name: " + accCustLname  + ", Customer ID: " + CustID;
	}

	public Accounts(int accID, int isJoint, String status, double balance, String accCustFname, String accCustLname, int custID) {
		super();
		this.accID = accID;
		this.isJoint = isJoint;
		this.status = status;
		this.balance = balance;
		this.accCustFname = accCustFname;
		this.accCustLname = accCustLname;
		CustID = custID;
	}
}