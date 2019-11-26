package part2;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class Employee extends Person implements Emp{


	String empUserName;
	String empPassword;
	int admin;
	
	
	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

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
	
	public Employee(String un, String pass, String f, String l, Date date, String a, int ad) {
		super(f, l, date, a);
		this.empUserName = un;
		this.empPassword = pass;
		this.admin = ad;
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
