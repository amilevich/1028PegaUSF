package davidvallejo.hw.javacore;

public class Question15MathC implements Question15MathI{
	@Override
	public double addition(double x, double y) {
		return x+y;//implementing math methods that will be implemented as a Interface
	}

	@Override
	public double division(double x, double y) {
		return x/y;
	}

	@Override
	public double subtraction(double x, double y) {
		return x-y;
	}

	@Override
	public double multiplication(double x, double y) {//using doubles to hold the variables and use decimals
		return x*y;
	}
}
