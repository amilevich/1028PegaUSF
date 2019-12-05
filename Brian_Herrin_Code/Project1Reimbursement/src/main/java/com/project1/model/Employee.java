package com.project1.model;

public class Employee extends User {
	public Employee(){
		setIsManager(0);
	}
	public Employee(String newUserName, String newPassword, String newFirstName, String newLastName, String newEmail){
		setUserName(newUserName);
		setPassword(newPassword);
		setFirstName(newFirstName);
		setLastName(newLastName);
		setEmail(newEmail);
		setIsManager(0);
	}
}
