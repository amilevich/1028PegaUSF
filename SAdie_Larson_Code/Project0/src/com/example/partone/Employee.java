package com.example.partone;

public class Employee extends Client {

	void viewApp() {
		if (!this.accountHolder) {
			System.out.println("Current status is:");
			if (this.applicationStatus == 0) {
				System.out.println("Pending approval");
				setAccountStatus();
			}
			if (this.applicationStatus == 1) {
				System.out.println("This account is currently active");
			} else {
				System.out.println("This account was denied");
			}
		}
	}

	void setAccountStatus() {
		System.out.println("Current status is: " + applicationStatus); //currently only will be pending as empoyee can't go in to edit anythign else
		System.out.println("Do you wnat to approve the account?");
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
			this.applicationStatus = 1; // approved
			this.accountHolder = true;
			
		} else if (yn == "No") {
			applicationStatus = 2; // denied
		}
	}

	void viewAccount() {
		System.out.println("Please enter account username to view");
		while (!validInput) {
			accountCur = sc.nextLine();
			// if account not an option
			System.out.println("Please enter a valid account");
			// else
			break;
		}
		validInput = false;
		// show all attributes of account
		System.out.println("Username: " + this.getUsername());
		System.out.println("Password: " + this.getPassword());
		System.out.println("Name: " + this.getfName() + " " + this.getlName());
		System.out.println("Birth date: " + this.getBirthM() + "/" + this.getBirthD() + "/" + this.getBirthY());
		System.out.println("List of accounts and their amount" + accounts);
	}

}
