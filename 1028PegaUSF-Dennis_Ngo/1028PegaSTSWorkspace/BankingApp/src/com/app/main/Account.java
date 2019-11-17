package com.app.main;

import java.io.Serializable;

public class Account implements Serializable{

	static final long serialVersionUID = -5419807147720782881L;
	/**
	 * 
	 */
	float balance;
	long accountNumber;

	public Account(float balance, long accountNumber) {//ben model
		super();
		this.balance = balance;
		this.accountNumber = accountNumber;
		
	}

	@Override
	public String toString() {
		return "Account [balance=" + balance + ", accountNumber=" + accountNumber + "]";
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

}
