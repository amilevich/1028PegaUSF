package com.project1.model;

public class Employee extends User {
	public Employee(){
		super();
		setRoleId(2);
	}
	public Employee(String newUserName, String newPassword, String newFirstName, String newLastName, String newEmail){
		super();
		setUserName(newUserName);
		setPassword(newPassword);
		setFirstName(newFirstName);
		setLastName(newLastName);
		setEmail(newEmail);
		setRoleId(2);
	}
	public Employee(int int1, String string, String string2, String string3, String string4, String string5, int int2) {
		super();
		setUserId(int1);
		setUserName(string);
		setPassword(string2);
		setFirstName(string3);
		setLastName(string4);
		setEmail(string5);
		setRoleId(int2);
	}
}
