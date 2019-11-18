package com.project0.bankapp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Serializable{
	
	/**
	 * javadocs
	 * @author Cristian Adon
	 * @param into my methods
	 * 
	 */
	private static final long serialVersionUID = -5482689122859395780L;
	//private variables for employee
	
	private String emplFname;
	private String emplLname;
	private String emplUserName ="admin";
	private String emplPassword="password";
	private int emplID;
	
	//constructor
	public Employee() {
		super();
	}

	
	//Employee getters
	public String getEmplFname() {
		return emplFname;
	}
	//getting employee last name
	public String getEmplLname() {
		return emplLname;
	}
	//getting employee user name
	public String getEmplUserName() {
		return emplUserName;
	}
	//getting employee pass
	public String getEmplPassword() {
		return emplPassword;
	}
	//getting employee ID
	public int getEmplID() {
		return emplID;
	}

	
	//Employee setters
	public void setEmplFname(String emplFname) {
		this.emplFname = emplFname;
	}
	//setting employee last name		
	public void setEmplLname(String emplLname) {
		this.emplLname = emplLname;
	}
	// setting employee user name
	public void setEmplUserName(String emplUserName) {
		this.emplUserName = emplUserName;
	}
	// setting employee pass
	public void setEmplPassword(String emplPassword) {
		this.emplPassword = emplPassword;
	}
	//setting employee ID
	public void setEmplID(int emplID) {
		this.emplID = emplID;
	}
	
	// write method for employee
		public static void writeEmplObject(String filename, Object obj) {
			
			try(ObjectOutputStream emploos = new ObjectOutputStream(new FileOutputStream(filename))){
				emploos.writeObject(obj);
				
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
			
		}// end write method
		
		//read method for employee
		public static void readEmplObject(String filename) {
			
			try(ObjectInputStream emplois = new ObjectInputStream(new FileInputStream(filename))){
				System.out.println(emplois.readObject());
				
			}catch(IOException exception) {
				exception.printStackTrace();
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		}// end read method  
	

}
