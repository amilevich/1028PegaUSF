package com.assignment1;

import java.util.ArrayList;


public class Q19 {
	public static ArrayList<Integer> listOfNumbers = new ArrayList<>();
	
	public static void displayList() {
		for (int i = 1;i<11;i++) {
			listOfNumbers.add(i);
		}
		System.out.println(listOfNumbers);
	}
	
	public static void addEvenNumbers() {
		int sum = 0; //even addition
		
		for(int i =1; i<listOfNumbers.size();i += 2) {
			sum += listOfNumbers.get(i);
		}
		
		System.out.println(sum + " even sum");
	}
	
	public static void addOddNumbers() {
		int sum = 0; //even addition
		
		for(int i =0; i<listOfNumbers.size();i += 2) {
			sum += listOfNumbers.get(i);
		}
		
		System.out.println(sum + " odd sum");
	}
	
	public static void removePrime() {
		ArrayList<Integer> removeNumbers = new ArrayList<Integer>();
		
		for(int i:listOfNumbers) {
			for(int j = 2;j <= i/2;j++) {
				if(i%j == 0) {
					removeNumbers.add(i);
					break;
				}
			}
		}
		System.out.println(removeNumbers);
	}
	
	public static void main(String[] args) {
		displayList();
		addEvenNumbers();
		addOddNumbers();
		removePrime();
		
	}

}
