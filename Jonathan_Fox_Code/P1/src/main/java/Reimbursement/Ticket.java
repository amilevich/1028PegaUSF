package Reimbursement;

import java.sql.Timestamp;

public class Ticket {
	private int status;
	private double amount;
	private String email, description;
	private byte type;
	private Timestamp time;
	
	public Ticket(String e, double a, String d, byte t, Timestamp ts) throws InstantiationException {
		if(e == null || e.equals("")) throw new InstantiationException("needs email");
		else email = e;

		if(a <= 0) throw new InstantiationException("invalid amount");
		else amount = a;
		
		if(d == null || d.equals("")) throw new InstantiationException("needs description");
		else description = d;
		
		if(t < 0 || t > 3) throw new InstantiationException("invalid type");
		else type = t;
		
		if(ts == null) throw new InstantiationException("needs timestamp");
		else time = ts;
		
		status = 0;
	}
	
	public byte getType() { return type; }
	public String getEmail() { return email; }
	public String getDesc() { return description; }
	public int getStatus() { return status; }
	public double getAmount() { return amount; }
	public Timestamp getTime() { return time; }
	
	public boolean approve() {
		if(status == 0) {
			status = 1;
			return true;
		} else return false;
	}
	
	public boolean deny() {
		if(status == 0) {
			status = -1;
			return true;
		} else return false;
	}
	
	public boolean equals(Ticket t) {
		if(t.getType() != type) return false;
		if(!t.getEmail().equals(email)) return false;
		if(!t.getDesc().equals(description)) return false;
		if(t.getStatus() != status) return false;
		if(t.getAmount() != amount) return false;
		if(!t.getTime().equals(time)) return false;
		return true;
	}

}
