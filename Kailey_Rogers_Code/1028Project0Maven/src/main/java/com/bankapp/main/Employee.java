package com.bankapp.main;

import java.util.HashMap;
import java.util.Scanner;

public class Employee extends Account{ 
	private String employeeUsername = "employee1";
	private String employeePassword = "empassword";
	public static final boolean validInput = false;
	public static int flag = 0;
	public static int flag1 = 0;

	// Getters and Setters
	public String getEmployeeUsername() {
		return employeeUsername;
	}

	public void setEmployeeUsername(String employeeUsername) {
		this.employeeUsername = employeeUsername;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	// Employee Login
	public void employeeLogIn(HashMap<String, Customer> hMap) {
		Scanner cls = new Scanner(System.in);

		// get username
		String temp;
		while (!validInput && flag == 0) {
			System.out.print("Please enter your username: ");
			temp = cls.nextLine();
			// if user exists
			if (temp.equals(employeeUsername)) {
				System.out.println("\n");
				System.out.print("Please enter your password: ");
				temp = cls.nextLine();

				// if password matches
				if (temp.equals(employeePassword)) {
					double temp3;
					int temp2;
					while (!validInput && flag1 == 0) {
						System.out.println("\n");
						System.out.println("Welcome to the employee portal.  Here are your options:");
						System.out.println("1 view account info");
						System.out.println("2 accounts needing approval");
						System.out.println("3 exit to main menu");
						System.out.print("What would you like to do: ");
						while (!validInput) {
							try {String input = cls.nextLine();
							temp2 = Integer.valueOf(input);
							break;
							}catch(Exception e){
								System.out.println("Please enter a valid number.");
							}
						}


						switch (temp2) {
						case 1:
							this.viewAccountPro(hMap);
							break;
						case 2:
							this.accountApprovePro(hMap);
							break;
						case 3:
							flag1 = 1;
							flag = 1;
							break;
						default:
							System.out.print("Not a valid input.  Please enter a valid input: ");
							break;
						}
					}
					flag1 = 0;
				} else {
					System.out.print("Incorrect password.  Please try again: ");
				}
			} else {
				System.out.print("Incorrect username.  Please try again: ");
			}
		}
		flag = 0;
	}
}
