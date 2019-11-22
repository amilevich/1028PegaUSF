package com.questions.homework;

import java.util.ArrayList;
import java.util.List;

public class EvenForLoopExample_12 {
	static List<Integer> nums = new ArrayList<Integer>();

	public static void main(String[] args) {
		
		for(int i = 1; i <= 100; i++) {//set range
			nums.add(i);
		}
		findEven();
		
	}

	public static void findEven() {
		
		for(Integer e : nums) {
			if(e % 2 == 0) {//if number constantly divided by to equals 0, it is even
				System.out.println(e);
			}
			
		}
	}


}
