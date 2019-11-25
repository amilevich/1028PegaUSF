package com.Q13;

public class Q13 {
	
	 //Q13. Display the triangle on the console as follows using any type of loop.  Do NOT use a simple group of print statements to accomplish this.
	
	 static void printTriangle(int count)
	 {    
	     if (count == 0) return;
	     printTriangle(count - 1);
	     for (int x = 0; x <= count-1; x++) { 
	    	 if(x%2==0)
	    		 System.out.print("0"); 
	    	 else
	    		 System.out.print("1");
	     }
	     System.out.print("\n"); 
	 }
	public static void main(String[] args) {
		printTriangle(4);
		
	}
}
