package com.project;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.project0.Customer;


public interface CustomerDao {

	  public int insertCustomer(Customer u) throws SQLException;
	  public Customer getCustomer(String userName) throws SQLException;
	  public List<Customer>getAllCustomers() throws SQLException;
	  public int deleteCustomer(int acctId) throws SQLException;
	  public int updateCustomer(Customer u) throws SQLException;
	  public boolean customerExit(String username, String password);		

	
	}
	
