package part2;

import java.sql.Date;
import java.time.LocalDate;

public class Admin extends Employee implements Clnt {


	public Admin() {
		super();
	}
	public Admin(String f, String l, Date dob, String a, String un, String pswd) {
		super(un, pswd, f, l, dob, a, 1);
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

