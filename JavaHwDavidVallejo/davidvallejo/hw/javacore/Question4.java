package davidvallejo.hw.javacore;
/*
 * 
 * Question 4: Write a program to compute N factorial.
 * 
 * In mathematics, the factorial of a positive integer n
 * denoted by n!
 * It's the product of all positive integers less than or equal to n
 * 
 */

public class Question4 {
		public static int z = 2; //z is holding the variable that will be checked for even or odd

		public static void main(String[] args) {

			System.out.println(factorial(3));
			System.out.println(factorial(14));
			System.out.println(factorial(99)); 

		}

		public static int factorial(int f) {
			
			if (f < 2) {
				if (z % 2 == 0) {
					return 1;
				} else {
					return -1;
				}
			} else {
				return factorial(f - 1) * f;//returns the factorial
			}
		}
}
