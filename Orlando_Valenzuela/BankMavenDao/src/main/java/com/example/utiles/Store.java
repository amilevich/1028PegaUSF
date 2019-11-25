package com.example.utiles;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.example.classes.Account;
import com.example.classes.Customer;
import com.example.classes.User;
import com.example.dao.AccountDaoImpl;
import com.example.dao.UserDaoImpl;

public class Store {
	
	
	
	private UserDaoImpl udi;
	private AccountDaoImpl adi;

	private Logger loggy;


	public Store(String url, String user, String pass, Logger loggy) {
		super();
        this.udi = new UserDaoImpl(url, user, pass );
        this.adi = new AccountDaoImpl(url, user, pass);

		this.loggy = loggy;
	}
	
	/////////////////echo/////////////////////////
    public ArrayList<Customer> findAllCustomer() {
  	
    	loggy.info("inside Store findAllCustomer");
	
    	ArrayList<Customer> list = new ArrayList<>(); 
		ArrayList<User> userlist = udi.findAll();
		userlist.forEach(n->list.add(((Customer)n)));

		return list;    
    } 
	
	
	/*
	 * find a customer for user & pass, return null if it does not exist 
	 */
	////////////////////////echo////////////////////////	
	public User findCustomer(String user, String pass) {
	////////////////////////////////////////////////////
		loggy.info("inside Store findCustomer for user and pass");
		
	
		return udi.findUser(user, pass);
	}
	
	
	/*
	 * find account for it's number
	 */
	//////////////////echo//////////////////////////
	public Account findAccount(String accountNum) {
	////////////////////////////////////////////
		loggy.info("inside Store fiendAccount for accountNum");
	
		return adi.find(accountNum);
	}
	
	/*
	 * add an account
	 */
	//////////////////echo//////////////////////////////////////
	public boolean addUserAccount(String user, String account) {
	////////////////////////////////////////////////////////////
		
		
		loggy.info("inside Store addUserAccount");	
		
		return  adi.insertUserAccount(user, account);
	}	
	
	
	/*
	 * add an account
	 */
	////////////////////////////////////////////
	public boolean addAccount(Account account) {
	////////////////////////////////////////////
		loggy.info("inside Store addAccount");	
		
		return  adi.insert(account);
	}
	
	
	/*
	 * add a customer
	 */
	///////////////////////////////////////////////
	public boolean addCustomer(Customer customer) {
	///////////////////////////////////////////////	
		loggy.info("inside Store addCustomer");
		
		return  udi.insert(customer);		
	}

	///////////////////////////////////////////////
	public boolean deleteCustomer(User customer) {
	///////////////////////////////////////////////	
		loggy.info("inside Store deleteCustomer");
		
		return  udi.delete(customer);		
	}	
	
	/*
	 * update an account
	 */
	//////////////////echo/////////////////////////////	
	public boolean updateAccount(Account account) {
	///////////////////////////////////////////////	
		loggy.info("inside Store updateAccount");
		
		return  adi.update(account);		
	}

	/*
	 * delete an account
	 */
	///////////////echo////////////////////////////
	public boolean deleteAccount(Account account) {
	///////////////////////////////////////////////
		
		loggy.info("inside Store deleteAccount");
		
		
		ArrayList<String> users = adi.deleteUserAccount( account.getAccountNum());
		
		users.forEach(n->udi.delete(udi.find(n)));
	
	
		return  adi.delete(account);
	}


	/*
	 * verified if a number account exist
	 */
	/////////////////////echo//////////////////////////
	public boolean existAccount(String accountNum) {
	///////////////////////////////////////////////
		loggy.info("inside Store existAccount");

		return  adi.exist(accountNum);	
	}
    ////////////////////echo///////////////////////
	public boolean existUserName(String username) {
	///////////////////////////////////////////////	
		
		return udi.exist(username);
		
	}	

	/*
	 * find all the pending account
	 */
	//////////////////echo/////////////////////////////
	public ArrayList<Account> pendingAccount() {
	///////////////////////////////////////////////
		
		loggy.info("inside Store pendingAccount");
	
		return  adi.findAllPending();	
	}
	


}
