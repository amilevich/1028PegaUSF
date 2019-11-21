package Q10MinOf2Num;

import java.util.Scanner;

public class MinOf2 {
	//Find the minimum of two numbers using ternary operators.
	
	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter an integer:");
		int n1 = sc.nextInt();
		
		System.out.println("Please enter another integer:");
		int n2 = sc.nextInt();

		int max = n1 >= n2 ? n1 : n2;
		
		System.out.println("Between "+n1+" and "+n2+", the larger number is: "+max+".");
	}
}
