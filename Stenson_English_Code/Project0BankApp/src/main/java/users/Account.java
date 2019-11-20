package users;

import java.io.Serializable;

public class Account implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3384840991769071306L;
	private String name;
	private String password;
	private int accountNumber;
	private double balance;
	private String id;
	
	private String nameTwo = null;
	private String passwordTwo = null;
	private String idTwo = null;
	
	//	ACCOUNT CONSTRUCTOR
	public Account(String name, String password, String id, double balance, int accountNumber) {
		super();
		this.name = name;
		this.password = password;
		this.id = id;
		this.accountNumber = this.hashCode();
		this.balance = balance;
	}
	//	JOINT ACCOUNT CONSTRUCTOR
	public Account(String name,String password, String id, String nameTwo, String passwordTwo,String idTwo,double balance, int accountNumber) {
		this(name, password, id, balance, accountNumber);
		this.nameTwo = nameTwo;
		this.idTwo = idTwo;
		this.passwordTwo = passwordTwo;
	}

	@Override
	public String toString() {
		return "Account name: " + name + ", account number: " + accountNumber + ", balance: " + balance;
	}
	
	// GETTERS AND SETTERS

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
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = this.hashCode();
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getNameTwo() {
		return nameTwo;
	}

	public void setNameTwo(String nameTwo) {
		this.nameTwo = nameTwo;
	}

	public String getPasswordTwo() {
		return passwordTwo;
	}

	public void setPasswordTwo(String passwordTwo) {
		this.passwordTwo = passwordTwo;
	}

	public String getIdTwo() {
		return idTwo;
	}

	public void setIdTwo(String idTwo) {
		this.idTwo = idTwo;
	}
	
	
	
	
	
	

}