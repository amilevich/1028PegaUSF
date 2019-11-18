package com.project.pt1;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class BankAccount implements Serializable{ 
	
	public int accountID = 0; 
	private double funds = 0;

	
	ArrayList<Customer> cList = new ArrayList<Customer>();
	//List that will hold customers who have access to this account.
	




BankAccount(){ //The account ID will be generated when the employee approves it.
	Random r = new Random();
	this.accountID = r.nextInt(9999-1000)+1000;
	
// Give bank account unique ID
	
}

public double getFunds() {
	return funds;
}
public void setFunds(double x) {
	this.funds = x;
}

public void depositFunds(double x) {
	this.funds += x;
	System.out.println("Deposited .... $" + x);
	System.out.println("New Balance .... $" + this.funds);
	this.updateFile();

}

public void withdrawFunds(double x) {
	Scanner sc = new Scanner(System.in);

	if ((this.funds - x) >= 0) {
		this.funds -= x;
		System.out.println("Dispensing .... "+ x);
		System.out.println("Your new balance is .... $" + this.funds);
		this.updateFile();


	} else {
		System.out.println("Error - Not enough funds");
		
	}
}

public int getID() {
	
	return accountID;
	
}

public void updateFile() { //not really nescessary since customer holds bank account obj which gets serialized with each transaction.
	
	String fileName = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/accounts/" + this.accountID + ".ser";//#0 needed for writing to file
	//WRITE TO FILE
	try {
		
		FileOutputStream out1 = new FileOutputStream(fileName); //#1 
        ObjectOutputStream out2 = new ObjectOutputStream(out1);//#2 for writing to file
        
        
        //OUTPUT(Serialization) of object
       
        
        out2.writeObject(this); //#3 thats needed for writing to file. *
        
        out2.close(); 
        out1.close(); 
          
        System.out.println("Bank Account Serialized & Updated");
        
	}
	
		catch(IOException ex) 
        { 
            System.out.println("IOException is caught - accountApp"); 
        }
	

	
}

public void readFile() {
	
String fileName = "/Users/Caio/Documents/workspace-sts-3.9.4.RELEASE/ProjectZeroPart1/src/main/java/com/project/pt1/accounts/" + this.accountID + ".ser"; //hoooly shit this works

	BankAccount object1 = null;
	try
    {    
        // Reading the object from a file 
        FileInputStream file = new FileInputStream(fileName); 
        ObjectInputStream in = new ObjectInputStream(file); 
          
        // Method for deserialization of object 
        object1 = (BankAccount)in.readObject(); 
        
        this.accountID = object1.accountID;
        this.funds = object1.funds;
          
        in.close(); 
        file.close(); 
       
    } 
      
    catch(IOException ex) 
    { 
        System.out.println(""); 
    } 
      
    catch(ClassNotFoundException ex) 
    { 
        System.out.println("ClassNotFoundException is caught"); 
    }
	
	
	
}



}



