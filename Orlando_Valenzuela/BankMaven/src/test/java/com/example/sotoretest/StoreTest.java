package com.example.sotoretest;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.example.bank.MyClass;
import com.example.classes.Account;
import com.example.classes.Customer;
import com.example.utiles.Store;

public class StoreTest {
	
	final static Logger loggy = Logger.getLogger(MyClass.class);
	
	File fileaccount = new File("C:\\Users\\Rosy\\Documents\\workspace-sts-3.9.4.RELEASE\\BankMaven\\src\\test\\java\\com\\example\\sotoretest\\account.txt");
	File filecustomer = new File("C:\\Users\\Rosy\\Documents\\workspace-sts-3.9.4.RELEASE\\BankMaven\\src\\test\\java\\com\\example\\sotoretest\\customer.txt");
	Store store = new Store(filecustomer, fileaccount, loggy);
	
	
	@Test
	public void addAccountTest() {
		assertTrue("ok", store.addAccount(new Account("1", 20, false, false)));
	}
	
	@Test
	public void addCustomerTest() {
		Customer cu = new Customer("prueba", "prueba");
		cu.setAccount(new Account("1", 20, false, false));
		cu.setAccountNum("1");
		assertTrue("ok", store.addCustomer(cu));
	}
	
	
	@Test
	public void updateAccountTest() {
		assertTrue("ok", store.updateAccount(new Account("1", 40, false, false)));
	}
	
	@Test
	public void existAccountTest() {
		assertTrue("ok", store.existAccount("1"));
	}	
	
	@Test
	public void deleteAccountTest() {
		assertTrue("ok", store.deleteAccount(new Account("1", 40, false, false)));
	}
	
	@Test
	public void deleteCustomerTest() {
		assertTrue("ok", store.deleteCustomer("1"));
	}
	
}
