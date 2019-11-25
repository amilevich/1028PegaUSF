package com.frontend;


import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.users.BankAdmin;
import com.users.Customer;
import com.users.Employee;

public class MainDriver {
	//prompts the user to stay on their current menu
	public static boolean keepinteracting(Scanner in, String account) {
		System.out.println("Do you want to carry on with " + account + " login menu?(yes or no)");
		String input = in.next();
		if(input.equals("yes")) {
			return true;
		}else if(input.equals("no")) {
			return false;
		}else {
			System.out.println("That is not a vaild input, you'll be taken out of the " + account + "menu");
			return false;
		}
	}
	//Introductory menu 
	public static void introductoryMenu() {
		System.out.println("Hello, Welcome to our lovely Bank.");
		System.out.println("Remember to have an employee in training to be a pega trainee by your side.");
		System.out.println("Let's get the legal stuff out of the way.");
		System.out.println("We will not be legally elligibale for any damages caused, also for any money lost (we have no insurance either)." + "\n");
	}
	
	//Instantiating new scanner object, used for all user interactions
	public static Scanner in = new Scanner(System.in);
	final static Logger loggy = Logger.getLogger(MainDriver.class);
	
	public static void main(String[] args) {
		
		//Deserialize placeholder
//		deserialiseSomeStuff();
		
		boolean interacting = true;
		introductoryMenu();
		do{
			loggy.info("User logged in.");
			
			System.out.println("Which menu would you like to access?"); //Giving user the options for which menu they'd like
			System.out.println("[0] Customer");
			System.out.println("[1] Employee");
			System.out.println("[2] Bank Admin");
			System.out.println("[3] Escape");
			try {
				int input = in.nextInt(); 
				in.nextLine();
				switch(input) {	
				case 0:
					loggy.info("User logged in as a customer");
					Customer.access(in);  //Accesses the customer menu
					loggy.info("User logged out of customer menu");
					break;
				case 1:
					loggy.info("User logged in as a employee");
					Employee.employeeLogin(in); //Accesses the employee login
					loggy.info("User logged out of employee menu");
					break;
				case 2:
					loggy.info("User logged in as a boss");
					BankAdmin.employeeLogin(in); //Access the bank admin login
					loggy.info("User logged out of admin menu");
					break;
				case 3:
					loggy.info("User chose to escape the menu");
//					interacting = keepinteracting(in, "bank");
					break;
			}
			interacting = keepinteracting(in, "bank"); 
			}catch(InputMismatchException e) {
				
				loggy.info("User input an invalid data type");

				System.out.println("\n" + "Invalid input, try to follow the (VERY) easy instructions next time." + 
				"You've been returned to the main menu" + "\n");
				in.nextLine();
			}
		}while(interacting);

//		serialiseSomeStuff();
			
		System.out.println("Thank you for using our esquisitley designed menu");
	}
}
