package davidvallejo.hw.javacore;
/*
 * 
 * Question 16: Write a program to display the number of characters for a string input. The string
 * should be entered as a command line argument using (String [ ] args).
 * 
 */
public class Question16 {
	public static void main(String[] args) {
		for (String userInput : args) { //ternary 
			System.out.println(userInput.length());
		}
	}
}
