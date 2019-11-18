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

	
		System.out.println("Please Select the account you want to work with. The number is associated there");
		for (int i = 0; i < this.getAllAccounts().size(); i++) {
			System.out.println(i + 1 + ". " + this.getAllAccounts().get(i));
		}
		Scanner scanner = new Scanner(System.in);
		int selectedAccountNumber = scanner.nextInt();
		int accountNo = this.getAllAccounts().get(selectedAccountNumber - 1);
		float deposit = Methods.getFloatvalue("Tell me how much you want to deposit");
		Methods.addDeposits(accountNo, deposit);
		System.out.println("$" + deposit + " has been withdraw on the account " + accountNo);
		Methods.bankloggy.info("$" + deposit + " has been withdraw on the account " + accountNo);
	}


	public void withdrawl() {
		System.out.println("Please Select the account you want to work with. The number is associated there");
		for (int i = 0; i < this.getAllAccounts().size(); i++) {
			System.out.println(i + 1 + ". " + this.getAllAccounts().get(i));
		}
		Scanner scanner = new Scanner(System.in);
		int selectedAccountNumber = scanner.nextInt();
		int accountNo = this.getAllAccounts().get(selectedAccountNumber - 1);
		float withdrawl = Methods.getFloatvalue("Tell me how much you want to withdraw");
		Methods.getWithdrawl(accountNo, withdrawl);
		System.out.println("$" + withdrawl + " has been withdraw on the account " + accountNo);
		Methods.bankloggy.info("$" + withdrawl + " has been withdraw on the account " + accountNo);

	}

	
	public void transfer() {
		// TODO Auto-generated method stub
		System.out.println("Please Select the account you want to work with. The number is associated there");
		for (int i = 0; i < this.getAllAccounts().size(); i++) {
			System.out.println(i + 1 + ". " + this.getAllAccounts().get(i));
		}
		Scanner scanner = new Scanner(System.in);
		int selectedAccountNumber = scanner.nextInt();
		int yourAccountNo = this.getAllAccounts().get(selectedAccountNumber - 1);

		float transfer = Methods.getFloatvalue("Tell me how much you want to transfer");
		System.out.println("Tell us to which account you want to transfer?");
		int otherAccountNumber = scanner.nextInt();
		scanner.nextLine();
		Methods.transfer(yourAccountNo, otherAccountNumber, transfer);
		System.out.println("$" + transfer + " has been withdrawn on the account " + yourAccountNo);
		System.out.println("$" + transfer + " has been deposited on the account " + otherAccountNumber);
		Methods.bankloggy.info("$" + transfer + " has been withdrawn on the account " + yourAccountNo);
		Methods.bankloggy.info("$" + transfer + " has been withdrawn on the account " + yourAccountNo);
		

	}


	public void viewAccount() {
		// TODO Auto-generated method stub
		System.out.println("Please Select the account you want to work with. The number is associated there");
		for (int i = 0; i < this.getAllAccounts().size(); i++) {
			System.out.println(i + 1 + ". " + this.getAllAccounts().get(i));
		}
		Scanner scanner = new Scanner(System.in);
		int selectedAccountNumber = scanner.nextInt();
		scanner.nextLine();
		int accountNo = this.getAllAccounts().get(selectedAccountNumber - 1);
		Methods.viewAccounts(accountNo);

	}

}
