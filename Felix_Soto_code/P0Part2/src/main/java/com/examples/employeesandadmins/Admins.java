package com.examples.employeesandadmins;

import java.util.Random;

    public class Admins {
	Random generator = new Random();
	private String adminFirstName;
	private String adminLastName;
	private String adminUsername ="admin";
	private String adminPassword="adminpass";
	private int adminID =  generator.nextInt(200);
	 
	public Admins() {
		super();
	}

	public String getAdminFirstName() {
		return adminFirstName;
	}

	public void setAdminFirstName(String adminFirstName) {
		this.adminFirstName = adminFirstName;
	}

	public String getAdminLastName() {
		return adminLastName;
	}

	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	@Override
	public String toString() {
		return "Admin adminFirstName=" + adminFirstName + ", adminLastName=" + adminLastName
				+ ", adminUsername=" + adminUsername + ", adminPassword=" + adminPassword + ", adminID=" + adminID + "]";
	}

	public Admins(String adminFirstName, String adminLastName, String adminUsername, String adminPassword,
			int adminID) {
		super();
		this.adminFirstName = adminFirstName;
		this.adminLastName = adminLastName;
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
		this.adminID = adminID;
	}	
}