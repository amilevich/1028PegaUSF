//package
package bankapp;
//import
import java.io.Serializable;
import java.util.logging.Logger;


public class currUserAccount implements Serializable{
	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
/*
	public static Logger getUserlog() {
		return userlog;
	}
*/
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
//	public static java.util.logging.Logger getLogger() {
	//	return userlog;
//	}
	//public final static Logger userlog = Logger.log(Logger.class);
	//logging in when the user logs into the main menu


	/**
	 * serializes the currUserAccount object
	 */
	static final long serialVersionUID = -1953226906380021677L;//serializing the account and info
	private String name;
	//PRIVATE STRING
	private String password;
	//PRIVATE STRING FOR PASSWORD
	private String accountID;
	//PRIVATE STRING FOR ACCOUNTID
	private Double balance;
	//PRIVATE DOUBLE TO HOLD THE BALANCE
	
	public currUserAccount(String name, String password, String accountID, Double balance) {
		super();//
		this.name = name;//getting the name of the current user in the object
		this.password = password;//getting the password of the current user in the object
		this.accountID = accountID;//getting the accountID of the current user in the object
		this.balance = balance;//getting the balance of the current user in the object
	}

	@Override//toString method
	public String toString() {
		return "currUserAccount [name=" + name + ", accountID=" + accountID + ", balance=" + balance + "]";
	}
//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getaccountID() {
		return accountID;
	}

	public void setaccountID(String accountID) {
		this.accountID = accountID;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String currUserAccount() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	

}
