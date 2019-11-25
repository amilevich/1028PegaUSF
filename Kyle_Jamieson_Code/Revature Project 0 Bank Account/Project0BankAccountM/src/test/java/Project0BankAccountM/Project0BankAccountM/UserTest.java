package Project0BankAccountM.Project0BankAccountM;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;

public class UserTest 
{
	static User user = null;
	
	@BeforeClass
	static public void setUp()
	{
		user = new User("user","123456",User.getCustomerCode(),"john","doe",10);
	}
	@Test
	public void testGetUserType()
	{
		assertEquals("getUserType: should return "+User.getCustomerCode(), User.getCustomerCode(), user.getUserType());
	}
	
	@Test
	public void testGetUserName()
	{
		assertEquals("getUserName: should return user", "user", user.getUserName());
	}
	
	@Test
	public void testGetPassword()
	{
		assertEquals("getPassword: should return 123456", "123456", user.getPassword());
	}
	
	@Test
	public void testGetAccountNumber()
	{
		assertEquals("getAccountNumber: should return 10", 10, user.getAccountNumber());
	}

	@Test
	public void testGetFirstName()
	{
		assertEquals("getFirstName: should return john", "john", user.getFirstName());
	}

	@Test
	public void testGetLastName()
	{
		assertEquals("getLastName: should return doe", "doe", user.getLastName());
	}

	@AfterClass
	static public void shutDown()
	{
		user = null;
	}

}
