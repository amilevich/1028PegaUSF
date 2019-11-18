package part1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client extends Person implements Clnt, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6620140899903260402L;
	String username = new String();
	String password = new String();
	ArrayList<Integer> accounts = new ArrayList<Integer>();
	
	public Client(String f, String l, String dob, String a) {
		super();
	}
	
	public Client (String f, String l, LocalDate dob, String a, String u, String p, int acc) {
		super(f, l, dob, a);
		this.username = u;
		this.password = p;
		this.accounts.add(acc);
	}
	
	public Client() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String getName() {
		return this.nameFirst +" "+ this.nameLast;
	}

	public ArrayList<Integer> getAccounts() {
		return accounts;
	}

	public void setAccounts(int i) {
		this.accounts.add(i);
	}

	public void register() {
		//take in user name
		//check to see it isn't used
		//set user name
		//set password
			//check to see if the password is secure enough if time permits
	}

	@Override
	public void withdraw(double amt, Account acct) {
		acct.makeWithdrawal(amt);
	}

	@Override
	public void deposit(double amt, Account acct) {
		acct.makeDeposit(amt);
	}


	@Override
	public void viewAcct(Account acctNum) {
		
	}

	@Override
	public String toString() {
		String s = "";
		for(int i = 0;i<accounts.size();i++) {
			s.concat(Integer.toString((accounts.get(i)))+", ");
		}
		return "Client [username=" + username + ", accounts=" + s + ", getName()=" + getName()
				+ ", getDateOfBirth()=" + getDateOfBirth() + ", getAddress()=" + getAddress() + "]";
	}
	
	
}
