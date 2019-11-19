package com.homework.HW1;

/*
 * Print all even numbers from array using enhanced for-loop.
 */
public class Q12_Array {
	public static void main(String[] args) {
		
		arrayPrint();
		
	}
	public static void arrayPrint() {
		int[] numbers = new int[99];
		int count = 1;
		for(int x:numbers) {
			
			numbers[count-1] = count;
			count++;
			if (count%2 == 0) {
				System.out.println(count);
			}
			
		}
	}

}
