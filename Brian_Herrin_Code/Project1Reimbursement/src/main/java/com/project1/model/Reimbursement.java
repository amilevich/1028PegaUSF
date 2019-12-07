package com.project1.model;

import java.sql.Blob;

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
	private String dateSubmitted;
	private String dateResolved;
	private String description;
	private Blob receipt;
	private int employeeId;
	private int managerId;
	private int statusId;
	private int typeId;
	
	public Reimbursement(int id, double amount, String submitted, String resolved, String description, Blob receipt, int author, int resolver, int status, int typeId) {
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
	
	public String getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(String dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public String getDateResolved() {
		return dateResolved;
	}

	public void setDateResolved(String dateResolved) {
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
