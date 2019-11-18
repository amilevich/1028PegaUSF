package com.project0;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Customer implements Serializable {
	/**
	 * 
	 *///variables declaration and initialized
	private static final long serialVersionUID = -6815639076385746891L;
	// Declare private variables
	Random randomGenerator = new Random();
	private int custId = randomGenerator.nextInt(7000000);
	private int acId=randomGenerator.nextInt(7000000);
	private String userName;
	ArrayList<String>theList=new ArrayList<String>();
	
	
	private String password;
	private String fName;
	private String lName;

	//public String cusId =randomGenerator.nextInt(70000);
	Account actt = new Account();
	private String acttId = Integer.toString(acId);
	private String stat ="penging";
	private double balance =0.0;
	private String cusId = Integer.toString(custId);
	
	
	
	
	

	// Create constructor with no fields
	public Customer() {
		super();

	}

	// create constructor with fields
	public Customer(String acctId,String userName, String password, String fName, String lName, String cusId) {
		super();
		
		this.userName = userName;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
		this.cusId = cusId;
		
		
		
	}
	
	//getters and setters
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public String getUserName() {
		return userName;
	}

	// Creating the getters

	// retrieve customer password
	public String getPassword() {
		return password;
	}

	// method that retrieve customer fisrt name
	public String getfName() {
		return fName;

	}

	// retrieving customer last name
	public String getlName() {
		return lName;
	}

	// retrieve id
	public String getCusId() {
		return cusId;
	}

	// retrieve customer username
	public void setUserName(String userName) {
		this.userName = userName;
	}

	// create setters
	// set the customer last name
	public void setPassword(String password) {
		this.password = password;
	}

	// set the customer first name
	public void setfName(String fName) {
		this.fName = fName;
	}

	// set the customer last name
	public void setlName(String lName) {
		this.lName = lName;
	}

	// set the customer id
	public void setCusId(String cusId) {
		this.cusId = cusId;
	}
	
	
	

	

	public String getActtId() {
		return acttId;
		
		
	}

	

	

	// creating method that write customer object
	public void writeCustomer(String Filename, Object object) {
		try (ObjectOutputStream cust = new ObjectOutputStream(new FileOutputStream(Filename))) {
			cust.writeObject(object);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

	//ToString method
	@Override
	public String toString() {
		return "Customer First Name= " + fName + ", Last Name= " + lName + ",userName= " + userName + ", password= " + password + " , cusId= " + cusId + ", acttId= " + acttId + ", status= " + stat + ", balance= "
				+ balance + "";
	}

	

	// Creating Method that read from to the file
	public static void  readCustomer(String name) {
		
		try (ObjectInputStream cust1 = new ObjectInputStream(new FileInputStream(name))) {
			Account.customerList=(ArrayList<Customer>)cust1.readObject();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}//serialization method
    
	public  void  customerSerialize(ArrayList<Customer>Lst) {
        
        try {
        	
            FileOutputStream fos = new FileOutputStream("./customer.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Lst);
            oos.close();
            fos.close();
            System.out.println("Your info has been saved!!");
            
            
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }// end serialization method
    
    public void customerDeserialize(ArrayList<Customer>Lst) {
        
        try {
            FileInputStream fis = new FileInputStream("./customer.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Lst = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException ioe) {
            ioe.printStackTrace();
            return;
        }catch(ClassNotFoundException c) {
                System.out.println("Class not found!");
                return;
            }
        //verifying data
        for(Customer c : Lst) {
            System.out.println(c);
        }
        
    }//end deserialized method

}
