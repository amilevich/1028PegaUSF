package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.Methods.Methods;
import com.accounts.Accounts;
import com.dao.JunitDao;
import com.profiles.Customers;
import com.profiles.Profiles;

public class Tests {
	
	JunitDao daoTest = new JunitDao();
	
	
	//No methods eligible for testing
	Customers customer = new Customers(); 
	Profiles profiles = new Profiles();
	Accounts account = new Accounts();
	
	
	
	
	@Test
	public void regestrationMethodTest() {
		assertEquals("shoild return sucess", "sucess", daoTest.getAllRegistration());
	}
	@Test
	public void testInsertRegestrationMethod() {
		assertEquals("shoild return sucess", "sucess", daoTest.insertRegistration(customer));
	}
	
	@Test
	public void testInsertUsers() {
		assertEquals("shoild return sucess", "sucess", daoTest.insertUsers(profiles));
	}
	@Test
	public void testGetUsers() {
		assertEquals("shoild return sucess", "sucess", daoTest.getUsers());
	}
	
	@Test
	public void testGetSocial() {
		assertEquals("shoild return sucess", "sucess", daoTest.getSocial("Diw", "pass"));
	}
	
	@Test
	public void testInsertAccounts() {
		assertEquals("shoild return sucess", "sucess", daoTest.insertAccounts(account));
	}
	
	
	@Test
	public void testGetAllAccounts() {
		assertEquals("shoild return sucess", "sucess", daoTest.getAllAccounts());
	}
	
	@Test
	public void testAddDeposit() {
		assertEquals("shoild return sucess", "sucess", daoTest.addDeposit(0000, 0));
	}
	
	@Test
	public void testView() {
		assertEquals("shoild return sucess", "sucess", daoTest.view(0, 0));
	}
	
	@Test
	public void testDeleteAccount() {
		assertEquals("shoild return sucess", "sucess", daoTest.deleteAccount(00));
	}
	
	
	
}
