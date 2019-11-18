package com.project.pt1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;


public class Admin implements Serializable {

	/**
	 * 
	 */
	final static Logger Loggy = Logger.getLogger(Admin.class);
	private String username;
	private String password;
	private double funds;

	public Admin() {

	}

	public Admin(String x, String y) {

		this.username = x;
		this.password = y;

	}

	public void adminLogin() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void viewApplications() { // Finished but not tested.

		ArrayList<Customer> custList = MainDriver.readCustomers();

		ArrayList<Customer> openApplications = new ArrayList<Customer>();

		int count = 1;
		for (Customer temp : custList) {
			if (temp.appStatus == Status.PENDING) {

				openApplications.add(temp);
				System.out.println(count + "---" + temp.toString());
				count++;
			}
		}

		Scanner scanMan = new Scanner(System.in);
		
		if (openApplications.isEmpty()) {
			System.out.println("No Pending Applications");

		} else if (openApplications.size() == 1) {
			System.out.println("[1]\t Which application would you like to view?");

		} else {
			System.out.println("[1-" + (count - 1) + "] - Which application would you like to view?");
			System.out.println();
		}

		int input = scanMan.nextInt();
		if (input > openApplications.size() | input < 0) {
			System.out.println("Invalid selection made. Please try again.");
			viewApplications();
			return;
		} else {
			System.out.println(openApplications.get(input - 1).toString());
			System.out.println("[1]-Approve  [2]-Deny");

			int dec = scanMan.nextInt();

			switch (dec) {
			case 0:
				break;
			case 1:
				Customer temp = openApplications.get(input - 1);
				approveApplication(temp);
				break;
			case 2:
				Customer temp1 = openApplications.get(input - 1);
				denyApplication(temp1);
			}
		}

	}

	public void viewJApplications() {

		String fileName = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/applications/customers.ser"; // hoooly
																																			// shit
																																			// this
																																			// works
		ArrayList<Customer> custCred = null;
		try {

			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(file);

			custCred = (ArrayList<Customer>) in.readObject();

			ArrayList<Customer> openApplications = new ArrayList<Customer>();

			in.close();
			file.close();

			int count = 1;
			for (Customer temp : custCred) {
				if (temp.jointStatus == jStatus.PENDING) {

					openApplications.add(temp);
					System.out.println(count + "---" + temp.toString());
					count++;
				}
			}

			Scanner scanMan = new Scanner(System.in);
			if (openApplications.size() == 1) {
				System.out.println("One current application:");
			} else {
				System.out.println("[1-" + (count - 1) + "] - Which application would you like to view?" + "[1-"
						+ (count - 1) + "]");
				System.out.println();
			}

			int input = scanMan.nextInt();

			System.out.println(openApplications.get(input - 1).toString());
			System.out.println("[1]-Approve  [2]-Deny");
			Scanner sc = new Scanner(System.in);

			int dec = sc.nextInt();

			switch (dec) {
			case 1:
				Customer temp1 = openApplications.get(input - 1);
				System.out.println("Account Approved.");
				approveJointApplication(temp1);
				temp1.updateFile();
				break;
			case 2:
				Customer temp = openApplications.get(input - 1);
				denyJointApplication(temp);
				temp.updateFile();
				System.out.println("Account Denied.");
				break;
			default:
				System.out.println("Invalid Selection.");

				break;
			}
		} catch (IOException ex) {
			System.out.println("No user found by the name:  ");
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		}

	}

	public void viewInfo() {
		ArrayList<Customer> custCred = MainDriver.readCustomers();

		for (Customer temp : custCred) {
			System.out.println(temp.toString());

		}
		System.out.println("What would you like to do?");
		System.out.println("[1] - View Additional Details");
		System.out.println("[2] - Return to Main Menu");

		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		ArrayList<Customer> detList = new ArrayList<Customer>();

		switch (input) {
		case 1:

			int count = 1;
			for (Customer temp : custCred) {

				detList.add(temp);
				System.out.println(count + "---" + temp.toString());
				count++;

			}
			if (count == 1) {
				System.out.println("For which Customer would you like to view additional details? [1]");
			} else {
				System.out.println(
						"For which Customer would you like to view additional details? [1-" + (count - 1) + "]");
			}

			int input1 = sc.nextInt();
			Customer temp = detList.get(input1 - 1);
			System.out.println(temp.toDetailedString());
			
			// TODO Write Admin detailed String.

			money(temp); // bring up money options menu

			break;
		case 2: // Return to Admin main menu
			adminPrompt();
			break;
		default:
			System.out.println("Invalid Selection made. Returning to main menu..");
			adminPrompt();
			break;

		}

	}

	public static void approveApplication(Customer x) {
		x.setStatus(Status.APPROVED);
		x.updateFile();
		System.out.println("Account Approved.");
		Loggy.info("Approved Application");
		

	}

	public static void denyApplication(Customer x) {

		x.setStatus(Status.DENIED);
		x.updateFile();
		System.out.println("Account Denied.");
		Loggy.info("Denied Application");

	}

	public void approveJointApplication(Customer x) {

		String User = x.JointAppDetails[0];
		String PW = x.JointAppDetails[1];

		x.JointAppDetails[0] = null;
		x.JointAppDetails[1] = null;

		String fileName = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/applications/customers.ser";
		ArrayList<Customer> custCred = null;
		try {

			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(file);

			custCred = (ArrayList<Customer>) in.readObject();

			in.close();
			file.close();

			for (Customer z : custCred) {

				if (z.getUsername().contentEquals(User) && z.getPassword().contentEquals(PW)) {

					z.account.accountID = x.account.accountID; // getter/setter later
					z.jointStatus = jStatus.APPROVED;
					z.updateFile();
					break;
				}

			}

			x.jointStatus = jStatus.APPROVED;
			System.out.println("Application Approved.");
			x.updateFile();

		} catch (IOException ex) {
			System.out.println("No user found by the name:  ");
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		}
		Loggy.info("Joint Approved Application");

	}

	public void denyJointApplication(Customer x) {

		x.jointStatus = jStatus.DENIED;
		System.out.println("Application denied.");

		ArrayList<Customer> custCred = MainDriver.readCustomers();

		for (Customer z : custCred) {

			if (z.getUsername().contentEquals(x.JointAppDetails[0])
					&& z.getPassword().contentEquals(x.JointAppDetails[1])) {

				z.jointStatus = jStatus.DENIED;
				z.updateFile();
				break;
			}

		}
		x.updateFile();
	}

	public void loseJointApplication(Customer x) {

		x.jointStatus = jStatus.LOST_IN_BEUROCRACY;
		System.out.println("Application Lost. Whoopsie!");
		x.updateFile();

	}

	public void adminPrompt() {

		/*
		 * This includes: Approving/denying accounts View Accounts>View
		 * Specific>Edit/Cancel/Transfers
		 * 
		 */

		System.out.println("What would you like to do?");
		System.out.println("[1] \tView Customer Accounts");
		System.out.println("[2] \tView Employee Accounts");
		System.out.println("[3] \tView Open Applications");
		System.out.println("[4] \tView Open Joint Applications");
		System.out.println("[5] \tLogout");
		System.out.println("Please make a selection.[1-6]");
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();

		switch (input) {
		case 1:
			viewInfo(); // written not tested
			MainDriver.promptContinue();
			adminPrompt();
			break;
		case 2:
			employeeOptions();
			adminPrompt();
			break;
		case 3:
			viewApplications(); // Written not tested
			MainDriver.promptContinue();
			adminPrompt();
			break;
		case 4:
			viewJApplications();
			MainDriver.promptContinue();
			adminPrompt();
			break;
		case 5:
			System.out.println("Now logging out.");
			MainDriver.promptContinue();
			MainDriver.prompt();
			break;
		default:
			System.out.println("Invalid selection.");
			adminPrompt();
			break;
		}

	}

	public void updateFile() { // UPDATED*(UNTESTED)

		String fileName = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/employees/admin/admin.ser";
		ArrayList<Admin> adminList = null;

		adminList = readAdmin();

		try {

			adminList = addRemove(adminList, this);

			FileOutputStream fop = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fop);

			oos.writeObject(adminList);

			fop.close();
			oos.close();

			System.out.println("Account Updated for '" + this.getUsername() + "'");

		} catch (IOException ex) {
			System.out.println("IOException is caught - Admin Update Error");
		}
	}

	public static ArrayList<Admin> readAdmin() {
		String fileName = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/employees/admin/admin.ser";
																																			
		ArrayList<Admin> adminCred = null;
		try {

			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(file);

			adminCred = (ArrayList<Admin>) in.readObject();

			in.close();
			file.close();

		} catch (IOException ex) {
			System.err.println("Failed Fetching Customer list in readAdmin()");
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		}
		return adminCred;

	}

	public static ArrayList<Admin> addRemove(ArrayList<Admin> x, Admin y) {
		for (int i = 0; i < x.size(); i++) {

			if (x.get(i).getUsername().contentEquals(y.getUsername())) {

				x.remove(i);
				x.add(i, y);

			}

		}
		return x;
	}

	public void money(Customer x) {
		System.out.println("[1]\t Deposit Funds");
		System.out.println("[2]\t Withdraw Funds");
		System.out.println("[3]\t Transfer Funds");
		System.out.println("[4]\t Delete Account");
		System.out.println("[5]\t Return to Menu");
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();

		switch (input) {
		case 1:
			System.out.println("How much would you like to deposit?");
			double deposit = scan.nextDouble();
			x.setFunds(deposit + x.getFunds());
			System.out.println("$" + deposit + " has been deposited to" + x.getUsername());
			System.out.println("New Balance....$" + x.getFunds());
			x.updateFile();
			Loggy.info("Admin has deposited.");
			break;
		case 2:
			System.out.println("How much would you like to withdraw?");
			double withdraw = scan.nextDouble();
			if (x.getFunds() >= withdraw) {
				x.setFunds(x.getFunds() - withdraw);
				System.out.println("Dispensing $" + withdraw + ".");
				System.out.println("New Balance....$" + x.getFunds());
				x.updateFile();
				Loggy.info("Money withdrawn by Admin! From: "+ x.getUsername());

			} else {
				System.out.println("Insufficient funds.");
				MainDriver.promptContinue();
				money(x);
			}
			break;
		case 3:
			transferFunds(x);
			Loggy.info("Money transfered by Admin! From: "+ x.getUsername() );
			MainDriver.promptContinue();
			adminPrompt();
			break;
		case 4:
			delete(x);
			System.out.println("Customer " + x.getUsername() + " deleted.");
			Loggy.info("Account deleted by Admin! From: "+ x.getUsername() );
			break;
		case 5:
			System.out.println("Returning to main menu.");
			break;
		default:
			System.out.println("Invalid selection made. Please try again.");
			MainDriver.promptContinue();
			money(x);
			break;
		}

	}

	public void transferFunds(Customer x) {

		ArrayList<Customer> custList = MainDriver.readCustomers();
		int count = 1;
		for (Customer temp : custList) {
			if (!(temp.getUsername().contentEquals(x.getUsername()))) {
				System.out.println(
						"[" + count + "] \t User: [" + temp.getUsername() + "] Balance: [" + temp.getFunds() + "]");
			}
		}
		if (custList.size() == 0) {
			System.out.println("No accounts currently open.");
		} else if (custList.size() == 1) {
			System.out.println("[1] \tTo which account would you like to transfer funds between?");
		} else {
			System.out.println("[1 - " + count + "] \t To which account would you like to transfer funds between?");
		}
		Scanner scan = new Scanner(System.in);
		int selection = scan.nextInt();

		Customer tempTrans = custList.get(selection - 1);

		System.out.println(x.getUsername() + "'s Account balance...." + x.getFunds());
		System.out.println(tempTrans.getUsername() + "'s Account balance...." + tempTrans.getFunds());

		System.out.println("[1]\t Transfer to " + x.getUsername());
		System.out.println("[2]\t Transfer to " + tempTrans.getUsername());
		System.out.println("[3]\t Return");
		int input = scan.nextInt();
		System.out.println("Please enter amount to transfer: ");
		double transAmount = scan.nextDouble();

		switch (input) {
		case 1:
			if (transAmount > tempTrans.getFunds()) {
				System.out.println("Insufficient Balance to complete transfer.");
				transferFunds(x);
			} else {
				x.setFunds(x.getFunds() + transAmount);
				tempTrans.setFunds(tempTrans.getFunds() - transAmount);
				x.updateFile();
				tempTrans.updateFile();

				System.out.println("New Balance for '" + x.getUsername() + "'...." + x.getFunds());
				System.out.println("New Balance for '" + tempTrans.getUsername() + "'...." + tempTrans.getFunds());

			}
			break;
		case 2:
			if (transAmount > x.getFunds()) {
				System.out.println("Insufficient Balance to complete transfer.");
				transferFunds(x);
			} else {
				tempTrans.setFunds(tempTrans.getFunds() + transAmount);
				x.setFunds(x.getFunds() - transAmount);
				x.updateFile();
				tempTrans.updateFile();

				System.out.println("New Balance for '" + x.getUsername() + "'...." + x.getFunds());
				System.out.println("New Balance for '" + tempTrans.getUsername() + "'...." + tempTrans.getFunds());
				Loggy.info("Money transfered by Admin! From: "+ x.getUsername() );
			}
			break;
		case 3:
			adminPrompt();
			break;
		default:
			System.out.println("Invalid Selection Made.");
			MainDriver.promptContinue();
			transferFunds(x);

		}

	}

	public void delete(Customer x) {

		ArrayList<Customer> custList = MainDriver.readCustomers();
		ArrayList<Customer> delList = custList;
		for (int i = 0; i < custList.size() - 1; i++) {
			if (custList.get(i).getUsername().contentEquals(x.getUsername())) {

				delList.remove(i);
				String fileName = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/applications/customers.ser";

				try {
					FileOutputStream fop = new FileOutputStream(fileName);
					@SuppressWarnings("resource")
					ObjectOutputStream oos = new ObjectOutputStream(fop);

					oos.writeObject(delList);
					oos.close();
					fop.close();

				} catch (IOException ex) {
					System.out.println("IOException is caught - Admin.delete(Customer x)");
				}

			}
		}

	}

	public void delete(Employee x) {

		ArrayList<Employee> empList = readEmployees();
		ArrayList<Employee> delList = empList;
		for (int i = 0; i < empList.size() - 1; i++) {
			if (empList.get(i).getUsername().contentEquals(x.getUsername())) {

				delList.remove(i);
				String fileName = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/employees/employees.ser";

				try {
					FileOutputStream fop = new FileOutputStream(fileName);
					@SuppressWarnings("resource")
					ObjectOutputStream oos = new ObjectOutputStream(fop);

					oos.writeObject(delList);
					oos.close();
					fop.close();

				} catch (IOException ex) {
					System.out.println("IOException is caught - Admin.delete(Customer x)");
				}

			}
		}

	}

	public static ArrayList<Employee> readEmployees() { 
		String fileName = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/employees/employees.ser";
		// thi
		ArrayList<Employee> empCred = null;
		try {

			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(file);

			empCred = (ArrayList<Employee>) in.readObject();

			in.close();
			file.close();

		} catch (IOException ex) {
			System.err.println("Failed Fetching Customer list in employees()");
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		}
		return empCred;

	}

	public void employeeOptions() {

		ArrayList<Employee> empList = readEmployees();
		int count = 1;
		for (Employee n : empList) {
			System.out.println("[" + count + "]" + n.toString());
			count++;
		}
		if (empList.size() == 1) {
			System.out.println("[1] Employee Account");
			Employee tempy = empList.get(0);
			MainDriver.promptContinue();
		} else {
			System.out.println("Which account would you like to view?[1-" + count + "]");
			Scanner scan = new Scanner(System.in);
			int input = scan.nextInt();
			Employee tempy = empList.get(input - 1);
			System.out.println(tempy.toString()); 
			System.out.println("What would you like to do?");
			System.out.println("[1] \tEdit Employment");
			System.out.println("[2] \tDelete Account.");
			System.out.println("[3] \tReturn");
			System.out.println("Please make selection: [1-3]");
			int selection = scan.nextInt();

			switch (selection) {
			case 1:
				promoteDemote(tempy);

				break;
			case 2:
				System.out.println("Employee " + tempy.getName() + " has been fired. You're fired!");
				delete(tempy);
				break;
			case 3:
				break;

			}

		}

	}

	public void promoteDemote(Employee x) {
		Scanner scan = new Scanner(System.in);
	
		System.out.println("[1]Promote");
		System.out.println("[2]Demote");
		System.out.println("[3]Fire");
		System.out.println("[4]Return");
		System.out.println("Please make a selection: [1-4]");
		int y = scan.nextInt();

		while(y!=4) {
			switch (y) {
			case 1:
				x.setSalary(x.getSalary() + 5000);
				System.out.println("$5000 raise! Congratulations !");
				System.out.println("New Salary: " + x.getSalary());
				Loggy.info("Employee has been promoted");
				promoteDemote(x);
				break;
			case 2:
				if ((x.getSalary() - 5000) < 35000) {
					System.out.println("Error. Associate minimum Salary is $35000.");
					return;
				}
				x.setSalary(x.getSalary() - 5000);
				System.out.println("$5000 pay deduction! Too bad !");
				System.out.println("New Salary: " + x.getSalary());
				Loggy.info("Employee has been demoted");
				
				promoteDemote(x);
				break;
			case 3:
				System.out.println("Employee " + x.getName() + " has been fired. You're fired!");
				delete(x);
				return;
			case 4:
				break;
			default:
				System.out.println("Invalid selection.");
				promoteDemote(x);
			
			}

		}
		x.writeEmployee();
	}

}
