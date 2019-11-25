package com.projectzero.dao;

import java.util.List;

import project0PartOne.Account;

public interface AccountDao {
	
	public List<Account> getAllAccounts();

	public Account getAccountById(int accountID);
	
	public Account getAccountByAccountById(int accountID);

	public int createAccount(Account account);

	public int updateAccount(Account account);
	
	public int updateAccountAcount(int accountID);
	
	public int updateAccount(Account account, String sql);

	public Account getAccountByCustomerId(int customerID);

	public int insert(Account account);

	public int deleteAccount(Account account);
	
	public Account getAccountID();
	
	public Account getAccountBalance();
	
	public Account getAccountType();
	
	public Account getAccountJoint();
	
	public Account getCustomerID();
	
}
