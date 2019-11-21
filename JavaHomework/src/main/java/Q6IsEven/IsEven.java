package Q6IsEven;

import java.util.Scanner;

public class IsEven {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an integer to determine if it is even:");
		int num = sc.nextInt();
		int n;		//allows the for loop to use the absolute value of num
		
		if(num<0) {			//determines if the number is negative and switches
			n=num*-1;		//it to positive for the loop to function properly
		}else n=num;
		
		for (int i=n;i>=0;i-=2) {
			if (i==1) {
				System.out.println("The number "+num+" is ODD.");
			}else if (i==0) {
				System.out.println("The number "+num+" is EVEN.");
			}
		}
	}
}

