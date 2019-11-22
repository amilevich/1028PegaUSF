package com.project.dao;

import java.util.List;

import com.project.pt1.Customer;

public interface CustomerDAO {
	
	/*
	 * DAO - Data Access Object,
	 * the purpose of it is to introduce a database layer to seperate our db interactions away from our business logic.
	 * 
	 * The DAO interfce will provide us with the guideline for our CRUD operations to be
	 * performed on objects of type Model/Bean.
	 * 
	 * 
	 */
	//CREATE
	public void insertCustomer(Customer x);
	//READ
	public Customer selectCustomer(String x); //String for now, will change to bankID later.
	public List<Customer> selectAllCustomers(); //This will probably be put in the AdminDAO
	
	//UPDATE
	public void updateCustomer(Customer x);
	public void updateFunds(Customer x);
	
	
	//DELETE
	public void deleteCustomer(Customer x);

}
