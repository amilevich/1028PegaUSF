package com.app.main;

import java.io.Serializable;

public class Customer implements Serializable{
	String userName;
	String userPin;
	String Name;
	
	@Override
	public String toString() {
		return "Customer [userName=" + userName + ", userPin=" + userPin + ", Name=" + Name + "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPin() {
		return userPin;
	}
	public void setUserPin(String userPin) {
		this.userPin = userPin;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	
	
}
