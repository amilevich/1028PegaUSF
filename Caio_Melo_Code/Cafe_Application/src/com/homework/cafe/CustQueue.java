package com.homework.cafe;

import java.util.LinkedList;
import java.util.Queue;

public class CustQueue { //holds a linkedList and has a toSring();
	

	Queue<Order> customerQueue = new LinkedList<Order>();
	
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
