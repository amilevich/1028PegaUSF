package com.simulation.test;
import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;



public class TestSimulation {

	
	//##############################
	Bank test = new Bank();
	
	@BeforeClass
	public  static void runBeforeTestMethod() {
	    System.out.println("Unit testing starts");
	}
	
//	@Test(timeout=3)
//	public void AreEqual() {
//		assertEquals("Should return true: ", 5, test.sum(2,3));
//	}
//	
//	@Test(timeout=3)
//	public void existsTest() {
//		assertEquals("Should return true: ", true, test.Exists("dffd"));
//	}
	@Test(timeout=3)
	public void registerTest() {
		assertEquals("Should return true: ",true, test.Register(5,"f","dffd"));
		System.out.println("Test Succesfull");
	}
	@Test(timeout=3)
	public void withdrawTest() {
		assertEquals("Should return true: ",true, test.Withdraw("dffd",5.3));
		System.out.println("Test Succesfull");
	}
	@Test(timeout=3)
	public void depositTest() {
		assertEquals("Should return true: ",true, test.Deposit("f",5.4));
		System.out.println("Test Succesfull");
	}
	@Test(timeout=3)
	public void denyTest() {
		assertEquals("Should return true: ",true, test.Deny("f"));
		System.out.println("Test Succesfull");
	}
	@Test(timeout=3)
	public void joinTest() {
		assertEquals("Should return true: ",true, test.Join("f","fdf"));
		System.out.println("Test Succesfull");
	}
	@Test(timeout=3)
	public void cancelTest() {
		assertEquals("Should return true: ",true, test.Cancel("f"));
		System.out.println("Test Succesfull");
	}
	
	@AfterClass
	public static void runAfterTestMethod() {
	    System.out.println("End of the unit test");
	}
	
}

