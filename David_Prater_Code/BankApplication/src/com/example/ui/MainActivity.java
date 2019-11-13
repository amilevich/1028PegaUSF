package com.example.ui;
import java.util.Scanner;
import com.example.users.NewCustomer;

public class MainActivity{
	
	static Scanner sc = new Scanner(System.in);
	static NewCustomer newCustomer = new NewCustomer();
	
	public static void main(String[] args) {
		int menuChoice = getMainMenu();
		openMainMenuChoice(menuChoice);
	}
	
	// Get the user's main menu choice
	public static int getMainMenu() {
		System.out.println("Please make a selection from the table below\n"
				+ "1. Apply for an account\n"
				+ "2. Account Login\n");
		int mainMenuChoice = sc.nextInt();
		return mainMenuChoice;
	}
	

		public static void openMainMenuChoice(int menuChoice) {
		switch (menuChoice) {
		case 1:
			System.out.println("New User");
			newCustomer.registerNewCustomer();
			System.out.println("Please try to log in later to see if you were approved!");
			break;
		case 2:
			System.out.println("What is your username");
			String username = sc.nextLine();
			
			
		}
	}
	
	
	
	public static void parseAccountInformation() {
		
	};

}