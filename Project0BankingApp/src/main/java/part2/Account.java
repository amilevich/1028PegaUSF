package part2;

enum Status {Pending, Approved, Denied, Cancelled}

public class Account {

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
	
	@Override
	public String toString() {
		return "Account [Account Number= " + acctNum + ", Balance= " + balance + ", Status= " + status + "]";
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
}
