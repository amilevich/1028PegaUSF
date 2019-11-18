/*package*/
package bankapp;

/*imports*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AccountManagement {
	//stores the account variables in a list
	public static List<currUserAccount> pendingAccounts = new ArrayList<currUserAccount>(); // Stores pending accounts
	public static Map<String,currUserAccount> storageAccount = new HashMap<String,currUserAccount>();// Stores approved accounts in a HashMap.
	// and stores the customer account info in a map
	//Getting the user account variables
	public static currUserAccount getcurrUserAccount(Scanner in) {
		System.out.println("Username: ");
		String username = in.next();//finding out the current user by taking in the account name and the password in the scanner variable
		System.out.println("Password: ");
		String password = in.next();
		String id = username + password;
		if(AccountManagement.storageAccount.keySet().contains(id)) {
			return storageAccount.get(id);
		}else {
			System.out.println("Could not verify the account");
			return null;
		}
		
	}
	public static currUserAccount getAccountTransfer(Scanner in) {
		System.out.println("What is the username on the account?");
		in.nextLine();
		String accountName = in.nextLine();
		currUserAccount account;
		for(String i:AccountManagement.storageAccount.keySet()) {
			if(i.contains(accountName)) {
				account = AccountManagement.storageAccount.get(i);
				return account;
			}
		}
		System.out.println("Could not verify your account");
		return null;
	}
}
