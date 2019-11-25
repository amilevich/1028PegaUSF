package com.examples.menu;

import java.util.Scanner;

import com.examples.customers.Customers;
import com.examples.customers.CustomersMenu;
import com.examples.employeemenu.EmpMenu;

public class MainMenu {
	
	public static void menu()  {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Customers cust = new Customers();

		int option;
		int input;
		    System.out.println();
		    System.out.println("=========================================");
			System.out.println("\n       Welcome to Revature Bank \n");
			System.out.println("=========================================");
	        System.out.println(" Press 1 if your are already a customer.");
	        System.out.println(" Press 2 to sign in as an employee.");
	        System.out.println(" Press 3 to sign in as an admin.");
	        System.out.println(" Press 4 to register an account with us.");
	        System.out.println(" Press 0 to exit.");
	        System.out.println("=========================================");
	        System.out.println();
	        
		do {
			input = sc.nextInt();
			option = input;
			switch (option) {
			case 1:
				CustomersMenu.customerSignIn();
				break;
			case 2:
				EmpMenu.employeeSignIn();
				break;
			case 3:
				EmpMenu.employeeSignIn();
				break;
			case 4:
				CustomersMenu.Registration();
				break;
			case 0:
				System.out.println("Have a nice day!");
				break;
			default:
				System.out.println("You entered the wrong option");
			}
		} while	 (option != 0);
	}
}
