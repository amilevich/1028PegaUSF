package Q12;

public class Q12Driver {

	//Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. Use the enhanced FOR loop for printing out the numbers.
	public static void main(String[] args) {
		int[] a = new int[100];
		
		//store 1-100 in a
		for(int i = 0; i < 100; i++) a[i] = i+1;
		
		//for all i in a, if i is even, print it
		for(int i : a) if((i & 0x00000001) == 0) System.out.printf("%d ", i);
		System.out.printf("\n");
	}

}
