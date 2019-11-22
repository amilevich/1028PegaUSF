package com.example.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class MyClass {

	public static void main(String[] args) {
	
	  String s = null;
	  String[] sn;	
	  File f = new File("C:\\Users\\Rosy\\Documents\\workspace-sts-3.9.4.RELEASE\\CoreJava\\src\\com\\example\\file\\file.txt");
	  ArrayList<String> sl = new ArrayList<>();
	  	  
	  try ( FileReader fr = new FileReader(f); 
			BufferedReader br = new BufferedReader(fr);){
		     
		    for (s = br.readLine(); s != null; s = br.readLine())
		        sl.add(s);	  
		    
	  } catch (Exception e) {
			e.printStackTrace();
		}
	  
	  for(String i : sl) {
		
		  sn = i.split(":");
		  System.out.println("\nName: " + sn[0] + " " + sn[1] + 
				             "\nAge:  " + sn[2] + " years" +
				             "\nState: " + sn[3]);
		  
	  }
	}
}
