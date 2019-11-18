package com.project.bankAccount;

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
	private String m_accountName;
	private String m_password;
	private String m_firstName;
	private String m_lastName;
	private int m_accountNum;
	
	private final static int customer = 0;
	private final static int employee = 1;
	private final static int admin = 2;

	public String getFirstName() {
		return m_firstName;
	}

	public void setFirstName(String _firstName) {
		this.m_firstName = _firstName;
	}

	public String getLastName() {
		return m_lastName;
	}

	public void setLastName(String _lastName) {
		this.m_lastName = _lastName;
	}

	public User()
	{
		m_userType = -1;
		m_accountName = new String("");
		m_password = new String("");
		m_firstName = new String("");
		m_lastName = new String("");
		m_accountNum = -1;
	}
	
	public User(String _name, String _password, int _type, String _fName, String _lName)
	{
		m_userType = (byte)_type;
		m_accountName = new String(_name);
		m_password = new String(_password);
		m_firstName = new String(_fName);
		m_lastName = new String(_lName);
		m_accountNum = -1;
	}

	public User(String _name, String _password, int _type, String _fName, String _lName, int _number)
	{
		m_userType = (byte)_type;
		m_accountName = new String(_name);
		m_password = new String(_password);
		m_firstName = new String(_fName);
		m_lastName = new String(_lName);
		m_accountNum = _number;
	}
	
	public static int getCustomerCode()
	{
		return customer;
	}
	
	public static int getEmployeeCode()
	{
		return employee;
	}
	
	public static int getAdminCode()
	{
		return admin;
	}
	
	public int getUserType()
	{
		return m_userType;
	}
	
	public String getAccountName()
	{
		return m_accountName;
	}
	
	public String getPassword()
	{
		return m_password;
	}
	
	
	public int getAccountNumber()
	{
		return m_accountNum;
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
	
	public void setName(String _name)
	{
		m_accountName = _name;
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
}
