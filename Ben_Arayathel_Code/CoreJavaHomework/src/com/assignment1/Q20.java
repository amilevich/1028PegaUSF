package com.assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Q20 {
	
	public static void readingFile() {
		Path file = FileSystems.getDefault().getPath("C:\\Users\\benBF\\OneDrive\\Documents\\Git folder\\1028PegaUSF\\Ben_Arayathel_Code\\Data.txt");
		try (InputStream in = Files.newInputStream(file);
		    BufferedReader reader =	
		      new BufferedReader(new InputStreamReader(in))) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		    	String[] lineList = line.split(":");
//		        System.out.println(line);
		        System.out.println("Name: " + lineList[0] + " " + lineList[1]);
		        System.out.println("Age: " + lineList[2] + " years");
		        System.out.println("State: " + lineList[3]); //I thought it was dumb saying "State: Arizona State", the first entry already implies statehood.
		        System.out.println("\n");
		    }
		} catch (IOException e) {
		    e.getStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		readingFile();
	}

}
