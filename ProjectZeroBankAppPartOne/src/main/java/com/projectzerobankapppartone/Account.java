package com.projectzerobankapppartone;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.apache.log4j.Logger;











public class Account implements Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 2850391116499877807L;
	///////////////unrelated/////////////////////
	final static Logger log = Logger.getLogger(Account.class);
	 Random randomGenerator = new Random();
	static Scanner input = new Scanner(System.in);
	static ArrayList<Customer> pendingCustomers = new ArrayList<Customer>();
	static ArrayList<Customer> jointCustomers = new ArrayList<Customer>();
	
///////////////objects/////////////////////
	static Customer cst = new Customer();
	static Employee emp = new Employee();
	
///////////////Variables/////////////////////
	private static int counter = 0;
	static int option;
	private  int acctID = randomGenerator.nextInt(100000);
	static String cname;
	static String cLname;
	static String user;
	static String pass;
	static String filename = "./acctFile.txt";
	static String ff = "./jointFile.txt";
///////////////Constructor/////////////////////
	public Account() {

	}
	
///////////////BankMenu/////////////////////
	public static void bankMenu() {
		cst.readObject(filename);
		//cst.readObject2(ff);
		char option;
		String input2;
		System.out.println("|                           W E L C O M E                               |");
		System.out.println("|_______________________________________________________________________|");
		System.out.println("| 'a' : Sign In as customer                                             |");
		System.out.println("| 'b' : Sign In as employee                                             |");
		System.out.println("| 'c' : Sign In as Admin                                             |");
		System.out.println("| 'd' : Register                                                        |");
		System.out.println("| 'q' : Quit                                                            |");
		System.out.println("|_______________________________________________________________________|");
		System.out.print(" Enter option here: ");

		do {
			input2 = input.next();
			option = input2.charAt(0);
			switch (option) {
			case 'a':
				// sign in as a customer method
				Customer.customerSignIn();
				break;
			case 'b':
				// sign in as employee method
				Employee.EmployeeSign();
				break;
			case 'c':
				// sign in as admin
				Administrator.AdminSign();
				break;
			case 'd':
				// Customer register method
				Registration();
				break;
			case 'q':
				System.out.println("Goodbye and thank you");
				break;
			default:
				System.out.println("You entered the wrong option");
			}
		} while (option != 'q');
	}
	
/////////////////////////////Registration/////////////////////
	public static void Registration() {
		log.warn("Registration page has been activated");
		System.out.println("__________________________________________________________________________");
		System.out.println("Type (1) if you want a single account or (2) if you want a joint account: ");
		option = input.nextInt();
		log.info("Single Account option was selected");
		if (option == 1) {
			counter++;
			System.out.println("___________________________________________________________________________");
			System.out.println("enter first name: " + counter);
			cname = input.next();
			cst.setName(cname);
			System.out.println("name created");
			
			// get lastname and print out
			System.out.println("enter last name: " + counter);
			cLname = input.next();
			cst.setlName(cLname);
			System.out.println("last name created");
			// asking Customer to create a username
			while (true) {
				System.out.println("please create a new user name: ");
				System.out.println("____________________________________________________________________________");
				String user1 = input.next();
				cst.setUsername(user1);
				if (cst.getUsername().length() > 5 && cst.getUsername().length() <= 10) {
					// customers.add(cst.getUsername());
					System.out.println("New user created!");
					System.out.println("_____________________________________________________________________________");
					break;
				} else {
					System.out.println("Username must be between 6 and 10 characters");
				}
				// Asking customer to create password
			}
			while (true) {
				System.out.println("please create a new password: ");
				System.out.println("___________________________________________________________");
				String pass = input.next();
				cst.setPassword(pass);
				if (cst.getPassword().length() > 5 && cst.getPassword().length() <= 10) {
					System.out.println("new password was created!!");
					break;
				} else {
					System.out.println("password must be between 6 and 10 characters");
				}
			}
		} else if (option == 2) {
			for (int i = 0; i < option; i++) {
					System.out.println("enter first name: " + counter);
					String name2 = input.next();
					cst.setName(name2);
					System.out.println("____________________________________________________________________________");
					System.out.println("enter last name: " + counter);
					String lname2 = input.next();
					System.out.println("____________________________________________________________________________");
					cst.setlName(lname2);
					// asking Customer to create a username
				while (true) {
					System.out.println("please create a new user name: ");
					System.out.println("**********************************************************");
					String user2 = input.next();
					cst.setUsername(user2);
					if (cst.getUsername().length() > 5 && cst.getUsername().length() <= 10) {
						System.out.println("new user name created!!");
						System.out.println("______________________________________________");
						break;
					} else {
						System.out.println("Username must be between 6 and 10 characters");
						System.out.println("__________________________________________________");
					}
					// Asking customer to create password
				}
				while (true) {
					System.out.println("please create a new password: ");
					System.out.println("___________________________________________________________");
					String pass2 = input.next();
					cst.setPassword(pass2);
					if (cst.getPassword().length() > 5 && cst.getPassword().length() <= 10) {
						break;
					} else {
						System.out.println("password must be between 6 and 10 characters");
						System.out.println("**********************************************************");
					}
				}
				// end of while loop
			}
			
		}
		System.out.println("Your Joint Account was created!!");
		System.out.println("Your account ID is:  " + cst.getActtID() + "and the status of the account is " + cst.getStat());
		pendingCustomers.add(new Customer(cst.getName(), cst.getlName(), cst.getUsername(), cst.getPassword(),
				cst.getCustID(), cst.getActtID(), cst.getStat(), cst.getBal()));
		cst.writeObject(filename, pendingCustomers);
		log.info("User was Created");
		bankMenu();
	}
	
///////////////Customer menu/////////////////////
	public static void CustMenu() {
		cst.readObject(filename);
		log.warn("Customer menu has been activated");
		Scanner input = new Scanner(System.in);
		char option;
		String input2;
		System.out.println("_________________________________________________| ");
		System.out.println("_________________________________________________| ");
		System.out.println(" 'a' : Deposit ");
		System.out.println(" 'b' : Withdrawal ");
		System.out.println(" 'c' : Transfer");
		System.out.println(" 'd' : Go Back");
		System.out.println(" 'q' : Quit");
		System.out.print("Enter option here: ");
		do {
			input2 = input.next();
			option = input2.charAt(0);
			switch (option) {
			case 'a':
				// Deposit method

				System.out.print(" please enter deposit amount: ");
				double amount = input.nextDouble();
				Deposit(amount);
				Scanner accCId = new Scanner(System.in);
				System.out.print("Enter Account ID to save: ");
				String apAcID = accCId.next();
				System.out.println("_______________________________________________________________________");
				CustMenu();
				break;
			case 'b':
				// Withdrawal method
				System.out.print("your balance is: " + cst.getBal() + " please enter withdrawal amount: ");
				double amount2 = input.nextDouble();
				Withdrawal(amount2);
				CustMenu();
				break;
			case 'c':
				// Transfer method
				Transfer();
				break;
			case 'd':
				// Main Menu
				bankMenu();
				break;
			case 'q':
				// quits the program
				System.out.println("Thank you and goodbye");
				break;
			default:
				System.out.println("You entered the wrong option");
			}
		} while (option != 'q');
		input.close();
	}
	
///////////////Deposits/////////////////////
	public static void Deposit(double amount) {
		System.out.println(amount);
		if (amount != 0 && amount > 0) {
			for (Customer cf : pendingCustomers) {
				if (user.equals(cf.getUsername())) {
					cf.setBal(cf.getBal() + amount);
					System.out.println("The amount of " + amount + " was deposited!");
					Customer.writeObject(filename, pendingCustomers);
				}
			}

		} else {
			System.out.println("invalid input!");
		}
	}
	
///////////////Withdrawal/////////////////////
	public static void Withdrawal(double amount) {
		if (amount != 0 && amount > 0) {
			for (Customer cf : pendingCustomers) {
				if (user.equals(cf.getUsername())) {
					cf.setBal(cf.getBal() - amount);
					System.out.println("The amount of " + cf.getBal() + " was withdraw");
					Customer.writeObject(filename, pendingCustomers);
				}
			}

		} else {
			System.out.println("invalid input!");
		}
	}
///////////////Transfer/////////////////////
	public static void Transfer() {
		double amount;
			for(Customer ct : pendingCustomers) {
				if(user.equals(ct.getUsername())) {
					System.out.print("Enter the account ID to whom you want to transfer to:");
					Scanner acID = new Scanner(System.in);
					String asid = acID.next();
					System.out.println("______________________________________________________________");
					for(int x = 0; x < pendingCustomers.size();x++) {
						if(pendingCustomers.get(x).getActtID().contains(asid)) {
							System.out.print("enter anount to transfer:");
							Scanner amt = new Scanner(System.in);
							amount = amt.nextDouble();
							if (amount != 0 && amount > 0) {
								pendingCustomers.get(x).setBal(ct.getBal() + amount);
								Customer.writeObject(Account.filename, Account.pendingCustomers);
								System.out.println(amount + " transfered to " + pendingCustomers.get(x).getActtID());
							}
						}
					}
				}
			}
	}
}
