package interview.questions;

import java.util.ArrayList;

public class QNineteen {
	
		public static void main(String[] args) {
			
			displayList();
		}
		public static boolean isPrime(int x) {
			
			for(int i=2;i<x;i++) {
				
				if(x%i == 0) {
					return false;
				}
			}
			return true;
		}

		static void displayList() {
			/*
			 * Add all evens and display result
			 * Add all ods and display result
			 * Remove prime numbers from the arraylist and print out arraylist
			 */
			ArrayList<Integer> evensNOdds = new ArrayList<Integer>();
			int totalEvens = 0;
			int totalOdds = 0;
			for(int i = 1; i<=10 ;i++) {
				System.out.print(i + " ");
				if(!(isPrime(i))) {
					evensNOdds.add(i);
				}
			}
			System.out.println();
			for(int j =0;j<11;j++) {
				if (j%2 == 0) {
					totalEvens+=j;
				}
				else {
					totalOdds+=j;
				}
			}
			System.out.println();
			System.out.println("Sum of all evens: " + totalEvens);
			System.out.println();
			System.out.println("Sum of all odds: " + totalOdds);
			System.out.println();
			System.out.println("Without primes: ");
			for(int x:evensNOdds) {
				System.out.print(x + " ");
			}
			
		}
		}

