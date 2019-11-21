package src.Question18;
/*
 * Write a program having a concrete subclass that inherits three abstract methods from a superclass. 
 * Provide the following three implementations in the subclass corresponding to the abstract methods in the superclass: 

Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
Convert all of the lower case characters to uppercase in the input string, and return the result. 
Convert the input string to integer and add 10, output the result to the console.
Create an appropriate class having a main method to test the above setup.

 * 
 */

import java.util.Scanner;

public class AbstractMain extends MyClass{

    public AbstractMain(String myString) {
        super(myString);
    }

    public static void main(String[] args) {
        String input;
        MyClass userInput;
        Scanner one = new Scanner(System.in);
        System.out.println("Enter String: " );
        while (true) {
            try {
                input = one.nextLine();
                userInput = new MyClass(input);
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input, Please enter numeric value");
            }
        }

        boolean checkUpper = userInput.isUpperCase();
        if(checkUpper){
            System.out.println("1.)" + input + " Does have uppercase Letters");
        }else{
            System.out.println("1.)" +input+" Does NOT have uppercase Letters");
        }

        String toUpper = userInput.convertToUpper();
        System.out.println("2.)" + input + " -> Converted to UpperCase: " + toUpper);

        int addTen = userInput.convertToInt();
        System.out.println("3.)" + input + " + 10 = " + addTen);


    }

}
