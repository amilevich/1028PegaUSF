package com.examples.dao;

import java.util.List;

import com.examples.customers.Customers;



public interface CustomersDao {
	
	
	//Create
    public int insertCustomers(Customers c);
	
	//read
	public Customers selectCustomersByCustID(int custID);// select your primary key
	public List<Customers> selectAllCustomers();
	
	//update
	public int updateCustomers(Customers c);
	
	//delete
	public int deleteCustomers(Customers c);
	

}// end class 
