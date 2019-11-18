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

public class Employee extends Customer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3328575467389340991L;
	
	final static Logger EntryLoog = Logger.getLogger(Employee.class);

	SaintsBankMenu emp1 = new SaintsBankMenu();
	
	private int eUserId = 534;
	private String eUser = "bossmoves";
	private String ePassword = "saints2";
	

	
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
	   // Customer details = new Customer();
		int tempId = 0, tempAcct =0;
		boolean tempApp= false;
		float tempBal = 0;
		String tempFirst = null, tempLast = null, tempUser = null;
		String finaliD, asps, finalBal = null, finAcct =  null;
		
		if (lvl == 1) {
	     tempId= client2.get(0).getCustomerID();
	     tempFirst = client2.get(0).getFirstName();
	     tempLast = client2.get(0).getLastName();
	     tempUser = client2.get(0).getcUserName();
	     tempApp = client2.get(0).isApprovalStatus();
	     tempAcct = client2.get(0).getAccountNumber();
	     tempBal = client2.get(0).getAccountBalance();
	    
	     finaliD = Integer.toString(tempId);
	    //details.update();
	    //details.isApprovalStatus();
//	    String asps = Boolean.toString(details.isApprovalStatus());
//	    String finalBal = Float.toString(details.getAccountBalance());
//	    String finAcct = Integer.toString(details.getAccountNumber());
//	    
	     asps = Boolean.toString(details.isApprovalStatus());
	     finalBal = Float.toString(details.getAccountBalance());
	     finAcct = Integer.toString(details.getAccountNumber());
	    
	    Customer.client3.add(finaliD);
	    Customer.client3.add(client2.get(0).getcUserName());
	    Customer.client3.add(client2.get(0).getcPassword());
	    Customer.client3.add(client2.get(0).getFirstName());
	    Customer.client3.add(client2.get(0).getLastName());
	    Customer.client3.add(asps);
	    Customer.client3.add(finalBal);
	    Customer.client3.add(finAcct);
		}
		if(lvl == 2) {
			 tempId= client2.get(0).getCustomerID();
			 finaliD = Integer.toString(tempId);
			 asps = Boolean.toString(client2.get(0).isApprovalStatus());
		     finalBal = Float.toString(client2.get(0).getAccountBalance());
		     finAcct = Integer.toString(client2.get(0).getAccountNumber());
		    
		    Customer.client3.add(finaliD);
		    Customer.client3.add(client2.get(0).getcUserName());
		    Customer.client3.add(client2.get(0).getcPassword());
		    Customer.client3.add(client2.get(0).getFirstName());
		    Customer.client3.add(client2.get(0).getLastName());
		    Customer.client3.add(asps);
		    Customer.client3.add(finalBal);
		    Customer.client3.add(finAcct);
			
		}
		if(lvl == 3) {
		tempId= client2.get(0).getCustomerID();
		 finaliD = Integer.toString(tempId);
		 asps = Boolean.toString(client2.get(0).isApprovalStatus());
	     finalBal = Float.toString(client2.get(0).getAccountBalance());
	     finAcct = Integer.toString(client2.get(0).getAccountNumber());
	    
	    Customer.client3.set(6, finalBal);
	 
	  
		}
	    System.out.println("Customer ID = " + tempId + "\nUsername = " + tempUser + "\nFirst name = " + tempFirst + "\nLast name = " + tempLast + "\nAccount Number: " + finAcct + "\nAccount Balance: " + finalBal + "\n\n\n");
	   
	    details.update();
	 }
	 public void elogin(int eKey) {
		
		 
		 System.out.println("***************************");
			System.out.println("******EMPLOYEE LOGIN*******");
			System.out.println("***************************");
			System.out.println("\n\n");
			
			
			if(eKey == geteUserId()) {
				System.out.println("Please enter your Username?");
				 String user = emp1.info.nextLine();
				if(user.equals(eUser) == true) {
					System.out.println("Please enter your Password?");
						String ePass = emp1.info.nextLine();
						if(ePass.equals(ePassword) == true) {
							System.out.println("Employee login Successful");
							EntryLoog.info("Employee" + geteUserId() + "has logged in");
							 emp1.menuChoiceAccount(2);
						}// end of password check
						else {
							System.out.println("Password is incorrect");
							emp1.menuLevelOne();
						}// end of password else
				}// end of username check
					else {
						System.out.println("Username doesn't match id ");
					}// end of username else
				
					
			}// end of userid check
			else{
				System.out.println("UserID doesn't match");
			}
	
		 
	 } 
	
	
	 public boolean approval(Customer process) {
		// String admChoice = " ";
		 boolean cause = false;
		 
		// Account createC = new Account();
		 
		
		 
		 System.out.println("Account is Currently Pending"); 
		 System.out.println("\n\n Will you like to continue with approval of this account? Y/N");
		 String admChoice = scan.info.next();
		 
		 if(admChoice.equals("Y") || admChoice.equals("y")) {
			 int tempAct = generateAcct();
			 cause = true;
			  String finalCause = Boolean.toString(cause);
			  process.setApprovalStatus(cause);
			  process.setAccountBalance(500);
			  process.setAccountNumber(tempAct);

			 System.out.println("The account was Approved !! " + "Your new account number is "  + tempAct);
			 EntryLoog.info("Employee has Approved a new account");
			 displayInfo(process, 1);
			 return cause;
		 }
		 else if(admChoice.equals("N") || admChoice.equals("n")) {
			 System.out.println("The account was not approved");
			 cause = false;
			 return cause;
		 }
		 else {
			 System.out.println("invalid choice. Please try again");
			 return false;
		 }
	}
	 
	 public int employMenuExtend() {
		 int choice;
		 
		 System.out.println("5)approval");
		 System.out.println("6)cancel");
		 
		  choice = scan.info.nextInt();
		 
		return choice;
	 }

//	 public static void retrieveAccount () {
//		 Customer newAcct = new Customer();
//		 
//		 Employee l = new Employee();
//		 String filename = "./newCustomer.txt";
//		 
//		Object newC  = readObject(filename);
//		
//		System.out.println("new: " + newC);
//		
//		String newCust = newC.toString();
//
//		String custSplit[] = newCust.split(",");
//	
//		
//		for(int i = 0 ; i < custSplit.length ; i++) {
//			
//			System.out.println(custSplit[i]);
//			StringBuilder build = new StringBuilder(custSplit[i]);
//			build.deleteCharAt(0);
//			custSplit[i] = build.toString();
//		}
//		
//		//Parsing the String from the file for the ID;
//		//String y  = custSplit[0];
//		//StringBuilder build = new StringBuilder(y);
//		//build.deleteCharAt(0);
//		
//		String y = custSplit[0];
//		System.out.println(y);
//		int g =Integer.parseInt(y);
//		
//		StringBuilder buildNb = new StringBuilder(custSplit[5]);
//		buildNb.deleteCharAt(5);
//		String t = buildNb.toString();
//		System.out.println(t);
//		boolean reslt = Boolean.parseBoolean(t);
//		
//		newAcct.setCustomerID(g);
//		newAcct.setcUserName(custSplit[1]);
//		newAcct.setcPassword(custSplit[2]);
//		newAcct.setFirstName(custSplit[3]);
//		newAcct.setLastName(custSplit[4]);
//		newAcct.setApprovalStatus(reslt);
//	
//		//l.approval(newAcct);
//		
//		
//		 }
		public int generateAcct() {
			

    		Random genId = new Random();
        	
        	int cusId = genId.nextInt(((8000000-7000000)+ 1 ) + 7000000);
        	
        	//setID(cusId);
        	
        	System.out.println("Your new id is " + cusId);
        	
        	return cusId; 
	 }
		public static void writeObject1(String filename, Object obj) {
    		//String value[] = new String[6];
    		try(ObjectOutputStream goOut = new ObjectOutputStream(new FileOutputStream(filename))){
    			
//    			for(int i = 0 ; i < name.length; i++ ) {
//    			outStream.write
//    			(name[i]);
//    			}
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

}
