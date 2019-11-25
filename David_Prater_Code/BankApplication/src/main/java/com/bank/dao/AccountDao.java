package com.bank.dao;

import java.util.List;

import com.bank.model.Account;

public abstract class AccountDao {

	//CREATE
	public abstract int insertAccount(Account a);
	//READ
	public abstract Account selectAccountByName(Account a);
	public abstract List<Account> selectAllAccounts();
	//UPDATE
	public abstract int updateAccount(Account a);
	//DELETE
	public abstract int deleteAccount(Account a);
	
}
