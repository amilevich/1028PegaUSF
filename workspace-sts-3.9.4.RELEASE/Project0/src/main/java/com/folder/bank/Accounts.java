package com.folder.bank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.folder.dao.CustomerDaoImpl;

public class Accounts implements Serializable {
	/**
	 * Java Docs
	 */
	private static final long serialVersionUID = 2766760989820227774L;
	Random randomGen = new Random();
	private int accountID = randomGen.nextInt(100);
	private boolean isJoint;
	private String status;
	private static int balance;

	// Scanners
	static Scanner input = new Scanner(System.in);
	
	//Loggy the Logger
	final static Logger loggy = Logger.getLogger(Accounts.class);

	// Instantiate of ArrayList
	public static ArrayList<Customers> accountsPending = new ArrayList<Customers>();
	public static ArrayList<Customers> accountsApproved = new ArrayList<Customers>();

	// Iterator
	static Iterator<Customers> iterPending = accountsPending.iterator();
	static Iterator<Customers> iterApproved = accountsApproved.iterator();

	static // Instantiate of Classes
	Customers newCustomer = new Customers();
	Employees employee = new Employees();
	Admin admin = new Admin();
	public static CustomerDaoImpl cusDao = new CustomerDaoImpl();

	// Text File
	static String filename = "./bankPen.txt";
	static String filename2 = "./bankApp.txt";

	static // Unrelated Variable
	int option;
	static int counter = 0;
	static int flag = 0;

	// *******************************************************************************************************************
	// Main Menu

	public static void menu() {
		//readObject(filename);
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("\n");
		//readObject2(filename2);s
		System.out.println("\n");
		System.out.println(" \n");
		System.out.println("\t  [̲̅$̲̅(̲̅ ᵕ꒳ᵕ)̲̅$̲̅]");
		System.out.println("        *****Bank*****");
		System.out.println("      *****Main Menu*****");
		System.out.println(" \n");
		System.out.println("\t 1. Customer");
		System.out.println("\t 2. Employee");
		System.out.println("\t 3. Admin");
		System.out.println("\t 4. Registration");
		System.out.println("\t 5. Done");
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("\n");
		
		// * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
		// Switch 1. Login
		// Switch 2. Registration
		try {
			String option = input.next();

			flag = 0;
			switch (option) {
			case "1":
				// Customer Login
				customerLogin();
				break;
			case "2":
				// Employee Login
				employeeLogin();
				break;
			case "3":
				// Admin login
				adminLogin();
				break;
			case "4":
				registration();
				break;
			case "5":
				System.out.println("Saved & Updated file");
				System.out.println("See ya next time! (´▽`)b");
				writeObject(filename, accountsPending);
				writeObject(filename2, accountsApproved);
			default:
				menu();
			}

		} catch (Exception e) {
			//System.out.println("Invalid user input. Da fook");
			menu();
		}
	}

	public void transfer(double transferAm, Customers send, Customers recieve) {
		double transferA = 100.00;
		System.out.println("Get account balance " + accountsApproved.get(getBalance()));

	}

	// *******************************************************************************************************************
	// Customer Login
	public static void customerLogin() {
		flag = 1;
		System.out.println("");
		System.out.println("");
		System.out.println("*****Customer Login Page*****");
		System.out.println("");
//		System.out.println(cusDao.);
		// Customer Login Username //Thanks
		System.out.println("Provide ID:");
		int userIDCredential;
		while (true) {
			String tempy = input.next();
			try {
				// userIDCredential = Integer.parseInt(tempy);
				userIDCredential = Integer.valueOf(tempy);
				break;
			} catch (Exception e) {
				System.out.println("Invlaid please enter a number");
			}
		}

		// Customer Login Password
		System.out.println("Provide Password: ");
		String passCredential = input.next();

		for (Customers customer : accountsApproved) {
			if (userIDCredential == customer.getCustomerId() && passCredential.equals(customer.getPassword()) && customer.getPendingApproved() == 1) {
				System.out.println("\n");
				System.out.println("\t Login credential valid (´▽`)b");
				loggy.info(customer.getCustomerId() + "Customer Login Successful");
				System.out.println("");
				System.out.println("");
				System.out.println("\t 1. Display");
				System.out.println("\t 2. Deposit");
				System.out.println("\t 3. Withdraw");
				System.out.println("\t 4. Transfer Money");
				System.out.println("\t 5. Done");
				String option = input.next();

				switch (option) {
				case "1":
					System.out.println("\t ****Display info****");
					customerList(accountsApproved, userIDCredential);
					customerLogin();
					break;
				case "2":
					System.out.println("\t ****Deposit****");
					deposit(accountsApproved, userIDCredential);
					loggy.info("Customer -- Deposited money" + customer.getTotalBalance());
					customerLogin();
					break;
				case "3":
					System.out.println("\t ****Withdraw****");
					withdraw(accountsApproved, userIDCredential);
					loggy.info("Customer -- Withdrew money" + customer.getTotalBalance());
					customerLogin();
					break;
				case "4":
					System.out.println("\t ****Transfer Money****");
					System.out.println("\n");
					System.out.println("Enter account ID to transfer the money:");
					System.out.println("\n");
					int id = input.nextInt();
					System.out.println("\n");

					int flag = 0;
					for (Customers i : accountsApproved) {
						if (id == i.getCustomerId()) {
							System.out.println("User Id: " + i.getUsername());
							System.out.println("Customer ID:" + i.getCustomerId());
							System.out.println("Username: " + i.getUsername());
							System.out.println("Balance: " + i.getTotalBalance());
							System.out.println("\n");
							System.out.println("\t 1. Send Money!!!");
							String optionss = input.next();

							switch (optionss) {
							case "1":

								System.out.println("How much do you wanna send?");
								int sendMon = input.nextInt();
								i.setTotalBalance(i.getTotalBalance() + sendMon);

								System.out.println("\t ****Receipt****");
								System.out.println("TToTTal balance: " + i.getTotalBalance());
								System.out.println("Total recieved from " + i.getUsername() + ": " + i.getTotalBalance());
								System.out.println("Balance : " + i.getTotalBalance());
								customer.setTotalBalance(customer.getTotalBalance() - sendMon);
								flag = 1;
								System.out.println("This is the thing" + i);
								cusDao.updateCustomer(i);
								cusDao.updateCustomer(customer);
								loggy.info("Customer -- Transfer money to " + i.getUsername() + " amount: " + sendMon);
								break;
							}
						}
						if (flag == 1) {
							break;
						}
					}
					break;
				case "5":
					System.out.println("\t Done");
					menu();
					break;
				default:
					System.out.println("Done");
					System.out.println("Nice going you broke it...");
					break;
				}
			}// else {
//				System.out.println("Error statement");
//				loggy.warn("Login Error!!!!");
//			}
		}
		
		customerLogin();
	}

	// *******************************************************************************************************************
	// Employee Login
	public static void employeeLogin() {
		flag = 2;
		System.out.println("\n");
		System.out.println("\t *****Employee Login Page*****");
		System.out.println("");

		// Employee Login Username
		Employees employee = new Employees();
		System.out.println("\t Provide Employee Username:");
		String emCredential = input.next();

		// Employee Login Password
		System.out.println("\t Em Password: ");
		String passCredential = input.next();

		if (emCredential.equals(employee.getEmUsername()) && passCredential.equals(employee.getEmPassword())) {
			loggy.info("Employee Login Successful");
			System.out.println("\n");
			System.out.println("\t 1. View All Accounts");
			System.out.println("\t 2. Approve/Decline Accounts");
			System.out.println("\t 3. Done");
			String option = input.next();

			switch (option) {
			case "1":
				System.out.println("\t View All Accounts");
				if (accountsPending.isEmpty() && accountsApproved.isEmpty()) {
					System.out.println("");
					System.out.println("");
					System.out.println("\t No Accounts...Register to continue");
					employeeLogin();
				} else {
//					printListPretty(accountsPending);
//					printListPretty(accountsApproved);
					cusDao.selectAllCustomers();
					employeeLogin();
				}
				break;
			case "2":
				System.out.println("\t Approve/Decline Accounts");
				accDec();
				employeeLogin();
				break;
			case "3":
				System.out.println("\t 3. Done");
				writeObject(filename, accountsPending);
				writeObject(filename2, accountsApproved);
				menu();
				break;
			default:
				System.out.println("Done");
				System.out.println("Nice going you broke it...");
				employeeLogin();
				break;
			}
		} else {
			System.out.println("\t Wrong Employee Login");
			employeeLogin();
		}
	}

	// *******************************************************************************************************************
	// Admin Login
	private static void adminLogin() {
		flag = 3;
		System.out.println("\n");
		System.out.println("\t *****Admin Login Page*****");
		System.out.println("");

		// Admin Login Username
		Admin admin = new Admin();
		System.out.println("\t Provide Admin String:");
		String adCredential = input.next();

		// Admin Login Password
		System.out.println("\t Admin Password: ");
		String passCredential = input.next();

		if (adCredential.equals(admin.getAdUsername()) && passCredential.equals(admin.getAdPassword())) {
			loggy.info("Admin -- Successful login");
			System.out.println("\n");
			System.out.println("\t 1. View All Accounts");
			System.out.println("\t 2. Approve/Decline Accounts");
			System.out.println("\t 3. Access client accounts");
			System.out.println("\t 4. Cancel accounts");
			System.out.println("\t 5. Done");
			String option = input.next();

			switch (option) {
			case "1":
				System.out.println("\t View All Accounts");
				if (accountsPending.isEmpty() && accountsApproved.isEmpty()) {
					System.out.println("");
					System.out.println("");
					System.out.println("\t No Accounts...Register to continue");
				} else {
					//printListPretty(accountsPending);
					cusDao.selectAllCustomers();
					adminLogin();
				}
//				if (accountsApproved.isEmpty()) {
//					System.out.println("");
//					System.out.println("");
//					System.out.println("\t No Accounts...Register to continue");
//				} else {
//					//printListPretty(accountsApproved);
//					System.out.println("Accounts Approved");
//					cusDao.selectAllCustomers();
//					adminLogin();
//				}
				break;
			case "2":
				System.out.println("\t ****Approve/Decline Accounts****");
				accDec();
				adminLogin();
				break;
			case "3":
				System.out.println("\t ****Access Specific client accounts****");

				System.out.println("\n");
				System.out.println("\t Enter Account ID you wanna access:");
				int id;
				while (true) {
					String tempy = input.next();
					try {
						id = Integer.valueOf(tempy);
						break;
					} catch (Exception e) {
						System.out.println("Invlaid please enter a number");
					}
				}

				// Print Specific Accounts Approved
				for (Customers i : accountsApproved) {
					if (id == i.getCustomerId()) {
						loggy.info("Admin -- Print " + i.getCustomerId() + " information");
						cusDao.selectCustomerByID(id);
					}
				}

				// Print Specific Pending Accounts
				for (Customers i : accountsPending) {
					if (id == i.getCustomerId()) {
						loggy.info("Admin -- Print " + i.getCustomerId() + " information");
						cusDao.selectCustomerByID(id);
					}
				}
				adminLogin();
				break;
			
			case "4":
				System.out.println("\t ****Cancel Account****");
				System.out.println("\n");
				System.out.println("\t Pending Accounts:");
				System.out.println("");
				for(Customers i : accountsPending) {
					System.out.println("\n\t"+i);
				}
				if(accountsPending.isEmpty()) {
					System.out.println("\t ****Pending Accounts is empty****");
				}
				System.out.println("");
				System.out.println("\t Approved Accounts:");
				System.out.println("\n");
				for(Customers i : accountsApproved) {
					System.out.println("\n\t"+i);
				}
				if(accountsApproved.isEmpty()) {
					System.out.println("\t ****Approved Accounts is empty****");
				}
				System.out.println("\n");
				
				//******************************************************************
				// Choose who you want to cancel by ID
				System.out.println("Choose user ID to remove");
				int cancelId = input.nextInt();
				
				for(Customers i : accountsPending) {
					if(cancelId == i.getCustomerId()) {
						loggy.info("Admin -- Removed " + i.getCustomerId() + " from Exclusive Bank");
						System.out.println("In the if Statement");
						cusDao.deleteCustomer(i);
						accountsPending.remove(i);
						System.out.println(i.getCustomerId());
						writeObject(filename,accountsPending);
						System.out.println("\t Pending Accounts:");
						System.out.println("");
						for(Customers j : accountsPending) {
							System.out.println("\n\t\t"+j);
						}
						if(accountsPending.isEmpty()) {
							System.out.println("\t ****Pending Accounts is empty****");
						}
					}
				}
				
				for(Customers i : accountsApproved) {
					System.out.println(i.getCustomerId());
					if(cancelId == i.getCustomerId()) {
						loggy.info("Admin -- Removed " + i.getCustomerId() + " from Exclusive Bank");
						System.out.println("In the if Statement 2");
						accountsApproved.remove(i);
						cusDao.deleteCustomer(i);
						writeObject(filename2,accountsApproved);
						System.out.println("\t Approved Accounts:");
						System.out.println("");
						for(Customers j : accountsApproved) {
							System.out.println("\n\t\t"+j);
						}
						if(accountsPending.isEmpty()) {
							System.out.println("\t ****Approved Accounts is empty****");
						}
					}
				}
				break;

			case "5":
				System.out.println("\t Done");
				menu();
				break;
			default:
				System.out.println("Done");
				System.out.println("Nice going you broke it...");
				adminLogin();
				break;
			}
		} 
		adminLogin();
	}

	// ********************************************************************************************************
	// Methods below
	// ***********************************************************************************************************
	

	// Registration
	public static void registration() {
		System.out.println("\n");
		System.out.println("\t*****Registration Menu******");
		System.out.println("");
		System.out.println("\t _____Account type?_____");
		System.out.println("");
		System.out.println("\t 1. Single \n");
		System.out.println("\t 2. Joint ");
		String option = input.next();
		// *****************************

		// Need a method for validation if it isnt int.

		switch (option) {
		// Single Account
		case "1":
			Customers singleCustomer = new Customers();
			System.out.println("\n");
			System.out.println("\t Option 1: Single Account");
			System.out.println("\n");

			// Single Username and Password
			System.out.println("\t Enter Username: \n");
			String usernameSin = input.next();
			singleCustomer.setUsername(usernameSin);
			System.out.println("\t Enter Password: \n");
			String passwordSin = input.next();
			singleCustomer.setPassword(passwordSin);

			// Single Account ID
			singleCustomer.setAccountType("Single");
			System.out.println("\n");
			// Single Accounts Balance
			singleCustomer.setTotalBalance(0);
			
			//PendingApproved
			if(singleCustomer.getPendingApproved() != 0) {
				singleCustomer.setPendingApproved(1);
			}

			// *********************************************************************
			// Receipt
			System.out.println("\t *****Here is your the receipt*****");
			System.out.println("\t New Username ID............" + singleCustomer.getCustomerId());
			System.out.println("\t New Account Type..........." + singleCustomer.getAccountType());
			System.out.println("\t New Username............... " + singleCustomer.getUsername());
			System.out.println("\t New Password............... " + singleCustomer.getPassword());
			System.out.println("\t Total Balance............... " + singleCustomer.getTotalBalance());
			System.out.println("\t Pending(0) or Aproved(1)..... " + singleCustomer.getPendingApproved());

			// Add into account pending Array List
			accountsPending.add(singleCustomer);
			cusDao.insertCustomer(singleCustomer);
			writeObject(filename, accountsPending);
			loggy.info("Register  -- Single " + singleCustomer.getUsername() + " to Exclusive Bank");

			break;
		// Joint Account
		case "2":

			// First User
			Customers jointCustomer = new Customers();
			System.out.println("\t Joint account");
			System.out.println("");
			System.out.println("\t Enter 1st Username: \n");
			String usernameJoint = input.next();
			jointCustomer.setUsername(usernameJoint);
			System.out.println("\t Enter 1st Password: \n");
			String passwordJoint = input.next();
			jointCustomer.setPassword(passwordJoint);
			System.out.println("\n");
			// Set Account Type
			jointCustomer.setAccountType("Joint");

			// Second User
			Customers joint2Customer = new Customers();

			System.out.println("\t Enter 2nd Username: \n");
			String usernameJoint2 = input.next();
			joint2Customer.setUsername(usernameJoint2);
			joint2Customer.setPassword(jointCustomer.getPassword());
			joint2Customer.setCustomerId(jointCustomer.getCustomerId());

			// Set Account Type
			joint2Customer.setAccountType("Joint");
			System.out.println("\n");

			// Single Accounts Balance
			jointCustomer.setTotalBalance(0);
			joint2Customer.setTotalBalance(jointCustomer.getTotalBalance());
			
			//PendingApproved
			if(joint2Customer.getPendingApproved() != 0) {
				joint2Customer.setPendingApproved(1);
			}

			// *********************************************************************
			// Receipt
			System.out.println("\t *****Here is 1nd User's receipt*****");
			System.out.println("\t New Username ID............ " + jointCustomer.getCustomerId());
			System.out.println("\t New Account Type........... " + jointCustomer.getAccountType());
			System.out.println("\t New Username............... " + jointCustomer.getUsername());
			System.out.println("\t New Password............... " + jointCustomer.getPassword());
			System.out.println("");
			System.out.println("\t *****Here is 2nd User's receipt*****");
			System.out.println("\t New Username ID............ " + joint2Customer.getCustomerId());
			System.out.println("\t New Account Type........... " + joint2Customer.getAccountType());
			System.out.println("\t New Username............... " + joint2Customer.getUsername());
			System.out.println("\t New Password............... " + joint2Customer.getPassword());
			System.out.println("");
			System.out.println("\tTotal Joint Balance.............. " + jointCustomer.getTotalBalance());
			System.out.println("\t Pending(0) or Aproved(1)..... " + jointCustomer.getPendingApproved());
			System.out.println("\t Pending(0) or Aproved(1)..... " + joint2Customer.getPendingApproved());
			System.out.println("\n");
			// Add into account pending Array List
			accountsPending.add(jointCustomer);
			accountsPending.add(joint2Customer);
			cusDao.insertCustomer(jointCustomer);
			cusDao.insertCustomer(joint2Customer);
			writeObject(filename, accountsPending);
			loggy.info("Register  -- joint " + jointCustomer.getUsername() + " & "+ joint2Customer.getUsername() + " to Exclusive Bank");
			break;

		default:
			System.out.println("Default");
		}

		menu();
	}
	// ***********************************************************************************************************
	// Approval / Decline method for Customers

	public static void accDec() {
		System.out.println("\n");
		if (accountsPending.isEmpty()) {
			System.out.println("\t Pending accounts is empty");
		} else {
			for (Customers i : accountsPending) {
				System.out.println("\t Account currently pending: " + i);
			}
		}
		System.out.println(" ");
		if (accountsApproved.isEmpty()) {
		} else {
			for (Customers i : accountsApproved) {
				System.out.println("\t Current active accounts: " + i);
			}
		}
		System.out.println("\n");
		System.out.println("\t 1. Accept");
		System.out.println("\t 2. Decline");
		int judgement = input.nextInt();

		switch (judgement) {
		case 1:
			System.out.println("");
			System.out.println("*************************");
			System.out.println("");

			// Show past account pending for check
			for (Customers i : accountsPending) {
				System.out.println("\t Account previously pending: " + i);
			}
			System.out.println("Enter customerID:");
			int id = input.nextInt();
			input.nextLine();
			for (Customers i : accountsPending) {
				if (i.getCustomerId() == id) {
					accountsApproved.add(i);
					accountsPending.remove(i);
					i.setPendingApproved(1);
					cusDao.updateCustomer(i);
					//writeObject(filename, accountsPending);
					//writeObject(filename2, accountsApproved);
					// Add pending account to approved account
					System.out.println("\t Approved!!! (´∀｀)");
					loggy.info("Approved new Account!!");
				}
			}
			System.out.println("");
			// Show active account
			for (Customers i : accountsApproved) {
				System.out.println("\t Current active accounts:\t" + i);
			}
			System.out.println("");

			// Show current pending account list
			for (Customers i : accountsPending) {
				System.out.println("\t Accounts currently pending:\t" + i);				
			}

			// Store accounts into database
			//writeObject(filename2, accountsApproved);
			//writeObject(filename, accountsPending);
			break;
		case 2:
			System.out.println("Enter customerID:");
			int idd = input.nextInt();
			for (Customers i : accountsPending) {
				if (i.getCustomerId() == idd) {
					accountsPending.remove(i);
					cusDao.deleteCustomer(i);
					System.out.println("\t Decline ゜:(つд⊂):゜。");
					loggy.info("Decline new Account!!");
					System.out.println(accountsPending);
				}
			}

			// Store accounts pending
			// writeObject(filename, accountsPending);
			break;
		default:
			System.out.println("Default at accDec");
			break;
		}
	}

	// *******************************************************************************
	// Money Transaction

	// Deposit
	public static void deposit(ArrayList<Customers> accountsApproved, int userIDCredential) {
		int newBalance = 0;
		System.out.println("\t Enter Amount to Deposit:");
		int amount = input.nextInt();
		if (amount > 0) {
			for (
					Customers i : accountsApproved) {
				if (i.getCustomerId() == userIDCredential) {
					newBalance = amount + i.getTotalBalance();
					i.setTotalBalance(newBalance);
					System.out.println("\t The amount of $" + newBalance + " was deposited");
					System.out.println("\t $" + i.getTotalBalance());
					System.out.println(i);
					cusDao.updateCustomer(i);
					writeObject(filename, accountsPending);
				}

			}
		} else {
			System.out.println("Invalid Deposit");
		}
		customerLogin();

	}

	// ********************************************************************************************************

	// Withdraw
	public static void withdraw(ArrayList<Customers> accountsApproved, int userIDCredential) {
		System.out.println("Withdraw amount: ");
		int newBalance = 0;
		int amount = input.nextInt();
		if (amount != 0 && amount > 0) {
			for (Customers i : accountsApproved) {
				if (i.getCustomerId() == userIDCredential) {
					newBalance = i.getTotalBalance() - amount;
					i.setTotalBalance(newBalance);
					System.out.println("The amount of $" + amount + " was withdrawed");
					System.out.println("Total Balance: $" + i.getTotalBalance());
					cusDao.updateCustomer(i);
					writeObject(filename, accountsPending);
				}
			}
		} else {
			System.out.println("Invalid Deposit");
		}
		customerLogin();
	}

	// *******************************************************************************************************************
	// Transfer money from one account to another
	public static void transferMoney() {

	}
	// *******************************************************************************************************************
	// ObjectInputStream & ObjectOutputStream

	// Write object to filename
	public static void writeObject(String filename, Object obj) {

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
			out.writeObject(obj);
		} catch (IOException io) {
			io.printStackTrace();
		}

	}

	// Read object from Accounts Pending
	public static void readObject(String filename) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			ArrayList<Customers> temp = (ArrayList<Customers>) ois.readObject();
			accountsPending.clear();
			for (Customers i : temp) {
				Customers c = new Customers();
				c = i;
				accountsPending.add(c);
			}
			System.out.println(accountsPending);

		} catch (FileNotFoundException e) {
			System.out.println("No accounts loaded");
			// e.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Read Object from Accounts Approved
	public static void readObject2(String filename2) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename2))) {
			ArrayList<Customers> temp = (ArrayList<Customers>) ois.readObject();
			accountsApproved.clear();
			// System.out.println(temp);
			for (Customers i : temp) {
				Customers c = new Customers();
				c = i;
				accountsApproved.add(c);
			}
			System.out.println(accountsApproved);

		} catch (FileNotFoundException e) {
			System.out.println("No accounts loaded");
			// e.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	// ********************************************************************************************************
	// Display Info
	// *******************************************************************************************************************
	// Print Account balance information

	public static void customerList(ArrayList<Customers> accountsApproved, int userIDCredential) {

		for (Customers i : accountsApproved) {
			if (i.getCustomerId() == userIDCredential) {
				System.out.println("This account belongs to  " + i.getUsername());
				System.out.println(
						"Total balance for account #: " + i.getCustomerId() + "\n " + i.getTotalBalance() + "\n");
				System.out.println("");
				System.out.println(i.toString());
				break;
			}
		}

	}
	// ********************************************************************************************************

	static void printListPretty(ArrayList<Customers> accountsAll) {
		System.out.println("\t All Active Customers: ");
		if (accountsApproved.isEmpty()) {
			System.out.println("\t ***No Active Customers. Try to approve more customers.***");
		} else {
			for (Customers i : accountsApproved) {
				System.out.println("\t All Active Accounts: " + i);
			}
		}

		if (accountsPending.isEmpty()) {
			System.out.println("\n");
			System.out.println("\t ***No Pending Customers. Try to approve more customers.***");
		} else {
			for (Customers i : accountsPending) {
				System.out.println("\t All Pending Accounts: " + i);
			}
		}
		System.out.println(flag);
		if (flag == 1) {
			customerLogin();
		} else if (flag == 2) {
			employeeLogin();
		} else if (flag == 3) {
			adminLogin();
		} else {
			menu();
		}
	}

	// ********************************************************************************************************
	// ********************************************************************************************************

	// Account Constructors
	public Accounts() {
		super();

	}

	// Setter & Getters

	// Get ID Account
	public int getAccountID() {
		return accountID;
	}

	// Set ID Account
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	// Get Joint Account
	public boolean isJoint() {
		return isJoint;
	}

	// Set Joint Account
	public void setJoint(boolean isJoint) {
		this.isJoint = isJoint;
	}

	// Get Status Account
	public String getStatus() {
		return status;
	}

	// Set Status Account
	public void setStatus(String status) {
		this.status = status;
	}

	// Get Balance Account
	public static int getBalance() {
		return balance;
	}

	// Set Balance Account
	public void setBalance(int balance) {
		this.balance = balance;
	}

}
