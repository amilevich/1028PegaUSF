package part2;

import org.apache.log4j.Logger;

public class Menus {
	final static Logger eventLogger= Logger.getLogger(Menus.class);
	
	static void displayClientMenu() {
		System.out.println("\n\n Client Options: ");
		System.out.println("\t1. View Account(s)\n\t2. Make Deposit.\n\t3. Make Withdrawal.\n\t4. Transfer Funds.\n\t5. Exit.");
	}
	static void displayWelcomeMenu() {
		System.out.println("\n\n\n\n\n\n\n\n   Welcome to the Bank of Batch Pega1028!\n");
		System.out.println("\t1. Client Log In\n\t2. Employee Log In\n\t3. Admin Log In\n\t4. Sign up\n\t5. Exit");
	}
	static void displayEmployeeMenu() {
		System.out.println("\n\nEmployee Options:\n");
		System.out.println("\t1. View Accounts\n\t2. Manage Accounts\n\t3. View Clients\n\t4. Exit");
	}
	static void displayAdminMenu() {
		System.out.println("\n\nAdministration Options:\n");
		System.out.println("\t1. View Accounts\n\t2. Manage Accounts\n\t3. View Clients\n\t4. Deposit\n\t5. Withdraw\n\t6. Transfer\n\t7. Exit");
	}
	public static void displayAcctManagement() {
		System.out.println("\n\nAccount Management:");
		System.out.println("\t1. Approve Pending Accounts\n\t2. Deny Pending Accounts\n\t3. Cancel Existing Accounts\n\t4. Create Joint Account\n\t5. Exit");
	}
}