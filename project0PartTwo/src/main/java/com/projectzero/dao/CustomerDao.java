package com.projectzero.dao;

import java.util.List;

import project0PartOne.Customer;

public interface CustomerDao {

	public int insert(Customer cust);

	public Customer getCustomerByUsername(String customerUsername);
	
	public Customer getCustomerByFirstName(String customerFirstName);

	public Customer getCustomerByLastName(String customerLastName);
	
	public Customer getCustomerByID(int customerID);

	public int createCustomer(Customer cust);

	public int updateCustomer(Customer cust);

	public int deleteCustomer(int customerID);
	
	public int deleteCustomer(Customer cust);

	public List<Customer> selectAllCustomers();
	
	public boolean customerExists(int customerID);
	
	public boolean customerExists(String customerUsername);
	
	public boolean customerExists2(String customerPassword);
	
	public boolean isUsernameUnique(Customer cust);
	
	public boolean ispasswordUnique(Customer cust);
}
