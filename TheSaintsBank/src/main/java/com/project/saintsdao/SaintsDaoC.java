package com.project.saintsdao;

import java.util.List;

import com.project.saintsbank.Customer;
import com.project.saintsbank.Employee;
import com.project.saintsbank.Account;



public interface SaintsDaoC {
	
	
	public int insertNewCustomer(Customer newAcct, int status);
	
	
	public Customer findByCustomerId(int cId, int mode);
	
	public int updateAcct(Customer acct);
	
	
	//Section for Employee and admin accounts only
	public Employee findByEmployee(int empl);
	
	public List<Integer> searchWApproval();
	
	public int updateAfterApproval();
	
	public int searchId(int id, int choice);
	
	public int FinSetUpNew(int cUserId, int acctN, int acctB, String AcctT, int statusA);
	
	
	// To pull Accounts
	public Account findAcctById(int Cid);
	public int UpdateBalance(int Cid, float acctP);

}
