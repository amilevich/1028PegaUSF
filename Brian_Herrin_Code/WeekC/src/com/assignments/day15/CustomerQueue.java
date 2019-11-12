package com.assignments.day15;

import java.util.LinkedList;
import java.util.Queue;

public class CustomerQueue {
	private Queue<Customer> line = new LinkedList<>();
	public Object getQueue() {
		// TODO Auto-generated method stub
		return null;
	}
//  mimics a line of customers coming up to the cashier to order food and receive their order.
	public Queue<Customer> getLine() {
		return line;
	}
	public void addCustomer(Customer newCustomer) {
		line.add(newCustomer);
	}
	public void setLine(Queue<Customer> line) {
		this.line = line;
	}
	public Customer getCustomerHead() {
		return line.element();
	}
	public void printHeadCustomerName() {
		System.out.println(line.element().getName());
	}
	public String toStringHeadCustomerName() {
		return line.element().getName();
	}
	public String toStringHeadCustomerOrder() {
		return line.element().getOrderString();
	}
	public void printCustomerNames() {
		printHeadCustomerName();
		System.out.println(line.size());
	}
}
