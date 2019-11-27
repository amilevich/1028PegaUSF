package com.admin;

public class Admin {
	
	private String adminFname;
	private String adminLname;
	private String adminUserName ="admin";
	private String adminPassword="password";
	private int adminID;
	
	public Admin() {
		super();
		
	}

	//admin getters
	public String getAdminFname() {
		return adminFname;
	}

	public void setAdminFname(String adminFname) {
		this.adminFname = adminFname;
	}

	public String getAdminLname() {
		return adminLname;
	}

	public void setAdminLname(String adminLname) {
		this.adminLname = adminLname;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	//admin setters
	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
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

	//constructor
	public Admin(String adminFname, String adminLname, String adminUserName, String adminPassword, int adminID) {
		super();
		this.adminFname = adminFname;
		this.adminLname = adminLname;
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
		this.adminID = adminID;
	}// end constructor

	@Override
	public String toString() {
		return "Admin [adminFname=" + adminFname + ", adminLname=" + adminLname + ", adminUserName=" + adminUserName
				+ ", adminPassword=" + adminPassword + ", adminID=" + adminID + "]";
	}
	
	

}// end admin
