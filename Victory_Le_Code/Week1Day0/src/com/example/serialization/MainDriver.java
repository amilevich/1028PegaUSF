package com.example.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainDriver {
	/*
	 * Serialization - the mechanism of converting the state(s) of an object into byte stream and persisting in a text file
	 * 
	 * Deserialization - reverse process, byte stream is used to recreate the actual Java object in memory
	 * 
	 * To make it happen:
	 * Serializable interface - Marker interface - has 0 methods
	 * 
	 * The ObjectOutputStream class contains the writeObject() method for serializaing an object
	 * The ObjectInputStream class contains the readObject() method for deserializing an object
	 */

	public static void main(String[] args) {
		String filename = "./sampleObjectFile.txt";
		Car car = new Car(true,"pentagon", 7, "UFO");
		writeObject(filename,car);
		readObject(filename);
		System.out.println("done");

		
	
	}

	public static void writeObject(String filename, Object obj) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			oos.writeObject(obj);
		}catch(IOException io) {
			io.printStackTrace();
		}
	}
	
	public static void readObject(String filename) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			//Object object = ois.readObject();
			System.out.println(ois.readObject());
		}catch(IOException exception) {
			exception.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
