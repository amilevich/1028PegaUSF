package interview.questions;

public class QSix {
	
	/*
	 * Write a program to determine if an integer is even without using the modulus operator (%)
	 */

	public static void main(String[] args) {
		isEven(-5);
	}
	
	public static void isEven(int n) {
		if((n/2)*2 == n ) {
			System.out.println("even");
		}else {
			System.out.println("odd");
		}
	}

}
