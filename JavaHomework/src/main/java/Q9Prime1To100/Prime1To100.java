package Q9Prime1To100;

import java.util.ArrayList;
import java.util.ListIterator;

public class Prime1To100 {
	//Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.

	public static void main(String[] args) {
		
		ArrayList<Integer> al = new ArrayList<>();
		int count=1;		//setting a counter to help insert a new line in the middle of the original array for a cleaner console display

		//populate the array list with 1-100
		for (int i=1; i<101; i++) {
			al.add(i);
		}
		
		//print original ArrayList
		System.out.println("Displaying the original ArrayList with all #'s 1-100:");
		ListIterator<Integer> iterator = al.listIterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
			count++;
			if (count==53) System.out.println();
		}
		
		System.out.println("\n\nPrimes between 1 and 100:");
		for(int i=0; i<al.size(); i++) {
			//check for prime
			if(isPrime((al.get(i)))) {				//call method to check for prime
				System.out.print(al.get(i)+" ");
			}
		}
	}
	
	static boolean isPrime(int n) {
	    //check if n is a multiple of 2 which removes the need to check for any other even number
	    if (n%2==0) return false;
	    //if not, then just check the odds up to the square root of the number in question
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
}
