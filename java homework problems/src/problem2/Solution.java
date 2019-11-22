package problem2;

public class Solution {
	
	public static void main(String[] args) {
		fib(25);
	}
	static void fib(int n) {
		int sum = 0;
		int a = 0;
		int b = 1;
		for (int i=0; i<n; i++) {
			sum = a + b;
			a = b;
			b = sum;		
			System.out.println(a);
		}
	}
	
	
	
}
