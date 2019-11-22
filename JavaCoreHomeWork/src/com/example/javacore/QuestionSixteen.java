package com.example.javacore;

import java.util.Scanner;

/*
 * Write a program to display the number of 
 * characters for a string input. The string should 
 * be entered as a command line argument using (String [ ] args).
 * 
 */
public class QuestionSixteen {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String character;
		
		 // check if length of args array is 
        // greater than 0 
		System.out.println("enter ");
		character = sc.next();
        if (args.length >0 ) {
        	
            System.out.println("The command line"+ 
                               " arguments are:" + args.length); 
  
            // iterating the args array and printing 
            // the command line arguments 
            for (String value:args) 
                System.out.println(value); 
        } 
        else
            System.out.println("No command line "+ 
                               "arguments found."); 

		
	}
	
	public static void CharacterString(String[]args) {
		for(int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	}

}
