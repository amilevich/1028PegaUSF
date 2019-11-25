package com.project.pt1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.project.dao.AdminDAOimp;
import com.project.dao.CustomerDAOclass;

public class MainDriver {

	static CustomerDAOclass cDAO = new CustomerDAOclass();
	static AdminDAOimp aDAO = new AdminDAOimp();

	final static Logger Loggy = Logger.getLogger(MainDriver.class);

	public static void main(String[] args) {
		displayMain();
		try {
			prompt();
		} catch (InputMismatchException e) {
			System.out.println("Input Mismatch Detected..");
			prompt();
		} finally {
			prompt(); // NEWLY ADDED!
		}

	}

	public static void login(String x, String y) {
		x = x.toLowerCase();
		y = y.toLowerCase();

		ArrayList<Customer> credentials = null;
		credentials = cDAO.selectAllCustomers();
		for (Customer temp : credentials) {
			if (temp.getUsername().contentEquals(x) && temp.getPassword().contentEquals(y.toLowerCase())) {
				if (temp.appStatus == Status.PENDING) {

					System.out.println("Your account is still pending!");
					promptContinue();
					prompt();

				} else if (temp.appStatus == Status.DENIED) {
					System.out.println("Your account application has been denied. \n Too bad!");
					promptContinue();
					prompt();

				} else {

					System.out.println("---- Login Successful ----");
					Loggy.info("Successful Login by : " + x);
					temp.customerPrompt();
				}

			} else if (temp.getUsername().contentEquals(x) && !(temp.getPassword().contentEquals(y))) {

				System.out.println("Password attempt unsuccessful \nWould you like to try again? ");
				Loggy.info("Failed Login! By: " + x);

				System.out.println("1\tYes");
				System.out.println("2\tNo");
				System.out.println("Please make a selection(1-2)");
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				int selection = sc.nextInt();

				switch (selection) {
				case 1:
					System.out.println("Please enter your password");
					String pw = sc.next();

					login(x, pw, credentials);
					break;
				case 2:
					prompt();
					break;

				}
			}
		}
			
				System.out.println("No user found by that username.");
				prompt();
			
		
//prompt
	}

	public static void login(String x, String y, ArrayList<Customer> z) {

		ArrayList<Customer> custCred = z;

		for (Customer temp : custCred) {
			System.out.println(temp.toString());
			if (temp.getUsername().contentEquals(x) && temp.getPassword().contentEquals(y)) {

				if (temp.appStatus.equals(Status.PENDING)) {

					System.out.println("Your account is still pending! Check back soon. ");
					promptContinue();
					prompt();

				} else if (temp.appStatus.equals(Status.DENIED)) {
					System.out.println("Your account application has been denied. \n Get better credit!");
					promptContinue();
					prompt();

				} else {

					System.out.println("---- Login Successful ----");
					temp.customerPrompt();
				}

			} else if (temp.getUsername().contentEquals(x) && !(temp.getPassword().contentEquals(y))) {

				System.out.println("Login Unsuccessful \nWould you like to try again? ");

				System.out.println("1\tYes");
				System.out.println("2\tNo");
				System.out.println("Please make a selection(1-2)");
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				int selection = sc.nextInt();

				switch (selection) {
				case 1:
					System.out.println("Please enter your password");
					String pw = sc.next();

					login(x, pw, z);
					break;
				case 2:
					prompt();
					break;

				}
			}

		}

	}

	public static void employeeLogin(String x, String y) { // PT1
		x = x.toLowerCase();
		ArrayList<Employee> empCred = null;
		empCred = aDAO.selectAllEmployees();

		for (Employee temp : empCred) {
			if (temp.getUsername().contentEquals(x) && temp.getPassword().contentEquals(y)) {

				System.out.println("---- Login Successful ----");
				Loggy.info("Successful Employee Login. By :" + x);
				Employee.employeePrompt();

			} else if (temp.getUsername().contentEquals(x) && !(temp.getPassword().contentEquals(y))) {

				System.out.println("Login Unsuccessful \nWould you like to try again? ");

				System.out.println("1\tYes");
				System.out.println("2\tNo");
				System.out.println("Please make a selection(1-2)");
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				int selection = sc.nextInt();

				switch (selection) {
				case 1:
					System.out.println("Please enter your password");
					String pw = sc.next();
					employeeLogin(x, pw);
					break;
				case 2:
					prompt();
					break;
				}
			} else {
				System.out.println("Username not found.");
				prompt();
			}

		}

	}

	public static void prompt() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Atlas Bank, please select from the available options:");

		System.out.println("[1] \t Apply for an Account.");
		System.out.println("[2] \t Customer Login. ");
		System.out.println("[3] \t Employee Login. ");
		System.out.println("[4] \t Admin Login.");
		System.out.println("[5] \t Exit");
		System.out.println("Please make a selection(1-4)");

		int selection = sc.nextInt();

		switch (selection) {

		case 1:
			System.out.println("Please enter your username");
			String tempName = sc.next();

			System.out.println("Please enter your password");
			String tempPassword = sc.next();

			register(tempName, tempPassword);
			prompt();

			break;
		case 2:
			System.out.println("Please enter your username");
			String login = sc.next();
			System.out.println("Please enter your password");
			String pw = sc.next();

			login(login, pw);
			break;
		case 3:
			System.out.println("Please enter your username");
			String elogin = sc.next();

			System.out.println("Please enter your password");
			String epw = sc.next();
			employeeLogin(elogin, epw);
			break;
		case 4:
			System.out.println("Please enter your username");
			String log = sc.next();
			System.out.println("Please enter your password");
			String adminPw = sc.next();
			adminLogin(log, adminPw);
			break;

		case 5:
			System.out.println("Now exiting......");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid Selection made, please enter a valid selection");
		}
	}

	@SuppressWarnings("resource")
	public static void register(String x, String y) {
		x = x.toLowerCase();

		ArrayList<Customer> cust = null;
		cust = cDAO.selectAllCustomers(); // SQL

		if (duplicateCheck(x)) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Username taken. Try Again?");
			System.out.println("[1]Yes\n[2]No");
			int tryAgain = sc.nextInt();

			if (tryAgain == 1) {
				System.out.println("Please enter new username: ");
				String newName = sc.next();

				System.out.println("Please enter password: ");
				String pass = sc.next();

				register(newName, pass);
			} else {
				prompt();
			}
		} else {
			Customer object = new Customer(x, y);
			cDAO.insertCustomer(object); // SQL -----------
			System.out.println("Acount Application sent! ");
			promptContinue();

		}

	}

	public static void promptContinue() {
		System.out.println("[ENTER]Continue");
		Scanner holdr = new Scanner(System.in);
		holdr.nextLine();

	}

	@SuppressWarnings("unchecked")

	public static ArrayList<Customer> readSQLCustomers() {
		ArrayList<Customer> temp = cDAO.selectAllCustomers();
		return temp;
	}

	public static Boolean duplicateCheck(String x) {

		ArrayList<Customer> dupList = cDAO.selectAllCustomers();

		for (Customer y : dupList) {

			if (y.getUsername().equalsIgnoreCase(x)) {
				return true;
			}
		}

		return false;

	}

	public static void adminLogin(String x, String y) {

		ArrayList<Admin> adminCred = null;
		adminCred = aDAO.selectAllAdmin();
		for (Admin temp : adminCred) {

			if (temp.getUsername().contentEquals(x) && temp.getPassword().contentEquals(y)) {
				System.out.println("--- Login Successful ---");
				Admin.adminPrompt();
				Loggy.info("Admin Login by:" + x);
			}

			else if (temp.getUsername().contentEquals(x) && !(temp.getPassword().contentEquals(y))) {

				System.out.println("Login Unsuccessful \nWould you like to try again? ");

				System.out.println("[1]\tYes");
				System.out.println("[2]\tNo");
				System.out.println("Please make a selection(1-2)");
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				int selection = sc.nextInt();

				switch (selection) {
				case 1:
					System.out.println("Please enter your password");
					String pw = sc.next();

					adminLogin(x, pw);
					break;
				case 2:
					prompt();
					break;

				}
			}

		}

	}

	public static void displayMain() {

		try {
			System.out.println();
			System.out.println("         .8.    8888888 8888888888 8 8888                  .8.            d888888o.             8 888888888o          .8.          b.             8 8 8888     ,88' ");  
			TimeUnit.MILLISECONDS.sleep(200);
			System.out.println("        .888.         8 8888       8 8888                 .888.         .`8888:' `88.           8 8888    `88.       .888.         888o.          8 8 8888    ,88'  ");  
			TimeUnit.MILLISECONDS.sleep(200);
			System.out.println("       :88888.        8 8888       8 8888                :88888.        8.`8888.   Y8           8 8888     `88      :88888.        Y88888o.       8 8 8888   ,88'   ");  
			TimeUnit.MILLISECONDS.sleep(200);
			System.out.println("      . `88888.       8 8888       8 8888               . `88888.       `8.`8888.               8 8888     ,88     . `88888.       .`Y888888o.    8 8 8888  ,88'    ");  
			TimeUnit.MILLISECONDS.sleep(200);
			System.out.println("     .8. `88888.      8 8888       8 8888              .8. `88888.       `8.`8888.              8 8888.   ,88'    .8. `88888.      8o. `Y888888o. 8 8 8888 ,88'     ");  
			TimeUnit.MILLISECONDS.sleep(200);
			System.out.println("    .8`8. `88888.     8 8888       8 8888             .8`8. `88888.       `8.`8888.             8 8888888888     .8`8. `88888.     8`Y8o. `Y88888o8 8 8888 88'      ");  
			TimeUnit.MILLISECONDS.sleep(200);
			System.out.println("   .8' `8. `88888.    8 8888       8 8888            .8' `8. `88888.       `8.`8888.            8 8888    `88.  .8' `8. `88888.    8   `Y8o. `Y8888 8 888888<       ");  
			TimeUnit.MILLISECONDS.sleep(200);
			System.out.println("  .8'   `8. `88888.   8 8888       8 8888           .8'   `8. `88888.  8b   `8.`8888.           8 8888      88 .8'   `8. `88888.   8      `Y8o. `Y8 8 8888 `Y8.     ");  
			TimeUnit.MILLISECONDS.sleep(200);
			System.out.println(" .888888888. `88888.  8 8888       8 8888          .888888888. `88888. `8b.  ;8.`8888           8 8888    ,88'.888888888. `88888.  8         `Y8o.` 8 8888   `Y8.   ");  
			TimeUnit.MILLISECONDS.sleep(200);
			System.out.println(".8'       `8. `88888. 8 8888       8 888888888888 .8'       `8. `88888. `Y8888P ,88P'           8 888888888P .8'       `8. `88888. 8            `Yo 8 8888     `Y8. \n");
			TimeUnit.MILLISECONDS.sleep(1000);	


		} catch (InterruptedException e) {

			System.out.println("Delay in Display() Exception.");

		}
	}
}
