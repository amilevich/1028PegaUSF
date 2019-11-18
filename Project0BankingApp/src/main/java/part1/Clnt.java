package part1;

public interface Clnt {
	
	void withdraw(double amt, Account acct);
	
	void deposit(double amt, Account acct);
	
	void viewAcct(Account acctNum);
	
}
