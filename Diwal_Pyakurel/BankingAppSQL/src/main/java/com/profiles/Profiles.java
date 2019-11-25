package com.profiles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import com.Methods.Methods;

import bankinterfaces.CommonInterfaces;

public class Profiles implements Serializable, CommonInterfaces {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private int social;
	private ArrayList<Integer> allAccounts;

	public Profiles() {
		// TODO Auto-generated constructor stub
	}
	public Profiles(String userName, String password, int social, ArrayList<Integer> allAccounts) {
		super();
		this.userName = userName;
		this.password = password;
		this.social = social;
		this.allAccounts = allAccounts;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSocial() {
		return social;
	}

	public void setSocial(int social) {
		this.social = social;
	}

	public ArrayList<Integer> getAllAccounts() {
		return allAccounts;
	}

	public void setAllAccounts(ArrayList<Integer> allAccounts) {
		this.allAccounts = allAccounts;
	}

	@Override
	public String toString() {
		return "Profiles [userName=" + userName + ", password=" + password + ", social=" + social + ", allAccounts="
				+ allAccounts + "]";
	}


	public void deposit() {
		
		ArrayList<Integer> customerActs = Methods.getCustomerAccounts(this.getSocial());
	
		System.out.println("Please Select the account you want to work with. The number is associated there");
		for (int i = 0; i < customerActs.size(); i++) {
			System.out.println(i + 1 + ". " + customerActs.get(i));
		}
		Scanner scanner = new Scanner(System.in);
		int selectedAccountNumber = scanner.nextInt();
		int accountNo = customerActs.get(selectedAccountNumber - 1);
		float deposit = Methods.getFloatvalue("Tell me how much you want to deposit");
		//Methods.addDeposits(accountNo, deposit);
		
		
		Methods.accts.addDeposit(accountNo, deposit);
		
		Methods.bankloggy.info("$" + deposit + " has been withdraw on the account " + accountNo);
	}


	public void withdrawl() {
		ArrayList<Integer> customerActs = Methods.getCustomerAccounts(this.getSocial());
		
		System.out.println("Please Select the account you want to work with. The number is associated there");
		for (int i = 0; i < customerActs.size(); i++) {
			System.out.println(i + 1 + ". " + customerActs.get(i));
		}
		Scanner scanner = new Scanner(System.in);
		int selectedAccountNumber = scanner.nextInt();
		int accountNo = customerActs.get(selectedAccountNumber - 1);
		float withdrawl = Methods.getFloatvalue("Tell me how much you want to withdraw");
		//Methods.addDeposits(accountNo, deposit);
	
		Methods.accts.withdraw(accountNo, withdrawl);

		Methods.bankloggy.info("$" + withdrawl + " has been withdraw on the account " + accountNo);

	}

	
	public void transfer() {
		// TODO Auto-generated method stub
ArrayList<Integer> customerActs = Methods.getCustomerAccounts(this.getSocial());
		
		System.out.println("Please Select the account you want to work with. The number is associated there");
		for (int i = 0; i < customerActs.size(); i++) {
			System.out.println(i + 1 + ". " + customerActs.get(i));
		}
		Scanner scanner = new Scanner(System.in);
		int selectedAccountNumber = scanner.nextInt();
		int accountNo = customerActs.get(selectedAccountNumber - 1);
		
		System.out.println("Tell us to which account you want to transfer?");
		int otherAccountNumber = scanner.nextInt();
		scanner.nextLine();
		
		float transfer = Methods.getFloatvalue("Tell me how much you want to transfer");
		
		Methods.accts.transfer(accountNo, otherAccountNumber, transfer);
		
		Methods.bankloggy.info("$" + transfer + " has been withdrawn on the account " + accountNo);
		Methods.bankloggy.info("$" + transfer + " has been withdrawn on the account " + accountNo);
		

	}


	public void viewAccount() {
		// TODO Auto-generated method stub
		ArrayList<Integer> customerActs = Methods.getCustomerAccounts(this.getSocial());
		
		System.out.println("Please Select the account you want to work with. The number is associated there");
		for (int i = 0; i < customerActs.size(); i++) {
			System.out.println(i + 1 + ". " + customerActs.get(i));
		}
		Scanner scanner = new Scanner(System.in);
		int selectedAccountNumber = scanner.nextInt();
		int accountNo = customerActs.get(selectedAccountNumber - 1);
		
		Methods.accts.view(accountNo, this.getSocial());
		
		

	}

}
