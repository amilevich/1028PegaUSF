package com.dao;

import java.util.ArrayList;

import com.profiles.Customers;

public interface DaoRegistrationINterfaces {
	
	public  void insertRegistration(Customers customer);
	public  ArrayList<Customers> getAllRegistration();
	public void deleteRegistration(); 
	
	

}
