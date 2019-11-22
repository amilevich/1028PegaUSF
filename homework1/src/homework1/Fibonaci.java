package homework1;

public class Fibonaci {
	static void printFibonacciNumbers(int n) {
		int numb1 =0; 
		int numb2=1; 
		int i;
		if (n<1)
			return;
		for(i= 0; i<n; i++) {System.out.print(numb2+ " ");
		int next = numb1 +numb2;
		numb1 = numb2;
		numb2 = next;
		
		}
		
	

}
}


