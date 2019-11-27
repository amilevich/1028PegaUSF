package com.daos;

import java.util.List;

import com.admin.Admin;
import com.customers.Customers;


public interface AdminDao {

	//Create
    public int insertCustomers(Customers c);
	
	//read
	public Admin selectCustomersByCustID(int custID);// select your primary key
	public List<Customers> selectAllCustomers();
	
	//update
	public int updateCustomers(Customers c);
	
	//delete
	public int deleteCustomers(Customers c);
	

}// end interface
