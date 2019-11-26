package part2;

import java.io.Serializable;

//import java.util.Random;

enum Status {Pending, Approved, Denied, Cancelled}

public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4856508116730843309L;
	private static int lastAcctNum = 5;
	private int acctNum;
	private double balance;
	private Status status;		//possible status options: Pending, Approved, Denied, Cancelled
	
	public Account() {
		this.status = Status.Pending;	//presets the status of all new accounts to pending prior to receiving approval
	}
	
	public Account(int a) {
			this.status = Status.Pending;
			this.acctNum = a;
	}

	public Account(int aNum, double bal, Status s) {
		this.acctNum = aNum;
		this.balance = bal;
		this.status = s;
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public int getAcctNum () {
		return this.acctNum;
	}
	
	public void makeDeposit(double dep) {
		this.balance += dep;
		System.out.println("The deposit of $"+dep+" into account "+this.acctNum+" was successful.");
	}
	public void makeWithdrawal(double with) {
		if (this.balance > with){
			this.balance -= with;
			System.out.println("The withdrawal of $"+with+" from account "+this.acctNum+" was successful.");
		}else {
			System.out.println("Withdrawal failed: Insufficient funds.");
		}
	}
//	public static int generateAcctNum() { //will now be done by SQL sequence
//		lastAcctNum+=3;
//		return lastAcctNum;
//	}
/*	public static int generateAcctNum() {
		int r;
		do {
			Random rand = new Random();
			r = rand.nextInt();
		} while (checkAcctNum(r));
		return r;
	}
	public static boolean checkAcctNum(int i) {
		if () { //account number i does not already exist, return true
			return true;
		}else return false;
	}*/
}
