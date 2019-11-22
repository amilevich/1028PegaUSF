package interview.questions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class QFourteen {
	
	


public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please make a selection");
		System.out.println();
		System.out.println("square root - 1");
		System.out.println("date - 2");
		System.out.println("split string - 3");
		
		
		int x = sc.nextInt();
		
		switch(x) {
		case 1: 
			System.out.println("Enter a number for the square root ");
			int sqRt = sc.nextInt();
			System.out.println("Square Root:" + Math.sqrt(sqRt));
		break;
		
		case 2:	
			 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");  
			 Date date = new Date();  
			 System.out.println("Date:" + dateFormat.format(date)); 
			   
			   
		break;
		
		case 3: 
			String str = "I am learning Core Java";
			String[] splitString = str.split(" ");
			System.out.println("Split String:" + splitString);
			
		break;
		}
	
		
		
	}
	}
