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

public class Admin {

	final static Logger Loggy = Logger.getLogger(Admin.class);
	private String username;
	private String password;

	public Admin() {

	}

	public Admin(String x, String y) {

		this.username = x;
		this.password = y;

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

	public static void viewApplications() {

		ArrayList<Customer> custList = null;
		custList = MainDriver.cDAO.selectAllCustomers();

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
				MainDriver.promptContinue();
				break;
			case 2:
				Customer temp1 = openApplications.get(input - 1);
				denyApplication(temp1);
				MainDriver.promptContinue();
			}
		}

	}

	public static void viewJApplications() {

		ArrayList<Customer> custCred = null;

		custCred = MainDriver.cDAO.selectAllCustomers();

		ArrayList<Customer> openApplications = new ArrayList<Customer>();

		int count = 1;
		for (Customer temp : custCred) {
			if (temp.jointStatus == jStatus.PENDING) {

				openApplications.add(temp);
				System.out.println(count + "---" + temp.toString());
				count++;
			}
		}

		Scanner scanMan = new Scanner(System.in);
		if (openApplications.size() == 0) {
			System.out.println("No pending joint applications.");
			return;
		} else if (openApplications.size() == 1) {
			System.out.println("One current application:");
		} else {
			System.out.println(
					"[1-" + (count - 1) + "] - Which application would you like to view?" + "[1-" + (count - 1) + "]");
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
			approveJointApplication(temp1);
			break;
		case 2:
			Customer temp = openApplications.get(input - 1);
			denyJointApplication(temp);
			break;
		default:
			System.out.println("Invalid Selection.");

			break;
		}

	}

	public static void viewInfo() {
		ArrayList<Customer> custCred = null;
		custCred = MainDriver.cDAO.selectAllCustomers();

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
				System.out.println("[" + count +"]" + " " + temp.toString());
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
			denyApprove(temp);
			MainDriver.promptContinue();
			money(temp); // Actual money menu

			break;
		case 2:
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
		System.out.println("Account Approved.");
		Loggy.info("Approved Application");
		MainDriver.cDAO.updateCustomer(x);

	}

	public static void denyApplication(Customer x) {

		x.setStatus(Status.DENIED);
		System.out.println("Account Denied.");
		Loggy.info("Denied Application");
		MainDriver.cDAO.updateCustomer(x);

	}

	public static void approveJointApplication(Customer x) {

		String User = x.JointAppDetails[0];
		String PW = x.JointAppDetails[1];

		ArrayList<Customer> custCred = null;
		custCred = MainDriver.cDAO.selectAllCustomers();

		Customer z = MainDriver.cDAO.selectByID(x.getjBankID());
		z.setjBankID(x.getBankID());
		z.jointStatus = jStatus.APPROVED;
		x.jointStatus = jStatus.APPROVED;

		MainDriver.cDAO.updateCustomer(z);
		MainDriver.cDAO.updateCustomer(x);
		System.out.println("Joint Application Approved.");
		Loggy.info("Joint Account has been approved.");
	}

	public static void denyJointApplication(Customer x) {

		x.jointStatus = jStatus.DENIED;
		System.out.println("Application denied.");

		ArrayList<Customer> custCred = null;
		custCred = MainDriver.cDAO.selectAllCustomers();

		Customer z = MainDriver.cDAO.selectByID(x.getBankID());
		z.setJointStatus(jStatus.DENIED);
		x.setJointStatus(jStatus.DENIED);
		x.JointAppDetails[0] = null;
		x.JointAppDetails[1] = null;
		x.setjBankID(0);
		z.setjBankID(0);

		MainDriver.cDAO.updateCustomer(z);
		MainDriver.cDAO.updateCustomer(x);

		Loggy.info("JointAccount has been denied!!");

	}

	public void loseJointApplication(Customer x) {

		x.jointStatus = jStatus.LOST_IN_BEUROCRACY;
		System.out.println("Application Lost. Whoopsie!");
		MainDriver.cDAO.updateCustomer(x);

	}

	public static void adminPrompt() {

		System.out.println("What would you like to do?");
		System.out.println("[1] \tView Customer Accounts");
		System.out.println("[2] \tView Employee Accounts");
		System.out.println("[3] \tView Open Account Applications");
		System.out.println("[4] \tView Open Joint Applications");
		System.out.println("[5] \tLogout");
		System.out.println("Please make a selection.[1-6]");
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();

		switch (input) {
		case 1:
			viewInfo();
			MainDriver.promptContinue();
			adminPrompt();
			break;
		case 2:
			employeeOptions();
			adminPrompt();
			break;
		case 3:
			viewApplications();
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

	public static void money(Customer x) {
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
			x.setFunds((deposit + x.getFunds()));
			System.out.println("$" + deposit + " has been deposited to " + x.getUsername());
			System.out.println("New Balance....$" + x.getFunds());
			MainDriver.cDAO.updateCustomer(x);
			Loggy.info("Admin has deposited.");
			break;
		case 2:
			System.out.println("How much would you like to withdraw?");
			double withdraw = scan.nextDouble();
			if (x.getFunds() >= withdraw) {
				x.setFunds(x.getFunds() - withdraw);
				System.out.println("Dispensing $" + withdraw + ".");
				System.out.println("New Balance....$" + x.getFunds());
				MainDriver.cDAO.updateCustomer(x);
				Loggy.info("Money withdrawn by Admin! From: " + x.getUsername());

			} else {
				System.out.println("Insufficient funds.");
				MainDriver.promptContinue();
				money(x);
			}
			break;
		case 3:
			transferFunds(x);
			Loggy.info("Money transfered by Admin! From: " + x.getUsername());
			MainDriver.promptContinue();
			adminPrompt();
			break;
		case 4:
			if(x.jointStatus == jStatus.APPROVED) { //Cascade delete by java ;)
				Customer temp = MainDriver.cDAO.selectByID(x.getjBankID());
				temp.setJointStatus(jStatus.NOT_JOINT);
				temp.setjBankID(0);
				temp.JointAppDetails[0] = null;
				temp.JointAppDetails[1] = null;
				MainDriver.cDAO.updateCustomer(temp);
			}
			MainDriver.cDAO.deleteCustomer(x);
			System.out.println("Customer " + x.getUsername() + " deleted.");
			Loggy.info("Account deleted by Admin! From: " + x.getUsername());
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

	public static void transferFunds(Customer x) {

		ArrayList<Customer> custList = null;
		custList = MainDriver.cDAO.selectAllCustomers();
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
				MainDriver.cDAO.updateCustomer(x);

				MainDriver.cDAO.updateCustomer(tempTrans);

				System.out.println("New Balance for '" + x.getUsername() + "'...." + x.getFunds());
				System.out.println("New Balance for '" + tempTrans.getUsername() + "'...." + tempTrans.getFunds());

			}
			break;
		case 2:
			if (transAmount > x.getFunds()) {
				System.out.println("Insufficient Balance to complete transfer.");
				MainDriver.promptContinue();
				transferFunds(x);
			} else {
				tempTrans.setFunds(tempTrans.getFunds() + transAmount);
				x.setFunds(x.getFunds() - transAmount);
				MainDriver.cDAO.updateCustomer(x);
				MainDriver.cDAO.updateCustomer(tempTrans);

				System.out.println("New Balance for '" + x.getUsername() + "'...." + x.getFunds());
				System.out.println("New Balance for '" + tempTrans.getUsername() + "'...." + tempTrans.getFunds());
				Loggy.info("Money transfered by Admin! From: " + x.getUsername());
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

	public static void delete(Employee x) {

		MainDriver.aDAO.deleteEmployee(x);
	}

	public static void employeeOptions() {

		ArrayList<Employee> empList = MainDriver.aDAO.selectAllEmployees();
		int count = 1;
		for (Employee n : empList) {
			System.out.println("[" + count + "]" + n.toString());
			count++;
		}
		if (empList.size() == 0) {
			System.out.println("No current employees!");
			adminPrompt();
		}
		else if( empList.size() == 0) {
			System.out.println("Which account would you like to view?[1]");
		}
		 else {
			System.out.println("Which account would you like to view?[1 - " + (count-1) + "]");
		}
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

	public static void promoteDemote(Employee x) {
		Scanner scan = new Scanner(System.in);

		System.out.println("[1]Promote");
		System.out.println("[2]Demote");
		System.out.println("[3]Fire");
		System.out.println("[4]Return");
		System.out.println("Please make a selection: [1-4]");
		int y = scan.nextInt();

		
			switch (y) {
			case 1:
				x.setSalary(x.getSalary() + 5000);
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
				MainDriver.aDAO.updateEmployee(x);
				adminPrompt();
				break;
			default:
				System.out.println("Invalid selection.");
				promoteDemote(x);

			}

		
		MainDriver.aDAO.updateEmployee(x);
	}

	public static void denyApprove(Customer x) {

		Scanner sc = new Scanner(System.in);
		if (x.appStatus.equals(Status.PENDING)) {
			System.out.println("------ Applications Pending! -------");
			System.out.println("[1]\tApprove Pending Application.");
			System.out.println("[2]\tDeny Application.");
			System.out.println("[3]\tContinue to menu.");
			int input1 = sc.nextInt();
			switch (input1) {
			case 1:

				approveApplication(x);
				MainDriver.cDAO.updateCustomer(x);
				Loggy.info("Account approved.");

				break;
			case 2:
				denyApplication(x);
				MainDriver.cDAO.updateCustomer(x);
				Loggy.info("Account denied.");
				break;
			case 3:
				break;
			default:
				System.out.println("None-input detected. Continuing to menu...");
				break;

			}
		} else if (x.jointStatus.equals(jStatus.PENDING)) {
			System.out.println("------ Applications Pending! -------");
			System.out.println("[1]\t Approve Pending Joint Application.");
			System.out.println("[2]\t Deny Deny Joint Application.");
			System.out.println("[3]\t Continue to menu.");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				approveJointApplication(x);
				break;
			case 2:
				denyJointApplication(x);
				break;
			case 3:
				break;
			default:
				System.out.println("Noninput detected. Continuing to menu..");
				return;
			}
		}

	}
}
