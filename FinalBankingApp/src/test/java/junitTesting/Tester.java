package junitTesting;

import com.app.main.JunitTest;

public class Tester {
	
	JunitTest test = new JunitTest(); 
	
	public void runCmenu() {
		assertEquals("I should return pass", "pass", test.runCmenu("1"));
	}
	
	public void runAmenu {
		assertEquals("I should return pass", "pass", test.runAmenu("1"));
	}
	
	
	
	

}
