package Q15MathInterface;

public class MathFromInterface implements MathInterface{

	@Override
	public int addition(int a, int b) {
		return a+b;
	}

	@Override
	public int subtraction(int a, int b) {
		return a-b;
	}

	@Override
	public int multiplication(int a, int b) {
		return a*b;
	}

	@Override
	public double division(int a, int b) {
		return a/b;
	}

}
