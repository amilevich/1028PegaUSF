package com.examples.employeemenu;

import java.util.List;
import java.util.Scanner;

import com.examples.accounts.Accounts;
import com.examples.customers.Customers;
import com.examples.dao.AccountsDaoImpl;
import com.examples.dao.CustomersDaoImpl;
import com.examples.dao.EmployeeDaoImpl;
import com.examples.employeesandadmins.Employees;
import com.examples.menu.MainMenu;
public class EmpMenu {
	

	 public static void employeeSignIn() {
	
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
	    Employees empl = new Employees();
			String username;
			System.out.println();
			System.out.println("Please enter your employee username: ");
			username = sc.next();
			EmployeeDaoImpl.emplExist(username);
			if (username.equals(empl.getEmpUsername())) {
				EmployeeSigninpass();
		} else {
			System.out.println("Employee user or password is incorrect!");
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
			System.out.println("Employee user or password incorrect");
			employeeSignIn();
		}
	}// end customer pass
		public static void approval() {
			AccountsDaoImpl acct = new AccountsDaoImpl();
			CustomersDaoImpl cImpl = new CustomersDaoImpl();
			Customers cust = new Customers();
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println();
			System.out.println("Please enter the account ID for the account you want to approve: ");
			System.out.println();
			int accID = sc.nextInt();
		    Accounts acc = new Accounts();
		    acc = acct.selectAccountsByAccountID(accID);
		    System.out.println(acc);
		    	 System.out.println();
		    	 System.out.println("Do you want to approve this account, (y) or (n)?");
		    	 String option = sc.next();
		    	 if(option.equals("y")) {
		    		String app = "approved";
		    		 acc.setStatus(app);
		    		 System.out.println(acc.getStatus());
		    		 acct.updateAccounts(acc);
		    		 System.out.println("Account: " + accID + " has been approved");
		    		 cImpl.updateCustomers(cust);
		    		 cust.setStatus(app);
		    		 employeeMenu();
		    	 }else if(option.equals("n")){
		    		 System.out.println("Ok. going back to the employee menu.");
		    		 employeeMenu();

		    	 }else {
		    		 System.out.println("Please enter a valid option. going back to the menu");
		    		 employeeMenu();
		    	 }    
		     }
		
	
	public static void employeeMenu() {
		System.out.println("========================================");
		System.out.println("");
		System.out.println("          Employee Menu:");
		System.out.println("");
        System.out.println(" Press 1 to get a list of all customers");
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
				AccountsDaoImpl emplViewcust1 = new AccountsDaoImpl();
				List<Accounts> custViewList1 = emplViewcust1.selectAllAccounts();
				for(int j = 0; j < custViewList1.size(); j++) {
					System.out.println(custViewList1.get(j).toString().replaceAll("^.|.$","").replace(", ", "\n"));
				}
				System.out.println();
				 System.out.println("Press 4 to return to the employee menu");
				
				
				break;
			case 2:
				AccountsDaoImpl emplViewcust = new AccountsDaoImpl();
				List<Accounts> custViewList = emplViewcust.selectAllAccounts();
				for(int j = 0; j < custViewList.size(); j++) {
					System.out.println(custViewList.get(j).toString().replaceAll("^.|.$","").replace(", ", "\n"));
				}
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