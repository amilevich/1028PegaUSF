package com.examples.corehomework;

import java.util.Scanner;

public class Q06Even { 
    
    static boolean isEven(int n) 
    { 
        boolean isEven = true; 
          
        for (int i = 1; i <= n; i++)  
            isEven = !isEven; 
              
        return isEven; 
    } 
       
    public static void main(String args[]) 
    { 
        Scanner sc = new Scanner(System.in);  
        System.out.println("Please enter a number");
        int n = sc.nextInt(); 
        if(isEven(n)) 
            System.out.println(n + " is even"); 
        else
            System.out.println(n + " is odd");  
    } 
} 