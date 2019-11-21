package Q18AbString;

import java.util.Scanner;

public class AbStringDriver {

	public static void main(String[] args) {
		
		ChildAbString obj = new ChildAbString();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a string to work with:");
		String input = sc.nextLine();
		
		if(obj.checkUpper(input)) {
			System.out.println("There are uppercase values in the string.");
		}else {
			System.out.println("There are no uppercase values in the string.");
		}
		
		String allUpper = obj.convertToUpper(input);
		System.out.println("The original string is: "+ input);
		System.out.println("The string with each character converted to uppercase is: "+allUpper);
		
		obj.convertIntPlusTen(input);
	}

}
