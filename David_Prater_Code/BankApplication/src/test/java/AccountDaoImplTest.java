import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.bank.dao.AccountDaoImpl;
import com.bank.model.Account;

public class AccountDaoImplTest {

	static AccountDaoImpl daoImlp = new AccountDaoImpl();
	static Account account = new Account(1, "123456", 50, "David", "Prater", "096 William", "david", "password");
	static Account testAccount;
	static Account testAccount2;

	@Test
	public void insertAccountTest() {
		AccountDaoImpl.insertAccount(account);
		List<Account> testList = AccountDaoImpl.selectAllAccounts();
		int accountLength = testList.size();
		assertEquals("Should be three", 7, accountLength);
	}

	@Test
	public void selectAccountByNumberTest() {
		testAccount = AccountDaoImpl.selectAccountByID("david");
		assertEquals("Should be equal", "david", AccountDaoImpl.selectAccountByID("david").getFirstName());
	}

	@Test
	public void selectAccountByIDTest() {
		testAccount = AccountDaoImpl.selectAccountByNumber("42864");
		assertEquals("Should be equal", "david", AccountDaoImpl.selectAccountByNumber("42864").getFirstName());
	}

	@Test
	public void selectAllAccounts() {
		List<Account> testList = AccountDaoImpl.selectAllAccounts();
		int accountLength =testList.size();
		
		assertEquals("Should be three", 6, accountLength);

	}

	@Test
	public void updateAccountTest() {
		testAccount = AccountDaoImpl.selectAccountByNumber("42864");
		AccountDaoImpl.updateAccount(testAccount);
	}

	@Test
	public void deleteAccountTest() {
		testAccount = AccountDaoImpl.selectAccountByNumber("123456");
		AccountDaoImpl.deleteAccount(testAccount);
		List<Account> testList = AccountDaoImpl.selectAllAccounts();
		int accountLength =testList.size();
		assertEquals("Should be three", 5, accountLength);
	}

}
