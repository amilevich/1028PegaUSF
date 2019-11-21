package Q14SwitchCase;

import java.util.Date;
import java.util.Scanner;

public class SwitchCase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		
		do {
			System.out.println("\n\n1. Square Root\n2. Today's Date\n3. Split String\n");
			System.out.println("Enter the number of the selection that you wish to use:");
			int selection =  sc.nextInt();
			sc.nextLine();
		
			switch(selection) {
			case 1:					//square root
				sqrt();
				break;
			case 2:					//today's date
				date();
				break;
			case 3:					//split string
				splitString();
				break;
			case 4:					//exit
				exit=true;
				break;
			default:
			
				break;
			}
		}while(!exit);
	}
	
	
	private static void splitString() {
		String input = "I am learning core java.";
		String stringArr[] = {"","","","",""};
		int arrCount = 0;
		
		System.out.println("\nThe original string was: "+input);
		
		for (int i = 0; i<input.length(); i++) {
			if(input.charAt(i)==' '){
				arrCount++;
			}else {
				stringArr[arrCount]+=input.charAt(i);
			}
		}
		
		System.out.println("\nThe split string is: ");
		for (int i = 0; i<5; i++) {
			System.out.println(stringArr[i]);
		}
		
	}

	private static void date() {
		Date date = new Date();
		System.out.println("The date is: "+ date +"\n");
	}

	public static void sqrt() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number you wish to find the square root of:");
		double num =  sc.nextInt();
		sc.nextLine();
		
		System.out.println("The square root of "+num+" is: "+Math.sqrt(num));
		
	}
}
