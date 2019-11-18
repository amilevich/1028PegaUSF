package com.project.saintsbanktest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.project.saintsbank.Customer;

public class CustomerQuality {

	
	Customer Test = new Customer();
	
	@Test
	public void isApprovalStatus() {
		assertEquals("Should be false",false, Test.isApprovalStatus());
	}
}
