package com.bank.dao;

import java.util.List;

import com.bank.model.Account;

public interface AccountDao {

	//CREATE
	public int insertAccount(Account a);
	//READ
	public Account selectAccountByName(String name);
	public List<Account> selectAllAccounts();
	//UPDATE
	public int updateAccount(Account a);
	//DELETE
	public int deleteAccount(Account a);
	
}
