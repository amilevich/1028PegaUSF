package com.project0.dao;

import java.util.List;

import com.project0.model.Customer;

public interface CustomerDao {
	
	/*
	 * DAO Design Pattern - Data Access Object
	 * the purpose of it is to introduce a database layer
	 * to separate our db interactions away from our business logic
	 * 
	 * The DAO interface will provide us with the guideline for our
	 * CRUD operations to be performed on objects of type Model/Bean (Customer)
	 */
	
	//CREATE
	public int insertCustomer(Customer c);
	//READ
	public Customer selectCustomerByName(String name);
	public List<Customer> selectAllCustomers();
	//UPDATE
	public int updateCustomer(Customer c);
	//DELETE
	public int deleteCustomer(Customer c);
	Customer selectCustomerById(int id);
}
