package com.project.dao;

import java.util.List;

import com.project.pt1.Customer;

public interface CustomerDAO {

	public void insertCustomer(Customer x);

	public Customer selectCustomer(String x);

	public List<Customer> selectAllCustomers();

	public void updateCustomer(Customer x);

	public void deleteCustomer(Customer x);

}
