package problem4;

public class Solution {

	
	public static int factorial(int N) {
		int total = 1;
		for (int i=1; i<=N; i++) {
			total *= i; 
		}
		return total; 
	}
	
	public static void main(String[] args) {
		System.out.println(factorial(4));
		System.out.println(factorial(3));
		System.out.println(factorial(2));
	}
}
