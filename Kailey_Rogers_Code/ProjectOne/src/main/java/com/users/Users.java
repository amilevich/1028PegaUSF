package com.users;

public abstract class Users {
	
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private int userID;
	private int userRole;
	
	public Users() {
		// TODO Auto-generated constructor stub
	}
	
	public Users(String firstName, String lastName, String userName, String password, String email, int userID,
			int userRole) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.userID = userID;
		this.userRole = userRole;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
	
	public abstract boolean userLogin();

	@Override
	public String toString() {
		return "Users [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password="
				+ password + ", email=" + email + ", userID=" + userID + ", userRole=" + userRole + "]";
	}
	
	

}
