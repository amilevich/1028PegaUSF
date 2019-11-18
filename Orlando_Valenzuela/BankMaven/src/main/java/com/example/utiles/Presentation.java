package com.example.utiles;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.example.classes.Account;
import com.example.classes.Customer;
import com.example.classes.User;

public class Presentation {
	
	private Scanner sc;
	private User user;
	private Controller controller;
	private Logger loggy;
	
	public Presentation(Controller controller, Logger loggy, Scanner sc) {
		super();
		this.sc = sc;
		this.controller = controller;
		this.user = null;
		this.loggy = loggy;
	}
	
	public void mainPresentation() {
		
		loggy.info("inside Presentation mainPresentation");
		int ac, tu;
		User user = null;
		boolean control = true;
		
		do
		{ 			
            ac = mainMenu();
			
			switch(ac) {
			
				case 1:{  //Login

					user = loginMenu( );
					
				    if (user != null) {
					    if (user.getClass().getSimpleName().equals("Customer")) {
					    	tu = 1;
					    }
					    else {
					    	if (user.getClass().getSimpleName().equals("Employee"))
					    		tu = 2;
					    	else
					    		tu = 3;
					    }
				    }
				    else {
				    	tu = 5;
				    }

					 switch(tu) {
						 case 1:{//Customer
							 
							 customerAcction();
							 
							 break;
						 }
						 case 2:{//Employee
							 employeeAcction();
							 break;
						 }
						 case 3:{//Administrator
							 
							 adminAcction();
							 break;		 
						 }				 
					 }
					 
                    break;
				}
				
				case 2:{  //Register
					
                    registerCustomer();
							
					break;
				}
				
				case 3:{  //Exit
				 
					control = false;
					
					break;
				}
					
			}	
		}
		while(control);
	}	
	
	private int mainMenu() {
		
		loggy.info("inside Presentation mainMenu");
		
		System.out.println("Welcome to the Bank, what do you want to do.");
		System.out.println("1: Login.");
		System.out.println("2: Register Customer.");
		System.out.println("3: Exit.");
		System.out.println("Select an action: ");
		
		return validateOption(1, 3);	
	}
	
	private User loginMenu() {
		
		loggy.info("inside Presentation loginMenu");
		
		int oplm;
		boolean control = true;
		String username, passuser;
		
	    do
	    {
			System.out.println("Please enter: ");
			System.out.println("User: ");
			username = sc.nextLine();
			System.out.println("Password: ");
			passuser = sc.nextLine();
			
			user = controller.login(username, passuser);
			
			if (user == null) {
				System.out.println("Your credentials are not correct, "
						+ "\n1: Do you want try again : "
						+ "\n2: Exit: ");
				oplm = validateOption(1, 2);
				control = (oplm == 1)? true: false;		
			}
	    }
	    while (user == null && control); 

	
	    return user;   
	}
	
	
	private String[] readCredentiales() {
		    
		    loggy.info("inside readCredentiales");
		    String[] u = new String[2];
		
			System.out.println("Please enter: ");
			System.out.println("User: ");
			u[0] = sc.nextLine();
			
			System.out.println("Password: ");
			u[1] = sc.nextLine();
			
			return u;
			
	}
	
	private int customerMenu() {
		
		loggy.info("inside Presentation customerMenu");
		
		System.out.println("Welcome to the Bank.");
		System.out.println("1: Balance.");
		System.out.println("2: Withdraw.");
		System.out.println("3: Deposit.");
		System.out.println("4: Transfer.");
		System.out.println("5: Exit.");
		System.out.println("Select an action: ");
		
		return validateOption(1, 5);	
	}
	
	private  int employeeMenu() {
		
		loggy.info("inside Presentation employeeMenu");
		
		System.out.println("Welcome to the Bank.");
		System.out.println("1: Acept or Deny.");
		System.out.println("2: Balance.");
		System.out.println("3: Exit.");
		System.out.println("Select an action: ");
		
		return validateOption(1, 3);		
	}
	
	private int adminMenu() {
		
		loggy.info("inside Presentation adminMenu");
		
		System.out.println("Welcome to the Bank.");
		System.out.println("1: Acept or Deny.");
		System.out.println("2: Balance.");
		System.out.println("3: Withdraw.");
		System.out.println("4: Deposit.");
		System.out.println("5: Transfer.");
		System.out.println("6: Exit.");
		System.out.println("Select an action: ");
		
		return validateOption(1, 6);	
	}
	
	private int registerMenu() {
		
		loggy.info("inside Presentation registerMenu");
		
		System.out.println("What do you want to do: ");
		System.out.println("1: Register simple account.");
		System.out.println("2: Register join account.");
		System.out.println("3: Exit.");
		System.out.println("Select an action: ");

		return validateOption(1, 3);		
	}
	
	private void registerCustomer() {
		
		loggy.info("inside Presentation registerCustomer");
		int oprm;
		String saldo, account;
		double balance = 0 ;
		
		String user1[] = null, user2[] = null;
		ArrayList<Customer> cl = new ArrayList<>();
		
		oprm = registerMenu();
		
		if (oprm == 1) { //Simple account

			user1 = readCredentiales();	
		}
		else {//join account
			 
			user1 = readCredentiales();
			user2 = readCredentiales();						
		}
		
		System.out.println("Please enter your inicial balance: ");
		do 
		{	
			saldo = sc.nextLine();
			balance = Double.parseDouble(saldo);
			
			if (balance < 0) {
				
				System.out.println("Please the balance can not be negative, enter valid value: ");					
			}
			  
	    }
		while (balance < 0);
		
		if (oprm == 1) {
			cl.add(new Customer(user1[0], user1[1]));
		}
		else {
			cl.add(new Customer(user1[0], user1[1]));
			cl.add(new Customer(user2[0], user2[1]));
		}
			
		account = controller.createAccount(cl, balance);

		System.out.println("Your account was created successfully, this is your account number: " + account);
		
	}
	
    private void adminAcction() {
    	
    	loggy.info("inside Presentation adminAcction");
    	 
		 int opam, adc, nac, nop;
		 Account account;
		 Customer customer;
		 String read = null;
		 double deposit = 0, transfer = 0, withdraw = 0;
		 boolean control = true, controlAcceptDeny = true, controlSee = true, 
				 controlDeposit = true, controlTransfer = true, controlWithdraw = true;
		 ArrayList<Account> al;
		 ArrayList<Customer> cl;    	
    	
    	do 
    	{    	
			opam = adminMenu();
			
			switch(opam) {
				case 1:{//Acept or Deny
					
					 
					 do {
					
					   al = controller.accountPending();
					   
					   if (al.size() > 0) {
	
						 System.out.println("Hello " + user.getUserName()+ " these are the pending accounts:");
						
						 for(int i = 0; i < al.size(); i++) {
							 System.out.println(" " + (i+1) + ": Account number -" + al.get(i).getAccountNum() + " balance - " + al.get(i).getBalance());		 
						 }
						 
						 System.out.println("Please choose an account: ");
						 
						 nac = validateOption(1, al.size());
						 
						 System.out.println("What do you want to do : "
									+ "\n1: Apccet : "
									+ "\n2: Deny: ");
						 adc = validateOption(1, 2);
						 
						 if (adc == 1) {
							
							 account = al.get(nac-1);
							 al.remove(nac-1);
							 account.setPending(false);
							 controller.updateAccount(account);
							 System.out.println("The account was update successfully.");
								 
						 }
						 else {
							 
							 account = al.get(nac-1);
							 al.remove(nac-1);
							 controller.deleteAccount(account);
							 System.out.println("The account was delete successfully.");							 
						 } 
						 
						 System.out.println("Do you want to make another operation: "
									+ "\n1: Do you want : "
									+ "\n2: Exit: ");
						 nop = validateOption(1, 2);
						 controlAcceptDeny = (nop == 1)? true: false;						 
						 
					 }
					 else {
						 
						 System.out.println("There are not accounts Pendings:");
						 controlAcceptDeny = false;
					 }
					 
					   					   
				 }	 
				 while(controlAcceptDeny); 					
					
					break;
				}

				case 2:{//Balance
					
					 do {
					
					   cl = controller.viewCustomers();
						 
					   if (cl.size() > 0) {
	
						 System.out.println("Hello " + user.getUserName()+ " these are all customers:");
						
						 for(int i = 0; i < cl.size(); i++) {
							 System.out.println(" " + (i+1) + ": User: " + cl.get(i).getUserName() + " Account: " + cl.get(i).getAccountNum());		 
						 }
						 
						 System.out.println("Please choose a customer: ");
						 
						 nac = validateOption(1, cl.size());
						 
						 System.out.println(cl.get(nac));
						 
						 System.out.println("Do you want to see another customer: "
									+ "\n1: Do you want : "
									+ "\n2: Exit: ");
						 nop = validateOption(1, 2);
						 controlSee = (nop == 1)? true: false;						 		 
					 }
					 else {
						 
						 System.out.println("There are not Customers:");
						 controlSee = false;
					 }	   					   
				 }	 
				 while(controlSee); 
					
					break;
				}

				case 3:{//Withdraw
					
					 
					 do {
						    cl = controller.viewCustomers();
						    
						    if (cl.size() > 0) {
		
							 System.out.println("Hello " + user.getUserName()+ " these are all customers:");
							
							 for(int i = 0; i < cl.size(); i++) {
								 System.out.println(" " + (i+1) + ": User: " + cl.get(i).getUserName() + " Account: " + cl.get(i).getAccountNum());		 
							 }
							 
							 System.out.println("Please choose a customer: ");
							 
							 nac = validateOption(1, cl.size());
							 
							 System.out.println("Please quantity: ");
							 read = sc.nextLine();
							 withdraw = Double.parseDouble(read);
							 
							 if (withdraw > 0 && cl.get(nac -1).getAccount().getBalance()> withdraw) {
								 
								 controller.deposit(cl.get(nac -1).getAccountNum(), withdraw);
								 System.out.println("Your transaction was successful.");							 
							
							 }
						     else {
							 
							     System.out.println("Your quantity has to be positive or your balance is not enoght.");
						     }
						 
								 System.out.println("Do you want make other operation:"
									+ "\n1: Do you want : "
									+ "\n2: Exit: ");
								 nac = validateOption(1, 2);
								 controlWithdraw = (nac == 1)? true: false;	
						    }   
			
							 else {
								 
								 System.out.println("There are not Customers:");
								 controlWithdraw = false;
							 }	   					   
						 }	 
						 while(controlWithdraw);					
					
					break;
				}
				case 4:{//Deposit
					
					 
					 do {
						
						    cl = controller.viewCustomers();
							 
						    if (cl.size() > 0) {
		
							 System.out.println("Hello " + user.getUserName()+ " these are all customers:");
							
							 for(int i = 0; i < cl.size(); i++) {
								 System.out.println(" " + (i+1) + ": User: " + cl.get(i).getUserName() + " Account: " + cl.get(i).getAccountNum());		 
							 }
							 
							 System.out.println("Please choose a customer: ");
							 
							 nac = validateOption(1, cl.size());
							 
							 System.out.println("Please quantity: ");
							 read = sc.nextLine();
							 deposit = Double.parseDouble(read);
							 
							 if (deposit > 0) {
								 
								 controller.deposit(cl.get(nac -1).getAccountNum(), deposit);
								 System.out.println("Your transaction was successful.");							 
							
							 }
						     else {
							 
							     System.out.println("Your quantity has to be positive.");
						     }
						 
								 System.out.println("Do you want make other operation:"
									+ "\n1: Do you want : "
									+ "\n2: Exit: ");
								 nac = validateOption(1, 2);
						         controlDeposit = (nac == 1)? true: false;	
						    }   
			
							 else {
								 
								 System.out.println("There are not Customers:");
								 controlDeposit = false;
							 }	   					   
						 }	 
						 while(controlDeposit); 					
					
					break;
				}
				case 5:{//Transfer
					
					 
					 do {
						
						    cl = controller.viewCustomers();
							 
						    if (cl.size() > 0) {
		
							 System.out.println("Hello " + user.getUserName()+ " these are all customers:");
							
							 for(int i = 0; i < cl.size(); i++) {
								 System.out.println(" " + (i+1) + ": User: " + cl.get(i).getUserName() + " Account: " + cl.get(i).getAccountNum());		 
							 }
							 
							 System.out.println("Please choose a sender customer: ");
							 
							 nac = validateOption(1, cl.size());
							 
							 //----------------------------------------------------------
							 customer = cl.remove(nac - 1);
							 for(int i = 0; i < cl.size(); i++) {
								 System.out.println(" " + (i+1) + ": User: " + cl.get(i).getUserName() + " Account: " + cl.get(i).getAccountNum());		 
							 }
							 
							 System.out.println("Please choose a receiver customer: ");
							 
							 adc = validateOption(1, cl.size());							 
							 
							 System.out.println("Please quantity: ");
							 read = sc.nextLine();
							 transfer = Double.parseDouble(read);
							 
							 if (transfer > 0 && customer.getAccount().getBalance() > transfer) {
								 
								 controller.transferMoney(customer.getAccountNum(), cl.get(adc -1).getAccountNum() , transfer);
								 System.out.println("Your transaction was successful.");							 
							
							 }
						     else {
							 
							     System.out.println("Your quantity has to be positive or your balance is not enoght.");
						     }
						 
								 System.out.println("Do you want make other operation:"
									+ "\n1: Do you want : "
									+ "\n2: Exit: ");
								 nac = validateOption(1, 2);
								 controlTransfer = (nac == 1)? true: false;	
						    }   
			
							 else {
								 
								 System.out.println("There are not Customers:");
								 controlTransfer = false;
							 }	   					   
						 }	 
						 while(controlTransfer); 				
					
					
					break;
				}
				case 6:{//Exit
					control = false;
					break;
				}						 		 
			 }
    	}while(control);	
    } 
    
    private  void customerAcction() {
    	
    	 loggy.info("inside Presentation customerAcction");
    	 
		 int opcm, newop;
		 boolean control = true, controlwithdraw = true,
				 controldeposit = true, controltransfer = true;
		 double withdraw = 0, deposit = 0, transfer = 0;
		 String read = null, transferaccount = null;
		 
		 do 
		 {
			 opcm = customerMenu();
								 
			 switch(opcm) {
				 case 1:{//Balance
					 
					 System.out.println("Hello, " + user.getUserName() + 
							 " your balance is: " + ((Customer)user).getAccount().getBalance());
					 
					 System.out.println("Do you want to make another operation: "
								+ "\n1: Do you want : "
								+ "\n2: Exit: ");
					 newop = validateOption(1, 2);
					 control = (newop == 1)? true: false;	
					 
					 break;
				 }
				 case 2:{//Withdraw
					 do {	 
						 
						 System.out.println("Hello, " + user.getUserName() + 
								 " enter quatity you want withdraw: ");
						 read = sc.nextLine();
						 withdraw = Double.parseDouble(read);
						 
						 if (withdraw > ((Customer)user).getAccount().getBalance()) {
							 System.out.println("Your balance is not enoght for this transaction : "
										+ "\n1: Do you want try again : "
										+ "\n2: Exit: ");

							 newop = validateOption(1, 2);
							 control = (newop == 1)? true: false;
						 }
						 else {
							 controller.withDraw(((Customer)user).getAccountNum(), withdraw);
							 System.out.println("Your transaction was successful,"
							 		+ " \nDo you want make other operation: " 						 
								+ "\n1: Yes i want: "
								+ "\n2: Not Exit: ");

							 newop = validateOption(1, 2);
							 controlwithdraw = (newop == 1)? true: false;
						 }
						  						 
						 }
						 while(controlwithdraw);
					 
					 break;
				 }
				 case 3:{//Deposit
					 
					 do {	 
						 
						 System.out.println("Hello, " + ((Customer)user).getUserName() + 
								 " enter quatity you want deposit: ");
						 read = sc.nextLine();
						 deposit = Double.parseDouble(read);
						 
						 if (deposit > 0) {
							 
							 controller.deposit(((Customer)user).getAccountNum(), deposit);
							 System.out.println("Your transaction was successful.");							 
						
						 }
						 else {
							 
							 System.out.println("Your quantity has to be positive.");
						 }
						 
							 System.out.println("Do you want make other operation:"
								+ "\n1: Do you want : "
								+ "\n2: Exit: ");
					         newop = validateOption(1, 2);
					         controldeposit = (newop == 1)? true: false;						 
						  						 
						 }
						 while(controldeposit);					 
					 
					 break;
				 }
				 case 4:{//Transfer
					 do {	 
						 
							 System.out.println("Hello, " + ((Customer)user).getUserName() + 
									 " enter account number to transfer: ");
							 read = sc.nextLine();
							 transferaccount = read;
							 
							 System.out.println("enter quantity: ");
							 read = sc.nextLine();
							 transfer = Double.parseDouble(read);
							 
							 if (controller.existAccount(transferaccount) 
								 && ((Customer)user).getAccount().getBalance() > transfer) {
								 
								 controller.transferMoney(((Customer)user).getAccountNum(), transferaccount, transfer);
								 System.out.println("Your transaction was successful.");
					
 
							 }
							 else
							 {
								 System.out.println("The account no exist or your balance is not enoght for this transaction :");
							 
							 }
							    System.out.println("Do you want make other operation: "
								+ "\n1: Do you want try again : "
								+ "\n2: Exit: ");
					            newop = validateOption(1, 2);
					            controltransfer = (newop == 1)? true: false;
						  						 
						 }
						 while(controltransfer);						 
					 
					 break;
				 }
				 case 5:{//Exit
					 control = false;
					 break;
				 }	 			 
			 } 
			 
		 }while (control);
    }

    private void employeeAcction() {
    	
    	 loggy.info("inside Presentation employeeAcction");
    	 
		 int opem, adc, nac, nop;
		 Account account;
		 boolean control = true, controlAcceptDeny = true, controlSee = true;
		 ArrayList<Account> al;
		 ArrayList<Customer> cl;
		 
		 do 
		 {
			 opem = employeeMenu();
		 
			 switch(opem) {
			 
				 case 1:{//Accept or Deny
					 
					 al = controller.accountPending();
					 do {
						 
					   if (al.size() > 0) {
	
						 System.out.println("Hello " + user.getUserName()+ " these are the pending accounts:");
						
						 for(int i = 0; i < al.size(); i++) {
							 System.out.println(" " + (i+1) + ": Account number -" + al.get(i).getAccountNum() + " balance - " + al.get(i).getBalance());		 
						 }
						 
						 System.out.println("Please choose an account: ");
						 
						 nac = validateOption(1, al.size());
						 
						 System.out.println("What do you want to do : "
									+ "\n1: Apccet : "
									+ "\n2: Deny: ");
						 adc = validateOption(1, 2);
						 
						 if (adc == 1) {
							
							 account = al.get(nac-1);
							 al.remove(nac-1);
							 account.setPending(false);
							 controller.updateAccount(account);
							 System.out.println("The account was update successfully.");
								 
						 }
						 else {
							 
							 account = al.get(nac-1);
							 al.remove(nac-1);
							 controller.deleteAccount(account);
							 System.out.println("The account was delete successfully.");							 
						 } 
						 
						 System.out.println("Do you want to make another operation: "
									+ "\n1: Do you want : "
									+ "\n2: Exit: ");
						 nop = validateOption(1, 2);
						 controlAcceptDeny = (nop == 1)? true: false;						 
						 
					 }
					 else {
						 
						 System.out.println("There are not accounts Pendings:");
						 controlAcceptDeny = false;
					 }
					 
					   					   
				 }	 
				 while(controlAcceptDeny); 
					 
					 break;
				 }

				 case 2:{//Balance
	
			
								 cl = controller.viewCustomers();
								 do {
									 
								   if (cl.size() > 0) {
				
									 System.out.println("Hello " + user.getUserName()+ " these are all customers:");
									
									 for(int i = 0; i < cl.size(); i++) {
										 System.out.println(" " + (i+1) + ": User: " + cl.get(i).getUserName() + " Account: " + cl.get(i).getAccountNum());		 
									 }
									 
									 System.out.println("Please choose a customer: ");
									 
									 nac = validateOption(1, cl.size());
									 
									 System.out.println(cl.get(nac -1));
									 
									 System.out.println("Do you want to see another customer: "
												+ "\n1: Do you want : "
												+ "\n2: Exit: ");
									 nop = validateOption(1, 2);
									 controlSee = (nop == 1)? true: false;						 		 
								 }
								 else {
									 
									 System.out.println("There are not Customers:");
									 controlSee = false;
								 }	   					   
							 }	 
							 while(controlSee); 
									 
					 break;
				 }
				 case 3:{//Exit
					 
					 control = false;
					 break;					 
				 }	 		 
			 } 
			 
		 }while (control);
    }
	
    private  int validateOption(int begin, int end) {
    	
    	loggy.info("inside Presentation validateOption");
    	
    	int opaux;
    	String op;
    			
    	do {
		     op = sc.nextLine();
		     opaux = Integer.parseInt(op);
		     
		     if (opaux < begin || opaux > end) {
		      
		    	 System.out.println("Please choose a valid option: ");  
		    	 
		     }
		}
		while (opaux < begin || opaux > end);
    	
    	return opaux;    	
    } 	

}
