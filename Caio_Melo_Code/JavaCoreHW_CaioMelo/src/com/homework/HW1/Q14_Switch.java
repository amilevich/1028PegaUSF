package com.homework.HW1;
import java.lang.Math;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner; 
/*
 * Use switch statement to do either of 3 things:
 * 1. Display Square Root 
 */

public class Q14_Switch {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1...Square Root");
		System.out.println("2...Display Date");
		System.out.println("3...Split String");
		System.out.println("Please make a selection.");
		
		
		int x = sc.nextInt();
		
		switch(x) {
		case 1: 
			System.out.println("Which number would you like the Square root of: ");
			int root = sc.nextInt();
			System.out.println("Square Root :" + Math.sqrt(root));
		break;
		
		case 2:	
			 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
			 LocalDateTime now = LocalDateTime.now();  
			 System.out.println(dtf.format(now)); 
			   
			   
		break;
		
		case 3: 
			String str = "I am learning Core Java";
			String[] arr = str.split("");
			System.out.println("String split and put into array at :" + arr);
			
		break;
		}
	
		
		
	}
	

}
