package com.app.main;

public class MainDriver extends Menu{

	public static void main(String[] args) { //run full cycle
		BankImpl bankDao = new BankImpl();
		Menu menu =  new Menu(); 
		menu.runWelcomeMenu();
		bankDao.truncateAccounts();
		bankDao.truncateCustomers();
		bankDao.truncateSqlKeys();
		bankDao.insertAllAccts(menu.allAccHash);
		bankDao.insertAllCusts(menu.allCustHash);
		
		
	}	
	
}