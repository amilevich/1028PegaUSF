package com.projects.project0.businesslayer;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.projects.project0.User;
import com.projects.project0.businesslayer.AdminEmployee;
public class Customer extends User implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static Logger log = Logger.getLogger(Customer.class);
	//
	public Customer() {
		super("Debugman", "password");
		 
	}
	
	public Customer(String newUsernameC, String newPasswordC) {
		super(newUsernameC, newPasswordC);
		setId(AdminEmployee.useNextUserId());
		//getAssociates().add(this);
	}

	public Customer(String newUsernameC, String newPasswordC, String newFirstNameC, String newLastNameC) {
		super(newUsernameC, newPasswordC, newFirstNameC, newLastNameC);
		setId(AdminEmployee.useNextUserId());
		//getAssociates().add(this);
	}
	
	public Customer(Integer id, String newUsernameC, String newPasswordC, String newFirstNameC, String newLastNameC) {
		super(newUsernameC, newPasswordC, newFirstNameC, newLastNameC);
		setId(id);
		//getAssociates().add(this);
	}
	
	public void serializeDataBase(Customer c) {
		try {
			FileOutputStream fileOut = new FileOutputStream("src/main/java/com/projects/project0/dataBaseCustomer.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(c);
			out.close();
			fileOut.close();
			//System.out.println("");
      } catch (IOException i) {
         i.printStackTrace();
      }
	}
	
	public Customer deserializeDataBase() {
		Customer c = null;
		try {
			FileInputStream file = new FileInputStream("src/main/java/com/projects/project0/dataBaseCustomer.txt");
			ObjectInputStream in = new ObjectInputStream(file);
			
			try {
				c = (Customer)in.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			in.close();
			file.close();
			//System.out.println("");
		} catch (IOException i) {
         i.printStackTrace();
		}
		return c;
	}
	
	public String toString() {
		return getUserName() + " " + getFirstName() + " " + getLastName();
	}
}
