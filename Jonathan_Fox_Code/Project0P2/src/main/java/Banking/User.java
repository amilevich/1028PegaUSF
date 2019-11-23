package Banking;

import java.io.Serializable;
import java.util.HashSet;


public class User implements Serializable {
	private static final long serialVersionUID = -7887242644915445362L;
	private byte type;
	private String username, personalInfo, hashPass;
	private HashSet<Integer> accounts;
	
	public static final byte ADMIN = (byte)0x02;
	public static final byte EMPLOYEE = (byte)0x01;
	public static final byte USER = (byte)0x00;
	
	//FOR SERIALIZATION. DO NOT USE
	User(){}
	
	public User(byte t, String u, String Hpass) throws InstantiationException {
		accounts = new HashSet<Integer>(0);
		
		if(t < 0 || t > 2) {
			System.out.printf("Improper user type.\n");
			throw new InstantiationException();
		}
		
		try {
			Double.valueOf(u);
			System.out.printf("Usernames cannot be numbers.\n");
			throw new InstantiationException();
		}
		catch(NumberFormatException e) { }
		
		type = t;
		username = u;
		hashPass = Hpass;
	}
	
	//Returns user's type as a string
	public String typeString() {
		switch(type) {
		case USER: return "User";
		case EMPLOYEE: return "Employee";
		case ADMIN: return "Admin";
		default:
			System.out.printf("Invalid type.\n");
			return null;
		}
	}
	
	public boolean addAccount(int a) { return accounts.add(a); }
	public boolean removeAccount(int a) { return accounts.remove(a); }
	public HashSet<Integer> getAccounts() { return accounts; }
	
	public String getUsername() { return username; }
	
	public String getInfo() { return personalInfo; }
	public void setInfo(String info) { personalInfo = info; }
	
	public byte getType() { return type; }
	
	public String getPass() { return hashPass; }
	public boolean login(String p) {
		if(hashPass.equals(p)) return true;
		return false;
	}
	
	public void print() {
		System.out.printf("====%s: %s====\n"
				+ "Personal Info: %s\n"
				+ "accounts:", this.typeString(), username, personalInfo);
		
		for(int i : accounts) System.out.printf(" %d", i);
		
		System.out.printf("\n====\n");
		
	}
}
