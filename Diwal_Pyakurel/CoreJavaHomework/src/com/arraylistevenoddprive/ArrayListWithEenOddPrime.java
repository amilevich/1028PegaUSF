package com.arraylistevenoddprive;

import java.util.ArrayList;

public class ArrayListWithEenOddPrime {

	public static void main(String[] args) {
		//pass the number till where you want to display number, add even/odd and remove prime
		checkNumbers(97);
	}

	public static void checkNumbers(int n) {
		//list to hold all numbers
		ArrayList<Integer> al = new ArrayList<>();
		//add numbes in the list
		for (int i = 0; i < n; i++) {
			al.add(i+1);
		}
		
		System.out.println("All the numbers from 1 to "+ n+" "+ al);
		//holds even and odd sum
		int evenSum = 0;
		int oddSum = 0;

		//calculates the even or odd sum
		for (int i = 0; i < al.size(); i++) {
			if (al.get(i) % 2 == 0) {
				evenSum += al.get(i);

			} else {
				oddSum += al.get(i);

			}
		}
		
		System.out.println("Even Number Sum: "+ evenSum);
		System.out.println("Even Number Sum: "+ oddSum);
		
		//second temp arraylist to hold the prime number
		ArrayList<Integer> tempArrayList = new ArrayList<Integer>();
		

		//passing prime number into temp array list
		for(int i =0; i<al.size(); i++) {
			int count=0;
			for(int j=0; j<al.size(); j++) {

				if(al.get(i)%al.get(j)==0) {
					count++;
				}
				
			}
			if(count==2) {
				
				tempArrayList.add(al.get(i));
				
			}
		}
		//deleting all prime from main array list
		al.removeAll(tempArrayList);

		System.out.println("All non prime numbers from 1 to "+ n+ " " +al);

	}

}
