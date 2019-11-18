package P0Tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Banking.Account;

public class AccountTester {

	@Test
	public void accountTest() {
		Account a;
		
		a = new Account(0);
		assertTrue(a != null);
		
		assertFalse(a.isApproved());
		assertFalse(a.deposit(10));
		assertFalse(a.withdraw(10));
		assertEquals(a.getBalance(), 0, 0);
		
		
		a.approve();
		assertTrue(a.isApproved());
		assertEquals(a.getID(), 0);
		assertFalse(a.getID() == 1);
		assertTrue(a.deposit(100.5));
		assertTrue(a.withdraw(10.1));
		assertFalse(a.withdraw(1000));
		assertFalse(a.deposit(-1));
		assertFalse(a.withdraw(-1));
		assertEquals(a.getBalance(), 90.4, 0);
		
		assertTrue(a.addUser("user0"));
		assertTrue(a.addUser("user1"));
		assertFalse(a.addUser("user1"));
		
		assertTrue(a.getUsers().contains("user0"));
		assertFalse(a.getUsers().contains("user2"));
		
		assertTrue(a.removeUser("user0"));
		assertFalse(a.removeUser("user0"));
		
	}
}
