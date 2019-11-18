package part1;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee extends Person implements Emp, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1687980901937290358L;
	int empID;
	String empUserName;
	String empPassword;
	
	public String getEmpUserName() {
		return empUserName;
	}

	public void setEmpUserName(String empUserName) {
		this.empUserName = empUserName;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	
	public Employee(String f, String l, LocalDate dob, String a) {
		
	}
	
	public Employee(String f, String l, LocalDate dob, String a, int eID, String userName, String pass) {
		super(f, l, dob, a);
		this.empID = eID;
		this.empUserName = userName;
		this.empPassword = pass;
	}
	
	public Employee() {
		super();
	}

	@Override
	public void viewAccount(Account a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewClient(Client c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewApps() {
		// view account information
		//offer menu for: approve, deny, exit
		
	}
}
