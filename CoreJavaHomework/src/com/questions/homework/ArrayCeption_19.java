package com.questions.homework;

import java.util.ArrayList;

public class ArrayCeption_19 {
	
	static ArrayList<Integer> nums = new ArrayList<>();
	static ArrayList<Integer> removeNums = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		printNums();
		remove();
		getEvens();
		addOddNumbers();
		
	}
	
	public static void printNums() {
		
		for (int i = 1; i <= 10; i++) {//Setting initial range
			nums.add(i);
		}
		System.out.println(nums);
	}
	public static void remove() {
		
		for(int i : nums) {//Remove the primes
			for(int x = 2;x <= i / 2; x++) {
				if(i % x == 0) {// modulus
					removeNums.add(i);
					break;
				}
			}
		}
		System.out.println(removeNums);
	}
	
	public static void getEvens() {
		
		int sum = 0;
		for(int i =1; i < nums.size(); i += 2) {// starting at 1, go through arraylist, iterate twice to add sum
			sum += nums.get(i);
		}
		System.out.println("Even total:" +sum);
	}
	
	public static void addOddNumbers() {
		
		int sum = 0; 
		for(int i =0; i < nums.size();i += 2) {// starting at 0, go through arraylist, iterate twice to add sum
			sum += nums.get(i);
		}
		System.out.println("Odd total:" +sum);
	}
	
	
}

