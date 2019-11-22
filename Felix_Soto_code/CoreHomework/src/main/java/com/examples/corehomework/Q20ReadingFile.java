package com.examples.corehomework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q20ReadingFile {

	public static void main(String[] args) {

		BufferedReader read = null;
		try {
			//reading the file
			read = new BufferedReader(new FileReader(
					"C:\\Users\\Felix\\Documents\\workspace-sts-3.9.4.RELEASE\\CoreHomework\\Data.txt"));
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
