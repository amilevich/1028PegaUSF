package com.project.saintsbank;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.apache.log4j.Logger;



public class Customer implements Serializable {

	final static Logger EntryLoog = Logger.getLogger(Customer.class);
		/**
	 * 
	 */
	private static final long serialVersionUID = -6216412364353854526L;
		/**
	 * 	@author Marcus San Louis
	 *  @version Java 8
	 */
	

		private int CustomerID;
		private String cUserName;
		private String cPassword;
		private String firstName;
		private String lastName;
		private boolean approvalStatus;
		private int  AccountNumber;
		private String AccountType;
		private float  AccountBalance;
	
		
		SaintsBankMenu scan = new SaintsBankMenu();
		
		
		
		static List<String> client1 = new ArrayList<String>();
		static List<String> client3 = new ArrayList<String>();
		 static List<Customer> client2 = new ArrayList<Customer>();
		
	
		
		public int getCustomerID() {
			return CustomerID;
		}

		public void setCustomerID(int iD) {
			CustomerID = iD;
		}

		
		public String getcUserName() {
			return cUserName;
		}

		public void setcUserName(String cUserName) {
			this.cUserName = cUserName;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getcPassword() {
			return cPassword;
		}

		public void setcPassword(String cPassword) {
			this.cPassword = cPassword;
		}

		

	public int getAccountNumber() {
			return AccountNumber;
		}

		public void setAccountNumber(int accountNumber) {
			AccountNumber = accountNumber;
		}

		public String getAccountType() {
			return AccountType;
		}

		public void setAccountType(String accountType) {
			AccountType = accountType;
		}

		public float getAccountBalance() {
			return AccountBalance;
		}

		public void setAccountBalance(float value) {
			AccountBalance = AccountBalance + value;
		}

	public boolean isApprovalStatus() {
		if(approvalStatus == false) {
			System.out.println("ACCOUNT IS PENDING VERIFICATION");
			return approvalStatus;
		}
		else {
			System.out.println("ACCOUNT STATUS : APPROVED");
			return approvalStatus;
		}
		}

	public void setApprovalStatus(boolean approvalStatus) {
			
				this.approvalStatus = approvalStatus;
				
		}

	public Customer() {

		//this(getCustomerID()  ,theUser, thePass,dFirst, dlast);
		//super();
		int theId = getCustomerID();
		String theUser = getcUserName();
		String thePass = getcPassword();
		String dFirst = getFirstName();
		String dlast = getLastName();
	    
	
		
	//	this(theId,theUser, thePass,dFirst, dlast);
	}
		
  
    
    public Customer(int iD, String cUserName, String cPassword, String firstName, String lastName) {
		
		CustomerID = iD;
		this.cUserName = cUserName;
		this.cPassword = cPassword;
		this.firstName = firstName;
		this.lastName = lastName;
	}
    

	@Override
	public String toString() {
		String cUpdate;
		if(approvalStatus == false) {
			cUpdate = "ACCOUNT STATUS : PENDING VERFICATION";
	}
	else {
		cUpdate = "ACCOUNT STATUS : GOOD";
	}
			
	return " New Customer Account information \n CustomerID=" + CustomerID + "\n cUserName=" + cUserName 
	+ "\n firstName=" + firstName + "\n lastName=" + lastName + "\n" + cUpdate + "\nAccount number: " + AccountNumber + 
 	"\nAccount balance " + AccountBalance;
	}

	public void newAccountRegisterInfo(int count) {
    	 {	
    	Customer cust = new Customer();
    	
    	// String filename = "./newCustomer.txt";
    	
    	String newUser, nuFirst, nuLast;
    	int newId;
    	String tempPass;
    
    	beforeGoBack();
    	
    	System.out.println("Customer " + count + " Information");
    	System.out.println("Please enter your first name: \n");
    	  nuFirst = goBackMenu();
    	//nuFirst = scan.info.nextLine();
    	cust.setFirstName(nuFirst);
    	
    	 beforeGoBack();
    	 System.out.println("Please enter your last name: \n");
    	 nuLast = goBackMenu();
    	 cust.setLastName(nuLast);
    	 
    	 beforeGoBack();
    	 System.out.println("Please enter a new Username: \n");
    	  newUser = goBackMenu();
    	 cust.setcUserName(newUser);
    	  
    	 // Generates new pass word for the account
    	   tempPass = generatePass();
    	   	cust.setcPassword(tempPass);
    	 //persist data into a text file
    	 
    	   	//Generates new id for account
    	   newId = generateId();
    	   cust.setCustomerID(newId);
    	   cust.setApprovalStatus(false);
    	   cust.toString();
    	   
    	  
    	   
    	   String filename = "./newCustomer.txt";
    	       	   
    	   int savedIdInt = cust.getCustomerID();
    	   String savedID = Integer.toString(savedIdInt);
    	   
    	   boolean apsb = cust.isApprovalStatus();
    	   String apsbs = Boolean.toString(apsb);
    	   
    	  String saved[] = new String[6];
    	  
    	
    	 // client1.add(cust);
    	 
    	  client1.add(savedID);
    	  client1.add(cust.getcUserName());
    	  client1.add(cust.getcPassword());
    	  client1.add(cust.getFirstName());
    	  client1.add(cust.getLastName());
    	  client1.add(apsbs);
    	  
    	  //System.out.println(client1);
    	  EntryLoog.info("New Customer " + savedID + " has LOGGED OUT! ACCOUNT IS PENDING VERIFICATION");
    	 
    	 writeObject(filename, client1);
    	  
    	  // writeString(filename, cust.toString());
//    	   writeString(filename, apsbs);
//    	   writeString(filename, savedID);
//    	   writeString(filename, cust.getFirstName());
//    	   writeString(filename, cust.getLastName());
//    	   writeString(filename, cust.getcUserName());
//    	   writeString(filename, cust.getcPassword());
    	 // writeString(filename, apsbs);
//    
    	   
    	   
    	   
    	   if(count == 1) {
    	    jointAcct();
    	    
    	   }
    	   else {
    		  // client1.add(cust);
    		   cust.toString();
    		   System.out.println("Your account information is currently saved into the system");
    		   scan.menuLevelOne();
    	   }
    	   
    	   
    	   }
    	   
    	  }// end of registerAccount
        
    	   
    	  
    	public void update() {
    	//Customer ups = new Customer();
    		
    		//Employee.displayInfo(ups);
    	//System.out.println(client1.toString());
    	//System.out.println(client2.toString());
    	
	    	String filename = "./2Customer.txt";
	    	
	    	System.out.println(client3);
	    		
	    	writeObject(filename, client3);
	    	
	    	scan.menuChoiceAccount(1);
	    	
    	}
    
    
    	public int generateId() {
    		
    		Random genId = new Random();
        	
        	int cusId = genId.nextInt(500);
        	
        	//setID(cusId);
        	
        	System.out.println("Your new id is " + cusId);
        	
        	return cusId; 
    	}// end of generateId
    	
    	public String generatePass() {
    		String newCode = "12345", newCode2 = "785462 ";
    		boolean compCode;
    		
    		
    		  compCode = newCode.equals(newCode2);
        	  
        	 // System.out.println("Example " + compCode);
        	 
        	  while(compCode != true) {
        	  
        	 beforeGoBack();
        	 System.out.println("Please enter a new Password: \n");
        	 newCode = goBackMenu();
        	 //cust.setcPassword(newCode);
        	
        	 beforeGoBack();
        	 System.out.println("Please re-enter the Password: \n");
        	 newCode2 = goBackMenu();
        	 
        	 compCode = newCode.equals(newCode2);
        	 
        	 if(compCode == true) {
        		 System.out.println("Your password was successfully saved!!");
        		 return newCode;
        	 }
        	 
        	 else {
        		
        		 System.out.println("Your passwords did not match. Please try again!!");
        		// cust.setcPassword(newCode);
        		 //	generatePass();
        		 //return newCode;
        		 
        	 }// END of the password default else statement
    		
    	}// end of generatePass()
        	  
        
    /*
     * 
     *Username password
     *retrieve obj matching username 
     *
     */
        	 
			return newCode;
    	}
    	public void jointAcct() {
        	String jointOp = " ";
        	System.out.print("Would you like to add another user for this account?(Y/N)?");
        	jointOp = scan.info.nextLine();
        	
        	Customer addOne = new Customer();
        	
        	if(jointOp.equals("Y") || jointOp.equals("y")) {
        		addOne.newAccountRegisterInfo(2);
        		
        	}
        	else if(jointOp.equals("N") || jointOp.equals("n")) {
        	    System.out.println("You have declined to add another user!!");
        	    addOne.toString();
        	    System.out.println("Returning to the main menu....\n\n\n");
        	    scan.menuLevelOne();
        	   
        	}
        	
        	
        }
    	
    	public static void beforeGoBack() {
    		System.out.println("********************************************");
    		System.out.println("*TYPE ''END'' TO GO BACK TO THE MAIN MENU?**");
    		System.out.println("********************************************");
    		System.out.println("\n\n");
    	}
    	public String goBackMenu() {
    		String choice = " ";
    		
    		//System.out.println("or Type 'END' to go back to the Main Menu");
    		 choice = scan.info.nextLine();
    		
    		if(choice.equals("END") == true || choice.equals("end") == true) {
    			System.out.println("Going back to main menu!!\n\n\n");
    			scan.menuLevelOne();
    			return " ";
    		}
    		else {
    			return choice;
    		}
    		
    	}// End of goBackMenu
    	public static void writeObject(String filename, Object obj) {
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
    	
    	public static Object readObject(String filename) {
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
    	public void customerLogin(int idKey) {
    		int count = 2;
    		
    		if (count == 1) {
    		 retrieveAccount("./newCustomer.txt", 1);
    		}
    		//System.out.println("Plus " + idKey);
    		else if (count == 2) {
    		
    		retrieveAccount("./2Customer.txt", 2);
    		}
    		
    		String user;
    		String pass;
    		System.out.println("***************************");
			System.out.println("******CUSTOMER LOGIN*******");
			System.out.println("***************************");
			System.out.println("\n\n");
			
			//System.out.println(client2.get(0).getCustomerID());
			
			if(idKey == client2.get(0).getCustomerID()) {
			
		    System.out.println("Please enter your Username?");
		    user = scan.info.nextLine();
		         
		    	if(user.equals(client2.get(0).getcUserName())){
		    		System.out.println("Please enter your password?");
		    		  pass = scan.info.nextLine();
		    		  
		    		  if(pass.equals(client2.get(0).getcPassword())) {
		    			  System.out.println("Login successful");
		    			  EntryLoog.info("Customer " + client2.get(0).getCustomerID() + "has login into their account");
		    			  
		    			  	if(client2.get(0).isApprovalStatus()== true) {
		    			  		scan.menuChoiceAccount(1);
		    			  	}
		    			  	else {
		    			  	   System.out.println("Please wait until the account is approved");
		    			  	   System.out.println("***********RETURNING TO THE MAIN MENU********");
		    			  	   scan.menuLevelOne();
		    			  	}
		    		  }
		    		  else {
		    			  System.out.println("unable to log in");
		    			  System.out.println("***********RETURNING TO THE MAIN MENU********");
		    			  scan.menuLevelOne();
		    		  }
		    	}
		    	else {
		    		System.out.println("Username doesn't match Id");
		    		System.out.println("***********RETURNING TO THE MAIN MENU********");
		    		scan.menuLevelOne();
		    	}
			}
		   
		   //System.out.println("Please enter your password?");
		     //String code = scan.info.nextLine();
		     
		     else {
		      System.out.println("User does not exist");
		    }
		    
    	}
    	 public static void retrieveAccount (String filename, int count) {
    		 Customer newAcct = new Customer();
    		 
    		 boolean reslt = false;
    		 float bala;
    		 int acnt;
    		 int g; 
    		 
    		Object newC  = readObject(filename);
    		
    		//System.out.println("new: " + newC);
    		

    		
    		String newCust = newC.toString();
    		
    		System.out.println(newCust);

    		String custSplit[] = newCust.split(",");
    	
    		
    		for(int i = 0 ; i < custSplit.length ; i++) {
    			
    			System.out.println(custSplit[i]);
    			StringBuilder build = new StringBuilder(custSplit[i]);
    			build.deleteCharAt(0);
    			custSplit[i] = build.toString();
    			break;
    		}
    		
    	
    		String y = custSplit[0];
    		StringBuilder remove = new StringBuilder(y);
    		//remove.deleteCharAt(2);
    		y = remove.toString();
    		System.out.println(y);
    		 g = Integer.parseInt(y);
    		
    		if (count == 1) {
    		StringBuilder buildNb = new StringBuilder(custSplit[5]);
    		buildNb.deleteCharAt(5);
    		String t = buildNb.toString();
    		 reslt = Boolean.parseBoolean(t);
    		}
    		
    		
    		
    		else if(count == 2) {
    			 reslt = Boolean.parseBoolean(custSplit[5]);
    			StringBuilder t = new StringBuilder(custSplit[7]);
    			t.deleteCharAt(6);
    			//t.deleteCharAt(0);
    			String tempAcct = t.toString();
    			bala = Float.parseFloat(custSplit[6]);
    		    acnt = Integer.parseInt(tempAcct);
    			newAcct.setAccountNumber(acnt);
    			newAcct.setAccountBalance(bala);	
    		}
    		
    		
    		newAcct.setCustomerID(g);
    		newAcct.setcUserName(custSplit[1]);
    		newAcct.setcPassword(custSplit[2]);
    		newAcct.setFirstName(custSplit[3]);
    		newAcct.setLastName(custSplit[4]);
    		//newAcct.setAccountNumber(acnt);
    		//newAcct.setAccountBalance(0);
    		newAcct.setApprovalStatus(reslt);
    		
    		client2.add(0, newAcct);
    		
    		System.out.println(client2);
    		
    		//menuChoiceAccount();
    		
    		
    		 }
}// End of Customer Class
    	
