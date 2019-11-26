package bankapp;
import java.util.Scanner;

//BankAdmin extending the Customer class
public class BankAdmin extends Customer {
	static String bankUser = "username";
	static String bankPass = "password";

	public static void loginAsAnEmployee(Scanner in) {
		final String white = "\u001B[97m";// white font
		final String black = "\u001B[100m";// gray text background
		System.out.println("Nice to see you faithful employee\n");
		System.out.println("Username: ");
		String username = in.next();
		System.out.println("Password: ");
		String password = in.next();

		if (bankUser.contentEquals(username) && bankPass.contentEquals(password)) {
			access(in);// the scanner in allows access to the account
			loggedInNav(in);
		} else {
			System.out.println(white + black + "Could not Verify the account");
		}
	}

	public static void loggedInNav(Scanner in) {
		System.out.println("Bank admin options:");
		System.out.println("Please select one of the following\n" + "\nW I T H D R A W  [1]?"
				+ "\nD E P O S I T [2]"
				+ "\nT R A N S F E R [3]"
				+ "\nA C C O U N T I N F O [4]"
				+ "\nE X I T [5]");
		int options = in.nextInt();
		in.nextLine();
		System.out.println("Name on the account ");
		String key = in.nextLine();
		in.nextLine();
		currUserAccount currUserAccount = AccountManagement.storageAccount.get(key);
		switch (options) {
		case 1:
			withdraw(currUserAccount, in);
			break;
		case 2:
			deposit(currUserAccount, in);
			break;
		case 3:
			System.out.println("Which account would you like to transfer to?");
			currUserAccount account2 = AccountManagement.getAccountTransfer(in);
			transfer(currUserAccount, account2, in);
			break;
		case 4:
			
			break;

		}
		System.out.println("Thanks for using this application");
	}

	public static void access(Scanner in) {
		System.out.println("Bank Official - Access");
		System.out.println(AccountManagement.storageAccount.keySet().toString());
	}

	public static void removeAccounts(currUserAccount account) {
		AccountManagement.storageAccount.remove(account.getaccountID());
		System.out.println("The account has been removed");

	}

}
