package com.example.calulator;

public class Calculator {
	public boolean areTwoIntegersEqual(int x, int y) {
		if (x == y) {
			return true;
		} else {
			return false;
		}
	}

	public double isThisSum(double x, double y) {
		return x+y;
	}

	public double isThisSubtract(double x, double y) {
		return x-y;
	}
	
	public double isThisMultiply(double x, double y) {
			return x*y;
	}
	
	public double isThisDivision(double x, double y) {
		return x/y;
	}
	
	public double isThisSquareRoot(int x) {
		return Math.sqrt(x);
	}

	/*
	 * WRITE METHODS AND TEST THEM: Sum method to add two integers
	 * Subtract method to subtract two integers 
	 * Multiplication 
	 * Division 
	 * Square Root etc.
	 */
}
