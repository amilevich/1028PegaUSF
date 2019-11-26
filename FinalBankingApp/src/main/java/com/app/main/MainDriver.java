package com.app.main;

public class MainDriver{

	public static void main(String[] args) {
		BankImpl bankDao = new BankImpl();
		Menu menu =  new Menu(); 
		menu.runWelcomeMenu();

		bankDao.insertAllAccts(menu.allAccHash);
		bankDao.insertAllCusts(menu.allCustHash);
		
		
	}	
	
}