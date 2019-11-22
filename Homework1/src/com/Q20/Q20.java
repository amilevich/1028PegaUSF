package com.Q20;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Q20 {
	/*
	 * Write a program that would read from the file and print it out to the screen in the following format:
	 * To:
	 * Name: Mickey Mouse
	 * Age: 35 years
	 * State: Arizona State
	 * 
	 * From:
	 * Mickey:Mouse:35:Arizona
	 * Hulk:Hogan:50:Virginia
	 * Roger:Rabbit:22:California
	 * Wonder:Woman:18:Montana
	 */
	
	// creating notepad file data.txt"
	public static void writeFile(String filename)  {
		String a = "Mickey:Mouse:35:Arizona\n" + 
				"Hulk:Hogan:50:Virginia\n" + 
				"Roger:Rabbit:22:California\n" + 
				"Wonder:Woman:18:Montana\n" + 
				"";
		try(FileWriter oos = new  FileWriter(filename)){
			oos.write(a);
		}catch(IOException io) {
			io.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		writeFile("data.txt");
		System.out.println(readFile("data.txt"));
		
	}
	
	public static String readFile(String filename) {
		
			String data = ""; 
			try {
				data = new String(Files.readAllBytes(Paths.get(filename))); //READING FILE INTO CONSOLE
			} catch (IOException e) {
				
				e.printStackTrace();
			}  
		    return data; 
		   
		}
	}
	

