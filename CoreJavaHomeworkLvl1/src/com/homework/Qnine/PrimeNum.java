package com.homework.Qnine;

import java.util.ArrayList;

public class PrimeNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> findP = new ArrayList<Integer>();
		
		for(int i = 0; i <= 100; i++) {
			findP.add(i);
		}
		
			
		
		for(int j = 0; j < findP.size(); j++) {
			boolean temp= isPrime(findP.get(j));
			if(temp == true) {
				System.out.print(findP.get(j)  + " ");
			}
			
			
		}
		
		

	}
// checks for prime number and returns if it is true only
	public static boolean isPrime(int n) {
		
		if (n <= 1)  return false;  
	    if (n <= 3)  return true;  
	    
	   //
	    if (n%2 == 0 || n%3 == 0) return false;  
	    
	    for (int i=5; i*i<=n; i=i+6)  
	        if (n%i == 0 || n%(i+2) == 0)  
	           return false;  
	    
	    return true;  
	}
}
