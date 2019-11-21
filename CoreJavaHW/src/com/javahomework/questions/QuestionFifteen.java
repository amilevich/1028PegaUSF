package com.javahomework.questions;
/*
 * Write a program that defines an interface having the following methods: 
 * addition, subtraction, multiplication, and division.  
 * Create a class that implements this interface and provides appropriate functionality to carry out the required operations. 
 * Hard code two operands in a test class having a 
 * main method that calls the 
 * implementing class.
 * */
public class QuestionFifteen implements MathOperations {

	@Override
	public void addition(int a, int b) { //overriden addition method that takes two integers as arguments
		System.out.println("Addition: " + a + " + " + b + " = " + (a+b));
		
	}

	@Override
	public void subtraction(int a, int b) {//overriden subtraction method that takes two integers as arguments
		System.out.println("Subtraction: " + a + " - " + b + " = " + (a-b));
		
	}

	@Override
	public void multiplication(int a, int b) {//overriden multiplication method that takes two integers as arguments
		System.out.println("Multiplication: " + a + " x " + b + " = " + (a*b));
		
	}

	@Override
	public void division(int a, int b) {//overriden division method that takes two integers as arguments
		System.out.println("Addition: " + a + " / " + b + " = " + (a/b));
		
	}
	
	
}
