package com.example.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainDriver {

	/*
	 * Serialization - is the mechanism of converting the sate(s) of an object into
	 * byte stream and persisting in a text file
	 * 
	 * De-serialization - reverse process, byte stream is used to recreate the
	 * actual Java object in memory
	 * 
	 * To make it happen: Serializaeable Interface - marker interface (0 methods)
	 * Marker interface - let JVM know what is going to happen to the class
	 * 
	 * The ObjectOutputStream class contains the writeoBject() method for
	 * serilaizing an object
	 * 
	 * The ObjectIputStream class contains the readObject() method for
	 * deserializaing an object
	 * 
	 * 
	 */

	public static void main(String[] args) {

		String filename = "./ObjectStream.txt";
		Car car = new Car(true, "pentagon", 7, "UFO");
		writeObject(filename, car);
		readObject(filename, car);	
		System.out.println("done");
		//for example with adding multiple objects look at hwcorenov22 - Q20
	}

	public static void writeObject(String filename, Object obj) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(obj);
			oos.flush();
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public static void readObject(String filename, Object obj) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			System.out.println(ois.readObject());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException anything) {
			anything.printStackTrace();
		}
	}
}
