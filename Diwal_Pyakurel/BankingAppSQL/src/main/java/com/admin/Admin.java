package com.admin;

import com.Methods.Methods;

import bankinterfaces.AdminInterfaces;
import bankinterfaces.CommonInterfaces;

public class Admin implements CommonInterfaces, AdminInterfaces {

	private String name;
	private int pinCode;

	public Admin() {
		super();
		this.name = "Mr Admin";
		this.pinCode = 1234;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public void deposit() {
		int accountNo = Methods.adminSelectsAccount();
		if (accountNo != 0) {
			float depositAmt = Methods.getFloatvalue("Please provide deposit amount");

			Methods.accts.addDeposit(accountNo, depositAmt);
			Methods.bankloggy.info("$" + depositAmt + " has been deposited on the account " + accountNo);

		}

	}

	public void withdrawl() {
		// TODO Auto-generated method stub
		int accountNo = Methods.adminSelectsAccount();
		if (accountNo != 0) {
			float withdrawlAmt = Methods
					.getFloatvalue("Please specify the amount you want to withdraw on this account");
			Methods.accts.withdraw(accountNo, withdrawlAmt);
			Methods.bankloggy.info("$" + withdrawlAmt + " has been withdraw on the account " + accountNo);

		}

	}

	public void transfer() {
		System.out.println("Please select the accont where you want to withdraw money");
		int withdrawingAccount = Methods.adminSelectsAccount();
		if (withdrawingAccount != 0) {

			System.out.println("Please select the accont where you want to transfer money");
			int depositingAccount = Methods.adminSelectsAccount();
			if (depositingAccount != 0) {
				float amt = Methods.getFloatvalue("Specify the amount for transfer");

				Methods.accts.transfer(withdrawingAccount, depositingAccount, amt);
				Methods.bankloggy.info("$" + amt + " has been deposited on the account " + depositingAccount);
				Methods.bankloggy.info("$" + amt + " has been withdrawn from the account " + withdrawingAccount);
			}

		}
	}

	public void viewAccount() {

		Methods.accts.viewAll();

	}

	public void deleteAccount() {
		System.out.println("Please provide the account number you want to delete");
		int accountNo = Methods.adminSelectsAccount();

		Methods.accts.deleteAccount(accountNo);

	}

	public void approveAccount() {

		Methods.approvalOfAccounts();

	}

}
