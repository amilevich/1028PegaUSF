package homework1;

import java.util.ArrayList;

public class PrimeNumber {
	
	public void  primeNumber() {
		//create a arraylist
		ArrayList<Integer>num = new ArrayList<Integer>();
		for(int i=1; i<=100; i++) {
			num.add(i);
			
			}
		//validate for not prime
		for(int i = 0; i<num.size(); i++) {
			if(!isPrime(num.get(i))) {
				num.remove(num.get(i));
				i--;
			
		}
		}System.out.println("************these are the prime numbers**************");
		System.out.println(num);
			
	}
	//validate for prime
	public static boolean isPrime(int x) {
		boolean itIs=true;
		for(int i = 2; i<x; i++) {
			if(x%i==0) {
				itIs=false;
				
			}
		}return itIs;
	}
	}


