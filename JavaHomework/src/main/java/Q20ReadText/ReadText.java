package Q20ReadText;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadText {

	/*
	 * Write a program that would read from the file and print it out to the screen in the following format:
	 * To:
	 * Name: Mickey Mouse
	 * Age: 35 years
	 * State: Arizona State
	 * 
	 * From:
	 * Mickey:Mouse:35:Arizona
	 * Hulk:Hogan:50:Virginia
	 * Roger:Rabbit:22:California
	 * Wonder:Woman:18:Montana
	 */
	
	public static void main(String[] args) {
		
	    File file =  new File("C:\\Users\\hellz\\Documents\\workspace-sts-3.9.9\\JavaHomework\\src\\main\\java\\Q20ReadText\\Data.txt");
	    Scanner sc;
	    String s=null;
	    String[] words = new String[4];
		try {
			sc = new Scanner(file);
		    while (sc.hasNextLine()) {
			    int last=0;
			    int wi = 0;
		    	s = sc.nextLine();
		    	for (int i = 0; i<s.length()-3; i++) { //there is no state shorter than 4 letters so reaching the end of the string is not needed
		    		if(s.charAt(i)==':') {
		    			//get the word using substring from last to i using wi
		    			words[wi]=s.substring(last, i);
		    			last=i+1;
		    			wi++;
		    		}	
		    	}
		    	words[3]=s.substring(last, s.length());
		    	System.out.print("\n\nName:\t"+words[0]+" "+words[1]+"\nAge:\t"+words[2]+" years\nState:\t"+words[3]);
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("\n\nexception caught");
		}

	}
}
