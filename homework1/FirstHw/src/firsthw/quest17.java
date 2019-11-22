package firsthw;

import java.util.Scanner;
public class quest17 {
	
	
	public static void main(String[] args) {
		Scanner mo = new Scanner(System.in);
		
		System.out.println("what is the principal");
		int prin = mo.nextInt();
		
		 System.out.println("what is the rate?");
		 double rate =  mo.nextDouble();
		
		 System.out.println("what is the time frame?");
		 int time =  mo.nextInt();
		 
		 System.out.println("your interest is $" +prin*rate*time/100);
		
		
		
	}

}
