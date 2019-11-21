package com.example.homework;

import java.io.IOException;

import com.example.homework.q15.*;
import com.example.homework.q18.Q18;

public class MainDriver {

	static int factorial;

	public static void main(String[] args) {
		Q1 q1 = new Q1();
		Q2 q2 = new Q2();
		Q3 q3 = new Q3();
		Q4 q4 = new Q4();
		Q5 q5 = new Q5();
		Q6 q6 = new Q6();
		Q7 q7 = new Q7();
		Q8 q8 = new Q8();
		Q9 q9 = new Q9();
		Q10 q10 = new Q10();
		Q11 q11 = new Q11();
		Q12 q12 = new Q12();
		Q13 q13 = new Q13();
		Q14 q14 = new Q14();
		// In Package
		// Command Line Arguments
		Q17 q17 = new Q17();
		Q18 q18 = new Q18();
		Q19 q19 = new Q19();
		Q20 q20 = new Q20();
		
		q1.bubbleSort();
		q2.fibonacciSequence();
		q3.reverseString("Reverse Me");
		System.out.println("\nFactorial equals " + q4.factorial(5));
		q5.subString("Hello World", 5);
		q6.evenOrOdd(-2);
		q7.sortEmployees();
		q8.palindromeCheck();
		q9.printPrimeNumbers();
		q10.ternaryMin(10 , 15);
		q11.accessFloats();
		q12.printEven();
		q13.printTriangle();
		// input 1,2,3 for sqrt, date, string array
		q14.switchCase(2);
		// Q15 In Package
		q17.calculateInterest();
		q18.question18();
		q19.arrayListManipulation();;
		
		try {
			q20.prettyPrint();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
