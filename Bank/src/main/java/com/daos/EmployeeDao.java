package com.daos;

import java.util.List;

import com.accounts.Accounts;
import com.employee.Employee;


public interface EmployeeDao {
	
	//Create
    public int insertAccounts(Accounts a);
	
	//read
	public Accounts selectAccountsByAccountID(int accountID);// select your primary key
	public List<Accounts> selectAllAccounts();
	
	//update
	public int updateAccounts(Accounts a);
	
	//delete
	public int deleteAccounts(Accounts a);


}// end interface
