package com.project0.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Set;

import org.apache.log4j.Logger;

public class DataBase implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static DataBase dB  = new DataBase();
	static Logger log = Logger.getLogger(DataBase.class);
	
	private HashMap<Integer, Object> map = new HashMap<Integer, Object>();
	
	public Object getMap(Integer id) {
		//dB.
		return this.map;
	}
	
	public void setMap(HashMap<Integer, Object> map) {
		this.map = map;
	}
	
	public Set<Integer> keySetMap() {
		return this.map.keySet();
	}
	
	public void putMap(Integer key, Object o) {
		this.map.put(key, o);
	}
	
	public void  putIfAbsentMap(Integer key, Object o) {
		this.map.put(key, o);
	}
	
	public void removeMapEntry(Object key){
		this.map.remove(key);
	}
	/*
	public static void serializeDataBase() {
		try {
			FileOutputStream fileOut = new FileOutputStream("src/main/java/com/projects/project0/datalayer/dataBase.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(dB);
			out.close();
			fileOut.close();
			//System.out.println("Serialized data is saved in " + fileOut.getFD() );
      } catch (IOException i) {
         i.printStackTrace();
      }
	}
	
	public static void deserializeDataBase() {
		try {
			FileInputStream file = new FileInputStream("src/main/java/com/projects/project0/datalayer/dataBase.txt");
			ObjectInputStream in = new ObjectInputStream(file);
			
			try {
				dB = (DataBase)in.readObject();
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
