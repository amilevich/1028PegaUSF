package com.bank.simulation;
import java.io.Serializable;

public class Account implements Serializable{
	
	
	/**
	 * javadocs
	 * @author Doga Akata
	 */
	private static final long serialVersionUID = -3053180277936399566L;
	private String name;
	private String join_name="nobody";
	private String password;
	private Double balance;
	private int authority;
	private int state;
	
	public Account() {
		this.authority=0;
		this.name="";
		this.password="";
		this.balance=0.0;
		this.state=1;
	}
	public Account(int auth, String name, String password){
		this.authority=auth;
		this.name=name;
		this.password=password;
		this.balance=0.0;
		this.state=1;
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJoinName() {
		return join_name;
	}
	public void setJoinName(String join_name) {
		this.join_name = join_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Double Deposit(Double qty){
		this.balance+=qty;
		return this.balance;
	}
	public Double Withdraw(Double qty){
		if(qty>this.balance) {
			return this.balance;
		}
		this.balance-=qty;
		return this.balance;
	}
}