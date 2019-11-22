package davidvallejo.hw.javacore;
/*
 * 
 * Question 6: Write a program to determine if an integer is even without using the modulus 
 * operator (%)
 * 
 */
public class Question6 {

	// Returns 0 if eoi 
    // is even, else odd 
    static int eoo(int eoi) //even or odd checking method
    { 
        //returns the integer 'eoi' and 1 so if the eoi & 1 = 1 then odd else even
        return (eoi & 1); 
    } 
       
    // Driver code 
    public static void main(String args[]) 
    { 
    	
    	for(int i=1;i<51;i++){ 
    		int eoi = 0 + i; 
        if(eoo(eoi)==0) {
        	System.out.print(eoi + " is Even \n"); }
        else {
        	System.out.print(eoi + " is Odd \n"); 
            }
    }
    } 
}
