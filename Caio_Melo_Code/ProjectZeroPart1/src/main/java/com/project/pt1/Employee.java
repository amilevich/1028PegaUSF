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


public class Employee implements Serializable {
	private String username;
	private String password;
	public String name;
	public String Date;
	private double salary = 30000.00;
	final static Logger Loggy = Logger.getLogger(Customer.class);

	Employee() {

	}

	public Employee(String x, String y) {
		this.username = x;
		this.password = y;
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

		String fileName = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/applications/customers.ser"; 
																																			
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
				if (temp.appStatus == Status.PENDING) {

					openApplications.add(temp);
					System.out.println(count + "---" + temp.toString());
					count++;
				}
			}
			if(openApplications.isEmpty()) {
				System.out.println("No Pending applications");
			}
			else {

			Scanner scanMan = new Scanner(System.in);
			System.out.println("Which application would you like to view?");
			System.out.println();

			int input = scanMan.nextInt();

			System.out.println(openApplications.get(input-1).toString());
			System.out.println("[1]-Approve  [2]-Deny");
			Scanner sc = new Scanner(System.in);

			int dec = sc.nextInt();

			switch (dec) {
			case 1:
				Customer temp = openApplications.get(input-1);
				approveApplication(temp);
				break;
			case 2:
				Customer temp1 = openApplications.get(input-1);
				denyApplication(temp1);
			}
			}
		} catch (IOException ex) {
			System.out.println("No user found by the name:  ");
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		}

	}
	
	public static void viewJApplications() {

		String fileName = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/applications/customers.ser"; // hoooly
																																			
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
				if (temp.jointStatus ==jStatus.PENDING) {

					openApplications.add(temp);
					System.out.println(count + "---" + temp.toString());
					count++;
				}
			}

			Scanner scanMan = new Scanner(System.in);
			if(openApplications.isEmpty()) {
				System.out.println("No currently pending joint applications");
				return;
			}
			else if(openApplications.size() == 1) {
				System.out.println("One current application:");
			}
			else {
			System.out.println("[1-" + (count - 1) + "] - Which application would you like to view?" + "[1-" + (count - 1) + "]");
			System.out.println();
			}

			int input = scanMan.nextInt();

			System.out.println(openApplications.get(input-1).toString());
			System.out.println("[1]-Approve  [2]-Deny");
			Scanner sc = new Scanner(System.in);

			int dec = sc.nextInt();

			switch (dec) {
			case 1:
				Customer temp1 = openApplications.get(input-1);
				System.out.println("Account Approved.");
				temp1.updateFile();
				break;
			case 2:
				Customer temp = openApplications.get(input-1);
				denyApplication(temp);
				temp.updateFile();
				System.out.println("Account Denied.");
				break;
			}
		} catch (IOException ex) {
			System.out.println("No user found by the name:  ");
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		}

	}

	public static void viewInfo() { 

		String fileName = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/applications/customers.ser";

		ArrayList<Customer> custCred = null;
		try {

			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(file);

			custCred = (ArrayList<Customer>) in.readObject();

			in.close();
			file.close();


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
						System.out.println(count + "---" + temp.toString());
						count++;
					
				}
				if(count == 1) {
					System.out.println("For which Customer would you like to view additional details? [1]");
				}
				else {
				System.out.println("For which Customer would you like to view additional details? [1-" + (count-1) + "]");
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
				System.out.println("Invalid Selection made. Returning to main menu..");
				employeePrompt();
				break;

			}

		}

		catch (IOException ex) {
			System.out.println("No user found by the name:  ");
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void approveApplication(Customer x) {

		x.setStatus(Status.APPROVED);
		x.updateFile();
		System.out.println("Account Approved.");
		Loggy.info("Account has been approved.");
	

	}

	public static void denyApplication(Customer x) {

		x.setStatus(Status.DENIED);
		x.updateFile();
		System.out.println("Account Denied.");
		Loggy.info("Account has been denied.");
	

	}
	public static void approveJointApplication(Customer x) {
		
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
			
		for(Customer z:custCred) {
			
			if(z.getUsername().contentEquals(User) && z.getPassword().contentEquals(PW)) {
				
				z.account.accountID = x.account.accountID;
				z.jointStatus = jStatus.APPROVED;
				z.updateFile();
				break;
			}
			
		}
		
		
		
		x.jointStatus = jStatus.APPROVED;
		System.out.println("Application Approved.");
		x.updateFile();
		Loggy.info("JointAccount has been approved.");
		}
		catch (IOException ex) {
			System.out.println("No user found by the name:  ");
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		}

	}

	public static void denyJointApplication(Customer x) {

		x.jointStatus = jStatus.DENIED;
		System.out.println("Application denied.");
		
		ArrayList<Customer> custCred = MainDriver.readCustomers();
		
		for(Customer z:custCred) {
			
			if(z.getUsername().contentEquals(x.JointAppDetails[0]) && z.getPassword().contentEquals(x.JointAppDetails[1])) {
				

				z.jointStatus = jStatus.DENIED;
				z.updateFile();
				break;
			}
			
		}
		x.updateFile();
		Loggy.info("JointAccount has been denied..");
		
	}
	public static void loseJointApplication(Customer x) {

		x.jointStatus = jStatus.LOST_IN_BEUROCRACY;
		System.out.println("Application Lost. Whoopsie!");
		x.updateFile();

	}

	public void writeEmployee() {
		String fileName = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/employees/employees.ser";
		
		ArrayList<Employee> empList = Admin.readEmployees();
		empList.add(this);
		
		
		
		try {

			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);

			
			out.writeObject(empList); 

			out.close();
			file.close();

			System.out.println("Employee account updated.");
		}

		catch (IOException ex) {
			System.out.println("IOException is caught - Employee Creation Error");
		}

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
			System.out.println("You have submitted your two weeks notice. Thank you for working with Atlas.");
			MainDriver.promptContinue();
			MainDriver.prompt();
			break;

		}
	}
	
	public String toString() {
		String str = "Employee Name: ["+this.name+"] Salary: [" + this.getSalary() + "]";
		return str;
		
		
	}
	public static void denyApprove(Customer x) {
		
		Scanner sc = new Scanner(System.in);
		if(x.appStatus.equals(Status.PENDING)) {
		System.out.println("[1]Approve Pending Application.");
		System.out.println("[2]Deny Deny Application.");
		System.out.println("[3]Return");
		int input1 = sc.nextInt();
		switch(input1) {
		case 1: 
			x.appStatus = Status.APPROVED;
			x.updateFile();
			System.out.println("Account Approved.");
			Loggy.info("Account approved.");
			
			break;
		case 2:
			x.appStatus = Status.DENIED;
			x.updateFile();
			System.out.println("Account Denied.");
		break;
		case 3: 
			return;
		default:
			System.out.println("None input detected. Returning to Main Menu.");
			return;

		}
		}
		else if(x.jointStatus.equals(jStatus.PENDING)) {
			System.out.println("[1]\t Approve Pending Joint Application.");
			System.out.println("[2]\t Deny Deny Joint Application.");
			System.out.println("[3]\t Return");
			int input = sc.nextInt();
			switch(input) {
			case 1: 
				x.appStatus = Status.APPROVED;
				x.updateFile();
				System.out.println("Account Approved.");
				
				break;
			case 2:
				x.appStatus = Status.APPROVED;
				x.updateFile();
				System.out.println("Account Approved.");
			break;
			case 3:return;	
			default:
				System.out.println("Noninput detected. Returning to Main Menu.");
				return;
			}
			}
			
	}
}
