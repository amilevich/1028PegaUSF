package com.homework.HW1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Q20_Notepad {
	public static void main(String[] args) {
		
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader("/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/JavaCoreHW_CaioMelo/Data.txt"));
		String line = reader.readLine();
		while(line != null) {

			String[] splitLine = line.split(":"); //Split string based on : as regex
			System.out.println("Name: " + splitLine[0] + " " + splitLine[1]);
			System.out.println("Age: " + splitLine[2]);
			System.out.println("State: "+ splitLine[3] +" State");
			System.out.println();
			line = reader.readLine();
			
			
		}
		reader.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
			
	}
	

}
