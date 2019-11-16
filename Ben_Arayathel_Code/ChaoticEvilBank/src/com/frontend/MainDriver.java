package com.frontend;

import java.util.Scanner;

import com.users.BankAdmin;
import com.users.Customer;
import com.users.Employee;

public class MainDriver {
	public static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		
		boolean interacting = true;
		while(interacting) {
			boolean menuInteraction = true;
			System.out.println("Hello");
			System.out.println("Input 0,1,2, depending on whether you're a customer,employee or bank admin");
		//	Scanner in = new Scanner(System.in);
			int input = in.nextInt();
			in.nextLine();
			switch(input) {	
			case 0:
				while(menuInteraction) {
				Customer.access(in);
				System.out.println("Carry on with customer login?(true or false)");
				menuInteraction = in.nextBoolean();
				}
				System.out.println("Customer interaction complete.");
				break;
			case 1:
				while(menuInteraction) {
				Employee.employeeLogin(in);
				System.out.println("Carry on with employee login?(true or false)");
				menuInteraction = in.nextBoolean();
				}
				System.out.println("Employee interaction complete");
				break;
			case 2:
				while(menuInteraction) {
				BankAdmin.employeeLogin(in);
				System.out.println("Carry on as a Admin?(true or false)");
				menuInteraction = in.nextBoolean();
				}
				System.out.println("Bank Administrator interaction complete");
				break;
			}

		}
		
	}
}
