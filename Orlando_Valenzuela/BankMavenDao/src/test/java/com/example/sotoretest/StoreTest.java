package com.example.sotoretest;

import static org.junit.Assert.assertTrue;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.example.bank.MyClass;
import com.example.classes.Account;
import com.example.classes.Customer;
import com.example.utiles.Store;

public class StoreTest {
	
	final static Logger loggy = Logger.getLogger(MyClass.class);

	String user = "bank", pass = "bank0";
	String url = "jdbc:oracle:thin:@dbtraining.ccdruazatxie.us-east-2.rds.amazonaws.com:1521:orcl";
	
	Store store = new Store(url, user, pass, loggy);
	
	
	@Test
	public void addAccountTest() {
		assertTrue("ok", store.addAccount(new Account("1", 20, false, false)));
	}
	
	@Test
	public void addCustomerTest() {
		Customer cu = new Customer("prueba", "prueba", 1);		
		assertTrue("ok", store.addCustomer(cu));
	}
	
	
	@Test
	public void updateAccountTest() {
		assertTrue("ok", store.updateAccount(new Account("1", 40, false, false)));
	}
	
	@Test
	public void deleteAccountTest() {
		assertTrue("ok", store.deleteAccount(new Account("1", 40, false, false)));
	}
	
	@Test
	public void deleteCustomerTest() {
		assertTrue("ok", store.deleteCustomer(new Customer("prueba", "prueba", 1)));
	}
	
}
