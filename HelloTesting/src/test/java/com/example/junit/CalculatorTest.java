package com.example.junit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.calculator.Calculator;

public class CalculatorTest {
	
	/*
	 * JUnit - Java unit testing framework.
	 * 
	 * Unit testing - testing a small portion of your program, typically,
	 * a method.
	 * 
	 * TDD - Test Driven Development, means writing your tests before you
	 * write your code.
	 * 
	 * Benefits:
	 * 1) Planning/Designing - it requires you to think/plan what you want 
	 * from each piece of code
	 * 2) Reusability
	 * 3) Modularity
	 * 4) Higher Quality
	 * 5) Scalibility
	 * 
	 * JUnit provides us with static methods that come from
	 * org.junit.assert class to test for certain conditions
	 * 
	 * These methods usually start with "assert" and let you specify
	 * an error message, the expected result, and the actual result.
	 * If the test fails, the Assert method will throw you an 
	 * AssertionException.
	 */
	
	Calculator calc = new Calculator();
	
	@Test
	public void areTwoIntegersEqual() {
		assertEquals("should return true", true, calc.areTwoIntegersEqual(4, 4));
		System.out.println("test 1");
	}
	
	
	@Test
	public void areTwoIntegersEqual2() {
		assertEquals("should return true", true, calc.areTwoIntegersEqual(4, 4));
		System.out.println("test 2");
	}
	
	
	/*
	 * @Ignore - ignores the method test that has this annotation
	 * @After - have a method that will run after each test
	 * @Before - have a method that will run before each test
	 * @AfterClass - have a method that will run after the whole class
	 * @BeforeClass - have a method that will run before the whole class
	 */
	
	@After
	public void afterMethod() {
		System.out.println("************after each method************");
	}
	
	@BeforeClass
	public static void methodCalledBeforeAllTests() {
		System.out.println("****WELCOME TO JUNIT****");
	}

}
