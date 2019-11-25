package com.project0;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Employee implements Serializable {
	
	
	 Scanner input = new Scanner(System.in);
	
	private static final long serialVersionUID = 7497019669544851685L;
	//declare private employee variables
	private String user;
	private String password;
	
	
//	public void employeeSign() {
//		
//		System.out.println("Enter Employee id:  ");
//		String tempUser = input.next();
//	
//		
//		 setUser(input.next(tempUser));
//		 getUser();
//
//		System.out.println("Enter Employee password:  ");
//		String temPass = input.next();
//		setPassword(temPass);
//		getPassword();
//		if (tempUser.equals("thor") && temPass.equals("thor")) {
//			employeeSign();
//		} else {
//			System.out.println("Employee user and password are incorect");
//		}
//
//		// Employee menu asking Employee to choose
//
//	}
//	
	//Create a constructor
	public Employee() {
		super();
	}
	
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
	
	
	//creating method that read and write file
		public static void writeEmployee(String name, Object object) {
			try(ObjectOutputStream employee =new ObjectOutputStream(new FileOutputStream(name))){
				employee.writeObject(object);
			}catch(IOException e) {
				e.printStackTrace();
			}
				
			
		}
		//Creating Method that read from to the file
		public static void readEmployee1(String name) {
			try(ObjectInputStream employee1 =new ObjectInputStream(new FileInputStream(name))){
				employee1.readObject();
			}catch(IOException e) {
				e.printStackTrace();
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
	
	
	
	
		}
}
