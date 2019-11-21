package Q19ArrListEvenOdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class ArrListEvenOdd {

	public static void main(String[] args) {
		/*
		 * Create an ArrayList and insert integers 1 through 10. 
		 * Display the ArrayList. Add all the even numbers up and display the result. 
		 * Add all the odd numbers up and display the result. 
		 * Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
		 */
		
		int e = 0; 
		int o = 0;
		int i;
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		ArrayList<Integer> arrMinusPrime = new ArrayList<Integer>();
		
		System.out.print("The original Array List is: ");
		
		ListIterator<Integer> iterator = arr.listIterator();
		while(iterator.hasNext()) {
			i = iterator.next();
			if (i%2==0)
				e+=i;
			else o+=i;
			System.out.print(" "+i);
			if(!isPrime(i)) {
				arrMinusPrime.add(i);
			}	
		}
		
		System.out.println("\n\nThe sum of all the even numbers is: "+e);
		System.out.println("\nThe sum of all the odd numbers is:  "+o);
		
		System.out.print("\nThe non-prime numbers in the array are: ");
		ListIterator<Integer> it = arrMinusPrime.listIterator();
		while(it.hasNext()) {
			i = it.next();
			System.out.print(" "+i);	
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
