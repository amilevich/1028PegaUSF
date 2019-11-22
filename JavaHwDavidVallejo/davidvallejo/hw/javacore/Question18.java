package davidvallejo.hw.javacore;

import JavaPackage2.Question11.Question18_2;

/*
 * 
 * Question 18: Write a program having a concrete subclass that inherits three abstract
 * methods from a superclass. Provide the following three implementations in the
 * subclass corresponding to the abstract methods in the superclass:
 * 1. Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending
 * if any are found.
 * 
 * 2. Convert all of the lower case characters to uppercase in the input string, and
 * return the result.
 * 3. Convert the input string to integer and add 10, output the result to the console.
 * 
 * Create an appropriate class having a main method to test the above setup.
 * 
 */
public class Question18 extends Question18_2 {
	//1st
		public Boolean UpperC(String a) { //Converts new string to lowercase, compares original string to see if its the same.
				
				String y = a.toLowerCase();
				if(y.contentEquals(a)) {
					return false;
					
				}
				else {
						return true;
					}
		}
		
		//2nd
		public String convertToLowerCase(String a) { 
			
			String y = a.toUpperCase();
			return y;
			
		}
		//3rd
		public Integer changeString(String a) {
			int charNum = Integer.parseInt(a); //Get integer value of passed string using ParseInt, returns int.
			charNum +=10;
			return charNum;

		}



		public static void main(String[] args) {

			Question18 mainObject = new Question18();
			
			String test = "Example/Test";
			String number = "20";
			
			System.out.println("First:  "+ mainObject.UpperC(test));
			//first 
			System.out.println("Second:  "+mainObject.convertToLowerCase(test));
			//second
			System.out.println("Third: "+mainObject.changeString(number));
			//third

			
			
		}
// overriding the upperC method
		@Override
		public Object upperC(String x) {
			// TODO Auto-generated method stub
			return null;
		}

		

	
}
