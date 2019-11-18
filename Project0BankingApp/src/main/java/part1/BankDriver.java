package part1;

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
		
		String empFilename = "./serializedemp.txt";		//set serialization file names
		String acctFilename = "./serializedacct.txt";	
		String clntFilename = "./serializedclnt.txt";	

		ArrayList<Employee> employeeList = new ArrayList<Employee>();				//declare array lists for people and accounts
		ArrayList<Account> accountList = new ArrayList<Account>();
		ArrayList<Client> clientList = new ArrayList<Client>();
		
		//seed initial lists
		Admin admin = new Admin("Bob", "Smith", LocalDate.of(1986, Month.JULY, 21), "123 main st, Tampa, FL", 1, "BobSmith", "12345");					//initial population of employee data
		Employee employee = new Employee("Jane", "Doe", LocalDate.of(1990, Month.DECEMBER, 25), "789 oak dr, Tampa, FL", 2, "JaneDoe", "67890");
		employeeList.add(admin);
		employeeList.add(employee);
		Client client = new Client();
		clientList.add(client);
		Account account = new Account();
		accountList.add(account);
		
		ListIterator<Employee> iterator = employeeList.listIterator(); 	//test print of initial employees in the employee array list
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getName());
		}
		
		//pull data from text files  
		//***was causing NULL pointer exceptions when accessing passwords as they were being set to 
		//NULL due to the password variables being set as transient, removed that keyword to proceed***
		try {
			employeeList = (ArrayList<Employee>) readObject(empFilename);
			accountList = (ArrayList<Account>) readObject(acctFilename);
			clientList = (ArrayList<Client>) readObject(clntFilename);
		}catch (Exception e) {
			e.printStackTrace();
		}

		
//		ListIterator<Employee> iterator = employeeList.listIterator(); 	//test print of initial employees in the employee array list
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next().getName());
//		}
		
		
		welcomeMenu(accountList, clientList, employeeList);	//call welcome menu
		
		//write data to text files
		writeObject(empFilename, employeeList);
		writeObject(acctFilename, accountList);
		writeObject(clntFilename, clientList);
		
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
	
	static void signUp (ArrayList<Account> accountList, ArrayList<Client> clientList) {
		//creates new user
		Client c = new Client();
		clientList.add(c);
		
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

		c.setDoB(y,m,d);
		c.setAddress();	//address
		c.register();	//take in and validate user name/password
		
		int a = Account.generateAcctNum();
		c.setAccounts(a);//account
		Account acct = new Account(a);
		accountList.add(acct);
		
		System.out.println("What would you like your username to be?");
		String un = sc.nextLine();
		System.out.println("What would you like your password to be?");
		String p = sc.nextLine();
		c.setUsername(un);			//set the username and password for the client
		c.setPassword(p);
		
	}
	
	public static void welcomeMenu(ArrayList<Account> accountList, ArrayList<Client> clientList, ArrayList<Employee> employeeList) {
		int selection;
		do {
			Menus.displayWelcomeMenu();					//display welcome menu, loop while response is not exit
			selection = selection();				//ask for and take in menu selection
			switch(selection) {
			case 1:			// client log in
				validateClient(accountList, clientList, employeeList);
				break;
			case 2:			// employee log in
				validateEmployee(accountList, clientList, employeeList);
				break;
			case 3:			// admin log in
				validateAdmin(accountList, clientList, employeeList);
				break;
			case 4:			//signs up a new client
				signUp(accountList, clientList);
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
	
	private static void validateAdmin(ArrayList<Account> accountList, ArrayList<Client> clientList,
			ArrayList<Employee> employeeList) {
		// take in user name/password then validate
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\nUser name: ");
		String un = sc.nextLine();
		System.out.println("\nPassword: ");
		String p = sc.nextLine();
	
			for(int i = 0; i<employeeList.size(); i++) {
				if(employeeList.get(i).getEmpUserName().equals(un) && 		//checking the user name
						employeeList.get(i).getEmpPassword().equals(p) &&	//password, and
						(employeeList.get(i)  instanceof Admin)) {			//if the emp is an admin
						adminLogIn(employeeList.get(i), accountList, clientList, employeeList);  ////log them in
						eventLogger.info("Admin "+employeeList.get(i).getName()+" logged in.");
						break;
				}
			}
	}//end validate admin

	private static void adminLogIn(Employee e, ArrayList<Account> accountList, ArrayList<Client> clientList,
			ArrayList<Employee> employeeList) {
		// logs the employee, or admin into the system after checking their authorization
		int selection;
		do {
			Menus.displayAdminMenu();			//display admin menu, loop while response is not exit
			selection = selection();				//ask for and take in menu selection
			switch(selection) {
			case 1:			// view accounts
				empViewClientAccountInfo(accountList);
				break;
			case 2:			// manage accounts
				manageAccounts(accountList);
				break;
			case 3:			// view clients
				viewClientInfo(clientList);
				break;
			case 4:			// deposit
				clientDeposit(adminClientSelect(clientList), accountList);
				break;	
			case 5:			// withdraw
				clientWithdraw(adminClientSelect(clientList), accountList);
				break;
			case 6:			//transfer
				clientTransfer(adminClientSelect(clientList), accountList);
				break;
			case 7:			// exit
				break;	
			default:		//invalid input, will allow the loop to continue
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n     ***Please try again with a valid option.***\n");
				break;
			}
		} while(selection != 7);
	}//end admin log in

	private static Client adminClientSelect(ArrayList<Client> clientList) {
		Client c = new Client();;
		Scanner sc = new Scanner(System.in);
		System.out.println("\nPlease enter the username of the client that you wish to modify the account(s) of: ");
		String un = sc.nextLine();
		
		ListIterator<Client> iterator = clientList.listIterator();
		while(iterator.hasNext()) {
			c = (Client)iterator.next();
			if (c.getUsername().equals(un)) {
				break;
			}
		}
		return c;
	}

	static int selection() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nPlease enter the number of your selection.");
		int i =  sc.nextInt();
		sc.nextLine();		//clears otherwise un-used new line char
		return i;
	}
	
	private static void validateEmployee(ArrayList<Account> accountList, ArrayList<Client> clientList, ArrayList<Employee> employeeList) {
		// take in user name/password then validate
		
		String un = " ";
		String p = " ";
		Employee e;
		Scanner sc = new Scanner(System.in);
		System.out.println("\nUser name: ");
		un = sc.nextLine();
		System.out.println("\nPassword: ");
		p = sc.nextLine();
	
		ListIterator<Employee> iterator = employeeList.listIterator();
		while(iterator.hasNext()) {
			e = iterator.next();
			if (e.getEmpUserName().equals(un)) {			//if user name exists 
				if(e.getEmpPassword().equals(p)) {			//and if password matches
					empLogIn(e, accountList, clientList, employeeList);
					eventLogger.info("Employee "+un+" logged in.");		//log them in
					break;
				}else System.out.println("Incorrect Username and/or Password.");
			}
		}		
	}//end validateEmployee

	private static void validateClient(ArrayList<Account> accountList, ArrayList<Client> clientList, ArrayList<Employee> employeeList) {
		// take in user name/password and validate
		Scanner sc = new Scanner(System.in);
		System.out.println("\nUser name: ");
		String un = sc.nextLine();
		System.out.println("\nPassword: ");
		String p = sc.nextLine();

		for(int i = 0; i<clientList.size(); i++) {
			if(clientList.get(i).getUsername().equals(un) && 		//checking the user name
					clientList.get(i).getPassword().equals(p)) {			//and password
					clientLogIn(clientList.get(i), accountList, clientList);  //log them in
					eventLogger.info("Client "+clientList.get(i).getName()+" logged in.");
					break;
			}
		}
		System.out.println("Incorrect Username and/or Password.");
	}//end validateClient
	
	private static void clientLogIn(Client client, ArrayList<Account> accountList, ArrayList<Client> clientList) {
		// logs the client into the system
		int selection=0;
		do {
			Menus.displayClientMenu();				//display client menu, loop while response is not exit
			selection = selection();				//ask for and take in menu selection
			switch(selection) {
			case 1:			// view
				viewClientAccountInfo(client, accountList);
				break;
			case 2:			// deposit
				clientDeposit(client, accountList);
				break;
			case 3:			//withdraw	
				clientWithdraw(client, accountList);
				break;
			case 4:			//transfer
				clientTransfer(client, accountList);
				break;	
			case 5:			//exit
				break;
			default:		//in valid input, will allow the loop to continue
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n     ***Please try again with a valid option.***\n");
				break;
			}
		} while(selection != 5);
		
	}//end clientLogIn
	
	private static void clientTransfer(Client client, ArrayList<Account> accountList) {
		Scanner sc = new Scanner(System.in);
		double d = 0.0;
		viewClientAccountInfo(client, accountList);
		//ask for account they wish to deposit to		
		System.out.println("Enter the account number that you wish to transfer FROM:");
		int fromA = sc.nextInt();		
		sc.nextLine();
		System.out.println("Enter the account number that you wish to transfer TO:");
		int toA = sc.nextInt();		
		sc.nextLine();
		do {
		System.out.println("Enter the amount you wish to transfer:");
		d = sc.nextDouble();
		sc.nextLine();
		}while (d<=0.0);
		
		for(int i=0; i<accountList.size();i++) {
			if(accountList.get(i).getAcctNum()==fromA && accountList.get(i).getStatus()== Status.Approved) {
				accountList.get(i).makeWithdrawal(d);
				break;
			}else {
				System.out.println("There is not a matching account number that is active.");
			}
		}
		
		for(int i=0; i<accountList.size();i++) {
			if(accountList.get(i).getAcctNum()==toA && accountList.get(i).getStatus()== Status.Approved) {
				accountList.get(i).makeDeposit(d);
				break;
			}else {
				System.out.println("There is not a matching account number that is active.");
			}
		}
	}
	
	private static void clientDeposit(Client client, ArrayList<Account> accountList) {
		Scanner sc = new Scanner(System.in);
		double d=0.0;
		viewClientAccountInfo(client, accountList);
		//ask for account they wish to deposit to		
		System.out.println("Enter the account number that you wish to use:");
		int a = sc.nextInt();		
		sc.nextLine();
		do {
		System.out.println("Enter the amount you wish to deposit:");
		d = sc.nextDouble();
		sc.nextLine();
		} while (d<=0.0);
		
		for(int i=0; i<accountList.size();i++) {
			if(accountList.get(i).getAcctNum()==a && accountList.get(i).getStatus()== Status.Approved) {
				accountList.get(i).makeDeposit(d);
				eventLogger.info("Deposit made to "+accountList.get(i).getAcctNum()+" of $"+d);
				break;
			}else if (i==accountList.size()-1) { //when the last item fails to trigger the above if statement
				System.out.println("There is not a matching account number that is active.");
			}
		}
	}
	
	private static void clientWithdraw(Client client, ArrayList<Account> accountList) {
		Scanner sc = new Scanner(System.in);
		double d=0.0;
		viewClientAccountInfo(client, accountList);
		//ask for account they wish to deposit to		
		System.out.println("Enter the account number that you wish to use:");
		int a = sc.nextInt();		
		sc.nextLine();
		do {
		System.out.println("Enter the amount you wish to withdraw:");
		d = sc.nextDouble();
		sc.nextLine();
		}while (d<=0.0);
		
		for(int i=0; i<accountList.size();i++) {
			if(accountList.get(i).getAcctNum()==a && accountList.get(i).getStatus()== Status.Approved) {
				accountList.get(i).makeWithdrawal(d);
				eventLogger.info("Withdrawal made from "+accountList.get(i).getAcctNum()+" of $"+d);
				break;
			}else {
				System.out.println("There is not a matching account number that is active.");
			}
		}	
	}

	private static void viewClientAccountInfo(Client client, ArrayList<Account> accountList) {
		ArrayList<Integer> clientsAccounts = client.getAccounts();
		int acctNum;
		System.out.println("Account: \tBalance:");	
		for (int i=0; i<clientsAccounts.size(); i++) {	//for the clients account(s)
			acctNum = clientsAccounts.get(i);			//use the account number
			System.out.print(acctNum+"\t\t");				
			for(int j=0; j<accountList.size();j++) {//to look up the account balance
				if(accountList.get(j).getAcctNum()==acctNum) {
					System.out.println(accountList.get(j).getBalance());
					break;
				}
			}
		}
	}
	
	private static void empViewClientAccountInfo( ArrayList<Account> accountList) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the account number you wish to view:");
		int a = sc.nextInt();
		sc.nextLine();			//clears the unused new line before a future input
		System.out.println("Account: \tStatus: \tBalance:");
		System.out.print(a+"\t\t");
		
		if(accountList.isEmpty()) {
			System.out.println("There are no accounts to view.");
		}else {
			for(int i=0; i<accountList.size();i++) {
				if(accountList.get(i).getAcctNum()==a) {
					System.out.println(accountList.get(i).getAcctNum()+"\t\t"+accountList.get(i).getStatus()+"\t\t"+accountList.get(i).getBalance());
					break;
				}
			}
		}		
	}

	private static void empLogIn(Employee employee, ArrayList<Account> accountList, ArrayList<Client> clientList, ArrayList<Employee> employeeList) {
		// logs the employee into the system after checking their authorization
		int selection;
		do {
			Menus.displayEmployeeMenu();			//display employee menu, loop while response is not exit
			selection = selection();				//ask for and take in menu selection
			switch(selection) {
			case 1:			// view accounts
				empViewClientAccountInfo(accountList);
				break;
			case 2:			// manage accounts
				manageAccounts(accountList);
				break;
			case 3:			// view clients
				viewClientInfo(clientList);
				break;
			case 4:			// exit
				break;	
			default:		//invalid input, will allow the loop to continue
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n     ***Please try again with a valid option.***\n");
				break;
			}
		} while(selection != 4);	
	}//end empLogIn

	private static void viewClientInfo(ArrayList<Client> clientList) {
		
		for(int i=0; i<clientList.size(); i++) {
			if (clientList.get(i).getName()==null)
				break;
			else System.out.println(clientList.get(i).toString());
		}
	}

	private static void manageAccounts(ArrayList<Account> accountList) {
		int selection;
		do {
			Menus.displayAcctManagement();
			selection = selection();
			switch(selection) {
			case 1:			//approve pending accounts
				displayPending(accountList);
				approveAccount(accountList);
				break;
			case 2:			//deny pending accounts
				displayPending(accountList);
				denyAccount(accountList);
				break;
			case 3:			//cancel existing accounts
				cancelAccount(accountList);
				break;
			case 4:			// add account holder to joint account
				break;
			default:		//invalid input, will allow the loop to continue
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n     ***Please try again with a valid option.***\n");
				break;
			}
			displayPending(accountList);
		}while (selection != 4);
	}

	private static void cancelAccount(ArrayList<Account> accountList) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the account number you wish to cancel:");
		int a = sc.nextInt();
		sc.nextLine();			//clears the unused new line before a future input
		for(int i=0; i<accountList.size();i++) {
			if(accountList.get(i).getAcctNum()==a) {
				accountList.get(i).setStatus(Status.Cancelled);
				break;
			}
		}
	}

	private static void approveAccount(ArrayList<Account> accountList) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the account number you wish to approve:");
		int a = sc.nextInt();
		sc.nextLine();			//clears the unused new line before a future input
		for(int i=0; i<accountList.size();i++) {
			if(accountList.get(i).getAcctNum()==a) {
				accountList.get(i).setStatus(Status.Approved);
				break;
			}
		}
	}

	private static void denyAccount(ArrayList<Account> accountList) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the account number you wish to deny:");
		int a = sc.nextInt();
		sc.nextLine();			//clears the unused new line before a future input
		for(int i=0; i<accountList.size();i++) {
			if(accountList.get(i).getAcctNum()==a) {
				accountList.get(i).setStatus(Status.Denied);
				break;
			}
		}
	}

	private static void displayPending (ArrayList<Account> accountList) {
		System.out.println("Account Number:");
		for(int i=0; i<accountList.size();i++) {
			if(accountList.get(i).getStatus().equals(Status.Pending)){
				System.out.println("\t"+accountList.get(i).getAcctNum());
			}
		}
	}
}
