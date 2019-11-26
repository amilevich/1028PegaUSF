package bankapp;

import java.util.Scanner;

public class Customer {
	private String db_userName;
	private String db_userPassword;
	private String db_userFavColor;
	private String db_userIsCustomer;
	private String db_userIsEmployee;
	private String db_userIsBankAdmin;

	public static void access(Scanner in) {
		System.out.print("GREETINGS VALUED CUSTOMER!\nIt's great to see you again 😊   ");
		System.out.print("\nDo you have an existing account? \nPLEASE SELECT [1] FOR YES\nPLEASE SELECT [2] FOR NO\n ");
		int userInput = in.nextInt();
		switch (userInput) {
		case 1:
			System.out.print("Great! Lets get you, Logged in!\n");
			System.out.println("Username: ");
			String username = "username";
			String password = "password";
			String usernameINPUT = in.next();
			System.out.println("Password: ");
			String passwordINPUT = in.next();
			//checks to see if the username and password matches the info on the db
			if (username.equals(usernameINPUT) && password.equals(passwordINPUT)) {
				System.out.println("WELCOME USER!!");
				break;
			}
			break;
		case 2:
			System.out.println("NO WORRIES");
			System.out.println("YOU'RE IN THE RIGHT PLACE THEN FRIEND-O");
			System.out.println("LET'S GET YOUR ACCOUNT SET UP!");
			System.out.println("Would you like to create an account?");
			System.out.println("Press 1 for yes ");
			System.out.println("Press 2 for no ");
			System.out.println("Press 3 to get back to the main menu \n");
			int userInput2 = in.nextInt();// the use has decided to create an account
			switch (userInput2) {
			case 1:
				/*
				 * 
				 * private String db_userName;        
	private String db_userPassword;
	private String db_userFavColor;
	private String db_userIsCustomer;
	private String db_userIsEmployee;
	private String db_userIsBankAdmin;*/
				//cc_input_ is the prefix standing for customer creation input _ then the matching field set
				System.out.println("LET'S GET YOUR ACCOUNT SET UP!");
				System.out.println("What is the name on the account?");
				String cc_input_username = in.next();
				System.out.println("What is the password on the account?");
				String cc_input_password = in.next();
				System.out.println("What is the your favorite color?");
				String cc_input_favcolor = in.next();
				String cc_input_isCustomer = "1";
				String cc_input_isEmployee = "0";
				String cc_input_isBankAdmin = "0";
				System.out.println("Great! Now one final question.");
				System.out.println("Would you like to set up a single account or a joint account?");
				//if single it will update the user accounts list adding the type of account it is and it
				//will update the user adding to the account types column
				System.out.println("Type 1 for Single \n Type 2 for Joint");
				String jointOrSingle = in.next();//user input bank admin password
				if((jointOrSingle.contentEquals("1") || jointOrSingle.contentEquals("yes"))){
				 System.out.println("Nice! Then you are good to go! just waiting for employee or admin approval!");
				 System.out.println("Say... you dont work here do you?");
				 System.out.println("Type [1] for yes \nType[2] for no ");
				 String doYouWorkHere = in.next();
				 if ((doYouWorkHere.contentEquals("1"))) {
					 System.out.println("I thought I recognized you! are you an employee or the bank admin? ");
					 System.out.println("Type [1] for Employee \nType[2] for bank admin ");
					 String employeeOrBankAdmin = in.next();
					 if ((employeeOrBankAdmin.contentEquals("1"))) {String empUsername = "employee";// user input bank admin password
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
							}}else {
								System.out.println("Welcome Bank Admin");
								}
							}
						
					 
					 
				 }
				 /*String empUsername = "employee";// user input bank admin password
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
						}*/
				 
				}else if((jointOrSingle.contentEquals("2") || jointOrSingle.contentEquals("no"))) {
					System.out.println("A 2 Person account!?");
					System.out.println("Nice! double the fun!");
				}else
				break;
			case 2:
				System.out.print("No worries!\nFeel free to come back and create an account with us anytime!\n");
				break;
			case 3:
				String AdminUsername = "bankadmin";//user input bank admin password
				String AdminPassword = "password";//user input bank admin password
				System.out.println("OK great! Just need to check your credentials first");// checking bank admin credentials
				System.out.println("What's the Bank Admin username?");// checking bank admin credentials
				System.out.println("pssst! the username is: bankadmin");
				System.out.println("USERNAME:");
				String bankAdminUsername = in.next(); //user input bank admin username
				System.out.println("What's the Bank Admin password?");// checking bank admin credentials
				System.out.println("pssst! the password is: password");
				System.out.println("PASSWORD:");
				String bankAdminPassword = in.next();//user input bank admin password
				if ((bankAdminUsername.equals(AdminUsername)) && (bankAdminPassword.equals(AdminPassword))) {
					System.out.println("Welcome Bank Admin");
					//set bank admin logged in to true
					//options for the bank admin
				}else {
					System.out.println("Sorry the credentials didn't match");
					System.out.println("You're cool though. Login as Bank Administator anyway?");
					System.out.println("Press 1 for Yes Press 2 for No");
					String loginAsAdminAnyways = in.next();
					if ((loginAsAdminAnyways.equals("yes")) || (loginAsAdminAnyways.equals(1))) {
						//bankAdminOptionsMenu
					}else if ((loginAsAdminAnyways.equals("no")) || (loginAsAdminAnyways.equals(2))) {
						System.out.println("Okie Doke no worries");
						System.out.println("Although we could use some help around here...");
						System.out.println("Need a job?");
						System.out.println("Press 1 for Yes Press 2 for No");
						String needAJob = in.next();
						if ((needAJob.equals("yes")) || (needAJob.equals(1))) {
							String empUsername = "employee";//user input bank admin password
							String empPassword = "password";//user input bank admin password
							System.out.println("Excellent! Welcome to the team boss... Time to get to work!");
							System.out.println("What's the EMPLOYEE username?(employee)");// checking bank admin credentials
							System.out.println("pssst! the username is: employee");
							System.out.println("USERNAME:");
							String employeeUsername = in.next(); //user input bank admin username
							System.out.println("What's the Employee password?(password)");// checking bank admin credentials
							System.out.println("pssst! the password is: password");
							System.out.println("PASSWORD:");
							String employeePassword = in.next();//user input bank admin password
							if ((empUsername.equals(employeeUsername)) && (empPassword.equals(employeePassword))) {
								System.out.println("Great to see you at work employee, get started");
								//set employee logged in to true
								//options for the employee
							}else{
								System.out.println("Learn your credentials.. but anyways your logged in");
								System.out.println("Now go approve some accounts rookie!");
								//set employee logged in to true
								//options for the employee
							}
					}else if ((needAJob.contentEquals("no")) || (needAJob.contentEquals("2")))
						System.out.println("No Worries check back soon for account approval then");
				}
				}
			/*	MainDriver menu = new MainDriver();
				String[] arguments = new String[] { "123" };
				menu.main(arguments);
				break; */
			}
			break;
		}

	}
	/* Creates a user account */
	public static void create(Scanner in) {
		System.out.println("USERNAME: ");
		String username = in.next();
		System.out.println("PASSWORD: ");
		String password = in.next();
		currUserAccount account = new currUserAccount(username, password, username + password, 0.0);
		AccountManagement.pendingAccounts.add(account);
		System.out.println("Congratulations!!!! Your account is waiting to be approved by a staff member.");
		System.out.println("Would you like to approve an account as an Employee or Bank Admin?");
		System.out.println("Press 1 for Yes Press 2 for No");
		String z = in.next();
		/**
		 * Press 1 for yes or 2 for no
		 * IF YES -> 
		 * 'Are you a Bank Admin or an Employee'
		 * 'Press 1 for Bank Admin or 2 for Employee'
		 * IF -> Bank Admin -> 
		 
		 * IF -> EMPLOYEE ->
		 * * ok great BankAdmin username (pssst! the username is: bankadmin)
		 * thanks, and BankAdmin password (pssst! the password is: password)
		 * #LoginsAsBankAdmin-> approve accounts 
		 * IF NO -> 'Ok great thanks! Come back soon and check on the account approval!' 
		 * Press 1 -> to go back to the menu Press 2 -> To do nothing
		 * IF 1 -> Goes back to the main menu IF 2 -> SysO '***Does Nothing***'
		 * ELSE->
		 * Re-ask the question from the previous menu
		 * -- would also be cool if accounts get approved automatically 30 seconds after creation
		 **/
		if ((z.equals("yes")) || (z.equals("y")) || (z.equals("1"))) {
			System.out.println("Awesome are you the Bank Administrator or an Employee?");
			System.out.println("Press 1 for Bank administrator Press 2 for Employee");
			String t = in.next();
			if ((t.equals("1")) || (t.equals("bank admin")) || (t.equals("0"))) {
				String AdminUsername = "bankadmin";//user input bank admin password
				String AdminPassword = "password";//user input bank admin password
				System.out.println("OK great! Just need to check your credentials first");// checking bank admin credentials
				System.out.println("What's the Bank Admin username?");// checking bank admin credentials
				System.out.println("pssst! the username is: bankadmin");
				System.out.println("USERNAME:");
				String bankAdminUsername = in.next(); //user input bank admin username
				System.out.println("What's the Bank Admin password?");// checking bank admin credentials
				System.out.println("pssst! the password is: password");
				System.out.println("PASSWORD:");
				String bankAdminPassword = in.next();//user input bank admin password
				if ((bankAdminUsername.equals(AdminUsername)) && (bankAdminPassword.equals(AdminPassword))) {
					System.out.println("Welcome Bank Admin");
					//set bank admin logged in to true
					//options for the bank admin
				}else {
					System.out.println("Sorry the credentials didn't match");
					System.out.println("You're cool though. Login as Bank Administator anyway?");
					System.out.println("Press 1 for Yes Press 2 for No");
					String loginAsAdminAnyways = in.next();
					if ((loginAsAdminAnyways.equals("yes")) || (loginAsAdminAnyways.equals(1))) {
						//bankAdminOptionsMenu
					}else if ((loginAsAdminAnyways.equals("no")) || (loginAsAdminAnyways.equals(2))) {
						System.out.println("Okie Doke no worries");
						System.out.println("Although we could use some help around here...");
						System.out.println("Need a job?");
						System.out.println("Press 1 for Yes Press 2 for No");
						String needAJob = in.next();
						if ((needAJob.equals("yes")) || (needAJob.equals(1))) {
							String empUsername = "employee";//user input bank admin password
							String empPassword = "password";//user input bank admin password
							System.out.println("Excellent! Welcome to the team boss... Time to get to work!");
							System.out.println("What's the EMPLOYEE username?(employee)");// checking bank admin credentials
							System.out.println("pssst! the username is: employee");
							System.out.println("USERNAME:");
							String employeeUsername = in.next(); //user input bank admin username
							System.out.println("What's the Employee password?(password)");// checking bank admin credentials
							System.out.println("pssst! the password is: password");
							System.out.println("PASSWORD:");
							String employeePassword = in.next();//user input bank admin password
							if ((empUsername.equals(employeeUsername)) && (empPassword.equals(employeePassword))) {
								System.out.println("Great to see you at work employee, get started");
								//set employee logged in to true
								//options for the employee
							}else{
								System.out.println("Learn your credentials.. but anyways your logged in");
								System.out.println("Now go approve some accounts rookie!");
								//set employee logged in to true
								//options for the employee
							}
					}else if ((needAJob.equals("no")) || (needAJob.equals("2")))
						System.out.println("No Worries check back soon for account approval then");
				}
				}} else if ((t.equals("2")) || (t.equals("employee")) || (t.equals("3"))) {
				System.out.println("Employee");// employee menu
			}
		} else {
			System.out.println("Sorry try again");// try again pls
		}
	}

	// transfering money between accounts
	public static void transfer(currUserAccount account1, currUserAccount account2, Scanner in) {
		try {
			System.out.println("TRANSFER AMMOUNT:  " + account1.getName() + " to " + account2.getName() + "?");
			double transferAmount = in.nextDouble();
			if ((account1.getBalance() - transferAmount) >= 0) {
				account1.setBalance(account1.getBalance() - transferAmount);
				account2.setBalance(account2.getBalance() + transferAmount);
				System.out.println("Transfer is succesful");
			} else {
				System.out.println(
						"Transfer not succesful, try again or input 0 when prompted for transfer amount to cancel transaction");
				transfer(account1, account2, in);
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			System.out.println("\nThanks for Banking with us. As always a pleasure.");
		}

	}

	public static void deposit(currUserAccount account, Scanner in) {
		System.out.println("DEPOSIT AMMOUNT: ");
		double dep = in.nextDouble();
		account.setBalance(account.getBalance() + dep);
		System.out.println("UPDATED ACCOUNT BALANCE:  �" + account.getBalance());
	}

	public static void withdraw(currUserAccount account, Scanner in) {
		System.out.println("How much would you like to withdraw?");
		double withdrawAmmount = in.nextDouble();
		if (account.getBalance() >= withdrawAmmount) {
			account.setBalance(account.getBalance() - withdrawAmmount);
			System.out.println("Your new account balance is �" + account.getBalance());

		} else if (account.getBalance() < withdrawAmmount) {
			System.out.println("ACCOUNT BALANCE: �" + account.getBalance());
			System.out.println("REQUEST NEW LOWER AMOUNT: ");
			withdraw(account, in);
		}
	}

	/* creating the joint account */
	public static void createJoint(Scanner in) {
		System.out.println("FIRSTNAME:");
		String username1 = in.next();
		System.out.println("PASSWORD: ");
		String password1 = in.next();
		System.out.println("SECOND NAME ON THE ACCOUNT:");
		String username2 = in.next();
		System.out.println("SECOND PASSWORD: ");
		String password2 = in.next();

	}

}
