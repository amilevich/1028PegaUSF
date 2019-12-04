package com.example.model;

import java.util.Random;

public class Users {

	Random generator = new Random();
	private int userID= generator.nextInt(1000);
	private String username;
	private String password;
	private String userFname;
	private String userLname;
	private String userEmail;
	private int userRoleID= generator.nextInt(1000);

	public Users() {
		
	}

	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
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


	public String getUserFname() {
		return userFname;
	}


	public void setUserFname(String userFname) {
		this.userFname = userFname;
	}


	public String getUserLname() {
		return userLname;
	}


	public void setUserLname(String userLname) {
		this.userLname = userLname;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public int getUserRoleID() {
		return userRoleID;
	}


	public void setUserRoleID(int userRoleID) {
		this.userRoleID = userRoleID;
	}

	@Override
	public String toString() {
		return "Users [userID=" + userID + ", username=" + username + ", password="
				+ password + ", userFname=" + userFname + ", userLname=" + userLname + ", userEmail=" + userEmail
			    + ", userRoleID=" + userRoleID + "]";
	}

	public Users(int userID, String username, String password, String userFname, String userLname, String userEmail, int userRoleID) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.userFname = userFname;
		this.userLname = userLname;
		this.userEmail = userEmail;
		this.userRoleID = userRoleID;
	}
}