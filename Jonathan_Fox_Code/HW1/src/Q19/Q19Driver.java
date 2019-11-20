package Q19;

import java.util.ArrayList;

public class Q19Driver {

	// Create an ArrayList and insert integers 1 through 10. Display the ArrayList.
	// Add all the even numbers up and display the result. Add all the odd numbers
	// up and display the result. Remove the prime numbers from the ArrayList and
	// print out the remaining ArrayList.
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		int sum = 0;
		
		for(int i = 1; i <= 10; i++) a.add(i);
		
		System.out.printf("%s\n", a.toString());
		
		//iterate through a, adding all even elements to sum
		for(int i = 0; i < a.size(); i++) if((a.get(i)&1) != 1) sum += a.get(i);
		
		System.out.printf("Sum of evens: %d\n", sum);
		
		sum = 0;
		//iterate through a, adding all odd elements to sum
		for(int i = 0; i < a.size(); i++) if((a.get(i)&1) == 1) sum += a.get(i);
		
		System.out.printf("Sum of odds: %d\n", sum);
		
		//iterate through a, removing primes
		for(int i = 0; i < a.size(); i++) {
			//call isPrime method from Q9
			if(Q9.Q9Driver.isPrime(a.get(i))){
				a.remove(i);
				i--;
			}
		}
		
		System.out.printf("Removed primes: %s\n", a.toString());

	}

}
