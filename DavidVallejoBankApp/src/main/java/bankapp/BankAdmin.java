//package

package bankapp;

//scanner
import java.util.Scanner;

//BankAdmin extending the Customer class
public class BankAdmin extends Customer {
	final String BWHITE = "\033[1;34m";//brightwhite font color
	final String whitebg = "\u001B[47m";//white text background 
	final String purp = "\u001B[106m";//not really purple actually blue cyan background
	final String green  = "\u001B[94m";//actually blue 
	final String white  = "\u001B[97m";//white font
	final String black  = "\u001B[100m";//gray text background
	final String lightgreen  = "\u001B[92m";//lightgreen color text \u001B[104m
	final String cyan1 = "\u001B[96m";// cyan color text
	final String bgb = "\u001B[104m";// background blue
	final String yellow = "\u001B[93m";// background blue
	//Hard coded values 
	static String bankUser = "username";//static stringvariable taking in the bankUser
	static String bankPass = "password";//static stringvariable taking in the bankPass
	//Hard coded values
	
	//This method verifies the login features of the account
		public static void loginAsAnEmployee(Scanner in) {
			final String BWHITE = "\033[1;34m";//a bright white color for the font 
			final String whitebg = "\u001B[47m";//white text-background
			final String purp = "\u001B[106m";//actually blue cyan background
			final String green  = "\u001B[94m";//actually blue 
			final String white  = "\u001B[97m";//white font
			final String black  = "\u001B[100m";//gray text background
			final String lightgreen  = "\u001B[92m";//brightgreen color text \u001B[104m
			final String cyan1 = "\u001B[96m";// cyan color text
			final String bgb = "\u001B[104m";// background blue
			final String yellow = "\u001B[93m";// background blue
			System.out.println("Nice to see you faithful employee\n");//asking the employee to enter in ther login information
			System.out.println("Username: ");//prompting the employee for a username 
			String username = in.next();//scanner variable called user name takes the in scanner and scans for the next user input to take in as input used to declare the variable;
			System.out.println("Password: ");//prompting the employee for a password 
			String password = in.next();//scanner variable called user name takes the in scanner and scans for the next user input to take in as input used to declare the variable;
			/*
			 * This if loop takes into account the username on file along with the password on file to let the user gain access into the account
			 * 
			 * */
			if (bankUser.contentEquals(username) && bankPass.contentEquals(password)) {//the contentEquals method of the string class compares the username to the userpassword and allows user account access
				access(in);//the scanner in allows access to the account
				loggedInNav(in);
			}else{//else statement 
				System.out.println(white+black+"Could not Verify the account");}}//if the if statement does not equal true then -> Could not verify the account 
		//This method will showcase what the employee can do and gives access to the methods within the class.
		public static void loggedInNav(Scanner in) {//creating the loggedInNav for the bank adminstrator -> Passing in the scanner variable as an argument
			
			System.out.println("Bank admin options:");
			System.out.println("Please select one of the following\n"
					+ "\nW I T H D R A W  [1]?"//Withdraw
					+ "\nD E P O S I T [2]"//Deposit
					+ "\nT R A N S F E R [3]"//Transfer
					+ "\nA C C O U N T I N F O [4]"//Account Info
					+ "\nE X I T [5]");//exit
			int options = in.nextInt();//options takes in the userInput
			in.nextLine();//
			System.out.println("Name on the account ");
			String key = in.nextLine();
			in.nextLine();//in takes the user inputs next line
			currUserAccount currUserAccount = AccountManagement.storageAccount.get(key);//currUserAccount the hash map key
			switch(options) {
			case 1:
				withdraw(currUserAccount, in);
				break;
			case 2:
				deposit(currUserAccount, in);
				break;
			case 3:
				System.out.println("Which account would you like to transfer to?");
				currUserAccount account2 = AccountManagement.getAccountTransfer(in);
				transfer(currUserAccount,account2, in);
				break;
			case 4:
				//takes the user to the info of the current customer
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
