package com.example.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainDriver {

	public static void main(String[] args) {
		/*
		 * Serialization is the mechanism of converting the state(s) of
		 * an object into byte stream and persisting in a text file
		 * 
		 * Deserialization- reserve process, byte  stream is used to recreate the actual java object in memory
		 * 
		 * To make it happen: 
		 * 1. Serializable interface- marker interface (0 methods)
		 * 
		 * 2.The ObjectOutputStream class contains the writeObject() method
		 * for serializing an object
		 * 
		 * The ObjectInputStream class contains the readObject() method
		 * for deserializing an object
		 */
		String filename = "./sampleObjectFile.txt";
		Car car = new Car(true, "pentagon", 7, "Toyota");
		writeObject(filename, car);
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
			System.out.println(ois.readObject());
		}catch(IOException exception) {
			exception.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
