package project0PartOne;

import java.util.Random;

public class Account {
	Random rand = new Random();
	Customer c = new Customer();
//////////////////////////////////////////////////////////ACCOUNT ATTRIBUTES/////////////////////////////////////////////////////////
	private int accountID = rand.nextInt(10000);
	private int balance;
	private String accountType;
	private int isJoint;
	private int customerID;
	private String status;
	
///////////////////////////////////////////////////////////////CONSTRUCTORS//////////////////////////////////////////////////////////
	public Account() {
		
	}

	public Account(int accountID, int balance, String accountType, int isJoint, int customerID, String status) {
		super();
		this.accountID = accountID;
		this.balance = balance;
		this.accountType = accountType;
		this.isJoint = isJoint;
		this.customerID=customerID;
		this.status=status;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getType() {
		return accountType;
	}

	public void setType(String accountType) {
		this.accountType = accountType;
	}

	public int isJoint() {
		return isJoint;
	}

	public void setJoint(int isJoint) {
		this.isJoint = isJoint;
	}
	
	public int getCustomerID() {
		return customerID;
	}

	public void setAccountUser(int customerID) {
		this.customerID = customerID;
	}
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Account AccountID: " + accountID + ", Balance: " + balance + ", Type: " + accountType + ", Is Joint: " + isJoint + ", Customer: " + customerID + ", Status: " + status;
	}
	
	
}
