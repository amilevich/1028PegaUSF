package firsthw;

public class quest15 implements maths{
public static void main(String[] args) {

	int a = 40;
	int b = 6;
	doit mat = new  doit();
	
	
	
	System.out.println("Addition: "+mat.addition(a, b));
	System.out.println("Subtraction: "+mat.subtraction(a, b));
	System.out.println("Multiplication: "+mat.multiplication(a, b));
	System.out.println("Division: "+mat.division(a, b));
	
}

@Override
public int addition(int a, int b) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int subtraction(int a, int b) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int multiplication(int a, int b) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public double division(int a, int b) {
	// TODO Auto-generated method stub
	return 0;
}
}

	class doit{
	
	public int addition(int a, int b) {
		return a+b;
	}

	
	public int subtraction(int a, int b) {
		return a-b;
	}

	public int multiplication(int a, int b) {
		return a*b;
	}

	
	public double division(int a, int b) {
		return a/b;
	}
	}

	
	

	
	
	

