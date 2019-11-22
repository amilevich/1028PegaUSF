package davidvallejo.hw.javacore;
/*
 * 
 * Question 11: Write a program that would access two float-variables from a class that
 * exists in another package. Note, you will need to create two packages to
 * demonstrate the solution.
 * 
 */
import JavaPackage2.Question11.question11_2;

public class Question11 extends question11_2{
	public static void main(String[] args) {
		System.out.println("Float A is: " + a);
		System.out.println("Float B is: " + b);
	}
}
