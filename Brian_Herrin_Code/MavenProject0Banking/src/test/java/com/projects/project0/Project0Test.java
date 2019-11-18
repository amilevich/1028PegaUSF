package com.projects.project0;

import static org.junit.Assert.*;

import org.junit.Test;

public class Project0Test {
	// getters and setters do not need to be tested.
	// Told roughly half of methods need testing
		// test your written methods
		/*
		// @Test
		// @before -
		// @after -
		// @beforeClass -
		// @afterClass -
		// @ignore -
		*/
	@Test
	public void isEqualToString() {
		String i = "Wally", j = "Wally";
		assertEquals("MainDriver isEqualToString: true ", true, MainDriver.isEqualToString(i, j));
		i = "Wally"; 
		j = "Waldo";
		assertEquals("MainDriver isEqualToString: false ", false, MainDriver.isEqualToString(i, j));
	}
	
	@Test
	public void isNegative() {
		double i = -0.6;
		assertEquals("MainDriver isNegative: true ", true, MainDriver.isNegative(i));
		i = 0.6;
		assertEquals("MainDriver isNegative: false ", false, MainDriver.isNegative(i));
	}
}
