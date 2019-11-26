package part2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class BankDriver {
	
	final static Logger eventLogger= Logger.getLogger(BankDriver.class);

	public static void main(String[] args) {

//		EmployeeDaoImp employeeDaoImp = new EmployeeDaoImp();
//		Employee emp = new Employee("ChrisTaylor", "passw0rd", "Chris", "Taylor", Client.setLocalDoB(1987, 12, 19), "23 winding creek ln tampa fl 45678", 1);
//		employeeDaoImp.insertEmp(emp);
		
		welcomeMenu();	//call welcome menu
		
		System.out.println("\nHave a great rest of your day!");
	}
	
	public static void writeObject(String filename, Object obj) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			oos.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Object readObject(String filename) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			return ois.readObject();
		}catch(IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}return null;
	}
	
	static void signUp () {
		//creates new user
		Client c = new Client();
		
		//takes in all needed info

		//sets first and last names
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first name: ");
		String f = sc.nextLine();
		System.out.println("Enter the last name: ");
		String l = sc.nextLine();
		c.setName(f, l);	
		
		//date of birth
		int count = 0;
		sc = new Scanner(System.in);
		System.out.println("What month were you born in? (1-12)");
		int m = sc.nextInt();

		
		while (m<1 || m>12) {
			count++;
			if (count>=3) {
				System.out.println("Number of tries exceeded."); 
				break;}
			System.out.println("Incorrect input, please try again.");
			System.out.println("What month were you born in? (1-12)");
			m = sc.nextInt();
		}
		
		sc = new Scanner(System.in);																										
		System.out.println("What day of the month were you born in? (enter a number between 1 and 31)");
		int d = sc.nextInt();
		count = 0;
		while (d<1 || d>31) {		//testing to ensure the user selected a number of days between 1 and 31
			count++;
			if (count>=3) {
				System.out.println("Number of tries exceeded."); 
				break;}
			System.out.println("Incorrect input, please try again.");
			System.out.println("What day of the month were you born in? (enter a number between 1 and 31)");
			d = sc.nextInt();																													
		}
		
		System.out.println("What year were you born in? (Please enter the 4 digit year.) ");
		int y = sc.nextInt();
		sc.nextLine();
		while((y<1900 || y>=2020) && count<3) {
			count++;
			if (count>=3) {
				System.out.println("Number of tries exceeded."); 
				break;
			}
			System.out.println("Incorrect input, please try again.");
			System.out.println("What year were you born in? (Please enter the 4 digit year.) ");
			y = sc.nextInt();
			sc.nextLine();
		}

		c.setDoB(Client.setLocalDoB(y,m,d));	//converting from localDate to date
		c.setAddress("a");	//address
		c.register();	//take in and validate user name/password
		
		//create/insert client data to Bank_Clients table
		ClientDaoImp clientDaoImp = new ClientDaoImp();
		clientDaoImp.insertClnt(c);
		//new account number generation process using SQL sequence
		AccountDaoImp accountDaoImp = new AccountDaoImp();
		accountDaoImp.insertAcct(c);	//creates new account with 0.0 balance, Pending status, and generated account number
	}
	
	public static void welcomeMenu() {
		int selection;
		do {
			Menus.displayWelcomeMenu();					//display welcome menu, loop while response is not exit
			selection = selection();				//ask for and take in menu selection
			switch(selection) {
			case 1:			// client log in
				validateClient();
				break;
			case 2:			// employee log in
				validateEmployee();
				break;
			case 3:			// admin log in
				validateAdmin();
				break;
			case 4:			//signs up a new client
				signUp();
				eventLogger.info("New user account created.");
				break;
			case 5:			//exits the application
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\nThank you!");
				eventLogger.info("Application exit.");
				break;	
			default:		//in valid input, will allow the loop to continue
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n     ***Please try again with a valid option.***\n");
				break;
			}
		} while(selection != 5);
	}
	
	private static void validateAdmin() {
		EmployeeDaoImp employeeDaoImpv = new EmployeeDaoImp();
		// take in user name/password then validate
		Scanner sc = new Scanner(System.in);
		System.out.println("\nUser name: ");
		String un = sc.nextLine();
		System.out.println("\nPassword: ");
		String p = sc.nextLine();
	
		Employee emp = employeeDaoImpv.selectEmpByName(un);
		if (emp!=null && emp.getEmpPassword().contentEquals(p) && emp.getAdmin()==1) {
			adminLogIn(emp);
			eventLogger.info("Admin "+emp.getName()+" logged in.");
		} else {
			System.out.println("Invalid credentials.");
		}
	}//end validate admin

	private static void adminLogIn(Employee e) {
		// logs the employee, or admin into the system after checking their authorization
		int selection;
		do {
			Menus.displayAdminMenu();			//display admin menu, loop while response is not exit
			selection = selection();				//ask for and take in menu selection
			switch(selection) {
			case 1:			// view accounts
				viewClientAccountInfo(empClientSelect());
				break;
			case 2:			// manage accounts
				manageAccounts();
				break;
			case 3:			// view clients
				viewClientInfo();
				break;
			case 4:			// deposit
				clientDeposit(adminClientSelect());
				break;	
			case 5:			// withdraw
				clientWithdraw(adminClientSelect());
				break;
			case 6:			//transfer
				clientTransfer(adminClientSelect());
				break;
			case 7:			// exit
				break;	
			default:		//invalid input, will allow the loop to continue
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n     ***Please try again with a valid option.***\n");
				break;
			}
		} while(selection != 7);
	}//end admin log in

	private static Client adminClientSelect() {
		ClientDaoImp clientDaoImp = new ClientDaoImp();
		Scanner sc = new Scanner(System.in);
		System.out.println("\nPlease enter the username of the client that you wish to modify the account(s) of: ");
		String un = sc.nextLine();
		
		Client c = clientDaoImp.selectClntByUserName(un);
		return c;
	}
	
	private static Client empClientSelect() {
		ClientDaoImp clientDaoImp = new ClientDaoImp();
		Scanner sc = new Scanner(System.in);
		System.out.println("\nPlease enter the username of the client that you wish to view the account(s) of: ");
		String un = sc.nextLine();
		
		Client c = clientDaoImp.selectClntByUserName(un);
		return c;
	}

	static int selection() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nPlease enter the number of your selection.");
		int i =  sc.nextInt();
		sc.nextLine();		//clears otherwise un-used new line char
		return i;
	}
	
	private static void validateEmployee() {
		// take in user name/password then validate
		EmployeeDaoImp employeeDaoImpv = new EmployeeDaoImp();
		// take in user name/password then validate
		Scanner sc = new Scanner(System.in);
		System.out.println("\nUser name: ");
		String un = sc.nextLine();
		System.out.println("\nPassword: ");
		String p = sc.nextLine();
	
		Employee emp = employeeDaoImpv.selectEmpByName(un);
		if (emp!=null && emp.getEmpPassword().contentEquals(p)) {
			empLogIn(emp);
			eventLogger.info("Employee "+un+" logged in.");
		} else {
			System.out.println("Invalid credentials.");
		}		
	}//end validateEmployee

	private static void validateClient() {
		ClientDaoImp clientDaoImp = new ClientDaoImp();
		// take in user name/password and validate
		Scanner sc = new Scanner(System.in);
		System.out.println("\nUser name: ");
		String un = sc.nextLine();
		System.out.println("\nPassword: ");
		String p = sc.nextLine();
		
		Client c = clientDaoImp.selectClntByUserName(un);
		if (c!=null && c.getPassword().contentEquals(p)) {
			clientLogIn(c);
			eventLogger.info("Client "+un+" logged in.");
		} else {
			System.out.println("Invalid credentials.");
		}	
	}//end validateClient
	
	private static void clientLogIn(Client client) {
		// logs the client into the system
		int selection=0;
		do {
			Menus.displayClientMenu();				//display client menu, loop while response is not exit
			selection = selection();				//ask for and take in menu selection
			switch(selection) {
			case 1:			// view
				viewClientAccountInfo(client);
				break;
			case 2:			// deposit
				clientDeposit(client);
				break;
			case 3:			//withdraw	
				clientWithdraw(client);
				break;
			case 4:			//transfer
				clientTransfer(client);
				break;	
			case 5:			//exit
				break;
			default:		//in valid input, will allow the loop to continue
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n     ***Please try again with a valid option.***\n");
				break;
			}
		} while(selection != 5);
		
	}//end clientLogIn
	
	private static void clientTransfer(Client client) {
		Scanner sc = new Scanner(System.in);
		double d = 0.0;
		AccountDaoImp accountDaoImp = new AccountDaoImp();
		viewClientAccountInfo(client);
		//ask for account they wish to deposit to		
		System.out.println("\n\nEnter the account number that you wish to transfer FROM:");
		int fromA = sc.nextInt();		
		sc.nextLine();
		System.out.println("\nEnter the account number that you wish to transfer TO:");
		int toA = sc.nextInt();		
		sc.nextLine();
		do {
		System.out.println("\nEnter the amount you wish to transfer:");
		d = sc.nextDouble();
		sc.nextLine();
		}while (d<=0.0);
		
		//withdrawal
		Account acct = accountDaoImp.selectAcctByNum(fromA);
		acct.makeWithdrawal(d);
		accountDaoImp.updateAcct(acct);
		eventLogger.info("Withdrawal made from "+acct.getAcctNum()+" of $"+d);
		
		//deposit
		acct = accountDaoImp.selectAcctByNum(fromA);
		acct.makeDeposit(d);
		accountDaoImp.updateAcct(acct);
		eventLogger.info("Deposit made to "+acct.getAcctNum()+" of $"+d);
		

	}
	
	private static void clientDeposit(Client client) {
		Scanner sc = new Scanner(System.in);
		double d=0.0;
		AccountDaoImp accountDaoImp = new AccountDaoImp();
		
		viewClientAccountInfo(client);		
		System.out.println("\n\nEnter the account number that you wish to use:");
		int a = sc.nextInt();		
		sc.nextLine();
		do {
			System.out.println("\nEnter the amount you wish to deposit:");
			d = sc.nextDouble();
			sc.nextLine();
			if(d<=0) {
				System.out.println("\nThe amount must be greater than 0.");
			}
		} while (d<=0.0);
		
		Account acct = accountDaoImp.selectAcctByNum(a);
		acct.makeDeposit(d);
		accountDaoImp.updateAcct(acct);
		eventLogger.info("Deposit made to "+acct.getAcctNum()+" of $"+d);
	}
	
	private static void clientWithdraw(Client client) {
		Scanner sc = new Scanner(System.in);
		double d=0.0;
		AccountDaoImp accountDaoImp = new AccountDaoImp();
		viewClientAccountInfo(client);
		//ask for account they wish to deposit to		
		System.out.println("\n\nEnter the account number that you wish to use:");
		int a = sc.nextInt();		
		sc.nextLine();
		do {
		System.out.println("\nEnter the amount you wish to withdraw:");
		d = sc.nextDouble();
		sc.nextLine();
		}while (d<=0.0);
		
		Account acct = accountDaoImp.selectAcctByNum(a);
		acct.makeWithdrawal(d);
		accountDaoImp.updateAcct(acct);
		eventLogger.info("Withdrawal made from "+acct.getAcctNum()+" of $"+d);
	}

	private static void viewClientAccountInfo(Client client) {
		AccountDaoImp accountDaoImp = new AccountDaoImp();
		System.out.println(client.toString());
		ArrayList<Account> clientsAccounts = accountDaoImp.selectClientAccts(client.getUsername());
		Account acct;
		System.out.println("Account: \tBalance: \tStatus:");
		
		for (int i=0; i<clientsAccounts.size(); i++) {
			acct = clientsAccounts.get(i);			
			System.out.print(acct.getAcctNum()+"\t\t"+acct.getBalance()+"\t\t"+acct.getStatus());				
			
		}
	}

	private static void empLogIn(Employee employee) {
		// logs the employee into the system after checking their authorization
		int selection;
		do {
			Menus.displayEmployeeMenu();			//display employee menu, loop while response is not exit
			selection = selection();				//ask for and take in menu selection
			switch(selection) {
			case 1:			// view accounts
				viewClientAccountInfo(empClientSelect());
				break;
			case 2:			// manage accounts
				manageAccounts();
				break;
			case 3:			// view clients
				viewClientInfo();
				break;
			case 4:			// exit
				break;	
			default:		//invalid input, will allow the loop to continue
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n     ***Please try again with a valid option.***\n");
				break;
			}
		} while(selection != 4);	
	}//end empLogIn

	private static void viewClientInfo() {
		ClientDaoImp clientDaoImp = new ClientDaoImp();
		ArrayList<Client> clients = clientDaoImp.selectAllClnts();
		for(int i=0; i<clients.size(); i++) {
			if (clients.get(i).getName()==null)
				break;
			else System.out.println(clients.get(i).toString());
		}
	}

	private static void manageAccounts() {
		int selection;
		do {
			AccountDaoImp accountDaoImp = new AccountDaoImp();
			Menus.displayAcctManagement();
			selection = selection();
			switch(selection) {
			case 1:			//approve pending accounts
				System.out.print("Pending ");
				display();
				approveAccount();
				break;
			case 2:			//deny pending accounts
				System.out.print("Pending ");
				display();
				denyAccount();
				break;
			case 3:			//cancel existing accounts
				display();
				cancelAccount();
				break;
			case 4:			// create joint account
				break;
			case 5:			// exit
				break;
			default:		//invalid input, will allow the loop to continue
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n     ***Please try again with a valid option.***\n");
				break;
			}
			//displayPending(accountList);
		}while (selection != 5);
	}//end manageAccounts

	private static void cancelAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the account number you wish to cancel:");
		int an = sc.nextInt();
		sc.nextLine();			//clears the unused new line before a future input
		AccountDaoImp accountDaoImp = new AccountDaoImp();
		Account acct = accountDaoImp.selectAcctByNum(an);
		acct.setStatus(Status.Cancelled);
		accountDaoImp.updateAcct(acct);
	}

	private static void approveAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the account number you wish to approve:");
		int an = sc.nextInt();
		sc.nextLine();			//clears the unused new line before a future input
		AccountDaoImp accountDaoImp = new AccountDaoImp();
		Account acct = accountDaoImp.selectAcctByNum(an);
		acct.setStatus(Status.Approved);
		accountDaoImp.updateAcct(acct);
	}

	private static void denyAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the account number you wish to deny:");
		int an = sc.nextInt();
		sc.nextLine();			//clears the unused new line before a future input
		AccountDaoImp accountDaoImp = new AccountDaoImp();
		Account acct = accountDaoImp.selectAcctByNum(an);
		acct.setStatus(Status.Denied);
		accountDaoImp.updateAcct(acct);
	}

	private static void display () {
		AccountDaoImp accountDaoImp = new AccountDaoImp();
		ArrayList<Account> arr = accountDaoImp.selectAllAcctsPending();
		System.out.println("Account Number(s):");
		for(int i=0; i<arr.size();i++) {
			System.out.println("\t"+arr.get(i).getAcctNum());
		}
	}
}
