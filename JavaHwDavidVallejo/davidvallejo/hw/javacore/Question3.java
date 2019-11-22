package davidvallejo.hw.javacore;
/*
 * 
 * Question 3: Reverse a string without using a temporary variable. Do NOT use reverse()
 * in the StringBuffer or the StringBuilder APIs.
 * 
 */
public class Question3 {
	public static void main(String[] args) {
		String reverseThisString = "desreveR"; //reverseThisString holds the value of the string we are reversing
		System.out.println(stringReversePrintMethod(reverseThisString));
		
		reverseThisString = "Reversed";
		System.out.println(stringReversePrintMethod(reverseThisString));
		
		reverseThisString = "sdrawkcab ydaerla si sihT";
		System.out.println(stringReversePrintMethod(reverseThisString));
		
		reverseThisString = "This is already backwards";
		System.out.println(stringReversePrintMethod(reverseThisString));
		
		reverseThisString = "racecar";
		System.out.println(stringReversePrintMethod(reverseThisString));
		
		reverseThisString = "TacoCat";
		System.out.println(stringReversePrintMethod(reverseThisString)); //the system runs the function and then prints out the product of the function 
	
	}
//using the charAt method of the CharSequence Interface takes
//charAt - returns a char at the specified index that then I use to print the string in reverse order
//String arrayOfCharacters is where I'm storing my string value
	
	/*
	 * The reversing function below that takes in a string and prints out a reversed string
	 */
	public static String stringReversePrintMethod(String arrayOfCharacters) {
		for (int f = arrayOfCharacters.length() - 1; f >= 0; f--) {
			arrayOfCharacters += arrayOfCharacters.charAt(f);
		}
	
		for (int f = 0; f < arrayOfCharacters.length(); f++) {
			arrayOfCharacters = arrayOfCharacters.substring(1);
		}
		return arrayOfCharacters;
	}
}
