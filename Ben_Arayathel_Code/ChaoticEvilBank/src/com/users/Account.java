package com.users;

import java.io.Serializable;

public class Account implements Serializable{
	
	/**
	 * 
	 */
	static final long serialVersionUID = -1953226906380021677L;
	String name;
	String password;
	String iD;
	Double balance;
	
	public Account(String name, String password, String iD, Double balance) {
		super();
		this.name = name;
		this.password = password;
		this.iD = iD;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", iD=" + iD + ", balance=" + balance + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	
	
	
	
	

}
