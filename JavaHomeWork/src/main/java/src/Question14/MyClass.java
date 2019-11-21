package src.Question14;
/*Write a program that demonstrates the switch case. Implement the following functionalities in the cases:
Case 1: Find the square root of a number using the Math class method. 
Case 2: Display today’s date.
Case 3: Split the following string and store it in a string array. 
		“I am learning Core Java”
 * 
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyClass {
	public static void main(String[] args) {

        //this is how you would pick the case
        int pick = 2;

        //variable for the square root
        int number = 144;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        //switch statement
        switch (pick) {
            case 1:
                System.out.println("Square Root of Number: "+number + " is: "+ Math.sqrt(number));
                break;
            case 2:
                System.out.println(dateFormat.format(date)); //2019/11/12 17:09:11 or whatever time it is at run time
                break;
            case 3: String myString = "I am learning Core Java";
                   String[] spString = myString.split("");
                printArray(spString);
        }
    }

    //print the array sequence
    static void printArray(String myArray[])
    {
        //get array length
        int n = myArray.length;
        //iterate through array and print it out
        for (int i=0; i<n; ++i) {
            System.out.print(myArray[i] + " ");
        }
        System.out.println();
    }
}
