package P0Tester;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import Banking.Account;
import Banking.Bank;
import Banking.User;

public class BankTester {
	static Bank c;
	
	@BeforeClass
	public static void init() throws InstantiationException, IOException {
		c = new Bank("BankInfo.txt");
	}
	
	
	@Test
	public void bankTest() throws InstantiationException {
		User u0, u1, u2;
		Account a1, a2;
		
		u0 = null;
		try{ u0 = new User((byte)0, "TestUser129385410298357091823", "Password0"); }
		catch(InstantiationException e) { fail("u2 Instantiation Exception"); }
		
		u1 = null;
		try{ u1 = new User((byte)1, "TestEmployee120938570112341235", "Password1"); }
		catch(InstantiationException e) { fail("u1 Instantiation Exception"); }
		
		u2 = null;
		try{ u2 = new User((byte)2, "TestAdmin10945810293580192385", "Password2"); }
		catch(InstantiationException e) { fail("u2 Instantiation Exception"); }
		
		a1 = new Account(-1);
		a2 = new Account(-2);
		
		if(a1 == null || a2 == null) fail("Account Instantiation Fail");
		
		assertTrue(c.addUser(u0));
		assertTrue(c.addUser(u1));
		assertTrue(c.addUser(u2));
		assertFalse(c.addUser(u2));
		
		assertTrue(c.getUser(u0.getUsername()) == u0);
		assertFalse(c.getUser(u1.getUsername()) == u2);
		assertTrue(c.getUser("1") == null);
		
		assertTrue(c.addAccount(a1));
		assertTrue(c.addAccount(a2));
		assertFalse(c.addAccount(a2));
		
		assertTrue(c.getAccount(-1) == a1);
		assertFalse(c.getAccount(-2) == a1);
		assertTrue(c.getAccount(-3) == null);
		
		assertTrue(c.link(u0, a1));
		assertTrue(c.link(u1, a1));
		assertTrue(c.link(u2, a1));
		
		assertTrue(c.link(u0, a2));
		assertTrue(c.link(u1, a2));
		assertTrue(c.link(u2, a2));
		
		assertFalse(c.link(u0, a1));
		
		assertTrue(u0.getAccounts().contains(-2));
		assertTrue(u1.getAccounts().contains(-2));
		assertTrue(u2.getAccounts().contains(-2));
		
		assertFalse(c.removeAccount(-3));
		assertTrue(c.removeAccount(-2));
		
		assertFalse(u0.getAccounts().contains(-2));
		assertFalse(u1.getAccounts().contains(-2));
		assertFalse(u2.getAccounts().contains(-2));
		
		assertTrue(c.getUsers().contains(u0.getUsername()));
		
		assertTrue(c.getAccounts().contains(a1.getID()));
		assertFalse(c.getAccounts().contains(a2.getID()));
		
	}
}
