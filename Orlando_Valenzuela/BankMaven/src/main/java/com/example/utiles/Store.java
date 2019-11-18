package com.example.utiles;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.example.classes.Account;
import com.example.classes.Customer;

public class Store {
	
	private File customerfile;
	private File acountfile;
	Logger loggy;


	public Store(File customerfile, File acountfile, Logger loggy) {
		super();
		this.customerfile = customerfile;
		this.acountfile = acountfile;
		this.loggy = loggy;
	}
	
	
    public ArrayList<Customer> findAllCustomer() {
    	
    	loggy.info("inside Store findAllCustomer");
		ArrayList<Customer> listCustumer, list = new ArrayList<>(); 
		ArrayList<Account> listAccount; 
		
		listCustumer = this.readCustomerFile();
		listAccount = this.readAccountFile();
				
		for(Customer c : listCustumer) {
			for (Account a : listAccount)
			   if(c.getAccountNum().equals(a.getAccountNum())) { 
					c.setAccount(a);
					list.add(c);
			}	
		}
		
		return list;    
    } 
	
	
	/*
	 * find a customer for user & pass, return null if it does not exist 
	 */
	////////////////////////////////////////////////////////	
	public Customer findCustomer(String user, String pass) {
	////////////////////////////////////////////////////////
		loggy.info("inside Store findCustomer for user and pass");
		Customer findcustomer = null;
		ArrayList<Customer> listCustumer; 
		ArrayList<Account> listAccount; 
		
		listCustumer = this.readCustomerFile();
				
		for(Customer c : listCustumer) {
			if(c.getUserName().equals(user) && c.getPassword().equals(pass)) {
				findcustomer = c;
			}	
		}
		
         if (findcustomer != null) {
        	 
        	listAccount = this.readAccountFile();
     		for(Account a : listAccount) {
    			if(a.getAccountNum().equals(findcustomer.getAccountNum())) {
    				findcustomer.setAccount(a);
    			}	
    		}
         }
		
		return findcustomer;		
	}
	
	/*
	 * find the customers for account
	 */
	//////////////////////////////////////////////////////////	
	public ArrayList<Customer> findCustomer(String accountNum) {
	//////////////////////////////////////////////////////////
		loggy.info("inside Store findCustomer for accountNum");
		ArrayList<Customer> listCustumer, findcustomer = new ArrayList<>(); 
		
		listCustumer = this.readCustomerFile();
				
		for(Customer c : listCustumer) {
			if(c.getAccountNum().equals(accountNum)) {
				findcustomer.add(c);
			}	
		}
		
		return findcustomer;
	}	
	
	/*
	 * find account for it's number
	 */
	////////////////////////////////////////////
	public Account findAccount(String accountNum) {
	////////////////////////////////////////////
		loggy.info("inside Store fiendAccount for accountNum");
		Account findaccount = null;
		ArrayList<Account> listAccount; 
		
		listAccount = this.readAccountFile();
				
		for(Account a : listAccount) {
			if(a.getAccountNum().equals(accountNum)) {
				findaccount = a;
			}	
		}
				
		return findaccount;
	}
	/*
	 * add an account
	 */
	////////////////////////////////////////////
	public boolean addAccount(Account account) {
	////////////////////////////////////////////
		loggy.info("inside Store addAccount");		
		ArrayList<Account> list;
		
		list = this.readAccountFile();
		list.add(account);
		this.writeAccountFile(list);
		
		return  true;
	}
	
	
	/*
	 * add a customer
	 */
	///////////////////////////////////////////////
	public boolean addCustomer(Customer customer) {
	///////////////////////////////////////////////	
		loggy.info("inside Store addCustomer");
		
		ArrayList<Customer> list;
		
		list = this.readCustomerFile();
		list.add(customer);
		this.writeCustomerFile(list);
	
		return  true;		
	}
	
	/*
	 * update an account
	 */
	///////////////////////////////////////////////	
	public boolean updateAccount(Account account) {
	///////////////////////////////////////////////	
		loggy.info("inside Store updateAccount");
		ArrayList<Account> list;
		
		list = this.readAccountFile();
		list.removeIf(n->n.getAccountNum().equals(account.getAccountNum()));
		list.add(account);
		this.writeAccountFile(list);
			
		return  true;		
	}

	/*
	 * delete an account
	 */
	///////////////////////////////////////////////
	public boolean deleteAccount(Account account) {
	///////////////////////////////////////////////
		
		loggy.info("inside Store deleteAccount");
		ArrayList<Account> list;
		
		list = this.readAccountFile();
		list.removeIf(n->n.getAccountNum().equals(account.getAccountNum()));
		this.writeAccountFile(list);
			
		return  true;
	}
	
	/*
	 * delete a customer for his account number
	 */
	///////////////////////////////////////////////
	public boolean deleteCustomer(String accountNum) {
    ///////////////////////////////////////////////	
		loggy.info("inside Store deleteCustomer");
		
		ArrayList<Customer> list;
		
		list = this.readCustomerFile();
		list.removeIf(n->n.getAccountNum().equals(accountNum));
		this.writeCustomerFile(list);
			
		return  true;	
	}
	
	/*
	 * delete a customer
	 */
	//////////////////////////////////////////////////
	public boolean deleteCustomer(Customer customer) {
	//////////////////////////////////////////////////	
		loggy.info("inside Store deleteCustomer");
		
		ArrayList<Customer> list;
		
		list = this.readCustomerFile();
		list.removeIf(n->n.getAccountNum().equals(customer.getAccountNum()));
		this.writeCustomerFile(list);
			
		return  true;
	}	

	/*
	 * verified if a number account exist
	 */
	///////////////////////////////////////////////
	public boolean existAccount(String accountNum) {
	///////////////////////////////////////////////
		loggy.info("inside Store existAccount");
		ArrayList<Account> list;
		
		list = this.readAccountFile();
		
			for(Account a : list)
				if (a.getAccountNum().equals(accountNum))
					return true;
		
		return  false;	
	}
	

	/*
	 * find all the pending account
	 */
	///////////////////////////////////////////////
	public ArrayList<Account> pendingAccount() {
	///////////////////////////////////////////////
		
		loggy.info("inside Store pendingAccount");
		ArrayList<Account> list, pending = new ArrayList<>();
		
		list = this.readAccountFile();
		list.forEach(n->{if(n.isPending())pending.add(n);});	
		return  pending;	
	}
	
	///////////////////////////////////////////////
	@SuppressWarnings("unchecked")
	private ArrayList<Account> readAccountFile( ) {
	///////////////////////////////////////////////
		loggy.info("inside Store readAccountFile");
			
		ArrayList<Account> accounts = null;
		
		try ( ObjectInputStream objIStrm =
		      new ObjectInputStream(new FileInputStream(this.acountfile)) ) {
  	  
	 	           		accounts = (ArrayList<Account>)objIStrm.readObject();
	 	           	     	
				 }
		         catch(EOFException  e) {
		        	        	        	 			         
		         }
				 catch(Exception e) {
					 loggy.error(e.getMessage());
					 e.printStackTrace();
				 }
		
		return  (accounts != null)?accounts: new ArrayList<>();	
	}
	
	////////////////////////////////////////////////////////////
	private void writeAccountFile(ArrayList<Account> accounts) {
	////////////////////////////////////////////////////////////
		
		loggy.info("inside Store writeAccountFile");
		
		try ( ObjectOutputStream objOStrm =
		      new ObjectOutputStream(new FileOutputStream(this.acountfile)) ) {
          	  
			           objOStrm.writeObject(accounts);  
      	 	           	
				 }
				 catch(Exception e) {
					 
					 loggy.error(e.getMessage());
					 e.printStackTrace();
				 }
		
	}	
	
	///////////////////////////////////////////////
	@SuppressWarnings("unchecked")
	private ArrayList<Customer> readCustomerFile( ) {
	///////////////////////////////////////////////
		
		
		loggy.info("inside Store readCustomerFile");
			
		ArrayList<Customer> customers = null;
		
		try ( ObjectInputStream objIStrm =
		      new ObjectInputStream(new FileInputStream(this.customerfile)) ) {

	 	           		customers = (ArrayList<Customer>)objIStrm.readObject();       	
				 }
		         catch(EOFException  e) {
		        	        	        	 			         
		         }
				 catch(Exception e) {
					 loggy.error(e.getMessage());
					 e.printStackTrace();
				 }
		
		return  (customers != null)?customers: new ArrayList<>();
	}
	
	///////////////////////////////////////////////////////////////
	private void writeCustomerFile(ArrayList<Customer> customers) {
	///////////////////////////////////////////////////////////////
		
		loggy.info("inside Store writeCustomerFile");
		
		try ( ObjectOutputStream objOStrm =
		      new ObjectOutputStream(new FileOutputStream(this.customerfile)) ) {
          	  
			           objOStrm.writeObject(customers);  
      	 	           	
				 }
				 catch(Exception e) {
					 
						loggy.error(e.getMessage());
					 e.printStackTrace();
				 }
		
	}	
}
