package com.backend;

import java.io.Serializable;

public class Account implements Serializable{
	
	static final long serialVersionUID = -1953226906380021677L;
	private String name;
	private String password;
	private String iD;
	private Double balance;
	
	private String secondName = null;
	private String secondPassword = null;
	private String secondID = null;
	
	public Account(String name, String password, String iD, Double balance) {
		super();
		this.name = name;
		this.password = password;
		this.iD = iD;
		this.balance = balance;
	}
	
	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getSecondPassword() {
		return secondPassword;
	}

	public void setSecondPassword(String secondPassword) {
		this.secondPassword = secondPassword;
	}

	public String getSecondID() {
		return secondID;
	}

	public void setSecondID(String secondID) {
		this.secondID = secondID;
	}

	public Account(String name,String password, String iD, String name2, String password2,String iD2,Double Balance) {
		this(name, password, iD, Balance);
		this.secondName = name2;
		this.secondID = iD2;
		this.secondPassword = password2;
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
