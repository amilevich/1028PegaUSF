package com.example.bank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.Scanner;

public class Customers implements Serializable {

	/**
	 * 
	 */
	final static String filePath = "/Users/VictoryLe/Desktop/RevatureGitRepo/1028PegaUSF/Victory_Le_Code/banking.txt";
	private static final long serialVersionUID = 8237467561552742438L;
	// Private data to extend to other classes && Serialization
	private int id;
	private static String firstName;
	private String lastName;
	private String userName;
	// Making password transient for security
	private transient String password;
	private double withdrawAmt;
	private double depositAmt;
	private double checkingBalance;
	private double savingBalance;
	private double totalBalance = checkingBalance + savingBalance;
	private String menuOption;
	private String input;

	// Constructor

	public Customers() {
	}

	// Customer Constructor
	public Customers(int id, String firstName, String lastName, String userName, String password, double withdrawAmt,
			double depositAmt, double checkingBalance, double savingBalance, double totalBalance) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.withdrawAmt = withdrawAmt;
		this.depositAmt = depositAmt;
		this.checkingBalance = checkingBalance;
		this.savingBalance = savingBalance;
		this.totalBalance = totalBalance;
	}

	// Print Info
	public void printInfo() {
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("username: " + userName);
		System.out.println("password: " + password);
		System.out.println("Checking Account Balance: " + checkingBalance);
		System.out.println("Saving Account Balance: " + savingBalance);
	}

	public void menuPopup() throws FileNotFoundException {

		System.out.println("Welcome to the Bank" + "\n" + "Victory");

		Scanner sc = new Scanner(System.in);

		// Show Menu

		System.out.println("1. Customer");
		System.out.println("2. Employee");
		System.out.println("3. Admin");
		System.out.println("4. Register");

		menuOption = sc.next();

		switch (menuOption) {

		case "1":
			System.out.println("Customer");
			login();
			break;
		case "2":
			System.out.println("Employee");
			login();
			break;
		case "3":
			System.out.println("Admin");
			login();
			break;
		case "4":
			System.out.println("Register");
			break;
		default:
			System.out.println("Error");
		}
	}

	// Login
	public void login() throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		File filename = new File("/Users/VictoryLe/Desktop/RevatureGitRepo/1028PegaUSF/Victory_Le_Code/banking.txt");
    	BufferedReader br = new BufferedReader(new FileReader(filename));
    	
		

		System.out.println("Enter Username");
		userName = sc.nextLine();
		System.out.println("Enter Password");
		password = sc.nextLine();
		//read from text file
		br.readLine();
		//select customer based on provided username
		
	 }

	// DEPOSIT into account balance
	public void deposit(String type, double depositAmt) {
		System.out.println("Deposit!");
		if (type == "checking deposit") {
			System.out.println(
					"\n" + "Depositing: " + depositAmt + " to Checking balance: " + getCheckingBalance() + "\n");
			this.setCheckingBalance(getCheckingBalance() + depositAmt);
			System.out.println("Total checking balance: " + getCheckingBalance());
		}

		if (type == "saving deposit") {
			System.out.println("\n" + "Depositing: " + depositAmt + " to Saving balance " + getSavingBalance() + "\n");
			this.setSavingBalance(getSavingBalance() + depositAmt);
			System.out.println("Total saving balance: " + getSavingBalance());
		}
	}

	// WITHDRAW from account balance
	public void Withdraw(String type, double withdrawAmt) {

		if (type == "checking withdraw") {
			System.out.println("\n" + "Withdraw: " + withdrawAmt + " from Checking balance " + getCheckingBalance());
			this.setCheckingBalance(getCheckingBalance() - withdrawAmt);
			System.out.println("\n" + "Total checking balance: " + getCheckingBalance() + "\n");
		}

		if (type == "saving withdraw") {
			System.out.println("\n" + "Withdraw: " + withdrawAmt + " from Saving balance " + getSavingBalance() + "\n");
			this.setSavingBalance(getSavingBalance() - withdrawAmt);
			System.out.println("\n" + "Total saving balance: " + getSavingBalance() + "\n");
		}
	}

	// Getter and Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public double getWithdrawAmt() {
		return withdrawAmt;
	}

	public void setWithdrawAmt(double withdrawAmt) {
		this.withdrawAmt = withdrawAmt;
	}

	public double getDepositAmt() {
		return depositAmt;
	}

	public void setDepositAmt(double depositAmt) {
		this.depositAmt = depositAmt;
	}

	public double getCheckingBalance() {
		return checkingBalance;
	}

	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	public double getSavingBalance() {
		return savingBalance;
	}

	public void setSavingBalance(double savingBalance) {
		this.savingBalance = savingBalance;
	}

	public double getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}

}
