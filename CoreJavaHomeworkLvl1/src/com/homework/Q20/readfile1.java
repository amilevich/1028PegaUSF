package com.homework.Q20;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class readfile1 {
	
	
	public static void main(String[] args) {
		try {
			// reading from a data file
		InputStream grab = new FileInputStream("./Data.txt");
		BufferedReader search = new BufferedReader(new InputStreamReader(grab));
		 
		 String col = search.readLine();
		 String info[] = col.split(":");
		 for(int i=0; i < info.length; i++) {
			   if(i == 0) {
				   System.out.println("Name: " + info[i]);
				   System.out.print(" " + info[i+1]);
			   }
			   else if(i==1) {
				   System.out.println("Age: " + info[i+1]);
			   }
			   else if(i==2) {
				   System.out.println("State: " + info[i+1]);
			   }
			   
		 
		}
		 
		}
		 catch(FileNotFoundException exception){
			
		}
		catch(IOException exception) {
			
		}
		 //col.split(" ");
		// while(col!= null) {
			// System.out.println("Name: "  );
		 //}
		
 
}
}
