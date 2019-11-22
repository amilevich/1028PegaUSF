package com.example.javacore;
/*
 *  Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
 */

public class QuestionOne {

	public static void main(String[] args) {
		// array of numbers 
        int arr[] ={1,0,5,6,3,2,3,7,9,8,4};  
        
        System.out.println("Numbers as given:");  
        for(int i = 0; i < arr.length; i++){  // iterating through the array elements 
                System.out.print(arr[i] + " ");  
        }  
        System.out.println();  
        bubbSort(arr);
        System.out.println();
        System.out.println("Numbers ordered using bubble sort");  
        for(int i = 0; i < arr.length; i++){  
                System.out.print(arr[i] + " ");  
        }  
}  
	
	 static void bubbSort(int[] array) {  
	        int numbers = array.length;  
	        int temp = 0;  
	         for(int i = 0; i < numbers; i++){  
	                 for(int c = 1; c < (numbers - i); c++){  
	                          if(array[c - 1] > array[c]){  
	                               
	                                 temp = array[c - 1];  
	                                 array[c - 1] = array[c];  
	                                 array[c] = temp; 
	                                 
	                         }// end if statement  
	                          
	                 }// end for loop  
	         }// end for loop  
	  
	    }//end bubbSort method   


}// end class
