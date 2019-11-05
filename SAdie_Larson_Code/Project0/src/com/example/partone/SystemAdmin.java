package com.example.partone;

import java.util.HashMap;

public class SystemAdmin extends Employee { 
	public SystemAdmin(HashMap<Integer, Account> bankAccounts) {
		super(bankAccounts);
		// TODO Auto-generated constructor stub
	}

// should be able to view and edit everything

	/*public SystemAdmin(HashMap<Integer, SystemAdmin> bankAccounts) {
		super(bankAccounts);
		// TODO Auto-generated constructor stub
	}

	// from employee
	/*
	 * view account approve account

	@Override
	public void viewApp() {
		if (!this.accountHolder) {
			System.out.println("Current status is: ");
			if (this.applicationStatus == 0) {
				System.out.println("Pending approval");
				setAccountStatus();
			}
			if (this.applicationStatus == 1) {
				System.out.println("This account is currently active");
				System.out.println("Do you want to edit the account status");
				
			} else {
				System.out.println("This account was denied");
			}
		}
	}

	@Override
	void setAccountStatus() {
		if (!accountHolder) { // account status still pending or was denied/cancelled
			if (applicationStatus == 2) {
				System.out.println("Application was previously denied or cancelled");
				System.out.println("Do you want to re-approve the account?");
			} else {
				System.out.println("Do you want to approve the account?");
			}

			System.out.println("Please enter Yes or No");
			while (!validInput) {
				yn = sc.nextLine();
				if ((yn == "Yes") || (yn == "No")) {
					break;
				} else {
					System.out.println("Invalid input. Please enter Yes or No");
				}
			}
			if (yn == "Yes") {
				applicationStatus = 1;
			} else if (yn == "No") {
				applicationStatus = 2; // denied
			}
		} else if (accountHolder) { // disable approved account
			System.out.println("The current status is: " + applicationStatus);
			System.out.println("Do you want the account to cancel the account?");
			System.out.println("Please enter Yes or No");
			while (!validInput) {
				yn = sc.nextLine();
				if ((yn == "Yes") || (yn == "No")) {
					break;
				} else {
					System.out.println("Invalid input. Please enter Yes or No");
				}
			}
			if (yn == "Yes") {
				applicationStatus = 2; // cancelled account
				accountHolder = false;
			} else if (yn == "No") {
				applicationStatus = 1; // decided to keep account active
				accountHolder = true;
			}
		} else { // not an account holder and application status was denied/cancelled
			System.out.println("Error occurred. AccountHolder cna only be true or false");
		}
	}
	*/

	// from account
	/*
	 * can set username can set password
	 */

	// from client
	/*
	 * can set account balance
	 */

}
