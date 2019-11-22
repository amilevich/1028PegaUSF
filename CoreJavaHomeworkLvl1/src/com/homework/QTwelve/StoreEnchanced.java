package com.homework.QTwelve;

public class StoreEnchanced {

	public static void main(String[] args) {
		
		int values[] = new int[100];
		
		System.out.println("These values are all the values from 1 to 100 that are even: ");
		
		for( int i : values) {
			
			values[i] +=1;
			
				if (values[i] % 2 == 0) {
					System.out.print(values[i]+ " ");
				}
		}
	}

}
