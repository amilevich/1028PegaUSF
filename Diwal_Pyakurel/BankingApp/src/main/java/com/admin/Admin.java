package com.admin;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.Methods.Methods;
import com.accounts.Accounts;

import bankinterfaces.AdminInterfaces;
import bankinterfaces.CommonInterfaces;

public class Admin implements CommonInterfaces, AdminInterfaces {
	
	private String name;
	private int pinCode;
	
	
	public Admin() {
		super();
		this.name = "Mr Admin";
		this.pinCode = 1234;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPinCode() {
		return pinCode;
	}


	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}



	public void deposit() {	
		int accountNo = Methods.adminSelectsAccount();
		float depositAmt = Methods.getFloatvalue("Please provide deposit amount");
		Methods.addDeposits(accountNo, depositAmt);
		System.out.println("$"+depositAmt+ " has been deposited on the account "+ accountNo);
		Methods.bankloggy.info("$"+depositAmt+ " has been deposited on the account "+ accountNo);
		
	}


	
	public void withdrawl() {
		// TODO Auto-generated method stub
		int accountNo = Methods.adminSelectsAccount();
		float withdrawlAmt = Methods.getFloatvalue("Please specify the amount you want to withdraw on this account");
		Methods.getWithdrawl(accountNo, withdrawlAmt);
		System.out.println("$" +withdrawlAmt+ " has been withdraw on the account "+ accountNo);
		Methods.bankloggy.info("$" +withdrawlAmt+ " has been withdraw on the account "+ accountNo);
	}


	
	public void transfer() {
		System.out.println("Please select the accont where you want to withdraw money");
		int withdrawingAccount = Methods.adminSelectsAccount();
		System.out.println("Please select the accont where you want to transfer money");
		int depositingAccount = Methods.adminSelectsAccount();
		float amt = Methods.getFloatvalue("Specify the amount for transfer");
		
		Methods.transfer(withdrawingAccount, depositingAccount, amt);
		System.out.println("$"+amt+ " has been deposited on the account "+ depositingAccount);
		System.out.println("$" +amt+ " has been withdrawn from the account "+ withdrawingAccount);
		Methods.bankloggy.info("$"+amt+ " has been deposited on the account "+ depositingAccount);
		Methods.bankloggy.info("$" +amt+ " has been withdrawn from the account "+ withdrawingAccount);
	}


	
	public void viewAccount() {
		ArrayList<Accounts> allAccounts = Methods.readAccounts();

		for(int i =0; i<allAccounts.size(); i++) {
			
			System.out.println(allAccounts.get(i).toString());
		}
	}


	
	public void deleteAccount() {
		ArrayList<Accounts> allAccounts = Methods.readAccounts();
		this.viewAccount();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please provide the account number you want to delete");
		int accountNo = sc.nextInt();
		//sc.nextLine();
		
		for(int i = 0; i<allAccounts.size(); i++) {
			if(allAccounts.get(i).getAccounNo()==accountNo) {
				allAccounts.remove(i);	
				System.out.println("Account Deleted");
				Methods.updateOnlineProfiles(allAccounts.get(i).getLinkedSocial().get(0));
				if(allAccounts.get(i).getLinkedSocial().get(1)!=0) {
					Methods.updateOnlineProfiles(allAccounts.get(i).getLinkedSocial().get(1));
				}
			}
			
		}
		
		
		
		String fileName = "accounts.ser";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(allAccounts);
			oos.close();
			fos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	
		
	}



	public void approveAccount() {
		// TODO Auto-generated method stub
		Methods.approvalOfAccounts();
		
	}
	
	

}
