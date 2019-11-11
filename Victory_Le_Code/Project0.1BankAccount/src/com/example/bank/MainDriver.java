package com.example.bank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
	 
	public class MainDriver {
		
		//Serialized bytes
		
	    public static void main(String[] args) {
	    	
	    	// Instantiations
	        Customers customer = new Customers();
	        Admin menu = new Admin();
	    
	    	
	    	
	    	customer.menuPopup();

	    	
	    
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
//**************************************************************************************************************************


	        // save the object to file
	        FileOutputStream fos = null;
	        ObjectOutputStream out = null;
	        try {
	            fos = new FileOutputStream(filename);
	            out = new ObjectOutputStream(fos);
	            out.writeObject(customer);

	            out.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        // read the object from file
	        // save the object to file
	        FileInputStream fis = null;
	        ObjectInputStream in = null;
	        try {
	            fis = new FileInputStream(filename);
	            in = new ObjectInputStream(fis);
	            customer = (Customers) in.readObject();
	            in.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
//**************************************************************************************************************************
	        

  
	        
	    }

	}

