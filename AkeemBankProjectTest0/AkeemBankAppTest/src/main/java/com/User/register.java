package com.User;

import com.dataHandler.DataHandler; 


import java.io.IOException;
import java.util.Scanner;



import com.dataHandler.EntityInfoDatabase;
import com.dataHandler.IdentificationDatabase;
import com.entityInfo.CustomerInfo;
import com.entityInfo.EmployeeInfo;

public class register {

	public static void registerCustomer() throws ClassNotFoundException, IOException{
    	Scanner rc = new Scanner(System.in);
    	String name;
    	String username;
    	String password;
    	int BankID;
    	System.out.println("Enter name");
    	name = rc.nextLine();
    	System.out.println("Enter Username");
    	username = rc.nextLine();
    	System.out.println("Enter Password");
    	password = rc.nextLine();
    	IdentificationDatabase base = DataHandler.readIdentificationBase();
    	BankID = base.getNextAvailableCustomerBankID();
    	DataHandler.storeIdentificationBase(base);
    	CustomerInfo newCustomer = new CustomerInfo(name,username,password,BankID);
    	EntityInfoDatabase<CustomerInfo> info = DataHandler.readCustomerInfo();
    	info.addEntityInfo(newCustomer);
    	DataHandler.storeCustomerInfo(info);
    	System.out.println("Successfull Registration!");
    }
   
    public static void registerEmployee() throws ClassNotFoundException, IOException{
    	Scanner rc = new Scanner(System.in);
    	String name;
    	String username;
    	String password;
    	int BankID;
    	System.out.println("Enter name");
    	name = rc.nextLine();
    	System.out.println("Enter Username");
    	username = rc.nextLine();
    	System.out.println("Enter Password");
    	password = rc.nextLine();
    	IdentificationDatabase base = DataHandler.readIdentificationBase();
    	BankID = base.getNextAvailableEmployeeBankID();
    	DataHandler.storeIdentificationBase(base);
    	EmployeeInfo newCustomer = new EmployeeInfo(name,username,password,BankID);
    	EntityInfoDatabase<EmployeeInfo> info = DataHandler.readEmployeeInfo();
    	info.addEntityInfo(newCustomer);
    	DataHandler.storeEmployeeInfo(info);
    	System.out.println("Successfull Registration!");	
    }
    
    public static void registerBankAdminInfo(){
    	
    }
}

