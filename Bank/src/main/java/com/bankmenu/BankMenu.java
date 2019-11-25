package com.bankmenu;

import java.util.List;
import java.util.Scanner;

import com.employee.Employee;
import com.mainmenu.MainMenu;
import com.accounts.Accounts;
import com.customers.Customers;
import com.customers.dao.*;
public class BankMenu {
	

	 public static void EmployeeSignin() {
	
		Scanner sc = new Scanner(System.in);
	    Employee empl = new Employee();
			String username;
			System.out.println();
			System.out.println("Please enter your username: ");
			username = sc.next();
			EmployeeDaoImpl.emplExist(username);
			if (username.equals(empl.getEmplUserName())) {
				EmployeeSigninpass();
		} else {
			System.out.println("Employee user or password incorrect!");
			EmployeeSignin();
		}
		
	 }
	 
	 private static void EmployeeSigninpass() {
		    Employee empl = new Employee();
    	 String password;
   		Scanner sc = new Scanner(System.in);
   		System.out.println();
   		System.out.println("Please enter your password: ");
   		password = sc.next();
   		CustomersDaoImpl.custExist1(password);
   		
   		if (password.equals(empl.getEmplPassword())) {
			      employeeMenu();
		} else {
			System.out.println("Employee user or password incorrect!");
			EmployeeSignin();
		}
	}// end customer pass
		public static void approval() {
			AccountsDaoImpl acct = new AccountsDaoImpl();
			
			Scanner sc = new Scanner(System.in);
			System.out.println();
			System.out.println("Please enter the account ID you want to approve: ");
			System.out.println();
			int accID = sc.nextInt();
			System.out.println(acct.selectAccountsByAccountID(accID));
			System.out.println("******************************************************************************************");
		    Accounts acc = new Accounts();
		    acc = acct.selectAccountsByAccountID(accID);
		    System.out.println(acc);
		    	 System.out.println();
		    	 System.out.println("Do you want to approve, (yes) or (No)?");
		    	 String option = sc.next();
		    	 if(option.equals("yes")) {
		    		 acc.setStatus("approved");
		    		 acct.updateAccounts(acc);
		    		 System.out.println("Account: " + accID + "has been approved");
                    
		    	 }else {
		    		 System.out.println("Status still pending!");
		    	 
		    	 
		            
		        }// end for each
		     
		}// end approval
	
	public static void employeeMenu() {
		System.out.println("_________________________________________________________________________");
		System.out.println("|                                                                        |");
		System.out.println("|                        Employee Menu:                                  |");
		System.out.println("|________________________________________________________________________|");
		System.out.println();
        System.out.println(" Please choose an option: ");
        System.out.println(" (1) : View Customes");
        System.out.println(" (2) : Approve an Account ");
        System.out.println(" (3) : Deny an Account");
        System.out.println(" (4) : Go Back");
        System.out.println(" (5) : Exit");
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
					System.out.println(custList.get(j).toString().replaceAll("^.|.$","").replace(", ", "\n"));
				}
				System.out.println();
				 System.out.println(" (4) : Go Back");
				
				
				break;
			case 2:
                //approve method
////				for(Customer cst : Account.CustomersList) {
//					System.out.println(cst);
//				}
				approval();
                
                break;
            case 3:
             // deny();
            	
                break;
            case 4:
                //Go back to employee menu
            	 employeeMenu();
            	
                break;
            case 5:
            	MainMenu.mainMenu();
        
                break;
			}
		} while (option != 5);
		
		
	}// end employee method
			
	}// end class


