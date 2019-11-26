package com.project.pt1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Employee {
	private String username;
	private String password;
	public String name;
	public String Date;
	private double salary = 30000.00;
	public int id_num = 0;
	final static Logger Loggy = Logger.getLogger(Customer.class);

	Employee() {

	}

	public Employee(String x, String y) {
		this.username = x;
		this.password = y;
	}

	public Employee(String x, String y, String z, double d,int e) {
		this.username = x;
		this.password = y;
		this.name = z;
		this.salary = d;
		this.id_num = e;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
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

		ArrayList<Customer> custCred = null;

		custCred = MainDriver.cDAO.selectAllCustomers();
		ArrayList<Customer> openApplications = new ArrayList<Customer>();

		int count = 1;
		for (Customer temp : custCred) {
			if (temp.appStatus == Status.PENDING) {

				openApplications.add(temp);
				System.out.println("[" + count + "] - " + temp.toString());
				count++;
			}
		}
		if (openApplications.isEmpty()) {
			System.out.println("No Pending applications");
		} else if(openApplications.size() == 1){
			System.out.println("One Pending Application");
			MainDriver.promptContinue();
			System.out.println(openApplications.get(0).toString());
			System.out.println("[1]-Approve\n[2]-Deny\n[3]-Return");
			Scanner sc = new Scanner(System.in);

			int dec = sc.nextInt();
			switch (dec) {
			case 1:
				Customer temp = openApplications.get(0);
				approveApplication(temp);
				break;
			case 2:
				Customer temp1 = openApplications.get(0);
				denyApplication(temp1);
			case 3: employeePrompt();
			default:
				employeePrompt();
				break;
			}
		
			
		}
		else {
			System.out.println("Which application would you like to view? [1-" + count +"]");
			Scanner scanMan = new Scanner(System.in);
			System.out.println();
			int input = scanMan.nextInt();
			System.out.println(openApplications.get(input - 1).toString());
			System.out.println("[1]-Approve\n[2]-Deny\n[3]-Return");
			Scanner sc = new Scanner(System.in);
			int dec = sc.nextInt();

			switch (dec) {
			case 1:
				Customer temp = openApplications.get(input - 1);
				approveApplication(temp);
				break;
			case 2:
				Customer temp1 = openApplications.get(input - 1);
				denyApplication(temp1);
			case 3: employeePrompt();
			break;
			default: employeePrompt();
			break;
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
				System.out.println("[" + count + "] - " + temp.toString());
				count++;
			}
		}

		Scanner scanMan = new Scanner(System.in);
		if (openApplications.isEmpty()) {
			System.out.println("No currently pending joint applications");
			return;
		} else if (openApplications.size() == 1) {
			System.out.println("One currently pending joint application.");
		} else {
			System.out.println(
					"[1-" + (count - 1) + "] - Which application would you like to view?" + "[1-" + (count - 1) + "]");
			System.out.println();
		}

		int input = scanMan.nextInt();
		Customer one = openApplications.get(input - 1);
		Customer two = MainDriver.cDAO.selectByID(one.getjBankID());
		System.out.println(openApplications.get(input - 1).toDetailedString());
		System.out.println("Applying for joint account with: ");
		System.out.println(two.toDetailedString());

		System.out.println("[1]-Approve  [2]-Deny");
		Scanner sc = new Scanner(System.in);

		int dec = sc.nextInt();

		switch (dec) {
		case 1:
			Customer temp1 = openApplications.get(input - 1);
			System.out.println("Account Approved.");
			approveApplication(temp1);
			break;
		case 2:
			Customer temp = openApplications.get(input - 1);
			denyApplication(temp);
			System.out.println("Account Denied.");
			break;
		}
	}

	public static void viewInfo() {

		ArrayList<Customer> custCred = MainDriver.cDAO.selectAllCustomers();

		for (Customer temp : custCred) {
			System.out.println(temp.toString());

		}
		System.out.println("What would you like to do?");
		System.out.println("[1] - View Additional Details");
		System.out.println("[2] - Return to Main Menu");

		Scanner sc = new Scanner(System.in);
		ArrayList<Customer> detList = new ArrayList<Customer>();
		int input = sc.nextInt();

		switch (input) {
		case 1:

			int count = 1;
			for (Customer temp : custCred) {

				detList.add(temp);
				System.out.println("["+count + "] - " + temp.toString());
				count++;

			}
			if (count == 1) {
				System.out.println("For which Customer would you like to view additional details? [1]");
			} else {
				System.out.println("For which Customer would you like to view additional details? [1-" + (count - 1) + "]");
			}

			int input1 = sc.nextInt();
			Customer tempy = detList.get(input1 - 1);
			System.out.println(tempy.toDetailedString());
			System.out.println("");
			denyApprove(tempy);
			
			break;
		case 2:
			employeePrompt();
			break;
		default:
			System.out.println("Invalid Selection made. Returning to menu..");
			employeePrompt();
			break;

		}
		//employeePrompt();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void approveApplication(Customer x) {

		x.setStatus(Status.APPROVED);
		MainDriver.cDAO.updateCustomer(x);
		System.out.println("Account Approved.");
		Loggy.info("Account has been approved.");

	}

	public static void denyApplication(Customer x) {

		x.setStatus(Status.DENIED);
		MainDriver.cDAO.updateCustomer(x);
		System.out.println("Account Denied.");
		Loggy.info("Account has been denied.");

	}

	public static void approveJointApplication(Customer x) {

		String User = x.JointAppDetails[0];
		String PW = x.JointAppDetails[1];

		String fileName = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/applications/customers.ser";
		ArrayList<Customer> custCred = null;
		custCred = MainDriver.cDAO.selectAllCustomers();

		Customer z = MainDriver.cDAO.selectByID(x.getjBankID());
		z.setjBankID(x.getBankID());
		z.jointStatus = jStatus.APPROVED;
		x.jointStatus = jStatus.APPROVED;

		MainDriver.cDAO.updateCustomer(z);
		MainDriver.cDAO.updateCustomer(x);
		System.out.println("Application Approved.");
		Loggy.info("JointAccount has been approved.");
	}

	public static void denyJointApplication(Customer x) {

		x.jointStatus = jStatus.DENIED;
		System.out.println("Application denied.");

		ArrayList<Customer> custCred = null;

		Customer z = MainDriver.cDAO.selectByID(x.getBankID());
		z.setJointStatus(jStatus.DENIED);
		x.setJointStatus(jStatus.DENIED);
		x.JointAppDetails[0] = null;
		x.JointAppDetails[1] = null;
		x.setjBankID(0);
		z.setjBankID(0);

		MainDriver.cDAO.updateCustomer(z);
		MainDriver.cDAO.updateCustomer(x);
		Loggy.info("Joint Account has been denied!!");

	}

	public static void loseJointApplication(Customer x) {

		x.jointStatus = jStatus.LOST_IN_BEUROCRACY;
		System.out.println("Application Lost. Whoopsie!");
		MainDriver.cDAO.updateCustomer(x);
	}

	public static void employeePrompt() {
		Scanner scan = new Scanner(System.in);

		System.out.println("What would you like to do?");
		System.out.println("[1]\t View Customer Accounts");
		System.out.println("[2]\t View Pending Applications");
		System.out.println("[3]\t View Pending Joint Applications");
		System.out.println("[4]\t Quit");
		System.out.println("Please make a selection.[1-4]");

		int input = scan.nextInt();

		switch (input) {
		case 1:
			viewInfo();
			MainDriver.promptContinue();
			employeePrompt();
			break;
		case 2:
			viewApplications();
			MainDriver.promptContinue();
			employeePrompt();
			break;
		case 3:
			viewJApplications();
			MainDriver.promptContinue();
			employeePrompt();
			break;
		case 4:
			System.out.println("Thank you for working with Atlas. Goodbye!");
			MainDriver.promptContinue();
			MainDriver.prompt();
			break;

		}
	}

	public String toString() {
		String str = "Employee Name: [" + this.name + "] Salary: [" + this.getSalary() + "]";
		return str;

	}

	public static void denyApprove(Customer x) {

		Scanner sc = new Scanner(System.in);
		if (x.appStatus.equals(Status.PENDING)) {
			System.out.println("------ Applications Pending! -------");
			System.out.println("[1]Approve Account Application.");
			System.out.println("[2]Deny Account Application.");
			System.out.println("[3]Continue to menu.");
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
				break;
			case 3://System.out.println(x.toDetailedString());
				break;
			default:
				System.out.println("None input detected.");
				break;

			}
		} else if (x.jointStatus.equals(jStatus.PENDING)) {
			System.out.println("------ Applications Pending! -------");
			System.out.println("[1]\t Approve Pending Joint Application.");
			System.out.println("[2]\t Deny Joint Application.");
			System.out.println("[3]\t Continue to menu.");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				approveJointApplication(x);
				break;
			case 2:
				denyJointApplication(x);
				break;
			case 3:System.out.println(x.toDetailedString());
				break;
			default:
				//System.out.println("Noninput detected. Continuing to menu...");
				break;
			}
		}

	}
}
