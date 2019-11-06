package com.example.bankaccount;

import java.util.Scanner;

public class MainDriver {

	
	public static void main(String[] args) {
		
		//Instance of Scanner function
		Scanner scanner = new Scanner(System.in);

		//Instance of class Customers
		Customers customer1 = new Customers();
		
		// Menu Popup
		customer1.Menu(0);
		
////		Use Scanner method for input data
//		
//		//Set Username
//		System.out.println("Create Username: ");
//		String userName = scanner.nextLine();
//		customer1.setUsername(userName);
//		System.out.println("Welcome " + customer1.getUsername());
//		
//		//Set Password
//		System.out.println("Create Password: ");
//		String passWord = scanner.nextLine();
//		customer1.setPassword(passWord);
		
		
//		Checking checking deposit & withdraw
		
		customer1.Deposit("checking deposit", 100);
		customer1.getTotalBalance();
		customer1.Withdraw("checking withdraw", 50);
		
		
//		Checking saving deposit & withdraw
		
		customer1.Deposit("saving deposit", 200);
		customer1.getTotalBalance();
		customer1.Withdraw("saving withdraw", 70);
		
//		customer1.customerList(userName, passWord, customer1);    
		
//		Instantiate Employee class & Call for the View Customer Account info

	}
	

		
}
