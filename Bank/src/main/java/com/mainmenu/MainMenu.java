package com.mainmenu;

import java.util.Scanner;

import com.accounts.Accounts;
import com.bankmenu.AdminMenu;
import com.bankmenu.BankMenu;
import com.customers.Customers;
import com.customers.CustomersMenu;
import com.daos.AccountsDaoImpl;

public class MainMenu {
	
	public static void mainMenu()  {
		Scanner sc = new Scanner(System.in);
		Customers cust = new Customers();

		char option;
		String input;
		   System.out.println();
	        System.out.println("________________________________________________________________________ ");
	        System.out.println("|                         W E L C O M E TO:                             |");
	        System.out.println("|                                                                       |");
	        System.out.println("|                         CRISTIAN'S BANKAPP                            |");
	        System.out.println("|_______________________________________________________________________|");
	        System.out.println("|  A :If your are already a customer, please sign in                    |");
	        System.out.println("|  B: Sign in as an employee                                            |");
	        System.out.println("|  C: Register to open an account with us                               |");
	        System.out.println("|  D  Sign in as an admin                                               |");
	        System.out.println("|  E: Exit                                                              |");
	        System.out.println("|_______________________________________________________________________|");
	        System.out.println();
	        System.out.print("Please enter your option below: ");
	        System.out.println();
		do {
			input = sc.next();
			option = input.charAt(0);
			switch (option) {
			case 'a':
				// sign in as a customer method
				
				CustomersMenu.customerSign();
				//bankingMenu();
				break;
			case 'b':
				// sign in as employee method
				BankMenu.EmployeeSignin();
				break;
			case 'c':
				// Customer register method
				CustomersMenu.Registration();
				break;
			case 'd':
				AdminMenu.adminSignin();
				break;
			case 'e':
				System.out.println("Thank you and goodbye!");
				break;
			default:
				System.out.println("You entered the wrong option");
			}
		} while	 (option != 'q');
	}

		
	

}
