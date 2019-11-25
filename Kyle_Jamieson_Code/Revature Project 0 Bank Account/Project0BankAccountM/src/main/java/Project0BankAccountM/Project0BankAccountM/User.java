package Project0BankAccountM.Project0BankAccountM;

import java.io.Serializable;

public class User implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6782824563497034985L;
	
	/*
	 *  Costumer = 0
	 *  employee = 1
	 *  admin	 = 2
	 */
	private byte m_userType;
	private String m_userName;
	private String m_password;
	private String m_firstName;
	private String m_lastName;
	private int m_accountNum;
	
	private final static int customer = 0;
	private final static int employee = 1;
	private final static int admin = 2;

	public User()
	{
		m_userType = -1;
		m_userName = "";
		m_password = "";
		m_firstName = "";
		m_lastName = "";
		m_accountNum = -1;
	}
	
	public User(String _name, String _password, int _type, String _fName, String _lName)
	{
		m_userType = (byte)_type;
		m_userName = new String(_name);
		m_password = new String(_password);
		m_firstName = new String(_fName);
		m_lastName = new String(_lName);
		m_accountNum = -1;
	}

	public User(String _name, String _password, int _type, String _fName, String _lName, int _number)
	{
		m_userType = (byte)_type;
		m_userName = new String(_name);
		m_password = new String(_password);
		m_firstName = new String(_fName);
		m_lastName = new String(_lName);
		m_accountNum = _number;
	}
	
	// get the type code for customer users
	public static int getCustomerCode()
	{
		return customer;
	}
	
	// get the type code for employee users
	public static int getEmployeeCode()
	{
		return employee;
	}
	
	// get the type code for admin users
	public static int getAdminCode()
	{
		return admin;
	}
	
	public int getUserType()
	{
		return m_userType;
	}
	
	public String getUserName()
	{
		return m_userName;
	}
	
	public String getPassword()
	{
		return m_password;
	}
	
	
	public int getAccountNumber()
	{
		return m_accountNum;
	}

	public String getFirstName() 
	{
		return m_firstName;
	}
	public String getLastName() 
	{
		return m_lastName;
	}

	public void setFirstName(String _firstName) 
	{
		this.m_firstName = _firstName;
	}

	public boolean isAdmin()
	{
		return admin == m_userType;
	}
	
	public boolean isEmployee()
	{
		return employee == m_userType;
	}
	
	public boolean isCustomer()
	{
		return customer == m_userType;
	}
	
	public void setUserType(int _newType)
	{
		// check if admin
		m_userType = (byte)_newType;
	}
	
	public void setUserName(String _name)
	{
		m_userName = _name;
	}
	
	public void setPassword(String _password)
	{
		m_password = _password;
	}
	public void setAccountNumber(int _number)
	{
		if(_number > 0)
			m_accountNum = _number;
	}

	public void setLastName(String _lastName) 
	{
		this.m_lastName = _lastName;
	}


}
