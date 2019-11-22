package davidvallejo.hw.javacore;
/*
 * 
 * Question 2: Write a program to display the first 25 Fibonacci numbers beginning at 0.
 * 
 */

public class Question2 {
	public static int a = 0, b = 1, c = a + b; 
	// initializing static variables at the top of the class
	//

	public static void main(String[] args) {
		System.out.print("The Fibonacci: \n");
		System.out.print(a + " \n" + b + "");
		fib(25);//calling the fibonacci sequence
	}

	public static int fib(int temp) {
		if (temp > 0) {
			c = a + b;
			System.out.print("\n" + c + " ");
			
			a = b;
			b = c;
			return fib(temp - 1);
		} else {
			return 0;
		}
	}

}
