package com.project1.model;

public class Reimbursement {
	public enum typeExpense {
	    LODGING, TRAVEL, FOOD, OTHER; 
	}
	public enum typeStatus {
	    PENDING, APPROVED, DENIED;
	}
	
	private typeExpense expense;
	private typeStatus status;
	private double amount;
	private String description;
	private String imageData;

	public typeExpense getExpense() {
		return expense;
	}

	public void setExpense(typeExpense expense) {
		this.expense = expense;
	}

	public String getImageData() {
		return imageData;
	}

	public void setImageData(String imageData) {
		this.imageData = imageData;
	}

	public typeStatus getStatus() {
		return status;
	}

	public void setStatus(typeStatus status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
