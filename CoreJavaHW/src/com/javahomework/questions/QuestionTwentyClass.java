package com.javahomework.questions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class QuestionTwentyClass {
	/*
	 * Create a notepad file called Data.txt and enter the following:
	 * Mickey:Mouse:35:Arizona Hulk:Hogan:50:Virginia Roger:Rabbit:22:California
	 * Wonder:Woman:18:Montana
	 * 
	 * Write a program that would read from the file and print it out to the screen
	 * in the following format:
	 * 
	 * Name: Mickey Mouse Age: 35 years State: Arizona State
	 * 
	 */
	public static void main(String[] args) {
		BufferedReader reader = null;
		try {//i have to use a try catch because reading a file can be risky
			//creating a reader object to read the file from my file path
			reader = new BufferedReader(new FileReader(
					"C:\\Users\\suazo\\OneDrive\\Documents\\1028Pegasts\\CoreJavaHW\\QuestionTwenty.txt"));
			String text; // text representation of text in file will be held here then put to an array
			while ((text = reader.readLine()) != null) { //while reading the file and it is not empty

				String[] myFileData = text.split(":");//declaring the array of where i want to store my text
				//printing out the format with system outputs
				System.out.println("Name: " + myFileData[0] + " " + myFileData[1]);
				System.out.println("Age: " + myFileData[2] + " years");
				System.out.println("State: " + myFileData[3] + " State");
				System.out.println("\n");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
