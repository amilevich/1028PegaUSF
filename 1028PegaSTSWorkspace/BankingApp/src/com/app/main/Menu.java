package com.app.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	public static void main(String[] args) {
		
	}
	
	float deposit;
	float withdraw;
	
	static boolean isReg = false;
	static Scanner scan = new Scanner(System.in);
	static Customer cust = new Customer(); // customer obj
	ArrayList<Customer> accounts = new ArrayList<Customer>();// Arraylist holding Customer -> Acct.

	public static void runCmenu() {
		
	}
	public static void runNewcMenu() { //Start Customer  menu
		String filename = "temp.ser"; 
		FileOutputStream temp1 = null; //Reading user object input FileInputStream = write.obj
		ObjectOutputStream temp2 = null; //Writing user object input //serialize, middle - admin edit while pending, seriliaze approve
	
	try {
		temp1 = new FileOutputStream(filename);
		temp2 = new ObjectOutputStream(temp1);
		temp2.writeObject(cust); //pass in class
		temp2.close();
		temp1.close();
		
	}catch (IOException ex){
		ex.printStackTrace();
	}
	
		System.out.println("Welcome to your local bank." + '\n'+ "1. Register" + '\n' + "2. Login");//if & switch
	
		String msg = scan.nextLine(); //Scanner String
		int step = Integer.valueOf(msg);
			switch (step) {
			case 1: msg = "1";
				System.out.println("Welcome to account regristration. Please enter your full name.");
				cust.Name = scan.nextLine();
				cust.setName(cust.Name);
			
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
				
				System.out.println("How much money do have on hand?");
				
				
				break;
	
		switch (step) {
		case 2: msg = "2";
			System.out.println("Welcome to login, please enter your username.");
		
			scan.nextLine();
		
			if(scan.hasNext(cust.userName)){
				System.out.println();
			}
		
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
	
	
	////////////////////////////SERIALIZATION/////////////////////////////////////////////////////////////////////////////////////////////
		//Save obj to file
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		
		
		try {
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(cust);
		
			out.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		//read the obj from file
		//save obj to file
			FileInputStream fis = null;
			ObjectInputStream in = null;
			try {
				fis = new FileInputStream(filename);
				in = new ObjectInputStream(fis);
				cust = (Customer) in.readObject();
				in.close();
			}catch (Exception ex){
				ex.printStackTrace();
			}
			System.out.println(cust);
		
		}
	}

	public static void runEmenu() {// Start Customer menu
		System.out.println("Test 2");
		}
	
	
}
