package com.javahomework.questions;

public class QuestionEighteenClass extends QEighteenAbstClass{
	/*
	 * Write a program having a concrete subclass that inherits three abstract
	 *  methods from a superclass. Provide the following three implementations 
	 *  in the subclass corresponding to the abstract methods in the superclass: 
	Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
	Convert all of the lower case characters to uppercase in the input string, and return the result. 
	Convert the input string to integer and add 10, output the result to the console.
	Create an appropriate class having a main method to test the above setup.

	 * */
	@Override
	public boolean checkUpperCase(String str) { //method that checks for uppercases
		if(!str.equals(str.toLowerCase())) {//return true if not lowercase or return false if it is
			return true;
		}else {
		return false;
		}
	}

	@Override
	public String convertLowerToUpper(String str) { //method that converts lower case to upper in a string
		
		return str.toUpperCase();
	}

	@Override
	public void convertStringToInteger(String str) { //method to take a string and convert it to an integer
		int a = Integer.parseInt(str);
		int b = 10;
		System.out.println(a + " + " + b + " = " + (a+b));
		
	}

	
	public static void main(String[] args) {
		String st = "say Hello to my little friend";
		String st1 = "15";
		QuestionEighteenClass b = new QuestionEighteenClass();
		System.out.println(b.checkUpperCase(st));
		System.out.println(st);
		System.out.println("-----------------------------");
		System.out.println("all are lowers to uppers");
		System.out.println(b.convertLowerToUpper(st));
		System.out.println("-----------------------------");
		b.convertStringToInteger(st1);
	}
	
}
