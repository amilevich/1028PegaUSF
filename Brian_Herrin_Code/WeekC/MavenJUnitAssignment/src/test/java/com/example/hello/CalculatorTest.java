package com.example.hello;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
	// getters and setters do not need to be tested.
	// test your written methods
	@Test
	public void isTwoIntegersEqual() {
		int i = 0, j = 0;
		Calculator calc = new Calculator();
		
		assertEquals("Calculator isTwoIntegersEqual: true ", true, calc.isTwoIntegersEqual(i, j));
	}
	
	@Test
	public void sum() {
		int i = 1, j = 5;
		Calculator calc = new Calculator();
		
		assertEquals("Calculator sum: 6 ", 6, calc.sum(i, j));
	}
	
	@Test
	public void subtract() {
		int i = 7, j = 1;
		Calculator calc = new Calculator();
		
		assertEquals("Calculator subtract: 6 ", 6, calc.subtract(i, j));
	}
	
	@Test
	public void multiplication(){
		int i = 5, j = 5;
		Calculator calc = new Calculator();
		
		assertEquals("Calculator multiplication: 25 ", 25, calc.multiplication(i, j));
	}
	
	@Test
	public void division(){
		int i = 5, j = 5;
		Calculator calc = new Calculator();
		
		assertEquals("Calculator division int: 1 ", 1, calc.division(i, j));
		
		double k = 5.0, l = 5.0;
		assertEquals(1.0, calc.division(k,l), 0.1);
	}
	
	@Test
	public void squareRoot() {
		double i = 25.0;
		Calculator calc = new Calculator();
		
		assertEquals(5.0, calc.squareRoot(i), 0.1);
	}
	
	@Test
	public void exponents() {
		double i = 2,  j = 4;
		Calculator calc = new Calculator();
		
		assertEquals(16.0, calc.exponents(i, j), 0.1);
	}
}
