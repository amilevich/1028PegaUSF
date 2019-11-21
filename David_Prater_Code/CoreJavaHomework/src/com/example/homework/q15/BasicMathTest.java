package com.example.homework.q15;

import static org.junit.Assert.*;

import org.junit.Test;

public class BasicMathTest {
	
	MathImplementation math = new MathImplementation();

	@Test
	public void testAddition() {
		assertEquals(5, 3, 2);
	}
	
	@Test
	public void testSubtraction() {
		assertEquals(9, 15, 6);
	}

}
