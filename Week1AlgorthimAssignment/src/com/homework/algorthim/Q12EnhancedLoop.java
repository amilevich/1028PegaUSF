package com.homework.algorthim;

import java.util.ArrayList;

public class Q12EnhancedLoop {
	ArrayList<Integer> evenNum = new ArrayList<Integer>();

	public void enhancedLoop() {
		
		for(int i = 0; i<=100; i++) {
			evenNum.add(i);
		}
//		System.out.println(evenNum);
		
		for(int n : evenNum) {
			if(n  %  2 == 0) {
				System.out.println(n);	
			}
		}
	}
	
	
	
//	public void enhancedLoop() {
//		int n =100;
//		int[] arr = new int[n];
//		
//		for(int i = 0; i < arr.length; i++) {
//			if(i  %  2 == 1) {
//				arr[i] = i+1;
//				System.out.println(arr[i]);				
//			}else {
//				System.out.println("odd");
//			}
//			
//		}
//	}
}