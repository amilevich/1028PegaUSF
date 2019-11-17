package com.example.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import com.example.calculator.Calculator;

public class CalculatorTest {
	/*
	 * JUnit - Java Unit testing framework
	 * 
	 * Unit testing - testing a small portion of your program, typically, a method.
	 * 
	 * TDD - Test Driven Development, write test before code
	 * 
	 * Benefits:
	 * 1. Planning - it requires think / plan what you want from each piece of code
	 * 2. Reusability
	 * 3. Modularity
	 * 4. Higher Quality
	 * 5. Scalibility
	 * 
	 * Junit provides static methods from org.junit.assert class to trst for certain conditions
	 * 
	 * These methods usually start with "assert" and let you specify error message the expected result, and
	 * the actual result. If test fails, the Assert Method will throw you an AssertionException
	 */
	
	Calculator calc = new Calculator();
	
	@Test
	public void areTwoIntegersEqual() {
		assertEquals("should return true", true, calc.areTwoIntegersEqual(4, 3));
	}
	@Test
	public void add() {
		assertEquals();
	}
	
	
}
