package com.projects.project0.businesslayer;

import static org.junit.Assert.*;

import org.junit.Test;

public class BusinessLayerTest {
	@Test
	public void isLoginValid(){
		DataBaseCustomers dBCustomers = new DataBaseCustomers();
		dBCustomers.putMapCustomers(0, new Customer("Billy", "password", "Bo", "Dallas"));
		dBCustomers.putMapCustomers(1, new Customer("Willy", "password", "Po", "Joe"));
		assertEquals("DataBaseCustomers isLoginValid: false ", false, dBCustomers.isLoginValid("Joey", "pass"));
		assertEquals("DataBaseCustomers isLoginValid: true ", true, dBCustomers.isLoginValid("Billy", "password"));
	}
}
