package com.homework.Q5;

public class maluma {

		// program cuts off the string  based on the size
		static String subString(int index, String bunny){

	       
	        char[] subString = new char[index];

	      
	        for(int i=0; i<=index-1;i++)
	        {
	            // just storing the characters until a certain index
	            subString[i] = bunny.charAt(i);
	        }
	      
	        String booed = new String(subString);
	      
	        return booed;
	    }
		
		public static void main(String[] args) {
			String st = "UCF Knights football";
		    int index=7;
		    String sub = subString(index,st);
		   
		    System.out.println(sub);
		    
		}
		
	    
	
}
