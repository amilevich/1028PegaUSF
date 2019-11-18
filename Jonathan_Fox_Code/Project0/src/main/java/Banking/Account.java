package Banking;

import java.io.Serializable;
import java.util.HashSet;


public class Account implements Serializable {
	private static final long serialVersionUID = 6037947808820551502L;
	private int id;
	private double money;
	private boolean approved;
	private HashSet<String> usernames;
	
	//FOR SERIALIZATION. DO NOT USE
	Account(){}
	
	public Account(int i){
		id = i;
		money = 0;
		approved = false;
		usernames = new HashSet<String>(0);
	}
	
	public boolean addUser(String u) {
		if(usernames.contains(u)) {
			System.out.printf("Account is already linked to this user.\n");
			return false;
		}

		return usernames.add(u);
	}
	
	public boolean removeUser(String u) {
		if(usernames.contains(u)) return usernames.remove(u);
		
		System.out.printf("User \"%s\" is not linked to account %d.\n", u, id);
		return false;
	}
	
	public HashSet<String> getUsers(){ return usernames; }
	
	public double getBalance() { return money; }
	
	public boolean deposit(double m) {
		if(!isApproved()) {
			System.out.printf("Account %d is not approved.\n", id);
			return false;
		}
		
		if(m < 0.0) {
			System.out.printf("You cannot deposit negative CBucks.\n");
			return false;
		}
				
		if(money + m >= money) {
			money += m;
			return true;
		}
		
		System.out.printf("That's too much money.\n");
		return false;
	}
	
	public boolean withdraw(double m) {
		if(!isApproved()) {
			System.out.printf("Account %d is not approved.\n", id);
			return false;
		}
		
		if(m < 0.0) {
			System.out.printf("You cannot withdraw negative CBucks.\n");
			return false;
		}
		
		if(m == 0.0) System.out.printf("Withdrawing 0 CBucks is a waste of processing power.\n");
		
		if(m > money) {
			System.out.printf("You cannot withdraw more money than you have.\n");
			return false;
		}
		
		money -= m;
		return true;
	}
	
	public int getID() { return id; }
	//public void setID(int i) { id = i; }
	
	public void approve() { 
		if(approved) System.out.printf("Account already approved.\n");
		else System.out.printf("Account %d approved.\n", id);
		approved = true; 
	}
	
	public boolean isApproved() { return approved; }
	
	public void print() {
		System.out.printf("====Account %d====\n"
				+ "CBucks: %f\n"
				+ "Approved: %s\n"
				+ "Users:", id, money, (approved ? "Yes" : "No"));
		
		for(String u : usernames) System.out.printf(" %s", u);
		
		System.out.printf("\n====\n");
	}
}
