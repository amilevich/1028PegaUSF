package com.app.main;

import java.io.Serializable;

public class Account implements Serializable{
	float balance;
	long accountNumber;
	float deposit;
	float withdraw;
	float transfer;
	//arraylist - single or joint
	//arraylist of customers

	public static void bankAccount(double balance, long accountNumber) {

	}
	
	public void deposit (float amount) {
		balance = balance + amount;
		System.out.println("Deposited $" + deposit + ". Current Balance: $" + balance);
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber() {// generate random acct#
		long accountNumber = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
		this.accountNumber = accountNumber;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(float deposit) {
		this.deposit = deposit;
	}

	public double getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(float withdraw) {
		this.withdraw = withdraw;
	}

	public double getTransfer() {
		return transfer;
	}

	public void setTransfer(float transfer) {
		this.transfer = transfer;
	}

	public void withdraw(float amount) {
		if(balance >= amount) {
			balance = balance - amount;
			System.out.println("Withdrew $" + amount + ". Current Balance: $" + balance);
		}else {
			System.out.println("Unable to withdraw" + amount + " due to insuffiecient funds!");
		}
		
	}
	
	public void transfer() {
		//Handle transfer
	}
	

}
