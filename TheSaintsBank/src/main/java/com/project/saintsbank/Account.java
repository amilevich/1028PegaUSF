package com.project.saintsbank;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Account {
	/**@author Lomar Stlouis
	 * @category Account
	 
	 */
	final static Logger EntryLoog = Logger.getLogger(Account.class);
	
	
	public float  DepositAmount;
	public float  WithdrawAmount;
	public float  TransferAmount;
	
	Scanner numinfo = new Scanner(System.in);
	 DecimalFormat df = new DecimalFormat("$###,###,##0.00");
	 
	 SaintsBankMenu menu1 = new SaintsBankMenu();
	 
	 Customer updateinfo = new Customer();
	

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
	 public void deposit() {
		 float value;
		 boolean depResult;
		 
		 //Account dep = new Account();
		 
		 
		 System.out.println("\n\n******************DEPOSIT MENU*************************\n\n");
		 System.out.println("Please enter the amount you wish to deposit into your account: ");
		 System.out.println("Format: $__.__");
		 
		 value = numinfo.nextFloat();
		 
		  depResult = verifyNegative("Deposit", value);
		  
		  if(depResult == true) {
		  System.out.println("You have successfully added " + df.format(value) + " to your balance" );
		  Customer.client2.get(0).setAccountBalance(value);
		  Employee.displayInfo(updateinfo, 3);
		  menu1.menuChoiceAccount(1);
		  }
		  else {
			  System.out.println("Please Try again");
			  deposit();
		  }
		  
		// return this.AccountBalance = value + this.AccountBalance;
		 
	 }
	 public void withdraw () {
		 float payout = 0;
		 
		 System.out.println("\n\n******************WITHDRAW MENU*************************\n\n");
		 System.out.println("Please enter the amount you wish to withdraw into your account: ");
		 System.out.println("Format: $__.__");
		 
		  payout = numinfo.nextFloat();
		 
		 if(Customer.client2.get(0).getAccountBalance() > payout) {
		 
		 System.out.println("YOU SUCCESSFULLY WITHDRAWN " + payout + " FROM YOUR BALANCE" );
		 Customer.client2.get(0).setAccountBalance(-payout);
		 menu1.menuChoiceAccount(1);
		 // return 0;
		 }
		 else {
			 System.out.println("*****WITHDRAW AMOUNT DECLINED, DUE TO INSUFFICENT FUNDS*****");
			 menu1.menuChoiceAccount(1);
			 //return 0;
		 }
		
		 
	 }
	
//	public void viewBalance() {
//		Account vb = new Account();
//		
//		//float balance = vb.getAccountBalance();
//		//System.out.println("Your balance for your account is " + balance);
//	}
	}

