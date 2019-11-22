package com.homework.Q19;

import java.util.ArrayList;

public class nineteen {
	
	static ArrayList<Integer> num = new ArrayList<>(10);

	public static void main(String[] args) {
		
		for(int i=0; i < 10; i++) {
			num.add(i+1);
		}
		System.out.println(num);
		int even = 0;
		int odd = 0;
		
		for(int j=0; j < num.size(); j++) {
			/// checkif the number is even
			if(num.get(j) % 2 ==0) {
				even += num.get(j);
			}// checks if the number is odd
			else if(num.get(j) % 2 !=0) {
				odd += num.get(j);
			}
			
		}
		
		System.out.println("Even number sum: " + even);
		System.out.println("odd number sum: " + odd);

	}

}
