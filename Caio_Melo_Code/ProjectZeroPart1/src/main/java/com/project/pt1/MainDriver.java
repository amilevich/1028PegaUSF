package com.project.pt1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.naming.NameAlreadyBoundException;

import org.apache.log4j.Logger;

public class MainDriver {

	final static Logger Loggy = Logger.getLogger(MainDriver.class);
	public static void main(String[] args) {
Loggy.info("Information!");
		

try {
		prompt();
}
catch(InputMismatchException e) {
	System.out.println("Input Mismatch Detected..");
	prompt();
}

	}

	@SuppressWarnings("unchecked")
	public static void login(String x, String y) { 

		String fileName = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/applications/customers.ser"; // hoooly
																																		
		ArrayList<Customer> custCred = readCustomers();
		

			

			for (Customer temp : custCred) {

				if (temp.getUsername().contentEquals(x) && temp.getPassword().contentEquals(y)) {

					if (temp.appStatus.equals(Status.PENDING)) {

						System.out.println("Your account is still pending!");
						promptContinue();
						prompt();

					} else if (temp.appStatus.equals(Status.DENIED)) {
						System.out.println("Your account application has been denied. \n Too bad!");
						promptContinue();
						prompt();

					} else {

						System.out.println("Login Successful");
						Loggy.info("Successful Login by : "+x);
						temp.customerPrompt();
					}

				} else if (temp.getUsername().contentEquals(x) && !(temp.getPassword().contentEquals(y))) {

					System.out.println("Login Unsuccessful \nWould you like to try again? ");
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

						login(x, pw, custCred); 
						break;
					case 2:
						prompt();
						break;

					}
				}

			}

		}
	public static void login(String x, String y,ArrayList<Customer> z) { 

		String fileName = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/applications/customers.ser"; 
																																		

		ArrayList<Customer> custCred = z;
		


			for (Customer temp : custCred) {

				if (temp.getUsername().contentEquals(x) && temp.getPassword().contentEquals(y)) {

					if (temp.appStatus.equals(Status.PENDING)) {

						System.out.println("Your account is still pending! Sit tight, Atlas only spins so fast.");
						promptContinue();
						prompt();

					} else if (temp.appStatus.equals(Status.DENIED)) {
						System.out.println("Your account application has been denied. \n Too bad!");
						promptContinue();
						prompt();

					} else {

						System.out.println("Login Successful");
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
	@SuppressWarnings("unchecked")
	public static void employeeLogin(String x, String y) { 

		String fileName = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/employees/employees.ser"; // hoooly
																																	

		ArrayList<Employee> empCred = null;

		try {

			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(file);

			empCred = (ArrayList<Employee>) in.readObject();

			in.close();
			file.close();

			for (Employee temp : empCred) {
				if (temp.getUsername().contentEquals(x) && temp.getPassword().contentEquals(y)) {

					System.out.println("Login Successful");
					Loggy.info("Successful Employee Login. By :"+x);
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
			prompt();
		}

		catch (IOException ex) {
			System.out.println("No user found by the name: '" + x + "'");
			Loggy.fatal("Employee Username directory not found.");
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		}

	}

	public static void prompt() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Atlas Bank, please select from the available options:");

		System.out.println("1 \t Apply for an Account.");
		System.out.println("2 \t Customer Login. ");
		System.out.println("3 \t Employee Login. ");
		System.out.println("4 \t Admin Login.");
		
		System.out.println("5 \t Exit");
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
			String adminLogin = sc.next();
			System.out.println("Please enter your password");
			String adminPw = sc.next();
			adminLogin(adminLogin, adminPw);
			break;

		case 5:
			System.out.println("Now exiting......");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid Selection made, please enter a valid selection");
		}
	}

	public static void register(String x, String y) {

		String fileName = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/applications/customers.ser";
		ArrayList<Customer> cust = null;
		cust = readCustomers();

		if (duplicateCheck(x)) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Username taken. Try Again?");
			System.out.println("[1]Yes\n[2]No");
			int tryAgain = sc.nextInt();

			if (tryAgain == 1) {
				System.out.println("Please enter new username: ");
				String newName = sc.next();
				register(newName, y);
			} else {
				prompt();
			}
		} else {
			Customer object = new Customer(x, y);

			try {
				cust.add(object);

				FileOutputStream fop = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fop);

				oos.writeObject(cust);
				System.out.println("Account Created - Application Pending.");
				oos.close();
				fop.close();

			} catch (IOException ex) {
				System.out.println("IOException is caught - Register Creation Error");
			}
		}

	}

	public static ArrayList<Customer> addRemove(ArrayList<Customer> x, Customer y) {
		for (int i = 0; i < x.size(); i++) {

			if (x.get(i).getUsername().contentEquals(y.getUsername())) {

				x.remove(i);
				x.add(i, y);

			}

		}
		return x;
	}
	

	public static void promptContinue() {
		System.out.println("[ENTER]Continue");
		Scanner holdr = new Scanner(System.in);
		holdr.nextLine();

	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Customer> readCustomers() {
		String fileName = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/applications/customers.ser"; 
																																			
		ArrayList<Customer> custCred = null;
		try {

			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(file);

			custCred = (ArrayList<Customer>) in.readObject();

			in.close();
			file.close();

		} catch (IOException ex) {
			System.err.println("Failed Fetching Customer list in readCustomers()");
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		}
		return custCred;

	}

	public static Boolean duplicateCheck(String x) {

		ArrayList<Customer> dupList = readCustomers();

		for (Customer y : dupList) {

			if (y.getUsername().equalsIgnoreCase(x)) {
				return true;
			} 
		}

		return false;

	}
	
	public static void adminLogin(String x,String y) {

			String fileName = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/employees/admin/admin.ser";
																																				
			ArrayList<Admin> adminCred = null;
			try {

				FileInputStream file = new FileInputStream(fileName);
				ObjectInputStream in = new ObjectInputStream(file);

				adminCred = (ArrayList<Admin>) in.readObject();

				
				
				in.close();
				file.close();

				// TODO implement another branch so they cant get in if account is still
				// pending.

				for (Admin temp : adminCred) {

					if (temp.getUsername().contentEquals(x) && temp.getPassword().contentEquals(y)) {
							temp.adminPrompt(); 
							Loggy.info("Admin Login by:" +x);
						}

					 else if(temp.getUsername().contentEquals(x) && !(temp.getPassword().contentEquals(y))) {

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

							adminLogin(x, pw); // uses same username that was passed to it, but new password
							break;
						case 2: // Send back to main screen.
							prompt();
							break;

						}
					}
					
				}
				}

			

			catch (IOException ex) {
				System.out.println("No user found by the name: '" + x + "Admin'");
			}

			catch (ClassNotFoundException ex) {
				System.out.println("ClassNotFoundException is caught");
			}

		}
	
	

}
