package com.employee;

import java.util.Random;

    public class Employee {
	Random generator = new Random();
	private String emplFname;
	private String emplLname;
	private String emplUserName ="admin";
	private String emplPassword="password";
	private int emplID =  generator.nextInt(300);
	
	//constructor 
	public Employee() {
		super();
	}

	// getters 
	public String getEmplFname() {
		return emplFname;
	}

	public String getEmplLname() {
		return emplLname;
	}

	public String getEmplUserName() {
		return emplUserName;
	}

	public String getEmplPassword() {
		return emplPassword;
	}

	public int getEmplID() {
		return emplID;
	}
	

	public Random getGenerator() {
		return generator;
	}

	public void setGenerator(Random generator) {
		this.generator = generator;
	}

	

	//setters
	public void setEmplFname(String emplFname) {
		this.emplFname = emplFname;
	}

	public void setEmplLname(String emplLname) {
		this.emplLname = emplLname;
	}

	public void setEmplUserName(String emplUserName) {
		this.emplUserName = emplUserName;
	}

	public void setEmplPassword(String emplPassword) {
		this.emplPassword = emplPassword;
	}

	public void setEmplID(int emplID) {
		this.emplID = emplID;
	}

	@Override
	public String toString() {
		return "Employee [emplFname=" + emplFname + ", emplLname=" + emplLname + ", emplUserName=" + emplUserName
				+ ", emplPassword=" + emplPassword + ", emplID=" + emplID + "]";
	}

	public Employee(String emplFname, String emplLname, String emplUserName, String emplPassword, int emplID) {
		super();
		this.emplFname = emplFname;
		this.emplLname = emplLname;
		this.emplUserName = emplUserName;
		this.emplPassword = emplPassword;
		this.emplID = emplID;
	}
	
	

	
	
}// end employee
