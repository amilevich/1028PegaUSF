package part2;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client extends Person implements Clnt {
	
	String username = new String();
	String password = new String();
	ArrayList<Integer> accounts = new ArrayList<Integer>();
	
	public Client(String f, String l, String dob, String a) {
		super();
	}
	
	public Client (String f, String l, Date dob, String a, String u, String p, int acc) {
		super(f, l, dob, a);
		this.username = u;
		this.password = p;
		this.accounts.add(acc);
	}
	
	public Client() {

	}

	public Client(String username, String pass, String first, String last, Date dob, String add) {
		this.username = username;
		this.password = pass;
		this.nameFirst = first;
		this.nameLast = last;
		this.setDoB(dob);
		this.setAddress(add);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String getName() {
		return this.nameFirst +" "+ this.nameLast;
	}

	public ArrayList<Integer> getAccounts() {
		return accounts;
	}

	public void setAccounts(int i) {
		this.accounts.add(i);
	}

	public void register() {
		boolean used = true;
		String un=" ";
		String p=" ";
		Scanner sc = new Scanner(System.in);
		while(used) {
			//take in user name
			System.out.println("What would you like your username to be?");
			un = sc.nextLine();
			//check to see it isn't used
			ClientDaoImp clientDaoImp = new ClientDaoImp();
			Client c = clientDaoImp.selectClntByUserName(un);
			if(c.equals(null)) {	//test if the user name is unique
				used=false;			//if unique, allow loop to exit
			}else {
				System.out.println("That user name is unavailable.");
			}
		}
		System.out.println("What would you like your password to be?");
		p = sc.nextLine();
		this.setUsername(un);			//set the username and password for the client
		this.setPassword(p);

		//check to see if the password is secure enough if time permits
	}

	@Override
	public void withdraw(double amt, Account acct) {
		acct.makeWithdrawal(amt);
	}

	@Override
	public void deposit(double amt, Account acct) {
		acct.makeDeposit(amt);
	}


	@Override
	public void viewAcct(Account acctNum) {
		
	}

	@Override
	public String toString() {
		String s = "";
		for(int i = 0;i<accounts.size();i++) {
			s.concat(Integer.toString((accounts.get(i)))+", ");
		}
		return "Client [username=" + username + ", accounts=" + s + ", getName()=" + getName()
				+ ", getDateOfBirth()=" + getDateOfBirth() + ", getAddress()=" + getAddress() + "]";
	}

	public static Date setLocalDoB(int y, int m, int d) {
		LocalDate localDate = LocalDate.of(y, m, d);
		Date date = java.sql.Date.valueOf(localDate);
		return date; 
		
		
	}
	
	
}
