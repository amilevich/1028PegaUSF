package com.homework.HW1;

/*
 * Implements 4 methods from interface 
 * 1. Addition
 * 2. Subtraction
 * 3. Division
 * 4. Multiplication.
 * 
 * Test class is called Q15_TestCase
 */
public class Q15_Class implements Q15_IF{

	@Override
	public double addition(double x, double y) {
		System.out.println("Adding...");
		return x+y;
		
	}

	@Override
	public double subtraction(double x, double y) {
		System.out.println("Subtracting..");
		return x-y;
	}

	@Override
	public double division(double x, double y) {
		System.out.println("Dividing...");
		return x/y;
		
	}
	@Override
	public double multiplication(double x,double y) {
	System.out.println("Multiplying...");
	return x*y;
	}
	
	public static void main(String[] args) {
		
		Q15_Class test = new Q15_Class();
		
		int x =10;
		int y =5;
		test.addition(x, y);
		test.subtraction(x, y);
		test.division(x, y);
		test.multiplication(x, y);
		
	}

	
}
