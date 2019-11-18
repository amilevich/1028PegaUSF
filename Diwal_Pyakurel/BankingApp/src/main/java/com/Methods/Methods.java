package com.Methods;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.accounts.Accounts;
import com.admin.Admin;
import com.employee.Employee;
import com.profiles.Customers;
import com.profiles.Profiles;

public class Methods implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Scanner sc = new Scanner(System.in);
	static Profiles currentUser;
	static Admin bankAdmin = new Admin();
	static Employee bankEmployee = new Employee();
	public final static Logger bankloggy = Logger.getLogger(Logger.class);

	//This method will take an input from user if they are customer or employee or admin and return the status as string
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

	//if the customer are new, this method will take response from user and return the selected options
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

	//this method will open a new account, which will be in pending state
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

			writeObject(customer, "pending.ser");
			bankloggy.info("Customer requests to open a joint account");

		} else {
			Customers customer = new Customers("userName", "password", firstName, secondName, social, false);

			writeObject(customer, "pending.ser");
			bankloggy.info("Customer request to open a single account");
		}

		System.out.println("The request to open the account has been submitted");

	}

	//this method will serialize the pending request
	public static void writeObject(Customers customer, String fileName) {

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		ArrayList<Customers> customerArray = readObject("pending.ser");
		customerArray.add(customer);

		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(customerArray);
			oos.close();
			fos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// Deserialize the pending acounts
	@SuppressWarnings("unchecked")
	public static ArrayList<Customers> readObject(String fileName) {
		ArrayList<Customers> customerArray = new ArrayList<Customers>();

		FileInputStream fis = null;
		ObjectInputStream oin = null;
		try {
			fis = new FileInputStream(fileName);
			oin = new ObjectInputStream(fis);

			if (fis.available() != 0) {
				customerArray = (ArrayList<Customers>) oin.readObject();
				oin.close();
			}

		} catch (Exception ex) {
			ex.printStackTrace();

		}

		return customerArray;
	}

	// Serialize the accounts object
	public static void writeAccounts(Accounts accounts) {
		String fileName = "accounts.ser";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		ArrayList<Accounts> accountsArray = readAccounts();
		accountsArray.add(accounts);

		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(accountsArray);
			oos.close();
			fos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
			bankloggy.info("App creats a new file");
		}
	}
	
	//Deserialize the accounts object

	@SuppressWarnings("unchecked")
	public static ArrayList<Accounts> readAccounts() {
		ArrayList<Accounts> accountsArray = new ArrayList<Accounts>();
		String fileName = "accounts.ser";
		FileInputStream fis = null;
		ObjectInputStream oin = null;
		try {
			fis = new FileInputStream(fileName);
			oin = new ObjectInputStream(fis);

			if (fis.available() != 0) {
				accountsArray = (ArrayList<Accounts>) oin.readObject();
				oin.close();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			bankloggy.info("App creats a new file");
		}
		return accountsArray;
	}

	//This method will take response from user regarding the deposit and will update the serialized array
	public static void addDeposits(int accountNumber, float x) {

		ArrayList<Accounts> allAccounts = Methods.readAccounts();

		for (int i = 0; i < allAccounts.size(); i++) {
			if (allAccounts.get(i).getAccounNo() == accountNumber) {
				float currentBalance = allAccounts.get(i).getBalance() + x;
				allAccounts.get(i).setBalance(currentBalance);
				System.out.println(allAccounts.get(i));
			}
		}

		String fileName = "accounts.ser";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(allAccounts);
			oos.close();
			fos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		bankloggy.info("A deposit has been made");

	}
	
	//This method will take response from user regarding the withdrawl and will update the serialized array

	public static void getWithdrawl(int accountNumber, float x) {

		ArrayList<Accounts> allAccounts = Methods.readAccounts();

		for (int i = 0; i < allAccounts.size(); i++) {
			if (allAccounts.get(i).getAccounNo() == accountNumber) {
				if (allAccounts.get(i).getBalance() > x) {
					float currentBalance = allAccounts.get(i).getBalance() - x;
					allAccounts.get(i).setBalance(currentBalance);
					System.out.println(allAccounts.get(i));
				} else {
					System.out.println("Sorry we could not process your request due to insufficient fund");
				}
				;
			}
		}

		String fileName = "accounts.ser";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(allAccounts);
			oos.close();
			fos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		bankloggy.info("A withdrawl has been done");

	}
	//This method will take response from user regarding the transfer and will update the serialized array
	public static void transfer(int ownAccountNumber, int otherAccountNumber, float x) {
		ArrayList<Accounts> allAccounts = Methods.readAccounts();

		boolean otherAccountFound = false;

		for (int i = 0; i < allAccounts.size(); i++) {
			if (allAccounts.get(i).getAccounNo() == otherAccountNumber) {
				otherAccountFound = true;
			}
		}

		if (!otherAccountFound) {
			System.out.println("Sorry we could not find an account");
		} else {
			Methods.addDeposits(otherAccountNumber, x);
			Methods.getWithdrawl(ownAccountNumber, x);
			System.out.println("Withdrawl Complete");
		}
		
		bankloggy.info("A transfer has been completed");

	}

	//this method will make sure that the accounts exists in the serialized file
	public static void viewAccounts(int accountNo) {
		ArrayList<Accounts> allAccounts = Methods.readAccounts();
		for (int i = 0; i < allAccounts.size(); i++) {
			if (allAccounts.get(i).getAccounNo() == accountNo) {
				allAccounts.get(i).toString();
				;
			}
		}

	}
//This method will serialize the user online profiles
	public static void writeProfiles(Profiles profiles) {
		String fileName = "profiles.ser";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		ArrayList<Profiles> profilesArray = readProfiles();
		profilesArray.add(profiles);

		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(profilesArray);
			oos.close();
			fos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
//deserialize online profiles
	@SuppressWarnings("unchecked")
	public static ArrayList<Profiles> readProfiles() {
		ArrayList<Profiles> profilesArray = new ArrayList<Profiles>();
		String fileName = "profiles.ser";
		FileInputStream fis = null;
		ObjectInputStream oin = null;

		try {
			fis = new FileInputStream(fileName);
			oin = new ObjectInputStream(fis);

			if (fis.available() != 0) {
				profilesArray = (ArrayList<Profiles>) oin.readObject();
				oin.close();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return profilesArray;
	}

	
	//This will prompt the user for admin options and give sub options once logged in
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

	//This will prompt the user for employees options and give sub options once logged in
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
//This method will verify the employee and will return boolean
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

	//if a new account is created then this method will update the profiles
	public static void updateOnlineProfiles(int social) {

		// use social and get all the accounts number in a list
		ArrayList<Profiles> allProfiles = Methods.readProfiles();
		ArrayList<Accounts> allAccounts = Methods.readAccounts();
		ArrayList<Integer> tempAllAccounts = new ArrayList<Integer>();

		for (int i = 0; i < allAccounts.size(); i++) {
			if (allAccounts.get(i).getLinkedSocial().contains(social)) {
				tempAllAccounts.add(allAccounts.get(i).getAccounNo());
			}
		}

		for (int j = 0; j < allProfiles.size(); j++) {
			if (allProfiles.get(j).getSocial() == social) {
				allProfiles.get(j).setAllAccounts(tempAllAccounts);
			}
		}

		String fileName = "profiles.ser";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(allProfiles);
			oos.close();
			fos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		System.out.println("Account update completed");

	}
//This method will give a series of steps to select a particular account
	public static int adminSelectsAccount() {

		ArrayList<Profiles> allProfiles = Methods.readProfiles();
		for (int i = 0; i < allProfiles.size(); i++) {
			System.out.println(i + 1 + " " + allProfiles.get(i).getUserName());
		}
		System.out.println("Please select the appropirate number");
		int serialNumber = sc.nextInt();
		sc.nextLine();
		System.out.println("Please select the appropirate number");
		for (int j = 0; j < allProfiles.get(serialNumber - 1).getAllAccounts().size(); j++) {
			System.out.println(j + 1 + " " + allProfiles.get(serialNumber - 1).getAllAccounts().get(j));
		}
		int secondSerialNumber = sc.nextInt();
		sc.nextLine();
		int accountSelected = allProfiles.get(serialNumber - 1).getAllAccounts().get(secondSerialNumber - 1);
		return accountSelected;
	}

	//This will verify admin and return boolean
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

	//Functionality to approve accounts
	public static void approvalOfAccounts() {

		ArrayList<Customers> pendingCustomerArray = Methods.readObject("pending.ser");

		for (int i = 0; i < pendingCustomerArray.size(); i++) {

			System.out.println("Do you want to APPROVE these accounts");
			System.out.println(pendingCustomerArray.get(i).toString());
			String adminResponse = sc.nextLine();

			if (adminResponse.equals("yes")) {
				Integer accounNo = Methods.accountGenerator();
				int balance = 0;
				Integer social1 = new Integer(pendingCustomerArray.get(i).getSocial());
				Integer social2 = new Integer(pendingCustomerArray.get(i).getSecondSocial());
				ArrayList<Integer> linkedSocial = new ArrayList<Integer>();
				linkedSocial.add(social1);
				linkedSocial.add(social2);
				Accounts accountCreated = new Accounts(accounNo, balance, linkedSocial);
				Methods.writeAccounts(accountCreated);

			} else if (adminResponse.equals("no")) {
				pendingCustomerArray.remove(i);

			} else {
				System.out.println("Admin, Please provide a valid response");
				Methods.approvalOfAccounts();
			}

		}

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		ArrayList<Customers> emptyCustomerArray = new ArrayList<Customers>();

		try {
			fos = new FileOutputStream("pending.ser");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(emptyCustomerArray);
			oos.close();
			fos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		System.out.println("No more accounts to verify");
	}

	//Random account generator
	public static Integer accountGenerator() {
		Random generator = new Random();
		Integer accountNo = generator.nextInt(9000000);
		return accountNo;

	}

	//This method will create online login if account exists
	public static void createOnlineProfile() {

		System.out.println("Please Enter your four disgit SSN to create an account");
		int social = sc.nextInt();
		sc.nextLine();
		ArrayList<Accounts> accounts = Methods.readAccounts();

		if (Methods.checkIfAccountExists(social)) {
			System.out.println("We were able to find your account");

			if (!Methods.checkifProfileExists(social)) {
				System.out.println("Lets Go and create your Online Account");

				ArrayList<Integer> allAccounts = new ArrayList<Integer>();
				for (int i = 0; i < accounts.size(); i++) {
					if (accounts.get(i).getLinkedSocial().contains(social)) {
						allAccounts.add(accounts.get(i).getAccounNo());
					}
				}
				System.out.println("Please provide us a userName for your account");
				String userName = sc.nextLine();
				System.out.println("Please provide us a password to protect your account");
				String password = sc.nextLine();
				Profiles profiles = new Profiles(userName, password, social, allAccounts);

				Methods.writeProfiles(profiles);
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
		ArrayList<Accounts> accounts = Methods.readAccounts();
		boolean check = false;
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getLinkedSocial().contains(social)) {
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

		ArrayList<Profiles> profiles = Methods.readProfiles();

		for (int i = 0; i < profiles.size(); i++) {
			if (profiles.get(i).getSocial() == social) {

				return true;
			}
		}

		return false;

	}
	
	//Will prompt options for customer

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
							currentUser.withdrawl();
						} else if (depWith.equals("transfer")) {
							currentUser.transfer();
						} else if (depWith.equals("view")) {
							currentUser.viewAccount();
						} else if (depWith.equals("exit")) {
							continueDep = false;
						} else if (depWith.equals("update")) {
							Methods.updateOnlineProfiles(currentUser.getSocial());
						} else {
							System.out.println("Please provide a valid response");
						}

					} else {
						System.out.println("Account not verified");
					}
					continueDep = false;
					ArrayList<Accounts> ac = Methods.readAccounts();
					System.out.println(ac);

				}

			} else if (newOrOld.equals("exit")) {
				keepAsking = false;
			} else {
				System.out.println("Please provide a valid response");
			}

		}

	}

	//Will verify the login and return true or false
	public static boolean customerLogin() {
		ArrayList<Profiles> profiles = Methods.readProfiles();

		boolean credentialsProvided = false;
		boolean keeplooping = true;

		while (keeplooping) {
			System.out.println("User, Please provide me your username");
			String userName = sc.nextLine().toLowerCase().trim();
			System.out.println("User, Please provide me your password");
			String password = sc.nextLine().toLowerCase().trim();
			for (int i = 0; i < profiles.size(); i++) {

				if (userName.equals(profiles.get(i).getUserName()) && password.equals(profiles.get(i).getPassword())) {

					System.out.println("We found your account");
					currentUser = profiles.get(i);
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

	//Method to view alla ccounts
	public static void viewAccount(int account) {
		ArrayList<Accounts> allAccounts = Methods.readAccounts();

		for (int i = 0; i < allAccounts.size(); i++) {
			if (allAccounts.get(i).getAccounNo() == account) {
				allAccounts.remove(i);
			}

		}

		String fileName = "accounts.ser";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(allAccounts);
			oos.close();
			fos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	//Will validate the float value
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
	//Will validate the int value
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
