package com.example.homework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Q20 {

	// Q20. Create a note pad file called Data.txt and enter the following:
	// Mickey:Mouse:35:Arizona
	// Hulk:Hogan:50:Virginia
	// Roger:Rabbit:22:California
	// Wonder:Woman:18:Montana
	//
	// Write a program that would read from the file and print it out to the screen
	// in the following format:
	//
	// Name: Mickey Mouse
	// Age: 35 years
	// State: Arizona State

	public void prettyPrint() throws IOException {

		// Create new BufferedReader
		BufferedReader br = null;
		String currentLine;
		// Try and read the file into a buffered reader
		try {
			br = new BufferedReader(new FileReader(
					"C:\\Users\\prate\\Documents\\My_Git_Repos\\1028PegaUSF\\David_Prater_Code\\CoreJavaHomework\\question20.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Loop through each line of the separate by ":" add to a String array and
		// format output
		while ((currentLine = br.readLine()) != null) {
			String[] format = currentLine.split(":");

			System.out.println("Name: " + format[0] + " " + format[1]);
			System.out.println("Age: " + format[2]);
			System.out.println("State: " + format[3]);
			System.out.println("");
		}

	}

}
