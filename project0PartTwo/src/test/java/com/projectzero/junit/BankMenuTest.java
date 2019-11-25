package com.projectzero.junit;

import org.junit.Test;

import com.projectzero.menu.BankMenu;

public class BankMenuTest {
	BankMenu bk = new BankMenu();
	@Test
	public void testBankMenu() {
		
		bk.bankMenu();
	}
}
