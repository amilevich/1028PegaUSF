package com.employeeDuties;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.account.JointAccount;
import com.account.NormalAccount;
import com.dataHandler.AccountsDatabase;
import com.dataHandler.DataHandler;
import com.dataHandler.IdentificationDatabase;
import com.dataHandler.RequestsDatabase;
import com.entityInfo.CustomerInfo;
import com.request.Request;

import accountHandler.AccountHandler;

public class EmployeeDuties {

	public void handleCustomerRequests() throws ClassNotFoundException, IOException{
    	Scanner sc = new Scanner(System.in);
    	RequestsDatabase database = DataHandler.readRequest();
    	Request request = null;
    	while((request = database.getNextRequest()) != null){
    	   	System.out.println("Displaying request from BankID" + request.getAssociatedBankID());
    	   	
    	   	if(request.getRequestType() == Request.RequestType.OPENJOINTACCOUNT){
    	   	  System.out.println("OPENAJOINTCCOUNT REQUEST");
    	   	  System.out.println("Do you want to prove this request?");
    	      System.out.println("Yes: 0, No: 1");
    	      int answer = 0;
    	
    	      answer = sc.nextInt();
    	      switch(answer){
    	       case 0:
    	    	  IdentificationDatabase IDbase = DataHandler.readIdentificationBase();
    	    	  int newAccountNumber = IDbase.getNextAvailableAccountNumber();
    	    	  int newBalance = 0;
    	    	  ArrayList<Integer> BankIDs = new ArrayList<Integer>();
    	    	  BankIDs.add(request.getAssociatedBankID());
    	    	  JointAccount newJointAccount = new JointAccount(newAccountNumber, newBalance, BankIDs);
    	    	  AccountsDatabase<JointAccount> AccountBase  = DataHandler.readJointAccount();
    	    	  AccountBase.addAccount(newJointAccount);
    	    	  DataHandler.storeJointAccount(AccountBase);
    	    	  request.setRequestStatus(Request.RequestStatus.APPROVED);
    	    	  DataHandler.storeRequest(database);
    	    	  DataHandler.storeIdentificationBase(IDbase);
    	    	  break;
    	       case 1:
    	    	  request.setRequestStatus(Request.RequestStatus.DENIED);
    	    	  break;
    	       case 2:
    	    	   return;
    	       default:
    	         break;
    	      }
    	   	}
    	   	
    	   	else if(request.getRequestType() == Request.RequestType.OPENNORMALACCOUNT){
    	   	    System.out.println("OPENANORMALCCOUNT REQUEST");
   	   	        System.out.println("Do you want to approve this request?");
   	            System.out.println("Yes: 1, No: 0"); 
   	            int answer = 0;
   	
   	            answer = sc.nextInt();
   	            switch(answer){
   	            case 1:
   	               IdentificationDatabase IDbase = DataHandler.readIdentificationBase();
   	    	       int newAccountNumber = IDbase.getNextAvailableAccountNumber();
   	    	       int newBalance = 0;
   	    	       int AssociatedBankID = request.getAssociatedBankID();
   	    	       NormalAccount newNormalAccount = new NormalAccount(newAccountNumber, newBalance, AssociatedBankID);
   	    	       AccountsDatabase<NormalAccount> AccountBase  = DataHandler.readNormalAccount();
  	    	       AccountBase.addAccount(newNormalAccount);
  	    	       DataHandler.storeNormalAccount(AccountBase);
  	    	       request.setRequestStatus(Request.RequestStatus.APPROVED);
  	    	       DataHandler.storeRequest(database);    
  	    	       DataHandler.storeIdentificationBase(IDbase);
   	               break;
   	            case 0:
   	    	       request.setRequestStatus(Request.RequestStatus.DENIED);
   	    	       break;
   	            default:
   	            break;
   	            }
    	   	}
    	   	
    	   	else if(request.getRequestType() == Request.RequestType.CLOSEJOINTACCOUNT){
    	   		System.out.println("issuing CLOSEJOINTACCOUNT request received from" + 
    	   	                      request.getAssociatedBankID());
    	   	    AccountsDatabase<JointAccount> AccountBase  = DataHandler.readJointAccount();
   	            if(AccountBase.LeaveAccount(request.getAccountNumber(), request.getAssociatedBankID())){
   	            	request.setRequestStatus(Request.RequestStatus.APPROVED);
   	            }
   	            else request.setRequestStatus(Request.RequestStatus.DENIED);
   	         DataHandler.storeRequest(database);  
   	         DataHandler.storeJointAccount(AccountBase);
    	   	}
    	   	
    	   	else if(request.getRequestType() == Request.RequestType.CLOSENORMALACCOUNT){
    	   		System.out.println("issuing CLOSENORMALACCOUNT request received from" + 
 	                      request.getAssociatedBankID());
    	   		AccountsDatabase<NormalAccount> AccountBase = DataHandler.readNormalAccount();
    	   	    if(AccountBase.LeaveAccount(request.getAccountNumber(), request.getAssociatedBankID())){
	            	request.setRequestStatus(Request.RequestStatus.APPROVED);
	            }
	            else request.setRequestStatus(Request.RequestStatus.DENIED);
    	   	 DataHandler.storeRequest(database);  
   	         DataHandler.storeNormalAccount(AccountBase);
    	   	}
    	}
    	System.out.println("No more requests to handle for this BankID");
    }
    
    public CustomerInfo retrieveCustomerInfo(String username) throws ClassNotFoundException, IOException{
        return AccountHandler.retrieveCustomerInfo(username);
    }
}
	

