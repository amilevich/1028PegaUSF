package com.javahomework.questions;

public class QuestionSixteenClass {
	/*
	 * Write a program to display the number of characters for a string input. 
	 * The string should be entered as a command line argument using (String [ ] args).
	 * */
	public static void main(String[] args) {
		// check if length of args array is 
        // greater than 0 
        if (args.length > 0) 
        { 
            System.out.println("command line argument found:"); 
  
            // iterating the args array and printing 
            for (String val:args) 
                System.out.println(val); 
        } 
        else
            System.out.println("No command argument found."); 
    }
	
}
