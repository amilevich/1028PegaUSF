package com.example.partone;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class Account {

	private String username;
	private String password;
	private String fName;
	private String lName;
	private int birthM;
	private int birthD;
	private int birthY;
	protected static String accountType; // Single, Joint
	private int userType; // client = 0, employee = 1, system admin = 2
	public String names;
	public int date;
	public static int accountKey;
	protected  boolean accountExists = false;


	public boolean validInput;
	Scanner sc = new Scanner(System.in);
	public String yn; // use as yes or no option in scanner

	////////////////////////////////////////////////////////
	////getters and setters ////// /////////////////////////
	///////////////////////////////////////////////////////
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		Account.accountType = accountType;
	}
	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public int getBirthY() {
		return birthY;
	}

	public void setBirthY(int birthY) {
		this.birthY = birthY;
	}

	public int getBirthM() {
		return birthM;
	}

	public void setBirthM(int birthM) {
		this.birthM = birthM;
	}

	public int getBirthD() {
		return birthD;
	}

	public void setBirthD(int birthD) {
		this.birthD = birthD;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	////////////////////////////////////////////////////////
	////creating an actual account /////////////////////////
	///////////////////////////////////////////////////////
	public void createAccount(HashMap<Integer, SystemAdmin> bankAccounts) { // using this as constructor but might want
																			// to change into main driver?
		System.out.println("Please enter a username below");
		while (!validInput) {
			username = sc.nextLine();
			for (Entry<Integer, SystemAdmin> en : bankAccounts.entrySet()) { // iterate through all members in
				if (username == en.getValue().getUsername()) {
					accountExists = true;;
					break;
				}
			}
			if(accountExists) {
				System.out.println("Invalid. Usenrame already exists");
			}
			else if (username.length() < 1) { // change to check that username is NOT taken
				System.out.println("Invalid. Username needs to have at least one character");
			} else {
				break;
			}
		}
		//////////////////////////////////////////////////////////////////////////////////////////////
		///// setting up password
		////////////////////////////////////////////////////////////////////////////////////////////// //////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("Please enter a password below");
		while (!validInput) {
			password = sc.nextLine();
			if (password.length() < 1) { // change to verify password meets specs
				System.out.println("Invalid. errors occurred in creating a password");
			} else {
				break;
			}
		}
		setUsername(username);
		setPassword(password);
		//////////////////////////////////////////////////////////////////////////////////////////////
		///// setting up account
		////////////////////////////////////////////////////////////////////////////////////////////// information//////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("Please enter your first name below");
		while (!validInput) {
			names = sc.nextLine();
			if (names == " ") {
				System.out.println("Please enter at least one character");
			} else {
				break;
			}
		}
		setfName(names);

		System.out.println("Please enter your last name below");
		while (!validInput) {
			names = sc.nextLine();
			if (names == " ") {
				System.out.println("Please enter at least one character");
			} else {
				break;
			}
		}
		setlName(names);

		System.out.println("Please enter your birth month");
		while (!validInput) {
			date = sc.nextInt();
			if ((date < 1) || date > 12) {
				System.out.println("Months fall between 1-12");
			} else {
				break;
			}
		}
		setBirthM(date);

		System.out.println("Please enter your birth day");
		while (!validInput) {
			date = sc.nextInt();
			if ((date < 1) || date > 31) {
				System.out.println("Dates fall between 1-31");
			} else {
				break;
			}
		}
		setBirthD(date);

		System.out.println("Please enter your birth year");
		while (!validInput) {
			date = sc.nextInt();
			if ((date < 1923) || date > 2001) {
				System.out.println("Years fall between 1923-2001");
			} else {
				break;
			}

		}
		setBirthY(date);

		System.out.println("Awesome, your account is in pending. Log in after employee approval has been confirmed");
	}

}
