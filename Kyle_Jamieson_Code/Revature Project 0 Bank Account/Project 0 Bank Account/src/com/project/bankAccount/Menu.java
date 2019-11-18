package com.project.bankAccount;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
//import org.apache.log4j.Logger;

public class Menu
{
//	final static Logger loggy = Logger.getLogger(Menu.class);
	 
	public static Menu m_menu;

	public static Menu GetInstance()
	{
		if(null == m_menu)
			m_menu = new Menu();
		
		return m_menu;
	}
	
	// Start up the menu system
	public void initMenuSystem()
	{
		// load in users and accounts
		String fileAccounts =  "./honey.txt";
		String fileCustomers = "./bees.txt";
		String fileEmployees = "./flowers.txt";
		String fileAdmins =    "./roots.txt";

		// Load customers
//		User cust = new User("nobody", "123456", User.getCustomerCode(), "john", "smith", 111);
//		m_users.add(cust);
		
		// Load employees
		User employ = new User("employee", "123456", User.getEmployeeCode(), "john", "smith");
		m_users.add(employ);

		// Load admins
		
		// Check if there are any admin accounts
		boolean bAnyAdmin = false;
		for(int i = 0; i < m_users.size(); i++)
		{
			if(User.getAdminCode() == m_users.get(i).getUserType())
			{
				// Confirmed there is at lest one admin
				bAnyAdmin = true;
				break;
			}
		}
		// No admin accounts... load a default one
		if(!bAnyAdmin)
		{
			User admin = new User("iamroot", "123456", User.getAdminCode(), "default", "admin");
			m_users.add(admin);
		}
		
		
		m_menuState = 0;
		m_curAccount = -1;
		m_curUser = -1;
		
		// Load accounts
	}
	
	// Shutdown the menu system
	public void shutDown()
	{
		m_menu = null;
		m_sc.close();
		m_sc = null;
		m_menuState = 0;
		m_curAccount = -1;
		m_curUser = -1;
	}
	
	// main update loop of the menu system.
	// Returns false only when user exits
	//
	// _timeSlice: time slice since last call(may not be needed unless running in real time
	public boolean update(double _timeSlice)
	{
		switch(m_menuState)
		{
			//Log in menu
			case 0:
				logInMenu();
			break;
			
			// Customer Menu
			case 1:
				customerMenu();
			break;
			
			// Employee Menu
			case 2:
				employeeMenu();
			break;
			
			// Admin Menu
			case 3:
				adminMenu();
			break;
			
			// Exit program
			case 4:
				return false;
		
			default:
			break;
		}
		
		return true;
	}
	public static void readObject(String filename) 
	{
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename)))
		{
			Object object = ois.readObject();
			System.out.println(object);
		}
		catch(IOException exception)
		{
			exception.printStackTrace();
		}
		catch(ClassNotFoundException anything) 
		{
			anything.printStackTrace();
		}
	}

	public static void writeObject(String filename, Object obj) 
	{
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename)))
		{
			oos.writeObject(obj);
		}
		catch(IOException io) 
		{
			io.printStackTrace();
		}
	}
	
	// block outside calls of constructor
	private Menu() {}
	
	// block outside calls of copy constructor
	private Menu(Menu c) {}

	private List<AccountInfo> m_accounts = new LinkedList<AccountInfo>();
	private List<User> m_users = new LinkedList<User>();
	private Scanner m_sc = new Scanner(System.in);

	
	// utility variables
	private byte m_menuState = 0;
	private int m_curAccount = -1;
	private int m_curUser = -1;
				
	// Log in an account or create a new customer account.	
	private void logInMenu()
	{
		// Get log in type
		System.out.println("Account Types\n1) Customer\n2) Employee\n3) Admin\n4) Create New Account");
		int state = this.getIntInput(1, 4);
		boolean bValid = false;
		
//		while(!bValid)
		{
			// Get user name and password
//			System.out.println("User Name: ");
//			String name = m_sc.nextLine();
//			System.out.println("Password: ");
//			String password = m_sc.nextLine();
			switch(state)
			{
				case 1:
				{
					// Get user name and password
					System.out.println("User Name: ");
					String name = m_sc.nextLine();
					System.out.println("Password: ");
					String password = m_sc.nextLine();
					// Find Customer account
					for(int i = 0; i < m_users.size(); i++)
					{
						if(m_users.get(i).getAccountName().contentEquals(name) && m_users.get(i).getPassword().contentEquals(password))
						{
							// Found customer account
							m_curUser = i;
							break;
						}
					}
					// Find the account connected to this customer
					if(-1 == m_curUser)
					{
						System.out.println("ERROR: Invalid account or password");
						return;
					}
					else
					{
						for(int i = 0; i < m_accounts.size(); i++)
						{
							if(m_accounts.get(i).getAccountNumber() == m_users.get(m_curUser).getAccountNumber())
								m_curAccount = i;
						}
					}
					
					// check if account found
					if(-1 == m_curAccount)
					{
						// User's account was not found
						System.out.println("ERROR: User's bank account was not found. Plase call (123) 123-4567 for assistance");
					}
					else
					{
						// Log into account
						bValid = true;
						m_menuState = 1;
					}
				}
				break;
				
				//employee login
				case 2:
				{
					// Get user name and password
					System.out.println("User Name: ");
					String name = m_sc.nextLine();
					System.out.println("Password: ");
					String password = m_sc.nextLine();
					// Find employee account
					for(int i = 0; i < m_users.size(); i++)
					{
						if(m_users.get(i).getAccountName().contentEquals(name) && m_users.get(i).getPassword().contentEquals(password))
						{
							// Found employee account
							m_curUser = i;
							break;
						}
					}
					// Find the account connected to this customer
					if(-1 == m_curUser)
					{
						System.out.println("ERROR: Invalid account or password");
						return;
					}
					else
					{
						// Log into account
						bValid = true;
						m_menuState = 2;
						m_curAccount = -1;
					}
				}
				break;
				
				case 3:
				{
					// Get user name and password
					System.out.println("User Name: ");
					String name = m_sc.nextLine();
					System.out.println("Password: ");
					String password = m_sc.nextLine();
					// Find admin account
					for(int i = 0; i < m_users.size(); i++)
					{
						if(m_users.get(i).getAccountName().contentEquals(name) && m_users.get(i).getPassword().contentEquals(password))
						{
							// Found employee account
							m_curUser = i;
							break;
						}
					}
					// Find the account connected to this customer
					if(-1 == m_curUser)
					{
						System.out.println("ERROR: Invalid account or password");
						return;
					}
					else
					{
						// Log into account
						bValid = true;
						m_menuState = 3;
						m_curAccount = -1;
					}
				}
				break;
				
				case 4:
				{
					this.newAccount();
					state = 0;
					m_menuState = 0;
				}
				break;
				
				default:
				break;
			}
		}
	}
	
	// Menu for use by customer accounts
	private void customerMenu()
	{
		System.out.println("Welcome " + m_users.get(m_curUser).getFirstName() + " " + m_users.get(m_curUser).getLastName() + ", Make your selection");
		if(m_accounts.get(m_curAccount).isAccountActive())
		{
			System.out.println("1)  Display account information");
			System.out.println("2)  Savings balance");
			System.out.println("3)  Withdawal from savings");
			System.out.println("4)  Deposit to savings");
			System.out.println("5)  Transfer from savings");
			System.out.println("6)  Checking balance");
			System.out.println("7)  Withdrawal from checking");
			System.out.println("8)  Deposit to checking");
			System.out.println("9)  Transfer from checking");
			System.out.println("10) Change Password");
			System.out.println("11) Close Account");
			System.out.println("12) Logout");
			System.out.println("13) Exit\n");
			System.out.print("Selection: ");
				
			//data check
			int option = this.getIntInput(1, 13);
	
			switch(option)
			{
				//do stuff
				case 1:
					this.displayCurAccountInfo();
				break;

				case 2: //saving balance
					displaySave();
				break;
				
				case 3://withdrawal savings
					this.withdrawSave();
				break;
			
				case 4://deposit savings
					this.depositSave();
				break;
			
				case 5: //transfer savings
					this.transferFromSave();
				break;
				
				case 6: //checking balance
					displayCheck();
				break;
			
				case 7: //withdrawal checking
					this.withdrawCheck();
				break;
			
				case 8: //deposit checking
					this.depositCheck();
				break;
			
				case 9: //transfer checking
					this.transferFromCheck();
				break;
			
				case 10: //change password
					this.changePassword();
				break;
			
				case 11: //close account
					closeAccount();
				break;
				
			
				case 12:
					//log out
					logOut();
				break;
				
				case 13:
					//exit
					exit();
				break;
				
				default:
					System.out.println("ERROR: invalid option. try again");
				break;
			}
		}
		else
		{
			// Account not active
			System.out.println("1) Display account information");
			System.out.println("2) Change Password");
			System.out.println("3) Close Account");
			System.out.println("4) Logout");
			System.out.println("5) Exit\n");
			System.out.print("Selection: ");
			
			//data check
			int option = this.getIntInput(1, 5);
			
			switch(option)
			{
				case 1:
				{
					this.displayCurAccountInfo();
				}
				break;

				case 2:
				{
					this.changePassword();
				}
				break;

				case 3:
				{
					closeAccount();
				}
				break;

				// Log out
				case 4:
				{
					logOut();
				}
				break;

				// Exit
				case 5:
				{
					exit();
				}
				break;

				default:
					System.out.println("ERROR: invalid option. try again");
				break;
			}
			
		}
	}
	
	// Menu for use by normal employees
	private void employeeMenu()
	{
		System.out.println("Welcome " + m_users.get(m_curUser).getFirstName() + " " + m_users.get(m_curUser).getLastName() + ", Make your selection");
		if(0 >= m_curAccount)
		{
			if(m_accounts.get(m_curAccount).getFlag(AccountInfo.FLAGS.PENDING))
			{
				System.out.println("1) Display account information");
				System.out.println("2) Approve Account");
				System.out.println("3) Deny Account");
				System.out.println("4) Logout");
				System.out.println("5) Exit\n");
				System.out.print("Selection: ");
				
				int option = this.getIntInput(1, 5);

				
				switch(option)
				{
					// display info
					case 1:
						this.displayCurAccountInfo();
					break;
					
					// Approve Account
					case 2:
						this.approveAccount();
					break;
					
					// Deny Account
					case 3:
						this.denyAccount();
					break;
					
					// Logout
					case 4:
						this.logOut();
					break;
					
					// Exit
					case 5:
						this.exit();
					break;
					
					default:
						System.out.println("ERROR: invalid option. try again");
					break;
				}
			}
			else
			{
				System.out.println("1) Display account information");
				System.out.println("2) Savings balance");
				System.out.println("3) Checking balance");
				System.out.println("4) Logout");
				System.out.println("5) Exit\n");
				System.out.print("Selection: ");

				int option = this.getIntInput(1, 5);

				switch(option)
				{
					// display account info
					case 1:
						this.displayCurAccountInfo();
					break;
					
					// saving balance
					case 2:
						this.displaySave();
					break;
					
					// checking balance
					case 3:
						this.displayCheck();
					break;

					// Logout
					case 4:
						this.logOut();
					break;
					
					// Exit
					case 5:
						this.exit();
					break;
					
					default:
						System.out.println("ERROR: invalid option. try again");
					break;
				}
}
		}
		else
		{
			System.out.println("1) Go to account by account number");
			System.out.println("2) Go to account by customer name");
			System.out.println("3) Logout");
			System.out.println("4) Exit\n");
			System.out.print("Selection: ");

			int option = this.getIntInput(1, 4);

			switch(option)
			{
				// Access account by number
				case 1:
					this.findAccountByNum();
				break;
				
				// Access account by legal name of customer
				case 2:
					this.findAccountByCustName();
				break;
				
				// Logout
				case 3:
					this.logOut();
				break;
				
				// Exit
				case 4:
					exit();
				break;
				
				default:
					System.out.println("ERROR: invalid option. try again");
				break;
			}
		}
	}
	
	// Menu for use by admin accounts. only menu able to create employee and admin accounts
	private void adminMenu()
	{
		System.out.println("current user index = " + m_curUser);
		System.out.println("Welcome " + m_users.get(m_curUser).getFirstName() + " " + m_users.get(m_curUser).getLastName() + ", Make your selection");
		if(0 <= m_curAccount)
		{
			if(m_accounts.get(m_curAccount).getFlag(AccountInfo.FLAGS.PENDING))
			{
				System.out.println("1) Display account information");
				System.out.println("2) Approve Account");
				System.out.println("3) Deny Account");
				System.out.println("4) Logout");
				System.out.println("5) Exit\n");
				System.out.print("Selection: ");

				int option = this.getIntInput(1, 5);
			
				switch(option)
				{
					// display account info
					case 1:
						this.displayCurAccountInfo();
					break;
					
					// saving balance
					case 2:
						this.displaySave();
					break;
					
					// checking balance
					case 3:
						this.displayCheck();
					break;
	
					// Logout
					case 4:
						this.logOut();
					break;
					
					// Exit
					case 5:
						this.exit();
					break;
					
					default:
						System.out.println("ERROR: invalid option. try again");
					break;
				}

			}
			else
			{
				System.out.println("1)  Display account information");
				System.out.println("2)  Savings balance");
				System.out.println("3)  Checking balance");
				System.out.println("4)  Withdrawal from savings");
				System.out.println("5)  Deposit to savings");
				System.out.println("6)  Transfer from savings");
				System.out.println("7)  Transfer to savings");
				System.out.println("8)  Withdrawal from checking");
				System.out.println("9)  Deposit to checking");
				System.out.println("10) Transfer from checking");
				System.out.println("11) Transfer to checking");
				System.out.println("12) Change name");
				System.out.println("13) Close Account");
				System.out.println("14) Freeze Account");
				System.out.println("15) Unfreeze Account");
				System.out.println("16) Logout");
				System.out.println("17) Exit\n");
				System.out.print("Selection: ");

				int option = this.getIntInput(1, 12);
				switch(option)
				{
					// Display current account information
					case 1:
						this.displayCurAccountInfo();
					break;
					
					// Saving balance
					case 2:
						this.displaySave();
					break;
					
					//checking balance
					case 3:
						this.displayCheck();
					break;
					
					//withdrawal from savings
					case 4:
						this.withdrawSave();
					break;
					
					//deposit to savings
					case 5:
						this.depositSave();
					break;
					
					//transfer from savings
					case 6:
						this.transferFromSave();
					break;
					
					//transfer to savings
					case 7:
						this.transferToSave();
					break;
					
					//withdrawal from checking
					case 8:
						this.withdrawCheck();
					break;
					
					//deposit to checking
					case 9:
						this.depositCheck();
					break;
					
					//transfer from checking
					case 10:
						this.transferFromCheck();
					break;
					
					//transfer to checking
					case 11:
						this.transferToCheck();
					break;
					
					//change name
					case 12:
						this.changeName();
					break;
					
					//close account
					case 13:
						this.closeAccount();
					break;
					
					//Freeze Account
					case 14:
						this.freezeAccount();
					break;
					
					//Unfreeze account
					case 15:
						this.unfreezeAccount();
					break;
					
					//logout
					case 16:
						logOut();
					break;
					
					//exit
					case 17:
						exit();
					break;
					
					default:
						System.out.println("ERROR: invalid option. try again");
					break;
				}
			}
		}
		else
		{
			System.out.println("1) Go to account by account number");
			System.out.println("2) Go to account by customer name");
			System.out.println("3) Create employee account");
			System.out.println("4) Create admin account");
			System.out.println("5) Logout");
			System.out.println("6) Exit\n");
			System.out.print("Selection: ");

			int option = this.getIntInput(1, 6);
			switch(option)
			{
				// Access account by number
				case 1:
					this.findAccountByNum();
				break;
				
				// Access account by legal name of customer
				case 2:
					this.findAccountByCustName();
				break;
				
				// Create employee account
				case 3:
					this.createEmployeeAccount();
				break;
				
				// Create admin account
				case 4:
					this.createAdminAccount();
				break;
				
				// Logout
				case 5:
					this.logOut();
				break;
				
				// Exit
				case 6:
					exit();
				break;
				
				default:
					System.out.println("ERROR: invalid option. try again");
				break;
			}
		}
	}

	
	private void logOut()
	{
		m_menuState = 0;
	}
	
	private void exit()
	{
		m_menuState = 4;
	}
	
	// Get the index of an account by the account number
	private int findAccountByNum()
	{
		System.out.println("Account number:");
		int accNum = getIntInput(0,Integer.MAX_VALUE);
		for(int i = 0; i < m_accounts.size(); i++)
		{
			if(m_accounts.get(i).getAccountNumber() ==accNum)
				return i;
		}
		
		//account not found
		return -1;
	}

	// Get the index of an account by search the legal name of main or joint account holder
	private int findAccountByCustName()
	{
		System.out.println("Please enter customers first name:");
		String fname = getStringInput();
		System.out.println("Please enter customers last name:");
		String lname = getStringInput();
		for(int i = 0; i < m_accounts.size(); i++)
		{
			if(m_accounts.get(i).getFirstName1().toLowerCase().contentEquals(fname.toLowerCase()) && 
					m_accounts.get(i).getLastName1().toLowerCase().contentEquals(lname.toLowerCase()))
				return i;
			else if (m_accounts.get(i).getFlag(AccountInfo.FLAGS.JOINT) && 
					m_accounts.get(i).getFirstName2().toLowerCase().contentEquals(fname.toLowerCase()) && 
					m_accounts.get(i).getLastName2().toLowerCase().contentEquals(lname.toLowerCase()))
				return i;
		}

		//account not found
		return -1;
	}
	
	// Get the index of an account by searching the main user name or joint user name
	private int findAccountByUserName()
	{
		System.out.println("User name:");
		String userName = getStringInput();
		//get account number
		for(int i = 0; i < m_users.size(); i++)
		{
			if(m_users.get(i).getAccountName().contentEquals(userName))
				return m_users.get(i).getAccountNumber();
		}
		
		//account not found
		return -1;
		
	}
	
	// Look for customer account
	//
	// _uName: Customer first name
	// _password: Customer last name
	private int findCustomer()
	{
		System.out.println("Please enter first name:");
		String fname = getStringInput();
		System.out.println("please enter last name:");
		String lname = getStringInput();
		
		// Find Customer account
		for(int i = 0; i < m_users.size(); i++)
		{
			if(m_users.get(i).getFirstName().toLowerCase().contentEquals(fname.toLowerCase()) && 
			   m_users.get(i).getLastName().toLowerCase().contentEquals(lname.toLowerCase()))
			{
				// Found customer account
				return i;
			}
		}
		//User not found
		System.out.println("Customer not found");
		return -1;
	}
	
	private void closeAccount()
	{
		
		if(-1 == m_curAccount)
			return;
		
		System.out.println("Are you sure you want to close this account? yes/no");
		String input = getStringInput().toLowerCase();
		if(input.contentEquals("yes") || input.contentEquals("y"))
			m_accounts.get(m_curAccount).setFlag(AccountInfo.FLAGS.CLOSED, true);
	}
	
	// Display the currently selected account's saving balance
	private void displaySave()
	{
		if(-1 != m_curAccount)
			System.out.println("Savings balance: " + m_accounts.get(m_curAccount).getSaveBalance());
	}
	
	// Display the currently selected account's checking balance
	private void displayCheck()
	{
		if(-1 == m_curAccount)
			return;

		System.out.println("Checking balance: " + m_accounts.get(m_curAccount).getCheckBalance());
	}
	
	private void freezeAccount()
	{
		if(-1 == m_curAccount)
			return;

		System.out.println("Ensure the proper paperwork is filed with legal before proceeding\nAre you sure about freezing this account? (yes/no)");
		
		String input = getStringInput().toLowerCase();
		if(input.contentEquals("yes") || input.contentEquals("y"))
			m_accounts.get(m_curAccount).setFlag(AccountInfo.FLAGS.FROZEN, true);
	}
	
	private void unfreezeAccount()
	{
		System.out.println("Ensure the proper paperwork is filed with legal before proceeding\nUnfreeze this account? (yes/no)");
		m_accounts.get(m_curAccount).setFlag(AccountInfo.FLAGS.FROZEN, true);
		
	}
	
	// Approve an account
	private void approveAccount()
	{
		if(-1 == m_curAccount)
			return;
		m_accounts.get(m_curAccount).setFlag(AccountInfo.FLAGS.APPROVED, true);
	}
	
	// Deny an account
	private void denyAccount()
	{
		if(-1 == m_curAccount)
			return;
		m_accounts.get(m_curAccount).setFlag(AccountInfo.FLAGS.DENIED, true);
	}
	
	// Deposit money to the saving of the currently selected account
	private void depositSave()
	{
		if(-1 == m_curAccount)
			return;
		
		System.out.println("Enter amount to deposit:");
		double deposit = getDoubleInput();
		m_accounts.get(m_curAccount).depositSave(deposit);
	}
	
	// Deposit money to the checking of the currently selected account
	private void depositCheck()
	{
		if(-1 == m_curAccount)
			return;
		
		System.out.println("Enter amount to deposit:");
		double deposit = getDoubleInput();
		m_accounts.get(m_curAccount).depositCheck(deposit);
		
	}
	
	// Withdrawal money from the saving of the currently selected account
	private void withdrawSave()
	{
		if(-1 == m_curAccount)
			return;
		
		System.out.println("Enter amount to withdraw:");
		double withdraw = getDoubleInput();
		m_accounts.get(m_curAccount).withdrawSave(withdraw);
		
	}
	private void withdrawCheck()
	{
		if(-1 == m_curAccount)
			return;
		
		System.out.println("Enter amount to withdraw:");
		double withdraw = getDoubleInput();
		m_accounts.get(m_curAccount).withdrawCheck(withdraw);
	}
	
	private void transferFromSave()
	{
		if(-1 == m_curAccount)
			return;
		
		System.out.println("Target account:");
		int targetAccount = getIntInput(0,Integer.MAX_VALUE);
		int targetIndex = -1;
		// find target account
		for(int i = 0; i < m_accounts.size(); i++)
		{
			if(targetAccount == m_accounts.get(i).getAccountNumber())
			{
				targetIndex = i;
				break;
			}
		}
		
		if(-1 == targetIndex)
		{
			System.out.println("ERROR: Target account not found");
			return; 
		}
		
		System.out.println("Amount to transfer to account " + targetAccount + ":");
		double dAmount = getDoubleInput();
		
		if(m_accounts.get(m_curAccount).getSaveBalance() >= dAmount)
		{
			m_accounts.get(m_curAccount).withdrawSave(dAmount);
			m_accounts.get(targetIndex).depositSave(dAmount);
		}
		else
			System.out.println("ERROR: account lacks enough funds");
		
	}
	
	private void transferToSave()
	{
		if(-1 == m_curAccount)
			return;
		
		System.out.println("Target account:");
		int targetAccount = getIntInput(0,Integer.MAX_VALUE);
		int targetIndex = -1;
		// find target account
		for(int i = 0; i < m_accounts.size(); i++)
		{
			if(targetAccount == m_accounts.get(i).getAccountNumber())
			{
				targetIndex = i;
				break;
			}
		}
		
		if(-1 == targetIndex)
		{
			System.out.println("ERROR: Target account not found");
			return; 
		}
		
		System.out.println("Amount to transfer from account " + targetAccount + ":");
		double dAmount = getDoubleInput();
		
		if(m_accounts.get(targetIndex).getSaveBalance() >= dAmount)
		{
			m_accounts.get(targetIndex).withdrawSave(dAmount);
			m_accounts.get(m_curAccount).depositSave(dAmount);
		}
		else
			System.out.println("ERROR: target account lacks enough funds");
	}
	
	private void transferFromCheck()
	{
		if(-1 == m_curAccount)
			return;
		
		System.out.println("Target account:");
		int targetAccount = getIntInput(0,Integer.MAX_VALUE);
		int targetIndex = -1;
		// find target account
		for(int i = 0; i < m_accounts.size(); i++)
		{
			if(targetAccount == m_accounts.get(i).getAccountNumber())
			{
				targetIndex = i;
				break;
			}
		}
		
		if(-1 == targetIndex)
		{
			System.out.println("ERROR: Target account not found");
			return; 
		}
		
		System.out.println("Amount to transfer to account " + targetAccount + ":");
		double dAmount = getDoubleInput();
		
		if(m_accounts.get(m_curAccount).getCheckBalance() >= dAmount)
		{
			m_accounts.get(m_curAccount).withdrawCheck(dAmount);
			m_accounts.get(targetIndex).depositCheck(dAmount);
		}
		else
			System.out.println("ERROR: account lacks enough funds");
	}
	
	private void transferToCheck()
	{
		if(-1 == m_curAccount)
			return;
		
		System.out.println("Target account:");
		int targetAccount = getIntInput(0,Integer.MAX_VALUE);
		int targetIndex = -1;
		// find target account
		for(int i = 0; i < m_accounts.size(); i++)
		{
			if(targetAccount == m_accounts.get(i).getAccountNumber())
			{
				targetIndex = i;
				break;
			}
		}
		
		if(-1 == targetIndex)
		{
			System.out.println("ERROR: Target account not found");
			return; 
		}
		
		System.out.println("Amount to transfer from account " + targetAccount + ":");
		double dAmount = getDoubleInput();
		
		if(m_accounts.get(targetIndex).getCheckBalance() >= dAmount)
		{
			m_accounts.get(targetIndex).withdrawCheck(dAmount);
			m_accounts.get(m_curAccount).depositCheck(dAmount);
		}
		else
			System.out.println("ERROR: target account lacks enough funds");
	}

	// change the password of the current user account
	private void changePassword()
	{
		if(-1 == m_curUser)
			return;
		System.out.println("Please enter current password");
		String curWord = getStringInput();
		if(!m_users.get(m_curUser).getPassword().contentEquals(curWord))
		{
			System.out.println("Incorrect password");
			return;
		}
		
		// Get new password
		System.out.println("Please enter new password");
		String newWord1 = getStringInput();
		System.out.println("Confirm new password");
		String newWord2 = getStringInput();
		if(!newWord1.contentEquals(newWord2))
		{
			System.out.println("Passwords don't match");
			return;
		}
		
		// Update password
		m_users.get(m_curUser).setPassword(newWord1);
	}
	
	private void changeName()
	{
		//TODO
	}

	// Create a new user account and bank account
	private boolean newAccount()
	{
		boolean bJoint = false;
		AccountInfo account1;
		String uName1;
		
		// check if user name is unique
		boolean bIsUnique = false;
		do
		{
			System.out.println("Enter user name:");
			uName1 = getStringInput();
			bIsUnique = true;
			for(int i = 0; i < m_users.size(); i++)
			{
				if(uName1 == m_users.get(i).getAccountName())
					bIsUnique = false;
			}
			
			if(!bIsUnique)
				System.out.println("User Name already taken");
		}
		while (!bIsUnique);
		
		System.out.println("Enter first name:");
		String fName1 = getStringInput();
		System.out.println("Enter last name:");
		String lName1 = getStringInput();
		System.out.println("SSN:");
		int ssn1 = getIntInput(0,Integer.MAX_VALUE);
		
		System.out.println("Enter password:");
		String word1 = getStringInput();
		System.out.println("Confirm password:");
		String word2 = getStringInput();
		while(!word1.contentEquals(word2))
		{
			System.out.println("passwords don't match, try again");
			System.out.println("Enter password:");
			word1 = getStringInput();
			System.out.println("Confirm password:");
			word2 = getStringInput();
		}
		
		User user1 = new User(uName1, word1, User.getCustomerCode(), fName1, lName1);
		
		System.out.println("Joint Account? (yes/no)");
		String joint = getStringInput();
		bJoint = joint.toLowerCase().contentEquals("yes");
		User user2 = null;
		int ssn2 = 0;
		if(bJoint)
		{
			System.out.println("Enter user name:");
			String uName2;
			// check if user name is unique
			bIsUnique = false;
			do
			{
				System.out.println("Enter user name:");
				uName2 = getStringInput();
				bIsUnique = true;
				for(int i = 0; i < m_users.size(); i++)
				{
					if(uName2 == m_users.get(i).getAccountName())
						bIsUnique = false;
				}
				
				if(!bIsUnique)
					System.out.println("User Name already taken");
			}
			while (!bIsUnique);
			
			System.out.println("Enter first name:");
			String fName2 = getStringInput();
			System.out.println("Enter last name:");
			String lName2 = getStringInput();
			System.out.println("SSN:");
			ssn2 = getIntInput(0,Integer.MAX_VALUE);
			
			System.out.println("Enter password:");
			String word3 = getStringInput();
			System.out.println("Confirm password:");
			String word4 = getStringInput();
			while(!word3.contentEquals(word4))
			{
				System.out.println("passwords don't match, try again");
				System.out.println("Enter password:");
				word3 = getStringInput();
				System.out.println("Confirm password:");
				word4 = getStringInput();
			}
			
			user2 = new User(uName2, word2, User.getCustomerCode(), fName2, lName2);
		}
		
		//Get new account number
		int num = m_accounts.size();
		boolean bSearch = true;
		do
		{
			bSearch = false;
			for(int i = 0; i < m_accounts.size(); i++)
			{
				if(m_accounts.get(i).getAccountNumber() == num)
				{
					num++;
					bSearch = true;
					break;
				}
			}
			
		}while(bSearch);
		/*
		System.out.println("Money for saving account?");
		double save = getDoubleInput();
		System.out.println("Money for checking account?");
		double check = getDoubleInput();
		
		m_users.add(user1);
		m_users.add(user2);
		*/
		double save = 0;
		double check = 0;
		account1 = new AccountInfo();
		account1.setAccountNumber(num);
		account1.depositSave(save);
		account1.setFlag(AccountInfo.FLAGS.PENDING, true);
		account1.setFlag(AccountInfo.FLAGS.JOINT, bJoint);
		account1.depositCheck(check);
		account1.setFirstName1(fName1);
		account1.setLastName1(lName1);
		account1.setSSN1(ssn1);
		
		if(bJoint)
		{
			account1.setFirstName2(user2.getFirstName());
			account1.setLastName2(user2.getLastName());
			account1.setSSN2(ssn2);
		}
		user1.setAccountNumber(num);
		m_users.add(user1);
		if(bJoint)
		{
			user2.setAccountNumber(num);
			m_users.add(user2);
		}
		m_accounts.add(account1);
		
		return true;
		
	}

	// Display the account information of the currently selected account
	private void displayCurAccountInfo()
	{
		if(-1 == m_curAccount)
			return;
		m_accounts.get(m_curAccount).displayInfo();
	}

	// Get an int as user input
	// Return: an error checked int
	//
	// _min: the min acceptable number
	// _max: the max acceptable number
	private int getIntInput(int _min, int _max)
	{
		boolean bIsValid = false;
		int option = -1;
		
		//data check
		while(!bIsValid)
		{
			// Make sure you got an int
			try
			{
				option = m_sc.nextInt();
			} 
			catch(InputMismatchException e) 
			{}
			finally
			{
				m_sc.nextLine();
			}
						
			// Check range
			if (option >= _min && option <=_max)
				bIsValid = true;
			else
			{
				System.out.println("ERROR: Invalid option. Please select " + _min + " - " + _max);
			}
		}
		
		
		return option;
	}
	
	// Get string input from user
	private String getStringInput()
	{
		return m_sc.nextLine();
	}
	
	// Create a new admin account
	private boolean createAdminAccount()
	{
		System.out.println("User name:");
		String userName;
		// check if user name is unique
		boolean bIsUnique = false;
		do
		{
			System.out.println("Enter user name:");
			userName = getStringInput();
			bIsUnique = true;
			for(int i = 0; i < m_users.size(); i++)
			{
				if(userName == m_users.get(i).getAccountName())
					bIsUnique = false;
			}
			
			if(!bIsUnique)
				System.out.println("User Name already taken");
		}
		while (!bIsUnique);

		System.out.println("First name:");
		String fName = getStringInput();
		System.out.println("Last name:");
		String lName = getStringInput();
		
		System.out.println("Password:");
		String word1 = getStringInput();
		System.out.println("Confirm Password:");
		String word2 = getStringInput();
		if(!word1.contentEquals(word2))
		{
			System.out.println("Passwords don't match");
			System.out.println("Password:");
			word1 = getStringInput();
			System.out.println("Confirm Password:");
			word2 = getStringInput();
		}
		
		User newUser = new User(userName, word1, User.getAdminCode(), fName, lName);
		m_users.add(newUser);
		
		return true;
	}
	
	// Create a new employee account
	private boolean createEmployeeAccount()
	{
		System.out.println("User name:");
		String userName;
		// check if user name is unique
		boolean bIsUnique = false;
		do
		{
			System.out.println("Enter user name:");
			userName = getStringInput();
			bIsUnique = true;
			for(int i = 0; i < m_users.size(); i++)
			{
				if(userName == m_users.get(i).getAccountName())
					bIsUnique = false;
			}
			
			if(!bIsUnique)
				System.out.println("User Name already taken");
		}
		while (!bIsUnique);
		System.out.println("First name:");
		String fName = getStringInput();
		System.out.println("Last name:");
		String lName = getStringInput();
		
		System.out.println("Password:");
		String word1 = getStringInput();
		System.out.println("Confirm Password:");
		String word2 = getStringInput();
		if(!word1.contentEquals(word2))
		{
			System.out.println("Passwords don't match");
			System.out.println("Password:");
			word1 = getStringInput();
			System.out.println("Confirm Password:");
			word2 = getStringInput();
		}
		
		User newUser = new User(userName, word1, User.getEmployeeCode(), fName, lName);
		m_users.add(newUser);
		
		return true;
	}
	
	private double getDoubleInput()
	{
		double input = Double.MIN_VALUE;
		do
		{
			try
			{
				input = m_sc.nextDouble();
			} 
			catch(InputMismatchException e) 
			{
				System.out.println("ERROR: Invalid input. Try again");
			}
			finally
			{
				m_sc.nextLine();
			}
		}while(Double.MAX_VALUE == input);

		return input;
	}
}
