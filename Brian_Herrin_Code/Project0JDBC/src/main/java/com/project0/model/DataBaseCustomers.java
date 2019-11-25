package com.project0.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.project0.maindriver.MainDriver;
import com.project0.dao.BankDaoImpl;

public class DataBaseCustomers extends DataBase implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static DataBaseCustomers dBCus = new DataBaseCustomers();
	private HashMap<Integer, Customer> mapCustomers = new HashMap<Integer, Customer>();
	/* Get actual class name to be printed on */
	//final static Logger log = Logger.getLogger(DataBaseCustomers.class);
	final static Logger logger = Logger.getLogger(DataBaseCustomers.class);

	public HashMap<Integer, Customer> getMapCustomers() {
		return dBCus.mapCustomers;
	}
	public Customer getMap(Integer id) {
		return dBCus.mapCustomers.get(id);
	}

	public void putMapCustomers(Integer i, Customer a) {
		dBCus.mapCustomers.put(i, a);
	}
	
	public Integer getCustomerId(String username) {
		Integer i = 0;
		for(Integer j : dBCus.mapCustomers.keySet()) {
			if(username.equals(dBCus.mapCustomers.get(j).getUserName())) {
				return j;
			}
		}
		return i;
	}
	
	public boolean isLoginValid(String temp1, String temp2) {
		for(int i = 0; i < dBCus.getMapCustomers().size(); i++) {
			//System.out.println("for loop " + dBCus.getMap(i).getUserName() + " " + dBCus.getMap(i).getPassword());
			if(MainDriver.isEqualToString(temp1, dBCus.getMap(i).getUserName() )) {
				//System.out.println("(Debug) Hey, there is a username like that!");
				if(MainDriver.isEqualToString(temp2, dBCus.getMap(i).getPassword() )) {
					//System.out.println("(Debug) Password too!");
					return true;
				} else {
					System.out.println("Wrong Password! Oh, no!");
					return false;
				}
			}
		}
		return false;
	}
	/*
	public static void serializeDataBaseCustomer() {
		try {
			// FileOutputStream fileOut = new FileOutputStream("bin/com/projects/project0/accountApplication.txt");
			FileOutputStream fileOut = new FileOutputStream("src/main/java/com/projects/project0/datalayer/dataBaseCustomers.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(dBCus);
			out.close();
			fileOut.close();
			//System.out.println("Serialized data is saved in " + fileOut.getFD() );
      } catch (IOException i) {
         i.printStackTrace();
      }
	}
	
	public static void deserializeDataBaseCustomer() {
		try {
			FileInputStream file = new FileInputStream("src/main/java/com/projects/project0/datalayer/dataBaseCustomers.txt");
			ObjectInputStream in = new ObjectInputStream(file);
			
			try {
				dBCus = (DataBaseCustomers)in.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			in.close();
			file.close();
			//System.out.println("");
		} catch (IOException i) {
         i.printStackTrace();
		}
	}
	*/
}