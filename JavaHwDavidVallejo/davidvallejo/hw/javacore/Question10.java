package davidvallejo.hw.javacore;
/*
 * 
 * Question 10: Find the minimum of two numbers using ternary operators.
 * 
 */
public class Question10 {
	public static void main(String[] args) {
		int a = 20, b = 21;
		ternary(a, b);
		
		a = 99;
		b = 33;
		ternary(a, b);
		
	}

	public static void ternary(int x, int y) {
		int temp = (x < y) ? x : y;//using the ternary operators
		System.out.println(temp);
	}
}
