package com.project0;

//Import Java Util
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JViewport;

import org.apache.log4j.Logger;

import com.project.AccounDaoImpl;
import com.project.CustomerDaoImp;

//Class with serializable implementation
public class Account implements Serializable {
	static CustomerDaoImp g =new CustomerDaoImp();
	
	
	final static Logger loggy = Logger.getLogger(Account.class);
	
	
	//Serialization and id
	private static final long serialVersionUID = -6713903791620619371L;

	static // Create object Scanner input
	Scanner input = new Scanner(System.in);

	static // instatiation of object
	Customer c = new Customer();
	Employee emp = new Employee();
	//Arraylist creation
	static ArrayList<String> accountList = new ArrayList<String>();
	static ArrayList<Customer> customerList = new ArrayList<Customer>();
	

	//variables declaration
	Random randomGenerator = new Random();
	int option;
	int counter = 0;

	// Declare and initialize variables
	private int acctId = randomGenerator.nextInt(100);
	private boolean iSJoint;
	private static String status ="pending";
	public double balance;
	//static int acctId; 
	static String user;
	static String pass;
	static String Filename = "./result";
	
	//Calling Constructor
	public Account(int acctId, double balance, String status) {
		super();
		this.acctId=acctId;
		this.balance = balance;
		

	}
	//calling account method
	public Account() {
	}

	// Creating getters
	// get account id
	public int getAcctId() {
		return acctId;
	}

	public boolean iSJoint() {
		return iSJoint;
	}

	// get account status
	public String getStatus() {
		return status;
	}

	// get account balance
	public double getBalance() {
		return balance;
	}

	// Create setters
	// set the account id
	public void setAcctId(int acctId) {
		this.acctId=acctId;
	}

	// set the account
	public void setiSJoint(boolean iSJoint) {
		this.iSJoint = iSJoint;
	}

	// set account status
	public void setStatus(String status) {
		this.status = status;
	}

	// set the account balance
	public void setBalance(double balance) {
		this.balance = balance;
	}

	// ------------------------------------------------------------------------------------------------------------------
	// Registration method
	public void theRegistration() {
		System.out.println();
		loggy.info("This is the loggin zone");
		loggy.error("Error: email me at gmail.com");
		System.out.println("What type of Account do you want to register?      ");
		System.out.println();
		System.out.println("1.--------------Customer Register (Single Account) ");
		System.out.println();
		System.out.println("2.---------------->customer register (Joint Account)");

		option = input.nextInt();

		
		// validation and get input from customer for single account
		if (option == 1) {
			counter++;
			System.out.println("**********************************************************");
			while (true) {
				System.out.println("enter first name: " + counter);
				String temp = input.next();
				c.setfName(temp);
				
				System.out.println("____________________________________________________________________________");
				try {
					Integer.valueOf(temp);
					System.out.println("invalid first name (only contain letters)");
					continue;
				} catch (Exception e) {
					break;
				}

			}

			// get input from customer(last name) 
			while (true) {

				System.out.println("enter last name: " + counter);

				String temp = input.next();
				c.setlName(temp);

				System.out.println("____________________________________________________________________________");

				try {
					Integer.valueOf(temp);
					System.out.println("invalid last name (only contain letters)");
					continue;
				} catch (Exception e) {
					break;
				}
			}

			// asking Customer for single account to create a username
			while (true) {
				System.out.println("please create a new user name: ");
				System.out.println("**********************************************************");
				c.setUserName(input.next());
				

				if (c.getUserName().length() > 5 && c.getUserName().length() <= 10) {
					System.out.println("Yeah!! a new user name created!!");
					System.out.println("______________________________________________");
					break;
				} else {
					System.out.println("No!!! Username must be between 6 and 10 characters");
					System.out.println("__________________________________________________");
					
				}
				
				
				
			}
			
			
			// Asking customer to create password
			while (true) {
				System.out.println("please create a new password: ");
				System.out.println("___________________________________________________________");
				c.setPassword(input.next());
				if (c.getPassword().length() > 5 && c.getPassword().length() <= 10) {
					// singleAccount.add("Password = " + c.getPassword());

					System.out.println("Awwww!! a new password was created!!");

					break;
				} else {
					System.out.println("No man!! your password must be between 6 and 10 characters");
					System.out.println("**********************************************************");
					}
				}
			
			
				System.out.println("please create a new user customer id: ");
				System.out.println("**********************************************************");
				c.setCusId(input.nextInt());
			
			
			
			}
		System.out.println("Your account ID is:  " + acctId + " and the status of the account is " + status);

		
//			
//
//		else if (option == 2) {
//
//			for (int i = 0; i < option; i++) {
//				while (true) {
//					System.out.println("enter first name: " + counter);
//					String temp = input.next();
//					c.setfName(temp);
//					// jointAccount.add(c.getfName());
//
//					System.out.println("____________________________________________________________________________");
//
//					try {
//						Integer.valueOf(temp);
//						System.out.println("invalid first name (only contain letters)");
//						continue;
//					} catch (Exception e) {
//						break;
//					}
//				} // end of while loop
//
//				while (true) {
//
//					System.out.println("enter last name: " + counter);
//
//					String temp = input.next();
//					System.out.println("____________________________________________________________________________");
//					c.setlName(temp);
//					// jointAccount.add(c.getlName());
//
//					try {
//						Integer.valueOf(temp);
//						System.out.println("invalid last name (only contain letters)");
//						continue;
//					} catch (Exception e) {
//						break;
//					}
//				} // end of while loop
//
//				// asking Customer to create a username
//				while (true) {
//					System.out.println("please create a new user name: ");
//					System.out.println("**********************************************************");
//					c.setUserName(input.next());
//					if (c.getUserName().length() > 5 && c.getUserName().length() <= 10) {
//						// jointAccount.add(c.getUserName());
//
//						System.out.println("Yeah!! a new user name created!!");
//
//						System.out.println("______________________________________________");
//						break;
//					} else {
//						System.out.println("No!!! Username must be between 6 and 10 characters");
//						System.out.println("__________________________________________________");
//
//					}
//					
//
//				}
//				// Asking customer to create password
//				while (true) {
//					System.out.println("please create a new password: ");
//					System.out.println("___________________________________________________________");
//					c.setPassword(input.next());
//					if (c.getPassword().length() > 5 && c.getPassword().length() <= 10) {
//
//						break;
//					} else {
//						System.out.println("No man!! your password must be between 6 and 10 characters");
//						System.out.println("**********************************************************");
//
//					}
//				}
//
//				// end of while loop
//			}
//
//			System.out.println("Awwww!! Your Joint Account was created!!");
//
//			System.out.println("Your account ID is:  " + acctId + "and the status of the account is " + status);
//			System.out.println();
//			
		//}
		g.insertCustomer(c);
		
		

		
		
	

		//bankMenu();
		}
	
	// while() loop

	public void employeeSign() {
		System.out.println("Enter Administrater id:  ");
		String tempUser = input.next();
		// emp.setUser(input.next(tempUser));
		emp.getUser();

		System.out.println("Enter Administrater password:  ");
		String temPass = input.next();
		emp.setPassword(temPass);
		emp.getPassword();
		if (tempUser.equals("thor") && temPass.equals("thor")) {
			employeeMenu();
		} else {
			System.out.println("Employee user and password are incorect");
		}

		// Employee menu asking Employee to choose

	}
	
	
	
	public void administrationSign() {
		System.out.println("Enter Employee id:  ");
		String tempUser = input.next();
		// emp.setUser(input.next(tempUser));
		emp.getUser();

		System.out.println("Enter Employee password:  ");
		String temPass = input.next();
		emp.setPassword(temPass);
		emp.getPassword();
		if (tempUser.equals("thor") && temPass.equals("thor")) {
			administraterMenu();
		} else {
			System.out.println("Employee user and password are incorect");
		}

		// Employee menu asking Employee to choose

	}
	
	
	

	public void employeeMenu() {
		// c.readCustomer(Filename);
		char option;
		System.out.println("________________________________________________________________________| ");
		System.out.println(" Choose an option: ");
		System.out.println();
		System.out.println(" 'a' : View Customers ");
		System.out.println(); 
		System.out.println(" 'b' : Account status (Approved/Denied");
		System.out.println(" 'c' : Go Back to he previous menu");
		System.out.println(" 'q' : Quit");
		System.out.print(" Enter option here: ");

		String input1;
		do {
			input1 = input.next();
			option = input1.charAt(0);
			switch (option) {
			case 'a':
				// readObject(Filename);
				for (Customer c : Account.customerList) {
					System.out.println(c);
				}

				break;
			case 'b':
				approved();

				break;
			case 'c':
				c.writeCustomer(Filename, customerList);
				bankMenu();

				break;
			case 'q':

				bankMenu();

				break;
			default:
				System.out.println("You entered the wrong option");
			}
		} while (option != 'q');

	}

	public void bankMenu() {
		//c.readCustomer(Filename);
		// c.customerDeserialize(customerList);
		customerList=g.getAllCustomers();
		char option;
		String input2;
		System.out.println("W E L C O M E  TO BANK OF MINE");
		System.out.println("");
		System.out.println(" a : Sign In as customer");
		System.out.println(" b : Sign In as employee");
		System.out.println(" c : Register");
		System.out.println(" d : Sign In as Administration");
		System.out.println(" q : Quit");
		System.out.println("");
		System.out.print(" Enter option here: ");
		do {
			input2 = input.next();
			option = input2.charAt(0);

			switch (option) {

			case 'a':
				signIn();
				customerMenu();
				//CustomerDaoImp z =new CustomerDaoImp();
				//z.customerExit();
				
				break;

			case 'b':
				employeeSign();
				break;
				
			case 'c':
				theRegistration();
				break;
				
			case 'd':
				administrationSign();
				break;
				
			case 'q':
				
				System.out.println("Thank you and goodbye!");
				break;
			default:
				System.out.println("You entered the wrong option");
			}
		} while (option != 'q');
	}

	public static void writeObject(String Filename, Object obj) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Filename))) {
			oos.writeObject(obj);
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	// Read inputstream
	public static void readObject(String Filename) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Filename))) {
			Object object = ois.readObject();
			System.out.println(object);
		} catch (IOException exception) {
			exception.printStackTrace();
		} catch (ClassNotFoundException anything) {
			anything.printStackTrace();
		}

	}// Signin method

	public static void signIn() {
		Scanner sign = new Scanner(System.in);
		System.out.println("Please enter the customer  username you want to sign in");
		user = sign.next();
		System.out.println("Please enter the customer  password you want to sign in");
		pass = sign.next();
		System.out.println("_______________________________________________________________________");
		for (int j = 0; j < customerList.size(); j++) {
			if (customerList.get(j).getUserName().contains(user) && customerList.get(j).getPassword().contains(pass)) {

				System.out.println(customerList.get(j).toString().replaceAll("^.|.$", "").replace(", ", "\n"));
			}
		}

	}
	



	public static void approved() {
		Scanner acctId = new Scanner(System.in);
		System.out.println("Enter the customer Account Id you want to approve or deny: ");
		String approved = acctId.next();		System.out.println("_______________________________________________________________________");
		for (int j = 0; j < customerList.size(); j++) {
			//if (customerList.get(j).getActtId().contains(approved)) {

				System.out.println(customerList.get(j).toString().replaceAll("^.|.$", "").replace(", ", "\n"));
				System.out.println("Approve? (yes or no)");
				String opt = acctId.next();
				if (opt.equals("yes")) {
					customerList.get(j).setStatus("approved");
					System.out.println(customerList.get(j).getStatus());
					System.out.println(customerList.get(j));
					g.updateCustomer(customerList.get(j));
					
					//c.writeCustomer(Filename, customerList);
					}
				else {
					customerList.get(j).setStatus("Deny");
					System.out.println("This account " +  "was " + status);
					c.writeCustomer(Filename, customerList);
					}
				}
			}
		

	

	// Customer menu ask with option to choose
	public void customerMenu() {

		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		System.out.println("What would  you like  to do today? ");
		System.out.println("");
		System.out.println("1. Deposit");
		System.out.println("2. withdraw");
		System.out.println("3. Balance");

		// While loop
		do {
			System.out.println("---------------------------------------------------------------");
			System.out.println("Please enter one of the following option please");
			System.out.println("");
			option = scanner.next().charAt(0);
			switch (option) {

			case '1':
				System.out.println("");
				System.out.println("Please enter amount you want to deposit: ");
				System.out.println("-------------------------------------------------------------");
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;

			case '2':
				System.out.println("=============================================================");
				System.out.println("Please enter the amount to withdraw");
				System.out.println("-------------------------------------------------------");
				int amount1 = scanner.nextInt();
				withdraw(amount1);
				System.out.println("\n");
				break;

			case '3':
				System.out.println("==================================================");
				System.out.println("Your balance is: " +  balance);
				System.out.println("------------------------------------------------------");
				System.out.println("\n");
				break;

			case 'c':
				System.out.println("Thank you. Have a nice dae");
				break;

			default:
				System.out.println("invalid !!");

			}

		} while (option != 'd');

	}

	public static void withdraw(int amount) {
		for (Customer jv : customerList)
			if (user.equals(jv.getUserName()))
				if (jv.getBalance() > amount) {
					jv.setBalance(jv.getBalance()- amount);

					System.out.println("Amount withdraw: " + amount);
					System.out.println("******************************************************************");
					System.out.println("Your balance now is: " + jv.getBalance());
					g.updateCustomer(jv);
		}

		else {
			System.out.println("unsificient fund!!(not enough money)");
		}

	}
	

	public void deposit(int amount) {
		
		System.out.println(amount);
		if (amount > 0) {

			for (Customer jv : customerList) {
				System.out.println(jv.getUserName());
				if (user.equals(jv.getUserName())) {
					jv.setBalance(jv.getBalance() + amount);
					System.out.println("Your amount deposit is " + amount);
					System.out.println("******************************************************************");
					System.out.println("Your balance now is: " + jv.getBalance());
					
				
					g.updateCustomer(jv);
					balance=jv.getBalance();
				
				}

				}
		} else {
			System.out.println("Must be greater than Zero");
		}

	}
	
	
	//creating method that read and write file
			public static void writeEmployee(String name, Object object) {
				try(ObjectOutputStream employee =new ObjectOutputStream(new FileOutputStream(name))){
					employee.writeObject(object);
				}catch(IOException e) {
					e.printStackTrace();
				}
					
				
			}
			//Creating Method that read from to the file
			public static void readEmployee1(String name) {
				try(ObjectInputStream employee1 =new ObjectInputStream(new FileInputStream(name))){
					employee1.readObject();
				}catch(IOException e) {
					e.printStackTrace();
				}catch(ClassNotFoundException e) {
					e.printStackTrace();
				}
		
		
		
		
			}
			//Administrater menu method
			public void administraterMenu() {
				char option;
				System.out.println("________________________________________________________________________| ");
				System.out.println(" Choose an option: ");
				System.out.println(" 'a' : View Customers ");
				System.out.println(" 'b' : Account status(Approved/Denied");
				System.out.println(" 'c' :(Deposit");
				System.out.println(" 'd' :(Withdraw");
				System.out.println(" 'e' :(balance");
				System.out.println(" 'f' :Go Back to he previous menu");
				System.out.println(" 'q' : Quit");
				System.out.print("Enter option here: ");

				String input1;
				do {
					input1 = input.next();
					option = input1.charAt(0);
					switch (option) {
					case 'a':
						// readObject(Filename);
						for (Customer c : Account.customerList) {
							System.out.println(c);
							
						}

						break;
					case 'b':
						approved();
						break;
						
					case 'c':
						signIn();
						
						System.out.println("===========================================================");
						System.out.println("Enter deposit: ");
						System.out.println("-------------------------------------------------------------");
						int amount = input.nextInt();
						deposit(amount);
						break;
						
						
					case 'd':
						signIn();
						System.out.println("=============================================================");
						System.out.println("Please enter the amount to withdraw");
						System.out.println("-------------------------------------------------------");
						int amount1 = input.nextInt();
						withdraw(amount1);
						System.out.println("\n");
						break;
						
					case 'e':
						
						Customer jv =new Customer();
						signIn();
						System.out.println("==================================================");
						System.out.println("Your balance is: " + balance);
						System.out.println("------------------------------------------------------");
						System.out.println("\n");
						break;

						
					case 'f':
						bankMenu();
						break;
					default:
						System.out.println("You entered the wrong option");
					}
				} while (option != 'q');

			}

}
