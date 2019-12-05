package com.users;

public class FinanceManager extends Users {

	public FinanceManager() {
		// TODO Auto-generated constructor stub
	}

	public FinanceManager(String firstName, String lastName, String userName, String password, String email,
			int userID, int userRole) {
		super(firstName, lastName, userName, password, email, userID, userRole);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean userLogin() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void viewTickets() {
		//logic to view all tickets
	}
	
	public void aproveTickets() {
		//logic to approve Tickets
	}
	
	public void denyTickets() {
		//logic to deny tickets
	}

	public void filterTickets() {
		//logic to filter tickets
	}
}
