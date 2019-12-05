package com.example.entitys;

import java.sql.Blob;
import java.sql.Timestamp;

public class Reimburstment {
	
	private int id;
	private float amount;
	private Timestamp submit;
	private Timestamp resolved;
	private String description;
	private Blob receipt;
	private User resolver;
	private Status status;
	private Type type;
	private User user;
	
	public Reimburstment() {
		super();
	}

	public Reimburstment(int id, float amount, Timestamp submit, Timestamp resolved, String description, Blob receipt,
			User resolver, Status status, Type type, User user) {
		super();
		this.id = id;
		this.amount = amount;
		this.submit = submit;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Timestamp getSubmit() {
		return submit;
	}

	public void setSubmit(Timestamp submit) {
		this.submit = submit;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Blob getReceipt() {
		return receipt;
	}

	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
	}

	public User getResolver() {
		return resolver;
	}

	public void setResolver(User resolver) {
		this.resolver = resolver;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Reimburstment [id=" + id + ", amount=" + amount + ", submit=" + submit + ", resolved=" + resolved
				+ ", description=" + description + ", receipt=" + receipt + ", resolver=" + resolver + ", status="
				+ status + ", type=" + type + ", user=" + user + "]";
	}
	
	
	
	
	

}
