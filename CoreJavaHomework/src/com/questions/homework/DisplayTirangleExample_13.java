package com.questions.homework;

public class DisplayTirangleExample_13 {

	public static void main(String[] args) {
		
		int n = 0;
		int q = 1;
		int m = 0;
		while(n < 9) {// #Needed for triangle
			
			while(m < n) {
				System.out.print(q + " ");//Space out properly
				q = q== 0 ? 1 : 0;//Ternary operator to alternate 1 / 0 system.out
				m++;
			}
			System.out.println(" ");//Space out properly
			n++;
			m = 0;
		}

	}

}
