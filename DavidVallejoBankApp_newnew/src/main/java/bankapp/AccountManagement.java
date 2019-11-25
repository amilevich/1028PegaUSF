
package bankapp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AccountManagement {

	public static List<currUserAccount> pendingAccounts = new ArrayList<currUserAccount>(); 
	public static Map<String,currUserAccount> storageAccount = new HashMap<String,currUserAccount>();

	public static currUserAccount getcurrUserAccount(Scanner in) {
		System.out.println("Username: ");
		String username = in.next();
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
