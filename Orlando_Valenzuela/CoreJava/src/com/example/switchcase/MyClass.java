package com.example.switchcase;

import java.util.Date;
import java.util.Scanner;

public class MyClass {

	public static void main(String[] args) {

		
		 int op;
		 String sop;
		 boolean control = true;
		 Scanner sc = new Scanner(System.in);
		 
		 do 
		 {
			 
 			 System.out.println("Hello, welcom: ");
			 System.out.println("1: Square root: ");
			 System.out.println("2: Today’s date: ");
			 System.out.println("3: Split phrase : ");
			 System.out.println("4: Exit : ");
			 System.out.println("Please choose an option: ");
			 
			 sop = sc.nextLine();
             op = Integer.parseInt(sop);
								 
			 switch(op) {
			 
				 case 1:{
					    
					 System.out.println("Please enter a number: ");
					 sop = sc.nextLine();
					 Double num = Double.parseDouble(sop);
					 System.out.println(" The square is: " + Math.sqrt(num));
					 
					 break;
				 }
				 case 2:{
					 
					 Date today = new Date(System.currentTimeMillis());
					 
					 System.out.println(" The today date: " + today.toGMTString());
					 
					 break;
					 
				 }
				 case 3:{
					 
					 System.out.println("Please enter phrase: ");
					 sop = sc.nextLine();
					 String[]  phrase = sop.split(" ");
					 
					 for (int i = 0; i < phrase.length; i++)
					    System.out.println(phrase[i]);	
					 
					 break;
					 
				 }

				 case 4:{
					 control = false;
					 break;
				 }	 			 
			 } 
			 
		 }while (control);		
		 
		 sc.close();
	}

}
