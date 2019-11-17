package com.bank.model;

import java.util.Scanner;

import com.bank.ui.BankMenu;

public class Employee {

	Scanner sc = new Scanner(System.in);
	
	NewCustomer newCustomer = new NewCustomer();

//	public void readNewUserFile() throws FileNotFoundException {
//		String fileName = "C:/Users/prate/Documents/My_Git_Repos/1028PegaUSF/David_Prater_Code/BankApplication/NewCustomerList.txt";
//		FileInputStream newCustomerInputStream = new FileInputStream(fileName);
//
//		boolean cont = true;
//		try{
//		   ObjectInputStream input = new ObjectInputStream(newCustomerInputStream);
//		   while(cont){
//		      Person newCustomer = (Person) input.readObject();
//		      if(newCustomer != null)
//		         newCustomerList.add(newCustomer);
//		      else
//		         cont = false;
//		   }
//		}catch(Exception e){
//		   //System.out.println(e.printStackTrace());
//		}
//	}
	
	public void approveNewCustomer() {

		
		for(Person newCustomer :  NewCustomer.newCustomerList) {
			System.out.println("Press 'y' to approve account and 'n' to deny the account.");
			String choice = sc.next();
			
			if(choice == "y") {
				BankMenu.customerList.add(newCustomer);
			} else if (choice == "n") {
				System.out.println("Denied");
			} else {
				approveNewCustomer();
			}
			
			String output = newCustomer.toString();
			System.out.println(output);
		}
		NewCustomer.newCustomerList.removeAll(NewCustomer.newCustomerList);
	}
	
}
