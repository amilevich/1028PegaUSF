package com.example.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.calulator.Calculator;

public class CalculatorTest {

	
	/*
	 * Junit - Java unit testing framework.
	 * 
	 * Unit testing - testing a small portion of your program, typically, a method
	 * 
	 * TDD - test driven development, means writing your tests before you write your code
	 * 
	 * Benefits:
	 * 1. planning - it requires you to think/plan what you want form each peice of code
	 * 2. reusability
	 * 3. modularity 
	 * 4. High quality
	 * 5. scalability
	 * 
	 * JUnit provides us with static methods that come from 
	 * orf.junit.assert class to test fo certain conditions
	 * 
	 * These methods usually start with "Assert" and let you specify 
	 * an error message, the expected result, and the actual result.
	 * If the test fails, the Assert method will throw you an 
	 * AssertionException.
	 */
	
	Calculator calc = new Calculator();
	
	@Test
	public void areTwoIntegersEqual() {
		assertEquals("should retrun true", true, calc.areTwoIntegersEqual(4, 4));
	}
	@Test
	public void isThisSum() {
		assertEquals("should retrun true", true, calc.isThisSum(4, 4, 8));
	}
	@Test
	public void isThisSubtract() {
		assertEquals("should retrun true", true, calc.isThisSubtract(4, 4, 0));
	}
	
	@Test
	public void isThisMultiply() {
		assertEquals("should retrun true", true, calc.isThisMultiply(4, 4, 16));
	}
	@Test
	public void isThisDivision() {
		assertEquals("should retrun true", true, calc.isThisDivision(4, 4, 1));
	}
	@Test
	public void isThisSquareRoot() {
		assertEquals("should retrun true", true, calc.isThisSquareRoot(4, 2));
	}
	
}
