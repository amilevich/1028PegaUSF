package firsthw;

public class quest4 {
	
	static int factorial(int n) {
		 if(n==1) {
		 return 1;
		 } 
		 else { 
		 return(n*factorial(n-1));
		 }
	}
	
public static void main(String[] args) {
	
System.out.println(factorial(6));
	
}
}
