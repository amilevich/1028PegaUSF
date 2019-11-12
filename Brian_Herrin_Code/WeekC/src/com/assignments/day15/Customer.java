package com.assignments.day15;

public class Customer {
	private String name; 
	private Order order;
	
	public Customer() {
		name = ""; 
		order = new Order();
	}
	public Customer(String newName, Order newOrder) {
		this.name = newName;
		this.order = newOrder;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Order getOrder() {
		return order;
	}
	public String getOrderString() {
		return order.toString();
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public String toString() {
		return name + ":" + order.toString();
	}
}
