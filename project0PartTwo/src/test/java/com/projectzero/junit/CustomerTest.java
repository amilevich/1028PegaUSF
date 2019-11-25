package com.projectzero.junit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.junit.Test;

import com.projectzero.dao.CustomerDaoImpl;
import project0PartOne.Customer;
import com.projectzero.menu.CustomerMenu;
public class CustomerTest {

	@Test
	public void testInsert() {
		Customer customerOne = new Customer(1,"Pablo","Escobar","pablito","escobar");
		CustomerDaoImpl cusDaoImpl = new CustomerDaoImpl();
		cusDaoImpl.insert(customerOne);
	}
	
	@Test
	public void testGetCustomerByName() {
		CustomerDaoImpl cusDaoImpl = new CustomerDaoImpl();
		System.out.println(cusDaoImpl.getCustomerByFirstName("Pablo"));
	}
	@Test
	public void testGetCustomerByLastName() {
		CustomerDaoImpl cusDaoImpl = new CustomerDaoImpl();
		System.out.println(cusDaoImpl.getCustomerByLastName("Escobar"));
	}
	@Test
	public void testCreateCustomer() {
		Scanner input = new Scanner(System.in);
		Customer c = new Customer();
		System.out.print("Create customer! ");
		System.out.print("Create ID: ");
		int id = input.nextInt();
		c.setCustomerID(id);
		System.out.print("Enter First Name: ");
		String fname = input.next();
		c.setCustomerFirstName(fname);
		System.out.print("Enter Last Name: ");
		String lname = input.next();
		c.setCustomerLastName(lname);
		System.out.print("Enter username: ");
		String user = input.next();
		c.setCustomerUsername(user);
		System.out.print("Enter password: ");
		String pass = input.next();
		c.setCustomerPassword(pass);
		Customer custwo = new Customer(c.getCustomerID(),c.getCustomerFirstName(),c.getCustomerLastName(),c.getCustomerUsername(),c.getCustomerPassword());
		CustomerDaoImpl ct = new CustomerDaoImpl();
		ct.createCustomer(custwo);
	}
	@Test
	public void testcustomerExists() {
		Scanner input = new Scanner(System.in);
		System.out.print("Entery your ID: ");
		int id = input.nextInt();
		CustomerDaoImpl ct = new CustomerDaoImpl();
		ct.customerExists(id);
	}
	
//	public void testupdateCustomer() {
//		CustomerDaoImpl cd = new CustomerDaoImpl();
//		Scanner input = new Scanner(System.in);
//		System.out.print("Enter ID: ");
//		int id=input.nextInt();
//		if(cd.customerExists(id)) {
//			cd.updateCustomer();
//		}
//	}
	@Test 
	public void testdeleteCustomer() {
		Scanner input = new Scanner(System.in);
		Customer c = new Customer();
		CustomerDaoImpl ct = new CustomerDaoImpl();
		System.out.println("Deleting a customer!");
		System.out.print("enter id: ");
		int id = input.nextInt();
		c.setCustomerID(id);
			ct.deleteCustomer(c.getCustomerID());
	}
	@Test
	public void testSelectAllCustomers() {
		CustomerDaoImpl cd = new CustomerDaoImpl();
		Scanner input = new Scanner(System.in);
		System.out.println("a. to view customers");
		System.out.println("b. to quit");
		String option = input.next();
		switch(option){
		case "a":
			System.out.print(cd.selectAllCustomers() + " ");
			
			break;
		case "b":
			System.out.println("goodBye!");
			break;
		}
	}
	@Test
	public void testCustomerRegistration() {
		CustomerMenu cm = new CustomerMenu();
		cm.customerRegistration();
	}
	@Test
	public void testCustomerSignin() {
		CustomerMenu cm = new CustomerMenu();
		cm.customerSignIn1();
	}
}
