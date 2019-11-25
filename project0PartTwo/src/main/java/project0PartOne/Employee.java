package project0PartOne;

import java.util.Random;

public class Employee {
	////////////////////////////////////////////////////////// EMPLOYEE
	Random rand = new Random();
	////////////////////////////////////////////////////////// ATTRIBUTES/////////////////////////////////////////////////////////
	private int employeeID; // employee's Identification number
	private String employeeFirstName;// employee's first name
	private String employeeLastName; // employee's last name
	private String employeeUsername = "admin";// employee's user name
	private String employeePassword = "admin";// employee's Password

	/////////////////////////////////////////////////////////////// CONSTRUCTORS//////////////////////////////////////////////////////////
	public Employee() {
		
	}

	

	public Employee(int employeeID, String employeeFirstName, String employeeLastName, String employeeUsername,
			String employeePassword) {
		super();
		this.employeeID = employeeID;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.employeeUsername = employeeUsername;
		this.employeePassword = employeePassword;
	}



	/////////////////////////////////////////////////////////////// GETTERS AND
	/////////////////////////////////////////////////////////////// SETTERS///////////////////////////////////////////////////
	public String getEmployeeFirstName() {// <--------------------this method retrieves the employee's first name when
											// called
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {// this method sets the employee's first name when
																// called
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeLastName() {// <--------------------this method retrieves the employee's last name when
											// called
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {// this method sets the employee's last name when called
		this.employeeLastName = employeeLastName;
	}

	public int getEmployeeID() {// <----------------------------this method retrieves the employee's ID number
								// when called
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {// <---------------this method sets the employee's ID number when called
		this.employeeID = employeeID;
	}

	public String getEmployeeUsername() {// <---------------------this method retrieves the employee's user name when
											// called
		return employeeUsername;
	}

	public void setEmployeeUsername(String employeeUsername) {// --this method sets the employee's user name when called
		this.employeeUsername = employeeUsername;
	}

	public String getEmployeePassword() {// <--------------------this method retrieves the employee's password when
											// called
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {// --this method sets the employee's password when called
		this.employeePassword = employeePassword;
	}



	@Override
	public String toString() {
		return "Employee Employee ID: " + employeeID + ", Employee First Name: " + employeeFirstName + ", Employee Last Name: "
				+ employeeLastName + ", Employee Username: " + employeeUsername + ", Employee Password: " + employeePassword;
	}

	/////////////////////////////////////////////////////////////// toSTRING-METHOD///////////////////////////////////////////////////
	
}
