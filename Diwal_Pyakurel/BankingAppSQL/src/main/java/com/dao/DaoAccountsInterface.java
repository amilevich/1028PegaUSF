package com.dao;

import java.util.ArrayList;

import com.accounts.Accounts;

public interface DaoAccountsInterface {
	
	public void insertAccounts(Accounts accounts);
	
	public ArrayList<Accounts> getAllAccounts();
	
	public void addDeposit(int accountNo, float x);
	
	public void withdraw(int accountNo, float x);
	
	public void transfer(int firstAccount, int secondAccount, float x);
	
	public void view (int accountNo, int social);
	
	public void viewAll();
	
	public void deleteAccount(int accountNo);
	
	public void deleteUnrequired();
	

}
