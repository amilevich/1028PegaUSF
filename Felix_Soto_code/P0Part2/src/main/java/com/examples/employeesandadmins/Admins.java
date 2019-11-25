package com.examples.employeesandadmins;

import java.util.Random;

    public class Admins {
	Random generator = new Random();
	private String empFirstName;
	private String empLastName;
	private String empUsername ="employee";
	private String empPassword="employeepass";
	private int empID =  generator.nextInt(300);
	 
	public Admins() {
		super();
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public String getEmpUsername() {
		return empUsername;
	}

	public void setEmpUsername(String empUsername) {
		this.empUsername = empUsername;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	@Override
	public String toString() {
		return "Employee empFirstName=" + empFirstName + ", empLastName=" + empLastName
				+ ", empUsername=" + empUsername + ", empPassword=" + empPassword + ", empID=" + empID + "]";
	}

	public Admins(String empFirstName, String empLastName, String empUsername, String empPassword,
			int empID) {
		super();
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empUsername = empUsername;
		this.empPassword = empPassword;
		this.empID = empID;
	}	
}