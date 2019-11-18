package com.example.classes;

public class Customer extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String accountNum;
	private transient Account account;
	
	

	public Customer() {
	 super();
	}

	public Customer(String userName, String password) {
		super(userName, password);
		this.accountNum = null;
		
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "User: " + super.password + ",\n" + account;
	}



	
	

}
