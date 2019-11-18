package part1;

import org.apache.log4j.Logger;

public class Menus {
	final static Logger eventLogger= Logger.getLogger(Menus.class);
	
	static void displayClientMenu() {
		System.out.println("\n\n Client Options: ");
		System.out.println("1. View Account(s)\n2. Make Deposit.\n3. Make Withdrawal.\n4. Transfer Funds.\n5. Exit.");
	}
	static void displayWelcomeMenu() {
		System.out.println("\n\n\n\n\n\n\n\nWelcome to the Bank of Batch!\n");
		System.out.println("1. Client Log In\n2. Employee Log In\n3. Admin Log In\n4. Sign up\n5. Exit");
	}
	static void displayEmployeeMenu() {
		System.out.println("\n\nEmployee Options:\n");
		System.out.println("1. View Accounts\n2. Manage Accounts\n3. View Clients\n4. Exit");
	}
	static void displayAdminMenu() {
		System.out.println("\n\nAdministration Options:\n");
		System.out.println("1. View Accounts\n2. Manage Accounts\n3. View Clients\n4. Deposit\n5. Withdraw\n6. Transfer\n7. Exit");
	}
	public static void displayAcctManagement() {
		System.out.println("\n\nAccount Management:");
		System.out.println("1. Approve Pending Accounts\n2. Deny Pending Accounts\n3. Cancel Existing Accounts\n4. Exit");
	}
}