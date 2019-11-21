package src.Question10;
/*
 * Find the minimum of two numbers using ternary operators.
 */

public class MyClass {
	public static void main(String[] args) {

		int val1 = 96;
		int val2 = 30;
		System.out.println("The minimum value of " + val1 + " and " + val2 + " is: ");
		int minVal = (val1 < val2) ? val1 : val2;
		System.out.println(minVal);
	}
}
