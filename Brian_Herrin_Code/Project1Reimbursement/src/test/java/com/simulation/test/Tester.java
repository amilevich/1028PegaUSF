package com.simulation.test;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Tester {

		
		//##############################
		TestDaos test = new TestDaos();
		
		@BeforeClass
		public  static void runBeforeTestMethod() {
		    System.out.println("Unit testing starts");
		}
		
		@Test(timeout=3)
		public void Test1() {
			assertEquals("Should return true: ", true, test.updateUsers("dfd"));
			System.out.println("Test Succesfull");
		}
		@Test(timeout=3)
		public void Test2() {
			assertEquals("Should return true: ", true, test.updateReimbursements(5,"ali","ali","ali","ali","ali",6));
			System.out.println("Test Succesfull");
		}
		@Test(timeout=3)
		public void Test3() {
			assertEquals("Should return true: ", true, test.approveReimb("dfd"));
			System.out.println("Test Succesfull");
		}
		@Test(timeout=3)
		public void Test4() {
			assertEquals("Should return true: ", true, test.denyReimb("dfd"));
			System.out.println("Test Succesfull");
		}
		

	}

