package com.examples.p0;
import java.io.IOException;

public class MainDriver {
	public static void main(String[] args) throws IOException {
		System.out.println("==========================");
		System.out.println("\n Welcome to Revature Bank \n");
		System.out.println("==========================");
		Bank gb = Bank.getBank();
		int input1 = 0;
		int input2 = 0;
		int input3 = 0;
		do {
			showStartMenu();
			input1 = Excptns.integerInput();
			if (input1 == 1) {
				do {
					showUserMenu();
					input2 = Excptns.integerInput();
					if (input2 == 1) {
						Customer cust = gb.accountLogin();
						if (cust == null) {
						
						} else {
							do {
								showCustomerMenu();
								input3 = Excptns.integerInput();
								if (input3 == 1) { // open account
									cust.openNewAccount();
								} else if (input3 == 2) { // deposit money
									Account temp = cust.getAccount();
									if (temp == null) {
									} else {
										temp.deposit();
									}
								} else if (input3 == 3) {// withdraw
									Account temp = cust.getAccount();
									if (temp == null) {
									} else {
										temp.withdraw();
									}
								} else if (input3 == 4) {// check account
									Account temp = cust.getAccount();
									if (temp == null) {
									} else {
										temp.showAccountDetails();
									}
								} else if (input3 != 0) {
									System.out.println("Please select one of the above option");
								}
							} while (input3 != 0);
						}
					} else if (input2 == 2) {
						gb.addSingleCustomers();
					} else if( input2 == 3) {
						gb.addJointCustomers();
					} else if (input2 != 0) {
						System.out.println("Please select one of the above option");
					}
				} while (input2 != 0);
			} else if (input1 == 2) {
				Admin admin = gb.adminLogin();
				if (admin == null) {
				} else {
					do {
						System.out.println("============================");
						System.out.println("\n Welcome to the admin menu! \n");
						System.out.println("============================");

						
						showAdminMenu();
						input2 = Excptns.integerInput();
						if (input2 == 1) {
							gb.showBankDetails(admin);
						} else if (input2 == 2) {
							gb.approveAccounts(admin); 
						} else if (input2 == 3) {
							gb.showAllAccounts(admin);
						} else if (input2 != 0) {
							System.out.println("Please enter one of the options above");
						}
					} while (input2 != 0);
				}
			} else if (input1 == 3) {
				Employee employee = gb.employeeLogin();
				if (employee == null) {
				} else {
					do {
						System.out.println("===============================");
						System.out.println("\n Welcome to the employee menu! \n");
						System.out.println("===============================");

						
						showEmployeeMenu();
						input2 = Excptns.integerInput();
						if (input2 == 1) {
							gb.showBankDetails(employee);
						} else if (input2 == 2) {
							gb.approveAccounts(employee);
						} else if (input2 == 3) {
							gb.showAllAccounts(employee);
						} else if (input2 != 0) {
							System.out.println("Please enter one of the options above");
						}
					} while (input2 != 0);
				}
			} else if (input1 != 0) {
				System.out.println("Please enter one of the options above");
			}
		} while (input1 != 0);
	}

	public static void showStartMenu() {
		System.out.println();
		System.out.println("Press 1 if you are a user");
		System.out.println("Press 2 if you are a admin");
		System.out.println("Press 3 if you are an Employee");
		System.out.println("Press 0 to exit");
	}

	public static void showAdminMenu() {
		System.out.println();
		System.out.println("Press 1 to show bank details");
		System.out.println("Press 2 to approve accounts");
		System.out.println("Press 3 to show all Accounts");
		System.out.println("Press 0 to go to previous menu.");
	}
	
	public static void showEmployeeMenu() {
		System.out.println();
		System.out.println("Press 1 to show bank details");
		System.out.println("Press 2 to approve accounts");
		System.out.println("Press 3 to show all Accounts");
		System.out.println("Press 0 to go to previous menu.");
	}

	public static void showUserMenu() {
		System.out.println();
		System.out.println("Press 1 if you are already a customer of our bank");
		System.out.println("Press 2 to register a single account");
		System.out.println("Press 3 to register a joint account");
		System.out.println("Press 0 to go back to previous menu");
	}

	public static void showCustomerMenu() {
		System.out.println();
		System.out.println("Press 1 to open a new account");
		System.out.println("Press 2 to deposit money");
		System.out.println("Press 3 to withdraw money");
		System.out.println("Press 4 to check account balance");
		System.out.println("Press 0 to go to previous menu");
	}
}
