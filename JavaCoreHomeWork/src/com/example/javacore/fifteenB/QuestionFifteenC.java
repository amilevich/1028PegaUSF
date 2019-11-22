package com.example.javacore.fifteenB;
/*
 * Write a program that defines an interface having the following methods: 
 * addition, subtraction, multiplication, and division.  
 * Create a class that implements this interface and provides 
 * appropriate functionality to carry out the required operations. 
 * Hard code two operands in a test class having a main method 
 * that calls the implementing class.
 * 
 */
public class QuestionFifteenC extends QuestionFifteenB{

	public static void main(String[] args) {

		QuestionFifteenC qc = new QuestionFifteenC();
		
		int a = 10;
		int b = 5;
		qc.addition(a, b);
		qc.subtraction(a, b);
		qc.multiplication(a, b);
		qc.division(a, b);
		
	}

}
