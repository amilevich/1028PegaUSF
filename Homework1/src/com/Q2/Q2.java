package com.Q2;

public class Q2 {
	//Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0.
	
		 static void fibonacci(int n){
			 System.out.print("25 Fibonacci numbers: ");
			 int n1=0;
			 int n2=1;
			 int count = 1;
			 while(count <=n) { 
				System.out.print(n1 + " ");
				int n3 = n1 + n2;
				n1 = n2;
				n2 = n3; 
				count++;
			}
			System.out.println();
		}
	public static void main(String[] args) {
		fibonacci(25);
		
	}

}
