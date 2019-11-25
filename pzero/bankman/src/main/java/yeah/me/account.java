package yeah.me;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Scanner;

public class account implements Serializable {
	
	private static final long serialVersionUID = 676;
	
	private double balance=0;
	private String id;
	private String username;
	private String password;
	private String cusna;
	private int Status =0;


	public int getStatus() {
		return Status;
	}






	public account(double balance, String id, String username, String password, String cusna, int status) {
		super();
		this.balance = balance;
		this.id = id;
		this.username = username;
		this.password = password;
		this.cusna = cusna;
		this.Status = status;
	}






	public account(double balance, String id, String username, String password, String cusna) {
		super();
		this.balance = balance;
		this.id = id;
		this.username = username;
		this.password = password;
		this.cusna = cusna;
		
	}



	


	public account() {
		// TODO Auto-generated constructor stub
	}






	public account(String cusna, String username, String password) {
		super();
		this.cusna = cusna;
		this.username = username;
		this.password = password;
		
	}






	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getCusna() {
		return cusna;
	}

	public void setCusna(String cusna) {
		this.cusna = cusna;
	}



	@Override
	public String toString() {
		return "account [balance=" + balance + ", id=" + id + ", username=" + username + ", password=" + password
				+ ", cusna=" + cusna + ", Status= " + Status;
	}






	public void setStatus(int status) {
		this.Status = status;
	}





//
//	public void setStatus() {
//		// TODO Auto-generated method stub
//		this.getStatus();
//	}






//	public int customerOptions(account r) {
//		// TODO Auto-generated method stub
//		return 0;
//	}






	
	

		
		
}	


