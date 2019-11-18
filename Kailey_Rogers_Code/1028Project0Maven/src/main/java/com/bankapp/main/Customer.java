package com.bankapp.main;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Customer extends Account {

	private String userUsername;
	private String userPassword;
	private String userFirstName;
	private String userLastName;
	private String jointUserUsername;
	private String userAccountApply;
	public static final boolean validInput = false;
	public static int flag = 0;
	public static int flag1 = 0;

	// Getters and setters
	public String getUserUsername() {
		return userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	public String getJointUserUsername() {
		return jointUserUsername;
	}

	public void setJointUserUsername(String jointUserUsername) {
		this.jointUserUsername = jointUserUsername;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserAccountApply() {
		return userAccountApply;
	}

	public void setUserAccountApply(String userAccountApply) {
		this.userAccountApply = userAccountApply;
	}

//	@Override
//	public String toString() {
//		return "[Username = " + userUsername + "]  [userPassword = " + userPassword + "]  [First Name= "
//				+ userFirstName + "]  [Last Name=" + userLastName + "]  [Joint Username =" + jointUserUsername
//				+ "]  [Account Applied for = " + userAccountApply + "]" + "\n";
//	}

	// Account Creation
	public void accountSignUp(HashMap<String, Customer> signup) {
		Scanner sc = new Scanner(System.in);
		while (!validInput && flag == 0) {
			// set Username
			System.out.print("Time to create your account.  Please enter your username: ");
			String temp;
			while (!validInput) {
				boolean userExists = false;
				temp = sc.nextLine();
				for (Entry<String, Customer> en : signup.entrySet()) {
					//if user exists
					if (temp.equals(en.getValue().getUserUsername())) {
						System.out.println("User already exists.  Please try again.");
						userExists = true;
						break;
					}
				}
				//if no input
				if (temp.length() <= 0) {
					System.out.println("Invalid username length.  Please enter a valid username.");
				} else if (!userExists) {
					break;
				}
			}
			setUserUsername(temp);

			// set password
			System.out.print("Username set.  Please enter your password: ");
			while (!validInput) {
				temp = sc.nextLine();
				if (temp.length() <= 0) {
					System.out.println("Invalid password length.  Please enter a valid password.");
				} else {
					break;
				}
			}
			setUserPassword(temp);

			// set first name
			System.out.print("Password set.  Please enter your first name: ");
			while (!validInput) {
				temp = sc.nextLine();
				if (temp.length() <= 0) {
					System.out.println("Invalid first name length.  Please enter a valid first name.");
				} else {
					break;
				}
			}
			setUserFirstName(temp);

			// set last name
			System.out.print("Please enter your last name: ");
			while (!validInput) {
				temp = sc.nextLine();
				if (temp.length() <= 0) {
					System.out.println("Invalid last name length.  Please enter a valid last name.");
				} else {
					break;
				}
			}
			setUserLastName(temp);

			// applying for a single or joint account
			System.out.print("Thank you for the info.  Are you applying for a single account or a joint account: ");
			while (!validInput) {
				temp = sc.nextLine();
				// single account
				if (temp.equals("single")) {
					System.out.println(
							"Application for single account has been sent to our employees for approval.  Once approved, you may"
									+ " log in.  Thank you.");
					setUserAccountApply("single");
					break;
					// joint account
				} else if (temp.equals("joint")) {
					System.out.print("Which user would you like to have a joint account with: ");
					temp = sc.nextLine();
					boolean userExists = false;
					// if user exists
					for (Entry<String, Customer> en : signup.entrySet()) {
						if (temp.equals(en.getValue().getUserUsername())) {
							System.out.println(
									"Application for a joint account has been sent to our employess for approval.  Once approved, you may"
											+ " log in.  Thank you.");
							userExists = true;
							setUserAccountApply("joint");
							break;
							// if user does not exist
						} else {
							System.out.print("User does not exist.  Please enter a valid user: ");
						}
					}
					// invalid account type entered
				} else {
					System.out.println("Input invalid.  Please enter a valid account type.");
				}
				// this.setStatus("pending");
				// System.out.println(getStatus());
				// System.out.println(this.getStatus());
				setUserAccountApply(temp);
			}
			flag = 1;
		}
		this.setStatus("pending");
		flag = 0;
	}
}