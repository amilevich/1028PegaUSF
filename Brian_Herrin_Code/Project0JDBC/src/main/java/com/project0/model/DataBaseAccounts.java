package com.project0.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.HashMap;

import com.project0.dao.BankDaoImpl;

import org.apache.log4j.Logger;

public class DataBaseAccounts extends DataBase  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static DataBaseAccounts dBAccs = new DataBaseAccounts();
	private HashMap<Integer, Account> mapAccounts = new HashMap<Integer, Account>();
	/* Get actual class name to be printed on */
	// static Logger log = Logger.getLogger(dataBaseApplication.class.getName());
	static Logger log = Logger.getLogger(DataBaseAccounts.class);

	public HashMap<Integer, Account> getMapAccounts() {
		return mapAccounts;
	}
	public Account getMap(Integer id) {
		return mapAccounts.get(id);
	}

	public void putMap(Integer i, Account a) {
		this.mapAccounts.put(i, a);
	}
	
	public boolean isAccountId(Integer id){
		if(getMap(id) != null) {
			return true;
		}
		return false;
	}
	
	public void logApplicationTransaction(HashMap<Integer, Account> hashMap) throws IOException, SQLException {
		//log.debug("Hello this is a debug message");
		log.info("Put Account in Database: ");
	}
	
	
	/*
	public static void serializeDataBaseAccount() {
		try {
			FileOutputStream fileOut = new FileOutputStream("src/main/java/com/projects/project0/datalayer/dataBaseAccounts.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(dBAccs);
			out.close();
			fileOut.close();
			//System.out.println("Serialized data is saved in " + fileOut.getFD() );
      } catch (IOException i) {
         i.printStackTrace();
      }
	}
	
	public static void deserializeDataBaseAccount() {
		try {
			FileInputStream file = new FileInputStream("src/main/java/com/projects/project0/datalayer/dataBaseAccounts.txt");
			ObjectInputStream in = new ObjectInputStream(file);
			
			try {
				dBAccs = (DataBaseAccounts)in.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
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