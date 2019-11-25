package com.project0;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Administrater {
	
	private static final long serialVersionUID = 7497019669544851685L;
	//declare private employee variables
	private String user;
	private String password;
	
	
	Scanner input = new Scanner(System.in);
	
	
	
	//create getters
	//-----------------------------------------------------------------
	//This method retrieves employee user
	
	public String getUser() {
		return user;
	}
	//This method retrieves employee password
	public String getPassword() {
		return password;
	}
	//This method set the employee user name
	public void setUser(String user) {
		this.user = user;
	}
	//This method set the employee password
	public void setPassword(String password) {
		this.password = password;
	}
	
}
	
	
