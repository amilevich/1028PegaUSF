package com.projectzerobankapppartone;

import java.util.Scanner;



public class Employee {
	
//////////////////////variables/////////////////////
	private String name;
	private String lName;
	private String username = "employee";
	private String password = "password";
	private int empID;
	static Scanner input = new Scanner(System.in);
	static Employee emp = new Employee();
	
//////////////////////Constructor/////////////////////
	public Employee() {
		super();
	}
	
//////////////////////Getters/////////////////////
	//this method retrieves the employees first name
	public String getName() {
		return name;
	}
	//this method retrieves the employees first lastname
	public String getlName() {
		return lName;
	}
	//this method retrieves the employees username
	public String getUsername() {
		return username;
	}
	//this method retrieves the employees password
	public String getPassword() {
		return password;
	}
	//this method retrieves the employees ID
	public int getEmpID() {
		return empID;
	}
//////////////////////Setters/////////////////////
	//this method sets the employees first name
	public void setName(String name) {
		this.name = name;
	}
	//this method sets the employees last name
	public void setlName(String lName) {
		this.lName = lName;
	}
	//this method sets the employees user name
	public void setUsername(String username) {
		this.username = username;
	}
	//this method sets the employees password
	public void setPassword(String password) {
		this.password = password;
	}
	//this method sets the employees ID
	public void setEmpID(int empID) {
		this.empID = empID;
	}
//////////////////////Menu/////////////////////
	public static void employeeMenu() {
		System.out.println(" Choose an option: ");
		System.out.println(" 'a' : View Customers ");
		System.out.println(" 'b' : Approve an account ");
		System.out.println(" 'c' : Deny an account");
		System.out.println(" 'd' : Go Back");
		System.out.println(" 'q' : Quit");
		System.out.print(" Enter option here: ");
		char option;
		String input2;
		do {
			input2 = input.next();
			option = input2.charAt(0);
			switch (option) {
			case 'a':
				// view Customers
				for (Customer ct : Account.pendingCustomers) {
					System.out.println(ct);
				}
				break;
			case 'b':
				// approve method
				Administrator.approveOrDeny();
				break;
			case 'c':
				// deny method
				Administrator.approveOrDeny();
				break;
			case 'd':
				// Main Menu
				Customer.writeObject(Account.filename, Account.pendingCustomers);
				employeeMenu();
				break;
			case 'q':
				// quits the program
				Account.bankMenu();
				break;
			default:
				System.out.println("You entered the wrong option");
			}
		} while (option != 'q');
	}
//////////////////////Employee Sign In/////////////////////
	public static void EmployeeSign() {
		System.out.println("Enter Employee username:  ");
		String tempUser = input.next();
		// emp.setUser(input.next(tempUser));
		emp.getUsername();

		System.out.println("Enter Employee password:  ");
		String temPass = input.next();
		emp.setPassword(temPass);
		emp.getPassword();
		if (tempUser.equals("employee") && temPass.equals("password")) {
			Employee.employeeMenu();
		} else {
			System.out.println("Employee user and password are incorect");
		}
		// Employee menu asking Employee to choose
	}
//////////////////////toString/////////////////////
//////////////////////toString/////////////////////
//////////////////////toString/////////////////////
//////////////////////toString/////////////////////
//////////////////////toString/////////////////////
//////////////////////toString/////////////////////
//////////////////////toString/////////////////////
}
