package com.Methods;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.accounts.Accounts;
import com.admin.Admin;
import com.dao.DaoAccountsTml;
import com.dao.DaoProfilesTmpl;
import com.dao.DaoRegistrationTmpl;
import com.employee.Employee;
import com.profiles.Customers;
import com.profiles.Profiles;

public class Methods  {
	/**
	 * 
	 */
	
	static Scanner sc = new Scanner(System.in);
	static Profiles currentUser;
	static Admin bankAdmin = new Admin();
	static Employee bankEmployee = new Employee();
	public final static Logger bankloggy = Logger.getLogger(Logger.class);

	public static DaoRegistrationTmpl regs = new DaoRegistrationTmpl();
	public static DaoProfilesTmpl profs = new DaoProfilesTmpl();
	public static DaoAccountsTml accts = new DaoAccountsTml();

	// This method will take an input from user if they are customer or employee or
	// admin and return the status as string
	
	
	public static String firstQuestion() {
		System.out.println("Called from ask if FirstQuestion");
		System.out.println("Type CUSTOMER for customer");
		System.out.println("Type ADMIN for admin");
		System.out.println("Type EMPLOYEE for employee");
		System.out.println("Type EXIT to exit from the application");

		String userStatus = sc.nextLine().toLowerCase().trim();

		if (userStatus.equals("customer")) {
			System.out.println("Hi Welcome to customer login");
		} else if (userStatus.equals("employee")) {
			System.out.println("Hi Welcome to Employee login");
		} else if (userStatus.equals("admin")) {
			System.out.println("Hi Welcome to Admin login");
		} else if (userStatus.equals("Exit")) {
			System.out.println("Thank you for visiting us, Have a nice day");
		}
		return userStatus;

	}

	// if the customer are new, this method will take response from user and return
	// the selected options
	public static String askifNew() {
		System.out.println("Called from ask if New Method");
		boolean keepAsking = true;
		String newOrOld = "";
		while (keepAsking) {
			System.out.println("Please provid a response");
			System.out.println("Type NEW: I want to open a NEW account");
			System.out.println("Type REGISTER: I want to create my online/login credentials");
			System.out.println("Type ONLINE: To Create Online Account");
			System.out.println("Type EXIT to exit from this menu");
			newOrOld = sc.nextLine();
			newOrOld = newOrOld.toLowerCase();

			if (newOrOld.equals("new") || newOrOld.equals("register") || newOrOld.equals("online")
					|| newOrOld.equals("exit")) {
				keepAsking = false;
			}

		}
		return newOrOld;
	}

	// this method will open a new account, which will be in pending state
	public static void openAccount() {

		System.out.println("Will this be a joint account? Type YES or NO");
		String singleOrJoint = sc.nextLine();
		singleOrJoint.toLowerCase();

		System.out.println("Please provide me your first name");
		String firstName = sc.nextLine();
		System.out.println("Please provide me your second name");
		String secondName = sc.nextLine();

		System.out.println("Please provide me your social");
		int social = sc.nextInt();
		sc.nextLine();

		if (singleOrJoint.equals("yes")) {
			System.out.println("Please provide the second user full name");
			String secondUserFullname = sc.nextLine();
			System.out.println("Please provide the social of second user");
			int secondUserSocial = sc.nextInt();
			sc.nextLine();
			Customers customer = new Customers("userName", "password", firstName, secondName, social, true,
					secondUserFullname, secondUserSocial);

			regs.insertRegistration(customer);
		
			bankloggy.info("Customer requests to open a joint account");

		} else {
			Customers customer = new Customers("userName", "password", firstName, secondName, social, false);
			
			regs.insertRegistration(customer);
			bankloggy.info("Customer request to open a single account");
		}

		System.out.println("The request to open the account has been submitted");

	}


	// This will prompt the user for admin options and give sub options once logged in
	public static void adminOptions() {

		boolean keepLooping = true;
		boolean verificationPassed = Methods.getAdminVerified();

		if (verificationPassed) {

			while (keepLooping) {
				System.out.println("Please provide a valid response");
				System.out.println("To make withdraw on an account - Type WITHDRAW");
				System.out.println("To add deposit on an account - Type Deposit");
				System.out.println("To transfer from  accounts - Type Transfer");
				System.out.println("To approve  an account - Type APPROVE");
				System.out.println("To view  an account - Type VIEW");
				System.out.println("To cancel an account - Type CANCEL");
				System.out.println("To Exit from this menu- Type EXIT");
				String adminOption = sc.nextLine();

				adminOption = adminOption.toLowerCase().trim();

				if (adminOption.equals("withdraw")) {
					bankAdmin.withdrawl();
				} else if (adminOption.equals("deposit")) {
					bankAdmin.deposit();
				} else if (adminOption.equals("withdraw")) {
					bankAdmin.withdrawl();
				} else if (adminOption.equals("transfer")) {
					bankAdmin.transfer();
				} else if (adminOption.equals("approve")) {
					bankAdmin.approveAccount();
				} else if (adminOption.equals("cancel")) {
					bankAdmin.deleteAccount();
				} else if (adminOption.equals("view")) {
					System.out.println("admin methods view");
					bankAdmin.viewAccount();
				} else if (adminOption.equals("exit")) {
					keepLooping = false;
				} else {
					System.out.println("Not a valid response");
				}

			}

		}

	}

	// This will prompt the user for employees options and give sub options once
	// logged in
	public static void employeeOptions() {

		boolean keepLooping = true;
		boolean verificationPassed = Methods.getEmployeeVerified();

		if (verificationPassed) {

			while (keepLooping) {
				System.out.println("Please provide a valid response");
				System.out.println("To make withdraw on an account - Type WITHDRAW");
				System.out.println("To add deposit on an account - Type Deposit");
				System.out.println("To transfer from  accounts - Type Transfer");
				System.out.println("To view from  accounts - Type View");
				System.out.println("To Exit from this menu- Type EXIT");
				String employeeOptions = sc.nextLine().toLowerCase().trim();

				if (employeeOptions.equals("withdraw")) {
					bankEmployee.withdrawl();
				} else if (employeeOptions.equals("deposit")) {
					bankEmployee.deposit();
				} else if (employeeOptions.equals("transfer")) {
					bankEmployee.transfer();
				} else if (employeeOptions.equals("view")) {
					bankEmployee.viewAccount();
				} else if (employeeOptions.equals("exit")) {
					keepLooping = false;
				} else {
					System.out.println("Not a valid response");
				}

			}

		}

	}

	// This method will verify the employee and will return boolean
	public static boolean getEmployeeVerified() {

		boolean employeeVerified = false;

		while (!employeeVerified) {
			System.out.println("Employee, Please insert your pin number");
			int pin = sc.nextInt();
			sc.nextLine();
			System.out.println(pin);
			if (bankEmployee.getPinCode() == pin) {
				employeeVerified = true;
				return employeeVerified;
			} else {
				System.out.println("Employee, Do you want to continue");
				String adminResponse = sc.nextLine().toLowerCase().trim();
				if (adminResponse.equals("no")) {
					System.out.println("Sorry, We could not verify the employee");
					return false;
				}
			}

		}
		return employeeVerified;
	}

	// if a new account is created then this method will update the profiles


	// This method will give a series of steps to select a particular account
	public static int adminSelectsAccount() {

		ArrayList<Profiles> allProfiles = profs.getUsers();
		ArrayList<Accounts> allAccounts = accts.getAllAccounts();
		
		System.out.println("Please select the appropirate number");
		for(int i = 0; i<allProfiles.size(); i++) {
			System.out.println(i + 1 + " " + allProfiles.get(i).getUserName());
		}
		
		int serialNumber = sc.nextInt();
		sc.nextLine();
		
		int social = allProfiles.get(serialNumber-1).getSocial();
		
		System.out.println("Please select the appropirate number");
		
		for(int j = 0; j<allAccounts.size(); j++) {
			if(allAccounts.get(j).getSocial()==social) {
				System.out.println(" " + allAccounts.get(j).getAccounNo());
			}
		}
		
		System.out.println("Please Type the appropirate account number");
		System.out.println("Please type 000000 to exit");
		int accountSelected = sc.nextInt();
		sc.nextLine();
		
		return accountSelected;
		
	}
			

	// This will verify admin and return boolean
	public static boolean getAdminVerified() {

		boolean adminVerified = false;

		while (!adminVerified) {
			System.out.println("Admin Please insert your pin number");
			int pin = sc.nextInt();
			sc.nextLine();
			if (bankAdmin.getPinCode() == pin) {
				adminVerified = true;
				return adminVerified;
			} else {
				System.out.println("Admin, Do you want to continue");
				String adminResponse = sc.nextLine().toLowerCase().trim();
				if (adminResponse.equals("no")) {
					System.out.println("Sorry, We could not verify admin");
					return false;
				}
			}

		}
		return adminVerified;
	}

	// Functionality to approve accounts
	public static void approvalOfAccounts() {

		// ArrayList<Customers> pendingCustomerArray =
		// Methods.readObject("pending.ser");
		ArrayList<Customers> pendingCustomerArray = regs.getAllRegistration();

		for (int i = 0; i < pendingCustomerArray.size(); i++) {

			System.out.println("Do you want to APPROVE these accounts");
			System.out.println(pendingCustomerArray.get(i).toString());
			String adminResponse = sc.nextLine();

			if (adminResponse.equals("yes")) {

				Integer accounNo = Methods.accountGenerator();

				Accounts account1 = new Accounts(accounNo, 0, null, pendingCustomerArray.get(i).getSocial());
				Accounts account2 = new Accounts(accounNo, 0, null, pendingCustomerArray.get(i).getSecondSocial());

				accts.insertAccounts(account1);
				accts.insertAccounts(account2);

				System.out.println("Account added in the system");

			}

		}

		regs.deleteRegistration();
		System.out.println("No more account to review");
		accts.deleteUnrequired();
	}

	// Random account generator
	public static Integer accountGenerator() {
		Random generator = new Random();
		Integer accountNo = generator.nextInt(9000000);
		return accountNo;

	}

	// This method will create online login if account exists
	public static void createOnlineProfile() {

		System.out.println("Please Enter your four disgit SSN to create an account");
		int social = sc.nextInt();
		sc.nextLine();
		ArrayList<Accounts> accounts = accts.getAllAccounts();

		if (Methods.checkIfAccountExists(social)) {
			System.out.println("We were able to find your account");

			if (!Methods.checkifProfileExists(social)) {
				System.out.println("Lets Go and create your Online Account");

				System.out.println("Please provide us a userName for your account");
				String userName = sc.nextLine();
				System.out.println("Please provide us a password to protect your account");
				String password = sc.nextLine();
				Profiles profiles = new Profiles(userName, password, social, null);

				profs.insertUsers(profiles);

				
				System.out.println("Accounts sucessfully created");

			} else {
				System.out.println("Looks like you already have an account");

			}

		} else {
			System.out.println("Sorry We were not able to find your account");
		}

	}

	// Test to check if the account exists
	public static boolean checkIfAccountExists(int social) {
		ArrayList<Accounts> accounts = accts.getAllAccounts();
		boolean check = false;
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getSocial() == social) {
				check = true;
				break;
			} else {
				check = false;
			}
		}

		return check;

	}

	// This methods will check if online login exists already in the system
	public static boolean checkifProfileExists(int social) {

		ArrayList<Profiles> profiles = profs.getUsers();

		for (int i = 0; i < profiles.size(); i++) {
			if (profiles.get(i).getSocial() == social) {

				return true;
			}
		}

		return false;

	}

	// Will prompt options for customer

	public static void customerOptions() {

		boolean keepAsking = true;

		while (keepAsking) {

			System.out.println("#############CUSTOMER MENU############");
			String newOrOld = Methods.askifNew();
			if (newOrOld.equals("new")) {
				Methods.openAccount();
			} else if (newOrOld.equals("register")) {
				// Provide the logic if old
				Methods.createOnlineProfile();
			} else if (newOrOld.equals("online")) {
				// online account
				boolean onlineAccountVerified = Methods.customerLogin();
				System.out.println(onlineAccountVerified);

				boolean continueDep = true;
				while (continueDep) {

					if (onlineAccountVerified) {
						System.out.println("Type DEPOSIT if you want to deposit");
						System.out.println("Type WITHDRAW if you want to withdraw");
						System.out.println("Type TRANSFER if you want to transfer funds");
						System.out.println("Type UPDATE if you want to view your account");
						System.out.println("Type VIEW if you want to view your account");
						System.out.println("Type EXIT if you want to exit from the menu");
						String depWith = sc.nextLine().toLowerCase().trim();
						if (depWith.equals("deposit")) {
							currentUser.deposit();

						} else if (depWith.equals("withdraw")) {
							currentUser.withdrawl();
						} else if (depWith.equals("transfer")) {
							currentUser.transfer();
						} else if (depWith.equals("view")) {
							currentUser.viewAccount();
						} else if (depWith.equals("exit")) {
							continueDep = false;
						} else if (depWith.equals("update")) {
							//Methods.updateOnlineProfiles(currentUser.getSocial());
						} else {
							System.out.println("Please provide a valid response");
						}

					} else {
						System.out.println("Account not verified");
					}
					continueDep = false;
					//ArrayList<Accounts> ac = Methods.readAccounts();
					//System.out.println(ac);

				}

			} else if (newOrOld.equals("exit")) {
				keepAsking = false;
			} else {
				System.out.println("Please provide a valid response");
			}

		}

	}

	// Will verify the login and return true or false
	public static boolean customerLogin() {
		ArrayList<Profiles> allProfiles = profs.getUsers();

		boolean credentialsProvided = false;
		boolean keeplooping = true;

		while (keeplooping) {
			System.out.println("User, Please provide me your username");
			String userName = sc.nextLine().toLowerCase().trim();
			System.out.println("User, Please provide me your password");
			String password = sc.nextLine().toLowerCase().trim();
			for (int i = 0; i < allProfiles.size(); i++) {

				if (userName.equals(allProfiles.get(i).getUserName())
						&& password.equals(allProfiles.get(i).getPassword())) {

					System.out.println("We found your account");
					currentUser = allProfiles.get(i);
					System.out.println(currentUser);
					credentialsProvided = true;
					keeplooping = false;
					return true;
				}

			}
			System.out.println("Credentials MisMatch, Want Cont?");
			String userResponse = sc.nextLine();
			if (userResponse.equals("no")) {
				credentialsProvided = false;
				keeplooping = false;
				return false;
			}

		}
		return credentialsProvided;
	}



	// get all the acounts linked with social

	public static ArrayList<Integer> getCustomerAccounts(int social) {

		ArrayList<Accounts> allActs = accts.getAllAccounts();
		ArrayList<Integer> customerAccts = new ArrayList<>();

		for (int i = 0; i < allActs.size(); i++) {
			if (allActs.get(i).getSocial() == social) {
				customerAccts.add(allActs.get(i).getAccounNo());
			}
		}
		return customerAccts;

	}

	// Will validate the float value
	public static float getFloatvalue(String string) {
		boolean inputPassed = false;
		float depositAmt = 0;

		while (!inputPassed) {
			try {
				System.out.println(string);
				depositAmt = sc.nextFloat();
				sc.nextLine();
				inputPassed = true;

			} catch (InputMismatchException e) {
				System.out.println("Input MissMatch");
				sc.nextLine();
			}
		}
		;

		return depositAmt;

	}

	// Will validate the int value
	public static int getIntvalue(String string) {
		boolean inputPassed = false;
		int intValue = 0;

		while (!inputPassed) {
			try {
				System.out.println(string);
				intValue = sc.nextInt();
				sc.nextLine();
				inputPassed = true;

			} catch (InputMismatchException e) {
				System.out.println("Input MissMatch");
				sc.nextLine();
			}
		}
		;

		return intValue;

	}

}
