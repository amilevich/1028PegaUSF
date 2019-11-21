package src.Question15;

public class TestInterface {
	   
	public double addition(double one, double two) {
	        return one+two;
	    }

	    public double subtraction(double one, double two) {
	        return one - two;
	    }

	    public double multiplication(double one, double two) {
	        return one*two;
	    }

	    public double division(double one, double two) {
	        if(two == 0){
	            System.out.println("Cannot Divide by zero");
	        }else{
	            return one /two;
	        }
	        return 0;
	    }
}
