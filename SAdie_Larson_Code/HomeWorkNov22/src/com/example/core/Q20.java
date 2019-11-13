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

public class Q20 extends ObjectOutputStream {

	protected Q20() throws IOException, SecurityException {
		super();
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fo = new FileOutputStream("Data.txt");
		ObjectOutputStream ob = new ObjectOutputStream(fo);
		Q20NotepadC m = new Q20NotepadC("Mickey", "Mouse", 25, "Arizona");
		ob.writeObject(m);
		ob.flush();

		Q20NotepadC h = new Q20NotepadC("Hulk", "Hogan", 50, "Virginia");
		ob.writeObject(h);
		ob.flush();

		Q20NotepadC r = new Q20NotepadC("Roger", "Rabbit", 22, "California");
		ob.writeObject(r);
		ob.flush();

		Q20NotepadC w = new Q20NotepadC("Wonder", "Woman", 18, "Montana");
		ob.writeObject(w);
		ob.flush();

		ob.close();

		ObjectInputStream obi = new ObjectInputStream(new FileInputStream("Data.txt"));

		ArrayList<Q20NotepadC> obiList = new ArrayList<Q20NotepadC>();
		obiList.add((Q20NotepadC) obi.readObject());

		/* To implement adding all of the objects in the file
		 * Q20NotepadC temp = new Q20NotepadC(); 
		 * try { while ((temp = (Q20NotepadC)
		 * obi.readObject()) != null) { obiList.add(temp); //
		 * System.out.println(obiList); } } catch(EOFException e) { //output expected }
		 */
		obi.close();

		System.out.println(obiList);
	}

}
