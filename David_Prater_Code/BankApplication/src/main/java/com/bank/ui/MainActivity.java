package com.bank.ui;
import java.io.FileNotFoundException;

import com.bank.dao.AccountDaoImp;
import com.bank.model.Account;
import com.bank.ui.BankMenu;

public class MainActivity{
	
	
	public static void main(String[] args) throws FileNotFoundException {
		// Try reading the file and catch the error it returns if the file doesn't exist
		Account accountOne = new Account("1", 1000, "David", "Prater", "906 William", "davidp", "password");
		
		AccountDaoImp accountDaoImpl = new AccountDaoImp();
		accountDaoImpl.updateAccount(accountOne);
		
		
		try{
			BankMenu.readCustomerList();
			}catch(Exception e) {
				e.printStackTrace();
			};
			
			System.out.println("");
			
		// Call this method to run the entire program
		BankMenu.getMainMenu();
	}
	
}