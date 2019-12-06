package com.project1.model;

public class Reimbursement {
	/*
	public enum typeExpense {
	    LODGING, TRAVEL, FOOD, OTHER; 
	}
	public enum typeStatus {
	    PENDING, APPROVED, DENIED;
	}
	*/
	private String expense;
	private String status;
	private double amount;
	private String description;
	private String imageData;
	private String dateSubmitted;
	private String dateResolved;
	
	public String getExpense() {
		return expense;
	}

	public void setExpense(String expense) {
		this.expense = expense;
	}

	public String getImageData() {
		return imageData;
	}

	public void setImageData(String imageData) {
		this.imageData = imageData;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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
}
