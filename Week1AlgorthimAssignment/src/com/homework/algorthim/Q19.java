package com.homework.algorthim;

import java.util.ArrayList;
import java.util.Iterator;

public class Q19 {
	ArrayList<Integer> odd = new ArrayList<Integer>();
	ArrayList<Integer> even = new ArrayList<Integer>();
	ArrayList<Integer> normal = new ArrayList<Integer>();
	
	public void stuff() {
		 int i = 1;
		
		while(i <=10){
			normal.add(i);
			if(i % 2 == 0) {
				even.add(i);
			} else if(i % 2 !=0) {
				odd.add(i);
			} 
			i++;
		}
		System.out.println("Normal " + normal);
		Iterator itr = normal.iterator();
		while(itr.hasNext()) {
			int j = (int) itr.next();
			if(j == 2 || j == 3 || j == 5 || j == 7){
				itr.remove();
				
			}
			
		}
		System.out.println("Even " + even);
		System.out.println("Odd " + odd);
		System.out.println("not..Prime " + normal);
	}
	
}
