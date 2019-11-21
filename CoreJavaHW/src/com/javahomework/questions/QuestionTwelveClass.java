package com.javahomework.questions;

public class QuestionTwelveClass {
	/*
	 * Write a program to store numbers from 1 to 100 in an array. 
	 * Print out all the even numbers from the array. Use the enhanced 
	 * FOR loop for printing out the numbers.
	 * */
	
	public static void main(String[] args) {
		int[] arr = new int[100]; //delcaring a integer array with size of 100
		for(int i = 1 ; i <arr.length; i++) { //looping the array and adding to the array
			arr[i]=i;
		}
		for(int v : arr) { // enhanced for loop to iterate through the array
			if(arr[v]%2==0) { //if element in array is divisible by 2 then it is even
				System.out.println(v);
			}
		}
		}
	}

