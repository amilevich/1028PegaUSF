package com.profiles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import com.Methods.Methods;
import com.accounts.Accounts;

import bankinterfaces.CommonInterfaces;

public class Customers implements Serializable {
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private int social;
	private ArrayList<Integer> accounts;
	boolean isJoint;
	private String secondUser;
	private int secondSocial;
	public Customers() {
		// TODO Auto-generated constructor stub
	}
	
	public Customers(String userName, String password, String firstName, String lastName, int social, boolean isJoint,
			String secondUser, int secondSocial) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.social = social;
		this.isJoint = isJoint;
		this.secondUser = secondUser;
		this.secondSocial = secondSocial;
		this.accounts= new ArrayList<Integer>();
	}

	public Customers(String userName, String password, String firstName, String lastName, int social, boolean isJoint) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.social = social;
		this.isJoint = isJoint;
		this.accounts= new ArrayList<Integer>();
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

	public int getSocial() {
		return social;
	}

	public void setSocial(int social) {
		this.social = social;
	}

	public ArrayList<Integer> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Integer> accounts) {
		this.accounts = accounts;
	}

	public boolean isJoint() {
		return isJoint;
	}

	public void setJoint(boolean isJoint) {
		this.isJoint = isJoint;
	}

	public String getSecondUser() {
		return secondUser;
	}

	public void setSecondUser(String secondUser) {
		this.secondUser = secondUser;
	}

	public int getSecondSocial() {
		return secondSocial;
	}

	public void setSecondSocial(int secondSocial) {
		this.secondSocial = secondSocial;
	}

	@Override
	public String toString() {
		return "Customers [userName=" + userName + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", social=" + social + ", isJoint=" + isJoint + ", secondUser=" + secondUser
				+ ", secondSocial=" + secondSocial + "]";
	}


	
	
	
	
}
