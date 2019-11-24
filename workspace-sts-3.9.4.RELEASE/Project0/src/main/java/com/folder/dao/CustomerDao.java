package com.folder.dao;

import java.util.List;

import com.folder.bank.Customers;

public interface CustomerDao {

	
	// CREATE
		public int insertCustomer(Customers c);
		
		// READ
		public Customers selectCustomerID(int id);
		
		public List<Customers> selectAllCustomers();
		
		// UPDATE
		public int updatePet(Customers c);
		
		// DELETE
		public int delete(Customers p);
}
