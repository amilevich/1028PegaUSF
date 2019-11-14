package com.example.calulator;

public class Calculator {
	public boolean areTwoIntegersEqual(int x, int y) {
		if (x == y) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isThisSum(int x, int y, int z) {
		if ((x + y) == z) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isThisSubtract(int x, int y, int z) {
		if ((x - y) == z) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isThisMultiply(int x, int y, int z) {
		if ((x * y) == z) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isThisDivision(int x, int y, int z) {
		if ((x / y) == z) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isThisSquareRoot(int x, int y) {
		if (Math.sqrt(x) == y) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * WRITE METHODS AND TEST THEM: Sum method to add two integers
	 * Subtract method to subtract two integers 
	 * Multiplication 
	 * Division 
	 * Square Root etc.
	 */
}
