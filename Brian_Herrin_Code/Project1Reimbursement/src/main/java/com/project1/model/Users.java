package com.project1.model;

public class Users {
	String name, password;
	int usersId;
	String firstName;
	String lastName;
	String email;
	int role;

	
	public Users() {
		
	}
	
	public Users(String name, String password) {
		
		this.name = name;
		this.password = password;
	}
	

	public Users(int usersId, String name, String password, String firstName, String lastName, String email, int role) {
		
		this.usersId = usersId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.name = name;
		this.password = password;
	}


	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
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

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [usersId=" + usersId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", role=" + role + ", name=" + name + ", password=" + password + "]";
	}

}