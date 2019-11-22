package com.traingle;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class DisplayTraingle {
	public static void main(String[] args) {

	
		
		makeTraingle();

	}


	public static void makeTraingle() {
		
		 Deque<Integer> deque = new LinkedList<Integer>(); 
		 
		 deque.add(0);
		 System.out.println(deque.toString().replace(",", " ").replace("[", "").replace("]", ""));
		 Integer temp0 = new Integer(0);
		 
		 int count = 0;
		 for(int i = 0; i<20; i++) {
			
			 if(count>=0&&count<=1) {
				 deque.addFirst(1);
				 count++;
				 System.out.println(deque.toString().replace(",", " ").replace("[", "").replace("]", ""));
			 }else if(count>=2&&count<=3) {
				 deque.addFirst(0);
				 count++;
				 System.out.println(deque.toString().replace(",", " ").replace("[", "").replace("]", ""));
			 }else {
				 count=0;
			 }
			 
		 }
		
	}
}
