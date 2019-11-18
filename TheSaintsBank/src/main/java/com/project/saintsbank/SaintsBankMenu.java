package com.project.saintsbank;

import java.util.Scanner;

import org.apache.log4j.Logger;




public class SaintsBankMenu {
	
	final static Logger EntryLoog = Logger.getLogger(SaintsBankMenu.class);
	
	Scanner info = new Scanner(System.in);

	public static void main(String[] args) {
		
	
		
		SaintsBankMenu go = new SaintsBankMenu();
		//go.menuChoiceAccount(2);
		go.menuLevelOne();
	}
	
	public void menuLevelOne() {
		int choice;
	

	System.out.println("***************************");
	System.out.println("***************************");
	System.out.println("**  WELCOME TO           **");
	System.out.println("**     THE SAINTS        **");
	System.out.println("**        BANKING SYSTEM **");
	System.out.println("**                       **");
    System.out.println("***************************");    
    System.out.println("***************************");    

	System.out.println("Choose one the following:");
	System.out.println("1.Customer");
	System.out.println("2.Employee");
	System.out.println("3.Apply for New Account");
	System.out.println("4.Exit");
	
	
	//Scanner info1 = new Scanner(System.in);
	choice = info.nextInt();
	
	if(choice == 1) {
		
		loginInput(1);
		
		 //return choice;
	}
	else if(choice == 2){

		menuLevelTwo(choice);
	
	}
	else if(choice == 3) {
		Customer client3 = new Customer();
		client3.newAccountRegisterInfo(1);
		
	}
	else if(choice == 4) {
		exit();
	}
	
	else
		invalidC();
		

	
}
	public int menuLevelTwo(int option) {
		
		System.out.println("Select one of the options below");
		System.out.println("1)Employee");
		System.out.println("2)Admin");
		System.out.println("3)Go back to the previous page..");
		option = info.nextInt();
		
		if(option == 1) {
			loginInput(2);
			return option;
		}
		else if(option == 2) {
			loginInput(4);
			return option;
		}
		else if(option == 3) {
			menuLevelOne();
			return option;
		}
		else {
			
			invalidC();
			menuLevelTwo(0);
			return 0;
		}
	}
	public int menuChoiceAccount(int mode) {
		 int acctChoice1 = 0;
		 
		 Employee blue = new Employee();
		 Account changeA = new Account();
		 Customer send = new Customer();
		
		 System.out.println("********************************");
		 System.out.println("Choose one of the Following:");
		 System.out.println("1.Deposit");
		 System.out.println("2.Withdraw");
		 System.out.println("3.transfer");
		 System.out.println("4.View balance");
		 System.out.println("7.Exit");
		 if(mode == 2) {
		  acctChoice1 = blue.employMenuExtend();
		 }
		 else {
			acctChoice1 = info.nextInt();
		 }
		 
//		 Scanner info2 = new Scanner(System.in);
//		 acctChoice1 = info2.nextInt();
//	
			
		switch(acctChoice1){
			case 1: 
				 System.out.println("Ready for Deposit");
				 changeA.deposit();
				 break;
			case 2:
				 System.out.println("Ready for withdraw");
				 changeA.withdraw();
				 break;
			case 3: 
				System.out.println("Ready for transfer");
				break;
			case 4:
				System.out.println("Ready for to view balance");
				//Customer.retrieveAccount("./2Customer.txt", 2);
				Employee.displayInfo(send, 2);
				menuChoiceAccount(1);
				break;
			case 5:
				System.out.println("Ready to approve account");
				Customer.retrieveAccount("./newCustomer.txt", 1);
				blue.approval(blue);
				break;
			case 6:
				System.out.println("Ready for cancel account");
				break;
			case 7:
				exit();
				break;
			
			}
			
				
			//}
			//case 2:
				
		return acctChoice1;
	}

	public void loginInput(int ckey) {
		int tempid;
		String user;
		String code;
		System.out.println("Please enter your id");
		EntryLoog.info("Id input Attempt");
		tempid = info.nextInt();
		
		//TODO if statement to see if customer account in pending
		//else output account in pending status
		
		if(ckey == 1) {
			Customer cLogin = new Customer();
			cLogin.customerLogin(tempid);
			EntryLoog.info("Customer Attemping to log in");
		}
		
		else if(ckey == 2) {
			Employee elogin = new Employee();
			elogin.elogin(tempid);
			EntryLoog.info("Employee Attemping to log in");
			}
		
		else if(ckey == 4) {
			System.out.println("***************************");
			System.out.println("******ADMIN LOGIN**********");
			System.out.println("***************************");
			System.out.println("\n\n");
	
			System.out.println("Please enter your Username?");
			user = info.nextLine();
			
			if(user != " ") {
			System.out.println("Please enter your password?");
			code = info.nextLine();
			}
			else
				invalidC();
			}
		
		else {
			invalidC();
			loginInput(0);
		}
		
		
	}
	public void invalidC() {
		System.out.println("Invalid Choice. Please select again");
	}
	
	public void exit() {
		System.out.println("******************************************************");
		System.out.println("THANK YOU FOR USING THE SAINTS BANK APPLICATION SYSTEM");
		System.out.println("******************************************************");
		
		System.exit(0);
	}

}
	