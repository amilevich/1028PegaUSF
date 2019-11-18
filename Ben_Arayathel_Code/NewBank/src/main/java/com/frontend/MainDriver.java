package com.frontend;


import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;

import java.io.*;

import com.backend.AccountManagement;
import com.users.BankAdmin;
import com.users.Customer;
import com.users.Employee;

public class MainDriver {
	//prompts the user to stay on their current menu
	public static boolean keepinteracting(Scanner in, String account) {
		System.out.println("Do you want to carry on with " + account + " login menu?(yes or no)");
		String input = in.next();
		if(input.equals("yes")) {
			return true;
		}else if(input.equals("no")) {
			return false;
		}else {
			System.out.println("That is not a vaild input, you'll be taken out of the " + account + "menu");
			return false;
		}
	}
	//Introductory menu 
	public static void introductoryMenu() {
		System.out.println("\t" + "Hello, Welcome to our lovely Bank.");
		System.out.println("Remember to have an employee in training to be a pega trainee by your side.");
		System.out.println("Let's get the legal stuff out of the way.");
		System.out.println("We will not be legally elligibale for any damages caused, also for any money lost (we have no insurance either)." + "\n");
	}
	
	//Instantiating new scanner object, used for all user interactions
	public static Scanner in = new Scanner(System.in);
	final static Logger loggy = Logger.getLogger(MainDriver.class);
	
	public static void deserialiseSomeStuff() {
		
		 try
	      {
	         FileInputStream fis = new FileInputStream("hashmap.ser");
	         ObjectInputStream ois = new ObjectInputStream(fis);
	         AccountManagement.storageAccount = (Map) ois.readObject();
	         ois.close();
	         fis.close();
	      }catch(IOException ioe)
	      {
	         ioe.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Class not found");
	         c.printStackTrace();
	         return;
	      }
	      System.out.println("Deserialized HashMap..");
	      // Display content using Iterator
	      Set set = AccountManagement.storageAccount.entrySet();
	      Iterator iterator = set.iterator();
	      while(iterator.hasNext()) {
	         Map.Entry mentry = (Map.Entry)iterator.next();
	         System.out.print("key: "+ mentry.getKey() + " & Value: ");
	         System.out.println(mentry.getValue());
	      }

		
	}
	
	public static void serialiseSomeStuff() {
		try
		{
			FileOutputStream fos =
					new FileOutputStream("hashmap.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(AccountManagement.storageAccount);
			oos.close();
			fos.close();
			System.out.printf("Serialized HashMap data is saved in hashmap.ser");
		}catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		//Deserialize placeholder
		deserialiseSomeStuff();
		
		boolean interacting = true;
		introductoryMenu();
		do{
			loggy.info("User logged in.");
			System.out.println("Input 0,1,2, depending on whether you're a customer,employee or bank admin"); //Giving user the options for which menu they'd like
			try {
				int input = in.nextInt(); 
				in.nextLine();
				switch(input) {	
				case 0:
					Customer.access(in);  //Accesses the customer menu
					break;
				case 1:
					Employee.employeeLogin(in); //Accesses the employee login
					break;
				case 2:
					BankAdmin.employeeLogin(in); //Access the bank admin login
					break;
			}
			interacting = keepinteracting(in, "bank"); 
			}catch(InputMismatchException e) {
				e.printStackTrace();
				System.out.println("\n" + "Invalid input, try to follow the (VERY) easy instructions next time." + 
				"You've been returned to the main menu" + "\n");
				in.nextLine();
			}
		}while(interacting);

		serialiseSomeStuff();
			
		System.out.println("Thank you for using our esquisitley designed menu");
	}
}
