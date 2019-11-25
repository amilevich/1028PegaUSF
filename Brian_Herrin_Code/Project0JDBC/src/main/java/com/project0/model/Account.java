package com.project0.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

import com.project0.maindriver.MainDriver;
import com.project0.model.Transactions;

public class Account implements Transactions, java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Once the account is open, customers should be able to withdraw, deposit, and transfer funds between accounts
	private Integer id = 0;
	private double balance = 0.0;
	private Set<Integer> customerId = new HashSet<Integer>();
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
	
	public Account(int int1, int int2, double double1, boolean b) {
		this.id = int1;
		this.customerId.add(int2);
		this.balance = double1;
		this.isApproved = b;
	}
	public Integer getAccountId(){
		return this.id;
	}
	
	public Set<Integer> getCustomerId() {
		return this.customerId;
	}
	
	public void setCustomerId(Set<Integer> customerId) {
		this.customerId = customerId;
	}
	/*
	public Customer getOwner(Integer id){
		if(this.customerId.contains(id)) {
			return ;
		}
		return this.customerId. .get(id);
	}
	*/
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
	
	public double getBalance() {
		return this.balance;
	}
	
	public void clearBalance() {
		this.balance = 0;
	}
	
	@Override
	public void deposit(double addedFunds) {
		this.balance = this.balance + addedFunds;
	}

	@Override
	public void withdraw(double requestedFunds) {
		double temp = this.balance;
		temp -= requestedFunds;
		if(MainDriver.isNegative(temp)){
			System.out.println("We are sorry, but there is not that much money in this account! If you still wish to make a withdraw, please request less money.");
		} else {
			this.balance -= requestedFunds;
		}
	}
	
	//
	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	public void toggleApproved() {
		this.isApproved = !isApproved;
	}
	//
	
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
		return getAccountId() + ": " + stringAssociatedCustomers() + " $" + this.getBalance();
	}
	
	public String stringAssociatedCustomers() {
		String output = "";
		for(Integer c : getCustomerId()) {
			return output.concat(" " + DataBaseCustomers.dBCus.getMap(c).toString() );
		}
		return output;
	}
	public void printAccount() {
		System.out.println("Account ID "+ getAccountId() + ": " + stringAssociatedCustomers() + " $" + this.getBalance());
	}
	@Override
	public double seeBalance(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double printBalance(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void deposit(double input, Account output) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void withdraw(double input, Account output) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void transfer(double input, Account output, Account output1) {
		// TODO Auto-generated method stub
		
	}
}
