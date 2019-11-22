package homework1;

import java.util.Scanner;

public class Interest {
	public void interest() {
		//Declare the variables
		double principal;
		int time;
		double rate;
		double Interest;
		//create scanner object
		Scanner scanner = new Scanner(System.in);
		System.out.println("****question 17 the interest rate*********");
		System.out.println("enter principal: ");
		principal =scanner.nextDouble();
		System.out.println("enter rate: ");
		rate = scanner.nextDouble();
		System.out.println("enter time");
		time=scanner.nextInt();
		//calculate the interest
		Interest=principal*rate*time;
		//display the result
		System.out.println("The interest rate will be: " + Interest);
		
		
	}

}
