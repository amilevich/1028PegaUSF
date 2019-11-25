package Project0BankAccountM.Project0BankAccountM;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import org.apache.log4j.Logger;

// Singleton menu system
public class MenuManager
{
	 
	private static MenuManager m_menu;

	
	// utility variables
	private MENUSTATE m_menuState = MENUSTATE.LOG_IN;
	private Account m_curAccount = null;
	private User m_curUser = null;
	private Scanner m_sc = new Scanner(System.in);
	Date date = new Date();
	final static Logger loggy = Logger.getLogger(MenuManager.class);

	public static MenuManager getInstance()
	{
		if(null == m_menu)
			m_menu = new MenuManager();
		
		return m_menu;
	}
	
	// block outside calls of constructor
	private MenuManager() {}
	
	// block outside calls of copy constructor
	private MenuManager(MenuManager c) {}

	// Start up the menu system
	public void initMenuSystem()
	{
//		loggy.info("init menu");
		// set to log in menu
		m_menuState = MENUSTATE.LOG_IN;
		m_curAccount = null;
		m_curUser = null;
		
		// Load accounts
		// 
	}
	
	// Shutdown the menu system
	public void shutDown()
	{
		m_menu = null;
		m_sc.close();
		m_sc = null;
		m_menuState = MENUSTATE.LOG_IN;
		m_curAccount = null;
		m_curUser = null;
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
			case LOG_IN:
				logInMenu();
			break;
			
			// Customer Menu
			case CUSTOMER:
				customerMenu();
			break;
			
			// Employee Menu
			case EMPLOYEE:
				employeeMenu();
			break;
			
			// Admin Menu
			case ADMIN:
				adminMenu();
			break;
			
			// Exit program
			case EXIT:
				m_menuState = MENUSTATE.LOG_IN;
				return false;
		
			default:
			break;
		}
		
		return true;
	}

	public static void readObject(String filename) 
	{
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));)
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
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));)
		{
			oos.writeObject(obj);
		}
		catch(IOException io)  
		{
			io.printStackTrace();
		}
		finally
		{
		}
	}


				
	// Log in an account or create a new customer account.	
	private void logInMenu()
	{
		loggy.info(timeStamp(date) + "Opening Log-in menu");
		// Get log in type
		System.out.println("Account Types\n1) Customer\n2) Employee\n3) Admin\n4) Create New Account");
		int state = this.getIntInput();
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
					
					// Find Customer Account
					UserDaoImpt userDao = new UserDaoImpt();
					User customer = userDao.selectUserByUsername(name);
					if(customer != null)
					{
						if(customer.getPassword().contentEquals(password))
						{
							bValid = true;
							m_curUser = customer;
							AccountDaoImpt adao = new AccountDaoImpt();
							m_curAccount = adao.selectAccountByNumber(m_curUser.getAccountNumber());
							m_menuState = MENUSTATE.CUSTOMER;
						}
						else
							System.out.println("ERROR: Invalid login");
					}
					else
					{
						System.out.println("ERROR: Invalid login");
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
					UserDaoImpt userDao = new UserDaoImpt();
					User employ = userDao.selectUserByUsername(name);
					if(employ != null)
					{
						if(employ.getPassword().contentEquals(password) && employ.isEmployee())
						{
							m_curUser = employ;
							bValid = true;
							m_menuState = MENUSTATE.EMPLOYEE;
						}
						else
							System.out.println("ERROR: Invalid login");
					}
					else
					{
						System.out.println("ERROR: Invalid login");
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
					UserDaoImpt userDao = new UserDaoImpt();
					User admin = userDao.selectUserByUsername(name);
					if(admin != null)
					{
						if(admin.getPassword().contentEquals(password) && admin.isAdmin())
						{
							m_curUser = admin;
							bValid = true;
							m_menuState = MENUSTATE.ADMIN;
						}
						else
							System.out.println("ERROR: Invalid login");
					}
					else
					{
						System.out.println("ERROR: Invalid login");
					}
				}
				break;
				
				case 4:
				{
					this.newAccount();
					state = 0;
					m_menuState = MENUSTATE.LOG_IN;
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
		//error check
		if(null == m_curUser || null == m_curAccount)
		{
			//something got screwed up. return to log in menu
			this.m_menuState = MENUSTATE.LOG_IN;
			return;
		}
		System.out.println("Welcome " + m_curUser.getFirstName() + " " + m_curUser.getLastName() + ", Make your selection");
		if(m_curAccount.isAccountActive())
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
			int option = this.getIntInput();
	
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
			int option = this.getIntInput();
			
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
		//error check
		if(null == m_curUser)
			return;
		System.out.println("Welcome " + m_curUser.getFirstName() + " " + m_curUser.getLastName() + ", Make your selection");
		if(null != m_curAccount)
		{
			if(m_curAccount.getFlag(Account.FLAGS.PENDING))
			{
				System.out.println("1) Display account information");
				System.out.println("2) Approve Account");
				System.out.println("3) Deny Account");
				System.out.println("4) Logout");
				System.out.println("5) Exit\n");
				System.out.print("Selection: ");
				
				int option = this.getIntInput();

				
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

				int option = this.getIntInput();

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

			int option = this.getIntInput();

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
		//error check
		if(null == m_curUser)
		{
			//something is screwed up. return to login
			m_menuState = MENUSTATE.LOG_IN;
			return;
		}
		System.out.println("Welcome " + m_curUser.getFirstName() + " " + m_curUser.getLastName() + ", Make your selection");
		if(null != m_curAccount)
		{
			if(m_curAccount.getFlag(Account.FLAGS.PENDING))
			{
				System.out.println("1) Display account information");
				System.out.println("2) Approve Account");
				System.out.println("3) Deny Account");
				System.out.println("4) Logout");
				System.out.println("5) Exit\n");
				System.out.print("Selection: ");

				int option = this.getIntInput();
			
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
				System.out.println("7)  Withdrawal from checking");
				System.out.println("8)  Deposit to checking");
				System.out.println("9) Transfer from checking");
				System.out.println("10) Change name on account");
				System.out.println("11) Close Account");
				System.out.println("12) Delete User");
				System.out.println("13) Freeze Account");
				System.out.println("14) Unfreeze Account");
				System.out.println("15) Logout");
				System.out.println("16) Exit\n");
//				System.out.println("7)  Transfer to savings");
//				System.out.println("11) Transfer to checking");
				System.out.print("Selection: ");

				int option = this.getIntInput();
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
					//withdrawal from checking
					case 7:
						this.withdrawCheck();
					break;
					
					//deposit to checking
					case 8:
						this.depositCheck();
					break;
					
					//transfer from checking
					case 9:
						this.transferFromCheck();
					break;
					//change name
					case 10:
						this.changeName();
					break;
					
					//close account
					case 11:
						this.closeAccount();
					break;
					
					// delete a user
					case 12:
						deleteUser();
					break;
					
					//Freeze Account
					case 13:
						this.freezeAccount();
					break;
					
					//Unfreeze account
					case 14:
						this.unfreezeAccount();
					break;
					
					//logout
					case 15:
						logOut();
					break;
					
					//exit
					case 18:
						exit();
					break;
					/*					
					//transfer to savings
					case 7:
						this.transferToSave();
					break;
*/					
					/*					
					//transfer to checking
					case 11:
						this.transferToCheck();
					break;
*/					
					
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
			System.out.println("3) Display all accounts");
			System.out.println("4) Create employee account");
			System.out.println("5) Create admin account");
			System.out.println("6) Logout");
			System.out.println("7) Exit\n");
			System.out.print("Selection: ");

			int option = this.getIntInput();
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
				
				//Dispaly all accounts
				case 3:
					this.viewAllAccounts();
				break;
				
				// Create employee account
				case 4:
					this.createEmployeeAccount();
				break;
				
				// Create admin account
				case 5:
					this.createAdminAccount();
				break;
				
				// Logout
				case 6:
					this.logOut();
				break;
				
				// Exit
				case 7:
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
		m_menuState = MENUSTATE.LOG_IN;
	}
	
	private void exit()
	{
		m_menuState = MENUSTATE.EXIT;
	}
	
	// Get the index of an account by the account number
	private Account findAccountByNum()
	{
		int num = -1;
		// Get account number from user
		do
		{
			System.out.println("Account number:");
			num = getIntInput();
		} while (-1 == num);
		
		// Find the account and return reference to it
		AccountDaoImpt dao = new AccountDaoImpt();
		return dao.selectAccountByNumber(num);
	}

	// Get the index of an account by search the legal name of main or joint account holder
	private List<Account> findAccountByCustName()
	{
		System.out.println("Please enter customers first name:");
		String fname = getStringInput();
		System.out.println("Please enter customers last name:");
		String lname = getStringInput();
		AccountDaoImpt dao = new AccountDaoImpt();

		//account not found
		return dao.selectAccountByRealname(fname, lname);
	}
	
	// Get the index of an account by searching the main user name or joint user name
	private Account findAccountByUserName()
	{
		System.out.println("User name:");
		String userName = getStringInput();
		UserDaoImpt udao = new UserDaoImpt();
		AccountDaoImpt adao = new AccountDaoImpt();
		
		//get account number
		User user = null;
		Account account = null;
		user = udao.selectUserByUsername(userName);
		account = adao.selectAccountByNumber(user.getAccountNumber());
		
		//account not found
		return account;
		
	}
	
	// Look for customer account
	//
	// _uName: Customer first name
	// _password: Customer last name
	private List<User> findCustomer()
	{
		List<User> output = null;
		System.out.println("Please enter first name:");
		String fname = getStringInput();
		System.out.println("please enter last name:");
		String lname = getStringInput();
		
		// Find Customer account
		UserDaoImpt dao = new UserDaoImpt();
		output = dao.selectUserByRealname(fname, lname);

		//User not found
		if(output != null)
			if(output.size() == 0)
				System.out.println("Customer not found");
		return output;
	}
	
	// flag the saving account as closed
	private void closeAccount()
	{
		if(null == m_curAccount)
			return;
		
		String input = "";
		do
		{
			System.out.println("Are you sure you want to close this account? yes/no");
			input = getStringInput().toLowerCase();
		} while(!input.contentEquals("yes") || !input.contentEquals("y") || !input.contentEquals("no") || !input.contentEquals("n"));
		if(input.contentEquals("yes") || input.contentEquals("y"))
		{
			m_curAccount.setFlag(Account.FLAGS.CLOSED, true);
			//update the database
			AccountDaoImpt dao = new AccountDaoImpt();
			dao.updateAccount(m_curAccount);
		}
	}
	
	private boolean deleteUser()
	{
		System.out.println("Enter user to delete:");
		String username = getStringInput();
		UserDaoImpt dao = new UserDaoImpt();
		User user = dao.selectUserByUsername(username);
		//check if user exists
		if(null != user)
		{
			String input = "";
			do
			{
				System.out.println("Delete user account " + username + "?");
				input = getStringInput().toLowerCase();
			} while(!input.contentEquals("yes") || !input.contentEquals("y") || !input.contentEquals("no") || !input.contentEquals("n"));
			if(input.contentEquals("yes") || input.contentEquals("y"))
			{
				do
				{
					System.out.println("Are you sure you want to delete user " + username + "? yes/no");
					input = getStringInput().toLowerCase();
				} while(!input.contentEquals("yes") || !input.contentEquals("y") || !input.contentEquals("no") || !input.contentEquals("n"));
				if(input.contentEquals("yes") || input.contentEquals("y"))
				{
					dao.deleteUser(user);
					return true;
				}
			}
			return false;
		}
		System.out.println("ERROR: user does not exist");
		return false;
	}
	
	private boolean deleteAccount()
	{
		System.out.println("Enter Account number of account to delete:");
		int accNum = getIntInput();
		AccountDaoImpt dao = new AccountDaoImpt();
		Account account = dao.selectAccountByNumber(accNum);
		//check if user exists
		if(null != account)
		{
			String input = "";
			do
			{
				System.out.println("Delete account " + accNum + "?");
				input = getStringInput().toLowerCase();
			} while(!input.contentEquals("yes") || !input.contentEquals("y") || !input.contentEquals("no") || !input.contentEquals("n"));
			if(input.contentEquals("yes") || input.contentEquals("y"))
			{
				do
				{
					System.out.println("Are you sure you want to delete account " + accNum + "? yes/no");
					input = getStringInput().toLowerCase();
				} while(!input.contentEquals("yes") || !input.contentEquals("y") || !input.contentEquals("no") || !input.contentEquals("n"));
				if(input.contentEquals("yes") || input.contentEquals("y"))
				{
					dao.deleteAccount(account);
					return true;
				}
			}
			return false;
		}
		System.out.println("ERROR: user does not exist");
		return false;
	}
	
	// Display the currently selected account's saving balance
	private void displaySave()
	{
		if(null != m_curAccount)
			System.out.println("Savings balance: " + m_curAccount.getSaveBalance());
		else
			System.out.println("ERROR: not logged into an account");
	}
	
	// Display the currently selected account's checking balance
	private void displayCheck()
	{
		if(null != m_curAccount)
			System.out.println("Checking balance: " + m_curAccount.getCheckBalance());
		else
			System.out.println("ERROR: not logged into an account");
	}
	
	// Freeze an account. Note only admins are capable of freezing accounts
	private void freezeAccount()
	{
		if(null != m_curUser)
		{
			if(m_curUser.getUserType()!= User.getAdminCode())
			{
				System.out.println("ERROR: ONLY admins can freeze accounts");
			}
		}
		if(null != m_curAccount)
		{
			System.out.println("Ensure the proper paperwork is filed with legal before proceeding\nAre you sure about freezing this account? (yes/no)");
			
			String input = ""; 
			do
				getStringInput().toLowerCase();
			while(!input.contentEquals("yes") || !input.contentEquals("y") || !input.contentEquals("no") || !input.contentEquals("n"));
			if(input.contentEquals("yes") || input.contentEquals("y"))
			{
				loggy.info(timeStamp(date) + "Account " + m_curAccount.getAccountNumber() + "has been frozen by " + m_curUser.getFirstName() + ' ' + m_curUser.getLastName());
				m_curAccount.setFlag(Account.FLAGS.FROZEN, true);
				//update the database
				AccountDaoImpt dao = new AccountDaoImpt();
				dao.updateAccount(m_curAccount);
			}
		}
		else
			System.out.println("ERROR: not logged into an account");
	}
	
	// Freeze an account. Note only admins are capable of freezing accounts
	private void unfreezeAccount()
	{
		if(null != m_curUser)
		{
			if(!m_curUser.isAdmin())
			{
				System.out.println("ERROR: ONLY admins can unfreeze accounts");
			}
		}
		
		if(null != m_curAccount)
		{
			System.out.println("Ensure the proper paperwork is filed with legal before proceeding\nUnfreeze this account? (yes/no)");
			String input = ""; 
			do
				getStringInput().toLowerCase();
			while(!input.contentEquals("yes") || !input.contentEquals("y") || !input.contentEquals("no") || !input.contentEquals("n"));
			if(input.contentEquals("yes") || input.contentEquals("y"))
			{
				loggy.info(timeStamp(date) + "Account " + m_curAccount.getAccountNumber() + "has been unfrozen by " + m_curUser.getFirstName() + ' ' + m_curUser.getLastName());
				m_curAccount.setFlag(Account.FLAGS.FROZEN, true);
				//update the database
				AccountDaoImpt dao = new AccountDaoImpt();
				dao.updateAccount(m_curAccount);
			}
		}
		else
			System.out.println("ERROR: not logged into an account");
	}
	
	// Approve an account
	private void approveAccount()
	{
		if(null != m_curUser)
		{
			// check if user level is high enough
			if(m_curUser.isAdmin() || m_curUser.isEmployee())
			{	
				if(null != m_curAccount)
				{
					loggy.info(timeStamp(date) + "Account " + m_curAccount + " approved by " + m_curUser.getFirstName() + ' ' + m_curUser.getLastName());
					m_curAccount.setFlag(Account.FLAGS.APPROVED, true);
					//update the database
					AccountDaoImpt dao = new AccountDaoImpt();
					dao.updateAccount(m_curAccount);
				}
			}
			else
				System.out.println("ERROR: Access level to low to approve accounts");
		}
	}
	
	// Deny an account
	private void denyAccount()
	{
		if(null != m_curUser)
		{
			// check if user level is high enough
			if(m_curUser.isAdmin() || m_curUser.isEmployee())
			{	
				if(null != m_curAccount)
				{
					loggy.info(timeStamp(date) + "Account " + m_curAccount + " denied by " + m_curUser.getFirstName() + ' ' + m_curUser.getLastName());
					m_curAccount.setFlag(Account.FLAGS.DENIED, true);
					//update the database
					AccountDaoImpt dao = new AccountDaoImpt();
					dao.updateAccount(m_curAccount);
				}
			}
			else
				System.out.println("ERROR: Access level to low to deny accounts");
		}
	}
	
	// Deposit money to the saving of the currently selected account
	private boolean depositSave()
	{
		if(null != m_curAccount)
		{
			System.out.println("Enter amount to deposit:");
			double deposit = getDoubleInput();
			if(m_curAccount.depositSave(deposit))
			{
				loggy.info(timeStamp(date) + '$' + deposit + " deposited into savings in account " + m_curAccount.getAccountNumber());
				//update the database
				AccountDaoImpt dao = new AccountDaoImpt();
				dao.updateAccount(m_curAccount);
				return true;
			}
		}
		return false;
	}
	
	// Deposit money to the checking of the currently selected account
	private boolean depositCheck()
	{
		if(null != m_curAccount)
		{
			System.out.println("Enter amount to deposit:");
			double deposit = getDoubleInput();
			if(m_curAccount.depositCheck(deposit))
			{
				loggy.info(timeStamp(date) + '$' + deposit + " deposited into checking in account " + m_curAccount.getAccountNumber());
				//update the database
				AccountDaoImpt dao = new AccountDaoImpt();
				dao.updateAccount(m_curAccount);
				return true;
			}
		}
		return false;
	}
	
	// Withdrawal money from the saving of the currently selected account
	private boolean withdrawSave()
	{
		if(null != m_curAccount)
		{
			System.out.println("Enter amount to withdraw:");
			double withdraw = getDoubleInput();
			if(m_curAccount.withdrawSave(withdraw))
			{
				loggy.info(timeStamp(date) + '$' + withdraw + " withdrawn from saving in account " + m_curAccount.getAccountNumber());
				//update the database
				AccountDaoImpt dao = new AccountDaoImpt();
				dao.updateAccount(m_curAccount);
				return true;
			}
		}
		return false;
		
	}
	private boolean withdrawCheck()
	{
		if(null != m_curAccount)
		{
			System.out.println("Enter amount to withdraw:");
			double withdraw = getDoubleInput();
			if(m_curAccount.withdrawCheck(withdraw))
			{
				loggy.info(timeStamp(date) + '$' + withdraw + " withdrawn from checking in account " + m_curAccount.getAccountNumber());
				//update the database
				AccountDaoImpt dao = new AccountDaoImpt();
				dao.updateAccount(m_curAccount);
				return true;
			}
		}
		return false;
	}

	// Transfer money from savings from this account to another account
	private boolean transferFromSave()
	{
		if(null != m_curAccount)
		{
			AccountDaoImpt dao = new AccountDaoImpt();
			// Get the account to be transfered to
			System.out.println("Enter target account for transfered funds:");
			int num = getIntInput();
			Account targetAcc = dao.selectAccountByNumber(num);
			if(null == targetAcc)
			{
				System.out.println("ERROR: transfer target account not found");
				return false;
			}
			
			// Get amount to transfer
			System.out.println("Enter amount of funds to transfer:");
			double amount = getDoubleInput();
			
			// Error check the amount
			if(amount < 0.0)
			{
				System.out.println("ERROR: you can't transfer a negative amount");
				return false;
			}
			else if(m_curAccount.getSaveBalance() < amount)
			{
				System.out.println("ERROR: not enough funds to complete transfer");
				return false;
			}
			else
			{
				//SUCCESS!!!
				m_curAccount.withdrawSave(amount);
				targetAcc.depositSave(amount);
				loggy.info(timeStamp(date) + '$' + amount + " transfered from saving in account " + m_curAccount.getAccountNumber() + " to saving in account " + targetAcc.getAccountNumber());
				//update the database
				dao.updateAccount(m_curAccount);
				dao.updateAccount(targetAcc);
				return true;
			}
		}
		return false;
	}
	
	// transfer money this accounts saving from another accounts saving
	private boolean transferToSave()
	{
		if(null != m_curAccount)
		{
			AccountDaoImpt dao = new AccountDaoImpt();
			// Get the account to be transfered to
			System.out.println("Enter account to transfer funds from:");
			int num = getIntInput();
			Account sourceAcc = dao.selectAccountByNumber(num);
			if(null == sourceAcc)
			{
				System.out.println("ERROR: account not found");
				return false;
			}
			
			// Get amount to transfer
			System.out.println("Enter amount of funds to transfer:");
			double amount = getDoubleInput();
			
			// Error check the amount
			if(amount < 0.0)
			{
				System.out.println("ERROR: you can't transfer a negative amount");
				return false;
			}
			else if(sourceAcc.getSaveBalance() < amount)
			{
				System.out.println("ERROR: not enough funds to complete transfer");
				return false;
			}
			else
			{
				//SUCCESS!!!
				sourceAcc.withdrawSave(amount);
				m_curAccount.depositSave(amount);
				loggy.info(timeStamp(date) + '$' + amount + " transfered from saving in account " + sourceAcc.getAccountNumber() + " to saving in account " + m_curAccount.getAccountNumber());
				//update the database
				dao.updateAccount(m_curAccount);
				dao.updateAccount(sourceAcc);
				return true;
			}
		}
		return false;
	}
	
	// Transfer from this checking account to another checking
	private boolean transferFromCheck()
	{
		if(null != m_curAccount)
		{
			AccountDaoImpt dao = new AccountDaoImpt();
			// Get the account to be transfered to
			System.out.println("Enter target account for transfered funds:");
			int num = getIntInput();
			Account targetAcc = dao.selectAccountByNumber(num);
			if(null == targetAcc)
			{
				System.out.println("ERROR: transfer target account not found");
				return false;
			}
			
			// Get amount to transfer
			System.out.println("Enter amount of funds to transfer:");
			double amount = getDoubleInput();
			
			// Error check the amount
			if(amount < 0.0)
			{
				System.out.println("ERROR: you can't transfer a negative amount");
				return false;
			}
			else if(m_curAccount.getCheckBalance() < amount)
			{
				System.out.println("ERROR: not enough funds to complete transfer");
				return false;
			}
			else
			{
				//SUCCESS!!!
				m_curAccount.withdrawCheck(amount);
				targetAcc.depositCheck(amount);
				loggy.info(timeStamp(date) + '$' + amount + " transfered from checking in account " + m_curAccount.getAccountNumber() + " to checking in account " + targetAcc.getAccountNumber());
				//update the database
				dao.updateAccount(m_curAccount);
				dao.updateAccount(targetAcc);
				return true;
			}
		}
		return false;
	}

	// Transfer funds from another check to this checking account
	private boolean transferToCheck()
	{
		if(null != m_curAccount)
		{
			AccountDaoImpt dao = new AccountDaoImpt();
			// Get the account to be transfered to
			System.out.println("Enter account to transfer funds from:");
			int num = getIntInput();
			Account sourceAcc = dao.selectAccountByNumber(num);
			if(null == sourceAcc)
			{
				System.out.println("ERROR: account not found");
				return false;
			}
			
			// Get amount to transfer
			System.out.println("Enter amount of funds to transfer:");
			double amount = getDoubleInput();
			
			// Error check the amount
			if(amount < 0.0)
			{
				System.out.println("ERROR: you can't transfer a negative amount");
				return false;
			}
			else if(sourceAcc.getCheckBalance() < amount)
			{
				System.out.println("ERROR: not enough funds to complete transfer");
				return false;
			}
			else
			{
				//SUCCESS!!!
				sourceAcc.withdrawCheck(amount);
				m_curAccount.depositCheck(amount);
				loggy.info(timeStamp(date) + '$' + amount + " transfered from checking in account " + sourceAcc.getAccountNumber() + " to checking in account " + m_curAccount.getAccountNumber());
				//update the database
				dao.updateAccount(m_curAccount);
				dao.updateAccount(sourceAcc);
				return true;
			}
		}
		return false;
	}

	// change the password of the current user account
	private boolean changePassword()
	{
		if(null != m_curUser)
		{
			System.out.println("Please enter current password");
			String newWord = getStringInput();
			
			if(!m_curUser.getPassword().contentEquals(newWord))
			{
				System.out.println("ERROR: invalid password");
				return false;
			}
			
			// get new password
			System.out.println("Enter new password");
			newWord = getStringInput();
			System.out.println("Confirm new password");
			if(!newWord.contentEquals(getStringInput()))
			{
				System.out.println("ERROR: Confirmed and new password didn't match");
				return false;
			}
			
			//updates the accounts password
			m_curUser.setPassword(newWord);
			UserDaoImpt dao = new UserDaoImpt();
			dao.updateUser(m_curUser);
		}
		return false;
	}
	
	// change the real name on a user
	private boolean changeName()
	{
		if(null != m_curUser)
		{
			System.out.println("Enter new first name");
			String fname = m_sc.nextLine();
			System.out.println("Enter new last name");
			String lname = m_sc.nextLine();
			// confirm the new real name
			System.out.println("Should new name on file be " + fname + ' ' + lname + "? (yes/no");
			String confirm;
			do
			{
				confirm = m_sc.nextLine().toLowerCase();
			} while(!confirm.contentEquals("yes") || !confirm.contentEquals("y") || !confirm.contentEquals("no") || !confirm.contentEquals("n"));
			if(confirm.contentEquals("yes") || confirm.contentEquals("y"))
			{
				//update the name on file
				m_curUser.setFirstName(fname);
				m_curUser.setLastName(lname);
				UserDaoImpt dao = new UserDaoImpt();
				dao.updateUser(m_curUser);
			}
		}
		return false;
	}

	// Create a new user account and bank account
	private boolean newAccount()
	{
		loggy.info(timeStamp(date) + "Opening new customer account");
		boolean bJoint = false;
		Account account1 = null;
		String uName1 = "";
		
		UserDaoImpt userDao = new UserDaoImpt();
		AccountDaoImpt accountDao = new AccountDaoImpt();

		//Get unique user name
		do
		{
			System.out.println("Enter Username");
			uName1 = m_sc.nextLine();
		}while(!userDao.isUsernameUnique(uName1));
		
		System.out.println("Enter first name:");
		String fName1 = getStringInput();
		System.out.println("Enter last name:");
		String lName1 = getStringInput();
		System.out.println("SSN:");
		int ssn1 = getIntInput();
		
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
			String uName2;
			// check if user name is unique
			do
			{
				System.out.println("Enter Username");
				uName2 = m_sc.nextLine();
			}while(!userDao.isUsernameUnique(uName2));
			
			System.out.println("Enter first name:");
			String fName2 = getStringInput();
			System.out.println("Enter last name:");
			String lName2 = getStringInput();
			System.out.println("SSN:");
			ssn2 = getIntInput();
			
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
		Random random = new Random();
		int num = 0;
		do
		{
			num = random.nextInt(Integer.MAX_VALUE);
		}while(!accountDao.isAccountNumberUnique(num));
		account1 = new Account();
		account1.setAccountNumber(num);
		account1.setFlag(Account.FLAGS.PENDING, true);
		account1.setFlag(Account.FLAGS.JOINT, bJoint);
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
		userDao.insertUser(user1);
		if(bJoint)
		{
			user2.setAccountNumber(num);
			userDao.insertUser(user2);
		}
		accountDao.insertAccount(account1);
		m_menuState = MENUSTATE.LOG_IN;
		m_curAccount = null;
		m_curUser = null;
		return true;
		
	}

	// Display the account information of the currently selected account
	private void displayCurAccountInfo()
	{
		if(null != m_curAccount)
			m_curAccount.displayInfo();
	}

	// Get an int as user input
	// Return: an error checked int
	private int getIntInput()
	{
		int option = -1;
		
		//data check
		while(-1 == option)
		{
			// Make sure you got an int
			try
			{
				option = m_sc.nextInt();
			} 
			catch(InputMismatchException e) 
			{
				System.out.println("ERROR: Invalid input. Try again");
			}
			finally
			{
				m_sc.nextLine();
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
		UserDaoImpt userDao = new UserDaoImpt();
		String userName;
		// check if user name is unique
		do
		{
			System.out.println("Enter Username");
			userName = m_sc.nextLine();
		}while(!userDao.isUsernameUnique(userName));

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

		// Add the new admin account to the database
		User newUser = new User(userName, word1, User.getAdminCode(), fName, lName);
		userDao.insertUser(newUser);
		loggy.info(timeStamp(date) + "Admin account " + newUser.getUserName() + " created for " + newUser.getFirstName() + ' ' + newUser.getLastName());
		
		return true;
	}
	
	// Create a new employee account
	private boolean createEmployeeAccount()
	{
		UserDaoImpt dao = new UserDaoImpt();
		String userName;
		// check if user name is unique
		do
		{
			System.out.println("Enter user name:");
			userName = getStringInput();
		}
		while(!dao.isUsernameUnique(userName));
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
		
		//add new user to database
		User newUser = new User(userName, word1, User.getEmployeeCode(), fName, lName);
		dao.insertUser(newUser);
		loggy.info(timeStamp(date) + "Employee account " + newUser.getUserName() + " created for " + newUser.getFirstName() + ' ' + newUser.getLastName());

		return true;
	}
	
	private void viewAllAccounts()
	{
		if(this.m_curUser.isAdmin())
		{
			AccountDaoImpt dao = new AccountDaoImpt();
			List<Account> accounts = dao.selectAllAccount();
			
			// Display everything
			System.out.println("Showing all accounts\n-------------------------------------------------------------------------");
			for(int i = 0; i < accounts.size(); i++)
			{
				System.out.println("Account Number: " + accounts.get(i).getAccountNumber());
				System.out.println("Name: " + accounts.get(i).getFirstName1() + ' ' + accounts.get(i).getLastName1());
				if(accounts.get(i).getFlag(Account.FLAGS.JOINT))
					System.out.println("Joint holder: " + accounts.get(i).getFirstName2() + accounts.get(i).getLastName2());
				System.out.println("Savings: " + accounts.get(i).getSaveBalance());
				System.out.println("Checking: " + accounts.get(i).getCheckBalance());
				if(accounts.get(i).getFlag(Account.FLAGS.PENDING))
					System.out.println("Account still pending approval");
				if(accounts.get(i).getFlag(Account.FLAGS.DENIED))
					System.out.println("Account has been denied");
				if(accounts.get(i).getFlag(Account.FLAGS.CLOSED))
					System.out.println("Account has been closed");
				if(accounts.get(i).getFlag(Account.FLAGS.FROZEN))
					System.out.println("Account has been FROZEN");
			
				System.out.println("\n---------------------------------------\n");
			}
			
		}
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
		}while(Double.MIN_VALUE == input);

		return input;
	}
	
	private enum MENUSTATE
	{
		LOG_IN,
		CUSTOMER,
		EMPLOYEE,
		ADMIN,
		EXIT
	}
	
	private String timeStamp(Date _date)
	{
		return '[' + _date.toString() + "] ";
	}
	

}
