package com.simulation.test;
import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bank.simulation.Bank;



public class TestSimulation {

	
	Bank bank = new Bank();
	
	@BeforeClass
	public  static void runBeforeTestMethod() {
	    System.out.println("Unit testing starts");
	}
	
	@Test(timeout=3)
	public void AreEqual() {
		assertEquals("Should return true", 5, bank.sum(2,3));
	}

	//Causes a test to fail if it takes longer than a specified amount of clock time
//	@Test(timeout=100) 
//	public void infinity() {
//	       while(true);
//	}
	@AfterClass
	public static void runAfterTestMethod() {
	    System.out.println("End of the unit test");
	}
	
}

