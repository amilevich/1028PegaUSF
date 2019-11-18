package com.project0.bankapp;

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

public class Account implements Serializable {

	/**
	*
	*/
	// scanners
		Scanner input = new Scanner(System.in);

		// instantiation of objects
		static Customer cust = new Customer();
		Employee empl = new Employee();
		
		//arraylist  for  storing customer information
		ArrayList<String> singleAccountList = new ArrayList<String>();
		ArrayList<String> jointAccountList = new ArrayList<String>();
		static ArrayList<Customer> CustomersList = new ArrayList<Customer>();
		ArrayList<String> approveAccountList = new ArrayList<String>();
//		ArrayList<Account> approveAccountList = new ArrayList<Account>();

		// option variable
		int counter = 0;
		int option;
		Random generator = new Random();// generate random number for account ID
		// declaring account variables

		private int accID = generator.nextInt(100000);
		private boolean isJoint;
		private String status = "Pending";
		private double balance;
		String stringAccID = Integer.toString(accID);
		private String accCustFname;
		private String accCustLname;
		private String accUserName;
		private String accPassword;
		String accStringCustID;
		static String filename = "./objectFilbe.txt";
		double previousTransaction;
		static String user, pass;

	// -----------------------------------------------------------------------------------------------------------------------------
	// no args constructor
	Account() {

	}
	
    public Account(String stringAccID, String accCustFname, String accCustLname, double bal,String status, String accStringCustID ) {
    	super();
    	this.accCustFname = accCustFname;
    	this.accCustLname = accCustLname;
    	this.accStringCustID = accStringCustID;
    	this.balance = bal;
    	this.status =  status;
    }

    // account getters
	public String getAcctID() {
		return stringAccID;
	}

	public boolean isJoint() {
		return isJoint;
	}

	public String getStatus() {
		return status;
	}

	public double getBalance() {
		return balance;
	}

	// account setters
	public void setAcctID(int acctID) {
		this.accID = acctID;
	}

	public void setJoint(boolean isJoint) {
		this.isJoint = isJoint;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	@Override
	public String toString() {
		return "Account status: " + status + ", Balance: " + balance + ", AccountID=" + stringAccID + ", First name: "
				+ accCustFname + ", Last name: " + accCustLname + ", CustomerID: " + accStringCustID;
	}
	
	
//---------------------------------------------------------------------------------------------------------------------------------------


	// Deposit method
	public void Deposit(double amount) {
		if ( amount > 0) {
			for(Customer cd : CustomersList) {
			
				if(user.equals(cd.getUserName())) {
				
					cd.setBal(cd.getBal() + amount);
					System.out.println("The amount of $" + amount + " was succesfully deposited!");
					cust.writeCustObject(filename, CustomersList);
					System.out.println("Your balance  is $: " + cd.getBal());
				}
			}
			/*
			if (amount > 0) {
	            for (Customer jv : customerList)
	                if (user.equals(jv.getUserName())) {
	                    jv.setBalance(jv.getBalance() + amount);
	                    System.out.println("Your amount deposit is " + amount);
	                    System.out.println("******************************************************************");
	                    System.out.println("Your balance now is: " + jv.getBalance());
	                    c.writeCustomer(Filename, customerList);
	                }*/
			previousTransaction = amount;
		
		} else {
			System.out.println("Invalid input!! Please try again!!");
		}
	}// end deposit method

	// Withdrawal method
	public void Withdrawal(double amount) {
		if (amount > balance) {
			System.out.println("You don't have enough balance to withdraw $" + amount);
			
		} else if(amount <= 0){
			System.out.println("You cannot withdraw $" + amount);
			System.out.println("Invalid input!! Please try again!!");
		}else {
			balance -= amount;
			previousTransaction = - amount;
			System.out.println("$" + amount + " has been withdrawn");
		}
	}// end withdraw 
	
	// method for the previous transaction
	public void previousTransaction() {
		
		if (previousTransaction > 0) {
			System.out.println(" Deposited " + previousTransaction);
		}
		else if(previousTransaction < 0) {
			System.out.println("Withdrawn: " +Math.abs(previousTransaction));// used +Math.abc for the absolute value for withdrawn 
		}
		else {
			System.out.println("No trasaction ocurred");
		}
	}
	
	// ---------------------------------------------------------------------------------------------------------------------------------

	// Registration method
	public void Registration() {
		System.out.println("_______________________________________________________________________________");
		System.out.println("Type 1. to open a single account");
		System.out.println("Type 2. to open a joint account");
		option = input.nextInt();
		if (option == 1) {
			counter++;
			while (true) {
				System.out.println("Please enter user first name: " + counter);

				// getting customer first name
				
				String temp = input.next();
				cust.setCustFname(temp);
				try {
					Integer.valueOf(temp);
					System.out.println("SORRY!! That is an invalid input!!(only contain letters)");
					continue;
				} catch (Exception e) {
					break;
				}
			}
			// get lastname and print out
			while (true) {
				System.out.println("Please enter your last name: " + counter);
				String temp = input.next();
				cust.setCustLname(temp);
				try {
					Integer.valueOf(temp);
					System.out.println("SORRY!! That is an invalid input!! (only contain letters)");
					continue;
				} catch (Exception e) {
					break;
				}
				
			}// end while loop
			// asking Customer to create a username
			while (true) {
				System.out.println();
				System.out.println("Awesome " + cust.getCustFname() + " " + cust.getCustLname());
				System.out.println();
				System.out.println("Please create a user name:");
				System.out.println("Your user name should be between 5 & 10 characters!");
				System.out.println();
				cust.setUserName(input.next());
				if (cust.getUserName().length() > 5 && cust.getUserName().length() <= 10) {
					System.out.println("Nice!! Your user name was created!!");
					System.out.println();
					break;
				} else {

					System.out.println("SORRY!! Your user name must be 5 or 10 characters long");
					System.out.println();
				}
				// Asking customer to create password
				
			}// end user name while loop
			
			
			while (true) {

				System.out.println("Please create a password:");
				System.out.println("Your password should not contain no more than 10 characters!");
				System.out.println();
				cust.setPassword(input.next());
				if (cust.getPassword().length() > 5 && cust.getPassword().length() <= 10) {
					System.out.println("Nice!! Your password was created!!");
					System.out.println();
					break;
				} else {

					System.out.println("SORRY!! Your password must be 5 or 10 characters long");
					System.out.println();
				
				}
			}// end pass while loop
			
			 System.out.println("Your account ID is: " + accID);
			 System.out.println();
			 System.out.println("Congratulations!! " + cust.getCustFname() + ", Your account has been created!!");
			 System.out.println("The status of your account is: " + status);
			 System.out.println();
//			 cust.serializedCustomer(CustomersList);
			 
		} else if (option == 2) {
			for (int i = 0; i < option; i++) {
				while (true) {
					System.out.println("Please enter user first name: " + counter);
					String temp = input.next();
					cust.setCustFname(temp);
					jointAccountList.add("First name: " + cust.getCustFname());
					System.out.println();
					try {
						Integer.valueOf(temp);
						System.out.println("SORRY!! That is an invalid input!!(only contain letters)");
						continue;
					} catch (Exception e) {
						break;
					}
				} // end of while loop
				while (true) {
					System.out.println("Please enter your last name: " + counter);
					String temp = input.next();
					cust.setCustLname(temp);
					 jointAccountList.add("Last name: " + cust.getCustLname());
					try {
						Integer.valueOf(temp);
						System.out.println("SORRY!! That is an invalid input!! (only contain letters)");
						continue;
					} catch (Exception e) {
						break;
					}
				} // end of while loop
				
					//  create a username
				while (true) {
					System.out.println();
					System.out.println("Awesome " + cust.getCustFname() + " " + cust.getCustLname());
					System.out.println();
					System.out.println("Please create a user name:");
					System.out.println("Your user name should be between 5 & 10 characters!");
					System.out.println();
					cust.setUserName(input.next());
					if (cust.getUserName().length() > 5 && cust.getUserName().length() <= 10) {
						jointAccountList.add(cust.getUserName());
						System.out.println("Nice!! Your user name was created!!");
						System.out.println();
						break;
					} else {
						System.out.println("SORRY!! Your user name must be 5 or 10 characters long");
						System.out.println();
					}
					//customer to create password
				}// end username while loop
				
				while (true) {
					System.out.println("Please create a password:");
					System.out.println("Your password should not contain no more than 10 characters!");
					System.out.println();
					cust.setPassword(input.next());
					if (cust.getPassword().length() > 5 && cust.getPassword().length() <= 10) {
						jointAccountList.add("Password: " + cust.getPassword());
						System.out.println("Nice!! Your password was created!!");
						System.out.println();
						break;
					} else {
						System.out.println("SORRY!! Your password must be 5 or 10 characters long");
						System.out.println();
					}
				}// end of while loop
				
			}
			 System.out.println("Your account ID is: " + accID);
			 System.out.println();
			 System.out.println("Congratulations!! Your account has been created and its status is: " + status);
			 System.out.println();
			jointAccountList.add(stringAccID);
			System.out.println();
			jointAccountList.add(status);
			System.out.println(jointAccountList);
		}
		
		 CustomersList.add(new Customer(cust.getCustFname(),cust.getCustLname(),cust.getUserName(),cust.getPassword(),cust.getCustID(), cust.getAccID(),cust.getStatus(), cust.getBal()));
		 cust.writeObject(filename, CustomersList);
	
		mainMenu();
	}// end registration
	
// employee signing
	public void EmployeSignin() {
		System.out.println("Please enter your username: ");
		String tempEmpUser = input.next();
		//empl.setEmplUserName(tempEmpUser);
		System.out.println("Please enter your password: ");
		String tempEmpPass = input.next();
		//empl.setEmplPassword(tempEmpPass);
		if (tempEmpUser.equals(empl.getEmplUserName()) && tempEmpPass.equals(empl.getEmplPassword())) {
			// menu of what the employee wants to do
			Account account = new Account();
			account.employeeMenu();
		} else {
			System.out.println("Employee user or password incorrect!");
			EmployeSignin();
		}
	}// end employee signing

	public void mainMenu() {
		char option;
		String input2;
		   cust.readObject(filename);
		   System.out.println();
	        System.out.println("________________________________________________________________________ ");
	        System.out.println("|                         W E L C O M E TO:                             |");
	        System.out.println("|                                                                       |");
	        System.out.println("|                         CRISTIAN'S BANKAPP                            |");
	        System.out.println("|_______________________________________________________________________|");
	        System.out.println("| 'a' : If your are already a customer, please sign in                  |");
	        System.out.println("| 'b' : Sign in as an employee                                          |");
	        System.out.println("| 'c' : Register to open an account with us                             |");
	        System.out.println("| 'q' : Exit                                                            |");
	        System.out.println("|_______________________________________________________________________|");
	        System.out.println();
	        System.out.print("Please enter your option below: ");
	        System.out.println();
		do {
			input2 = input.next();
			option = input2.charAt(0);
			switch (option) {
			case 'a':
				// sign in as a customer method
				customerSign();
				bankingMenu();
				break;
			case 'b':
				// sign in as employee method
				EmployeSignin();
				break;
			case 'c':
				// Customer register method
				Registration();
				break;
			case 'q':
				System.out.println("Thank you and goodbye!");
				break;
			default:
				System.out.println("You entered the wrong option");
			}
		} while	 (option != 'q');
	}

	public void employeeMenu() {
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
	
		do {
			
			option = input.nextInt();
			switch (option) {
			case 1:
				// view Customers
				//cust.deserializedCustomer(CustomersList);
				//cust.readObject(filename);
				//System.out.println(Account.CustomersList);
				for(Customer cst : Account.CustomersList) {
					System.out.println(cst);
					
				}
				
				break;
			case 2:
                //approve method
////				for(Customer cst : Account.CustomersList) {
//					System.out.println(cst);
//				}
				approval();
                
                break;
            case 3:
              deny();
            	
                break;
            case 4:
                //Go back to employee menu
            	employeeMenu();
            	
                break;
            case 5:
                
                //calling the main menu again
            	cust.writeObject(filename, CustomersList);
                mainMenu();
                
                break;
                default: System.out.println("You entered the wrong option");
				System.out.println("You entered the wrong option");
			}
		} while (option != 5);
	}// end employee method
	

	
	//Menu method
	public void bankingMenu() {
		int option;
		double balance = cust.getBal();
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n");
		System.out.println("What would you like to do? ");
		System.out.println("1. Check your balance ");
		System.out.println("2. Make a deposit ");
		System.out.println("3. Withdraw");
		System.out.println("4. See your previous transaction");
		System.out.println("5. Exit");
		
		do {
			System.out.println("=============================================================");
			System.out.println("What would you like to do next ? Please select an opction ");
			System.out.println("=============================================================");
			option = scanner.nextInt();
			System.out.println("\n");

			
			switch(option) {
			
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Your Balance is:  " + "$" + cust.getBal());
				System.out.println("----------------------------------");
				System.out.println("\n");
				break;
				
			case 2:
				System.out.println("-----------------------------------");
				System.out.println("Enter an amount to deposit: ");
				System.out.println("------------------------------------");
				int amount1 = scanner.nextInt();
				Deposit(amount1);
				System.out.println("\n");
				System.out.println("$" + amount1 + " has been deposited");
				System.out.println("Your new balance is: " + "$" + cust.getBal());

				break;
				
			case 3:
				System.out.println("--------------------------------------");
				System.out.println("Enter an amount to withdraw: ");
				System.out.println("---------------------------------------");
				int amount2 = scanner.nextInt();
				Withdrawal(amount2);
				
				System.out.println("Your balance now is: $"  + cust.getBal());
				System.out.println("\n");
				break;
				
			case 4:
				System.out.println("----------------------------------------");
				previousTransaction();
				System.out.println("-----------------------------------------");
				System.out.println("\n");
				break;
				
			case 5:
            	cust.writeObject(filename, CustomersList);
            	mainMenu();
				System.out.println("=============================================");
				break;
				
				default:
				System.out.println("Invalid option!! Please enter a valid option ");
				
			}
			
		}while(option != 5);
		
		System.out.println("Thank You for using our sevices!! ");
		
	}// end banking menu
	
	
	public void customerSign() {		
		Scanner custsign = new Scanner(System.in);
		System.out.println("Please enter your username: ");
		user = custsign.next();
		System.out.println();
		System.out.println("Please enter your password");
		pass = custsign.next();
		System.out.println("_______________________________________________________________________");
        for (int j = 0; j < CustomersList.size(); j++) {
            if(CustomersList.get(j).getUserName().contains(user) && CustomersList.get(j).getPassword().contains(pass)) {
                
                System.out.println(CustomersList.get(j).toString().replaceAll("^.|.$", "").replace(", ", "\n"));
                bankingMenu();
                
            }
        }// end for each

		System.out.println("SORRY! incorrect username or passsword!!");
		customerSign();
	}// end customer sign in
	
	
	//approval method
	@SuppressWarnings("unlikely-arg-type")
	public static void approval() {
		
		for(Customer cst : Account.CustomersList) {
			System.out.println(cst);	
		}
		
		Scanner accID = new Scanner(System.in);
		System.out.println();
		System.out.println("Please enter the account ID you want to approve: ");
		System.out.println();
		String approve = accID.next();
		System.out.println("******************************************************************************************");
	     for (int i = 0; i < CustomersList.size(); i++) {
	    	 if(CustomersList.get(i).getAccID().contains(approve)) {
	        
	              System.out.println(CustomersList.get(i).toString().replaceAll("^.|.$", "").replace(", ", "\n"));
	    	 System.out.println();
	    	 System.out.println("Do you want to approve, (yes) or (No)?");
	    	 String option = accID.next();
	    	 if(option.equals("yes")) {
	    		 CustomersList.get(i).setStatus("approved");
	    		 cust.writeObject(filename,CustomersList);
	    		 }
	    	 
	    	 }
	            
	        }// end for each
	     
	}// end approval
	

public static void deny() {
	
	for(Customer dcust : Account.CustomersList) {
		System.out.println(dcust);	
	}
	
	Scanner accID = new Scanner(System.in);
	System.out.println();
	System.out.println("Please enter the account ID you want to deny: ");
	System.out.println();
	String approve = accID.next();
	System.out.println("******************************************************************************************");
     for (int i = 0; i < CustomersList.size(); i++) {
    	 if(CustomersList.get(i).getAccID().contains(approve)) {
        
              System.out.println(CustomersList.get(i).toString().replaceAll("^.|.$", "").replace(", ", "\n"));
    	 System.out.println();
    	 System.out.println("Do you want to deny, (yes) or (No)?");
    	 String option = accID.next();
    	 if(option.equals("yes")) {
    		 CustomersList.get(i).setStatus("pending");
    		 cust.writeObject(filename,CustomersList);
    		 }
    	 
    	 }
            
        }// end for each
     
}// end approval




}// end class
	
	
	
	
	
	


