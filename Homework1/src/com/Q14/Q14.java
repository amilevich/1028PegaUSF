package com.Q14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Q14 {
	
	 static void switchExample(int choice, int number) {
		 switch (choice) { 
	        case 1: 
	            choice = 1; 
	            System.out.println(Math.sqrt(number));
	            break; 
	        case 2: 
	        	choice = 2; 
	        	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	        	Date date = new Date();
	        	System.out.println(dateFormat.format(date));
	            break; 
	        case 3: 
	        	choice = 3; 
	        	String myString = "I am learning Core Java";
	        	String[] items = myString.split(" ");
	        	for(String i:items) {
	        		System.out.print("'" + i + "' ");
	        	}
	            break; 
	       
	        } 
	 }
	public static void main(String[] args) {
		
		switchExample(1,1024);
		switchExample(2,1024);
		switchExample(3,1024);
	}
}
