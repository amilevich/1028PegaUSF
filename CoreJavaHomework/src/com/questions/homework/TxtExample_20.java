package com.questions.homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TxtExample_20 {

	public static void main(String[] args) {
		File source = new File("Data.txt"); //Find the txt file
		StringBuffer text = new StringBuffer(); //Readying sequence of chars from txt file
		BufferedReader reader = null;//Reading txt to human / character language
		
		try
	    {
	        reader = new BufferedReader(new FileReader(source));
	        String data = null;

	        while ((data = reader.readLine()) != null)// while the there is data, edit the text and make it readable
	        {
	            text.append(data)
	                .append(System.getProperty(
	                    "line.separator"));
	        }
	    }catch(FileNotFoundException e) {
	    	e.printStackTrace();	
	    }catch(IOException e) {
	    	e.printStackTrace();
	    }
		try {
			String line1 = Files.readAllLines(Paths.get("Data.txt")).get(0); //Grab 1st line specifically
			System.out.println(line1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(text.toString());
		
		
	}
	


}
