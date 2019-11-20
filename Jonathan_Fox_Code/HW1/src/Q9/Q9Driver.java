package Q9;

import java.util.ArrayList;

public class Q9Driver {

	//Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
	public static void main(String[] args) {
		ArrayList<Integer> ai = new ArrayList<Integer>();
		
		for(int i = 1; i <= 100; i++) {
			if(isPrime(i)) System.out.printf("%d ", i);
			ai.add(i);
		}
		
		System.out.printf("\n");
	}
	
	public static boolean isPrime(int n) {
		//check if all numbers from 2 to n/2 evenly divide n. if any do, n is not prime
		for(int i = 2; i <= n/2; i++) if((n%i) == 0) return false;
		return true;
	}
}
