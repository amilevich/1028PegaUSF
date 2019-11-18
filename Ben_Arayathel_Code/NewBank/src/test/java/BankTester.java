import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

import com.backend.Account;
import com.backend.AccountManagement;

public class BankTester {
	
//	@Test
//	public void firstTest() {
//		assertEquals(0, 0);
//		System.out.println("test 1");
//	}
	
	@Test
	public void tetGetAccount() {
		Scanner in = new Scanner(System.in);
		Account testaccount = new Account("ben","pass","benpass",0.0);
		AccountManagement.storageAccount.put(testaccount.getiD(),testaccount);
		assertEquals(AccountManagement.getAccount(in), testaccount);
		AccountManagement.storageAccount.remove(testaccount.getiD());
	}
	
	@Test
	public void testTransferGetAccount() {
		Scanner in = new Scanner(System.in);
		Account testaccount = new Account("ben","pass","benpass",0.0);
		AccountManagement.storageAccount.put(testaccount.getiD(),testaccount);
		assertEquals(AccountManagement.getAccountTransfer(in), testaccount);
		AccountManagement.storageAccount.remove(testaccount.getiD());
	}

}
