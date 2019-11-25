package com.project.saintsbank;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import com.project.saintsdao.SaintsBankCImp;

public class Employee extends Customer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3328575467389340991L;
	
	final static Logger EntryLoog = Logger.getLogger(Employee.class);

	SaintsBankMenu emp1 = new SaintsBankMenu();
	
	 Account addin = new Account();
	
	private int eUserId;
	private String eUser;
	private String ePassword;
	

	
	 public int geteUserId() {
		return eUserId;
	}
	public void seteUserId(int eUserId) {
		this.eUserId = eUserId;
	}
	public String geteUser() {
		return eUser;
	}
	public void seteUser(String eUser) {
		this.eUser = eUser;
	}
	public String getePassword() {
		return ePassword;
	}
	public void setePassword(String ePassword) {
		this.ePassword = ePassword;
	}
	public static void displayInfo(Customer details, int lvl) {
	 
	 }
	/*
	 * Login for Employee account. This mpethod will check the input information against the 
	 */
	 public void elogin(int eKey) {
		int efoundId = 0;
		
		 
		 System.out.println("***************************");
			System.out.println("******EMPLOYEE LOGIN*******");
			System.out.println("***************************");
			System.out.println("\n\n");
			
			SaintsBankCImp empl = new SaintsBankCImp();
			//Searching the employee table for an employee id
			  efoundId = empl.searchId(eKey, 2);
					 
			if(eKey == efoundId) {
			 Employee ebankUser = empl.findByEmployee(eKey);
				System.out.println("Please enter your Username?");
				 String user = emp1.info.nextLine();
				if(user.equals(ebankUser.geteUser()) == true) {
					System.out.println("Please enter your Password?");
						String ePass = emp1.info.nextLine();
						if(ePass.equals(ebankUser.ePassword) == true) {
							System.out.println("Employee login Successful");
							EntryLoog.info("Employee" + geteUserId() + "has logged in");
							 emp1.menuChoiceAccount(2, eKey);
						}// end of password check
						else {
							System.out.println("Password is incorrect");
							emp1.menuLevelOne();
						}// end of password else
				}// end of username check
					else {
						System.out.println("Username doesn't match id ");
						emp1.menuLevelOne();
					}// end of username else
				
					
			}// end of userid check
			else{
				System.out.println("UserID doesn't match");
				emp1.menuLevelOne();
			}
	
		 
	 } 
	
	// Process for approving the account for customer
	 public boolean approval() {
		int  admChoice1 = 0;
		 boolean cause = false;
		 
		 SaintsBankCImp slin = new SaintsBankCImp();
		 
		 
		 admChoice1 = pullAccountsPending();
		 
		// Customer process = new Customer();
		 
		Customer process = slin.findByCustomerId(admChoice1, 1);

		 viewAccountInfo(process, 1);           
		 
		 System.out.println("********Account is Currently Pending*********"); 
		 System.out.println("\n\n Will you like to continue with approval of this account? Y/N");
		 String admChoice = scan.info.next();
		 
		 if(admChoice.equals("Y") || admChoice.equals("y")) {
			 int tempAct = generateAcct();
			 cause = true;
			  //String finalCause = Boolean.toString(cause);
			  process.setApprovalStatus(cause);
			  addin.setAccountBalance(500);
			  addin.setAccountNumber(tempAct);
			  addin.setAccountType("Single");
			 
			  // adding the account number and balance to user account
			  slin.FinSetUpNew(admChoice1,tempAct, 500, "Single", 1);

			 System.out.println("ACCOUNT APPROVED!! " + "Customer # " + admChoice1 + " new account number is "  + tempAct);
			 EntryLoog.info("Employee " + eUserId + " has approved a new account for user" + admChoice);
			 //displayInfo(process, 1);
			 viewAccountInfo(process, 2);
			 emp1.menuChoiceAccount(2, admChoice1);
			 return cause;
		 }
		 else if(admChoice.equals("N") || admChoice.equals("n")) {
			 System.out.println("*****USERID " + admChoice + "'s ACCOUNT WAS NOT APPROVED");
			 emp1.menuChoiceAccount(2, admChoice1);
			 cause = false;
			 return cause;
		 }
		 else {
			 System.out.println("invalid choice. Please try again");
			 approval();
			 return false;
		 }
	}
	 // Extended menu for admins and employees
	 public int employMenuExtend(int cCount) {
		 int choice;
		 
		
		 System.out.println("5. APPROVAL");
		 cCount++;
		 System.out.println("6. CANCEL");
		 
		  choice = scan.info.nextInt();
		 
		return choice;
	 }

	 	//generates account number not in the database
		public int generateAcct() {
			

    		Random genId = new Random();
        	
        	int cusId = genId.nextInt(((8000000-7000000)+ 1 ) + 7000000);
        	
        	
        	
        	System.out.println("NEW ACCOUNT NUMBER  : " + cusId);
        	
        	return cusId; 
	 }
		public static void writeObject1(String filename, Object obj) {
    		//String value[] = new String[6];
    		try(ObjectOutputStream goOut = new ObjectOutputStream(new FileOutputStream(filename))){
    			

    		goOut.writeObject(obj);
    		}catch(IOException io) {
    			io.printStackTrace();
    		}
    	}
    	
    	public static Object readObject1(String filename) {
    		//String name;
    		try(ObjectInputStream comeIn = new ObjectInputStream(new FileInputStream(filename))){
    			ArrayList arrive = (ArrayList) comeIn.readObject();
    			//System.out.println(arrive);
    			return arrive;
    		}catch(IOException exception) {
    			exception.printStackTrace();
    		}
   		catch(ClassNotFoundException anything) {
    			anything.printStackTrace();
    		}
    		return 0;
    	}

    	// Will Print the list of all the new accounts pending approval
    	// For the Employee and admin only
    	public int pullAccountsPending() {
    		int choiceId;
    		
    	//List<Integer>valuesId =
    		
    	SaintsBankCImp sfia = new SaintsBankCImp();
    	
    	List<Integer>valuesId = sfia.searchWApproval();
    	
    	System.out.println("*****USER ACCOUNTS CURRENTLY PENDING*****");
    	
    	for(int  x: valuesId) {
    		System.out.println("UserID : " +  x);
    	}
    		
    	System.out.println("Select the UserID from Above to contiune the process: ");
    	 choiceId = scan.info.nextInt();
    	
    	
			return choiceId;
    		
    	}

    	public int viewAccountInfo(Customer info, int option) {
    		
    		System.out.print("*********Customer Info****************");
    		
    		System.out.println("\nUsername: " + info.getcUserName());
    		System.out.println("Customer Id: " + info.getCustomerID());
    		System.out.println("First Name: " + info.getFirstName());
    		System.out.println("Last Name: " + info.getLastName());
    		
    		
    		if(option == 2) {
    			
    			System.out.println("Account Number: " + addin.getAccountNumber());
    			System.out.println("Account Type: " + addin.getAccountType());
    			System.out.println("Account Balance:" + addin.getAccountBalance());
    			
    		}
    		System.out.print("*********END OF INFO****************");
    		System.out.println("\n\n");
			return 0;
    		
    	}
}
