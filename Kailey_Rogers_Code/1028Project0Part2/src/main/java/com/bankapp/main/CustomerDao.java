package com.bankapp.main;

import java.util.HashMap;


public interface CustomerDao {

	//CREATE
	public int insertCustomer(Customer c);
	//READ
	public Customer selectCustomerByUsername(String name);
	public HashMap<String, Customer> selectAllCustomers();
	//UPDATE
	public int updateCustomerFirstName(Customer c);
	public int updateCustomerLastName(Customer c);
	public int updateCustomerPassword(Customer c);
	//DELETE
	public int deleteCustomer(Customer c);
	
}
