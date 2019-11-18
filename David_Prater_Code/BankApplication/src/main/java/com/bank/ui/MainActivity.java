package com.bank.ui;
import java.io.FileNotFoundException;

import com.bank.ui.BankMenu;

public class MainActivity{
	
	
	public static void main(String[] args) throws FileNotFoundException {
		//openMainMenuChoice(menuChoice);
		try{
			BankMenu.readCustomerList();
			}catch(Exception e) {
				e.printStackTrace();
			};
		BankMenu.getMainMenu();
	}
	
}