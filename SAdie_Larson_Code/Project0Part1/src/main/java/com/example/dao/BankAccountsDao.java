package com.example.dao;

import java.util.HashMap;
import java.util.List;

import com.example.partone.Account;

public interface BankAccountsDao {
	// CREATE
	public void insertBankAccounts(Account acc); // return type does not matter

	// READ
	public Account selectById(int id);

	public HashMap<Integer, Account> selectBankAccounts(); // will go to database select all from pets and will then go
															// to java

	// UPDATE
	public void updateBankAccounts(Account acc); // return type does not matter

	// DELETE
	public void deleteBankAccounts(int key);

}
