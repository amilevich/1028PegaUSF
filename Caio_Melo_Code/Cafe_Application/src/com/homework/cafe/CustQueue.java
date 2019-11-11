package com.homework.cafe;

import java.util.LinkedList;

public class CustQueue {

	LinkedList<Order> customerQueue = new LinkedList<Order>();
	
	public String toString() {
		String z = "";
		int temp = 1;
		
		for(Order x:customerQueue) {
			z += "["+temp+"]" + x.toString() + ",";
			temp++;
		}
		return z;
	}
}
