package com.bankmenu;

import java.util.List;
import java.util.Scanner;

import com.accounts.Accounts;
import com.customers.Customers;
import com.daos.AccountsDaoImpl;
import com.daos.CustomersDaoImpl;
import com.employee.Employee;
import com.mainmenu.MainMenu;

public class AdminMenu {
	
	
	public static void adminMenu() {
		System.out.println("_________________________________________________________________________");
		System.out.println("|                                                                        |");
		System.out.println("|                        Admin Menu:                                     |");
		System.out.println("|________________________________________________________________________|");
		System.out.println();
        System.out.println(" Please choose an option: ");
        System.out.println(" (1) : View Customes");
        System.out.println(" (2) : Approve an Account ");
        System.out.println(" (3) : Deny an Account");
        System.out.println(" (4) : Go Back");
        System.out.println(" (5) : Exit");
        System.out.println(" (6) : Cancel an account");
        System.out.println(" (7) : Transfer");
        System.out.println(" (8) : deposit");
        System.out.println(" (9) : withdraw");
        System.out.println();
        System.out.print("Please enter option here: ");
		int option;
		Scanner input = new Scanner(System.in);
		
		do {
			option = input.nextInt();
			switch (option) {
			case 1:
				// view Customers
				CustomersDaoImpl emplcust = new CustomersDaoImpl();
				List<Customers> custList = emplcust.selectAllCustomers();
				for(int j = 0; j < custList.size(); j++) {
					System.out.println("\n");
					System.out.println(custList.get(j).toString().replaceAll("^.|.$","").replace(", ", "\n"));
					System.out.println("\n");
				}
				System.out.println();
				 System.out.println(" (4) : Go Back");
				
				
				break;
			case 2:
                //approve method
////				for(Customer cst : Account.CustomersList) {
//					System.out.println(cst);
//				}
				AccountsDaoImpl emplViewcust = new AccountsDaoImpl();
				List<Accounts> custViewList = emplViewcust.selectAllAccounts();
				for(int j = 0; j < custViewList.size(); j++) {
					System.out.println(custViewList.get(j).toString().replaceAll("^.|.$","").replace(", ", "\n"));
				}
				approval();
                
                break;
            case 3:
            	deny();
            	
                break;
            case 4:
                //Go back to admin menu
            	adminMenu();
            	
                break;
            case 5:
            	MainMenu.mainMenu();
        
                break;
            
            case 6:
            	//cancel
            	break;
            	
            case 7:
            	transfer();
            	break;
            	
            case 8:
            	Deposit() ;
            	break;
            	
            case 9:
            	Withdraw();
            	break;
			}
		} while (option != 9);
		
		
	}// end admin method
	
	public static void approval() {
		AccountsDaoImpl acct = new AccountsDaoImpl();
		CustomersDaoImpl cImpl = new CustomersDaoImpl();
		Customers cust = new Customers();
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("Please enter the account ID for the account you want to approve: ");
		System.out.println();
		int accID = sc.nextInt();
		//System.out.println(acct.selectAccountsByAccountID(accID));
		System.out.println("******************************************************************************************");
	    Accounts acc = new Accounts();
	    acc = acct.selectAccountsByAccountID(accID);
	    System.out.println(acc);
	    	 System.out.println();
	    	 System.out.println("Do you want to approve, (yes) or (No)?");
	    	 String option = sc.next();
	    	 if(option.equals("yes")) {
	    		String app = "approved";
	    		 acc.setStatus(app);
	    		 //System.out.println(acc.getStatus());
	    		 //cImpl.updateCustomers(cust);
	    		 acct.updateAccounts(acc);
	    		 System.out.println("Account: " + accID + " has been approved");
	    		 cImpl.updateCustomers(cust);
	    		 cust.setStatus(app);
	    		 adminMenu();
                
	    	 }else {
	    		 System.out.println("Status still pending!");
	    	 
	    		 adminMenu();
	            
	        }// end for each
	     
	}// end approval
	
	public static void deny() {
		AccountsDaoImpl acct = new AccountsDaoImpl();
		CustomersDaoImpl cImpl = new CustomersDaoImpl();
		Customers cust = new Customers();
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("Please enter the account ID for the account you want to deny: ");
		System.out.println();
		int accID = sc.nextInt();
		//System.out.println(acct.selectAccountsByAccountID(accID));
		System.out.println("******************************************************************************************");
	    Accounts acc = new Accounts();
	    acc = acct.selectAccountsByAccountID(accID);
	    System.out.println(acc);
	    	 System.out.println();
	    	 System.out.println("Do you want to deny, (yes) or (No)?");
	    	 String option = sc.next();
	    	 if(option.equals("yes")) {
	    		String app = "denied";
	    		 acc.setStatus(app);
	    		 //System.out.println(acc.getStatus());
	    		 //cImpl.updateCustomers(cust);
	    		 acct.updateAccounts(acc);
	    		 System.out.println("Account: " + accID + " has been denied");
	    		 cImpl.updateCustomers(cust);
	    		 cust.setStatus(app);
	    		 adminMenu();
                
	    	 }else {
	    		 System.out.println("Your account has been denied!");
	    	 
	    		 adminMenu();
	            
	        }// end for each
	     
	}// end deny
	public static void transfer() {
		AccountsDaoImpl accDao = new AccountsDaoImpl();
		Accounts acctransf = new Accounts();
		Accounts acctransf1 = new Accounts();
		Scanner sc = new Scanner(System.in);
		Customers  cust = new Customers();
		Employee empl = new Employee();
		int amount = 0;
		System.out.println("Please enter your account ID: ");
		int accID = sc.nextInt();
		acctransf  = accDao.selectAccountsByAccountID(accID);
		System.out.println();
		System.out.println("Please now enter the account ID you want to transfer to: ");
		int accID2 = sc.nextInt();
		acctransf1 = accDao.selectAccountsByAccountID(accID2);
		System.out.println();
		System.out.println("OK, now please enter the amount you want to transfer: ");
		amount = sc.nextInt();
		acctransf1.setBalance(amount);
		acctransf.setBalance(acctransf.getBalance() - amount);
		accDao.updateAccounts(acctransf);
		accDao.updateAccounts(acctransf1);
		System.out.println("The amount of $" + amount + " has been transfered to " + accID2);
		adminMenu();
	}// end transfer
	
	// Deposit method
		static public void Deposit() {
			Accounts account = new Accounts();
			AccountsDaoImpl  accDao = new AccountsDaoImpl(); 
			Scanner sc = new Scanner(System.in);
			int amount = 0;
			System.out.println("Please enter the account ID to deposit:");
			int acid = sc.nextInt();
			account = accDao.selectAccountsByAccountID(acid);
			System.out.println();
			System.out.println("Please enter the amount you want to deposit: ");
			amount = sc.nextInt();
			account.setBalance(amount + account.getBalance());
			accDao.updateAccounts(account);
			System.out.println("The amount of $ " + amount + " has been deposited!!");
			adminMenu();
				
		
		}// end deposit
		
		static public void Withdraw() {
			Accounts account = new Accounts();
			AccountsDaoImpl  accDao = new AccountsDaoImpl(); 
			Scanner sc = new Scanner(System.in);
			int amount = 0;
			System.out.println("Please enter the account ID to withdraw :");
			int acid = sc.nextInt();
			account = accDao.selectAccountsByAccountID(acid);
			System.out.println();
			System.out.println("Please enter the amount you want to withdraw: ");
			amount = sc.nextInt();
			account.setBalance(account.getBalance()- amount);
			accDao.updateAccounts(account);
			System.out.println("The amount of $ " + amount + " has been withdrawn!!");
			adminMenu();
			
				
		}// end withdraw
		
		 public static void adminSignin() {
				
				Scanner sc = new Scanner(System.in);
			    Employee empl = new Employee();
					String username;
					System.out.println();
					System.out.println("Please enter your admin username: ");
					username = sc.next();
					//EmployeeDaoImpl.emplExist(username);
					if (username.equals(empl.getEmplUserName())) {
						EmployeeSigninpass();
				} else {
					System.out.println("Employee user or password incorrect!");
					adminSignin();
				}
				
			 }
			 
			 private static void EmployeeSigninpass() {
				    Employee empl = new Employee();
		    	 String password;
		   		Scanner sc = new Scanner(System.in);
		   		System.out.println();
		   		System.out.println("Please enter your admin password: ");
		   		password = sc.next();
		   		CustomersDaoImpl.custExist1(password);
		   		
		   		if (password.equals(empl.getEmplPassword())) {
					      adminMenu();
				} else {
					System.out.println("Employee user or password incorrect!");
					adminSignin();
				}
			}// end customer pass
			 
			 

}// end class
