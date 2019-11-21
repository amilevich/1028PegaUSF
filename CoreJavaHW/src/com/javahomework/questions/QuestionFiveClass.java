package com.javahomework.questions;

public class QuestionFiveClass {
	/*
	 * Write a substring method that accepts a string str 
	 * and an integer idx and returns the substring contained 
	 * between 0 and idx-1 inclusive.  Do NOT use any of the 
	 * existing substring methods in the String, StringBuilder, 
	 * or StringBuffer APIs.
	 * 
	 * */
	static String subString(int index, String st){

        //declare a substring that is the length of the index specified
        char[] subString = new char[index];

        //iterate till you hit the index
        for(int i=0; i<=index-1;i++)
        {
            //iterate through string and keep assigning until index -1
            subString[i] = st.charAt(i);
        }
        // the sub String character array needs to be converted to string
        String subStr = new String(subString);
        //return the substring
        return subStr;
    }
	
	public static void main(String[] args) {
		String st = "WE ARE THE CHAMPIONS, MY FRIENDS";
	    int index=9;
	    System.out.println("This is the original String: "+ "\n" + st);
	    String sub = subString(index,st);
	    System.out.println("After Substring method is applied between 0 and index " + index + " is: ");
	    System.out.println(sub);
	    
	}
	
    
}
