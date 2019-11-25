package com.examples.employeemenu;

import java.util.List;
import java.util.Scanner;

import com.examples.accounts.Accounts;
import com.examples.customers.Customers;
import com.examples.dao.*;
import com.examples.employeesandadmins.Employees;
import com.examples.menu.MainMenu;
public class EmpMenu {
	

	 public static void employeeSignIn() {
	
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
	    Employees empl = new Employees();
			String username;
			System.out.println();
			System.out.println("Please enter your username: ");
			username = sc.next();
			EmployeeDaoImpl.emplExist(username);
			if (username.equals(empl.getEmpUsername())) {
				EmployeeSigninpass();
		} else {
			System.out.println("Employee user or password incorrect!");
			employeeSignIn();
		}
		
	 }
	 
	 private static void EmployeeSigninpass() {
		    Employees emp = new Employees();
    	 String password;
   		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
   		System.out.println();
   		System.out.println("Please enter your password: ");
   		password = sc.next();
   		CustomersDaoImpl.custExist2(password);
   		
   		if (password.equals(emp.getEmpPassword())) {
			      employeeMenu();
		} else {
			System.out.println("Employee user or password incorrect!");
			employeeSignIn();
		}
	}// end customer pass
		public static void approval() {
			AccountsDaoImpl acct = new AccountsDaoImpl();
			
			@SuppressWarnings("resource")
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
		System.out.println("========================================");
		System.out.println("");
		System.out.println("          Employee Menu:");
		System.out.println("");
        System.out.println(" Press 1 to have a list of customers");
        System.out.println(" Press 2 to approve an Account");
        System.out.println(" Press 3 to deny an account");
        System.out.println(" Press 4 to go back to the previous menu");
        System.out.println(" Press 5 to exit");
        System.out.println();
		int option;
		@SuppressWarnings("resource")
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
				 System.out.println("Press 4 to return to the employee menu");
				
				
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
            	MainMenu.menu();
        
                break;
			}
		} while (option != 5);		
	}			
}