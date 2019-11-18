package com.bank.ui;
import java.io.FileNotFoundException;

import org.apache.log4j.Logger;

import com.bank.ui.BankMenu;

public class MainActivity{
	
	
	public static void main(String[] args) throws FileNotFoundException {
		// Try reading the file and catch the error it returns if the file doesn't exist
		try{
			BankMenu.readCustomerList();
			}catch(Exception e) {
				e.printStackTrace();
			};
		// Call this method to run the entire program
		BankMenu.getMainMenu();
	}
	
}