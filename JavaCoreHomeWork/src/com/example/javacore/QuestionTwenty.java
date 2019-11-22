package com.example.javacore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Create a notepad file called Data.txt and enter the following: 
 * Mickey:Mouse:35:Arizona
Hulk:Hogan:50:Virginia
Roger:Rabbit:22:California
Wonder:Woman:18:Montana

Write a program that would read from the file and print it out to the screen in the following format:

Name: Mickey Mouse
Age: 35 years
State: Arizona State

 */
public class QuestionTwenty {

	public static void main(String[] args) {

		BufferedReader read = null;
		try {
			//reading the file
			read = new BufferedReader(new FileReader(
					"C:\\Users\\bcord_000\\Desktop\\Spring Workspace\\JavaCoreHomeWork\\src\\com\\example\\javacore\\Data.txt"));
			String text; 
			while ((text = read.readLine()) != null) { //looping through the file while it is not null

				String[] Data = text.split(":");// storing text
				//printing the data from the file
				System.out.println("Name: " + Data[0] + " " + Data[1]);
				System.out.println("Age: " + Data[2] + " years");
				System.out.println("State: " + Data[3] + " State");
				System.out.println("\n");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (read != null) {
				try {
					read.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

}
