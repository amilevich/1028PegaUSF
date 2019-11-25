package com.project0.model;

import org.apache.log4j.Logger;

import com.project0.dao.BankDaoImpl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;

public class AdminEmployee extends Employee implements Transactions {
	/**
	 * Bank admins should be able to view and edit all accounts. This includes:
	 *  Approving/denying accounts 
	 *  Withdrawing, depositing, transferring from all accounts 
	 *  Canceling accounts
	 */
	private static final long serialVersionUID = 1L;
	private static Integer accountNextId = 0;
	private static Integer userNextId = 0;
	public static AdminEmployee adminEmp = new AdminEmployee();
	final static Logger log = Logger.getLogger(AdminEmployee.class);
	
	public AdminEmployee(Set<Integer> accountId, String userName, String password, String firstName, String lastName) {
		this.setIdAccount(accountId);
		this.setUserName(userName);
		this.setPassword(password);
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

	public AdminEmployee() {
		
	}
	
	public static int useNextUserId() {
		//deserializeNextUserId();
		userNextId++;
		//serializeNextUserId();
		return userNextId;
	}
	
	public static int useNextAccountId() {
		//deserializeNextAccountId();
		accountNextId++;
		//serializeNextAccountId();
		return accountNextId;
	}
	/*
	public static void serializeNextAccountId() {
		try {
			FileOutputStream fileOut = new FileOutputStream("src/main/java/com/projects/project0/datalayer/accountId.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(accountNextId);
			out.close();
			fileOut.close();
			//System.out.println("");
      } catch (IOException i) {
         i.printStackTrace();
      }
	}
	
	public static void deserializeNextAccountId() {
		try {
			FileInputStream file = new FileInputStream("src/main/java/com/projects/project0/datalayer/accountId.txt");
			ObjectInputStream in = new ObjectInputStream(file);
			
			try {
				accountNextId = (Integer)in.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			in.close();
			file.close();
			//System.out.println("");
		} catch (IOException i) {
         i.printStackTrace();
		}
	}
	
	public static void serializeNextUserId() {
		try {
			FileOutputStream fileOut = new FileOutputStream("src/main/java/com/projects/project0/datalayer/userId.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(userNextId);
			out.close();
			fileOut.close();
			//System.out.println("");
      } catch (IOException i) {
         i.printStackTrace();
      }
	}
	
	public static void deserializeNextUserId() {
		try {
			FileInputStream file = new FileInputStream("src/main/java/com/projects/project0/datalayer/userId.txt");
			ObjectInputStream in = new ObjectInputStream(file);
			
			try {
				userNextId = (Integer)in.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			in.close();
			file.close();
			//System.out.println("");
		} catch (IOException i) {
         i.printStackTrace();
		}
	}
	*/
	@Override
	public double seeBalance(Integer id) {
		return 0;
	}

	@Override
	public double printBalance(int id) {
		return BankDaoImpl.dBDao.selectAccountById(id).getBalance();
		//return DataBaseAccounts.dBAccs.getMap(id).getBalance();
	}
	@Override
	public void withdraw(double transBalance, Account map) {
		map.withdraw(transBalance);
		BankDaoImpl.dBDao.updateAccount(map);
		log.info("Withdraw " + map.toString());
	}
	@Override
	public void transfer(double transBalance, Account map, Account map1) {
		map.withdraw(transBalance);
		map1.deposit(transBalance);
		BankDaoImpl.dBDao.updateAccount(map);
		BankDaoImpl.dBDao.updateAccount(map1);
		log.info("Transfer " + map.toString() + " " + map1.toString());
	}

	@Override
	public void deposit(double input, Account output) {
		output.deposit(input);
		BankDaoImpl.dBDao.updateAccount(output);
		log.info("Deposit " + output.toString());
	}

	@Override
	public void deposit(double input) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdraw(double input) {
		// TODO Auto-generated method stub
		
	}
}
