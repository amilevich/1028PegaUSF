package com.example.mathinterface;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MathOPImplTest {
	
	MathOpImp mop = new MathOpImp();
 	
	@Test
	public void multiplicationTest() {
		assertEquals("ok", 9, mop.multiplication(3,3));
	}
	
	@Test
	public void divisionTest() {
		assertEquals("ok", 1, mop.division(3,3));
	}

}
