package com.example.junit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.Junit.Junit;

public class Part0Test {

	Junit j = new Junit();

	@Test
	public void isAVaildNumber() {
		assertEquals("should retrun true", 1, j.checkAmount("900.05"));
		assertEquals("should retrun true", 0, j.checkAmount("-9"));
		assertEquals("should retrun true", 0, j.checkAmount("Hello"));
	}

	@BeforeClass
	public static void methodCalledBeforeAllOther() {
		System.out.println("*********************Welcome to Junit*********************");
	}

	@After
	public void methodCalledAfterEveryMethod() {
		System.out.println("*********************Method Completed*********************");
	}

	@AfterClass
	public static void methodCalledAfterAllOther() {
		System.out.println("*********************Finished Junit*********************");
	}

}
