package com.reimbursement;

public class Reimbursement {
	int reimbId;
	float reimbAmt;
	String reimbursementSubmitted;
	String reimbursementResolved;
	String reimbDesc;
	String reimbReceipt;
	int reimbAuthor;
	int reimbResolver;
	int reimbStatusId;
	int reimbTypeId;
	public Reimbursement() {
		// TODO Auto-generated constructor stub
	}
	public Reimbursement(int reimbId, float reimbAmt, String reimbursementSubmitted, String reimbursementResolved,
			String reimbDesc, String reimbReceipt, int reimbAuthor, int reimbResolver, int reimbStatusId,
			int reimbTypeId) {
		super();
		this.reimbId = reimbId;
		this.reimbAmt = reimbAmt;
		this.reimbursementSubmitted = reimbursementSubmitted;
		this.reimbursementResolved = reimbursementResolved;
		this.reimbDesc = reimbDesc;
		this.reimbReceipt = reimbReceipt;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatusId = reimbStatusId;
		this.reimbTypeId = reimbTypeId;
	}
	public int getReimbId() {
		return reimbId;
	}
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}
	public float getReimbAmt() {
		return reimbAmt;
	}
	public void setReimbAmt(float reimbAmt) {
		this.reimbAmt = reimbAmt;
	}
	public String getReimbursementSubmitted() {
		return reimbursementSubmitted;
	}
	public void setReimbursementSubmitted(String reimbursementSubmitted) {
		this.reimbursementSubmitted = reimbursementSubmitted;
	}
	public String getReimbursementResolved() {
		return reimbursementResolved;
	}
	public void setReimbursementResolved(String reimbursementResolved) {
		this.reimbursementResolved = reimbursementResolved;
	}
	public String getReimbDesc() {
		return reimbDesc;
	}
	public void setReimbDesc(String reimbDesc) {
		this.reimbDesc = reimbDesc;
	}
	public String getReimbReceipt() {
		return reimbReceipt;
	}
	public void setReimbReceipt(String reimbReceipt) {
		this.reimbReceipt = reimbReceipt;
	}
	public int getReimbAuthor() {
		return reimbAuthor;
	}
	public void setReimbAuthor(int reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}
	public int getReimbResolver() {
		return reimbResolver;
	}
	public void setReimbResolver(int reimbResolver) {
		this.reimbResolver = reimbResolver;
	}
	public int getReimbStatusId() {
		return reimbStatusId;
	}
	public void setReimbStatusId(int reimbStatusId) {
		this.reimbStatusId = reimbStatusId;
	}
	public int getReimbTypeId() {
		return reimbTypeId;
	}
	public void setReimbTypeId(int reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}
	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", reimbAmt=" + reimbAmt + ", reimbursementSubmitted="
				+ reimbursementSubmitted + ", reimbursementResolved=" + reimbursementResolved + ", reimbDesc="
				+ reimbDesc + ", reimbReceipt=" + reimbReceipt + ", reimbAuthor=" + reimbAuthor + ", reimbResolver="
				+ reimbResolver + ", reimbStatusId=" + reimbStatusId + ", reimbTypeId=" + reimbTypeId + "]";
	}
	
}