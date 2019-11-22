package davidvallejo.hw.javacore;

import java.io.FileReader;
import java.io.IOException;

/*
 * 
 * Question 20: Create a notepad file called data.txt and enter the following:
 * Mickey:Mouse:35:Arizona
 * Hulk:Hogan:50:Virginia
 * Roger:Rabbit:22:California
 * Wonder:Woman:18:Montana
 * Write a program that would read from the file and print it out to the screen in the
 * following format:
 * Name: Mickey Mouse
 * Age: 35 years
 * State: Arizona State
 * 
 */

public class Question20 {
	public static void main(String[] args) {
		

		String filename = "Data.txt";//question 20 pulling data from another file
		readCharacterStream(filename);
	}

	public static void readCharacterStream(String filename) {
		try (FileReader readObj = new FileReader(filename)) {
			int i;
			int j = 0;
			String theData = new String("");

			while ((i = readObj.read()) != -1) {
				Q20Data fileData = new Q20Data();
				while ((char) i != '\n' && i != -1) {
					theData = theData + ((char) i);
					i = readObj.read();//reading the data
					/*The data being read out to the user through logic*/
					if ((char) i == ':' && j == 0) { 
						j++;
					} else if ((char) i == ':' && j == 1) { 
						theData = theData.replace(':', ' ');
						fileData.setName(theData);
						theData = "";
						j++;
					} else if ((char) i == ':' && j == 2) { 
						theData = theData.substring(1, theData.length());
						fileData.setAge(Integer.valueOf(theData));
						theData = "";
						j = 0;
					} else if ((char) i == '\n' || i == -1) {
						theData = theData.substring(1, theData.length());
						fileData.setState(theData);
						theData = "";
					}
				}
				System.out.println(fileData);
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
