package com.project0.dao;

import java.util.List;

import com.project0.model.Account;

public interface AccountDao {
	
	/*
	 * DAO Design Pattern - Data Access Object
	 * the purpose of it is to introduce a database layer
	 * to separate our db interactions away from our business logic
	 * 
	 * The DAO interface will provide us with the guideline for our
	 * CRUD operations to be performed on objects of type Model/Bean (Pet)
	 */
	
	//CREATE
	public int insertAccount(Account a);
	//READ
	public Account selectAccountById(int id);
	public List<Account> selectAllAccounts();
	//UPDATE
	public int updateAccount(Account a);
	//DELETE
	public int deleteAccount(Account a);
}
