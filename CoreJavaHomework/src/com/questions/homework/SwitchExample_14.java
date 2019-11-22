package com.questions.homework;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class SwitchExample_14 {

	public static void main(String[] args) {
		Switches();
	}
	
	public static void Switches() {
		Scanner sc = new Scanner(System.in);
		System.out.println("What would you like to do?" +'\n'+ "1. Find square root of 10" +'\n'+ "2. Display date." +'\n'+ "3. Split and store ''I am learning Core Java''");
		String options = sc.nextLine();
		
		switch(options) {
		case "1" : //find square root of set number
			double x = 10;
			System.out.println("The square root of 10 is: " + Math.sqrt(x));
			break;
		case "2" : //pulls current time / date in military time
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			System.out.println(dtf.format(now));
			break;
		case "3" :
			String splitSentence = "I am learning Core Java.";
			String [] split = splitSentence.split(" ");
			for(String i : split) {// take letters from string and split it
				System.out.println(i);
			}
			break;
		}
	}
}

