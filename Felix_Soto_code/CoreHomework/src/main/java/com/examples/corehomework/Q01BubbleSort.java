package com.examples.corehomework;

public class Q01BubbleSort {

	 static void bubbleSort(int[] array) {  
	        int n = array.length;  
	        int temp = 0;  
	         for(int i=0; i < n; i++){  
	                 for(int a=1; a < (n-i); a++){  
	                          if(array[a-1] > array[a]){  
	                                 //swap the elements  
	                                 temp = array[a-1];  
	                                 array[a-1] = array[a];  
	                                 array[a] = temp;  
	                         }  
	                          
	                 }  
	         }  
	  
	    }  
	    public static void main(String[] args) {  
	                int arr[] ={1,0,5,6,3,2,3,7,9,8,4};  
	                 
	                System.out.println("this is the array before Bubble sort");  
	                for(int i=0; i < arr.length; i++){  
	                        System.out.print(arr[i] + " ");  
	                }  
	                System.out.println();  
	                  
	                bubbleSort(arr);
	                System.out.println("this is the array after Bubble sort");  
	                for(int i=0; i < arr.length; i++){  
	                        System.out.print(arr[i] + " ");  
	                }  
	        }  
	}  