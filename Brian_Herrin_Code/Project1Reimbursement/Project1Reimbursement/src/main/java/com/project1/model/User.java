package com.project1.model;

public class User {
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private int isManager;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIsManager() {
		return isManager;
	}
	public void setIsManager(int isManager) {
		if(isManager > 1) {
			isManager = 1;
		} else if(isManager < 0) {
			isManager = 0;
		} else {
			isManager = 0;
		}
		this.isManager = isManager;
	}
}
