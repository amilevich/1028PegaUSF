package com.project.Reimburse;

public class Reimburse {
	
	private int reimbId;// re
	private int reimAmt;// Reimbursement Amount
	private int reimSub;//TODO change type 
	private int reimResod;//TODO change type
	private String reimDes;
	private String reimRec;// TODO change type
	private int reimAuth;
	private int reimResor;
	private int reimStatusId;
	private int reimTypeId;

	
	public int getReimbId() {
		return reimbId;
	}
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}
	public int getReimAmt() {
		return reimAmt;
	}
	public void setReimAmt(int reimAmt) {
		this.reimAmt = reimAmt;
	}
	public String getReimDes() {
		return reimDes;
	}
	public void setReimDes(String reimDes) {
		this.reimDes = reimDes;
	}
	public int getReimAuth() {
		return reimAuth;
	}
	public void setReimAuth(int reimAuth) {
		this.reimAuth = reimAuth;
	}
	public int getReimResor() {
		return reimResor;
	}
	public void setReimResor(int reimResor) {
		this.reimResor = reimResor;
	}
	public int getReimStatusId() {
		return reimStatusId;
	}
	public void setReimStatusId(int reimStatusId) {
		this.reimStatusId = reimStatusId;
	}
	public int getReimTypeId() {
		return reimTypeId;
	}
	public void setReimTypeId(int reimTypeId) {
		this.reimTypeId = reimTypeId;
	}
	
	
	
	public int reimgetype() {
		return reimAmt;
		
	}
	

}
