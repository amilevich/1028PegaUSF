package com.dao;

import java.util.List;

import com.backend.Account;

public interface AccountDao {
	
	public void Insert(Account a);
	public Account selectAccountByName(String id);
	public List<Account> selectAllAccounts();
	public int updateAccount(Account a, double amount);
	public int deleteAccount(Account a);
	
}
