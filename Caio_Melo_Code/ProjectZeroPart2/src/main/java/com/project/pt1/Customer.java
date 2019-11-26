
package com.project.pt1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.apache.log4j.Logger;

enum Status {

	PENDING, APPROVED, DENIED;
}

enum jStatus {
	NOT_JOINT, PENDING, APPROVED, DENIED, LOST_IN_BEUROCRACY;
}

public class Customer {

	final static Logger Loggy = Logger.getLogger(Customer.class);

	private int bankID;
	private String username;
	private String password;
	public Status appStatus;
	public jStatus jointStatus;
	private Double funds = 0.0;
	String[] JointAppDetails = new String[2];
	private int jBankID;

	DecimalFormat dFormat = new DecimalFormat("#.00");

	public Customer(int a, String b, String c, double f, String stat, String jstat, int jID) {

		this.bankID = a;
		this.username = b;
		this.password = c;
		this.funds = f;
		if (stat.contains("APPROVED")) {
			this.appStatus = Status.APPROVED;
		} else if (stat.equalsIgnoreCase("DENIED")) {
			this.appStatus = Status.DENIED;
		} else {
			this.appStatus = Status.PENDING;
		}

		if (jstat.equalsIgnoreCase("NOT_JOINT")) {
			this.jointStatus = jStatus.NOT_JOINT;
		} else if (jstat.equalsIgnoreCase("APPROVED")) {
			this.jointStatus = jStatus.APPROVED;
		} else if (jstat.equalsIgnoreCase("PENDING")) {
			this.jointStatus = jStatus.PENDING;
		} else if (jstat.equalsIgnoreCase("DENIED")) {
			this.jointStatus = jStatus.DENIED;
		} else {
			this.jointStatus = jStatus.LOST_IN_BEUROCRACY;
		}
		this.jBankID = jID;
	}

	public Customer() {
		appStatus = Status.PENDING;
	}

	public Customer(String x, String y) {

		this.username = x;
		this.password = y;
		appStatus = Status.PENDING;
		jointStatus = jStatus.NOT_JOINT;

		Random r = new Random();
		bankID = r.nextInt(9999 - 1000) + 1000;
	}

	public int getjBankID() {
		return jBankID;
	}

	public void setjBankID(int jBankID) {
		this.jBankID = jBankID;
	}

	public void setAppStatus(Status appStatus) {
		this.appStatus = appStatus;
	}

	public Status getAppStatus() {
		return appStatus;
	}

	public String getStatus() {
		return appStatus.toString();
	}

	public jStatus getJointStatus() {
		return jointStatus;
	}

	public String getJStatus() {
		return jointStatus.toString();
	}

	public void setJointStatus(jStatus jointStatus) {
		this.jointStatus = jointStatus;
	}

	public int getBankID() {
		return bankID;
	}

	public void setBankID(int bankID) {
		this.bankID = bankID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String name) {
		this.username = name;
	}

	public String getPassword() {
		return password;
	}

	public double getFunds() {
		return funds;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFunds(double x) {
		this.funds = x;
	}

	public void reDisplay() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Would you like to make another transaction?");
		System.out.println("[1] \t Yes");
		System.out.println("[2] \t No");

		int input = sc.nextInt();
		switch (input) {
		case 1:
			customerPrompt();
			break;
		case 2:
			System.out.println("Thank you for using Atlas Bank, Goodbye.");
			MainDriver.prompt();

		}

	}

	public void setStatus(Status stat) {
		this.appStatus = stat;
	}

	public void customerPrompt() {
		Scanner sc = new Scanner(System.in);
		System.out.println("What would you like to do?");
		System.out.println("[1] \t Deposit Funds");
		System.out.println("[2] \t Withdraw Funds");
		System.out.println("[3] \t Transfer Funds");
		System.out.println("[4] \t View Balance");
		System.out.println("[5] \t Apply for a Joint Account");
		System.out.println("[6] \t Logout.");
		System.out.println("Please make a selection(1-6)");

		int selection = sc.nextInt();
		switch (selection) {

		case 1:
			System.out.print("How much would you like to deposit?");
			int depo = sc.nextInt();
			depositFunds(depo);
			Loggy.info("Customer deposit successful. Amount : " + depo);
			reDisplay();
			break;
		case 2:
			System.out.println("Available funds .... $" + this.getFunds());
			System.out.println("Please enter withdrawl amount.");

			double wd = sc.nextDouble();
			withdrawFunds(wd);
			Loggy.info("Customer withdrawl successful.");
			reDisplay();

			break;
		case 3:
			if (this.getJointStatus() == jStatus.NOT_JOINT) {
				System.out.println("You do not currently have a joint bank account.");
				MainDriver.promptContinue();
				customerPrompt();
			} else {
				transferFunds();
			}

			break;
		case 4:
			System.out.println("Account Balance .... " + getFunds());
			reDisplay();
			break;
		case 5:
			System.out.println("Please enter the username for the secondary account");
			String tempName = sc.next();

			System.out.println("Please enter the password for the secondary account");
			String tempPw = sc.next();
			jointApplication(tempName, tempPw);
			Loggy.info("Joint application sent. Between " + this.getUsername() + " and" + tempName);
			break;
		case 6:
			System.out.println("Thank you for banking with Atlas");
			MainDriver.prompt();

			break;
		}
	}

	@SuppressWarnings("unchecked")
	public void jointApplication(String x, String y) {

		{

			Customer object1 = null;
			ArrayList<Customer> cust = null;

			cust = MainDriver.readSQLCustomers(); // DOING SQL STUFF

			for (Customer temp : cust) {
				if (temp.getUsername().contentEquals(x) && temp.getPassword().contentEquals(y)) {

					this.JointAppDetails[0] = x;
					this.JointAppDetails[1] = y;

					temp.JointAppDetails[0] = this.getUsername();
					temp.JointAppDetails[1] = this.getPassword();

					this.jBankID = temp.bankID;
					temp.jBankID = this.bankID;

					this.jointStatus = jStatus.PENDING;
					temp.jointStatus = jStatus.PENDING;

					MainDriver.cDAO.updateCustomer(temp);
					MainDriver.cDAO.updateCustomer(this);

					System.out.println("Joint Account Application Successfully Sent.");
					System.out.println("[1] \t Continue");
					System.out.println("[2] \t Logout");
					Scanner sc = new Scanner(System.in);
					int cont = sc.nextInt();
					switch (cont) {
					case 1:
						this.customerPrompt();
						break;
					case 2:
						System.out.println("Thank you for using Atlas Bank. Goodbye.");
						MainDriver.prompt();

					}
				}
				} 

					System.out.println("Secondary Account Password Incorrect. \nWould you like to try again? ");
					System.out.println("1\tYes");
					System.out.println("2\tNo");
					System.out.println("Please make a selection(1-2)");
					@SuppressWarnings("resource")
					Scanner sc = new Scanner(System.in);
					int selection = sc.nextInt();

					switch (selection) {
					case 1:
						System.out.println("Please enter secondary account password.");
						String pw = sc.next();

						jointApplication(x, pw);
						break;
					case 2: // Send back to customer screen.
						customerPrompt();
						break;
					default:
						customerPrompt();
					}
				

			

		}
	}

	public static ArrayList<Customer> addRemove(ArrayList<Customer> x, Customer y) {
		for (int i = 0; i < x.size(); i++) {

			if (x.get(i).getUsername().contentEquals(y.getUsername())) {

				x.remove(i);
				x.add(i, y);

			}

		}
		return x;
	}

	public String toString() {
		return "Name: [" + this.username + "] " +

				"AccountID: [" + this.bankID + "] Application Status: [" + this.appStatus + "]" + "Joint Status: ["
				+ this.getJStatus().toString() + "]";
	}

	public String toDetailedString() {
		String x = "Name: [" + this.username + "] " + " AccountID: [" + this.bankID + "] Funds: $[" + this.getFunds()
				+ "] Application Status: [" + this.appStatus + "] Joint Status: [" + this.jointStatus + "]";

		if (this.jointStatus == jStatus.APPROVED) {
			x += "\nJoint Account:\n" + MainDriver.cDAO.selectByID(this.jBankID).toJointString();
			return x;
		}

		return x;
	}

	public String toJointString() {
		String x = "Name: [" + this.username + "] " + " AccountID: [" + this.bankID + "] Funds: $[" + this.getFunds()
				+ "] Application Status: [" + this.appStatus + "] Joint Status: [" + this.jointStatus + "]";
		return x;
	}

	public void transferFunds() {

		ArrayList<Customer> temp = null;
		temp = MainDriver.cDAO.selectAllCustomers(); // SQL TAKEOVER
		ArrayList<Customer> jAccounts = new ArrayList<Customer>();
		int count = 1;

		for (Customer x : temp) {
			if (x.getjBankID() == this.bankID) {
				jAccounts.add(x);
				System.out.println("[" + count + "]" + "-" + x.username + "...." + x.funds);
				count++;

			}
		}

		if (jAccounts.size() == 0) {
			System.out.println("You currently have no open joint accounts.");
			MainDriver.promptContinue();
			customerPrompt();
			
		} else {
			Scanner sc = new Scanner(System.in);
			System.out.println("Which account would you like to transfer funds?");
			int input = sc.nextInt();
			Customer z = jAccounts.get(input - 1);
			moveMoney(z);

		}
	}

	public void moveMoney(Customer x) {
		System.out.println("Current Account balance...." + this.getFunds());
		System.out.println(" Account balance...." + x.getFunds());

		System.out.println("[1] Transfer to Joint Account");
		System.out.println("[2] Transfer from Joint Account");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		switch (input) {
		case 1:
			System.out.println("Please enter outgoing transfer amount: ");
			double trans = sc.nextDouble();
			if (this.getFunds() < trans) {
				System.out.println("Insufficient funds.");
				moveMoney(x);
			} else {
				this.funds -= trans;
				x.funds += trans;

				MainDriver.cDAO.updateCustomer(x);
				MainDriver.cDAO.updateCustomer(this);

				System.out.println("Transfer successfuly made.");
				System.out.println("New Account Balance...." + this.funds);
				System.out.println("Joint Account Balance...." + x.getFunds());

				MainDriver.promptContinue();
				customerPrompt();

			}
			break;
		case 2:
			System.out.println("Please enter incoming transfer amount: ");
			double intrans = sc.nextDouble();
			if (x.getFunds() < intrans) {
				System.out.println("Insufficient funds.");
				moveMoney(x);
			} else {
				Loggy.info("Outgoing transfer made.");
				this.funds += intrans;
				x.funds -= intrans;

				MainDriver.cDAO.updateCustomer(x); // SQL!!
				MainDriver.cDAO.updateCustomer(this);

				System.out.println("Transfer successfuly made.");
				System.out.println("New Account Balance  ...." + this.funds);
				System.out.println("Joint Account Balance...." + x.getFunds());
				MainDriver.promptContinue();
				customerPrompt();

			}
			break;
		}

	}

	public void depositFunds(double x) {
		this.funds += x;
		System.out.println("Deposited .... $" + x);
		System.out.println("New Balance .... $" + this.funds);
		MainDriver.cDAO.updateCustomer(this); // SQL!!

	}

	public void withdrawFunds(double x) {
		Scanner sc = new Scanner(System.in);

		if ((this.funds - x) >= 0) {
			this.funds -= x;
			System.out.println("Dispensing .... " + x);
			System.out.println("Your new balance is .... $" + this.funds);
			MainDriver.cDAO.updateCustomer(this);

		} else {
			System.err.println("Insufficient funds.");

		}
	}
}
