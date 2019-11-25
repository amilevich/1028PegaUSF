package com.project0.model;

//import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class User implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id = 0;
	private Set<Integer> accountId = new HashSet<Integer>();
	private String userName, password, firstName, lastName;
	//private Set<User> associates;

	public User() {
		this.setUserName("DebugMan");
		this.setPassword("");
		this.setFirstName("Debug");
		this.setLastName("Man");
	}

	public User(String userName, String password) {
		this.setUserName(userName);
		this.setPassword(password);
		this.setFirstName("");
		this.setLastName("");
	}
	public User(String userName, String password, String firstName, String lastName) {
		this.setUserName(userName);
		this.setPassword(password);
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}
	public User(Set<Integer> idAccount, String userName, String password, String firstName, String lastName) {
		this.setIdAccount(idAccount);
		this.setUserName(userName);
		this.setPassword(password);
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

	public Set<Integer> getIdAccount() {
		return accountId;
	}
	
	public void setIdAccount(Set<Integer> accountId) {
		this.accountId = accountId;
	}

	public void addAllIdAccount(Set<Integer> accountId) {
		this.accountId.addAll(accountId);
	}
	
	public void addIdAccount(Integer accountId) {
		this.accountId.add(accountId);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFields(String userName, String password, String firstName, String lastName) {
		this.setUserName(userName);
		this.setPassword(password);
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

	public void setFields(String userName, String password) {
		this.setUserName(userName);
		this.setPassword(password);
		this.setFirstName("");
		this.setLastName("");
	}

	public static void serializeUsername(String name) {
		System.out.println("User serializeUsername");
	}

	public static void serializePassword() {
		System.out.println("User serializePassword");
	}

	public static String deserializeUsername() {
		System.out.println("User deserializeUsername");
		return "";
	}

	public String deserializePassword() {
		System.out.println("User deserializePassword");
		return "";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFullName() {
		return " " + getFirstName() + " " + getLastName();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void transfer(double input, Account output, Account output1) {
		// TODO Auto-generated method stub
		
	}
}
