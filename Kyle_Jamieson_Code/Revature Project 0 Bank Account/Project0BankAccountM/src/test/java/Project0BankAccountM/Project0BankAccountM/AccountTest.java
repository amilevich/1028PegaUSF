package Project0BankAccountM.Project0BankAccountM;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;

import Project0BankAccountM.Project0BankAccountM.Account.FLAGS;

public class AccountTest 
{
	public static Account account = null;
	
	@BeforeClass
	public static void startUp()
	{
//		public Account(int _nAccountNumber, short _nFlags, String _fname1, String _lname1, String _fname2, 
//				String _lname2, int _nSSN1, int _nSSN2, double _nSavingBalance, double _nCheckBalance,
//				double _nLoanBalance) 
		account = new Account(10, (short)101, "johe", "doe", "jane", "smith", 123, 456, 90.7, 32.4, 76.0);
	}
	
	@Test
	public void testGetAccountNumber() 
	{
		assertEquals("getAccountNumber: should return 10", 10, account.getAccountNumber());
	}
	@Test
	public void testGetFirstName1() 
	{
		assertEquals("getFirstName1: should return john", "john", account.getFirstName1());
	}
	@Test
	public void testGetLastName1() 
	{
		assertEquals("getLastName1: should return doe", "doe", account.getLastName1());
	}
	@Test
	public void testGetFirstName2() 
	{
		assertEquals("getFirstName2: should return jane", "jane", account.getFirstName2()); 
	}
		
	@Test
	public void testGetLastName2() 
	{
		assertEquals("getLastName2: should return smith", "smith", account.getLastName2());
	}
	
	@Test
	public void testGetSaveBalance() 
	{
		assertEquals("getSaveBalance: should return 90.7", 90.7, account.getSaveBalance());
	}
	@Test
	public void testGetCheckBalance() 
	{
		assertEquals(32.4, account.getCheckBalance());
	}
	@Test
	public void testGetLoanBalance() 
	{
		assertEquals("getLoanBalance: should return 76.0", 76.0, account.getLoanBalance());
	}
	@Test
	public void testGetFlags() 
	{
		assertEquals("getFlags: should return 101", (short)101, account.getFlags());
	}
	@Test
	public void testGetSSN1() 
	{
		assertEquals("getSSN1: should return 123", 123, account.getSSN1());
	}
	@Test
	public void testGetSSN2() 
	{
		assertEquals("getSSN2: should return 456", 456, account.getSSN2());
	}

	@AfterClass
	public static void shutDown()
	{
		account = null;
	}
	
}
