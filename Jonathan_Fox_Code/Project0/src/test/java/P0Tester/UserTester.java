package P0Tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import Banking.User;

public class UserTester {
	
	@Before
	public void init() {
	}
	
	@Test
	public void userTest() {
		User u = null;
		
		try {
			u = new User((byte)3, "TestUser5191974114651991651965651946251984165", "Password0");
			fail("User Improperly Created.\n");
		
		}
		catch (InstantiationException e) {}
		
		try {
			u = new User((byte)0, "4510590.02985", "Password0");
			fail("User Improperly Created.\n");
		}
		catch (InstantiationException e) {}
		
		try { u = new User((byte)0, "TestUser5191974114651991651965651946251984165", "Password0"); }
		catch (InstantiationException e) { fail("User Instantiation Exception"); }
		
		assertEquals(u.typeString(), "User");
		
		try { u = new User((byte)1, "TestUser4561846216984121868218955984165", "Password1"); }
		catch (InstantiationException e) { fail("User Instantiation Exception"); }
		
		assertEquals(u.typeString(), "Employee");
		
		try { u = new User((byte)2, "TestUser655216516479451669845684846515", "Password2"); }
		catch (InstantiationException e) { fail("User Instantiation Exception"); }
		
		assertEquals(u.typeString(), "Admin");
		
		
		assertTrue(u.addAccount(0));
		assertTrue(u.addAccount(1));
		assertFalse(u.addAccount(1));
		
		assertTrue(u.getAccounts().contains(0));
		assertTrue(u.getAccounts().contains(1));
		assertFalse(u.getAccounts().contains(2));
		
		assertTrue(u.removeAccount(0));
		assertTrue(u.removeAccount(1));
		assertFalse(u.removeAccount(1));
		assertFalse(u.removeAccount(2));
		
		assertEquals(u.getUsername(), "TestUser655216516479451669845684846515");
		assertEquals(u.getPass(), "Password2");
		assertEquals(u.getType(), (byte)2);
		
		u.setInfo("info");
		assertEquals(u.getInfo(), "info");
		assertTrue(u.login("Password2"));
		assertFalse(u.login("notPass"));
		
		
	}
	
}
