package com.example.classes;

public class Customer extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient Account account;
	
	

	public Customer() {
	 super();
	}

	public Customer(String userName, String password, Integer typeUser) {
		super(userName, password, typeUser);	
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
