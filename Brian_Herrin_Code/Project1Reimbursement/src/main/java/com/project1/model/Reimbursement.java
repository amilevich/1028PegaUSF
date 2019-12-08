package com.project1.model;

import java.sql.Blob;
import java.sql.Timestamp;

//import oracle.sql.TIMESTAMP;

public class Reimbursement {
	/*
	public enum typeExpense {
	    LODGING, TRAVEL, FOOD, OTHER; 
	}
	public enum typeStatus {
	    PENDING, APPROVED, DENIED;
	}
	*/
	private int id;
	private double amount;
	private Timestamp dateSubmitted;
	private Timestamp dateResolved;
	private String description;
	private Blob receipt;
	private int employeeId;
	private int managerId;
	private int statusId;
	private int typeId;
	
	// Resolved, with all values
	public Reimbursement(int id, double amount, Timestamp submitted, Timestamp resolved, String description, Blob receipt, int author, int resolver, int status, int typeId) {
		 setId(id);
		 setAmount(amount); 
		 setDateSubmitted(submitted);
		 setDateResolved(resolved);
		 setDescription(description);
		 setReceipt(receipt);
		 setEmployeeId(author);
		 setManagerId(resolver);
		 setStatusId(status);
		 setTypeId(typeId);
	}
	// Resolved, but no receipt
	public Reimbursement(int id, double amount, Timestamp submitted, Timestamp resolved, String description, int author, int resolver, int status, int typeId) {
		 setId(id);
		 setAmount(amount); 
		 setDateSubmitted(submitted);
		 setDateResolved(resolved);
		 setDescription(description);
		 setEmployeeId(author);
		 setManagerId(resolver);
		 setStatusId(status);
		 setTypeId(typeId);
	}
	// Pending, doesn't have resolver or resolved timestamp
	public Reimbursement(int id, double amount, Timestamp submitted, String description, Blob receipt, int author, int status, int typeId) {
		 setId(id);
		 setAmount(amount); 
		 setDateSubmitted(submitted);
		 setDescription(description);
		 setReceipt(receipt);
		 setEmployeeId(author);
		 setStatusId(status);
		 setTypeId(typeId);
	}
	// Pending, no receipt no resolver & timestamp-resolved
	public Reimbursement(int id, double amount, Timestamp submitted, String description, int author, int status, int typeId) {
		 setId(id);
		 setAmount(amount); 
		 setDateSubmitted(submitted);
		 setDescription(description);
		 setEmployeeId(author);
		 setStatusId(status);
		 setTypeId(typeId);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public Timestamp getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(Timestamp dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public Timestamp getDateResolved() {
		return dateResolved;
	}

	public void setDateResolved(Timestamp dateResolved) {
		this.dateResolved = dateResolved;
	}
	
	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int id) {
		this.typeId = id;
	}

	public Blob getReceipt() {
		return receipt;
	}

	public void setReceipt(Blob imageData) {
		this.receipt = imageData;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int status) {
		this.statusId = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
}
