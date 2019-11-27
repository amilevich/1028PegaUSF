package com.simulation.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bank.simulation.dao.BankDao;
import com.bank.simulation.dao.BankDaoImpl;

import org.apache.log4j.BasicConfigurator;

public class Bank implements Serializable {

	private static final Logger loggy = Logger.getLogger(Bank.class);
	private static final long serialVersionUID = -3053180277936399566L;
	private ArrayList<Account> accounts;
	private String prompt;
	private String user;
	private String password;
	private int authority;
	private BankDao bd;

	public Bank() {
		this.accounts = new ArrayList<Account>();
		this.prompt = "bank>";
		this.user = "";
		this.password = "";
		this.authority = 0;
		bd = new BankDaoImpl();
	}


	// Getters and Setters
	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

	// Get account object from user name
	public Account GetAccount(String name) {
		for (Account account : accounts) {
			if (account.getName().equals(name)) {
				return account;
			}
		}
		return null;
	}

	// Check the existing of the given user name
	public boolean Exists(String name) {
		
		return true;
	}

	// Register account from the line data of store file
	public boolean Register(String account_info) {
		String[] items = account_info.split(" ");
		Register(Integer.parseInt(items[2]), items[0], items[1]);
		Deposit(items[0], Double.parseDouble(items[3]));
		for (Account account : accounts) {
			if (account.getName().equals(items[0])) {
				account.setJoinName(items[4]);
			}
		}
		return true;
	}

	// Register account from auth, name, password
	public boolean Register(int auth, String name, String password) {
		if (Exists(name))
			return true;
		accounts.add(new Account(auth, name, password));
		// Account.accts.insertAcc(accounts);
		bd.insertAcc(auth, name, password);
		return true;
	}

	// Deposit by name, qty
	public boolean Deposit(String name, Double qty) {
		for (Account account : accounts) {
			if (account.getName().equals(name)) {
				double balance = 0.0;
				balance = account.Deposit(qty);
				bd.updatePet(name, balance);
				return true;
			}
		}
		return true;
	}

	// Withdraw by name, qty
	public boolean Withdraw(String name, Double qty) {
		for (Account account : accounts) {
			if (account.getName().equals(name)) {
				double balance = 0.0;
				balance = account.Withdraw(qty);
				bd.updatePet(name, balance);
				return true;
			}
		}
		return true;
	}

	// Deny the giver account
	public boolean Deny(String name) {
		for (Account account : accounts) {
			if (account.getName().equals(name) && account.getAuthority() == 1) {// customer:1
				account.setState(0);
				bd.Deny(name);
				return false;
			}
		}
		return true;
	}

	// Allow the given account
	public boolean Allow(String name) {
		for (Account account : accounts) {
			if (account.getName().equals(name) && account.getAuthority() == 1) {
				account.setState(1);
				bd.Allow(name);
				return false;
			}
		}
		return true;
	}

	// Remove the given account
	public boolean Cancel(String name) {
		for (Account account : accounts) {
			if (account.getName().equals(name) && account.getAuthority() == 1) {
				accounts.remove(account);
				bd.Cancel(name);
				return false;
			}
		}
		return true;
	}

	// Join joiner to customer
	public boolean Join(String name, String join_name) {
		if (!Exists(join_name)) {
			return false;
		}
		for (Account account : accounts) {
			if (account.getName().equals(name) && account.getAuthority() == 2) {// joiner:2
				account.setJoinName(join_name);
				// account.setName(join_name);
				return true;
			}
		}
		return true;
	}

	// write
	public void writeAccounts(String filename) {
		String content = "";

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			for (Account a : accounts) {
				content += a.getName() + " " + a.getPassword() + " " + Integer.toString(a.getAuthority()) + " "
						+ a.getBalance().toString() + " " + a.getJoinName() + "\r\n";
				// oos.writeObject(content);
			}
			oos.writeObject(content);
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	// read
	public void readAccounts(String filename) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			Object object = ois.readObject();
			System.out.println(object);
		} catch (IOException exception) {
			exception.printStackTrace();
		} catch (ClassNotFoundException anything) {
			anything.printStackTrace();
		}
	}

	
	
}
