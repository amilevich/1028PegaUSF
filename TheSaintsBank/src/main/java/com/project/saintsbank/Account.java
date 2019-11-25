package com.project.saintsbank;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.project.saintsdao.SaintsBankCImp;

public class Account {
	/**@author Lomar Stlouis
	 * @category Account
	 
	 */
	final static Logger EntryLoog = Logger.getLogger(Account.class);
	
	//Account jump = new Account();
	
	private int  AccountNumber;
	private String AccountType;
	private float  AccountBalance;
	public float  DepositAmount;
	public float  WithdrawAmount;
	public float  TransferAmount;
	
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

	
	
	Scanner numinfo = new Scanner(System.in);
	 DecimalFormat df = new DecimalFormat("$###,###,##0.00");
	 
	 SaintsBankMenu menu1 = new SaintsBankMenu();
	 
	// Customer updateinfo = new Customer();
	

//	@Override
//	public String toString() {
//		return "Account [AccountNumber=" + AccountNumber + ", AccountBalance=" + df.format(AccountBalance) + "]";
//	}

	public Account() {
	
	
	
	
	}
	//First layer menu to determine Customer or Employee
	
	public boolean verifyNegative(String name , float value) {
	  
		if (value > 0 ) {
			
			System.out.println(name + " of " + df.format(value)  + " successfully");
			return true;
		}
//		else if (value < 0) {
//			
//			System.out.println("Unable to make a " + name + " for the amount of " + value + "due to insuuficent funds");
//			//return false;
//			
//		
//			return false;
//		}
		
		else {
			System.out.println("System unable to read value correctly!!");
			return false;
		}
		
	}
	 public void deposit(int CustId) {
		 float value;
		 boolean depResult;
		 
		 Account depC = new Account();
		 
		 SaintsBankCImp depPull = new SaintsBankCImp();
		 
		 if(CustId < 500) {
		 
		  depC = depPull.findAcctById(CustId);
		 }
		 else if(CustId > 1000) {
			int value2;
			 System.out.println("ENTER THE USER ID YOU WISH TO MANAGE: ");
			 value2 = numinfo.nextInt();
			 
			 depC = depPull.findAcctById(value2);
		 }
		 else {
		    	System.out.println("SORRY,YOU DO NOT HAVE ACCESS TO THIS FEATURE!!!");
		    	menu1.menuChoiceAccount(2, CustId);
		    	
		    }
		 
		 System.out.println("\n\n******************DEPOSIT MENU*************************\n\n");
		 System.out.println("\n\n******************"+depC.getAccountNumber()+"**********\n\n");
		 System.out.println("Please enter the amount you wish to deposit into your account: ");
		 System.out.println("Format: $__.__");
		 
		 value = numinfo.nextFloat();
		 
		  depResult = verifyNegative("Deposit", value);
		  
		  if(depResult == true) {
		  System.out.println("You have successfully added " + df.format(value) + " to your balance" );
		  depC.setAccountBalance(value);
		  depPull.UpdateBalance(CustId, depC.getAccountBalance());
		  
		  }
		  else {
			  System.out.println("Please Try again");
			  deposit(CustId);
		  }
		  
		// returns to the menu at level 1
		  // Different set of menus based on logged in user
		  if(CustId > 1000) {
			  	EntryLoog.info("Admin " + CustId + "DEPOSITED " + df.format(value) + " INTO " +  "ACCOUNT " + depC.getAccountNumber());
				 menu1.menuChoiceAccount(3, CustId);
			 }
			 else if (CustId < 500) {
				 menu1.menuChoiceAccount(1, CustId);
			 }
	 }
	 ///Withdrawn
	 public void withdraw (int CustId) {
		 
        SaintsBankCImp witPull = new SaintsBankCImp();
		 
		 Account witC = new Account();
		 
		 if(CustId < 500) {
		          witC= witPull.findAcctById(CustId);
		 }
		 else if(CustId > 1000) {
				int value2;
				 System.out.println("ENTER THE USER ID YOU WISH TO MANAGE: ");
				 value2 = numinfo.nextInt();
				 witC = witPull.findAcctById(value2);
			 }
		 else {
		    	System.out.println("SORRY,YOU DO NOT HAVE ACCESS TO THIS FEATURE!!!");
		    	menu1.menuChoiceAccount(2, CustId);
		    	
		    }
		 float payout = 0;
		 
		 System.out.println("\n\n******************WITHDRAW MENU*************************\n\n");
		 System.out.println("Please enter the amount you wish to withdraw into your account: ");
		 System.out.println("Format: $__.__");
		 
		  payout = numinfo.nextFloat();
		 
		 if(witC.getAccountBalance() > payout) {

		 System.out.println("YOU SUCCESSFULLY WITHDRAWN " + payout + " FROM YOUR BALANCE");
		 witC.setAccountBalance(-payout);
		 witPull.UpdateBalance(CustId, witC.getAccountBalance());
		 
		 }
		 else{
			 System.out.println("*****WITHDRAW AMOUNT DECLINED, DUE TO INSUFFICENT FUNDS*****");
			 //return 0;
		 }
		 
		 if(CustId > 1000) {
			 EntryLoog.info("Admin " + CustId + "WITHDRAWN" + df.format(payout) + " INTO " +  "ACCOUNT " + witC.getAccountNumber());
			 menu1.menuChoiceAccount(3, CustId);
		 }
		 else if (CustId < 500) {
			 menu1.menuChoiceAccount(1, CustId);
		 }
	 
	 } 
	 
	// Viewing the Balance for the Customer based on id 
	public void viewBalance(int cus) {;
	
		SaintsBankCImp viewb = new SaintsBankCImp();
		
		Account viewA = new Account();
		Customer ViewC = new Customer();
		
		 if(cus < 500) {
			 viewA = viewb.findAcctById(cus);
			 ViewC = viewb.findByCustomerId(cus, 1);
	      }
	    else if(cus > 500) {
			int value2;
			 System.out.println("ENTER THE USER ID YOU WISH TO MANAGE: ");
			 value2 = numinfo.nextInt();
			 viewA = viewb.findAcctById(value2);
			 ViewC = viewb.findByCustomerId(value2, 1);
	       }
		
		 viewA = viewb.findAcctById(cus);
		 ViewC = viewb.findByCustomerId(cus, 1);
		
		System.out.println("*************ACCOUNT BALANCE INFORMATION****************************");
		System.out.println("*-----------ACCOUNT NUMBER " + viewA.AccountNumber + "-------------*");
		System.out.println("*    CUSTOMER " + ViewC.getFirstName() +" "+ ViewC.getLastName() +"*");
		System.out.print("\n*THE ACCOUNT BALANCE FOR ACCOUNT " + viewA.AccountNumber + " :     *");
		System.out.print(df.format(viewA.getAccountBalance()));
		System.out.print("\n");
		System.out.println("*********************************************************************");
		viewA.getAccountNumber();
		
		 if(cus > 500) {
			 EntryLoog.info("Admin " + cus +  " VIEW BALANCE OF" +  "ACCOUNT " + viewA.getAccountNumber());
			 menu1.menuChoiceAccount(3, cus);
		 }
		 else if (cus < 500) {
			 menu1.menuChoiceAccount(1, cus);
		 }
		
     	}
	
	// transfer a set  amount of money from one account to the next
	public void transferBalance(int cusr) {
		float transMount;
		int optionId;
      
		SaintsBankCImp tranb = new SaintsBankCImp();
		
		Account tranA = new Account();
		Account tranZ = new Account();
		Customer ViewC = new Customer();
	
     if(cusr < 500) {
	          tranA= tranb.findAcctById(cusr);
	 }
	 else if(cusr > 1000) {
			int value2;
			 System.out.println("ENTER THE USER ID YOU WISH TO MANAGE: ");
			 value2 = numinfo.nextInt();
			 tranA = tranb.findAcctById(value2);
		 }
	 else {
	    	System.out.println("SORRY,YOU DO NOT HAVE ACCESS TO THIS FEATURE!!!");
	    	menu1.menuChoiceAccount(2, cusr);
	 }
		 
		 System.out.println("\n\n******************WITHDRAW MENU*************************\n\n");
		 System.out.println("Please enter the account you wish to transfer to: ");
		 optionId = menu1.info.nextInt();
		 tranZ = tranb.findAcctById(optionId);
		 
		 
		 System.out.println("Please enter the amount you wish to transfer into ACCOUNT "+ tranZ.getAccountNumber() + " : ");
		 System.out.println("(Format:$__.__)");
		  transMount = numinfo.nextFloat();
		  
		  if(tranA.getAccountBalance() > transMount) {
			  	// Stores the account new account balance for Customer1
		    	tranA.setAccountBalance(-transMount);
			 tranb.UpdateBalance(cusr, tranA.getAccountBalance()); 
			 
			 //Stores new account balnce for customer 2
			  tranZ.setAccountBalance(transMount);
			  tranb.UpdateBalance(optionId, tranZ.getAccountBalance());
			  System.out.println("YOU SUCCESSFULLY TRANSFERRED " + df.format(transMount) + " FROM YOUR BALANCE To ACCOUNT " + tranZ.getAccountNumber());
		  }
		  else {
			  System.out.println("*****TRANSFER AMOUNT DECLINED, DUE TO INSUFFICENT FUNDS*****"); 
		  }
		  
		  if(cusr > 1000) {
				 EntryLoog.info("Admin " + cusr + "WITHDRAWN" + df.format(transMount) + " INTO " +  "ACCOUNT " + tranA.getAccountNumber());
				 menu1.menuChoiceAccount(3, cusr);
			 }
			else if (cusr < 500) {
				 menu1.menuChoiceAccount(1, cusr);
			 }
}
}