package com.q18;

import java.util.Scanner;

public class MainDriver {
	public static void main(String[] args) {
		MyClass mc  = new MyClass();
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please provide a string to check for uppercase and to convert");
		
		String st = sc.nextLine();
		mc.checkUppercase(st);
		mc.convertUppercase(st);
		
		System.out.println("Please provide a number and will add 10 on that");
		
		String ss = sc.nextLine();
		System.out.println(mc.add(ss));
		

}
}