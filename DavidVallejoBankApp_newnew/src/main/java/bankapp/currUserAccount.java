package bankapp;

import java.io.Serializable;

public class currUserAccount implements Serializable {
	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	static final long serialVersionUID = -1953226906380021677L;
	private String name;
	// PRIVATE STRING
	private String password;
	private String accountID;
	private Double balance;
	
	/*
	 * Need to connect to the database here and check the login credentials with the user login credentials
	 *on the database
	 * */

	public currUserAccount(String name, String password, String accountID, Double balance) {
		super();
		this.name = name;
		this.password = password;
		this.accountID = accountID;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "currUserAccount [name=" + name + ", accountID=" + accountID + ", balance=" + balance + "]";
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

	public String getaccountID() {
		return accountID;
	}

	public void setaccountID(String accountID) {
		this.accountID = accountID;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String currUserAccount() {
		return null;
	}

}
