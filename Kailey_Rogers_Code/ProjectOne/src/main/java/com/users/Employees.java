package com.users;

public class Employees extends Users {
	
	public Employees() {
		// TODO Auto-generated constructor stub
	}

	public Employees(String firstName, String lastName, String userName, String password, String email, int userID,
			int userRole) {
		super(firstName, lastName, userName, password, email, userID, userRole);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean userLogin() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void viewPastTickets() {
		//logic to view past tickets
	}
	
	public void addNewTickets() {
		//logic to add new ticket
	}

}
