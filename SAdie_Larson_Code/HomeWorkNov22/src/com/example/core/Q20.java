package com.example.core;

import java.io.EOFException;

/*
 * Mickey:Mouse:35:Arizona
Hulk:Hogan:50:Virginia
Roger:Rabbit:22:California
Wonder:Woman:18:Montana

Write a program that would read from the file and print it out to the screen in the following format:

Name: Mickey Mouse
Age: 35 years
State: Arizona State


 */

//TO DO: double check

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Q20 {

	public static void main(String[] args) {
		String filename = "Data.txt";

		 Q20NotepadC m = new Q20NotepadC("Mickey", "Mouse", 25, "Arizona");
		 Q20NotepadC h = new Q20NotepadC("Hulk", "Hogan", 50, "Virginia");		
		 Q20NotepadC r = new Q20NotepadC("Roger", "Rabbit", 22, "California");		
		 Q20NotepadC w = new Q20NotepadC("Wonder", "Woman", 18, "Montana");
		 
		 try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
				oos.writeObject(m);
				oos.writeObject(h);
				oos.writeObject(r);
				oos.writeObject(w);				
			} catch (IOException io) {
				io.printStackTrace();
			}
		 
		 readObject(filename, m);
	}
	
	public static void readObject(String filename, Object obj) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			while (true) {
				try {
					obj = ois.readObject();
				} catch (Exception e) {
					break;
				}
				System.out.println(obj);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
