package com.example.classes;

import java.io.Serializable;

public class User implements Serializable{
		
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String userName;
	protected String password;
	 
	public User() {
		super();
	}	
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
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

	@Override
	public String toString() {
		return "User: " + userName;
	}
	 
	 
}
