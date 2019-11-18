package com.example.classes;

import java.io.Serializable;


public class Account implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	private String accountNum;
	private double balance;
	private boolean joint ;
	private boolean pending;
	
	public Account() {
		super();		
	}
	
	public Account(String accountNum, double balance, boolean joint, boolean pending) {
		super();
		this.accountNum = accountNum;
		this.balance = balance;
		this.joint = joint;
		this.pending = pending;
		
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isJoint() {
		return joint;
	}


	public void setJoint(boolean joint) {
		this.joint = joint;
	}

	public boolean isPending() {
		return pending;
	}

	public void setPending(boolean pending) {
		this.pending = pending;
	}

	@Override
	public String toString() {
		return "Account: " + accountNum + ",\nbalance: " + balance + ",\njoint: " + joint + ",\npending: "
				+ pending;
	}
	
	
}
