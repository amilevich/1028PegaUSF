package project0;


import org.junit.Test;

import com.project0.Account;

public class Project0Test {
	Account c = new Account();
	
	
	@Test
public void firstTest () {
		c.deposit(45);

	}
	
	@Test
	public void seconTest() {
		c.withdraw(20);
		 	}
}
	