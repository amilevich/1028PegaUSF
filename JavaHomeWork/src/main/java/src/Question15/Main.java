package src.Question15;
/*
 * Write a program that defines an interface having the following methods: addition, subtraction, multiplication, and division.  
 * Create a class that implements this interface and provides appropriate functionality to carry out the required operations. 
 * Hard code two operands in a test class having a main method that calls the implementing class.
 */
public class Main {
	
	 public static void main(String[] args) {

	        TestInterface calculator = new TestInterface();
	        double operand1 = 6;
	        double operand2= 8;

	        System.out.println("Numbers are: "+operand1+ " and " +operand2);
	        System.out.println("Addition: "+ calculator.addition(operand1,operand2));
	        System.out.println("Subtraction: "+ calculator.subtraction(operand1,operand2));
	        System.out.println("Multiplication: "+ calculator.multiplication(operand1,operand2));
	        System.out.println("Division: "+ calculator.division(operand1,operand2));
	    }
}
