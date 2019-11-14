package com.app.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	float deposit;
	float withdraw;
	
	static boolean isReg = false;
	static Scanner scan = new Scanner(System.in);
	
	static Customer cust = new Customer(); // customer obj
	static Account acct = new Account();
	static ArrayList<Customer> accounts = new ArrayList<Customer>();// Arraylist holding Customer -> Acct.
	
	static String filename = "temp.ser";
	
	public static void main(String[] args) {
		writeCustomer(filename, cust); //Reading user object input FileInputStream = write.obj
		readCustomer(filename);	//Writing user object input //serialize, middle - admin edit while pending, seriliaze approve
	}

	public static void runCmenu() {
		
	}
	public static void runNewcMenu() { //Start Customer  menu
	
		System.out.println("Welcome to your local bank." + '\n'+ "1. Register" + '\n' + "2. Login");
		String msg = scan.nextLine(); //Scanner String
		
		int step = Integer.valueOf(msg)-1;
			switch (step) {
			case 0: msg = "1";
				System.out.println("Welcome to account regristration. Please enter your full name.");
				cust.Name = scan.nextLine();
				cust.setName(cust.Name); //insert validation
			
				System.out.println("Please enter a username.");
				cust.userName = scan.nextLine();
				cust.setUserName(cust.userName);
			
				System.out.println("Please enter a four digit pin number.");
				cust.userPin = scan.nextLine();
				//pinSetup();
				
				while(cust.userPin.length() != 4) {
				System.out.println("Invalid pin. Please re-enter");
				cust.userPin = scan.nextLine();
				}
				cust.setUserPin(cust.userPin);
				
//				System.out.println("What's your initial deposit amount?");
//				acct.balance = scan.nextFloat();
//				acct.setBalance(acct.balance);
				
				writeCustomer(filename, cust);
				accounts.add(cust);
				System.out.println(accounts);
				//readCustomer(filename);
				
				
				System.out.println("Okay " + cust.Name + "Please await account approval and review your account details:" +'\n' + cust.userName + cust.userPin + acct.balance);
				
				case 1: msg = "2";
				System.out.println("Welcome to login, please enter your username.");
		
				cust.userName = scan.nextLine();
				
				System.out.println("Enter pin number.");
				cust.userPin = scan.nextLine();
				
				for(int i = 0; i < accounts.size(); i++) {
//					while() {
//						
//					}
					if(cust.userName.equals(accounts.get(i).userName) && cust.userPin.equals(accounts.get(i).userPin))
					{
						System.out.println("Logged in");
						System.out.println(accounts.get(i));
					}else{
						System.out.println("Invalid input");
					}
				}
				
				System.out.println("Fail");
				break;
			
				default : System.out.println("Safety");
			}
	}
		
		
//				case 3: msg = "3";
//					break;
	
	
//				System.out.println("Is this your first time logging in? (Yes / No)");
//				
//				if(login1.equals("yes") | login1.equals("Yes") ) {
//					System.out.println("Cool");
//				}else {
//					System.out.println("Ok");
//				}
	
	
	

	public static void runEmenu() {// Start Customer menu
		System.out.println("Test 2");
		}
////////////////////////////SERIALIZATION/////////////////////////////////////////////////////////////////////////////////////////////
	public static void writeCustomer(String filename, Object cust) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			oos.writeObject(cust);
		}catch (IOException a){
			a.printStackTrace();
			}
		}
	public static void readCustomer(String filename) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			Object object = ois.readObject();
			System.out.println(object);
		}catch(IOException b) {
			b.printStackTrace();
		}catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
	}
	
}
