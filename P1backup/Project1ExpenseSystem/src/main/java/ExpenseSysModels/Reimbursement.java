package ExpenseSysModels;

import java.util.Date;

public class Reimbursement {
	int reimbID;
	double amount;
	java.sql.Date submitted;
	java.sql.Date resolved;
	String description;
	int author;
	int resolver;
	int status;
	int type;
	
	public Reimbursement(int rID, double amt, java.sql.Date sub, java.sql.Date resd, String desc, int auth,
			int resr, int sts, int typ) {
		this.reimbID = rID;
		this.amount = amt;
		this.submitted = sub;
		this.resolved = resd;
		this.description = desc;
		this.author = auth;
		this.resolver = resr;
		this.status = sts;
		this.type = typ;
	}
	public int getReimbID() {
		return reimbID;
	}
	public void setReimbID(int reimbID) {
		this.reimbID = reimbID;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public java.sql.Date getSubmitted() {
		return submitted;
	}
	public void setSubmitted(java.sql.Date submitted) {
		this.submitted = submitted;
	}
	public java.sql.Date getResolved() {
		return resolved;
	}
	public void setResolved(java.sql.Date resolved) {
		this.resolved = resolved;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public int getResolver() {
		return resolver;
	}
	public void setResolver(int resolver) {
		this.resolver = resolver;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Reimbursement [reimbID=" + reimbID + ", amount=" + amount + ", submitted=" + submitted + ", resolved="
				+ resolved + ", description=" + description + ", author=" + author + ", resolver=" + resolver
				+ ", status=" + status + ", type=" + type + "]";
	}
	
	
}
