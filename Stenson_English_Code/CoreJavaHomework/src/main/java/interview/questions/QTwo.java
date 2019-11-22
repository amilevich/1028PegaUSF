package interview.questions;

public class QTwo {

	public static void main(String[] args) {
		fibonacci(25);
	}

	public static int n1 = 0, n2 = 1;

	public static void fibonacci(int count) {
		if (count > 0) { // && means both conditions must be met
			int n3 = n1 + n2; // n3 = 1 n3 = 3
			n1 = n2; // n1 = 1 n1 = 2
			n2 = n3; // n2 = 2 n2 = 3
			System.out.print(" " + n3);
			fibonacci(count - 1);
		}

	}
}
