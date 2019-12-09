package com.project1.model;

import java.util.List;

public class SessionData {
	private Users user;
	private List<Reimbursement> reimbursements;
	
	public SessionData(){
		
	}
	public SessionData(Users user, List<Reimbursement> reimbursements){
		this.user = user;
		this.reimbursements = reimbursements;
	}
	
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public List<Reimbursement> getReimbursements() {
		return reimbursements;
	}
	public void setReimbursements(List<Reimbursement> reimbursements) {
		this.reimbursements = reimbursements;
	} 
}
