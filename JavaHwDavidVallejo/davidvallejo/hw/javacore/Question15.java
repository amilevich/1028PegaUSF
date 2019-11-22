package davidvallejo.hw.javacore;

import java.util.Scanner;

/*
 * 
 * Question 15: Write a program that defines an interface having the following methods:
 * addition, subtraction, multiplication, and division. Create a class that implements
 * this interface and provides apprtempriate functionality to carry out the required
 * temperations. Hard code two temperands in a test class having a main method that
 * calls the implementing class.
 * 
 */
public class Question15 {
	public static void main(String[] args) {
		Question15MathC test = new Question15MathC();
		String x, y, z;
		String temp;
	    double tempNum = 0;
	    tempNum=tempNum +0;
		while (true) {
			System.out.println("Please enter first value: ");
			Scanner sc = new Scanner(System.in);
			while (true) {
				x = sc.nextLine();
				try {
					tempNum = Double.valueOf(x);
				} catch (Exception e) {
					System.out.println("Entered value must be a number");
					continue;
				}
				break;
			}
			while (true) {
				System.out.println("Please enter Operand: +, -, *, / ");
				temp = sc.nextLine();
				if ((temp.equals("+")) || (temp.equals("-")) || (temp.equals("*")) || (temp.equals("/"))) {
					break;
				}
			}
			System.out.println("Please enter second value: ");
			y = sc.nextLine();
			while (true) {
				try {
					tempNum = Double.valueOf(y);
				} catch (Exception e) {
					System.out.println("Entered value must be a number");
					continue;
				}
				break;
			}
			switch (temp) {
			case "+":
				System.out
						.println("Answer: " + x + temp + y + " = " + test.addition(Double.valueOf(x), Double.valueOf(y)));
				break;
			case "-":
				System.out.println(
						"Answer: " + x + temp + y + " = " + test.subtraction(Double.valueOf(x), Double.valueOf(y)));
				break;
			case "*":
				System.out.println(
						"Answer: " + x + temp + y + " = " + test.multiplication(Double.valueOf(x), Double.valueOf(y)));
				break;
			case "/":
				System.out
						.println("Answer: " + x + temp + y + " = " + test.division(Double.valueOf(x), Double.valueOf(y)));
				break;
			}
			System.out.println("-----------------------------------");
			System.out.println("Calculate something else?");
			System.out.println("type yes or no");
			z = sc.nextLine();
			if((z.equals("yes"))||(z.equals("y"))||(z.equals("1"))) {
               Question15.main(args);//calling the start of the class over else closing scanner and breaking out of lotemp
			}else {
		    System.out.println("Ok great have  a good one");
		    sc.close();
			break;
			}
		}
	}
}
