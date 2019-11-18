package Banking;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.xml.bind.DatatypeConverter;

import org.apache.log4j.Logger;

public class Driver {
	private static Logger log = Logger.getLogger(Driver.class);

	//Driver handles all input, the terminal user interface, and logging
	public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InstantiationException {
		final boolean one = true;
		Bank CForLife = null;
		Scanner input, tokens;
		String command, token = "";
		User user = null;
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		
		System.out.printf("Input file for bank info storage or type \"quit\" to quit. (Should be \"BankInfo.txt\")\n");
		
		input = new Scanner(System.in);
		while (CForLife == null) {
			token = input.next();
			if(token.equals("quit")) {
				System.out.printf("Bye!\n");
				System.exit(0);
			}
			
			try {
				CForLife = new Bank(token);
			} catch (FileNotFoundException e) {
				System.out.printf("File not found. Try again.\n");
				CForLife = null;
			}
		}

		System.out.printf("Welcome to CForLife interactive bank terminal. Type \"help\" for commands. Type \"quit\" to exit.\n");
		log.info(token.concat(" openned."));
		
		//Terminal input infinite loop
		while(one) {
			command = input.nextLine();
			tokens = new Scanner(command);
			Account a;
			User u;
			String s = "";
			
			if(!tokens.hasNext()) {
				tokens.close();
				continue;
			}
			
			token = tokens.next();
			switch(token) {
			
			//add [username] [account] - Links username to account.
			case "add":
				if(user == null || user.getType() < User.EMPLOYEE) {
					Driver.error(3);
					break;
				}
				
				try {					
					token = tokens.next();
					u = CForLife.getUser(token);
					if(u == null) {
						Driver.error(5);
						break;
					}
					
					token = tokens.next();
					a = CForLife.getAccount(Integer.valueOf(token));
					if(a == null) {
						Driver.error(6);
						break;
					}
					
					if(!CForLife.link(u, a)) System.out.printf("Account link falure.\n");
					else{
						log.info("User " + u.getUsername() + " and Account " + a.getID() + " linked.");
						System.out.printf("User %s and Account %d are now linked.\n", u.getUsername(), a.getID());
					}
				}
				catch(NoSuchElementException e) { Driver.error(1); }
				catch(NumberFormatException e) { Driver.error(1); }
				
				break;
				
			//apply (username0 username1...) - Applies for a new account. Requires active user. Can add more usernames to form joint account.
			case "apply":				
				if(user == null) {
					Driver.error(2);
					break;
				}
				
				a = new Account(CForLife.useNextID());
				
				if(!CForLife.addAccount(a)) break;
				if(!CForLife.link(user, a)) {
					System.out.printf("Failed to link %s to Account %d.\n", user.getUsername(), a.getID());
					break;
				}
				
				while(tokens.hasNext()) {
					token = tokens.next();
					
					if(!CForLife.link(CForLife.getUser(token), a)) System.out.printf("Failed to link %s to Account %d.\n", token, a.getID());
				}
				
				if(user.getType() > User.USER) a.approve();
				if(a.isApproved()) {
					log.info("Account " + a.getID() + " created and approved.");
					System.out.printf("Account %d created and linked to you. Since you are an %s, it has automatically been approved.\n", a.getID(), user.typeString());
				}
				else {
					log.info("Account " + a.getID() + " created.");
					System.out.printf("Account %d created and linked to you. An employee or admin is required to approve it before it can be used.\n", a.getID());
				}
				
				break;
				
			//approve [account] - Approves account. Only usable by higher ranking users.
			case "approve":
				if(user == null || user.getType() < User.EMPLOYEE) {
					Driver.error(3);
					break;
				}
				
				try {
					token = tokens.next();
					
					a = CForLife.getAccount(Integer.valueOf(token));
					if(a == null) Driver.error(6);
					else {
						a.approve();
						log.info("Account " + a.getID() + " approved.");
					}
				}
				catch (NoSuchElementException e) { Driver.error(1); }
				catch (NumberFormatException e) { Driver.error(1); }
								
				break;
				
			//cancel [account] - Deletes account. Only usable by admins.
			case "cancel":
				if(user == null || user.getType() != User.ADMIN ) {
					System.out.printf("You must be logged in as an admin to cancel accounts.\n");
					break;
				}
				
				try {
					token = tokens.next();
					
					a = CForLife.getAccount(Integer.valueOf(token));
					if(a == null) Driver.error(6);
					
					if(CForLife.removeAccount(a.getID())) log.info("Account " + a.getID() + " canceled.\n");
					
					a = null;
				}
				catch (NoSuchElementException e) { Driver.error(1); }
				catch (NumberFormatException e) { Driver.error(1); }
				
				break;
				
			//deposit [amount] [account] - Deposit amount into account. Only usable by a user linked to the account or admins.
			case "deposit":
				if(user == null) {
					Driver.error(2);
					break;
				}
				
				try {
					double m = Double.valueOf(tokens.next());
					int ai = Integer.valueOf(tokens.next());
					a = CForLife.getAccount(ai);
					
					if(a == null) {
						Driver.error(6);
						break;
					}
					
					if(!a.getUsers().contains(user.getUsername()) && user.getType() != User.ADMIN) {
						System.out.printf("You must be logged in as an Admin or a user linked to this account to deposit.\n");
						break;
					}
					
					if(!a.deposit(m)) System.out.printf("Deposit Failed\n");
					else{
						log.info(m + " CBucks deposited into Account " + a.getID() + ". New balance: " + a.getBalance() + " CBucks.");
						System.out.printf("Deposit successful. New balance for account %d is %f CBucks.\n", a.getID(), a.getBalance());
					}
				}
				catch(NumberFormatException e) { Driver.error(1); }
				catch(NoSuchElementException e) { Driver.error(1); }
				
				break;
				
			//deny [account] - Denies account. Only usable by employees and admins.
			case "deny":
				if(user == null || user.getType() < User.EMPLOYEE) {
					Driver.error(3);
					break;
				}
				
				try {
					token = tokens.next();
					
					a = CForLife.getAccount(Integer.valueOf(token));
					
					if(a == null) {
						Driver.error(6);
						break;
					}
					
					if(a.isApproved()) {
						System.out.printf("Account %d is already approved.\n", a.getID());
						break;
					}
					
					if(CForLife.removeAccount(a.getID())) log.info("Account " + a.getID() + " canceled.");
					
					a = null;
				}
				catch(NoSuchElementException e) { Driver.error(1); }
				catch(NumberFormatException e) { Driver.error(1); }
				
				break;
				
			//help (command) - helps
			case "help":
				if(!tokens.hasNext()) {
					System.out.printf("----COMMANDS----\n"
							+ "add [username] [account]\n"
							+ "apply (username0 username1...)\n"
							+ "approve [account]\n"
							+ "cancel [account]\n"
							+ "deposit [amount] [account]\n"
							+ "deny [account]\n"
							+ "help (command)\n"
							+ "edit [username] (new_value)\n"
							+ "info (username/account)\n"
							+ "list [\"u\"/\"a\"]\n"
							+ "login [username] [password]\n"
							+ "logout\n"
							+ "quit\n"
							+ "register [type] [username] [password] (info)\n"
							+ "transfer [amount] [accountF] [accountT]\n"
							+ "withdraw [amount] [account]\n"
							+ "----\n");
					break;
				}
				
				token = tokens.next();
				switch(token) {
				case "add": System.out.printf("add [username] [account] - Links username to account.\n"); break;
				case "apply": System.out.printf("apply (username0 username1...) - Applies for a new account. Requires active user. Can add more usernames to form joint account.\n"); break;
				case "approve": System.out.printf("approve [account] - Approves account. Only usable by higher ranking users.\n"); break;
				case "cancel": System.out.printf("cancel [account] - Deletes account. Only usable by admins.\n"); break;
				case "deposit": System.out.printf("deposit [amount] [account] - Deposit amount into account. Only usable by a user linked to the account or admins.\n"); break;
				case "deny": System.out.printf("deny [account] - Denies account. Only usable by employees and admins.\n"); break;
				case "help": System.out.printf("This is what I do.\n"); break;
				case "edit": System.out.printf("edit [username] (new_value) - Replaces personal info of username with new_value. Only usable by username or admins.\n"); break;
				case "info": System.out.printf("info (username/account) - Prints all info of the user or account, only usable by username/users linked to account, employees, and admins. If no username or account is given, prints current user info.\n"); break;
				case "list": System.out.printf("list [\"u\"/\"a\"] - Lists all users/accounts.\n"); break;
				case "login": System.out.printf("login [username] [password] - If username/passoword pair is accepted, sets respective user as active user.\n"); break;
				case "logout": System.out.printf("logout - Logs out user.\n"); break;
				case "quit": System.out.printf("Care to guess what this does?\n"); break;
				case "register": System.out.printf("register [type(\"0\"/\"1\"/\"2\")] [username] [password] (info)- Registers new user. Employee and admin accounts can only be created by admins.\n"); break;
				case "transfer": System.out.printf("transfer [amount] [accountF] [accountT] - Transfers amount from accountF to accountT. Only usable by users linked to accountF or admins.\n"); break;
				case "withdraw": System.out.printf("withdraw [amount] [account] - Withdraw amount from account. Only usable by username or admins.\n"); break;
				default: System.out.printf("%s: command not recognized\n", token);
				}
				
				break;
				
			//edit [username] (new_value) - Replaces personal info of username with new_value. Only usable by username or admins.
			case "edit":
				if(user == null) {
					Driver.error(2);
					break;
				}
				
				try {
					token = tokens.next();
					u = CForLife.getUser(token);
					
					if(u == null) {
						Driver.error(5);
						break;
					}
					if(u != user && u.getType() != User.ADMIN) {
						System.out.printf("You must be logged in as this user or an admin to edit this user info.\n");
						break;
					}
					
					s = "";
					if(tokens.hasNext()) s = tokens.next();
					while(tokens.hasNext()) s = String.format("%s %s", s, tokens.next());
					
					user.setInfo(s);
					
					log.info(u.getUsername() + "'s user info is now: \"" + u.getInfo() + "\"");
					System.out.printf("%s's user info is now: \"%s\"\n", u.getUsername(), u.getInfo());
				}
				catch (NoSuchElementException e) { Driver.error(1); }
				
				break;
				
			//info (username/account) - Prints all info of the user or account, only usable by username/users linked to account, employees, and admins. If no username or account is given, prints current user info.
			case "info":
				if(user == null) {
					Driver.error(2);
					break;
				}
				
				try {
					token = tokens.next();
					
					a = CForLife.getAccount(Integer.valueOf(token));
					if(a == null) Driver.error(6);
					else if(user.getAccounts().contains(a.getID()) || user.getType() > User.USER) a.print();
					else System.out.printf("You must be logged in as an admin, employee, or a user linked to this account to view this info.\n");
				}
				catch (NumberFormatException e) {					
					u = CForLife.getUser(token);
					if(u == null) Driver.error(5);
					else if(user == u || user.getType() > User.USER) u.print();
					else System.out.printf("You must be logged in as this user, an admin, or an employee to view this info.\n");
				}
				catch (NoSuchElementException e) { user.print(); }
								
				break;
				
			//list ["u"/"a"] - Lists all users/accounts.
			case "list":
				if(user == null || user.getType() < User.EMPLOYEE) {
					Driver.error(3);
					break;
				}
				
				if(tokens.hasNext()) token = tokens.next();
				else {
					Driver.error(1);
					break;
				}
				
				try {
					if(token.equals("a")) {
						for(int id : CForLife.getAccounts()) CForLife.getAccount(id).print();
					}else if(token.equals("u")) {
						for(String username : CForLife.getUsers()) CForLife.getUser(username).print();
					}else System.out.printf("Token \"%s\" was unexpected.\n", token);
					
				}catch(NoSuchElementException e) {
					System.out.printf("%s is empty.\n", token.equals("a") ? "accounts" : "users");
				}
				
				break;
				
			//login [account] [password] - If username/passoword pair is accepted, sets respective user as active user.
			case "login":
				try {
					u = CForLife.getUser(tokens.next());
					
					if(u == null) Driver.error(5);
					else if(u.login(DatatypeConverter.printHexBinary(md5.digest(tokens.next().getBytes())))) {
						user = u;
						System.out.printf("Now logged in as %s. Welcome!\n", u.getUsername());
					}
					else System.out.printf("Wrong password.\n");
					
				}catch (NoSuchElementException e) { Driver.error(1); }
				
				break;
				
			//logout - Logs out user.
			case "logout":
				if(user == null) Driver.error(2);
				else {
					user = null;
					System.out.printf("Now logged out.\n");
				}
				
				break;
				
			//quit - quits
			case "quit":
				System.out.printf("Bye!\n");
				CForLife.saveAndQuit();
				
			//register [type("0"/"1"/"2")] [username] [password] (info)- Registers new user. Employee and admin accounts can only be created by admins.
			case "register":
				byte t;
				String username, pass;
				
				try {
					t = Byte.valueOf(tokens.next());
					
					if(t > User.USER && (user == null || user.getType() != User.ADMIN)) {
						System.out.printf("Only admins can create employee or admin accounts.\n");
						break;
					}
					
					username = tokens.next();
					
					if(CForLife.getUser(username) != null) {
						System.out.printf("User already exists.\n");
						break;
					}
					
					pass = DatatypeConverter.printHexBinary(md5.digest(tokens.next().getBytes()));
					
					s = "";
					if(tokens.hasNext()) s = tokens.next();
					while(tokens.hasNext()) s = String.format("%s %s", s, tokens.next());
					
					u = new User(t, username, pass);
					u.setInfo(s);
					CForLife.addUser(u);
					
					log.info("User \"" + u.getUsername() + "\" has been created.");
					System.out.printf("User %s has been created.\n", u.getUsername());
				}
				catch (NoSuchElementException e) { Driver.error(1); }
				catch (NumberFormatException e) { Driver.error(1); }
				catch (InstantiationException e) { Driver.error(1); }
				
				break;
				
			//transfer [amount] [accountF] [accountT] - Transfers amount from accountF to accountT. Only usable by users linked to accountF or admins.
			case "transfer":
				if(user == null) {
					Driver.error(2);
					break;
				}
				
				try {
					double d = Double.valueOf(tokens.next());
					int af = Integer.valueOf(tokens.next());
					int at = Integer.valueOf(tokens.next());
					
					if(CForLife.getAccount(af) == null || CForLife.getAccount(at) == null) {
						Driver.error(6);
						break;
					}
					
					if(!CForLife.getAccount(af).getUsers().contains(user.getUsername()) && user.getType() != User.ADMIN) {
						System.out.printf("You must be logged in as an Admin or a user linked to Account %d to transfer.\n", af);
						break;
					}
					
					if(!CForLife.getAccount(af).withdraw(d)) {
						System.out.printf("Failed to withdraw %f CBucks from account %d.\n", d, af);
						break;
					}
					
					if(!CForLife.getAccount(at).deposit(d)) {
						System.out.printf("Failed to deposit %f CBucks into Account %d", d, at);
						if(!CForLife.getAccount(af).deposit(d)) Driver.error(-1);
						break;
					}
					
					log.info("User " + user.getUsername() + " transfered " + d + " CBucks from Account " + af + " to Account " + at + ".\n");
					System.out.printf("Transfer successful. New balance for Account %d is %f CBucks.\n", af, CForLife.getAccount(af).getBalance());
				}
				catch(NoSuchElementException e) { Driver.error(1); }
				catch(NumberFormatException e) { Driver.error(1); }
				
				break;
				
			//withdraw [amount] [account] - Withdraw amount from account. Only usable by username or admins.
			case "withdraw":
				if(user == null) {
					Driver.error(2);
					break;
				}
				
				try {
					double m = Double.valueOf(tokens.next());
					int ai = Integer.valueOf(tokens.next());
					a = CForLife.getAccount(ai);
					
					if(a == null) {
						Driver.error(6);
						break;
					}
					
					if(!a.getUsers().contains(user.getUsername()) && user.getType() != User.ADMIN) {
						System.out.printf("You must be logged in as an Admin or a user linked to this account to withdraw.\n");
						break;
					}
					
					if(!a.withdraw(m)) System.out.printf("Withdrawal Failed\n");
					else{
						log.info(m + " CBucks withdrawn from Account " + a.getID() + ". New balance: " + a.getBalance() + " CBucks.");
						System.out.printf("Withdrawal successful. New balance for account %d is %f CBucks.\n", a.getID(), a.getBalance());
					}
				}
				catch(NumberFormatException e) { Driver.error(1); }
				catch(NoSuchElementException e) { Driver.error(1); }
				
				break;
				
			default: 
				System.out.printf("%s: command not recognized\n", token);
			}
			
			tokens.close();
			
		}
	}
	
	//prints common errors
	public static void error(int i) {
		switch(i) {
		case 0: System.out.printf("Not Implemented\n"); break;
		case 1: System.out.printf("Improper usage, please use \"help (command)\" for syntax.\n"); break;
		case 2: System.out.printf("Requires active user. Please login.\n"); break;
		case 3: System.out.printf("Requires employee or admin.\n"); break;
		case 4: System.out.printf("Requires admin\n."); break;
		case 5: System.out.printf("User does not exist.\n"); break;
		case 6: System.out.printf("Account does not exist.\n"); break;
		default: System.out.printf("PANIC!!!\n");
		}
	}
	
}
