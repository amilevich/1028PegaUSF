package com.project0.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.project0.maindriver.MainDriver;
import com.project0.dao.BankDaoImpl;

public class DataBaseEmployees extends DataBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static DataBaseEmployees dBEmp = new DataBaseEmployees();
	private HashMap<Integer, Employee> mapEmployees = new HashMap<Integer, Employee>();
	/* Get actual class name to be printed on */
	final static Logger logger = Logger.getLogger(DataBaseEmployees.class);

	public HashMap<Integer, Employee> getMapEmployees() {
		return mapEmployees;
	}
	public Employee getMap(Integer id) {
		return mapEmployees.get(id);
	}

	public void putMapEmployees(Integer i, Employee e) {
		this.mapEmployees.put(i, e);
	}
	
	public boolean isLoginValid(String temp1, String temp2) {
		//System.out.println("DataBaseEmployees isLoginValid: " + temp1 + " " + dBEmp.getMapEmployees().size());
		for(int i = 0; i < dBEmp.getMapEmployees().size(); i++) {
			//System.out.println("for loop " + dBEmp.getMap(i).getUserName() + " " + dBEmp.getMap(i).getPassword());
			if(MainDriver.isEqualToString(temp1, dBEmp.getMap(i).getUserName() )) {
				//System.out.println("(Debug) Hey, there is a username like that!");
				if(MainDriver.isEqualToString(temp2, dBEmp.getMap(i).getPassword() )) {
					//System.out.println("(Debug) Password too!");
					return true;
				} else {
					//System.out.println("(Debug) Wrong Password! Oh, no!");
					return false;
				}
			}
		}
		return false;
	}
	
	public void logEmployeeTransaction(HashMap<Integer, Employee> hashMap) throws IOException, SQLException {
		//log.debug("Hello this is a debug message");
		log.info("Put Employee in Database: ");
	}
	/*
	public static void serializeDataBaseEmployee() {
		try {
			FileOutputStream fileOut = new FileOutputStream("src/main/java/com/projects/project0/datalayer/dataBaseEmployees.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(dBEmp);
			out.close();
			fileOut.close();
			//System.out.println("Serialized data is saved in " + fileOut.getFD() );
      } catch (IOException i) {
         i.printStackTrace();
      }
	}
	
	public static void deserializeDataBaseEmployee() {
		try {
			FileInputStream file = new FileInputStream("src/main/java/com/projects/project0/datalayer/dataBaseEmployees.txt");
			ObjectInputStream in = new ObjectInputStream(file);
			
			try {
				dBEmp = (DataBaseEmployees)in.readObject();
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