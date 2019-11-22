package come.homework.qthree;

import java.util.Scanner;

public class Qthree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Input a String: ");
		String toBeReversed = sc.nextLine();
		for (int i = toBeReversed.length()-1; i >= 0; i--) {
			toBeReversed += toBeReversed.charAt(i);
		}
		System.out.println(toBeReversed.substring(toBeReversed.length() /2));
	}
}
