package com.project;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.project0.Account;
import com.project0.Customer;


public interface AccountDao {

	  public int insertAccount(Customer u) ;
	  public Account getAccount( int acctId);
	  public List<Account>getAllAccounts() ;
	  public int deleteAccount(Account u); 
	  public int updateAccount(Account u) ;
	int insertAccount(Account u);
	
	}
	
	


