package com.accounts;

import java.io.Serializable;
import java.util.ArrayList;

public class Accounts implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int accounNo;
	private float balance;
	private ArrayList<Integer> linkedSocial;
	private int social;
	
	public Accounts() {
		// TODO Auto-generated constructor stub
	}
	
	public Accounts(int accounNo, float balance, ArrayList<Integer> linkedSocial, int social) {
		super();
		this.accounNo = accounNo;
		this.balance = balance;
		this.linkedSocial = linkedSocial;
		this.social = social;
	}
	public int getSocial() {
		return social;
	}
	public void setSocial(int social) {
		this.social = social;
	}
	public Accounts(int accounNo, int balance, ArrayList<Integer> linkedSocial) {
		super();
		this.accounNo = accounNo;
		this.balance = balance;
		this.linkedSocial = linkedSocial;
	}
	public int getAccounNo() {
		return accounNo;
	}
	public void setAccounNo(int accounNo) {
		this.accounNo = accounNo;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public ArrayList<Integer> getLinkedSocial() {
		return linkedSocial;
	}
	public void setLinkedSocial(ArrayList<Integer> linkedSocial) {
		this.linkedSocial = linkedSocial;
	}
	@Override
	public String toString() {
		return "Accounts [accounNo=" + accounNo + ", balance=" + balance + ", linkedSocial=" + linkedSocial + "]";
	}

	
	
	
	
}
