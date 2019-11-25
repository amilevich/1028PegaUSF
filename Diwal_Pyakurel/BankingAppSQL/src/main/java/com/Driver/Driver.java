package com.Driver;

import com.Methods.Methods;

public class Driver {

	public static void main(String[] args) {

		System.out.println("Welcome to Bank");

		boolean exit = true;
		while (exit) {

			String userStatus = Methods.firstQuestion();
			Methods.bankloggy.info(userStatus + "logs in");

			if (userStatus.equals("customer")) {
				Methods.customerOptions();
			} else if (userStatus.equals("admin")) {
				Methods.adminOptions();
			} else if (userStatus.equals("employee")) {
				Methods.employeeOptions();
			} else if (userStatus.equals("exit")) {
				System.out.println("Have a nice day");
				exit = false;
			} else {
				System.out.println("Not a valid response");
			}

		}

	}

}

/*
 * Logic for the applications
 *
 * Two classes: Accounts and Profiles Accounts will have linked SSN. Can have
 * multiple SSN Profiles will have SSN and Linked Accounts
 *
 * When user create a new account, will be in pending state and admin needs to
 * verify Once verified, Account will be created and SSN will be added to
 * acounts and Acct Number will be linked to Profiles
 *
 * Once approved, customer needs to login When they login, based on SSN, profile
 * will be pulled and based on profile, all the related accounts will be pulled
 *
 * Once pulled, customer can work on their accounts
 *
 * Admin and Employee can make deposit or withdraw on any accounts Admin can
 * delete accounts as well
 */
