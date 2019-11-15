package com.example.core;

//DONE
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
import java.io.FileReader;
import java.io.IOException;

public class Q20 {

	public static void main(String[] args) {
	

		String filename = "Data2.txt";
		readCharacterStream(filename);
	}

	public static void readCharacterStream(String filename) {
		try (FileReader reader = new FileReader(filename)) {
			int i;
			int j = 0;
			String dat = new String("");

			while ((i = reader.read()) != -1) {
				Q20NotepadC em = new Q20NotepadC();
				while ((char) i != '\n' && i != -1) {
					dat = dat + ((char) i);
					i = reader.read();
					
					if ((char) i == ':' && j == 0) { // space between name
						j++;
					} else if ((char) i == ':' && j == 1) { //name assignment
						dat = dat.replace(':', ' ');
						em.setName(dat);
						dat = "";
						j++;
					} else if ((char) i == ':' && j == 2) { //age assingment
						dat = dat.substring(1, dat.length());
						em.setAge(Integer.valueOf(dat));
						dat = "";
						j = 0;
					} else if ((char) i == '\n' || i == -1) {
						dat = dat.substring(1, dat.length());
						em.setState(dat);
						dat = "";
					}
				}
				System.out.println(em);
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
