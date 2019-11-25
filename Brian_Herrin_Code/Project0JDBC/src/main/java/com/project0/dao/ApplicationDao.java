package com.project0.dao;

import java.util.List;

import com.project0.model.Account;

public interface ApplicationDao {
	
	/*
	 * DAO Design Pattern - Data Access Object
	 * the purpose of it is to introduce a database layer
	 * to separate our db interactions away from our business logic
	 * 
	 * The DAO interface will provide us with the guideline for our
	 * CRUD operations to be performed on objects of type Model/Bean (Account)
	 */
	
	//CREATE
	public int insertApplication(Account a);
	//READ
	public Account selectApplicationById(int id);
	public List<Account> selectAllApplications();
	//UPDATE
	public int updateApplication(Account a);
	//DELETE
	public int deleteApplication(Account a);
}
