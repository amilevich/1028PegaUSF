package com.projects.project0.businesslayer;

import org.apache.log4j.Logger;

import java.io.*;
import java.sql.SQLException;
import java.util.HashMap;


public class DataBaseApplications extends DataBase  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static DataBaseApplications dBApps = new DataBaseApplications();
	private HashMap<Integer, Account> mapApplications = new HashMap<Integer, Account>();
	/* Get actual class name to be printed on */
	// static Logger log = Logger.getLogger(dataBaseApplication.class.getName());
	static Logger log = Logger.getLogger(DataBaseApplications.class);

	public HashMap<Integer, Account> getMapApplications() {
		return mapApplications;
	}
	public Account getMap(Integer id) {
		return mapApplications.get(id);
	}

	public void putMap(Integer i, Account a) {
		this.mapApplications.put(i, a);
	}
	
	public void removeMap(Integer i, Account a) {
		this.mapApplications.remove(i, a);
	}
	
	public boolean isAccountId(Integer id){
		if(getMap(id) != null) {
			return true;
		}
		return false;
	}
	
	public void logApplicationTransaction(HashMap<Integer, Account> hashMap) throws IOException, SQLException {
		log.debug("Hello this is a debug message");
		log.info("Put Application in Database: ");
	}

	public static void serializeDataBaseApplication() {
		try {
			FileOutputStream fileOut = new FileOutputStream("src/main/java/com/projects/project0/datalayer/dataBaseApplicants.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(dBApps);
			out.close();
			fileOut.close();
			//System.out.println("Serialized data is saved in " + fileOut.getFD() );
      } catch (IOException i) {
         i.printStackTrace();
      }
	}
	
	public static void deserializeDataBaseApplication() {
		try {
			FileInputStream file = new FileInputStream("src/main/java/com/projects/project0/datalayer/dataBaseApplicants.txt");
			ObjectInputStream in = new ObjectInputStream(file);
			
			try {
				dBApps = (DataBaseApplications)in.readObject();
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
}