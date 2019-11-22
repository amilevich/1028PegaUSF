package firsthw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class quest19 {
	
	
	public static void main(String[] args) {
		int ev = 0; 
		int od = 0;
		int i;
		ArrayList<Integer> all = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		ArrayList<Integer> notPrime = new ArrayList<Integer>();
		
		ListIterator<Integer> iterator = all.listIterator();
		while(iterator.hasNext()) {
			i = iterator.next();
			if (i%2==0)
				ev+=i;
			else od+=i;
			if(!isPrime(i)) {
				notPrime.add(i);
			}	
		}
		
		System.out.println("The sum of the even numbers is: "+ev);
		System.out.println("The sum of the odd numbers is:  "+od);
		System.out.print("non-prime numbers are: ");
		ListIterator<Integer> it = notPrime.listIterator();
		while(it.hasNext()) {
			i = it.next();
			System.out.print(" "+i);	
		}	
	}
	
	static boolean isPrime(int n) {
	    
	    if (n%2==0&&n>2) return false;
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
		
	}


