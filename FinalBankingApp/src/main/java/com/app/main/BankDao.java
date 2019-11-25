package com.app.main;

import java.util.ArrayList;
import java.util.HashMap;

public interface BankDao {
	
	public HashMap<String, Customer> getCHashMap();

	public HashMap<String, Account> getAHashMap();

	public ArrayList<SqlKeys> fetchSqlKeys();
	
	public HashMap<String, Customer> selectAllCusts();
	
	public HashMap<String, Account> selectAllAccts();
	
	public void truncateCustomers();
	
	public void truncateAccounts();
	
	public int insertAllCusts(HashMap<String, Customer>hashMapC);
	
	public int insertAllAccts(HashMap<String, Account>hashMapA);
	
	public void truncateSqlKeys();
	
}
