package part1;

import java.io.Serializable;
import java.time.LocalDate;

public class Admin extends Employee implements Clnt, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5949927327437390922L;

	public Admin() {
		super();
	}
	public Admin(String f, String l, LocalDate dob, String a, int eID, String un, String pswd) {
		super(f, l, dob, a, eID, un, pswd);
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
	public void viewApps() {
		// view account information
		//offer menu for: approve, deny, exit
		
	}
	
	@Override
	public void viewAcct(Account acctNum) {
		// view account information
		//offer menu for: cancel, or done
		
	}
	/*
	 * view
	 * approve/deny
	 * with, dep, trans
	 * cancel account
	 */

}

