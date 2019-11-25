package BankingApp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class BankMain {

	public static UserManager userman;
	final static Logger log = Logger.getLogger(BankMain.class);

	public static void main(String[] args) throws Exception {

		try {

			userman = new FileUserManger(new PrintWriter(new FileWriter("users.txt", true)),
					new BufferedReader(new FileReader("users.txt")));

			Scanner myObj = new Scanner(System.in);
			Account account = new Account();

			introInptuts(myObj);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("That was not printed.");
			e.printStackTrace();
		} finally {
			userman.cleanup();
		}

		Users user = new Users("shaypatel", "1234","1");
		Users user1 = new Users("divaD", "divaD", "0");
		Users user2 = new Users("randymarsh", "rando1", "0");
		Users user3 = new Users("charlie", "paddy1", "0");

		UsersDao usersDaoImpl = new UsersDaoImpl();

		usersDaoImpl.insertUser(user);
		usersDaoImpl.insertUser(user1);
		usersDaoImpl.insertUser(user2);
		usersDaoImpl.insertUser(user3);
		//System.out.println(usersDaoImpl.selectAllUsers());
	}

	public static void introInptuts(Scanner myObj) {
		boolean isValidInput = false;
		String param = "";
		System.out.println(
				"Welcome to Tegridy banking app, sign up to get started.\n Already have an account? Sign in below.");
		while (!isValidInput) {
			System.out.print("Enter: login/signup: \n");
			param = myObj.nextLine();
			if (param.equals("login") || param.equals("signup")) {
				String message = param.equals("login") ? "Enter your login credentials"
						: "Signup up by entering your details";
				System.out.println(message);
				isValidInput = true;
			} else {
				System.out.print("You entered an invalid input. Enter 'login' or 'signup'");
			}
		}
		if (param.equals("login")) {
			login(myObj);
		} else {
			signup(myObj);
		}
	}

	// Method to allow user to login to bank
	public static void login(Scanner myObj) {
		boolean isValidInput = false;
		String userName = null;
		String role = "1";
		while (!isValidInput) {
			System.out.print("Enter your username: ");
			userName = myObj.nextLine();
			System.out.print("Enter your password: ");
			String password = myObj.nextLine();
			// The great man that is named Ben, showed me how to implement a switch
			// statement to get users input of either 0 for user or 1 for admin to see which
			// menu would be displayed. Originally, it didnt matter what user was being used
			// the Admin menu was always visible.
			if (userman.isValidateCredentials(userName, password)) {
				boolean loginResult = userman.login(userName, password);
				if (loginResult) {
					isValidInput = true;
					System.out.println("Access user press 0, for employee press 1, for admin press 2.");
					int input = myObj.nextInt();
					switch (input) {
					case 0:
						userAccount(myObj, userName);
						break;
					case 1:
						employeeAccount(myObj);
						break;
					case 2:
						adminAccount(myObj);
						break;
					default:
						System.out.println("Invalid input. Please choose correct access number.");
					}

				} else {
					System.out.println("Invalid username or password");
				}
			} else {
				System.out.println("Username and password is required");
			}

		}
	}

	// Method to allow user or admin to create username and password
	public static void signup(Scanner myObj) {
		boolean isValidInput = false;
		String userName = null;
		while (!isValidInput) {
			System.out.print("Enter your username: ");
			userName = myObj.nextLine();
			System.out.print("Enter your password: ");
			String password = myObj.nextLine();
			System.out.print("Enter your role: 0 for Users, 1 for Employees, or 2 for Admins.\n");
			String role = myObj.nextLine();
			if (userman.isValidateCredentials(userName, password)) {
				boolean result = userman.signUp(new Users(userName, password, role));
				if (result) {
					isValidInput = true;
				} else {
					System.out.print("Role should be either 0 or 1. O for Users or 1 for Admins");
				}
			} else {
				System.out.println("Username and password are required");
			}

		}
		System.out.println("Signed up successfully!\n");
		account(myObj, userName);
	}

	// Method to allow user or admin to see if they have an account or create one if
	// not. If account is created then you can chose what you would like to do.
	public static void account(Scanner myObj, String username) {
		boolean isValidInput = false;
		boolean isValidInput2 = false;
		Account account = new Account();

		HashMap<String, String> accDetails = account.getAccountDetails(username);

		if (accDetails.isEmpty()) {
			System.out.println("Sorry you do not have any bank account.");
			System.out.println("You can create an account today!");

			while (!isValidInput || !isValidInput2) {
				System.out.print("Enter your first name: ");
				String firstName = myObj.nextLine();

				System.out.print("Enter your last name: ");
				String lastName = myObj.nextLine();

				if (account.isValidateCredentials(firstName, lastName)) {
					account.create(username, firstName, lastName);
					isValidInput = true;
					isValidInput2 = true;
				} else {
					System.out.println("Fisrt name and last name are required");
				}
			}

			System.out.println("Your account has been created successfully.");
			System.out.println("Your account is being reviewed.");
			System.out.println(
					"The bank admin must approve your account before you would be able be make transaction on it.");
			System.out.println("Log back in to see the status of your account.");
			System.out.println("Thanks, have a good day.");
		} else if (accDetails.get("status").equals("0")) {
			System.out.println("See Your account details below: ");
			System.out.println("Your account ID: " + username);
			System.out.println("First Name: " + accDetails.get("firstName"));
			System.out.println("Last Name: " + accDetails.get("lastName"));
			System.out.println("Your balance: " + accDetails.get("balance"));
			System.out.println(
					"Your account status: Your account has not been approved yet. So you can't make any transaction yet");
			System.out.println("Thank you!");
		} else {
			System.out.println("See Your account details below: ");
			System.out.println("Your account ID: " + username);
			System.out.println("First Name: " + accDetails.get("firstName"));
			System.out.println("Last Name: " + accDetails.get("lastName"));
			System.out.println("Balance: " + accDetails.get("balance"));
			System.out.println("Status: Active");

			transaction(myObj, accDetails.get("balance"), username);

		}
	}

	public static void transaction(Scanner myObj, String balance, String owner) {
		boolean isValidInput = false;
		String newBalance = balance;

		while (!isValidInput) {
			System.out.println("You can perform the following actions on your account");
			System.out.println("withdraw");
			System.out.println("deposit");
			System.out.println("transfer");
			System.out.println();

			System.out.print("Enter one of the following: ");
			String trans = myObj.nextLine();

			if (trans.equals("withdraw")) {
				newBalance = withdraw(newBalance, myObj, owner);
			} else if (trans.equals("deposit")) {
				newBalance = deposit(newBalance, myObj, owner);
			} else if (trans.equals("transfer")) {
				newBalance = transfer(newBalance, myObj, owner);
			} else {
				System.out.println("Invalid inputs enter one of these 'withdraw', 'deposit', 'transfer'");
			}

		}

	}

	public static String deposit(String balance, Scanner myObj, String owner) {
		boolean isValidInput = false;
		int updatedBal = Integer.parseInt(balance);
		Account account = new Account();
		String dep = null;

		while (!isValidInput) {
			System.out.println("Enter a deposit amount: ");
			dep = myObj.nextLine();
			try {
				int iDep = Integer.parseInt(dep);
				updatedBal += iDep;
				account.updateBalance(owner, Integer.toString(updatedBal));
				log.info("Depost: " + updatedBal);
				isValidInput = true;

			} catch (NumberFormatException e) {
				System.out.println("You entered an invalid input. Deposit amount should be positive numbers");
			}
		}
		System.out.println("You have successfully deposited $" + dep + " dollars to your account");
		System.out.println("Your balance is: " + Integer.toString(updatedBal));
		return Integer.toString(updatedBal);
	}

	public static String withdraw(String balance, Scanner myObj, String owner) {
		boolean isValidInput = false;
		int updatedBal = Integer.parseInt(balance);
		Account account = new Account();
		String dep = null;

		while (!isValidInput) {
			System.out.println("Enter a withdraw amount: ");
			dep = myObj.nextLine();
			try {
				int iDep = Integer.parseInt(dep);
				updatedBal = updatedBal - iDep;
				log.info("Withdrew: " + updatedBal);
				if (updatedBal < 0) {
					System.out.println("You can't withdraw more than your available balance");
				} else {
					account.updateBalance(owner, Integer.toString(updatedBal));
				}
				isValidInput = true;

			} catch (NumberFormatException e) {
				System.out.println("You entered an invalid input. Withdraw amount should be positive numbers");
			}
		}
		System.out.println("You have successfully withdrawn $" + dep + " dollars from your account");
		System.out.println("Your balance is: " + Integer.toString(updatedBal));
		return Integer.toString(updatedBal);
	}

	public static String transfer(String balance, Scanner myObj, String owner) {
		boolean isValidInput = false;
		int updatedBal = Integer.parseInt(balance);
		Account account = new Account();
		String dep = "";
		HashMap<String, String> accDetails = null;

		while (!isValidInput) {
			System.out.println("Enter a transfer amount: ");
			dep = myObj.nextLine();

			System.out.println("Enter the accountId of the recipent: ");
			String recipent = myObj.nextLine();
			if (recipent.trim().equals("") || dep.trim().equals("")) {
				System.out.println("Amount and accountid are required");
				continue;
			}
			accDetails = account.getAccountDetails(recipent);

			if (accDetails.isEmpty()) {
				System.out.println("The account Id you entered was not found");
				continue;
			}

			try {
				int iDep = Integer.parseInt(dep);
				updatedBal -= iDep;
				account.updateBalance(recipent.trim(),
						Integer.toString(iDep + Integer.parseInt(accDetails.get("balance"))));
				account.updateBalance(owner, Integer.toString(updatedBal));
				isValidInput = true;

			} catch (NumberFormatException e) {
				System.out.println("You entered an invalid input. Transfer amount should be positive number.");
			}
		}

		System.out.println("You have successfully transfered " + dep + " dollars to" + accDetails.get("owner"));
		System.out.println("Your balance is: " + Integer.toString(updatedBal));

		return Integer.toString(updatedBal);
	}

	// This is the User account method that allows user to deposit, withdraw, or
	// transfer funds to other accounts.
	public static void userAccount(Scanner myObj, String username) {
		System.out.println("Welcome to the user dashboard");
		System.out.println("");

		boolean isValidInput1 = false;
		Account account = null;
		account = new Account();

		ArrayList<HashMap<String, String>> accounts = account.getAllAccountDetails();

		for (int i = 0; i < accounts.size(); i++) {

			HashMap<String, String> accDetails = accounts.get(i);

			if (accDetails.get("owner").equals(username)) {
				System.out.println("Account ID: " + accDetails.get("owner"));
				System.out.println("First Name: " + accDetails.get("firstName"));
				System.out.println("Last Name: " + accDetails.get("lastName"));
				System.out.println("Balance: " + accDetails.get("balance"));
				if (accDetails.get("status").equals("1")) {
					System.out.println("Status: Active");
				} else {
					System.out.println("Status: Not active");
				}
				System.out.println();
			}

		}

		boolean isValidInput2 = false;
		String accountId = "0";
		String action = null;

		while (!isValidInput2) {
			System.out.println();
			accountId = myObj.nextLine();
			System.out.println(accountId);
			if (accountId == null || accountId.equals("")) {
				System.out.print("accountId is required");
			} else {
				HashMap<String, String> accDetails = account.getAccountDetails(accountId);

				if (accDetails.isEmpty()) {
					System.out.print("Account not found.");
					continue;
				}
				System.out.println("You can perform the following actions on this account: ");
				System.out.println("deposit");
				System.out.println("withdraw");
				System.out.println("transaction");
				System.out.println("exit");
				System.out.print("Enter an action: ");
				action = myObj.nextLine();

				if (action.equals("deposit")) {
					deposit(accDetails.get("balance"), myObj, accDetails.get("owner"));
				} else if (action.equals("withdraw")) {
					withdraw(accDetails.get("balance"), myObj, accDetails.get("owner"));
				} else if (action.equals("transfer")) {
					transfer(accDetails.get("balance"), myObj, accDetails.get("owner"));
				} else if (action.equals("transfer")) {
					boolean isValidEdit = false;

					while (!isValidEdit) {
						System.out.println("Enter the new first name: ");
						String firstName = myObj.nextLine();

						System.out.println("Enter the new last name: ");
						String lastName = myObj.nextLine();

						if (lastName.trim().equals("") || firstName.trim().equals("")) {
							System.out.println("Last name and First name is required");
						} else {
							account.edit(accDetails.get("owner"), firstName, lastName);
							isValidEdit = true;
						}
					}
				} else if (action.equals("exit")) {
					System.out.println("Goodbye");
					break;
				}
			}
		}
	}
	public static void employeeAccount(Scanner myObj) {
		System.out.println("Welcome to the employee dashboard");
		System.out.println("Below is the list of all the accounts");
		System.out.println("");

		boolean isValidInput = false;
		Account account = null;
		account = new Account();

		ArrayList<HashMap<String, String>> accounts = account.getAllAccountDetails();

		for (int i = 0; i < accounts.size(); i++) {
			HashMap<String, String> accDetails = accounts.get(i);

			System.out.println("Account ID: " + accDetails.get("owner"));
			System.out.println("First Name: " + accDetails.get("firstName"));
			System.out.println("Last Name: " + accDetails.get("lastName"));
			System.out.println("Balance: " + accDetails.get("balance"));
			if (accDetails.get("status").equals("1")) {
				System.out.println("Status: Active");
			} else {
				System.out.println("Status: Not active");
			}
			System.out.println();

		}

		boolean isValidInput1 = false;
		String accountId = null;
		String action = null;

		while (!isValidInput1) {
			System.out.println();
			System.out.println("Enter the Account ID you want to modify: ");
			accountId = myObj.nextLine();
			System.out.println(accountId);
			if (accountId == null || accountId.equals("")) {
				System.out.print("accountId is required");
			} else {
				HashMap<String, String> accDetails = account.getAccountDetails(accountId);

				if (accDetails.isEmpty()) {
					System.out.print("Account not found.");
					continue;
				}
				System.out.println("You can perform the following action on this account: ");
				System.out.println("delete");
				System.out.println("edit");
				if (accDetails.get("status").equals("0")) {
					System.out.println("approve");
				}
				System.out.println("exit");
				System.out.print("Enter an action: ");
				action = myObj.nextLine();

				if (action.equals("approve")) {
					account.updateStatus(accDetails.get("owner"), "1");
				} else if (action.equals("deposit")) {
					deposit(accDetails.get("balance"), myObj, accDetails.get("owner"));
				} else if (action.equals("withdraw")) {
					withdraw(accDetails.get("balance"), myObj, accDetails.get("owner"));
				} else if (action.equals("transfer")) {
					transfer(accDetails.get("balance"), myObj, accDetails.get("owner"));
				} else if (action.equals("transfer")) {
					boolean isValidEdit = false;

					while (!isValidEdit) {
						System.out.println("Enter the new first name: ");
						String firstName = myObj.nextLine();

						System.out.println("Enter the new last name: ");
						String lastName = myObj.nextLine();

						if (lastName.trim().equals("") || firstName.trim().equals("")) {
							System.out.println("Last name and First name is required");
						} else {
							account.edit(accDetails.get("owner"), firstName, lastName);
							isValidEdit = true;
						}
					}
				} else if (action.equals("exit")) {
					System.out.println("Goodbye");
					break;
				}
			}
		}
	}
	
	// This is the Admin account method that allows admin to approve account, or
	// deposit, withdraw, or transfer funds to other accounts.
	public static void adminAccount(Scanner myObj) {
		System.out.println("Welcome to the admin dashboard");
		System.out.println("Below is the list of all the accounts");
		System.out.println("");

		boolean isValidInput = false;
		Account account = null;
		account = new Account();

		ArrayList<HashMap<String, String>> accounts = account.getAllAccountDetails();

		for (int i = 0; i < accounts.size(); i++) {
			HashMap<String, String> accDetails = accounts.get(i);

			System.out.println("Account ID: " + accDetails.get("owner"));
			System.out.println("First Name: " + accDetails.get("firstName"));
			System.out.println("Last Name: " + accDetails.get("lastName"));
			System.out.println("Balance: " + accDetails.get("balance"));
			if (accDetails.get("status").equals("1")) {
				System.out.println("Status: Active");
			} else {
				System.out.println("Status: Not active");
			}
			System.out.println();

		}

		boolean isValidInput1 = false;
		String accountId = null;
		String action = null;

		while (!isValidInput1) {
			System.out.println();
			System.out.println("Enter the Account ID you want to modify: ");
			accountId = myObj.nextLine();
			System.out.println(accountId);
			if (accountId == null || accountId.equals("")) {
				System.out.print("accountId is required");
			} else {
				HashMap<String, String> accDetails = account.getAccountDetails(accountId);

				if (accDetails.isEmpty()) {
					System.out.print("Account not found.");
					continue;
				}
				System.out.println("You can perform the following action on this account: ");
				System.out.println("deposit");
				System.out.println("withdraw");
				System.out.println("transaction");
				System.out.println("delete");
				System.out.println("edit");
				if (accDetails.get("status").equals("0")) {
					System.out.println("approve");
				}
				System.out.println("exit");
				System.out.print("Enter an action: ");
				action = myObj.nextLine();

				if (action.equals("approve")) {
					account.updateStatus(accDetails.get("owner"), "1");
				} else if (action.equals("deposit")) {
					deposit(accDetails.get("balance"), myObj, accDetails.get("owner"));
				} else if (action.equals("withdraw")) {
					withdraw(accDetails.get("balance"), myObj, accDetails.get("owner"));
				} else if (action.equals("transfer")) {
					transfer(accDetails.get("balance"), myObj, accDetails.get("owner"));
				} else if (action.equals("transfer")) {
					boolean isValidEdit = false;

					while (!isValidEdit) {
						System.out.println("Enter the new first name: ");
						String firstName = myObj.nextLine();

						System.out.println("Enter the new last name: ");
						String lastName = myObj.nextLine();

						if (lastName.trim().equals("") || firstName.trim().equals("")) {
							System.out.println("Last name and First name is required");
						} else {
							account.edit(accDetails.get("owner"), firstName, lastName);
							isValidEdit = true;
						}
					}
				} else if (action.equals("exit")) {
					System.out.println("Goodbye");
					break;
				}
			}
		}
	}
}
