package com.project0;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7497019669544851685L;
	//declare private employee variables
	private String user= "leroy";
	private String password="leroy";
	private String fName;
	private String lName;
	private int employeeId;
	
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
	
	//This method retrieves employee first name
	public String getfName() {
		return fName;
	}
	//This method retrieves employee last name
	public String getlName() {
		return lName;
	}
	
	//This method retrieves employee id
	public int getEmployeeId() {
		return employeeId;
		
	}
	
	
	//This method set the employee user name
	public void setUser(String user) {
		this.user = user;
	}
	//This method set the employee password
	public void setPassword(String password) {
		this.password = password;
	}
	//This method set the employee first name
	public void setfName(String fName) {
		this.fName = fName;
	}
	//This method set the employee last name
	public void setlName(String lName) {
		this.lName = lName;
	}
	//This method set the employee id
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
