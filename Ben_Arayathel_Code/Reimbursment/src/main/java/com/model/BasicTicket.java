package com.model;

public class BasicTicket {
	
	String price;
	String ttype;
	String desc;
	
	public BasicTicket() {
		
	}
	
	public BasicTicket(String price, String ttype, String desc) {
		super();
		this.price = price;
		this.ttype = ttype;
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "BasicTicket [price=" + price + ", ttype=" + ttype + ", desc=" + desc + "]";
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTtype() {
		return ttype;
	}

	public void setTtype(String ttype) {
		this.ttype = ttype;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
	

}
