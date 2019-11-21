package com.javahomework.questions;

import java.util.ArrayList;

public class QuestionNineClass {
	// the task is to put numbers form 1 to 100 in an array list and then just add the ones that
	// prime  will be printed out
	public static void main(String[] args) {
		ArrayList<Integer>numArr = new ArrayList<Integer>();//<--------- array list where all the numbers will be stored
		//--------------------------------------------------------------------------------------------------------------------
		//this for loop adds the numbers from 1 to 100 to the list
		for(int i = 1; i <=100; i++) {
			numArr.add(i);
		}
		//-------------------------------------------------------------------------------------------------------------------
		for(Integer c : numArr) { //<------------- here i use an enhanced for loop to make sure the numbers are stored
			System.out.println(c);
		}
		//-------------------------------------------------------------------------------------------------------------------
		///this for loop i use to iterate the array list
		for (int i = 0; i<numArr.size(); i++){
            if (!isPrime(numArr.get(i))){ //<----------- here i am saying if they are not prime numbers 
                numArr.remove(numArr.get(i));//<--------then i will remove them from the list
                i--; //<--------------------------------here i am decrementing
            }
        }
		 System.out.println(numArr);//<----------------then here i print out the list of prime numbers
		
	}
	///////////////////////////////////////////////////////SECOND LAYER///////////////////////////////////////////////////////////////
	//this static method returns true if the number we take as argument is a prime
	//the purpose of this method is to check if a number is prime
	public static boolean isPrime(int x){
        boolean itIs = true;
        for (int i = 2; i < x; i++){
            if(x%i == 0){
                itIs = false;  
            }
        }
        return itIs;
    }
}
