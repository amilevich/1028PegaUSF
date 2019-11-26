package com.bankapp.main;

import java.util.List;


public interface AccountDao {
	
	//CREATE
	public int insertAccount(Account a);
	//READ
	public Account selectAccountByID(int accountSelect);
	public List<Account> selectAllAccounts();
	//UPDATE
	public double addBalance(Customer a);
	public double subtractBalance(Customer a);
	public int approveAccount(Customer a);
	public int cancelAccount(Customer a);
	//DELETE
	public int deleteAccount(Customer a);

}
