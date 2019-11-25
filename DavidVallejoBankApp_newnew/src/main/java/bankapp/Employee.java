/*package*/
package bankapp;
/*imports*/
import java.util.Scanner;
/*Bank employee class*/
public class Employee {
    static String Employeeusername = "employee";
	static String Employeepassword = "password";
	
	
	//This method verifies the login features of the account
	public static void logInAsAnEmployee(Scanner in) {
		System.out.println("Let's get to work! Enter in your employee ID: ");
		System.out.println("Username: ");
		String username = in.next();
		System.out.println("Password: ");
		String password = in.next();
		/*Setting the content equal to employee username and checking to show the logged in menu*/
		if (Employeeusername.contentEquals(username) && Employeepassword.contentEquals(password)) {
			//shows the logged in menu
		}else{
			System.out.println("Incorrect login credentials");}
	}
	
	//THis method will showcase what the employee can do and gives access to the methods within the class.
	public static void loggedInnav(Scanner in) {
		
		System.out.println("Well done, you can follow basic protocol.");
		System.out.println("What would you like to do? Approve pending accounts[0] "
				+ "or access intimate details about our customers?[1]");
		int options = in.nextInt();		
		switch(options) {
		case 0:
			approveAccounts();
			break;
		case 2:
			Info(in);
		
		}
	}
	
	//Approve pending accounts, within the array list into the "approved" pending map.
	public static void approveAccounts() {
		if(AccountManagement.pendingAccounts.isEmpty()) {
			System.out.println("No accounts to approve");
		}else {
			for(currUserAccount i:AccountManagement.pendingAccounts) {
				AccountManagement.storageAccount.put(i.currUserAccount(), i);

			}
			System.out.println("Accounts have been approved");
		}
	}
	
	//Allows employees to view account details via the toString method
	public static void Info(Scanner in) {

		if(AccountManagement.storageAccount.isEmpty()) {
			System.out.println("No accounts available to access");
		}else {
			System.out.println(AccountManagement.storageAccount.keySet().toString());
			boolean accessing = true;

			while(accessing) {
				try {
				System.out.println("Which account would you like to access?");
				in.nextLine();
				String onlineID = in.nextLine();
				currUserAccount account = AccountManagement.storageAccount.get(onlineID);
				System.out.println(account.toString());}catch(NullPointerException e) {
					//e.printStackTrace();
					System.out.println("That account does not exist");
				}
				
				System.out.println("Do you want to do anythin else?");
				String input = in.next();
				if (input.equals("no")) {
					accessing = false;
				}else if(input.equals("yes")) {
					System.out.println("Great lets do this!");
				// src.MainDriver.main(args);
				}else {
					System.out.println("That isn't a vaild input, remember we don't accept upper case.");
					break;
				}	
			}
		}

	}

}
	

