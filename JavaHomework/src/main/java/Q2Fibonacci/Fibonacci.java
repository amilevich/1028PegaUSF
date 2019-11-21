package Q2Fibonacci;

public class Fibonacci {

	public static int n1 = 0, n2 = 1;
	
	public static void main(String[] args) {
		
		System.out.print("Fibonacci Sequence: "+n1+" "+n2);
		printFib(23);

	}
	

	public static void printFib(int count) {

		if (count > 0) {
			int n3 = n1+n2;
			n1=n2;
			n2=n3;
			System.out.print(" "+n3);
			printFib(--count);
		}
	}
}
