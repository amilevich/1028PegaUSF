package com.projects.project0.businesslayer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

import com.projects.project0.MainDriver;
import com.projects.project0.userlayer.Transactions;

public class Account implements Transactions, java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Once the account is open, customers should be able to withdraw, deposit, and transfer funds between accounts
	private Integer id = 0;
	private Set<Integer> customerId = new HashSet<Integer>();
	private double balance = 0.0;
	private boolean isApproved = false;
	
	public Account() {
		
	}
	public Account(Integer id, double funds) {
		this.id = id;
		this.balance = funds;
	}
	public Account(Integer id, Set<Integer>customerId, double funds, boolean isApproved) {
		this.id = id;
		this.customerId = customerId;
		this.balance = funds;
		this.isApproved = isApproved;
	}
	
	public Integer getAccountId(){
		return this.id;
	}
	
	public Set<Integer> getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(Set<Integer> customerId) {
		this.customerId = customerId;
	}
	//
	public Customer getOwner(Integer id){
		return new Customer("Debugman", "password");
	}
	
	public void listAssociatedCustomers(){
		for(Integer c : getCustomerId()) {
			DataBaseCustomers.dBCus.getMap(c).toString();
		}
	}
	//
	public void setOwner(){
		
	}
	//
	// Makes sure the account is complete and open before performing transactions
	public boolean isAccountComplete() {
		if(this.id == 0) {
			return false;
		}
		/*
		if(this.mainOwner == null) {
			return false;
		}
		*/
		return true;
	}

	@Override
	public double seeBalance() {
		return balance;
	}
	public void clearBalance() {
		balance = 0;
	}
	
	@Override
	public void deposit(double addedFunds) {
		balance = balance + addedFunds;
	}

	@Override
	public void withdraw(double requestedFunds) {
		double temp = balance;
		temp -= requestedFunds;
		if(MainDriver.isNegative(temp)){
			System.out.println("We are sorry, but there is not that much money in this account! If you still wish to make a withdraw, please request less money.");
		} else {
			this.balance -= requestedFunds;
		}
	}

	@Override
	public void transfer(double transitioningFunds, Account receivingAccount) {
		/*
			
		*/
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	public void toggleApproved() {
		this.isApproved = !isApproved;
	}
	
	
	public static void serializeAccountApplication(Account a) {
		a.printAccount();
		try {
			// FileOutputStream fileOut = new FileOutputStream("bin/com/projects/project0/accountApplication.txt");
			FileOutputStream fileOut = new FileOutputStream("src/main/java/com/projects/project0/accountApplication.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(a);
			out.close();
			fileOut.close();
			//System.out.println("Serialized data is saved in " + fileOut.getFD() );
      } catch (IOException i) {
         i.printStackTrace();
      }
	}
	
	public static Account deserializeAccountApplication() {
		Account a = null;
		try {
			FileInputStream file = new FileInputStream("src/main/java/com/projects/project0/accountApplication.txt");
			ObjectInputStream in = new ObjectInputStream(file);
			
			try {
				a = (Account)in.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			in.close();
			file.close();
			//System.out.println("");
      } catch (IOException i) {
         i.printStackTrace();
      }
		return a;
	}
	
	public String toString(){
		return getAccountId() + ": " + stringAssociatedCustomers() + " $" + this.seeBalance();
	}
	
	public String stringAssociatedCustomers() {
		String output = "";
		for(Integer c : getCustomerId()) {
			return output.concat(" " + DataBaseCustomers.dBCus.getMap(c).toString() );
		}
		return output;
	}
	public void printAccount() {
		System.out.println("Account ID "+ getAccountId() + ": " + stringAssociatedCustomers() + " $" + this.seeBalance());
	}
}
