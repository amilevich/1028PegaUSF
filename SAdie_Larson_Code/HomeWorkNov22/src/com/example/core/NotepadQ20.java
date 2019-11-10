package com.example.core;

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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class NotepadQ20 extends ObjectOutputStream {

	protected NotepadQ20() throws IOException, SecurityException {
		super();
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fo = new FileOutputStream("Data.txt");
		ObjectOutputStream ob = new ObjectOutputStream(fo);
		NotepadC m = new NotepadC("Mickey", "Mouse", 25, "Arizona");
		ob.writeObject(m);
		NotepadC h = new NotepadC("Hulk", "Hogan", 50, "Virginia");
		ob.writeObject(h);
		NotepadC r = new NotepadC("Roger", "Rabbit", 22, "California");
		ob.writeObject(r);
		NotepadC w = new NotepadC("Wonder", "Woman", 18, "Montana");
		ob.writeObject(w);
		ob.close();

		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Data.txt"));

		ArrayList<NotepadC> obI = new ArrayList<NotepadC>(); 
		NotepadC re = (NotepadC) objectInputStream.readObject();
		
		objectInputStream.close();
		System.out.println("Name: " + re.name + " " + re.type);
		System.out.println("Age: " + re.age + " years");
		System.out.println("State: " + re.state + " State");

	}

}
