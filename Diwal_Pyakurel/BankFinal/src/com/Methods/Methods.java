package com.Methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.accounts.Accounts;
import com.profiles.Customers;

public class Methods implements Serializable {
	static Scanner sc = new Scanner(System.in);

	public static String startApplication() {
		System.out.println("Customer or Employee or Admin or Exit");

		String userStatus = sc.nextLine();
		userStatus = userStatus.toLowerCase();

		if (userStatus.equals("customer")) {
			System.out.println("Hi Welcome to customer login");
		} else if (userStatus.equals("employee")) {
			System.out.println("Hi Welcome to Employee login");
		} else if (userStatus.equals("admin")) {
			System.out.println("Hi Welcome to Admin login");
		} else {
			System.out.println("Please provide a valid data");
			startApplication();
		}

		return userStatus;

	}

	public static String askifNew() {
		System.out.println("Please provid a response");
		System.out.println("Type New: I want to open a NEW account");
		System.out.println("Type Existing: I want to use my EXISTING account");
		String newOrOld = sc.nextLine();
		newOrOld = newOrOld.toLowerCase();

		if (newOrOld.equals("new")) {
			System.out.println("Sure,We can open a new account");
		} else if (newOrOld.equals("existing")) {
			System.out.println("Sure, we Can check your existing account");
		} else {
			Methods.askifNew();
		}
		return newOrOld;
	}

	public static void openAccount() {

		System.out.println("Will this be a joint account? Type YES or NO");
		String singleOrJoint = sc.nextLine();
		singleOrJoint.toLowerCase();

		System.out.println("Please provide me your first name");
		String firstName = sc.nextLine();
		System.out.println("Please provide me your second name");
		String secondName = sc.nextLine();
		System.out.println("Please provide me your user name");
		String userName = sc.nextLine();
		System.out.println("Please create a password");
		String password = sc.nextLine();
		System.out.println("Please provide me your social");
		int social = sc.nextInt();
		sc.nextLine();

		if (singleOrJoint.equals("yes")) {
			System.out.println("Please provide the second user full name");
			String secondUserFullname = sc.nextLine();
			System.out.println("Please provide the social of second user");
			int secondUserSocial = sc.nextInt();

			Customers customer = new Customers(userName, password, firstName, secondName, social, true,
					secondUserFullname, secondUserSocial);
			System.out.println(customer.toString());
			writeObject(customer, "pending.ser");

		} else {
			Customers customer = new Customers(userName, password, firstName, secondName, social, false);
			System.out.println(customer.toString());
			writeObject(customer, "pending.ser");
		}

	}
	
	

	public static void writeObject(Customers customer, String fileName) {
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		ArrayList<Customers> customerArray = readObject("pending.ser");
		customerArray.add(customer);

		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(customerArray);
			oos.close();
			fos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
	
	
	

	@SuppressWarnings("unchecked")
	public static ArrayList<Customers> readObject(String fileName) {
		ArrayList<Customers> customerArray = new ArrayList<>();
		
		FileInputStream fis = null;
		ObjectInputStream oin = null;
		try {
			fis = new FileInputStream(fileName);
			oin = new ObjectInputStream(fis);

			if (fis.available() != 0) {
				customerArray = (ArrayList<Customers>) oin.readObject();
				oin.close();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return customerArray;
	}
	
	
	public static void writeAccounts(Accounts accounts) {
		String fileName = "accounts.ser";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		ArrayList<Accounts> accountsArray = readAccounts();
		accountsArray.add(accounts);

		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(accountsArray);
			oos.close();
			fos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Accounts> readAccounts() {
		ArrayList<Accounts> accountsArray = new ArrayList<>();
		String fileName = "accounts.ser";
		FileInputStream fis = null;
		ObjectInputStream oin = null;
		try {
			fis = new FileInputStream(fileName);
			oin = new ObjectInputStream(fis);

			if (fis.available() != 0) {
				accountsArray = (ArrayList<Accounts>) oin.readObject();
				oin.close();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return accountsArray;
	}
	
	
	public static void  adminOptions() {
		
		System.out.println("Please provide a valid response");
		System.out.println("To withdraw from an account - Type WITHDRAW");
		System.out.println("To add deposit on an account - Type Deposit");
		System.out.println("To transfer from an account - Type Transfer");
		System.out.println("To approve  an account - Type APPROVE");
		System.out.println("To cancel an account - Type CANCEL");
		String adminOption = sc.nextLine();
		adminOption=adminOption.toLowerCase();
		
		if(adminOption.equals("withdraw")) {
			System.out.println(adminOption);
			
		}else if (adminOption.equals("deposit")) {
			System.out.println(adminOption);
		}else if(adminOption.equals("transfer")) {
			System.out.println(adminOption);
		}else if (adminOption.equals("approve")) {
			Methods.approveAccounts();
		}else if(adminOption.equals("cancel")) {
			System.out.println(adminOption);
		}else {
			adminOptions();
		}
		
	}
	
	
	public static void approveAccounts() {
		//get the array list
		ArrayList<Customers> pendingCustomerArray= Methods.readObject("pending.ser");
		ArrayList<Accounts> accountsArray= new ArrayList<>();
		
		for(int i = 0; i<pendingCustomerArray.size(); i++) {
			System.out.println("Do you want to approve this customer to create account");
			System.out.println(pendingCustomerArray.get(i));
			String approveResponse = sc.nextLine();
			if(approveResponse.equals("yes")) {
				ArrayList<Integer> accounts = new ArrayList<Integer>();
				accounts.add(pendingCustomerArray.get(i).getSocial());
				accounts.add(pendingCustomerArray.get(i).getSecondSocial());
				
				int accountNo = Methods.accountGenerator();
				Integer accountNumber = accountNo;
				ArrayList<Integer> acct = new ArrayList<>();
				acct.add(accountNumber);
				System.out.println(acct);
				Accounts account = new Accounts(accountNo, 0, accounts);
				accountsArray.add(account);
				pendingCustomerArray.get(i).getAccounts().add(accountNumber);
				Methods.writeAccounts(account);
				Methods.writeObject(pendingCustomerArray.get(i), "approved.ser");
				
				
			}else if(approveResponse.equals("no")) {
				pendingCustomerArray.remove(i);
				
			}
			
			
			
			
			
			//Will Delete the pending file as the work is done
			//File file = new File("pending.ser");
			//file.delete();
			
			
			
			
		}
		
		ArrayList<Customers> approvedCustomer = Methods.readObject("approved.ser");
		System.out.println(approvedCustomer.size());
		for(int i=0; i<approvedCustomer.size(); i++) {
			System.out.println(approvedCustomer.get(i).getAccounts());
		}
		
		
		
		
		//ask admin what he wants to do with each account- Approve or Deny
		
		// if approve create Accounts Object and add the SSN
		
		// if deny then delete the Object
		
		// delete the entire pending file
	}
	
	public static int accountGenerator() {
		Random generator = new Random();
		int accountNo= generator.nextInt(9000000);
		return accountNo;
		
	}

}
