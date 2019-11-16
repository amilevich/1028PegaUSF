package com.example.Junit;

public class Junit {

	public int checkAmount(String x) {
		double amount = 0;
		try {
			amount = Double.valueOf(x);
		} catch (Exception e) {
			//System.out.println("\t\t\tInvalid. Input must be an number");
			return 0;
		}
		if (amount < 0) { // checks if non-negative value used
			return 0;
		} else {
			return 1;
		}
	}
	
	

	
}
