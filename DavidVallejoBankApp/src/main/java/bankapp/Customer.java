package bankapp;

import java.util.Scanner;

public class Customer {

	//access will let the user decide between opening a new account vs logging into a previous account.
	public static void access(Scanner in) {
		System.out.print("GREETINGS VALUED CUSTOMER!\nIt's great to see you again 😊   ");
		System.out.print("\nDo you have an existing account? \nPLEASE SELECT [1] FOR YES\nPLEASE SELECT [2] FOR NO\n ");
		int userInput = in.nextInt();
		//switch cases below
		switch(userInput) {
		case 1://case 1 means user does have an existing account 
			System.out.print("Great! Lets get you, Logged in!\n");
			System.out.println("Username: ");
			String username = "username";
			String password = "password";
			String usernameINPUT = in.next();
			System.out.println("Password: ");
			String passwordINPUT = in.next();
			if(username.equals(usernameINPUT) && password.equals(passwordINPUT)) {
				System.out.println("WELCOME USER!!");
				break;
			}
			//Previous scanner objects I created
			/* System.out.println("UserName:");//scanner object takes in userName
			System.out.println("Password:");//scanner object takes in userPassword */
			break;
		case 2://case 2 means the user does not have an existing account
			System.out.println("No Worries! Would you like to create an account?\n");//asks the user to create an account
			System.out.print("Press 1 for yes\n");//takes a 1 if the user wants to create a new account
			System.out.print("Press 2 for no\n");//takes a 2 if the user does not want to create an account 
			System.out.print("Press 3 to get back to the main menu\n");//exits the flow entirely and redirects to the main menu
			int userInput2 = in.nextInt();
			switch(userInput2) {
			case 1:
				create(in);
				break;
			case 2:
				System.out.print("No worries!\nFeel free to come back and create an account with us anytime!\n");
				break;
			case 3://case 3 -> code that takes the user back to the main app driver
				MainDriver menu = new MainDriver();
				String[] arguments = new String[] {"123"};
				menu.main(arguments);//There's probably an easier way to call main but ay
				break;
			}
			break;
		}
		
	}
	
	//creates an account
	public static void create(Scanner in) {//the scanner variable is taken in as an argument in the create method 
		System.out.println("USERNAME: ");//the user is selecting a username
		String username = in.next(); //user input is store in the user name
		System.out.println("PASSWORD: "); // the password variable is promted
		String password = in.next(); //user input for the password variable is stored in the password variable
		currUserAccount account = new currUserAccount(username, password, username + password, 0.0);//the account object of type account is constructed using 5 parameters including 4 strings and a double
		AccountManagement.pendingAccounts.add(account);//adding accounts to the AccountManagement variable's.pendingAccounts method
		System.out.println("Congratulations!!!! Your account is waiting to be approved by a staff member.");//pending account awaiting apporoval by staff prometed to the user.
	}
	//transfering money between accounts
	public static void transfer(currUserAccount account1,currUserAccount account2,Scanner in) {//getting user input on the accounts they'd like to transfer to and from 
		try {//trying transfer first 
		System.out.println("TRANSFER AMMOUNT:  " + account1.getName() + " to " + account2.getName() + "?");
		double transferAmount = in.nextDouble();
		if((account1.getBalance()-transferAmount) >= 0) {//if statement 
			account1.setBalance(account1.getBalance()-transferAmount);
			account2.setBalance(account2.getBalance()+transferAmount);
			System.out.println("Transfer is succesful");}
		else {//else statement
			System.out.println("Transfer not succesful, try again or input 0 when prompted for transfer amount to cancel transaction");
			transfer(account1, account2, in);
		}}catch(Exception e) {
			e.getStackTrace();//e stacktrace
		}finally {//finally method always runs
			System.out.println("\nThanks for Banking with us. As always a pleasure.");
		}
		
	}
	//depositing accounts
	public static void deposit(currUserAccount account,Scanner in) {//account and scanner params 
		System.out.println("DEPOSIT AMMOUNT: ");//asking the user to select a deposit ammount
		double dep = in.nextDouble();
		account.setBalance(account.getBalance() + dep);
		System.out.println("UPDATED ACCOUNT BALANCE:  �" + account.getBalance());
	}
	
    //withdraws from account
	public static void withdraw(currUserAccount account,Scanner in) {//ACCOUNT withdraw method taking in the account and scanner variable as parameters
		System.out.println("How much would you like to withdraw?");//promting withdrawal ammount 
		double withdrawAmmount = in.nextDouble();
		if(account.getBalance()>=withdrawAmmount) {//checking to see if the account has enough money in the account to support the withdrawal
			account.setBalance(account.getBalance() - withdrawAmmount);//substracting the withdrawal ammount from the account balance and updating 
			System.out.println("Your new account balance is �" + account.getBalance());

		}else if(account.getBalance()<withdrawAmmount){
			System.out.println("ACCOUNT BALANCE: �" + account.getBalance());
			System.out.println("REQUEST NEW LOWER AMOUNT: ");
			withdraw(account, in);
		}
	}
	/*creating the joint account */
	public static void createJoint(Scanner in) { //creating the joint user accounts 
		System.out.println("FIRSTNAME:");//first name in the account 
		String username1 = in.next();
		System.out.println("PASSWORD: ");//first password in the account 
		String password1 = in.next();
		
		System.out.println("SECOND NAME ON THE ACCOUNT:");//second name in the account 
		String username2 = in.next();
		System.out.println("SECOND PASSWORD: ");//second password in the account
		String password2 = in.next();
		
		
	}
	
}
