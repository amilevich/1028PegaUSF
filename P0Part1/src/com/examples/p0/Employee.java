package com.examples.p0;

public class Employee extends User{
		Bank bank;

		public Employee(String fullName, String userName, String password) {
			super(fullName, userName, password);
		}

		public String getUserName() {
			return userName;
		}

		public String getPassword() {
			return password;
		}
	}