package Q20;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q20Driver {

	//Create a notepad file called Data.txt and enter the following: 
	//Mickey:Mouse:35:Arizona
	//Hulk:Hogan:50:Virginia
	//Roger:Rabbit:22:California
	//Wonder:Woman:18:Montana

	//Write a program that would read from the file and print it out to the screen in the following format:

	//Name: Mickey Mouse
	//Age: 35 years
	//State: Arizona State

	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream inFile = new FileInputStream("Data.txt");
		Scanner input = new Scanner(inFile);
		Scanner tokens;
		String name, state;
		int age;
		
		//while there are more lines to read
		while(input.hasNextLine()) {
			tokens = new Scanner(input.nextLine());
			//separate tokens by ":" instead of " "
			tokens.useDelimiter(":");
			
			//read in tokens with 0 error checking
			name = tokens.next() + " " + tokens.next();
			age = Integer.valueOf(tokens.next());
			state = tokens.next();

			//beautiful print statement
			System.out.printf("Name: %s\nAge: %d years\nState: %s State\n\n", name, age, state);
		}
		
		input.close();
	}
}
