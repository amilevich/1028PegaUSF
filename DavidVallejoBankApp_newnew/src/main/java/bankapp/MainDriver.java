package bankapp;

import java.util.Scanner;
import org.apache.log4j.Logger;



public class MainDriver {
	JDBCCONNECT initConnect = new JDBCCONNECT();
	public static Scanner in = new Scanner(System.in);
	final static Logger Loggy = Logger.getLogger(MainDriver.class);
    
	/* Main driver class the MAIN METHOD */
	public static void main(String[] args) { // the top of the main class in the mainDrive
	//	String userFavColor = resultsOfQuery.getString(3);
	/*	if((useFavColor.contentEqual("blue"))) {
			
	     } */
		Loggy.info("The application is running!");// first log
		boolean activeUser = true; // while the activeUser is set to true within the menu scope the while loop will
									// continue function
		while (activeUser) {// Overall arching while loop containing most of the app within its block
							// statement
			// style variables
			boolean mainMenu = true;
			final String BWHITE = "\033[1;34m";
			final String white = "\u001B[97m";
			final String black = "\u001B[100m";// gray text background
			final String cyan1 = "\u001B[96m";
			final String yellow = "\u001B[93m";// yellow text
			System.out.print(black + cyan1 + "\t💰💰💰 W E L C O M E\tT O\tT H E 💰💰💰                       " + BWHITE
					+ "" + cyan1 + "\n\t 🤑 🤑 🤑 🤑 🤑 B  A  N  K 🤑 🤑 🤑 🤑 🤑   \t\t\t  ");
			System.out.print(white + " \n");
			System.out.print(black + "\tPRESS [" + cyan1 + "1" + white + "] ➕ [" + cyan1 + "ENTER" + white
					+ "] ➡️ IF YOU ARE A " + cyan1 + "CUSTOMER\t\t           " + white + "\n");
			System.out.print("\t" + white + "PRESS " + white + "[" + cyan1 + "2" + white + "] ➕ [" + cyan1 + "ENTER"
					+ white + "] ➡️ IF YOU ARE A " + cyan1 + "EMPLOYEE\t\t" + white + "           \n");
			System.out.print("\tPRESS [" + cyan1 + "3" + white + "] ➕ [" + cyan1 + "ENTER" + white
					+ "] ➡️ IF YOU ARE A " + cyan1 + "BANK ADMIN  \t\t   \n" + cyan1 + black + "");
			int navSelection = in.nextInt();// Saves the users input to navSelection variable
			in.nextLine();
			switch (navSelection) {
			case 1: // if 1 is selected continues to Customer portal
				while (mainMenu) {
					Customer.access(in);
					mainMenu = in.nextBoolean();
				}
				System.out.println("Customer interaction complete.");
				break;
			case 2: // if 2 is selected continues to Employee portal
				System.out.println("THANKS FOR WORKING AT DAVID'S BANK EMPLOYEE!");
				System.out.println("Did you know the username for employee is: employee");
				System.out.println("and did you know the password for employee is: password");
				System.out.println("Press 1 for Yes Press 2 for No");
				String employeeLoggingIn = in.next();
				if ((employeeLoggingIn.equals("yes")) || (employeeLoggingIn.contentEquals("1"))) {
					String empUsername = "employee";// user input bank admin password
					String empPassword = "password";// user input bank admin password
					System.out.println("Excellent! Welcome to the team boss... Time to get to work!");
					System.out.println("What's the EMPLOYEE username?(employee)");// checking bank admin credentials
					System.out.println("pssst! the username is: employee");
					System.out.println("USERNAME:");
					String employeeUsername = in.next(); // user input bank admin username
					System.out.println("What's the Employee password?(password)");// checking bank admin credentials
					System.out.println("pssst! the password is: password");
					System.out.println("PASSWORD:");
					String employeePassword = in.next();// user input bank admin password1
					if ((empUsername.equals(employeeUsername)) && (empPassword.equals(employeePassword))) {
						System.out.println("Great to see you at work employee,let's get started");
						System.out.println("What would you like to do now?");
						System.out.println("[1] REVIEW PENDING ACCOUNTS");
						System.out.println("[2] VIEW CUSTOMER ACCOUNT INFO");
						System.out.println("[3] LOGIN AS THE BANK ADMINISTRATOR");
						System.out.println("[4] LOGIN AS A CUSTOMER");
						System.out.println("[4] LOG OUT");
						String employeeAction = in.next();// user input bank admin password
						if ((employeeAction.contentEquals("1"))) {
							System.out.println("REVIEW PENDING ACCOUNTS");
						} else if ((employeeAction.contentEquals("2"))) {
							System.out.println("VIEW CUSTOMER INFO");
						} else if ((employeeAction.contentEquals("3"))) {
							System.out.println("LOGIN AS THE BANK ADMINISTRATOR");
						} else if ((employeeAction.contentEquals("4"))) {
							System.out.println("LOGIN AS A CUSTOMER");
						} else if ((employeeAction.contentEquals("5"))) {
							System.out.println("LOG OUT");
						} else {
							System.out.println("Sorry that isn't an option!");
						}
						String employeeApproveAccounts = in.next();
						if ((employeeApproveAccounts.contentEquals("1")
								|| employeeApproveAccounts.contentEquals("yes"))) {
							System.out.println("Sweet! condsider all accounts approved");
						} else {
							System.out.println("Well you gotta do something!\n Can't just sit there!");
						}
						// set employee logged in to true
						// options for the employee
					} else {
						System.out.println("Learn your credentials.. but anyways your logged in, YOU GOT THE JOB!");
						System.out.println("Now go approve some accounts rookie!");
						// set employee logged in to true
						// options for the employee
					}
				} else if ((employeeLoggingIn.equals("no")) || (employeeLoggingIn.contentEquals("2"))) {
					System.out.println("No Worries check back soon for account approval then");
				}
				System.out.println("Employee interaction complete");
				break;
			case 3: // if 3 is selected continues to Bank Admin portal
				String AdminUsername = "bankadmin";// user input bank admin password
				String AdminPassword = "password";// user input bank admin password
				System.out.println("OK great! Just need to check your credentials first");// checking bank admin
																							// credentials
				System.out.println("What's the Bank Admin username?");// checking bank admin credentials
				System.out.println("pssst! the username is: bankadmin");
				System.out.println("USERNAME:");
				String bankAdminUsername = in.next(); // user input bank admin username
				System.out.println("What's the Bank Admin password?");// checking bank admin credentials
				System.out.println("pssst! the password is: password");
				System.out.println("PASSWORD:");
				String bankAdminPassword = in.next();// user input bank admin password
				if ((bankAdminUsername.equals(AdminUsername)) && (bankAdminPassword.equals(AdminPassword))) {
					System.out.println("WELCOME BANK ADMIN!!!\n");
					// set bank admin logged in to true
					// options for the bank admin
					System.out.println("What would you like to do next?\n");
					System.out.println("SELECT FROM THE BANK ADMIN MENU BELOW:\n");
					System.out.println("[1] APPROVE ACCOUNTS");
					System.out.println("[2] DELETE ACCOUNTS");
					System.out.println("[3] TRANSFER MONEY");
					String bankAdminAction = in.next();
					if ((bankAdminAction.contentEquals("1"))) {
						System.out.println("Aight let's head out and approve these accounts");
					} else if ((bankAdminAction.contentEquals("2"))) {
						System.out.println("Aight let's head out and delete some accounts");
					} else if ((bankAdminAction.contentEquals("3"))) {
						System.out
								.println("Aight let's head out and transfer some money to and from different accounts");
					}
				} else {
					System.out.println("Sorry the credentials didn't match");
					System.out.println("You're cool though. Login as Bank Administator anyway?");
					System.out.println("Press 1 for Yes Press 2 for No");
					String loginAsAdminAnyways = in.next();
					if ((loginAsAdminAnyways.equals("yes")) || (loginAsAdminAnyways.contentEquals("1"))) {
						System.out.println("AWESOME! WELCOME TO THE BANK MR.ADMIN!");
						System.out.println("What would you like to do now?");
						System.out.println("[1] REVIEW PENDING ACCOUNTS");
						System.out.println("[2] VIEW CUSTOMER ACCOUNT INFO");
						System.out.println("[3] LOGIN AS THE BANK ADMINISTRATOR");
						System.out.println("[4] LOGIN AS A CUSTOMER");
						System.out.println("[4] LOG OUT");
						String employeeAction = in.next();// user input bank admin password
						if ((employeeAction.contentEquals("1"))) {
							System.out.println("REVIEW PENDING ACCOUNTS");
						} else if ((employeeAction.contentEquals("2"))) {
							System.out.println("VIEW CUSTOMER INFO");
						} else if ((employeeAction.contentEquals("3"))) {
							System.out.println("LOGIN AS THE BANK ADMINISTRATOR");
						} else if ((employeeAction.contentEquals("4"))) {
							System.out.println("LOGIN AS A CUSTOMER");
						} else if ((employeeAction.contentEquals("5"))) {
							System.out.println("LOG OUT");
						} else {
							System.out.println("Sorry that isn't an option!");
						}
					} else if ((loginAsAdminAnyways.equals("no")) || (loginAsAdminAnyways.contentEquals("2"))) {
						System.out.println("Okie Doke no worries");
						System.out.println("Although we could use some help around here...");
						System.out.println("Need a job?");
						System.out.println("Press 1 for Yes Press 2 for No");
						String needAJob = in.next();
						if ((needAJob.equals("yes")) || (needAJob.equals(1))) {
							String empUsername = "employee";// user input bank admin password
							String empPassword = "password";// user input bank admin password
							System.out.println("Excellent! Welcome to the team boss... Time to get to work!");
							System.out.println("What's the EMPLOYEE username?(employee)");// checking bank admin
																							// credentials
							System.out.println("pssst! the username is: employee");
							System.out.println("USERNAME:");
							String employeeUsername = in.next(); // user input bank admin username
							System.out.println("What's the Employee password?(password)");// checking bank admin
																							// credentials
							System.out.println("pssst! the password is: password");
							System.out.println("PASSWORD:");
							String employeePassword = in.next();// user input bank admin password
							if ((empUsername.equals(employeeUsername)) && (empPassword.equals(employeePassword))) {
								System.out.println("Great to see you at work employee, get started");
								// set employee logged in to true
								// options for the employee
							} else {
								System.out.println("Learn your credentials.. but anyways your logged in");
								System.out.println("Now go approve some accounts rookie!");
								// set employee logged in to true
								// options for the employee
							}
						} else if ((needAJob.equals("no")) || (needAJob.equals(2)))
							System.out.println("No Worries check back soon for account approval then");
					}
				}
				mainMenu = false;
				break;
			}
			Loggy.info("User is using the main menu");

		}

	}
}
