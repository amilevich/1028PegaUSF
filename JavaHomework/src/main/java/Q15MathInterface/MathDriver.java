package Q15MathInterface;

public class MathDriver {

	public static void main(String[] args) {
		int a = 20;
		int b = 4;
		MathFromInterface obj = new MathFromInterface();
		
		System.out.println("\nThe operands are: "+a+" and "+b+"\n");
		
		System.out.println("Addition: \t\t"+obj.addition(a, b));
		System.out.println("Subtraction: \t\t"+obj.subtraction(a, b));
		System.out.println("Multiplication: \t"+obj.multiplication(a, b));
		System.out.println("Division: \t\t"+obj.division(a, b));
		
	}

}
