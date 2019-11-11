package com.example.bank;

public class Menu extends Admin{
	private int menuOption;
	
	public void menuPopup() {
		System.out.println("Welcome to the Bank" + "\n" + Customers.getFirstName());
		switch (menuOption) {
		
		case 1 : 
			System.out.println("Customer");
			break;
		case 2 : 
			System.out.println("Employee");
			break;
		case 3 : 
			System.out.println("Admin");
			break;
		case 4 : 
			System.out.println("Register");
			break;
		default:
			System.out.println("Error");
		}
	
		
	}


}
