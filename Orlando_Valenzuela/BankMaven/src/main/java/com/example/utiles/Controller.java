package com.example.utiles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.stream.IntStream;

import org.apache.log4j.Logger;

import com.example.classes.*;

public class Controller {
	
	private Store store;
	private Logger loggy;

	public Controller(Store store, Logger loggy) {
		super();
		this.store = store;
		this.loggy = loggy;
	}
	///////////////////////////////////////////////////////////////////////////////
	public String createAccount(ArrayList<Customer> customer, double inicialBalance) {
	///////////////////////////////////////////////////////////////////////////////	
		loggy.info("inside Controller createAccount");
		String accountNum;
		Account account;
		Customer customeraux;
		
		for (accountNum = generateAccount(); existAccount(accountNum); accountNum = generateAccount());
		
		account = new Account(accountNum, inicialBalance, false, true);
		
		if (customer.size() > 1) {
			
			account.setJoint(true);
			customeraux = customer.get(0);
			customeraux.setAccount(account);
			customeraux.setAccountNum(accountNum);
			store.addCustomer(customeraux);
			
			customeraux = customer.get(1);
			customeraux.setAccount(account);
			customeraux.setAccountNum(accountNum);
			store.addCustomer(customeraux);	
			
		}
		else {
		
			customeraux = customer.get(0);
			customeraux.setAccount(account);
			customeraux.setAccountNum(accountNum);
			store.addCustomer(customeraux);
			
		}
		
		store.addAccount(account);
		
		return accountNum;
	}

    /////////////////////////////////////////////////////////////////////////	
	public boolean transferMoney(String sender, String receiver, double quantity) {
	/////////////////////////////////////////////////////////////////////////	
		
		loggy.info("inside Controller transderMoney");
		Account accountsender, accountreceiver;
		
		accountsender = store.findAccount(sender);
		accountreceiver = store.findAccount(receiver);
		
		accountsender.setBalance(accountsender.getBalance() - quantity );
		accountreceiver.setBalance(accountreceiver.getBalance() + quantity);
		
		store.updateAccount(accountsender);
		store.updateAccount(accountreceiver);
		
		return true;
	}
	

	
	public ArrayList<Customer> viewCustomers() {
		
		loggy.info("inside Controller viewCustomer");
		return store.findAllCustomer();
	}	
	

	//////////////////////////////////////////////////////////
	public boolean withDraw(String accountNum, double quantity) {
	//////////////////////////////////////////////////////////	
		loggy.info("inside Controller withDraw");
		Account account;
		
		account = store.findAccount(accountNum);
		account.setBalance(account.getBalance() - quantity);
		store.updateAccount(account);
		
		
		return true;
	}
	/////////////////////////////////////////////////////////
	public boolean deposit(String accountNum, double quantity) {
	/////////////////////////////////////////////////////////
		loggy.info("inside Controller deposit");
		Account account;
		account = store.findAccount(accountNum);
		account.setBalance(account.getBalance() + quantity);
		
		return true;
	}
	////////////////////////////////////////////
	public ArrayList<Account> accountPending() {
	////////////////////////////////////////////
		loggy.info("inside Controller accountPending");
		return store.pendingAccount();
	}
	/////////////////////////////////////////////
	public User login(String user, String pass) {
	/////////////////////////////////////////////	
		
		loggy.info("inside Controller loging");
		Admin admin = new Admin("admin", "admin");
		Employee employee = new Employee("employee", "employee");
		
		if (admin.getUserName().equals(user) && admin.getPassword().equals(pass)) {
			
			return admin;
		}
		else {
			  
				if (employee.getUserName().equals(user) && employee.getPassword().equals(pass)) {
		
					return employee;    
			
		        }
		        else {
		        	return store.findCustomer(user, pass);
		        }
		     }
		 		
	}
	/////////////////////////////////////////////
	public boolean existAccount(String accountNum) {
    /////////////////////////////////////////////
		
		loggy.info("inside Controller existAccount");
		return store.existAccount(accountNum);
	}	
	
	///////////////////////////////////////////////
	public boolean deleteAccount(Account account) {
	///////////////////////////////////////////////
		loggy.info("inside Controller deleteAccount");
		store.deleteAccount(account);
		store.deleteCustomer(account.getAccountNum());
		 
		return true;
	}	
	///////////////////////////////////////////////
	public boolean updateAccount(Account account) {
	///////////////////////////////////////////////	
		loggy.info("inside Controller updateAccount");
		store.updateAccount(account);
		 
		return true;
	}
	///////////////////////////////
	private String generateAccount() {
	///////////////////////////////	
		
		loggy.info("inside Controller generateAccount");
		Random random = new Random();
		IntStream intStream = random.ints(10, 1, 10);
		Iterator<?> iterator = intStream.iterator();	
		String num = "";
		
		while (iterator.hasNext()){
		   num  = num + iterator.next();
		}
	 
		return num;
	}

}
