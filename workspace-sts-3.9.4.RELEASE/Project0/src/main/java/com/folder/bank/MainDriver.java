package com.folder.bank;


public class MainDriver extends Accounts {

	public static void main(String[] args) {
		Accounts.cusDao.selectAllCustomers();
		menu();
	}

}
