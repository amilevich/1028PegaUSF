package homework1;

public class Factorial {
	
		 
		  public int  factorial(int n)
		  {
			 
		    // this line is to find factorial
		    return (n == 1 || n == 0) ? 1 : n * factorial(n - 1);
		  
		  }
		  
	}
		 


