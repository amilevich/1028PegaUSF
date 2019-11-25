package com.project0.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.project0.dao.BankDaoImpl;
import com.project0.model.Customer;
import com.project0.model.DataBaseCustomers;

public class ModelLayerTest {
	@Test
	public void isLoginValid(){
		DataBaseCustomers dBCustomers = new DataBaseCustomers();
		dBCustomers.putMapCustomers(0, new Customer("Billy", "password", "Bo", "Dallas"));
		dBCustomers.putMapCustomers(1, new Customer("Willy", "password", "Po", "Joe"));
		assertEquals("DataBaseCustomers isLoginValid: false ", false, dBCustomers.isLoginValid("Joey", "pass"));
		assertEquals("DataBaseCustomers isLoginValid: true ", true, dBCustomers.isLoginValid("Billy", "password"));
	}
	
	@Test
	public void insertCustomerTable() {
		BankDaoImpl bankDaoImpl = new BankDaoImpl();
		assertEquals("BankDAO selectCustomerByName: Joe Hill ", "Joe Hill", bankDaoImpl.selectCustomerByName("Wally").getFullName());
	}
	
	@Test
	public void insertEmployeeTable() {
		BankDaoImpl bankDaoImpl = new BankDaoImpl();
		assertEquals("BankDAO selectEmployeeByName:  ", "AdminEmployee", bankDaoImpl.selectEmployeeByName("AdminEmployee").getUserName());
	}
}
