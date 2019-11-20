package Q15;

public class Q15Driver {
	// Write a program that defines an interface having the following methods:
	// addition, subtraction, multiplication, and division. Create a class that
	// implements this interface and provides appropriate functionality to carry out
	// the required operations. Hard code two operands in a test class having a main
	// method that calls the implementing class.
	public static void main(String[] args) {
		double x = 15;
		double y = 5;
		mathstuff m = new mathstuff();
		
		System.out.printf("%f\n", m.add(x, y));
		System.out.printf("%f\n", m.subtract(x, y));
		System.out.printf("%f\n", m.mult(x, y));
		System.out.printf("%f\n", m.divide(x, y));
		
	}
	
	interface mathInterface{
		abstract double add(double x, double y);
		abstract double subtract(double x, double y);
		abstract double mult(double x, double y);
		abstract double divide(double x, double y);
	}
	
	public static class mathstuff implements mathInterface{
		@Override
		public double add(double x, double y) { return x+y; }

		@Override
		public double subtract(double x, double y) { return x-y; }

		@Override
		public double mult(double x, double y) { return x*y; }

		@Override
		public double divide(double x, double y) { return x/y; }
	}

}
